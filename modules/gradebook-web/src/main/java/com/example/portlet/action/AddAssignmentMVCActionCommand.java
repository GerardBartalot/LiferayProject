package com.example.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.example.constants.GradebookWebPortletKeys;
import com.example.constants.MVCCommandNames;
import java.util.Date;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.service.AssignmentService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
/**
 * MVC Action Command for adding assignments.
 *
 * @author liferay
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + GradebookWebPortletKeys.GRADEBOOKWEB,
                "mvc.command.name=" + MVCCommandNames.ADD_ASSIGNMENT
        },
        service = MVCActionCommand.class
)

public class AddAssignmentMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
        ThemeDisplay themeDisplay =
                (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Assignment.class.getName(), actionRequest);
        // Get parameters from the request.
        String title = ParamUtil.getString(actionRequest, "title");

        String description = ParamUtil.getString(actionRequest, "description", null);
        Date dueDate = ParamUtil.getDate(actionRequest, "dueDate", null);
        // Call the service to add a new assignment.

        _assignmentService.addAssignment(
                themeDisplay.getScopeGroupId(), title, description, dueDate, serviceContext);

        // Set the success message.
        SessionMessages.add(actionRequest, "assignmentAdded");
        sendRedirect(actionRequest, actionResponse);
    }
    @Reference
    protected AssignmentService _assignmentService;
}