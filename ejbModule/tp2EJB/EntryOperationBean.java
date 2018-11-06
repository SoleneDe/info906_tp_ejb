package tp2EJB;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote
public class EntryOperationBean implements EntryOperation {
	@PersistenceContext
	private EntityManager em;
	
	public EntryOperationBean() {}

	@Override
	public Entry getEntry(long id) {
		return em.find(Entry.class, id);
	}

	@Override
	public Entry createEntry(String name, int priority, int estimation, String description) {
		return new Entry(name, priority, estimation, description);
	}

	@Override
	public Entry updateEntry(long id, String name, int priority, int estimation, String description) {
		Entry entry = em.find(Entry.class, id);
		
		// attributes to change
		if (name != null && !"".equals(name))
			entry.setName(name);
		if (priority != -1)
			entry.setPriority(priority);
		if (estimation != -1)
			entry.setEstimation(estimation);
		if (description != null && !"".equals(description))
			entry.setDescription(description);
		
		return entry;
	}

	@Override
	public Entry addComment(long id, String name, String content) {
		Entry entry = em.find(Entry.class, id);
		entry.addComment(new Comment(name, content));
		return entry;
	}

}
