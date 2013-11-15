package votebacon.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AuthenticationHandler {
	private static List<User> users = new ArrayList<User>();
	
	private User currentUser;
	
	public void register(User user){
		AuthenticationHandler.users.add(user);
		login(user);
	}
	
	public boolean login(User user){
		int index = AuthenticationHandler.users.indexOf(user);
		if(index > -1){
			this.currentUser = user;
			return true;
		}
		return false;
	}
	
	public void logout(){
		this.currentUser = null;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}