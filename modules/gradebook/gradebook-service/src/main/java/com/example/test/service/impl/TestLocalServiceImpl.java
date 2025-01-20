package com.example.test.service.impl;

import com.example.test.validator.TestValidator;
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
import com.liferay.training.gradebook.model.Test;
import com.liferay.training.gradebook.service.base.TestLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = "model.class.name=com.example.test.model.Test",
		service = AopService.class
)
public class TestLocalServiceImpl extends TestLocalServiceBaseImpl {

	public Test addTest(long groupId, String title, String description,
						Date dueDate, ServiceContext serviceContext) throws PortalException {

		// Validar los parámetros antes de continuar
		_testValidator.validate(title, description, dueDate);

		Group group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);

		long testId = counterLocalService.increment(Test.class.getName());

		Test test = createTest(testId);
		test.setCompanyId(group.getCompanyId());
		test.setCreateDate(serviceContext.getCreateDate(new Date()));
		test.setDueDate(dueDate);
		test.setDescription(description);
		test.setGroupId(groupId);
		test.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		test.setTitle(title);
		test.setUserId(userId);
		test.setUserName(user.getScreenName());

		return super.addTest(test);
	}

	public Test updateTest(long testId, String title, String description,
						   Date dueDate, ServiceContext serviceContext) throws PortalException {

		// Validar los parámetros antes de actualizar
		_testValidator.validate(title, description, dueDate);

		Test test = getTest(testId);
		test.setModifiedDate(new Date());
		test.setTitle(title);
		test.setDueDate(dueDate);
		test.setDescription(description);

		return super.updateTest(test);
	}

	public List<Test> getTestsByGroupId(long groupId) {
		return testPersistence.findByGroupId(groupId);
	}

	public List<Test> getTestsByKeywords(long groupId, String keywords, int start, int end,
										 OrderByComparator<Test> orderByComparator) {
		return testLocalService.dynamicQuery(
				getKeywordSearchDynamicQuery(groupId, keywords), start, end, orderByComparator);
	}

	public long getTestsCountByKeywords(long groupId, String keywords) {
		return testLocalService.dynamicQueryCount(getKeywordSearchDynamicQuery(groupId, keywords));
	}

	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));

		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
			disjunctionQuery.add(RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
			dynamicQuery.add(disjunctionQuery);
		}

		return dynamicQuery;
	}

	@Override
	public Test addTest(Test test) {
		throw new UnsupportedOperationException("Not supported.");
	}

	@Override
	public Test updateTest(Test test) {
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
	TestValidator _testValidator;

}
