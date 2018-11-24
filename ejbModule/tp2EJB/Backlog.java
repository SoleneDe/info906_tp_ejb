package tp2EJB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Backlog implements Serializable {
	
	private static final long serialVersionUID = 5395137346326413422L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable
	@OrderBy("priority DESC")
	private List<Entry> entries;
	private int size;
	
	public Backlog() {
		this.entries = new ArrayList<>();
		this.size = entries.size();
	}

	public long getId() {
		return id;
	}

	public long getSize() {
		return size;
	}

	public List<Entry> getEntries() {
		return entries;
	}
	
	public Backlog sortEntries()
	{
		entries.sort(new Comparator<Entry>() {
			@Override
			public int compare(Entry e1, Entry e2) {
				return e2.getPriority() - e1.getPriority();
			}
		});
		
		return this;
	}
	
	public void addEntry(Entry entry)
	{
		entries.add(entry);
		size = entries.size();
		sortEntries();
	}
	
	public void removeEntry(Entry entry)
	{
		entries.remove(entry);		
		size = entries.size();
	}

}
