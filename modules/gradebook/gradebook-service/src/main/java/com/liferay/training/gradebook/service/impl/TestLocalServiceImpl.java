/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.gradebook.service.impl;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.training.gradebook.service.base.TestLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.training.gradebook.model.Test",
	service = AopService.class
)
public class TestLocalServiceImpl extends TestLocalServiceBaseImpl {
	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return null;
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		return 0;
	}
}