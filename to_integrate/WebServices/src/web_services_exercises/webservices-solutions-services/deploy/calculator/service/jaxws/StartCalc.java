
package calculator.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "startCalc", namespace = "http://service.calculator/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "startCalc", namespace = "http://service.calculator/")
public class StartCalc {

	@XmlElement(name = "arg0", namespace = "")
	private float arg0;

	/**
	 * @return returns float
	 */
	public float getArg0() {
		return arg0;
	}

	/**
	 * @param arg0 the value for the arg0 property
	 */
	public void setArg0(float iarg0) {
		arg0 = iarg0;
	}

}
