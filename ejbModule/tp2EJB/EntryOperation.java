package tp2EJB;

public interface EntryOperation {
	Entry getEntry(long id);
	Entry createEntry(String name, int priority, int estimation, String description);
	Entry updateEntry(long id, String name, int priority, int estimation, String description);
	Entry addComment(long id, String name, String content);
}
