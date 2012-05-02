/**
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
package edu.toronto.cs.se.mmtf.mid.trait;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.mapping.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.mapping.Link;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElement;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelRel;

/**
 * A container for common functions of a mid/mapping model.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTrait {

	/**
	 * Adds a model to a multimodel.
	 * 
	 * @param model
	 *            The model to add.
	 * @param origin
	 *            The origin of the model.
	 * @param multiModel
	 *            The root multimodel (possibly null).
	 * @param modelUri
	 *            The uri of the model to add (possibly null).
	 * @throws Exception
	 *             If the resource pointed by the model uri could not be get.
	 */
	private static void addModel(Model model, ModelOrigin origin, MultiModel multiModel, URI modelUri) throws Exception {

		// possibly raise exceptions as first thing
		EObject root;
		if (modelUri == null) { // model relationship
			root = model;
		}
		else { // model or standalone model relationship
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(modelUri, true);
			root = resource.getContents().get(0);
			String fileName = modelUri.lastSegment();
			model.setName(fileName.substring(0, fileName.lastIndexOf('.')));
			model.setFileExtension(modelUri.fileExtension());
		}

		// add to multimodel container
		if (multiModel != null) {
			multiModel.getModels().put(modelUri.toPlatformString(true), model);
		}
		// set basic attributes
		if (modelUri == null) {
			modelUri = EcoreUtil.getURI(model);
			//TODO MMTF: occhio devo rendere l'uri univoco qui
		}
		//TODO MMTF: setType: prendo uri dal root, ma le relationships?
		//TODO MMTF: model.setType(MMTFRegistry.getModelType(modelTypeUri));
		model.setLevel(MidLevel.INSTANCES);
		model.setRoot(root);
		model.setUri(modelUri.toPlatformString(true));
		model.setOrigin(origin);
		model.setSupertype(null);
	}

	/**
	 * Creates and adds a model to a multimodel.
	 * 
	 * @param origin
	 *            The origin of the model.
	 * @param multiModel
	 *            The root multimodel, null if the root is a relationship.
	 * @param modelUri
	 *            The uri of the model to add.
	 * @return The model just created.
	 * @throws Exception
	 *             If the resource pointed by the model uri could not be get.
	 */
	public static Model createModel(ModelOrigin origin, MultiModel multiModel, URI modelUri) throws Exception {

		Model model = MidFactory.eINSTANCE.createModel();
		addModel(model, origin, multiModel, modelUri);

		return model;
	}

	/**
	 * Creates and adds a model relationship to a multimodel.
	 * 
	 * @param origin
	 *            The origin of the model relationships.
	 * @param multiModel
	 *            The root multimodel.
	 * @param modelRelUri
	 *            The uri of the model relationship to add, null if not
	 *            imported.
	 * @param modelRelType
	 *            The specific model relationship class type.
	 * @return The model relationship just created.
	 * @throws Exception
	 *             If the resource pointed by the model relationship uri could
	 *             not be get.
	 */
	public static ModelRel createModelRel(ModelOrigin origin, MultiModel multiModel, URI modelRelUri, EClass modelRelType) throws Exception {

		ModelRel modelRel = (ModelRel) MappingFactory.eINSTANCE.create(modelRelType);
		addModel(modelRel, origin, multiModel, modelRelUri);

		return modelRel;
	}

	/**
	 * Creates and adds a model container to a model relationship.
	 * 
	 * @param modelRel
	 *            The model relationship.
	 * @param model
	 *            The model that corresponds to the model container.
	 * @return The model container just created.
	 */
	public static ModelContainer createModelRelContainer(ModelRel modelRel, Model model) {

		ModelContainer container = MappingFactory.eINSTANCE.createModelContainer();
		if (modelRel.eContainer() == null) { // standalone model relationship
			container.setContainedModel(model);
		}
		else {
			container.setReferencedModel(model);
		}
		modelRel.getContainers().add(container);

		return container;
	}

	/**
	 * Creates and adds a model element to a model container.
	 * 
	 * @param container
	 *            The model container
	 * @param elementPointer
	 *            The pointer to the real model element.
	 * @return The model element just created.
	 */
	public static ModelElement createModelElement(ModelContainer container, EObject elementPointer) {

		ModelElement element = MappingFactory.eINSTANCE.createModelElement();
		if (elementPointer instanceof EReference) {
			element.setCategory(ModelElementCategory.RELATIONSHIP);
		}
		else {
			element.setCategory(ModelElementCategory.ENTITY);
		}
		element.setPointer(elementPointer);
		element.setLevel(container.getModel().getLevel());
		//TODO MMTF: who pass/lookup the element type?

		ItemProviderAdapter itemAdapter = null;
		for (Adapter adapter : elementPointer.eAdapters()) {
			if (adapter instanceof ItemProviderAdapter) {
				itemAdapter = (ItemProviderAdapter) adapter;
				break;
			}
		}
		String name = (itemAdapter == null) ? "" : itemAdapter.getText(elementPointer);
		element.setName(name);

		container.getElements().add(element);

		return element;
	}

	/**
	 * Creates and adds a copy of a model relationship to a multimodel.
	 * 
	 * @param multiModel
	 *            The root multimodel.
	 * @param modelRelUri
	 *            The uri of the original model relationship.
	 * @return The model relationship just created.
	 * @throws Exception
	 *             If the resources pointed by the various uris could not be
	 *             get.
	 */
	public static ModelRel copyModelRel(MultiModel multiModel, URI modelRelUri) throws Exception {

		// this duplicate code is needed to infer the model relationship class
		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(modelRelUri, true);
		EObject root = resource.getContents().get(0);
		ModelRel modelRel = createModelRel(
			ModelOrigin.IMPORTED,
			multiModel,
			modelRelUri,
			root.eClass()
		);

		// copy mapping structure
		ModelRel origModelRel = (ModelRel) modelRel.getRoot();
		HashMap<EObject, ModelElement> elements = new HashMap<EObject, ModelElement>();
		for (ModelContainer origContainer : origModelRel.getContainers()) {
			URI modelUri = URI.createPlatformResourceURI(origContainer.getContainedModel().getUri(), true);
			Model model = getModelUnique(multiModel, modelUri); // the model can already be in the MID
			if (model == null) {
				model = createModel(ModelOrigin.IMPORTED, multiModel, modelUri);
			}
			modelRel.getModels().add(model);
			ModelContainer container = createModelRelContainer(modelRel, model);
			for (ModelElement origElement : origContainer.getElements()) {
				ModelElement element = createModelElement(container, origElement.getPointer());
				element.setName(origElement.getName());
				elements.put(element.getPointer(), element);
			}
		}
		for (Link origLink : origModelRel.getLinks()) {
			Link link = (Link) MappingFactory.eINSTANCE.create(origLink.eClass());
			link.setName(origLink.getName());
			modelRel.getLinks().add(link);
			for (ModelElement origElement : origLink.getElements()) {
				link.getElements().add(elements.get(origElement.getPointer()));
			}
		}

		return modelRel;
	}

	/**
	 * Removes a model container from a model relationship following the removal
	 * of a model.
	 * 
	 * @param modelRel
	 *            The model relationship.
	 * @param model
	 *            The model to be removed.
	 */
	public static void removeModelRelContainer(ModelRel modelRel, Model model) {

		for (ModelContainer container : modelRel.getContainers()) {
			if (container.getModel() == model) {
				modelRel.getContainers().remove(container);
				ArrayList<Link> delLinks = new ArrayList<Link>();
				for (ModelElement element : container.getElements()) {
					for (Link link : element.getLinks()) {
						// binary links have no longer sense, delete them later to avoid concurrent modification problems
						if (link instanceof BinaryLink) {
							delLinks.add(link);
						}
					}
					element.getLinks().clear();
				}
				for (Link delLink : delLinks) {
					delLink.getElements().clear();
					modelRel.getLinks().remove(delLink);
				}
				break;
			}
		}
	}

	/**
	 * Checks the uniqueness of a model to be imported in a MID.
	 * 
	 * @param multiModel
	 *            The root multimodel.
	 * @param modelUri
	 *            The uri of the model to be imported.
	 * @return Null if the model is unique, the model already in the MID
	 *         otherwise.
	 */
	public static Model getModelUnique(MultiModel multiModel, URI modelUri) {

		return multiModel.getModels().get(modelUri.toPlatformString(true));
	}

	/**
	 * Checks the uniqueness of a model to be imported in a Mapping diagram.
	 * 
	 * @param modelRel
	 *            The root model relationship.
	 * @param modelUri
	 *            The uri of the model to be imported.
	 * @return Null if the model is unique, the model already in the MID
	 *         otherwise.
	 */
	public static Model getModelUnique(ModelRel modelRel, URI modelUri) {

		for (Model model : modelRel.getModels()) {
			if (modelUri.equals(model.getUri())) {
				return model;
			}
		}

		return null;
	}

	/**
	 * Checks the uniqueness of a model to be imported in a MID.
	 * 
	 * @param multiModel
	 *            The root multimodel.
	 * @param modelUri
	 *            The uri of the model to be imported.
	 * @return True if the model is unique.
	 * @throws MMTFException
	 *             If the model is not unique.
	 */
	public static boolean assertModelUnique(MultiModel multiModel, URI modelUri) throws MMTFException {

		if (getModelUnique(multiModel, modelUri) != null) {
			throw new MMTFException("Imported model " + modelUri + " is already in the diagram");
		}

		return true;
	}

	/**
	 * Checks the uniqueness of a model to be imported in a Mapping diagram.
	 * 
	 * @param modelRel
	 *            The root model relationship.
	 * @param modelUri
	 *            The uri of the model to be imported.
	 * @return True if the model is unique.
	 * @throws MMTFException
	 *             If the model is not unique.
	 */
	public static boolean assertModelUnique(ModelRel modelRel, URI modelUri) throws MMTFException {

		if (getModelUnique(modelRel, modelUri) != null) {
			throw new MMTFException("Imported model " + modelUri + " is already in the diagram");
		}

		return true;
	}

}