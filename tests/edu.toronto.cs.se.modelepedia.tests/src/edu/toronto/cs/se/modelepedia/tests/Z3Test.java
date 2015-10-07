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
package edu.toronto.cs.se.modelepedia.tests;

import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mavo.constraint.MAVOMultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIB;
import edu.toronto.cs.se.modelepedia.z3.mavo.Z3MAVOModelParser;
import edu.toronto.cs.se.modelepedia.z3.reasoning.Z3ReasoningEngine;

public class Z3Test extends MMINTTest {

	@Test
	public void ecoreAllSAT() throws Exception {

		/**
		 * TODO:
		 * 1) Refactor common code in a better way
		 * 2) Come up with interesting mavo input model(s)
		 * 3) Consider an intermediate test with the encoding and a property as input
		 */
		Bundle testBundle = Platform.getBundle(TESTS_BUNDLE_NAME);
		MID instanceMID = createInstanceMID();
		Model model = addInputModel(instanceMID, testBundle, "model/z3", "ecore.classdiagram_mavo");
		Z3ReasoningEngine z3Reasoner = (Z3ReasoningEngine) MAVOMultiModelConstraintChecker.getMAVOReasoner("SMTLIB");
		EcoreMAVOToSMTLIB ecore2smt = (EcoreMAVOToSMTLIB) MultiModelTypeRegistry.<Operator>getType(Z3ReasoningEngine.ECOREMAVOTOSMTLIB_OPERATOR_URI);
		EList<Model> inputModels = new BasicEList<Model>();
		inputModels.add(model);
		EList<OperatorInput> inputs = ecore2smt.checkAllowedInputs(inputModels);
		Map<String, MID> outputMIDsByName = MultiModelOperatorUtils.createSimpleOutputMIDsByName(ecore2smt, instanceMID);
		ecore2smt.start(inputs, new BasicEList<>(), outputMIDsByName, instanceMID);
		Z3MAVOModelParser z3ModelParser = ecore2smt.getZ3MAVOModelParser();
		MAVORoot rootMavoModelObj = (MAVORoot) model.getEMFInstanceRoot();
		int numSolutions = z3Reasoner.allSAT(z3ModelParser.getSMTLIBEncoding(), z3ModelParser, MAVOUtils.getAnnotatedMAVOModelObjects(rootMavoModelObj), rootMavoModelObj);
		Assert.assertEquals(46, numSolutions);
	}

}
