
package helloworld.client.proxy;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAXWS SI.
 * JAX-WS RI 2.0_01-b59-fcs
 * Generated source version: 2.0
 *
 */
@WebService(name = "HelloWorld", targetNamespace = "http://service.helloworld/")
public interface HelloWorld {


    /**
     *
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://service.helloworld/", className = "helloworld.client.proxy.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://service.helloworld/", className = "helloworld.client.proxy.SayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}