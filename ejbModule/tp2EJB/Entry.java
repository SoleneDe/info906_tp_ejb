package tp2EJB;

import java.util.ArrayList;
import java.util.Date;

public class Entry {

	private long id;
	private String name;
	private Date date;
	private int priority;
	private int estimation;
	private String description;
	private ArrayList<Comment> comments;
	
	public Entry() {}

}
