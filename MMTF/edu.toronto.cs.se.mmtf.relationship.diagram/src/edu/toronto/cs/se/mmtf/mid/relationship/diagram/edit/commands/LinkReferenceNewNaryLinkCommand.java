/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelLightTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.trait.RelationshipDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;

/**
 * The command to create a link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class LinkReferenceNewNaryLinkCommand extends LinkReferenceCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param req
	 *            The request.
	 */
	public LinkReferenceNewNaryLinkCommand(CreateElementRequest req) {

		super(req);
	}

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doUndo(monitor, info);
		MultiModel multiModel = (MultiModel) getElementToEdit().eContainer();
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMTF.initTypeHierarchy(multiModel);
		}

		return status;
    }

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doRedo(monitor, info);
		MultiModel multiModel = (MultiModel) getElementToEdit().eContainer();
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMTF.initTypeHierarchy(multiModel);
		}

		return status;
    }

	/**
	 * Checks if a link can be created.
	 * 
	 * @return True if a link can be created, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return
			super.canExecute() && (
				MultiModelConstraintChecker.isInstancesLevel((ModelRel) getElementToEdit()) ||
				!MultiModelConstraintChecker.isRootType((ModelRel) getElementToEdit())
			);
	}

	protected LinkReference doExecuteInstancesLevel() throws MMTFException {

		ModelRel modelRel = (ModelRel) getElementToEdit();
		LinkReference linkTypeRef = RelationshipDiagramTrait.selectLinkTypeReferenceToCreate(modelRel, null, null);
		LinkReference newLinkRef = MultiModelInstanceFactory.createLinkAndLinkReference(
			linkTypeRef.getObject(),
			modelRel,
			RelationshipPackage.eINSTANCE.getLink(),
			RelationshipPackage.eINSTANCE.getLinkReference()
		);

		return newLinkRef;
	}

	protected LinkReference doExecuteTypesLevel() throws MMTFException {

		ModelRel modelRelType = (ModelRel) getElementToEdit();
		LinkReference linkTypeRef = RelationshipDiagramTrait.selectLinkTypeReferenceToExtend(modelRelType, null, null);
		Link linkType = linkTypeRef.getObject();
		if (MultiModelTypeRegistry.getRootTypeUri(linkType).equals(linkType.getUri())) {
			linkTypeRef = null; // the link reference to the root is never shown
		}
		String newLinkTypeName = RelationshipDiagramTrait.getStringInput("Create new light link type", "Insert new link type name");
		LinkReference newLinkTypeRef = MultiModelLightTypeFactory.createLightLinkTypeAndLinkTypeReference(
			modelRelType,
			linkType,
			linkTypeRef,
			newLinkTypeName,
			RelationshipPackage.eINSTANCE.getLink(),
			RelationshipPackage.eINSTANCE.getLinkReference()
		);
		MMTF.initTypeHierarchy((MultiModel) modelRelType.eContainer());

		return newLinkTypeRef;
	}

	/**
	 * Creates a new link.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result.
	 * @throws ExecutionException
	 *             If configuration command execution goes wrong.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			LinkReference newElement = (MultiModelConstraintChecker.isInstancesLevel((ModelRel) getElementToEdit())) ?
				doExecuteInstancesLevel() :
				doExecuteTypesLevel();
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);
	
			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No link created", e);
			return CommandResult.newErrorCommandResult("No link created");
		}
	}

}