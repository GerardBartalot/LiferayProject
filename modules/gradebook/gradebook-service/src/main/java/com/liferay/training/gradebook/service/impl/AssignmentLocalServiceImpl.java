package com.liferay.training.gradebook.service.impl;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.service.base.AssignmentLocalServiceBaseImpl;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.training.gradebook.validator.AssignmentValidator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = "model.class.name=com.liferay.training.gradebook.model.Assignment",
		service = AopService.class
)
public class AssignmentLocalServiceImpl extends AssignmentLocalServiceBaseImpl {

	public Assignment addAssignment(long groupId, Map<Locale, String> titleMap, String description,
									Date dueDate, ServiceContext serviceContext) throws PortalException {
		// Validate assignment parameters.
		_assignmentValidator.validate(titleMap, description, dueDate);

		// Get group and user.
		Group group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		// Generate primary key for the assignment.
		long assignmentId = counterLocalService.increment(Assignment.class.getName());
		// Create assigment. This doesn't yet persist the entity.
		Assignment assignment = createAssignment(assignmentId);
		// Populate fields.
		assignment.setCompanyId(group.getCompanyId());
		assignment.setCreateDate(serviceContext.getCreateDate(new Date()));
		assignment.setDueDate(dueDate);
		assignment.setDescription(description);
		assignment.setGroupId(groupId);
		assignment.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		assignment.setTitleMap(titleMap);
		assignment.setUserId(userId);
		assignment.setUserName(user.getScreenName());
		// Persist assignment to database.
		return super.addAssignment(assignment);
	}

	public Assignment updateAssignment(long assignmentId, Map<Locale, String> titleMap,
									   String description, Date dueDate, ServiceContext serviceContext) throws PortalException {
		// Validate assignment parameters.
		_assignmentValidator.validate(titleMap, description, dueDate);

		// Get the Assignment by id.
		Assignment assignment = getAssignment(assignmentId);
		// Set updated fields and modification date.
		assignment.setModifiedDate(new Date());
		assignment.setTitleMap(titleMap);
		assignment.setDueDate(dueDate);
		assignment.setDescription(description);
		assignment = super.updateAssignment(assignment);
		return assignment;
	}

	public List<Assignment> getAssignmentsByGroupId(long groupId) {
		return assignmentPersistence.findByGroupId(groupId);
	}
	public List<Assignment> getAssignmentsByGroupId(long groupId, int start, int end) {
		return assignmentPersistence.findByGroupId(groupId, start, end);
	}
	public List<Assignment> getAssignmentsByGroupId(long groupId, int start, int end,
													OrderByComparator<Assignment> orderByComparator) {
		return assignmentPersistence.findByGroupId(groupId, start, end, orderByComparator);
	}
	public List<Assignment> getAssignmentsByKeywords(
			long groupId, String keywords, int start, int end,
			OrderByComparator<Assignment> orderByComparator) {
		return assignmentLocalService.dynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords), start, end,
				orderByComparator);
	}
	public long getAssignmentsCountByKeywords(long groupId, String keywords) {
		return assignmentLocalService.dynamicQueryCount(
				getKeywordSearchDynamicQuery(groupId, keywords));
	}
	private DynamicQuery getKeywordSearchDynamicQuery(
			long groupId, String keywords) {
		DynamicQuery dynamicQuery = dynamicQuery().add(
				RestrictionsFactoryUtil.eq("groupId", groupId));
		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery =
					RestrictionsFactoryUtil.disjunction();
			disjunctionQuery.add(
					RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(
					RestrictionsFactoryUtil.like(
							"description", "%" + keywords + "%"));
			dynamicQuery.add(disjunctionQuery);
		}
		return dynamicQuery;
	}

	@Override
	public Assignment addAssignment(Assignment assignment) {
		throw new UnsupportedOperationException("Not supported.");
	}
	@Override
	public Assignment updateAssignment(Assignment assignment) {
		throw new UnsupportedOperationException("Not supported.");
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return null;
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		return 0;
	}

	@Reference
	AssignmentValidator _assignmentValidator;

}