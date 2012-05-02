/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.trait.MIDDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.part.MIDDiagramEditor;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTrait;

/**
 * The command to create a model container by importing an existing model.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelContainerImportModelCommand extends ModelContainerCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param req
	 *            The request.
	 */
	public ModelContainerImportModelCommand(CreateElementRequest req) {

		super(req);
	}

	/**
	 * Creates a new model container by importing a model.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result, or the error result if the model could not be
	 *         imported.
	 * @throws ExecutionException
	 *             If configuration command execution goes wrong.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			URI modelUri = MIDDiagramTrait.selectModelToImport(false);
			MappingReference owner = (MappingReference) getElementToEdit();
			ModelReference modelRef;

			MultiModelTrait.assertModelUnique(owner, modelUri); // model must not be already in the mapping
			if (owner.eContainer() == null) { // standalone mapping reference
				modelRef = MultiModelTrait.createModelReference(ModelReferenceOrigin.IMPORTED, null, modelUri);
			}
			else {
				modelRef = MultiModelTrait.getModelUnique((MultiModel) owner.eContainer(), modelUri); // model can be already in the MID
				if (modelRef == null) {
					modelRef = MultiModelTrait.createModelReference(ModelReferenceOrigin.IMPORTED, (MultiModel) owner.eContainer(), modelUri);
				}
			}
			ModelContainer newElement = MultiModelTrait.createMappingReferenceModelContainer(owner, modelRef);
			owner.getModels().add(modelRef);

			// update outline
			MIDDiagramEditor editor = (MIDDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			editor.getOutlinePage().addInput(modelUri);

			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);

			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model added", e);
			return CommandResult.newErrorCommandResult("No model added");
		}
	}

	/**
	 * Disallows the command to be executed when the diagram root is a binary
	 * mapping reference and is either not standalone or has already two models.
	 * 
	 * @return False if the command can't be executed, true otherwise.
	 */
	@Override
	public boolean canExecute() {

		MappingReference owner = (MappingReference) getElementToEdit();
		if (owner instanceof BinaryMappingReference) {
			// a binary mapping which is not standalone can be only modified through the MID
			// a binary mapping which is standalone must have at most 2 models
			if (owner.eContainer() != null || owner.getModels().size() >= 2) {
				return false;
			}
		}
		return super.canExecute();
	}

}