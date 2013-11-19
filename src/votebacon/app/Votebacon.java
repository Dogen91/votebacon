package votebacon.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import votebacon.beans.Link;

@ManagedBean
@ApplicationScoped
public class Votebacon {
	private List<Link> links = new ArrayList<Link>();

	public void addNewLink(Link link, String username) throws IOException {
		link.setUsername(username);
		this.links.add(link);
		Collections.sort(links);
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("detail.xhtml?id=" + this.links.indexOf(link));		
	}

	public List<Link> getSortedLinks(){
		Collections.sort(links);
		return this.links;
	}
	
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
}
