/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.example.test.model.impl;

import com.example.test.model.Test;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Test in entity cache.
 *
 * @author Gerard Bartalot
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
		StringBundler sb = new StringBundler(27);

		sb.append("{testId=");
		sb.append(testId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", testDate=");
		sb.append(testDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Test toEntityModel() {
		TestImpl testImpl = new TestImpl();

		testImpl.setTestId(testId);

		if (name == null) {
			testImpl.setName("");
		}
		else {
			testImpl.setName(name);
		}

		if (description == null) {
			testImpl.setDescription("");
		}
		else {
			testImpl.setDescription(description);
		}

		if (testDate == Long.MIN_VALUE) {
			testImpl.setTestDate(null);
		}
		else {
			testImpl.setTestDate(new Date(testDate));
		}

		testImpl.setStatus(status);
		testImpl.setCompanyId(companyId);
		testImpl.setGroupId(groupId);
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

		testImpl.setPriority(priority);

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
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		testDate = objectInput.readLong();

		status = objectInput.readInt();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		priority = objectInput.readInt();
		dueDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(testId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(testDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(priority);
		objectOutput.writeLong(dueDate);
	}

	public long testId;
	public String name;
	public String description;
	public long testDate;
	public int status;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int priority;
	public long dueDate;

}