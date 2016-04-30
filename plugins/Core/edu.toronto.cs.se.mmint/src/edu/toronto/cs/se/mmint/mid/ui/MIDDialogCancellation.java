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
package edu.toronto.cs.se.mmint.mid.ui;

import edu.toronto.cs.se.mmint.MMINTException;

public class MIDDialogCancellation extends MMINTException {

	public MIDDialogCancellation() {

		super("Dialog cancelled");
	}

	/** Default serial version. */
	private static final long serialVersionUID = 1L;

}