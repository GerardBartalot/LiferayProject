/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.gradebook.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TestService}.
 *
 * @author Brian Wing Shun Chan
 * @see TestService
 * @generated
 */
public class TestServiceWrapper
	implements ServiceWrapper<TestService>, TestService {

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
	public TestService getWrappedService() {
		return _testService;
	}

	@Override
	public void setWrappedService(TestService testService) {
		_testService = testService;
	}

	private TestService _testService;

}