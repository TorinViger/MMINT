/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mavo;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Var decision to be made within a MAVO model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mavo.VarDecision#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mavo.MAVOPackage#getVarDecision()
 * @model
 * @generated
 */
public interface VarDecision extends MAVODecision {
	/**
	 * Returns the value of the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The merge domain for this decision.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain</em>' containment reference.
	 * @see #setDomain(MAVOCollection)
	 * @see edu.toronto.cs.se.mavo.MAVOPackage#getVarDecision_Domain()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MAVOCollection getDomain();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.mavo.VarDecision#getDomain <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' containment reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(MAVOCollection value);

} // VarDecision
