package tp2EJB;

import java.util.Collection;

public interface AgencyOperation {
	Agency createAgency(String name);
	Agency getAgency(long id);
	Collection<Agency> getAllAgencies();
}