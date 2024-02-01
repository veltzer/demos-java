
package calendar.client.proxy;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAXWS SI. JAX-WS RI 2.0_01-b59-fcs Generated
 * source version: 2.0
 */
@WebService(name = "HebCalendar", targetNamespace = "http://service.calendar/")
public interface HebCalendar {

	/**
	 * @param arg0
	 * @return returns Response<calendar.client.proxy.HebDayOfWeekResponse>
	 */
	@WebMethod(operationName = "hebDayOfWeek")
	@RequestWrapper(localName = "hebDayOfWeek", targetNamespace = "http://service.calendar/", className = "calendar.client.proxy.HebDayOfWeek")
	@ResponseWrapper(localName = "hebDayOfWeekResponse", targetNamespace = "http://service.calendar/", className = "calendar.client.proxy.HebDayOfWeekResponse")
	Response<HebDayOfWeekResponse> hebDayOfWeekAsync(
			@WebParam(name = "arg0", targetNamespace = "") XMLGregorianCalendar arg0);

	/**
	 * @param arg0
	 * @param asyncHandler
	 * @return returns Future<? extends Object>
	 */
	@WebMethod(operationName = "hebDayOfWeek")
	@RequestWrapper(localName = "hebDayOfWeek", targetNamespace = "http://service.calendar/", className = "calendar.client.proxy.HebDayOfWeek")
	@ResponseWrapper(localName = "hebDayOfWeekResponse", targetNamespace = "http://service.calendar/", className = "calendar.client.proxy.HebDayOfWeekResponse")
	Future<?> hebDayOfWeekAsync(
			@WebParam(name = "arg0", targetNamespace = "") XMLGregorianCalendar arg0,
			@WebParam(name = "asyncHandler", targetNamespace = "") AsyncHandler<HebDayOfWeekResponse> asyncHandler);

	/**
	 * @param arg0
	 * @return returns String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "hebDayOfWeek", targetNamespace = "http://service.calendar/", className = "calendar.client.proxy.HebDayOfWeek")
	@ResponseWrapper(localName = "hebDayOfWeekResponse", targetNamespace = "http://service.calendar/", className = "calendar.client.proxy.HebDayOfWeekResponse")
	String hebDayOfWeek(
			@WebParam(name = "arg0", targetNamespace = "") XMLGregorianCalendar arg0);

	/**
	 * @param arg0
	 * @return returns Response<calendar.client.proxy.HebDayNameResponse>
	 */
	@WebMethod(operationName = "hebDayName")
	@RequestWrapper(localName = "hebDayName", targetNamespace = "http://service.calendar/", className = "calendar.client.proxy.HebDayName")
	@ResponseWrapper(localName = "hebDayNameResponse", targetNamespace = "http://service.calendar/", className = "calendar.client.proxy.HebDayNameResponse")
	Response<HebDayNameResponse> hebDayNameAsync(
			@WebParam(name = "arg0", targetNamespace = "") int arg0);

	/**
	 * @param arg0
	 * @param asyncHandler
	 * @return returns Future<? extends Object>
	 */
	@WebMethod(operationName = "hebDayName")
	@RequestWrapper(localName = "hebDayName", targetNamespace = "http://service.calendar/", className = "calendar.client.proxy.HebDayName")
	@ResponseWrapper(localName = "hebDayNameResponse", targetNamespace = "http://service.calendar/", className = "calendar.client.proxy.HebDayNameResponse")
	Future<?> hebDayNameAsync(
			@WebParam(name = "arg0", targetNamespace = "") int arg0,
			@WebParam(name = "asyncHandler", targetNamespace = "") AsyncHandler<HebDayNameResponse> asyncHandler);

	/**
	 * @param arg0
	 * @return returns String
	 */
	@WebMethod
	@WebResult(targetNamespace = "")
	@RequestWrapper(localName = "hebDayName", targetNamespace = "http://service.calendar/", className = "calendar.client.proxy.HebDayName")
	@ResponseWrapper(localName = "hebDayNameResponse", targetNamespace = "http://service.calendar/", className = "calendar.client.proxy.HebDayNameResponse")
	String hebDayName(@WebParam(name = "arg0", targetNamespace = "") int arg0);

}