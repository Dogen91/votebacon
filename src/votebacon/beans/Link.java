package votebacon.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Link {
	private String title;
	private String username;
	private String url;

	private Calendar created = Calendar.getInstance();

	private int vote;

	private List<Comment> comments = new ArrayList<Comment>();
	
	public String getInfoText(){
		String returnString = "submitted ";
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
		return returnString + " ago by " + this.getUsername();
	}
	
	public void addComment( Comment newComment, String username) {
		newComment.setAuthor( username );
		this.comments.add( newComment );
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
