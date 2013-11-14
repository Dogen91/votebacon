package votebacon.beans;

import java.util.Date;
 
public class Comment {
	private Date date;
	private String author;
	private String content;
	
	public Comment() {
		this.date = new Date();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
