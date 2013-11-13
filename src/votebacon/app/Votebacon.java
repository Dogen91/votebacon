package votebacon.app;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import votebacon.beans.Link;

@ManagedBean
@ApplicationScoped
public class Votebacon {
	private List<Link> links = new ArrayList<Link>();

	public void addNewLink(Link link){
		this.links.add(link);
	}
	
	public Integer voteUp(int id){
		if(this.links.size() > id){
			Link link = this.links.get(id);
			link.setVote(link.getVote() + 1);
			return link.getVote();
		}else {
			// TODO pforster: create exception
			return null;
		}
	}
	
	public Integer voteDown(int id){
		if(this.links.size() > id){
			Link link = this.links.get(id);
			link.setVote(link.getVote() - 1);
			return link.getVote();
		}else {
			// TODO pforster: create exception
			return null;
		}
	}
	
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
}
