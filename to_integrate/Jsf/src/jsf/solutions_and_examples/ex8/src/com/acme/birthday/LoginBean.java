package jsf.solutions_and_examples.ex8.src.com.acme.birthday;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class LoginBean {
	private boolean loggedIn;

	private String userName;
	private String password;

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean login) {
		this.loggedIn = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String ipassword) {
		password = ipassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String iuserName) {
		userName = iuserName;
	}

	public void loginHandler(ActionEvent event) {
		if (userName.equals(password)) {
			System.out.println("Login ok");
			setLoggedIn(true);
		} else {
			System.out.println("Bad login");
			FacesContext.getCurrentInstance().addMessage("loginForm",
					new FacesMessage("User name or password are incorrect"));
		}
	}

	public String checkLogin() {
		if (isLoggedIn()) {
			return "loggedIn";
		} else {
			return "notLoggedIn";
		}
	}
}
