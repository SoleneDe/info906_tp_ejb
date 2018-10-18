package tp2EJB;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Agency implements Serializable {
	private static final long serialVersionUID = 9180907257967323585L;

	private static long currentId = 0;
	
	@Id
	private long id;
	@OneToOne
	private Backlog backlog;
	private String name;
	
	public Agency() {}
	
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
