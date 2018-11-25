package tp2EJB;


public interface BacklogOperation {
	/**
	 * Add a new entry in the backlog
	 * @param id The id of the backlog where the new entry is added
	 * @param entry The entry to add in the backlog
	 * @return The backlog where the entry is added
	 */
	Backlog addEntry(long id, Entry entry);
	/**
	 * Delete an entry from the backlog
	 * @param idB Id of the backlog where the entry is
	 * @param idE Id of the entry to be deleted
	 * @return The backlog where the entry is removed
	 */
	Backlog deleteEntry(long idB, long idE);
	/**
	 * Sort the entries in the backlog, from high priority to low priority
	 * @param id Id of the backlog where the sorting happens
	 * @return The backlog where the sorting happens
	 */
	Backlog sortEntries(long id);
	/**
	 * Find a backlog thanks to its id
	 * @param id Id of the backlog you are looking for
	 * @return The backlog you are looking for
	 */
	Backlog getBacklog(long id);
}