
package helloworld.client.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the helloworld.client.proxy package. <p>An
 * ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

	private static final QName SAYHELLO_QNAME = new QName(
			"http://service.helloworld/", "sayHello");
	private static final QName SAYHELLORESPONSE_QNAME = new QName(
			"http://service.helloworld/", "sayHelloResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: helloworld.client.proxy
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link SayHelloResponse }
	 */
	public SayHelloResponse createSayHelloResponse() {
		return new SayHelloResponse();
	}

	/**
	 * Create an instance of {@link SayHello }
	 */
	public SayHello createSayHello() {
		return new SayHello();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }
	 * {@code >}}
	 */
	@XmlElementDecl(namespace = "http://service.helloworld/", name = "sayHello")
	public JAXBElement<SayHello> createSayHello(SayHello value) {
		return new JAXBElement<SayHello>(SAYHELLO_QNAME, SayHello.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SayHelloResponse }{@code >}}
	 */
	@XmlElementDecl(namespace = "http://service.helloworld/", name = "sayHelloResponse")
	public JAXBElement<SayHelloResponse> createSayHelloResponse(
			SayHelloResponse value) {
		return new JAXBElement<SayHelloResponse>(SAYHELLORESPONSE_QNAME,
				SayHelloResponse.class, null, value);
	}

}
