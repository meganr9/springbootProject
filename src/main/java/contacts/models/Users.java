package main.java.contacts.models;

import java.util.ArrayList;
import java.util.List;

/*
* Object of an array of users to be easily converted to JSON
*/
public class Users {
	List<User> users;

	public Users() {
		users = new ArrayList<>();
	}

	public Users(List<User> users) {
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {

		this.users = users;
	}
}
