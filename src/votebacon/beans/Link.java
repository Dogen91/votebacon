package votebacon.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Link {
	private String title;
	
	private String url;

	private Calendar created = Calendar.getInstance();

	private int vote;

	private List<Comment> comments = new ArrayList<Comment>();
	
	public String getInfoText(){
		Calendar currentCal = Calendar.getInstance();
		long currentTimeInMillis = currentCal.getTimeInMillis();
		long createdTimeInMillis = created.getTimeInMillis();
		long agoInMillis = currentTimeInMillis - createdTimeInMillis;
		if(agoInMillis < 1000 * 60 * 60){
			return "submitted " + (agoInMillis / 1000 / 60) +  " minutes ago by user dogen";
		}else if(agoInMillis < 1000 * 60 * 60 * 24){
			return "submitted " + (agoInMillis / 1000 / 60 / 60) +  " hours ago by user dogen";
		}else {
			return "submitted " + (agoInMillis / 1000 / 60 / 60 / 24) +  " days ago by user dogen";
		}
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

}
