package com.example.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.example.constants.GradebookWebPortletKeys;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.training.gradebook.service.AssignmentService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
/**
 * MVC Action Command for deleting assignments.
 *
 * @author liferay
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + GradebookWebPortletKeys.GRADEBOOKWEB,
                "mvc.command.name=/gradebook/assignment/delete"
        },
        service = MVCActionCommand.class
)

public class DeleteAssignmentMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
        // Get assignment id from request.
        long assignmentId = ParamUtil.getLong(actionRequest, "assignmentId");
        // Call service to delete the assignment.
        _assignmentService.deleteAssignment(assignmentId);
        // Set success message.
        SessionMessages.add(actionRequest, "assignmentDeleted");
    }

    @Reference
    protected AssignmentService _assignmentService;
}

