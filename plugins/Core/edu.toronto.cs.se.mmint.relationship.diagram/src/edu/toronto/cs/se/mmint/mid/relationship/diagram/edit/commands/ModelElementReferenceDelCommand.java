/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;

/**
 * The command to delete a model element reference.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelElementReferenceDelCommand extends DestroyElementCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public ModelElementReferenceDelCommand(DestroyElementRequest request) {

		super(request);
	}

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doUndo(monitor, info);
		MultiModel multiModel = MultiModelRegistry.getMultiModel((ModelEndpointReference) getElementToEdit());
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMINT.createTypeHierarchy(multiModel);
		}

		return status;
    }

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doRedo(monitor, info);
		MultiModel multiModel = MultiModelRegistry.getMultiModel((ModelEndpointReference) getElementToEdit());
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMINT.createTypeHierarchy(multiModel);
		}

		return status;
    }

	@Override
	public boolean canExecute() {

		return super.canExecute();
	}

	protected void doExecuteInstancesLevel(IProgressMonitor monitor, IAdaptable info) throws MMINTException {

		((ModelElementReference) getElementToDestroy()).deleteInstanceReference();
	}

	protected void doExecuteTypesLevel(IProgressMonitor monitor, IAdaptable info) throws MMINTException {

		((ModelElementReference) getElementToDestroy()).deleteTypeReference();
		MMINT.createTypeHierarchy(MultiModelRegistry.getMultiModel((ModelEndpointReference) getElementToEdit()));
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			if (MultiModelConstraintChecker.isInstancesLevel((ModelEndpointReference) getElementToEdit())) {
				doExecuteInstancesLevel(monitor, info);
			}
			else {
				doExecuteTypesLevel(monitor, info);
			}

			return super.doExecuteWithResult(monitor, info);
		}
		catch (MMINTException e) {
			MMINTException.print(Type.ERROR, "No model element deleted", e);
			return CommandResult.newErrorCommandResult("No model element deleted");
		}
	}

}