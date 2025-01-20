/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.example.test.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Dylan Navarro
 */
public class NoSuchTestException extends NoSuchModelException {

	public NoSuchTestException() {
	}

	public NoSuchTestException(String msg) {
		super(msg);
	}

	public NoSuchTestException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchTestException(Throwable throwable) {
		super(throwable);
	}

}