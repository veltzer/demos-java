<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<html>
	<head>
		<title>JSF Birthday Cake</title>
	</head>
	<body>
		<div align="center">
			<h:form id="ageForm">
				<h:outputText value="How old are you? " />
				<h:inputText id="userAge" size="4" value="#{cake.userAge}" required="true">
					<f:validateLongRange minimum="1" maximum="120" />
				</h:inputText>
				<h:commandButton value="It's my birthday!" id="birthday"  actionListener="#{cake.showCake}" />
				<br />
				<h:message for="userAge" style="color: red;" />
			</h:form>
			<br />
			<h:panelGroup id="cake" rendered="false" /> <!-- Java code will add children to this element -->
		</div>
	</body>
</html>
</f:view>
