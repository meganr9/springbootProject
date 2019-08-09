
package main.java.contacts;

import main.java.contacts.models.User;

import java.util.*;

/*
* Holds the users
*
*/
public class UserStorage {
	
	private HashMap<Integer, User> userHashMap;
	private static UserStorage userStorage = null;

	private UserStorage(){
		userHashMap = new HashMap();
	}

	public static UserStorage getInstance() {
		if(userStorage == null) {
			userStorage = new UserStorage();
			return userStorage;
		}
		else {
			return userStorage;
		}
	}
	
	public User add(User user) {
		if (!userHashMap.containsKey(user.getID())) {
			userHashMap.put(user.getID(), user);
			return user;
		} else {
			return null;
		}
	}
	public User getUser(int id) {
		return userHashMap.get(id);
	}

	public List<User> getUsers() {
		ArrayList<User> users =new ArrayList<User>(userHashMap.values());
		Collections.sort(users);
		return users;
	}

	public User removeUser(Integer id) {
		return userHashMap.remove(id);
	}
}