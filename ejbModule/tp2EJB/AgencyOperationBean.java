package tp2EJB;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote
public class AgencyOperationBean implements AgencyOperation {
	@PersistenceContext
	private EntityManager em;
	
	public AgencyOperationBean() {}

	@Override
	public Agency createAgency(String name) {
		Agency agency = new Agency(name);
		em.persist(agency.getBacklog());
		em.persist(agency);
		return agency;
	}

	@Override
	public Agency getAgency(long id) {
		return em.find(Agency.class, id);
	}

}
