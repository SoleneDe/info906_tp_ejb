package tp2EJB;

import java.util.Date;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote
public class BacklogOperationBean implements BacklogOperation {
	@PersistenceContext
	private EntityManager em;
	
	public BacklogOperationBean() {}

	@Override
	public Backlog addEntry(long id, String name, Date date, int priority, int estimation, String description) {
		Backlog backlog = em.find(Backlog.class, id);
		Entry entry = new Entry(name, priority, estimation, description);
		em.persist(entry);
		backlog.addEntry(entry);
		return backlog;
	}

	@Override
	public Backlog getBacklog(long id) {
		return em.find(Backlog.class, id);
	}

}
