package tp2EJB;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Agency {
	private static long currentId = 0;
	
	@Id
	private long id;
	private Backlog backlog;
	private String name;
	
	public Agency(String name) {
		this.id = ++currentId;
		this.backlog = new Backlog();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public Backlog getBacklog() {
		return backlog;
	}
	
	public String getName() {
		return name;
	}
}
