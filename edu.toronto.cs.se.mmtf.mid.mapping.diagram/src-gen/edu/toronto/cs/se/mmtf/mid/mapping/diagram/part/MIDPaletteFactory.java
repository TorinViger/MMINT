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
package edu.toronto.cs.se.mmtf.mid.mapping.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import edu.toronto.cs.se.mmtf.mid.mapping.diagram.providers.MIDElementTypes;

/**
 * @generated
 */
public class MIDPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createModels1Group());
		paletteRoot.add(createMappings2Group());
	}

	/**
	 * Creates "Models" palette tool group
	 * @generated
	 */
	private PaletteContainer createModels1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Models1Group_title);
		paletteContainer.setId("createModels1Group"); //$NON-NLS-1$
		paletteContainer.add(createImportmodel1CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Mappings" palette tool group
	 * @generated
	 */
	private PaletteContainer createMappings2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Mappings2Group_title);
		paletteContainer.setId("createMappings2Group"); //$NON-NLS-1$
		paletteContainer.add(createNewbinarymappinglink1CreationTool());
		paletteContainer.add(createNewNarymappinglink2CreationTool());
		paletteContainer.add(createNewNarymappinglinkelement3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImportmodel1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Importmodel1CreationTool_title,
				Messages.Importmodel1CreationTool_desc,
				Collections.singletonList(MIDElementTypes.ModelContainer_2005));
		entry.setId("createImportmodel1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.ModelContainer_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewbinarymappinglink1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Newbinarymappinglink1CreationTool_title,
				Messages.Newbinarymappinglink1CreationTool_desc,
				Collections
						.singletonList(MIDElementTypes.BinaryMappingLink_4005));
		entry.setId("createNewbinarymappinglink1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.BinaryMappingLink_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewNarymappinglink2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.NewNarymappinglink2CreationTool_title,
				Messages.NewNarymappinglink2CreationTool_desc,
				Collections.singletonList(MIDElementTypes.MappingLink_2006));
		entry.setId("createNewNarymappinglink2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.MappingLink_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNewNarymappinglinkelement3CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.NewNarymappinglinkelement3CreationTool_title,
				Messages.NewNarymappinglinkelement3CreationTool_desc,
				Collections
						.singletonList(MIDElementTypes.MappingLinkElements_4004));
		entry.setId("createNewNarymappinglinkelement3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(MIDElementTypes
				.getImageDescriptor(MIDElementTypes.MappingLinkElements_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}