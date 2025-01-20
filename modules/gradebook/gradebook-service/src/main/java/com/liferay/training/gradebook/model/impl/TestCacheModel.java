/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.gradebook.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.training.gradebook.model.Test;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Test in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TestCacheModel implements CacheModel<Test>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TestCacheModel)) {
			return false;
		}

		TestCacheModel testCacheModel = (TestCacheModel)object;

		if (testId == testCacheModel.testId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, testId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{testId=");
		sb.append(testId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Test toEntityModel() {
		TestImpl testImpl = new TestImpl();

		testImpl.setTestId(testId);
		testImpl.setGroupId(groupId);
		testImpl.setCompanyId(companyId);
		testImpl.setUserId(userId);

		if (userName == null) {
			testImpl.setUserName("");
		}
		else {
			testImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			testImpl.setCreateDate(null);
		}
		else {
			testImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			testImpl.setModifiedDate(null);
		}
		else {
			testImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			testImpl.setTitle("");
		}
		else {
			testImpl.setTitle(title);
		}

		if (description == null) {
			testImpl.setDescription("");
		}
		else {
			testImpl.setDescription(description);
		}

		if (dueDate == Long.MIN_VALUE) {
			testImpl.setDueDate(null);
		}
		else {
			testImpl.setDueDate(new Date(dueDate));
		}

		testImpl.resetOriginalValues();

		return testImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		testId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		dueDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(testId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(dueDate);
	}

	public long testId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public long dueDate;

}