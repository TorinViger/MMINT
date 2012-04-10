/**
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
package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceDelModelCommand;

/**
 * The semantic edit policy for mapping references' models.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MappingReferenceModelsSemanticEditPolicy extends MappingReferenceModelsItemSemanticEditPolicy {

	/**
	 * Gets the command to destroy a model reference of a mapping reference.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {

		return getGEFWrapper(new MappingReferenceDelModelCommand(req));
	}

}
