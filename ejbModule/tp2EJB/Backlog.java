package tp2EJB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

import javax.persistence.CascadeType;
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
	private static final long serialVersionUID = -5646602840666834605L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable
	@OrderBy("priority DESC")
	private ArrayList<Entry> entries;
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

	public ArrayList<Entry> getEntries() {
		return entries;
	}
	
	public Backlog sortEntries()
	{
		entries.sort(new Comparator<Entry>() {
			@Override
			public int compare(Entry e1, Entry e2) {
				return e1.getPriority() - e2.getPriority();
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
