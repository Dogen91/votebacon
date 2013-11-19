package votebacon.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import votebacon.beans.Link;
import votebacon.beans.User;

@ManagedBean
@ApplicationScoped
public class Votebacon {
	private List<Link> links = new ArrayList<Link>();
	private int maxLinkID;
	
	public void addNewLink(Link link, String username) throws IOException {
		link.setUsername(username);
		link.setId( this.getMaxLinkID() );
		
		this.setMaxLinkID( this.getMaxLinkID()+1 );
		this.links.add(link);
		
		//Collections.sort(links);
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("detail.xhtml?id=" + link.getId() );
	}
	
	public Link getLink(int id) {
		for(int i=0;i<this.links.size();i++){
	        if(this.links.get(i).getId() == id){
	            return this.links.get(i);
	        }
		}
		return null;
	}
	
	public int voteUp( int linkID, User user ) {
		if ( user != null ) {
			return this.getLink( linkID ).voteUp( user );
		} else {
			return 0;
		}
	}
	
	public int voteDown( int linkID, User user ) {
		if ( user != null ) {
			return this.getLink( linkID ).voteDown( user );
		} else {
			return 0;
		}
	}

	public List<Link> getSortedLinks(){
		Collections.sort( this.links );
		return this.links;
	}
	
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public int getMaxLinkID() {
		return maxLinkID;
	}

	public void setMaxLinkID(int maxLinkID) {
		this.maxLinkID = maxLinkID;
	}
}
