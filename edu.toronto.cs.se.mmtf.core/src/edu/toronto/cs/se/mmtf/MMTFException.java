/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * Custom exception for MMTF.
 *
 * @author Alessio Di Sandro
 */
public class MMTFException extends Exception {

	/** Exception types. */
	public enum Type {WARNING, ERROR}

	/** Autogenerated. */
	private static final long serialVersionUID = 1L;

	/**
	 * Prints an exception.
	 *
	 * @param type    The exception category.
	 * @param message The exception message.
	 * @param e       The exception or error.
	 */
	public static void print(Type type, String message, Throwable e) {

		//TODO MMTF: remove type and use int as first argument == IStatus.SOMETHING
		int status;
		switch (type) {
			case WARNING:
				status = IStatus.WARNING;
				break;
			case ERROR:
				status = IStatus.ERROR;
				break;
			default:
				status = IStatus.ERROR;
		}
		MMTFActivator.getDefault().getLog().log(
			new Status(status, MMTFActivator.PLUGIN_ID, message, e)
		);

		if (status == IStatus.ERROR) {
			System.exit(-1);
		}
	}

	/**
	 * Constructor: initialises the superclass.
	 *
	 * @param message The exception message.
	 */
	public MMTFException(String message) {

		super(message);
	}

	/**
	 * Constructor: initialises the superclass with a chained exception.
	 *
	 * @param message The exception message.
	 * @param cause   The exception that caused this exception.
	 */
	public MMTFException(String message, Throwable cause) {

		super(message, cause);
	}

}
