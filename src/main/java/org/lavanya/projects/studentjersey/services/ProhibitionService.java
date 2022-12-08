package org.lavanya.projects.studentjersey.services;

import java.util.List;

import org.lavanya.projects.studentjersey.exceptions.PMException;
import org.lavanya.projects.studentjersey.models.Prohibition;
import org.lavanya.projects.studentjersey.mysql.MySQLStore;

public class ProhibitionService {
	MySQLStore store = new MySQLStore();
	
	public void add(Prohibition prohibition) throws PMException {
		System.out.println("entered service");
		store.add(prohibition);
	}

	public List<Prohibition> getAll() throws PMException {
		return store.getAll();
	}

	public Prohibition get(String prohibitionName) throws PMException {
		return store.get(prohibitionName);
	}

	public List<Prohibition> getProhibitionsFor(String subject) throws PMException {
		return store.getProhibitionsFor(subject);
	}

	public void update(String prohibitionName, Prohibition prohibition) throws PMException {
		store.update(prohibitionName, prohibition);
		
	}

	public void delete(String prohibitionName) throws PMException {
		store.delete(prohibitionName);
	}
}
