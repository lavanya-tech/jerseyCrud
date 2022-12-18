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
		Prohibition p_added = new Prohibition("Lavanya","subject3",new OperationSet("has_access"));
		int id = service.add(p_added);
		assertNotNull(service.get(id));
		Prohibition p_found = service.get(id);
		assertEquals(p_added.getName(),p_found.getName());
		assertEquals(p_added.getOperations(),p_found.getOperations());
		assertEquals(p_added.getSubject(),p_found.getSubject());
	}
	
	@Test
	void testAddwithNameNull() throws PMException {
		Prohibition p_added = new Prohibition(null,"subject3",new OperationSet("has_access"));
		Exception exception = assertThrows(Exception.class, () -> service.add(p_added));
		assertEquals("no name was provided when creating a prohibition", exception.getMessage());
	}
	
	@Test
	void testAddwithSubjectNull() throws PMException {
		Prohibition p_added = new Prohibition("pavani",null,new OperationSet("has_access"));
		Exception exception = assertThrows(Exception.class, () -> service.add(p_added));
		assertEquals("no subject was provided when creating a prohibition", exception.getMessage());
	}

	@Test
	void testAddwithOperationInvalid() throws PMException {
		Prohibition p_added = new Prohibition("pavan","subject3",new OperationSet("invalid"));
		Exception exception = assertThrows(Exception.class, () -> service.add(p_added));
		assertEquals("invalid operations were provided when creating a prohibition", exception.getMessage());
	}

	@Test
	void testAddwithOperationNull() throws PMException {
		Prohibition p_added = new Prohibition("sravani","subject3",null);
		Exception exception = assertThrows(Exception.class, () -> service.add(p_added));
		assertEquals("no operations were provided when creating a prohibition", exception.getMessage());
	}
	
	@Test
	void testGetAll() throws PMException {
		assertNotNull(service.getAll());
	}

	@Test
	void testGet() throws PMException {
		Prohibition p_added = new Prohibition("Nidhi","subject4",new OperationSet("no_access"));
		int id = service.add(p_added);
		assertNotNull(service.get(id));
		Prohibition p_found = service.get(id);
		assertEquals(p_added.getName(),p_found.getName());
		assertEquals(p_added.getOperations(),p_found.getOperations());
		assertEquals(p_added.getSubject(),p_found.getSubject());
	}

	@Test
	void testGetProhibitionsFor() throws PMException {
		Prohibition p_added = new Prohibition("Nithya","subject10",new OperationSet("has_access"));
		service.add(p_added);
		assertNotEquals(0,service.getProhibitionsFor(p_added.getSubject()).size());
	}

	@Test
	void testUpdate() throws PMException {
		Prohibition p_added = new Prohibition("ram","subject9",new OperationSet("no_access"));
		int id = service.add(p_added);
		p_added.setOperations(new OperationSet("has_access"));
		service.update(id, p_added);
		assertEquals(service.get(id).getOperations(),p_added.getOperations());
	}

	@Test
	void testDelete() throws PMException {
		Prohibition p_added = new Prohibition("saranya","subject3",new OperationSet("has_access"));
		int id = service.add(p_added);
		service.delete(id);
		Exception exception = assertThrows(Exception.class, () -> service.get(id));
		assertEquals("Invalid Id", exception.getMessage());
	}

}
