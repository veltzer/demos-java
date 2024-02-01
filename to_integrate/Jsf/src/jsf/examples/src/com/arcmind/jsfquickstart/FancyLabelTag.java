package com.arcmind.jsfquickstart;

import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentTag;

public class FancyLabelTag extends UIComponentTag {

	private String label;
	private String errorStyleClass = "";
	private String errorStyle = "";
	private String forComponent;

	/**
	 * @return Returns the forComponent.
	 */
	public String getFor() {
		return forComponent;
	}

	/**
	 * @param forComponent The forComponent to set.
	 */
	public void setFor(String iforComponent) {
		forComponent = iforComponent;
	}

	/**
	 * @return Returns the label.
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label The label to set.
	 */
	public void setLabel(String ilabel) {
		label = ilabel;
	}

	@Override
	protected void setProperties(UIComponent component) {
		/* you have to call the super class */
		super.setProperties(component);
		((FancyLabelComponent) component).setLabel(label);
		((FancyLabelComponent) component).setErrorStyleClass(errorStyleClass);
		((FancyLabelComponent) component).setFor(forComponent);
		((FancyLabelComponent) component).setErrorStyle(errorStyle);

	}

	@Override
	public String getComponentType() {
		return "arcmind.Label";
	}

	@Override
	public String getRendererType() {
		return null;
	}

	/**
	 * @return Returns the errorStyleClass.
	 */
	public String getErrorStyleClass() {
		return errorStyleClass;
	}

	/**
	 * @param errorStyleClass The errorStyleClass to set.
	 */
	public void setErrorStyleClass(String ierrorStyleClass) {
		errorStyleClass = ierrorStyleClass;
	}
}
