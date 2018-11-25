package tp2EJB;

import java.util.Collection;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Remote
public class AgencyOperationBean implements AgencyOperation {
	@PersistenceContext
	private EntityManager em;
	
	public AgencyOperationBean() {}

	@Override
	public Agency createAgency(String name) {
		Agency agency = new Agency(name);
		em.persist(agency);
		return agency;
	}

	@Override
	public Agency getAgency(long id) {
		return em.find(Agency.class, id);
	}

	@Override
	public Collection<Agency> getAllAgencies() {
		Query query = em.createQuery("SELECT a FROM Agency a");
		return (Collection<Agency>) query.getResultList();
	}

}
