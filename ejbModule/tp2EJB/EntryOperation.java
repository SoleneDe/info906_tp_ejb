package tp2EJB;

public interface EntryOperation {
	/**
	 * Find an entry thanks to its id
	 * @param id Id of the entry you are looking for
	 * @return The entry you are looking for
	 */
	Entry getEntry(long id);
	/**
	 * Create a new entry
	 * @param name The username of its creator
	 * @param priority The priority of the entry
	 * @param estimation The estimation of the entry
	 * @param description The text describing the entry
	 * @return The created entry
	 */
	Entry createEntry(String name, int priority, int estimation, String description);
	/**
	 * Change the entry's attributes
	 * @param id The id of the entry to update
	 * @param name The username of its creator
	 * (currently, stays as the original creator, but could be used to change it with the user who updated the entry)
	 * @param priority The new priority of the entry
	 * @param estimation The new estimation of the entry
	 * @param description The new description of the entry
	 * @return The updated entry
	 */
	Entry updateEntry(long id, String name, int priority, int estimation, String description);
	/**
	 * Add a comment to the entry
	 * @param id The id of the entry where the comment is added
	 * @param name The username of the comment's author
	 * @param content The actual comment
	 * @return The entry where the comment is added
	 */
	Entry addComment(long id, String name, String content);
}
