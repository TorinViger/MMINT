/**
 */
package edu.toronto.cs.nlsfung.gsn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.Strategy#getState <em>State</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getStrategy()
 * @model
 * @generated
 */
public interface Strategy extends GsnElement, GoalSupporter {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.nlsfung.gsn.ValidityState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see edu.toronto.cs.nlsfung.gsn.ValidityState
	 * @see #setState(ValidityState)
	 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getStrategy_State()
	 * @model
	 * @generated
	 */
	ValidityState getState();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.gsn.Strategy#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see edu.toronto.cs.nlsfung.gsn.ValidityState
	 * @see #getState()
	 * @generated
	 */
	void setState(ValidityState value);

} // Strategy
