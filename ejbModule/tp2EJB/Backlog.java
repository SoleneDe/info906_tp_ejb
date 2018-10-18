package tp2EJB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Backlog implements Serializable {
	private static final long serialVersionUID = -5646602840666834605L;

	private static long currentId = 0;
	
	@Id
	private long id;
	@OneToMany
	private ArrayList<Entry> entries;
	private int size;
	
	public Backlog() {
		this.id = ++currentId;
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
	
	public void addEntry(Entry entry)
	{
		entries.add(entry);
		entries.sort(new Comparator<Entry>() {
			// TODO vérifier l'ordre
			@Override
			public int compare(Entry e1, Entry e2) {
				return e1.getPriority() - e2.getPriority();
			}
		});
		
		size = entries.size();
	}
	
	public void removeEntry(Entry entry)
	{
		entries.remove(entry);		
		size = entries.size();
	}

}
