/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar_mavo;

import edu.toronto.cs.se.mmtf.mavo.MAVOElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint#getDependenciesAsDepender <em>Dependencies As Depender</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint#getDependenciesAsDependee <em>Dependencies As Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getDependencyEndpoint()
 * @model abstract="true"
 * @generated
 */
public interface DependencyEndpoint extends MAVOElement {
	/**
	 * Returns the value of the '<em><b>Dependencies As Depender</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies As Depender</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies As Depender</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getDependencyEndpoint_DependenciesAsDepender()
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference#getTgt
	 * @model opposite="tgt"
	 * @generated
	 */
	EList<DependerReference> getDependenciesAsDepender();

	/**
	 * Returns the value of the '<em><b>Dependencies As Dependee</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies As Dependee</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies As Dependee</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getDependencyEndpoint_DependenciesAsDependee()
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference#getTgt
	 * @model opposite="tgt"
	 * @generated
	 */
	EList<DependeeReference> getDependenciesAsDependee();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getDependencyEndpoint_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // DependencyEndpoint