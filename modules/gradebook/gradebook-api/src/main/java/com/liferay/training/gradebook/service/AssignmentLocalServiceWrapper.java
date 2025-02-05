/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.gradebook.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AssignmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentLocalService
 * @generated
 */
public class AssignmentLocalServiceWrapper
	implements AssignmentLocalService, ServiceWrapper<AssignmentLocalService> {

	public AssignmentLocalServiceWrapper() {
		this(null);
	}

	public AssignmentLocalServiceWrapper(
		AssignmentLocalService assignmentLocalService) {

		_assignmentLocalService = assignmentLocalService;
	}

	/**
	 * Adds the assignment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param assignment the assignment
	 * @return the assignment that was added
	 */
	@Override
	public com.liferay.training.gradebook.model.Assignment addAssignment(
		com.liferay.training.gradebook.model.Assignment assignment) {

		return _assignmentLocalService.addAssignment(assignment);
	}

	@Override
	public com.liferay.training.gradebook.model.Assignment addAssignment(
			long groupId, java.util.Map<java.util.Locale, String> titleMap,
			String description, java.util.Date dueDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assignmentLocalService.addAssignment(
			groupId, titleMap, description, dueDate, serviceContext);
	}

	/**
	 * Creates a new assignment with the primary key. Does not add the assignment to the database.
	 *
	 * @param assignmentId the primary key for the new assignment
	 * @return the new assignment
	 */
	@Override
	public com.liferay.training.gradebook.model.Assignment createAssignment(
		long assignmentId) {

		return _assignmentLocalService.createAssignment(assignmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assignmentLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the assignment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param assignment the assignment
	 * @return the assignment that was removed
	 */
	@Override
	public com.liferay.training.gradebook.model.Assignment deleteAssignment(
		com.liferay.training.gradebook.model.Assignment assignment) {

		return _assignmentLocalService.deleteAssignment(assignment);
	}

	/**
	 * Deletes the assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param assignmentId the primary key of the assignment
	 * @return the assignment that was removed
	 * @throws PortalException if a assignment with the primary key could not be found
	 */
	@Override
	public com.liferay.training.gradebook.model.Assignment deleteAssignment(
			long assignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assignmentLocalService.deleteAssignment(assignmentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assignmentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _assignmentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _assignmentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _assignmentLocalService.dynamicQuery();
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

		return _assignmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.gradebook.model.impl.AssignmentModelImpl</code>.
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

		return _assignmentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.gradebook.model.impl.AssignmentModelImpl</code>.
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

		return _assignmentLocalService.dynamicQuery(
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

		return _assignmentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _assignmentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.training.gradebook.model.Assignment fetchAssignment(
		long assignmentId) {

		return _assignmentLocalService.fetchAssignment(assignmentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _assignmentLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the assignment with the primary key.
	 *
	 * @param assignmentId the primary key of the assignment
	 * @return the assignment
	 * @throws PortalException if a assignment with the primary key could not be found
	 */
	@Override
	public com.liferay.training.gradebook.model.Assignment getAssignment(
			long assignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assignmentLocalService.getAssignment(assignmentId);
	}

	/**
	 * Returns a range of all the assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.gradebook.model.impl.AssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of assignments
	 * @param end the upper bound of the range of assignments (not inclusive)
	 * @return the range of assignments
	 */
	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment>
		getAssignments(int start, int end) {

		return _assignmentLocalService.getAssignments(start, end);
	}

	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment>
		getAssignmentsByGroupId(long groupId) {

		return _assignmentLocalService.getAssignmentsByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment>
		getAssignmentsByGroupId(long groupId, int start, int end) {

		return _assignmentLocalService.getAssignmentsByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment>
		getAssignmentsByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.training.gradebook.model.Assignment>
					orderByComparator) {

		return _assignmentLocalService.getAssignmentsByGroupId(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.training.gradebook.model.Assignment>
		getAssignmentsByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.training.gradebook.model.Assignment>
					orderByComparator) {

		return _assignmentLocalService.getAssignmentsByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	/**
	 * Returns the number of assignments.
	 *
	 * @return the number of assignments
	 */
	@Override
	public int getAssignmentsCount() {
		return _assignmentLocalService.getAssignmentsCount();
	}

	@Override
	public long getAssignmentsCountByKeywords(long groupId, String keywords) {
		return _assignmentLocalService.getAssignmentsCountByKeywords(
			groupId, keywords);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _assignmentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _assignmentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assignmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the assignment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AssignmentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param assignment the assignment
	 * @return the assignment that was updated
	 */
	@Override
	public com.liferay.training.gradebook.model.Assignment updateAssignment(
		com.liferay.training.gradebook.model.Assignment assignment) {

		return _assignmentLocalService.updateAssignment(assignment);
	}

	@Override
	public com.liferay.training.gradebook.model.Assignment updateAssignment(
			long assignmentId, java.util.Map<java.util.Locale, String> titleMap,
			String description, java.util.Date dueDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _assignmentLocalService.updateAssignment(
			assignmentId, titleMap, description, dueDate, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _assignmentLocalService.getBasePersistence();
	}

	@Override
	public AssignmentLocalService getWrappedService() {
		return _assignmentLocalService;
	}

	@Override
	public void setWrappedService(
		AssignmentLocalService assignmentLocalService) {

		_assignmentLocalService = assignmentLocalService;
	}

	private AssignmentLocalService _assignmentLocalService;

}