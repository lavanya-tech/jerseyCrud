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

	public int add(String name, String subject, OperationSet operations) throws PMException {
		if (null == name) {
			throw new IllegalArgumentException("no name was provided when creating a prohibition");
		}
		if (null == subject) {
			throw new IllegalArgumentException("no subject was provided when creating a prohibition");
		}
		if (null == operations || operations.isEmpty()) {
			throw new IllegalArgumentException("no operations were provided when creating a prohibition");
		}
		for (String operation : operations) {
			if (!Operations.toOperations(operation))
				throw new IllegalArgumentException("invalid operations were provided when creating a prohibition");
		}
		return store.add(name, subject, operations);
	}

	public List<Prohibition> getAll() throws PMException {
		return store.getAll();
	}

	public Prohibition get(int prohibitionId) throws PMException {
		if (store.get(prohibitionId).getStatus() == false)
			throw new IllegalArgumentException("Invalid Id");
		return store.get(prohibitionId);
	}

	public List<Prohibition> getProhibitionsFor(String prohibitionsubject) throws PMException {
		return store.getProhibitionsFor(prohibitionsubject);
	}

	public void update(int prohibitionId, String name, String subject, OperationSet operations) throws PMException {
		if (store.get(prohibitionId) == null) {
			throw new NoSuchElementException();
		}
		if (null == name) {
			throw new IllegalArgumentException("no name was provided when creating a prohibition");
		}
		if (null == subject) {
			throw new IllegalArgumentException("no subject was provided when creating a prohibition");
		}
		if (null == operations || operations.isEmpty()) {
			throw new IllegalArgumentException("no operations were provided when creating a prohibition");
		}
		for (String operation : operations) {
			if (!Operations.toOperations(operation))
				throw new IllegalArgumentException("invalid operations were provided when creating a prohibition");
		}
		store.update(prohibitionId, name, subject, operations);
	}

	public void delete(int prohibitionId) throws PMException {
		if (store.get(prohibitionId) == null)
			throw new IllegalArgumentException("Invalid Id");
		store.delete(prohibitionId);
	}
}
