
package calculator.client.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for invokeOperationResponse complex type. <p>The following
 * schema fragment specifies the expected content contained within this class.
 * <pre> &lt;complexType name="invokeOperationResponse"> &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;sequence> &lt;element name="return"
 * type="{http://www.w3.org/2001/XMLSchema}float"/> &lt;/sequence>
 * &lt;/restriction> &lt;/complexContent> &lt;/complexType> </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invokeOperationResponse", propOrder = {
		"vreturn"
})
public class InvokeOperationResponse {

	@XmlElement(name = "return")
	private float vreturn;

	/**
	 * Gets the value of the return property.
	 */
	public float getReturn() {
		return vreturn;
	}

	/**
	 * Sets the value of the return property.
	 */
	public void setReturn(float value) {
		vreturn = value;
	}

}
