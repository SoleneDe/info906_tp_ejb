package tp2EJB;

public interface EntryOperation {
	Entry getEntry(long id);
	Entry updateEntry(long id, String name, int priority, int estimation, String description);
	void deleteEntry(long id);
	Entry addComment(long id, String name, String content);
}
