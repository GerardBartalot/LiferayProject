/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.gradebook.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link TestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TestLocalService
 * @generated
 */
public class TestLocalServiceWrapper
	implements ServiceWrapper<TestLocalService>, TestLocalService {

	public TestLocalServiceWrapper(TestLocalService testLocalService) {
		_testLocalService = testLocalService;
	}

	/**
	 * Adds the test to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param test the test
	 * @return the test that was added
	 */
	@Override
	public com.liferay.training.gradebook.model.Test addTest(
		com.liferay.training.gradebook.model.Test test) {

		return _testLocalService.addTest(test);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _testLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new test with the primary key. Does not add the test to the database.
	 *
	 * @param testId the primary key for the new test
	 * @return the new test
	 */
	@Override
	public com.liferay.training.gradebook.model.Test createTest(long testId) {
		return _testLocalService.createTest(testId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _testLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param testId the primary key of the test
	 * @return the test that was removed
	 * @throws PortalException if a test with the primary key could not be found
	 */
	@Override
	public com.liferay.training.gradebook.model.Test deleteTest(long testId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _testLocalService.deleteTest(testId);
	}

	/**
	 * Deletes the test from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param test the test
	 * @return the test that was removed
	 */
	@Override
	public com.liferay.training.gradebook.model.Test deleteTest(
		com.liferay.training.gradebook.model.Test test) {

		return _testLocalService.deleteTest(test);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _testLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _testLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _testLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _testLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.gradebook.model.impl.TestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _testLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.gradebook.model.impl.TestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _testLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _testLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _testLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.training.gradebook.model.Test fetchTest(long testId) {
		return _testLocalService.fetchTest(testId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _testLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _testLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _testLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _testLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the test with the primary key.
	 *
	 * @param testId the primary key of the test
	 * @return the test
	 * @throws PortalException if a test with the primary key could not be found
	 */
	@Override
	public com.liferay.training.gradebook.model.Test getTest(long testId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _testLocalService.getTest(testId);
	}

	/**
	 * Returns a range of all the tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.gradebook.model.impl.TestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tests
	 * @param end the upper bound of the range of tests (not inclusive)
	 * @return the range of tests
	 */
	@Override
	public java.util.List<com.liferay.training.gradebook.model.Test> getTests(
		int start, int end) {

		return _testLocalService.getTests(start, end);
	}

	/**
	 * Returns the number of tests.
	 *
	 * @return the number of tests
	 */
	@Override
	public int getTestsCount() {
		return _testLocalService.getTestsCount();
	}

	/**
	 * Updates the test in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param test the test
	 * @return the test that was updated
	 */
	@Override
	public com.liferay.training.gradebook.model.Test updateTest(
		com.liferay.training.gradebook.model.Test test) {

		return _testLocalService.updateTest(test);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _testLocalService.getBasePersistence();
	}

	@Override
	public TestLocalService getWrappedService() {
		return _testLocalService;
	}

	@Override
	public void setWrappedService(TestLocalService testLocalService) {
		_testLocalService = testLocalService;
	}

	private TestLocalService _testLocalService;

}