/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.example.test.service.persistence.impl;

import com.example.test.exception.NoSuchTestException;
import com.example.test.model.Test;
import com.example.test.model.TestTable;
import com.example.test.model.impl.TestImpl;
import com.example.test.model.impl.TestModelImpl;
import com.example.test.service.persistence.TestPersistence;
import com.example.test.service.persistence.TestUtil;
import com.example.test.service.persistence.impl.constants.TestPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the test service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Gerard Bartalot
 * @generated
 */
@Component(service = TestPersistence.class)
public class TestPersistenceImpl
	extends BasePersistenceImpl<Test> implements TestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TestUtil</code> to access the test persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TestImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public TestPersistenceImpl() {
		setModelClass(Test.class);

		setModelImplClass(TestImpl.class);
		setModelPKClass(long.class);

		setTable(TestTable.INSTANCE);
	}

	/**
	 * Caches the test in the entity cache if it is enabled.
	 *
	 * @param test the test
	 */
	@Override
	public void cacheResult(Test test) {
		entityCache.putResult(TestImpl.class, test.getPrimaryKey(), test);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the tests in the entity cache if it is enabled.
	 *
	 * @param tests the tests
	 */
	@Override
	public void cacheResult(List<Test> tests) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (tests.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Test test : tests) {
			if (entityCache.getResult(TestImpl.class, test.getPrimaryKey()) ==
					null) {

				cacheResult(test);
			}
		}
	}

	/**
	 * Clears the cache for all tests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TestImpl.class);

		finderCache.clearCache(TestImpl.class);
	}

	/**
	 * Clears the cache for the test.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Test test) {
		entityCache.removeResult(TestImpl.class, test);
	}

	@Override
	public void clearCache(List<Test> tests) {
		for (Test test : tests) {
			entityCache.removeResult(TestImpl.class, test);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TestImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TestImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new test with the primary key. Does not add the test to the database.
	 *
	 * @param testId the primary key for the new test
	 * @return the new test
	 */
	@Override
	public Test create(long testId) {
		Test test = new TestImpl();

		test.setNew(true);
		test.setPrimaryKey(testId);

		test.setCompanyId(CompanyThreadLocal.getCompanyId());

		return test;
	}

	/**
	 * Removes the test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param testId the primary key of the test
	 * @return the test that was removed
	 * @throws NoSuchTestException if a test with the primary key could not be found
	 */
	@Override
	public Test remove(long testId) throws NoSuchTestException {
		return remove((Serializable)testId);
	}

	/**
	 * Removes the test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the test
	 * @return the test that was removed
	 * @throws NoSuchTestException if a test with the primary key could not be found
	 */
	@Override
	public Test remove(Serializable primaryKey) throws NoSuchTestException {
		Session session = null;

		try {
			session = openSession();

			Test test = (Test)session.get(TestImpl.class, primaryKey);

			if (test == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(test);
		}
		catch (NoSuchTestException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Test removeImpl(Test test) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(test)) {
				test = (Test)session.get(
					TestImpl.class, test.getPrimaryKeyObj());
			}

			if (test != null) {
				session.delete(test);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (test != null) {
			clearCache(test);
		}

		return test;
	}

	@Override
	public Test updateImpl(Test test) {
		boolean isNew = test.isNew();

		if (!(test instanceof TestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(test.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(test);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in test proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Test implementation " +
					test.getClass());
		}

		TestModelImpl testModelImpl = (TestModelImpl)test;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (test.getCreateDate() == null)) {
			if (serviceContext == null) {
				test.setCreateDate(date);
			}
			else {
				test.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!testModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				test.setModifiedDate(date);
			}
			else {
				test.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(test);
			}
			else {
				test = (Test)session.merge(test);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(TestImpl.class, test, false, true);

		if (isNew) {
			test.setNew(false);
		}

		test.resetOriginalValues();

		return test;
	}

	/**
	 * Returns the test with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the test
	 * @return the test
	 * @throws NoSuchTestException if a test with the primary key could not be found
	 */
	@Override
	public Test findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTestException {

		Test test = fetchByPrimaryKey(primaryKey);

		if (test == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return test;
	}

	/**
	 * Returns the test with the primary key or throws a <code>NoSuchTestException</code> if it could not be found.
	 *
	 * @param testId the primary key of the test
	 * @return the test
	 * @throws NoSuchTestException if a test with the primary key could not be found
	 */
	@Override
	public Test findByPrimaryKey(long testId) throws NoSuchTestException {
		return findByPrimaryKey((Serializable)testId);
	}

	/**
	 * Returns the test with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param testId the primary key of the test
	 * @return the test, or <code>null</code> if a test with the primary key could not be found
	 */
	@Override
	public Test fetchByPrimaryKey(long testId) {
		return fetchByPrimaryKey((Serializable)testId);
	}

	/**
	 * Returns all the tests.
	 *
	 * @return the tests
	 */
	@Override
	public List<Test> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Test> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Test> findAll(
		int start, int end, OrderByComparator<Test> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Test> findAll(
		int start, int end, OrderByComparator<Test> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Test> list = null;

		if (useFinderCache) {
			list = (List<Test>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TEST;

				sql = sql.concat(TestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Test>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the tests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Test test : findAll()) {
			remove(test);
		}
	}

	/**
	 * Returns the number of tests.
	 *
	 * @return the number of tests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TEST);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "testId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the test persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		TestUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		TestUtil.setPersistence(null);

		entityCache.removeCache(TestImpl.class.getName());
	}

	@Override
	@Reference(
		target = TestPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = TestPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = TestPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TEST = "SELECT test FROM Test test";

	private static final String _SQL_COUNT_TEST =
		"SELECT COUNT(test) FROM Test test";

	private static final String _ORDER_BY_ENTITY_ALIAS = "test.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Test exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		TestPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}