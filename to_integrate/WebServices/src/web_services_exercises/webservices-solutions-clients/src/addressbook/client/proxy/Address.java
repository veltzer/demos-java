
package addressbook.client.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for address complex type. <p>The following schema fragment
 * specifies the expected content contained within this class. <pre>
 * &lt;complexType name="address"> &lt;complexContent> &lt;restriction
 * base="{http://www.w3.org/2001/XMLSchema}anyType"> &lt;sequence> &lt;element
 * name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"
 * minOccurs="0"/> &lt;element name="num"
 * type="{http://www.w3.org/2001/XMLSchema}int"/> &lt;element name="street"
 * type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 * &lt;/sequence> &lt;/restriction> &lt;/complexContent> &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address", propOrder = {
		"city", "country", "num", "street"
})
public class Address {

	private String city;
	private String country;
	private int num;
	private String street;

	/**
	 * Gets the value of the city property.
	 * @return possible object is {@link String }
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the value of the city property.
	 * @param value allowed object is {@link String }
	 */
	public void setCity(String value) {
		this.city = value;
	}

	/**
	 * Gets the value of the country property.
	 * @return possible object is {@link String }
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the value of the country property.
	 * @param value allowed object is {@link String }
	 */
	public void setCountry(String value) {
		this.country = value;
	}

	/**
	 * Gets the value of the num property.
	 */
	public int getNum() {
		return num;
	}

	/**
	 * Sets the value of the num property.
	 */
	public void setNum(int value) {
		this.num = value;
	}

	/**
	 * Gets the value of the street property.
	 * @return possible object is {@link String }
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets the value of the street property.
	 * @param value allowed object is {@link String }
	 */
	public void setStreet(String value) {
		this.street = value;
	}

}
