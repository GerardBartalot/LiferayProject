/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.gradebook.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;
import com.liferay.training.gradebook.exception.NoSuchTestException;
import com.liferay.training.gradebook.model.Test;
import com.liferay.training.gradebook.service.TestLocalServiceUtil;
import com.liferay.training.gradebook.service.persistence.TestPersistence;
import com.liferay.training.gradebook.service.persistence.TestUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class TestPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"com.liferay.training.gradebook.service"));

	@Before
	public void setUp() {
		_persistence = TestUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Test> iterator = _tests.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Test test = _persistence.create(pk);

		Assert.assertNotNull(test);

		Assert.assertEquals(test.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Test newTest = addTest();

		_persistence.remove(newTest);

		Test existingTest = _persistence.fetchByPrimaryKey(
			newTest.getPrimaryKey());

		Assert.assertNull(existingTest);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTest();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Test newTest = _persistence.create(pk);

		newTest.setGroupId(RandomTestUtil.nextLong());

		newTest.setCompanyId(RandomTestUtil.nextLong());

		newTest.setUserId(RandomTestUtil.nextLong());

		newTest.setUserName(RandomTestUtil.randomString());

		newTest.setCreateDate(RandomTestUtil.nextDate());

		newTest.setModifiedDate(RandomTestUtil.nextDate());

		newTest.setTitle(RandomTestUtil.randomString());

		newTest.setDescription(RandomTestUtil.randomString());

		newTest.setDueDate(RandomTestUtil.nextDate());

		_tests.add(_persistence.update(newTest));

		Test existingTest = _persistence.findByPrimaryKey(
			newTest.getPrimaryKey());

		Assert.assertEquals(existingTest.getTestId(), newTest.getTestId());
		Assert.assertEquals(existingTest.getGroupId(), newTest.getGroupId());
		Assert.assertEquals(
			existingTest.getCompanyId(), newTest.getCompanyId());
		Assert.assertEquals(existingTest.getUserId(), newTest.getUserId());
		Assert.assertEquals(existingTest.getUserName(), newTest.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTest.getCreateDate()),
			Time.getShortTimestamp(newTest.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingTest.getModifiedDate()),
			Time.getShortTimestamp(newTest.getModifiedDate()));
		Assert.assertEquals(existingTest.getTitle(), newTest.getTitle());
		Assert.assertEquals(
			existingTest.getDescription(), newTest.getDescription());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTest.getDueDate()),
			Time.getShortTimestamp(newTest.getDueDate()));
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Test newTest = addTest();

		Test existingTest = _persistence.findByPrimaryKey(
			newTest.getPrimaryKey());

		Assert.assertEquals(existingTest, newTest);
	}

	@Test(expected = NoSuchTestException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Test> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Test_Test", "testId", true, "groupId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "title", true, "description", true, "dueDate",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Test newTest = addTest();

		Test existingTest = _persistence.fetchByPrimaryKey(
			newTest.getPrimaryKey());

		Assert.assertEquals(existingTest, newTest);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Test missingTest = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTest);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Test newTest1 = addTest();
		Test newTest2 = addTest();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTest1.getPrimaryKey());
		primaryKeys.add(newTest2.getPrimaryKey());

		Map<Serializable, Test> tests = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, tests.size());
		Assert.assertEquals(newTest1, tests.get(newTest1.getPrimaryKey()));
		Assert.assertEquals(newTest2, tests.get(newTest2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Test> tests = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(tests.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Test newTest = addTest();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTest.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Test> tests = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, tests.size());
		Assert.assertEquals(newTest, tests.get(newTest.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Test> tests = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(tests.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Test newTest = addTest();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTest.getPrimaryKey());

		Map<Serializable, Test> tests = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, tests.size());
		Assert.assertEquals(newTest, tests.get(newTest.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			TestLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Test>() {

				@Override
				public void performAction(Test test) {
					Assert.assertNotNull(test);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Test newTest = addTest();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Test.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("testId", newTest.getTestId()));

		List<Test> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Test existingTest = result.get(0);

		Assert.assertEquals(existingTest, newTest);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Test.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("testId", RandomTestUtil.nextLong()));

		List<Test> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Test newTest = addTest();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Test.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("testId"));

		Object newTestId = newTest.getTestId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("testId", new Object[] {newTestId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTestId = result.get(0);

		Assert.assertEquals(existingTestId, newTestId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Test.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("testId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"testId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Test addTest() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Test test = _persistence.create(pk);

		test.setGroupId(RandomTestUtil.nextLong());

		test.setCompanyId(RandomTestUtil.nextLong());

		test.setUserId(RandomTestUtil.nextLong());

		test.setUserName(RandomTestUtil.randomString());

		test.setCreateDate(RandomTestUtil.nextDate());

		test.setModifiedDate(RandomTestUtil.nextDate());

		test.setTitle(RandomTestUtil.randomString());

		test.setDescription(RandomTestUtil.randomString());

		test.setDueDate(RandomTestUtil.nextDate());

		_tests.add(_persistence.update(test));

		return test;
	}

	private List<Test> _tests = new ArrayList<Test>();
	private TestPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}