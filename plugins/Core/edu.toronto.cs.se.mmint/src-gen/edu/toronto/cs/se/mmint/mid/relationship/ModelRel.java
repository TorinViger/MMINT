/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Rel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A model relationship type among model types or a model relationship instance among model instances.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getModelEndpoints <em>Model Endpoints</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getMappings <em>Mappings</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getModelEndpointRefs <em>Model Endpoint Refs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.ModelRel#getMappingRefs <em>Mapping Refs</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelRel()
 * @model
 * @generated
 */
public interface ModelRel extends Model {
	/**
	 * Returns the value of the '<em><b>Model Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.ModelEndpoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of model endpoints.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Endpoints</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelRel_ModelEndpoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelEndpoint> getModelEndpoints();

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.relationship.Mapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of mappings among model elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelRel_Mappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<Mapping> getMappings();

	/**
	 * Returns the value of the '<em><b>Model Endpoint Refs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of references to model endpoints. This is different from the list of model endpoints because it includes inherited endpoints too.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Endpoint Refs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelRel_ModelEndpointRefs()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelEndpointReference> getModelEndpointRefs();

	/**
	 * Returns the value of the '<em><b>Mapping Refs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.mmint.mid.relationship.MappingReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of references to mappings. This is different from the list of mappings because it includes inherited mappings too.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mapping Refs</em>' containment reference list.
	 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#getModelRel_MappingRefs()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingReference> getMappingRefs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model relationship type of this model relationship instance.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement metatype = super.getMetatype();\nreturn (metatype == null) ? null : (ModelRel) metatype;'"
	 * @generated
	 */
	ModelRel getMetatype();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * {@inheritDoc}<br />
	 * Gets the model relationship supertype of this model relationship type.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ExtendibleElement supertype = super.getSupertype();\nreturn (supertype == null) ? null : (Model) supertype;'"
	 * @generated
	 */
	Model getSupertype();

	/**
	 * <!-- begin-user-doc --> Creates and adds a binary subtype of this model relationship type to the Type MID.
	 * 
	 * @param newModelRelTypeName
	 *            The name of the new model relationship type.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the new model relationship type, null if no
	 *            constraint is associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated with the new model relationship type, null
	 *            if no constraint is associated.
	 * @param isMetamodelExtension
	 *            Not used.
	 * @return The created binary model relationship type.
	 * @throws MMINTException
	 *             If this is a model relationship instance, or if the uri of the new model relationship type is already
	 *             registered in the Type MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" newModelRelTypeNameRequired="true" isMetamodelExtensionRequired="true"
	 * @generated
	 */
	BinaryModelRel createBinarySubtype(String newModelRelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a subtype of this model
	 * relationship type to the Type MID, copying its structure from another
	 * model relationship type.
	 * 
	 * @param origModelRelType
	 *            The original model relationship type to be copied into the new
	 *            one.
	 * @return The created model relationship type.
	 * @throws MMINTException
	 *             If this is a model relationship instance, or if any of the
	 *             uris of the components of the new model relationship type are
	 *             already registered in the Type MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" origModelRelTypeRequired="true"
	 * @generated
	 */
	ModelRel copySubtype(ModelRel origModelRelType) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Deletes this model relationship type from the
	 * Type MID.
	 * 
	 * @throws MMINTException
	 *             If this is a model relationship instance.
	 * <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteType() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Gets the model type resources to be used in the
	 * Relationship diagram outline for this model relationship type.
	 * 
	 * @throws MMINTException
	 *             If this is a model relationship instance.
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	ResourceSet getOutlineResourceTypes() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a model relationship instance of this model relationship type to an
	 * Instance MID, together with its model instance endpoints and references to them.
	 * 
	 * @param newModelRelUri
	 *            The uri of the new model relationship, null if the new model relationship is not in a separate file;
	 *            e.g. a standalone model relationship is in its own files, a plain model relationship is not.
	 * @param endpointModels
	 *            The endpoint models.
	 * @param instanceMID
	 *            An Instance MID, null if the model relationship isn't going to be added to it.
	 * @return The created model relationship.
	 * @throws MMINTException
	 *             If this is a model relationship instance, if no endpoint models are specified, or if the uri of the
	 *             new model relationship is already registered in the Instance MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" endpointModelsRequired="true" endpointModelsMany="true"
	 * @generated
	 */
	ModelRel createInstanceAndEndpointsAndReferences(String newModelRelUri, EList<Model> endpointModels, MID instanceMID) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and possibly adds a binary model relationship instance of this model relationship
	 * type to an Instance MID.
	 * 
	 * @param newModelRelUri
	 *            The uri of the new model relationship, null if the new model relationship is not in a separate file;
	 *            e.g. a standalone model relationship is in its own files, a plain model relationship is not.
	 * @param instanceMID
	 *            An Instance MID, null if the model relationship isn't going to be added to it.
	 * @return The created binary model relationship.
	 * @throws MMINTException
	 *             If this is a model relationship instance, or if the uri of the new model relationship is already
	 *             registered in the Instance MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	BinaryModelRel createBinaryInstance(String newModelRelUri, MID instanceMID) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Creates and adds a binary model relationship instance of this model relationship type to
	 * an Instance MID, together with its model instance endpoints and references to them.
	 * 
	 * @param newModelRelUri
	 *            The uri of the new model relationship, null if the new model relationship is not in a separate file;
	 *            e.g. a standalone model relationship is in its own files, a plain model relationship is not.
	 * @param endpointSourceModel
	 *            The source endpoint model.
	 * @param endpointTargetModel
	 *            The target endpoint model.
	 * @param instanceMID
	 *            An Instance MID, null if the model relationship isn't going to be added to it.
	 * @return The created binary model relationship.
	 * @throws MMINTException
	 *             If this is a model relationship instance, or if the uri of the new model relationship is already
	 *             registered in the Instance MID. <!-- end-user-doc -->
	 * @model required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException" endpointSourceModelRequired="true" endpointTargetModelRequired="true"
	 * @generated
	 */
	BinaryModelRel createBinaryInstanceAndEndpointsAndReferences(String newModelRelUri, Model endpointSourceModel, Model endpointTargetModel, MID instanceMID) throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Deletes this model relationship instance from the
	 * Instance MID that contains it.
	 * 
	 * @throws MMINTException
	 *             If this is a model relationship type. <!-- end-user-doc -->
	 * @model exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	void deleteInstance() throws MMINTException;

	/**
	 * <!-- begin-user-doc --> Gets the model instance resources to be used in
	 * the Relationship diagram outline for this model relationship instance.
	 * 
	 * @throws MMINTException
	 *             If this is a model relationship type. <!-- end-user-doc -->
	 * @model kind="operation" required="true" exceptions="edu.toronto.cs.se.mmint.mid.MMINTException"
	 * @generated
	 */
	ResourceSet getOutlineResourceInstances() throws MMINTException;

} // ModelRel
