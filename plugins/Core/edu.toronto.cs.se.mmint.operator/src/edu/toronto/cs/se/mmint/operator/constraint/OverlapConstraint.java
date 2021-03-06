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
package edu.toronto.cs.se.mmint.operator.constraint;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class OverlapConstraint extends MatchConstraint {

    @Override
    public boolean validate(Model model) {

        if (!super.validate(model)) {
            return false;
        }
        long extraMappings = ((ModelRel) model).getMappings().stream()
            .filter(mapping -> mapping.getMetatypeUri().equals("http://se.cs.toronto.edu/mmint/Overlap2/Mapping2"))
            .count();
        if (extraMappings != 0) {
            return false;
        }

        return true;
    }

}
