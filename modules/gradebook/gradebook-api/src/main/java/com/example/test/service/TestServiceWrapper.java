/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.example.test.service;

import com.example.test.model.Test;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Collections;
import java.util.List;

/**
 * Provides a wrapper for {@link TestService}.
 *
 * @author Gerard Bartalot
 * @see TestService
 * @generated
 */
public class TestServiceWrapper
	implements ServiceWrapper<TestService>, TestService {

	public TestServiceWrapper() {
		this(null);
	}

	public TestServiceWrapper(TestService testService) {
		_testService = testService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _testService.getOSGiServiceIdentifier();
	}

	@Override
	public List<Test> getAssignmentsByKeywords(long scopeGroupId, String keywords, int start, int end, OrderByComparator<Test> comparator) {
		return Collections.emptyList();
	}

	@Override
	public Object getAssignmentsCountByKeywords(long scopeGroupId, String keywords) {
		return null;
	}

	@Override
	public Test getAssignment(long assignmentId) {
		return null;
	}

	@Override
	public TestService getWrappedService() {
		return _testService;
	}

	@Override
	public void setWrappedService(TestService testService) {
		_testService = testService;
	}

	private TestService _testService;

}