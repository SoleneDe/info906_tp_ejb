package tp2EJB;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comment {
	private static long currentId = 0;
	
	@Id
	private long id;
	private Date date;
	private String name;
	private String content;
	
	public Comment(String name, String content) {
		this.id = ++currentId;
		this.name = name;
		this.content = content;
		this.date = new Date(); // get current date
	}

	public long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}	
}
