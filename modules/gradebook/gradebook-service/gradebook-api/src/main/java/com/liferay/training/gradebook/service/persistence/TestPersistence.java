/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.training.gradebook.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.training.gradebook.exception.NoSuchTestException;
import com.liferay.training.gradebook.model.Test;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the test service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TestUtil
 * @generated
 */
@ProviderType
public interface TestPersistence extends BasePersistence<Test> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TestUtil} to access the test persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the tests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tests
	 */
	public java.util.List<Test> findByGroupId(long groupId);

	/**
	 * Returns a range of all the tests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tests
	 * @param end the upper bound of the range of tests (not inclusive)
	 * @return the range of matching tests
	 */
	public java.util.List<Test> findByGroupId(long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the tests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tests
	 * @param end the upper bound of the range of tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tests
	 */
	public java.util.List<Test> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Test>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tests
	 * @param end the upper bound of the range of tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tests
	 */
	public java.util.List<Test> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Test>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first test in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching test
	 * @throws NoSuchTestException if a matching test could not be found
	 */
	public Test findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Test>
				orderByComparator)
		throws NoSuchTestException;

	/**
	 * Returns the first test in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching test, or <code>null</code> if a matching test could not be found
	 */
	public Test fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Test>
			orderByComparator);

	/**
	 * Returns the last test in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching test
	 * @throws NoSuchTestException if a matching test could not be found
	 */
	public Test findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Test>
				orderByComparator)
		throws NoSuchTestException;

	/**
	 * Returns the last test in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching test, or <code>null</code> if a matching test could not be found
	 */
	public Test fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Test>
			orderByComparator);

	/**
	 * Returns the tests before and after the current test in the ordered set where groupId = &#63;.
	 *
	 * @param testId the primary key of the current test
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next test
	 * @throws NoSuchTestException if a test with the primary key could not be found
	 */
	public Test[] findByGroupId_PrevAndNext(
			long testId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Test>
				orderByComparator)
		throws NoSuchTestException;

	/**
	 * Removes all the tests where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of tests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tests
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the test in the entity cache if it is enabled.
	 *
	 * @param test the test
	 */
	public void cacheResult(Test test);

	/**
	 * Caches the tests in the entity cache if it is enabled.
	 *
	 * @param tests the tests
	 */
	public void cacheResult(java.util.List<Test> tests);

	/**
	 * Creates a new test with the primary key. Does not add the test to the database.
	 *
	 * @param testId the primary key for the new test
	 * @return the new test
	 */
	public Test create(long testId);

	/**
	 * Removes the test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param testId the primary key of the test
	 * @return the test that was removed
	 * @throws NoSuchTestException if a test with the primary key could not be found
	 */
	public Test remove(long testId) throws NoSuchTestException;

	public Test updateImpl(Test test);

	/**
	 * Returns the test with the primary key or throws a <code>NoSuchTestException</code> if it could not be found.
	 *
	 * @param testId the primary key of the test
	 * @return the test
	 * @throws NoSuchTestException if a test with the primary key could not be found
	 */
	public Test findByPrimaryKey(long testId) throws NoSuchTestException;

	/**
	 * Returns the test with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param testId the primary key of the test
	 * @return the test, or <code>null</code> if a test with the primary key could not be found
	 */
	public Test fetchByPrimaryKey(long testId);

	/**
	 * Returns all the tests.
	 *
	 * @return the tests
	 */
	public java.util.List<Test> findAll();

	/**
	 * Returns a range of all the tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tests
	 * @param end the upper bound of the range of tests (not inclusive)
	 * @return the range of tests
	 */
	public java.util.List<Test> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tests
	 * @param end the upper bound of the range of tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tests
	 */
	public java.util.List<Test> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Test>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tests
	 * @param end the upper bound of the range of tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tests
	 */
	public java.util.List<Test> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Test>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the tests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tests.
	 *
	 * @return the number of tests
	 */
	public int countAll();

}