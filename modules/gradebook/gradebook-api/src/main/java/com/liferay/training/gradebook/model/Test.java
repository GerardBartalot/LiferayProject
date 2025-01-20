/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.gradebook.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Test service. Represents a row in the &quot;Test_Test&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TestModel
 * @generated
 */
@ImplementationClassName("com.liferay.training.gradebook.model.impl.TestImpl")
@ProviderType
public interface Test extends PersistedModel, TestModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.training.gradebook.model.impl.TestImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Test, Long> TEST_ID_ACCESSOR =
		new Accessor<Test, Long>() {

			@Override
			public Long get(Test test) {
				return test.getTestId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Test> getTypeClass() {
				return Test.class;
			}

		};

}