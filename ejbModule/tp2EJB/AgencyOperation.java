package tp2EJB;

public interface AgencyOperation {
	Agency createAgency(String name);
	Agency getAgency(long id);
}