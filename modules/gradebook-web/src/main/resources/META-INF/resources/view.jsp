<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ include file="/META-INF/resources/init.jsp" %>

<h1>¡Bienvenido a mi Portlet!</h1>

<liferay-ui:message key="welcome-message" />

<portlet:actionURL var="sampleActionURL">
	<portlet:param name="cmd" value="doSomething" />
</portlet:actionURL>
