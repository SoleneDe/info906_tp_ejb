package tp2EJB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Entry implements Serializable {
	private static final long serialVersionUID = -6594257572878013271L;

	private static long currentId = 0;
	
	@Id
	private long id;
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creation;
	private int priority;
	private int estimation;
	private String description;
	@OneToMany
	private ArrayList<Comment> comments;
	
	public Entry() {}

	public Entry(String name, int priority, int estimation, String description) {
		this.id = ++currentId;
		this.name = name;
		this.creation = new Date();
		this.priority = priority;
		this.estimation = estimation;
		this.description = description;
		this.comments = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getEstimation() {
		return estimation;
	}

	public void setEstimation(int estimation) {
		this.estimation = estimation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public Date getCreation() {
		return creation;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}
	
	public void addComment(Comment comment)
	{
		comments.add(comment);
	}
}
