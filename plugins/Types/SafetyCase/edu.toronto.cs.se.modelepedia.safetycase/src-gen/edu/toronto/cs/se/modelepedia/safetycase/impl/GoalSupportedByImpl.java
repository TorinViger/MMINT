/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.impl;

import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.GoalSupportedBy;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal Supported By</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalSupportedByImpl#getConclusion <em>Conclusion</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.GoalSupportedByImpl#getPremise <em>Premise</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoalSupportedByImpl extends SupportedByImpl implements GoalSupportedBy {
	/**
	 * The cached value of the '{@link #getConclusion() <em>Conclusion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConclusion()
	 * @generated
	 * @ordered
	 */
	protected Goal conclusion;

	/**
	 * The cached value of the '{@link #getPremise() <em>Premise</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPremise()
	 * @generated
	 * @ordered
	 */
	protected DecomposableCoreElement premise;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoalSupportedByImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyCasePackage.Literals.GOAL_SUPPORTED_BY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal getConclusion() {
		if (conclusion != null && conclusion.eIsProxy()) {
			InternalEObject oldConclusion = (InternalEObject)conclusion;
			conclusion = (Goal)eResolveProxy(oldConclusion);
			if (conclusion != oldConclusion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetyCasePackage.GOAL_SUPPORTED_BY__CONCLUSION, oldConclusion, conclusion));
			}
		}
		return conclusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal basicGetConclusion() {
		return conclusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConclusion(Goal newConclusion) {
		Goal oldConclusion = conclusion;
		conclusion = newConclusion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.GOAL_SUPPORTED_BY__CONCLUSION, oldConclusion, conclusion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecomposableCoreElement getPremise() {
		if (premise != null && premise.eIsProxy()) {
			InternalEObject oldPremise = (InternalEObject)premise;
			premise = (DecomposableCoreElement)eResolveProxy(oldPremise);
			if (premise != oldPremise) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetyCasePackage.GOAL_SUPPORTED_BY__PREMISE, oldPremise, premise));
			}
		}
		return premise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecomposableCoreElement basicGetPremise() {
		return premise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPremise(DecomposableCoreElement newPremise) {
		DecomposableCoreElement oldPremise = premise;
		premise = newPremise;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyCasePackage.GOAL_SUPPORTED_BY__PREMISE, oldPremise, premise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SafetyCasePackage.GOAL_SUPPORTED_BY__CONCLUSION:
				if (resolve) return getConclusion();
				return basicGetConclusion();
			case SafetyCasePackage.GOAL_SUPPORTED_BY__PREMISE:
				if (resolve) return getPremise();
				return basicGetPremise();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SafetyCasePackage.GOAL_SUPPORTED_BY__CONCLUSION:
				setConclusion((Goal)newValue);
				return;
			case SafetyCasePackage.GOAL_SUPPORTED_BY__PREMISE:
				setPremise((DecomposableCoreElement)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SafetyCasePackage.GOAL_SUPPORTED_BY__CONCLUSION:
				setConclusion((Goal)null);
				return;
			case SafetyCasePackage.GOAL_SUPPORTED_BY__PREMISE:
				setPremise((DecomposableCoreElement)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SafetyCasePackage.GOAL_SUPPORTED_BY__CONCLUSION:
				return conclusion != null;
			case SafetyCasePackage.GOAL_SUPPORTED_BY__PREMISE:
				return premise != null;
		}
		return super.eIsSet(featureID);
	}

} //GoalSupportedByImpl
