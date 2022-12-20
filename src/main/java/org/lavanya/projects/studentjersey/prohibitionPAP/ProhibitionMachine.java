package org.lavanya.projects.studentjersey.prohibitionPAP;

import java.util.List;

import org.lavanya.projects.studentjersey.exceptions.PMException;
import org.lavanya.projects.studentjersey.models.Prohibition;
import org.lavanya.projects.studentjersey.operations.OperationSet;

public interface ProhibitionMachine {
	/**
	 * Create a new prohibition.
	 *
	 * @param name, subject, operations of the prohibition to be created.
	 * @return id of the prohibition created.
	 * @throws PMException if there is an error creating a prohibition.
	 */
	int add(String name, String subject, OperationSet operations) throws PMException;

	/**
	 * Get a list of all prohibitions
	 *
	 * @return a list of all prohibitions
	 * @throws PMException if there is an error getting the prohibitions.
	 */
	List<Prohibition> getAll() throws PMException;

	/**
	 * Retrieve a Prohibition and return the Object representing it.
	 *
	 * @param prohibitionId The id of the Prohibition to retrieve.
	 * @return the Prohibition with the given id.
	 * @throws PMException if there is an error getting the prohibition with the
	 *                     given id.
	 */
	Prohibition get(int prohibitionId) throws PMException;

	/**
	 * Get all of the prohibitions a given entity is the direct subject of. The
	 * subject can be a user, user attribute, or process.
	 * 
	 * @param subject the name of the subject to get the prohibitions for.
	 * @return The list of prohibitions the given entity is the subject of.
	 */
	List<Prohibition> getProhibitionsFor(String subject) throws PMException;

	/**
	 * Update the prohibition with the given prohibitionId. Prohibition names cannot
	 * be updated.
	 *
	 * @param prohibitionId the name of the prohibition to update.
	 * @param name,         subject, operations of the prohibition to update.
	 * @throws PMException if there is an error updating the prohibition.
	 */
	void update(int prohibitionId, String name, String subject, OperationSet operations) throws PMException;

	/**
	 * Delete the prohibition, and remove it from the data structure.
	 *
	 * @param prohibitionId The Id of the prohibition to delete.
	 * @throws PMException if there is an error deleting the prohibition.
	 */
	void delete(int prohibitionId) throws PMException;
}
