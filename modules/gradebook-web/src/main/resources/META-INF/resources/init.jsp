<%@page import="com.liferay.portal.kernel.util.*" %>
<%@page import="com.liferay.portal.kernel.theme.*" %>
<%@page import="com.liferay.portal.kernel.model.*" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%
    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    User user = themeDisplay.getUser();
    String currentURL = themeDisplay.getURLCurrent();
    long groupId = themeDisplay.getScopeGroupId();
    String portletNamespace = themeDisplay.getPortletDisplay().getNamespace();
%>
