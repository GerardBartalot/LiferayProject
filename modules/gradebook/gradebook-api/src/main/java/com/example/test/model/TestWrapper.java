/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.example.test.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Test}.
 * </p>
 *
 * @author Gerard Bartalot
 * @see Test
 * @generated
 */
public class TestWrapper
	extends BaseModelWrapper<Test> implements ModelWrapper<Test>, Test {

	public TestWrapper(Test test) {
		super(test);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("testId", getTestId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("testDate", getTestDate());
		attributes.put("status", getStatus());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("priority", getPriority());
		attributes.put("dueDate", getDueDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long testId = (Long)attributes.get("testId");

		if (testId != null) {
			setTestId(testId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date testDate = (Date)attributes.get("testDate");

		if (testDate != null) {
			setTestDate(testDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}
	}

	@Override
	public Test cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this test.
	 *
	 * @return the company ID of this test
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this test.
	 *
	 * @return the create date of this test
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this test.
	 *
	 * @return the description of this test
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the due date of this test.
	 *
	 * @return the due date of this test
	 */
	@Override
	public Date getDueDate() {
		return model.getDueDate();
	}

	/**
	 * Returns the group ID of this test.
	 *
	 * @return the group ID of this test
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this test.
	 *
	 * @return the modified date of this test
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this test.
	 *
	 * @return the name of this test
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this test.
	 *
	 * @return the primary key of this test
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this test.
	 *
	 * @return the priority of this test
	 */
	@Override
	public Integer getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the status of this test.
	 *
	 * @return the status of this test
	 */
	@Override
	public Integer getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the test date of this test.
	 *
	 * @return the test date of this test
	 */
	@Override
	public Date getTestDate() {
		return model.getTestDate();
	}

	/**
	 * Returns the test ID of this test.
	 *
	 * @return the test ID of this test
	 */
	@Override
	public long getTestId() {
		return model.getTestId();
	}

	/**
	 * Returns the user ID of this test.
	 *
	 * @return the user ID of this test
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this test.
	 *
	 * @return the user name of this test
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this test.
	 *
	 * @return the user uuid of this test
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this test.
	 *
	 * @param companyId the company ID of this test
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this test.
	 *
	 * @param createDate the create date of this test
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this test.
	 *
	 * @param description the description of this test
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the due date of this test.
	 *
	 * @param dueDate the due date of this test
	 */
	@Override
	public void setDueDate(Date dueDate) {
		model.setDueDate(dueDate);
	}

	/**
	 * Sets the group ID of this test.
	 *
	 * @param groupId the group ID of this test
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this test.
	 *
	 * @param modifiedDate the modified date of this test
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this test.
	 *
	 * @param name the name of this test
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this test.
	 *
	 * @param primaryKey the primary key of this test
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this test.
	 *
	 * @param priority the priority of this test
	 */
	@Override
	public void setPriority(Integer priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the status of this test.
	 *
	 * @param status the status of this test
	 */
	@Override
	public void setStatus(Integer status) {
		model.setStatus(status);
	}

	/**
	 * Sets the test date of this test.
	 *
	 * @param testDate the test date of this test
	 */
	@Override
	public void setTestDate(Date testDate) {
		model.setTestDate(testDate);
	}

	/**
	 * Sets the test ID of this test.
	 *
	 * @param testId the test ID of this test
	 */
	@Override
	public void setTestId(long testId) {
		model.setTestId(testId);
	}

	/**
	 * Sets the user ID of this test.
	 *
	 * @param userId the user ID of this test
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this test.
	 *
	 * @param userName the user name of this test
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this test.
	 *
	 * @param userUuid the user uuid of this test
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected TestWrapper wrap(Test test) {
		return new TestWrapper(test);
	}

}