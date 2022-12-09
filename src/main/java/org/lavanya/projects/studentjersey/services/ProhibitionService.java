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

	public Prohibition get(int prohibitionId) throws PMException {
		return store.get(prohibitionId);
	}

	public List<Prohibition> getProhibitionsFor(String prohibitionsubject) throws PMException {
		return store.getProhibitionsFor(prohibitionsubject);
	}

	public void update(int prohibitionId, Prohibition prohibition) throws PMException {
		store.update(prohibitionId, prohibition);
		
	}

	public void delete(int prohibitionId) throws PMException {
		store.delete(prohibitionId);
	}
}
