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
	
	/**
	 * Registers a new user after checking if it doesn't already exist and if the passwords match.
	 * @param user
	 * @author PFORSTER, PCHR
	 */
	public void register(User user){
		if( !this.userExists( user ) ){
			if ( user.getConfirmPassword().equals(user.getPassword()) ) {
				// doesn't exist yet. add user and log them in.
				AuthenticationHandler.users.add(user);
				login(user);
			} else {
				// passwords don't match. Prompt a message!
			}
		} else {
			// exists already, sorry.
			// TODO: prompt a message or something. The code below should work according to http://stackoverflow.com/a/319036
			// but doesn't. :(
			//FacesContext.getCurrentInstance().addMessage("registerForm:userAlreadyExistsError", new FacesMessage("User already exists!"));
			
		}
	}
	
	/**
	 * Let the user log in with his/her credentials if it exists.
	 * @param user
	 * @return Boolean
	 * @author PFORSTER, PCHR
	 */
	public boolean login(User user){
		if( this.userExists( user ) ){
			this.currentUser = user;
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if a user already exists.
	 * @param user
	 * @return Boolean
	 * @author PCHR
	 */
	public boolean userExists( User user ) {
		return AuthenticationHandler.users.indexOf(user) > -1;
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