<%@ include file="init.jsp"%>
<liferay-ui:error key="serviceErrorDetails">
    <liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' key="error.assignment-service-error" />
</liferay-ui:error>

<liferay-ui:success key="assignmentAdded" message="assignment-added-successfully" />
<liferay-ui:success key="assignmentUpdated" message="assignment-updated-successfully" />
<liferay-ui:success key="assignmentDeleted" message="assignment-deleted-successfully" />


<div class="container-fluid-1280">
    <h1><liferay-ui:message key="Assignments" /></h1>
    <%-- Clay management toolbar. --%>
    <clay:management-toolbar
            disabled="${assignmentCount eq 0}"
            displayContext="${assignmentsManagementToolbarDisplayContext}"
            itemsTotal="${assignmentCount}"
            searchContainerId="assignmentEntries"
            selectable="false"
    />
    <%-- Search container. --%>
    <liferay-ui:search-container
            emptyResultsMessage="no-assignments"
            id="assignmentEntries"
            iteratorURL="${portletURL}"
            total="${assignmentCount}">
        <liferay-ui:search-container-results results="${assignments}" />
        <liferay-ui:search-container-row
                className="com.liferay.training.gradebook.model.Assignment"
                modelVar="entry">

            <%-- Generate assignment view URL. --%>
            <portlet:renderURL var="viewAssignmentURL">
                <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_ASSIGNMENT %>" />
                <portlet:param name="redirect" value="${currentURL}" />
                <portlet:param name="assignmentId" value="${entry.assignmentId}" />
            </portlet:renderURL>
            <c:choose>
                <%-- Descriptive (list) view --%>
                <c:when
                        test='${assignmentsManagementToolbarDisplayContext.getDisplayStyle().equals("descriptive")}'>
                    <%-- User --%>
                    <liferay-ui:search-container-column-user
                            showDetails="<%=false%>"
                            userId="<%=entry.getUserId()%>"
                    />
                    <liferay-ui:search-container-column-text colspan="<%=2%>">
                        <%
                            String modifiedDateDescription =
                                    LanguageUtil.getTimeDescription(
                                            request, System.currentTimeMillis()
                                                    - entry.getModifiedDate().getTime(), true);
                        %>
                        <h5 class="text-default">
                            <liferay-ui:message
                                    arguments="<%=new String[] {entry.getUserName(), modifiedDateDescription}%>"
                                    key="x-modified-x-ago" />
                        </h5>
                        <h4>
                            <aui:a href="${viewAssignmentURL}">
                                ${entry.getTitle(locale)}
                            </aui:a>
                        </h4>
                    </liferay-ui:search-container-column-text>
                    <liferay-ui:search-container-column-jsp
                            path="/assignment/entry_actions.jsp" />
                </c:when>
                <%-- Card view --%>

                <%-- Table view --%>
                <c:otherwise>
                    <liferay-ui:search-container-column-text
                            href="${viewAssignmentURL}"
                            name="title"
                            value="<%= entry.getTitle(locale) %>"
                    />
                    <liferay-ui:search-container-column-user
                            name="author"
                            userId="${entry.userId}"
                    />
                    <liferay-ui:search-container-column-date
                            name="create-date"
                            property="createDate"
                    />
                    <liferay-ui:search-container-column-jsp
                            name="actions"
                            path="/assignment/entry_actions.jsp"
                    />
                </c:otherwise>
            </c:choose>

        </liferay-ui:search-container-row>

        <%-- Iterator / Paging --%>
        <liferay-ui:search-iterator
                displayStyle="${assignmentsManagementToolbarDisplayContext.getDisplayStyle()}"
                markupView="lexicon"
        />
    </liferay-ui:search-container>
</div>
