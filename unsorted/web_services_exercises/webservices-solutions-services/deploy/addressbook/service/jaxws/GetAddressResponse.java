
package addressbook.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAddressResponse", namespace = "http://service.addressbook/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAddressResponse", namespace = "http://service.addressbook/")
public class GetAddressResponse {

    @XmlElement(name = "return", namespace = "")
    private addressbook.service.Address _return;

    /**
     * 
     * @return
     *     returns Address
     */
    public addressbook.service.Address get_return() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void set_return(addressbook.service.Address _return) {
        this._return = _return;
    }

}