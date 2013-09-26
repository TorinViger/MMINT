/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.reasoning;

public class Z3SMTUtils implements Z3SMTSolver {

	public static String predicate(String predicateStart, String smtTerms) {

		return predicateStart + smtTerms + SMTLIB_PREDICATE_END;
	}

	public static String assertion(String smtTerms) {

		return predicate(SMTLIB_ASSERT, smtTerms);
	}

	public static String not(String smtTerms) {

		return predicate(SMTLIB_NOT, smtTerms);
	}

	public static String and(String smtTerms) {

		return predicate(SMTLIB_AND, smtTerms);
	}

	public static String or(String smtTerms) {

		return predicate(SMTLIB_OR, smtTerms);
	}

	public static String exists(String smtQuantification, String smtTerms) {

		return predicate(
			SMTLIB_EXISTS,
			SMTLIB_PREDICATE_START + SMTLIB_PREDICATE_START + smtQuantification + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END + smtTerms
		);
	}

	public static String forall(String smtQuantification, String smtTerms) {

		return predicate(
			SMTLIB_FORALL,
			SMTLIB_PREDICATE_START + SMTLIB_PREDICATE_START + smtQuantification + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END + smtTerms
		);
	}

}
