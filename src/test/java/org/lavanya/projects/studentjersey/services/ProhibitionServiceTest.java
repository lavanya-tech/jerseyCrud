package org.lavanya.projects.studentjersey.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.lavanya.projects.studentjersey.exceptions.PMException;
import org.lavanya.projects.studentjersey.models.Prohibition;
import org.lavanya.projects.studentjersey.operations.OperationSet;

class ProhibitionServiceTest {

	private ProhibitionService service = new ProhibitionService();

	@Test
	void testAdd() throws PMException {
		String name = "Lavanya";
		String subject = "subject3";
		OperationSet operations = new OperationSet("has_access");
		int id = service.add(name, subject, operations);
		assertNotNull(service.get(id));
		Prohibition p_found = service.get(id);
		assertEquals(name, p_found.getName());
		assertEquals(operations, p_found.getOperations());
		assertEquals(subject, p_found.getSubject());
	}

	@Test
	void testAddwithNameNull() throws PMException {
		String name = null;
		String subject = "subject3";
		OperationSet operations = new OperationSet("has_access");
		Exception exception = assertThrows(Exception.class, () -> service.add(name, subject, operations));
		assertEquals("no name was provided when creating a prohibition", exception.getMessage());
	}

	@Test
	void testAddwithSubjectNull() throws PMException {
		String name = "pavani";
		String subject = null;
		OperationSet operations = new OperationSet("has_access");
		Exception exception = assertThrows(Exception.class, () -> service.add(name, subject, operations));
		assertEquals("no subject was provided when creating a prohibition", exception.getMessage());
	}

	@Test
	void testAddwithOperationInvalid() throws PMException {
		String name = "pavan";
		String subject = "subject3";
		OperationSet operations = new OperationSet("invalid");
		Exception exception = assertThrows(Exception.class, () -> service.add(name, subject, operations));
		assertEquals("invalid operations were provided when creating a prohibition", exception.getMessage());
	}

	@Test
	void testAddwithOperationNull() throws PMException {
		String name = "sravani";
		String subject = "subject3";
		OperationSet operations = null;
		Exception exception = assertThrows(Exception.class, () -> service.add(name, subject, operations));
		assertEquals("no operations were provided when creating a prohibition", exception.getMessage());
	}

	@Test
	void testGetAll() throws PMException {
		assertNotNull(service.getAll());
	}

	@Test
	void testGet() throws PMException {
		String name = "Nidhi";
		String subject = "subject4";
		OperationSet operations = new OperationSet("no_access");
		int id = service.add(name, subject, operations);
		assertNotNull(service.get(id));
		Prohibition p_found = service.get(id);
		assertEquals(name, p_found.getName());
		assertEquals(operations, p_found.getOperations());
		assertEquals(subject, p_found.getSubject());
	}

	@Test
	void testGetProhibitionsFor() throws PMException {
		String name = "nithya";
		String subject = "subject10";
		OperationSet operations = new OperationSet("has_access");
		service.add(name, subject, operations);
		assertNotEquals(0, service.getProhibitionsFor(subject).size());
	}

	@Test
	void testUpdate() throws PMException {
		String name = "ram";
		String subject = "subject9";
		OperationSet operations = new OperationSet("no_access");
		int id = service.add(name, subject, operations);
		operations = new OperationSet("has_access");
		service.update(id, name, subject, operations);
		assertEquals(service.get(id).getOperations(), operations);
	}

	@Test
	void testDelete() throws PMException {
		String name = "saranya";
		String subject = "subject3";
		OperationSet operations = new OperationSet("has_access");
		int id = service.add(name, subject, operations);
		service.delete(id);
		Exception exception = assertThrows(Exception.class, () -> service.get(id));
		assertEquals("Invalid Id", exception.getMessage());
	}

}
