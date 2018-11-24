package tp2EJB;


public interface BacklogOperation {
	Backlog addEntry(long id, Entry entry);
	Backlog deleteEntry(long idB, long idE);
	Backlog sortEntries(long id);
	Backlog getBacklog(long id);
}