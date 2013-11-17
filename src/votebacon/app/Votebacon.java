package votebacon.app;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import votebacon.beans.AuthenticationHandler;
import votebacon.beans.Comment;
import votebacon.beans.Link;

@ManagedBean
@ApplicationScoped
public class Votebacon {
	private List<Link> links = new ArrayList<Link>();

	public void addNewLink(Link link, String username){
		link.setUsername(username);
		
		this.links.add(link);
		// TODO: user has to be forwarded to the detail view of the new link.
	}
	
	public Integer voteUp(int id){
		if(this.links.size() >= id){
			Link link = this.links.get(id);
			
			link.setVotes( link.getVotes() + 1 );
			link.setPosVotes( link.getPosVotes() + 1 );
			
			return link.getEffectiveVotes();
		}else {
			// TODO pforster: create exception
			return null;
		}
	}
	
	public Integer voteDown(int id){
		if(this.links.size() >= id){
			Link link = this.links.get(id);
			
			link.setVotes( link.getVotes() + 1 );
			
			return link.getEffectiveVotes();
		}else {
			// TODO pforster: create exception
			return null;
		}
	}
	
	public Integer voteUpComment( int linkID, int id ) {
		if(this.links.size() >= linkID ){
			Link link = this.links.get(id);
			
			if ( link.getComments().size() >= id ) {
				Comment comment = link.getComments().get( id );
				comment.setVote( comment.getVote()+1 );
				return comment.getVote();
			}
		}
		return 0;
	}
	
	public Integer voteDownComment( int linkID, int id ) {
		if(this.links.size() >= linkID ){
			Link link = this.links.get(id);
			
			if ( link.getComments().size() >= id ) {
				Comment comment = link.getComments().get( id );
				comment.setVote( comment.getVote()-1 );
				return comment.getVote();
			}
		}
		return 0;
	}
	
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
}
