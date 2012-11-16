/*
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
package edu.toronto.cs.se.mmtf.mid.trait;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmtf.repository.MMTFConstants;

public class MultiModelHierarchyUtils implements MMTFConstants {

	private static class ExtensionHierarchyComparator implements Comparator<IConfigurationElement> {

		private HashMap<String, String> extensionUris;
		private String childName;
		private String rootUri;

		public ExtensionHierarchyComparator(HashMap<String, String> extensionUris, String childName, String rootUri) {

			this.extensionUris = extensionUris;
			this.childName = childName;
			this.rootUri = rootUri;
		}

		@Override
		public int compare(IConfigurationElement extension1, IConfigurationElement extension2) {

			if (childName != null) {
				extension1 = extension1.getChildren(childName)[0];
				extension2 = extension2.getChildren(childName)[0];
			}
			IConfigurationElement typeConfig1 = extension1.getChildren(CHILD_EXTENDIBLETYPE)[0];
			String uri1 = typeConfig1.getAttribute(EXTENDIBLETYPE_ATTR_URI);
			String supertypeUri1 = extensionUris.get(uri1);
			int supertypes1 = (rootUri != null && uri1.equals(rootUri)) ? -1 : 0;
			while (supertypeUri1 != null) {
				supertypes1++;
				uri1 = supertypeUri1;
				supertypeUri1 = extensionUris.get(uri1);
			}
			IConfigurationElement typeConfig2 = extension2.getChildren(CHILD_EXTENDIBLETYPE)[0];
			String uri2 = typeConfig2.getAttribute(EXTENDIBLETYPE_ATTR_URI);
			if (uri2 == null) {
				extension2 = extension2.getChildren(CHILD_EXTENDIBLETYPE)[0];
				uri2 = extension2.getAttribute(EXTENDIBLETYPE_ATTR_URI);
			}
			String supertypeUri2 = extensionUris.get(uri2);
			int supertypes2 = (rootUri != null && uri2.equals(rootUri)) ? -1 : 0;
			while (supertypeUri2 != null) {
				supertypes2++;
				uri2 = supertypeUri2;
				supertypeUri2 = extensionUris.get(uri2);
			}

			int relativeOrder = supertypes1 - supertypes2;
			if (relativeOrder == 0) {
				relativeOrder = uri1.compareTo(uri2);
			}

			return relativeOrder;
		}

	}

	private static class TypeHierarchyComparator implements Comparator<ExtendibleElement> {

		@Override
		public int compare(ExtendibleElement elementType1, ExtendibleElement elementType2) {

			int supertypes1 = 0;
			while (elementType1.getSupertype() != null) {
				supertypes1++;
				elementType1 = elementType1.getSupertype();
			}
			int supertypes2 = 0;
			while (elementType2.getSupertype() != null) {
				supertypes2++;
				elementType2 = elementType2.getSupertype();
			}

			int relativeOrder = supertypes1 - supertypes2;
			if (relativeOrder == 0) {
				relativeOrder = elementType1.getUri().compareTo(elementType2.getUri());
			}

			return relativeOrder;
		}
	}

	private static class TypeRefHierarchyComparator implements Comparator<ExtendibleElementReference> {

		@Override
		public int compare(ExtendibleElementReference elementTypeRef1, ExtendibleElementReference elementTypeRef2) {

			int supertypes1 = 0;
			while (elementTypeRef1.getSupertypeRef() != null) {
				supertypes1++;
				elementTypeRef1 = elementTypeRef1.getSupertypeRef();
			}
			int supertypes2 = 0;
			while (elementTypeRef2.getSupertypeRef() != null) {
				supertypes2++;
				elementTypeRef2 = elementTypeRef2.getSupertypeRef();
			}


			int relativeOrder = supertypes1 - supertypes2;
			if (relativeOrder == 0) {
				relativeOrder = elementTypeRef1.getUri().compareTo(elementTypeRef2.getUri());
			}

			return relativeOrder;
		}
	}

	public static Iterator<IConfigurationElement> getExtensionHierarchyIterator(IConfigurationElement[] extensions, String childName, String rootUri) {

		HashMap<String, String> extensionUris = new HashMap<String, String>();
		for (IConfigurationElement extension : extensions) {
			if (childName != null) {
				extension = extension.getChildren(childName)[0];
			}
			IConfigurationElement typeConfig = extension.getChildren(CHILD_EXTENDIBLETYPE)[0];
			String uri = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_URI);
			String supertypeUri = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_SUPERTYPEURI);
			extensionUris.put(uri, supertypeUri);
		}
		TreeSet<IConfigurationElement> hierarchy = new TreeSet<IConfigurationElement>(
			new ExtensionHierarchyComparator(extensionUris, childName, rootUri)
		);
		for (IConfigurationElement extension : extensions) {
			hierarchy.add(extension);
		}

		return hierarchy.iterator();
	}

	//TODO MMTF: are type and type ref iterators really needed, or are the lists already ordered by construction?
	public static <T extends ExtendibleElement> TreeSet<T> getTypeHierarchy(EList<T> elementTypes) {

		TreeSet<T> hierarchy = new TreeSet<T>(
			new TypeHierarchyComparator()
		);
		for (T elementType : elementTypes) {
			hierarchy.add(elementType);
		}

		return hierarchy;
	}

	public static <T extends ExtendibleElement> Iterator<T> getTypeHierarchyIterator(EList<T> elementTypes) {

		TreeSet<T> hierarchy = getTypeHierarchy(elementTypes);

		return hierarchy.iterator();
	}

	public static <T extends ExtendibleElement> Iterator<T> getInverseTypeHierarchyIterator(EList<T> elementTypes) {

		TreeSet<T> hierarchy = getTypeHierarchy(elementTypes);

		return hierarchy.descendingIterator();
	}

	private static <T extends ExtendibleElementReference> TreeSet<T> getTypeRefHierarchy(EList<T> elementTypeRefs) {

		TreeSet<T> hierarchy = new TreeSet<T>(
			new TypeRefHierarchyComparator()
		);
		for (T elementTypeRef : elementTypeRefs) {
			hierarchy.add(elementTypeRef);
		}

		return hierarchy;
	}

	public static <T extends ExtendibleElementReference> Iterator<T> getTypeRefHierarchyIterator(EList<T> elementTypeRefs) {

		TreeSet<T> hierarchy = getTypeRefHierarchy(elementTypeRefs);

		return hierarchy.iterator();
	}

	public static <T extends ExtendibleElementReference> Iterator<T> getInverseTypeRefHierarchyIterator(EList<T> elementTypeRefs) {

		TreeSet<T> hierarchy = getTypeRefHierarchy(elementTypeRefs);

		return hierarchy.descendingIterator();
	}

	public static <T extends ExtendibleElement> T get(String elementTypeUri, EList<T> elementTypes) {

		if (elementTypeUri == null) {
			return null;
		}

		for (T elementType : elementTypes) {
			if (elementTypeUri.equals(elementType.getUri())) {
				return elementType;
			}
		}

		return null;
	}

	public static <T extends ExtendibleElement> T get(T correspondingElementType, EList<T> elementTypes) {

		if (correspondingElementType == null) {
			return null;
		}

		return get(correspondingElementType.getUri(), elementTypes);
	}

	public static <T extends ExtendibleElementReference> T getReference(String elementTypeRefUri, EList<T> elementTypeRefs) {

		if (elementTypeRefUri == null) {
			return null;
		}

		for (T elementTypeRef : elementTypeRefs) {
			if (elementTypeRefUri.equals(elementTypeRef.getUri())) {
				return elementTypeRef;
			}
		}

		return null;
	}

	public static <T extends ExtendibleElementReference> T getReference(T correspondingElementTypeRef, EList<T> elementTypeRefs) {

		if (correspondingElementTypeRef == null) {
			return null;
		}

		return getReference(correspondingElementTypeRef.getUri(), elementTypeRefs);
	}

	public static <T extends ExtendibleElementEndpointReference> EList<T> getEndpointReferences(String targetTypeUri, EList<T> typeEndpointRefs) {

		if (targetTypeUri == null) {
			return null;
		}

		EList<T> targetTypeEndpointRefs = new BasicEList<T>();
		for (T typeEndpointRef : typeEndpointRefs) {
			if (targetTypeUri.equals(typeEndpointRef.getTargetUri())) {
				targetTypeEndpointRefs.add(typeEndpointRef);
			}
		}

		return targetTypeEndpointRefs;
	}

	public static <T extends ExtendibleElementEndpoint> T getEndpoint(String targetTypeUri, EList<T> typeEndpoints) {

		if (targetTypeUri == null) {
			return null;
		}

		for (T typeEndpoint : typeEndpoints) {
			if (targetTypeUri.equals(typeEndpoint.getTargetUri())) {
				return typeEndpoint;
			}
		}

		return null;
	}

}