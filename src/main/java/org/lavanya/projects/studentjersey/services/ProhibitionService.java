package org.lavanya.projects.studentjersey.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.lavanya.projects.studentjersey.exceptions.PMException;
import org.lavanya.projects.studentjersey.models.Prohibition;
import org.lavanya.projects.studentjersey.mysql.MySQLStore;
import org.lavanya.projects.studentjersey.operations.OperationSet;
import org.lavanya.projects.studentjersey.operations.Operations;

public class ProhibitionService {
	MySQLStore store = new MySQLStore();
	public int add(Prohibition prohibition) throws PMException {
		if(prohibition.getName() == null) 
            throw new IllegalArgumentException("no name was provided when creating a prohibition");
		if(prohibition.getSubject() == null)
            throw new IllegalArgumentException("no subject was provided when creating a prohibition");
		OperationSet os = prohibition.getOperations();
		if(os == null || os.size() == 0)
		    throw new IllegalArgumentException("no operations were provided when creating a prohibition");
		for(String i: prohibition.getOperations()) {
			if(Operations.toOperations(i) == null)
			    throw new IllegalArgumentException("invalid operations were provided when creating a prohibition");
		}
		return store.add(prohibition);
	}

	public List<Prohibition> getAll() throws PMException {
		return store.getAll();
	}

	public Prohibition get(int prohibitionId) throws PMException {
		if(store.get(prohibitionId).getStatus() == false)
			throw new IllegalArgumentException("Invalid Id");
		return store.get(prohibitionId);
	}

	public List<Prohibition> getProhibitionsFor(String prohibitionsubject) throws PMException {
		return store.getProhibitionsFor(prohibitionsubject);
	}

	public void update(int prohibitionId, Prohibition prohibition) throws PMException {
		if(store.get(prohibitionId) == null)
			throw new NoSuchElementException();
		if(store.get(prohibitionId).getStatus() == false)
			throw new NoSuchElementException();
		if(prohibition.getName() == null)
            throw new IllegalArgumentException("no name was provided when creating a prohibition");
		if(prohibition.getSubject() == null)
            throw new IllegalArgumentException("no subject was provided when creating a prohibition");
		OperationSet os = prohibition.getOperations();
		if(os == null || os.size() == 0)
		    throw new IllegalArgumentException("no operations were provided when creating a prohibition");
		for(String i: prohibition.getOperations()) {
			if(Operations.toOperations(i) == null)
			    throw new IllegalArgumentException("invalid operations were provided when creating a prohibition");
		}
		store.update(prohibitionId, prohibition);	
	}

	public void delete(int prohibitionId) throws PMException {
		if(store.get(prohibitionId) == null)
			throw new IllegalArgumentException("Invalid Id");
		store.delete(prohibitionId);
	}
}
