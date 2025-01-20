/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.training.gradebook.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class TestValidationException extends PortalException {

	public TestValidationException() {
	}

	public TestValidationException(String msg) {
		super(msg);
	}

	public TestValidationException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public TestValidationException(Throwable throwable) {
		super(throwable);
	}

    public Iterable<Object> getErrors() {
        return null;
    }
}