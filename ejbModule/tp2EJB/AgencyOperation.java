package tp2EJB;

import java.util.Collection;

public interface AgencyOperation {
	/**
	 * Create a new agency and its backlog
	 * @param name Name of the agency
	 * @return The new agency
	 */
	Agency createAgency(String name);
	/**
	 * Find an agency thanks to its id
	 * @param id Id of the agency you are looking for
	 * @return The agency you are looking for
	 */
	Agency getAgency(long id);
	/**
	 * Find all agencies in the database
	 * @return A collection of all the agencies
	 */
	Collection<Agency> getAllAgencies();
}