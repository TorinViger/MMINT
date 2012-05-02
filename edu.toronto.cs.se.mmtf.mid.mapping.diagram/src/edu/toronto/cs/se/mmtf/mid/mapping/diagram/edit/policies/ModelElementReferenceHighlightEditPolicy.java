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
package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.policies;

import org.eclipse.gef.editpolicies.NonResizableEditPolicy;

/**
 * The highlight edit policy (a drag policy) for model element references.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelElementReferenceHighlightEditPolicy extends NonResizableEditPolicy {

	/**
	 * Disallow dragging, so that the model element reference is just
	 * highlighted.
	 * 
	 * @return False.
	 */
	public boolean isDragAllowed() {

		return false;
	}

}