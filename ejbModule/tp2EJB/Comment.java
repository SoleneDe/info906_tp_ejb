package tp2EJB;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment implements Serializable {
	private static final long serialVersionUID = 5385411064684911918L;

	private static long currentId = 0;
	
	@Id
	private long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creation;
	private String name;
	private String content;
	
	public Comment() {}
	
	public Comment(String name, String content) {
		this.id = ++currentId;
		this.name = name;
		this.content = content;
		this.creation = new Date(); // get current date
	}

	public long getId() {
		return id;
	}

	public Date getCreation() {
		return creation;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}	
}
