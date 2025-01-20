/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.example.test.service;

import com.example.test.model.Test;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.liferay.portal.kernel.util.OrderByComparator;
import org.osgi.annotation.versioning.ProviderType;

import java.util.Date;
import java.util.List;

/**
 * Provides the remote service interface for Test. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Gerard Bartalot
 * @see TestServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TestService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.example.test.service.impl.TestServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the test remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TestServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	List<Test> getAssignmentsByKeywords(long scopeGroupId, String keywords, int start, int end, OrderByComparator<Test> comparator);

	Object getAssignmentsCountByKeywords(long scopeGroupId, String keywords);

	Test getAssignment(long assignmentId);

	void addAssignment(long scopeGroupId, String title, String description, Date dueDate, ServiceContext serviceContext);

	void updateAssignment(long assignmentId, String title, String description, Date dueDate, ServiceContext serviceContext);

	void deleteAssignment(long assignmentId);
}