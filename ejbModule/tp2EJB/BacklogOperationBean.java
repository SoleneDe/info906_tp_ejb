package tp2EJB;

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
	public Backlog addEntry(long id, Entry entry) {
		Backlog backlog = em.find(Backlog.class, id);
		backlog.addEntry(entry);
		return backlog;
	}

	@Override
	public Backlog deleteEntry(long idB, long idE) {
		Backlog backlog = em.find(Backlog.class, idB);
		Entry entry = em.find(Entry.class, idE);
		
		for (Comment comment : entry.getComments()) {
			em.remove(comment);
		}
		backlog.removeEntry(entry);
		em.remove(entry);
		
		return backlog;
	}

	@Override
	public Backlog sortEntries(long id) {
		return em.find(Backlog.class, id).sortEntries();
		
	}

	@Override
	public Backlog getBacklog(long id) {
		return em.find(Backlog.class, id);
	}

}
