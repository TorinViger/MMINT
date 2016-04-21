/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.statemachine_mavo;

import edu.toronto.cs.se.mavo.MAVOElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Firing Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine_mavo.FiringElement#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine_mavo.FiringElement#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage#getFiringElement()
 * @model abstract="true"
 * @generated
 */
public interface FiringElement extends MAVOElement {
	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' attribute.
	 * @see #setTrigger(String)
	 * @see edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage#getFiringElement_Trigger()
	 * @model
	 * @generated
	 */
	String getTrigger();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.statemachine_mavo.FiringElement#getTrigger <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' attribute.
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(String value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see #setAction(String)
	 * @see edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage#getFiringElement_Action()
	 * @model
	 * @generated
	 */
	String getAction();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.statemachine_mavo.FiringElement#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(String value);

} // FiringElement
