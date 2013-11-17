package votebacon.beans;

import java.util.Calendar;

import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class Comment {
	private String author;
	private String content;
	private int vote = 0;
	
	private Calendar created = Calendar.getInstance();

	public String getInfoText() {
		String returnString = this.getAuthor() + " wrote ";
		Calendar currentCal = Calendar.getInstance();
		long currentTimeInMillis = currentCal.getTimeInMillis();
		long createdTimeInMillis = created.getTimeInMillis();
		long agoInMillis = currentTimeInMillis - createdTimeInMillis;
		
		if(agoInMillis < 1000 * 60 * 60){
			returnString += (agoInMillis / 1000 / 60) +  " minutes";
		}else if(agoInMillis < 1000 * 60 * 60 * 24){
			returnString += (agoInMillis / 1000 / 60 / 60) +  " hours";
		}else {
			returnString += (agoInMillis / 1000 / 60 / 60 / 24) +  " days";
		}
		return returnString + " ago:";
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

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}
	
	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}
}
