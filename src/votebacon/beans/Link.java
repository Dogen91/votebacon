package votebacon.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Link implements Comparable<Link> {
	private String title;
	private String username;
	private String url;
	
	private int votes = 0;
	private int posVotes = 0;

	private Calendar created = Calendar.getInstance();

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
	
	// returns the "real score"
	public double getScore() {
		if ( this.getVotes() == 0 ) {
			return 0.0;
		} else {
			return (double) this.getPosVotes() / (double) this.getVotes();
		}
	}
	
	// returns a simple positive-negative votes number
	public int getEffectiveVotes() {
		return this.getPosVotes() - ( this.getVotes() - this.getPosVotes() );
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

	public int getPosVotes() {
		return posVotes;
	}

	public void setPosVotes(int posVotes) {
		this.posVotes = posVotes;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Override
	public int compareTo( Link o ) {
		if (o instanceof Link) {
	        Link otherLink = (Link) o;
	        if ( this.getScore() < otherLink.getScore() ) {
	        	return -1;
	        } else if ( this.getScore() > otherLink.getScore() ) {
	        	return 1;
	        } else {
	        	return 0;
	        }
	        //return ( this.getScore() < otherLink.getScore() ? -1 : 1 );
	    } else {
	        return 0;
	    }
	}

}
