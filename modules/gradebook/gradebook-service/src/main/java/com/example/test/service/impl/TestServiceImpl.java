package com.example.test.service.impl;

import com.example.test.model.Test;
import com.example.test.service.base.TestServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;
import java.util.Date;

public class TestServiceImpl extends TestServiceBaseImpl {

	// Obtener Test por testId
	public Test getTest(long testId) throws PortalException {
		return testLocalService.getTest(testId);
	}

	// Obtener los Tests por groupId
	public List<Test> getTestsByGroupId(long groupId) {
		return testLocalService.findByGroupId(groupId);
	}

	// Obtener Tests por palabras clave
	public List<Test> getTestsByKeywords(long groupId, String keywords, int start, int end, OrderByComparator<Test> orderByComparator) {
		return testLocalService.getTestsByKeywords(groupId, keywords, start, end, orderByComparator);
	}

	// Obtener la cantidad de Tests por palabras clave
	public long getTestsCountByKeywords(long groupId, String keywords) {
		return testLocalService.getTestsCountByKeywords(groupId, keywords);
	}

	// Actualizar Test
	public Test updateTest(long testId, String title, String description, Date dueDate, ServiceContext serviceContext) throws PortalException {
		return testLocalService.updateTest(testId, title, description, dueDate, serviceContext);  // Llamada correcta al servicio local
	}

	// Crear un nuevo Test
	public Test addTest(long groupId, String title, String description, Date dueDate, ServiceContext serviceContext) throws PortalException {
		return testLocalService.addTest(groupId, title, description, dueDate, serviceContext);  // Llamada correcta al servicio local
	}

	// Eliminar Test
	public Test deleteTest(long testId) throws PortalException {
		Test test = testLocalService.getTest(testId);  // Obtener el Test
		return testLocalService.deleteTest(test);  // Llamada a la eliminación
	}
}