package tp2EJB;

import java.util.ArrayList;
import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Backlog {
	private static long currentId = 0;
	
	@Id
	private long id;
	//Chaque «backlog» sera composé d'entrées (triées par ordre de priorité décroissante).
	private ArrayList<Entry> entries;
	
	public Backlog() {
		this.id = ++currentId;
		this.entries = new ArrayList<>();
	}

	public long getId() {
		return id;
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
	}

}
