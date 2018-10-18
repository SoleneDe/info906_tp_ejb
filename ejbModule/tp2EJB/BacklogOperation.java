package tp2EJB;

import java.util.Date;

public interface BacklogOperation {
	Backlog addEntry(long id, String name, Date date, int priority, int estimation, String description);
	Backlog getBacklog(long id);
}