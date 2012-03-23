package edu.toronto.cs.se.mmtf.repository;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;

import edu.toronto.cs.se.mmtf.MMTF;

public class MetamodelsExtensionListener extends MMTFExtensionListener {

	public MetamodelsExtensionListener(MMTF mmtf) {

		super(mmtf);
	}

	@Override
	public void added(IExtension[] extensions) {

		IConfigurationElement[] config;
		Metamodel metamodel;
		for (IExtension extension : extensions) {
			config = extension.getConfigurationElements();
			for (IConfigurationElement elem : config) {
				metamodel = mmtf.addMetamodel(elem);
				mmtf.addMetamodelEditors(metamodel);
			}
		}
	}

	@Override
	public void removed(IExtension[] extensions) {

		IConfigurationElement[] config;
		for (IExtension extension : extensions) {
			config = extension.getConfigurationElements();
			for (IConfigurationElement elem : config) {
				mmtf.removeMetamodel(elem);
			}
		}
	}

}