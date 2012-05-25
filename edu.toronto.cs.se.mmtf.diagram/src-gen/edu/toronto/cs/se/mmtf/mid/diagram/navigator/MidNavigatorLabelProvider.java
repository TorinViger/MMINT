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
package edu.toronto.cs.se.mmtf.mid.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelNameType2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelParameter2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelParameterEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelParameterName2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelParameterNameEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelModelsEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelNameType2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.OperatorEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.OperatorNameEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MidDiagramEditorPlugin;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MidElementTypes;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MidParserProvider;

/**
 * @generated
 */
public class MidNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		MidDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		MidDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof MidNavigatorItem
				&& !isOwnView(((MidNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof MidNavigatorGroup) {
			MidNavigatorGroup group = (MidNavigatorGroup) element;
			return MidDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof MidNavigatorItem) {
			MidNavigatorItem navigatorItem = (MidNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case ExtendibleElementSupertypeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///edu/toronto/cs/se/mmtf/model/mid.ecore?ExtendibleElement?supertype", MidElementTypes.ExtendibleElementSupertype_4001); //$NON-NLS-1$
		case OperatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///edu/toronto/cs/se/mmtf/model/mid.ecore/operator?Operator", MidElementTypes.Operator_2005); //$NON-NLS-1$
		case Model2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///edu/toronto/cs/se/mmtf/model/mid.ecore?Model", MidElementTypes.Model_2002); //$NON-NLS-1$
		case ModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///edu/toronto/cs/se/mmtf/model/mid.ecore?Model", MidElementTypes.Model_2001); //$NON-NLS-1$
		case ModelRel2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///edu/toronto/cs/se/mmtf/model/mid.ecore/relationship?ModelRel", MidElementTypes.ModelRel_2004); //$NON-NLS-1$
		case ModelParameter2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///edu/toronto/cs/se/mmtf/model/mid.ecore/operator?ModelParameter", MidElementTypes.ModelParameter_4005); //$NON-NLS-1$
		case MultiModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http:///edu/toronto/cs/se/mmtf/model/mid.ecore?MultiModel", MidElementTypes.MultiModel_1000); //$NON-NLS-1$
		case ModelParameterEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///edu/toronto/cs/se/mmtf/model/mid.ecore/operator?ModelParameter", MidElementTypes.ModelParameter_4004); //$NON-NLS-1$
		case BinaryModelRelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///edu/toronto/cs/se/mmtf/model/mid.ecore/relationship?BinaryModelRel", MidElementTypes.BinaryModelRel_4003); //$NON-NLS-1$
		case ModelRelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///edu/toronto/cs/se/mmtf/model/mid.ecore/relationship?ModelRel", MidElementTypes.ModelRel_2003); //$NON-NLS-1$
		case ModelRelModelsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///edu/toronto/cs/se/mmtf/model/mid.ecore/relationship?ModelRel?models", MidElementTypes.ModelRelModels_4002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = MidDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& MidElementTypes.isKnownElementType(elementType)) {
			image = MidElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof MidNavigatorGroup) {
			MidNavigatorGroup group = (MidNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof MidNavigatorItem) {
			MidNavigatorItem navigatorItem = (MidNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case ExtendibleElementSupertypeEditPart.VISUAL_ID:
			return getExtendibleElementSupertype_4001Text(view);
		case OperatorEditPart.VISUAL_ID:
			return getOperator_2005Text(view);
		case Model2EditPart.VISUAL_ID:
			return getModel_2002Text(view);
		case ModelEditPart.VISUAL_ID:
			return getModel_2001Text(view);
		case ModelRel2EditPart.VISUAL_ID:
			return getModelRel_2004Text(view);
		case ModelParameter2EditPart.VISUAL_ID:
			return getModelParameter_4005Text(view);
		case MultiModelEditPart.VISUAL_ID:
			return getMultiModel_1000Text(view);
		case ModelParameterEditPart.VISUAL_ID:
			return getModelParameter_4004Text(view);
		case BinaryModelRelEditPart.VISUAL_ID:
			return getBinaryModelRel_4003Text(view);
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_2003Text(view);
		case ModelRelModelsEditPart.VISUAL_ID:
			return getModelRelModels_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getModelParameter_4005Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.ModelParameter_4005,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry
						.getType(ModelParameterName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModel_2001Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.Model_2001,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(ModelNameTypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelRelModels_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOperator_2005Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.Operator_2005,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(OperatorNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelRel_2003Text(View view) {
		IParser parser = MidParserProvider
				.getParser(MidElementTypes.ModelRel_2003,
						view.getElement() != null ? view.getElement() : view,
						MidVisualIDRegistry
								.getType(ModelRelNameTypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModel_2002Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.Model_2002,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry.getType(ModelNameType2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelParameter_4004Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.ModelParameter_4004,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry
						.getType(ModelParameterNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getModelRel_2004Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.ModelRel_2004,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry
						.getType(ModelRelNameType2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getExtendibleElementSupertype_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMultiModel_1000Text(View view) {
		MultiModel domainModelElement = (MultiModel) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getLevel());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBinaryModelRel_4003Text(View view) {
		IParser parser = MidParserProvider.getParser(
				MidElementTypes.BinaryModelRel_4003,
				view.getElement() != null ? view.getElement() : view,
				MidVisualIDRegistry
						.getType(BinaryModelRelNameTypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			MidDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return MultiModelEditPart.MODEL_ID.equals(MidVisualIDRegistry
				.getModelID(view));
	}

}