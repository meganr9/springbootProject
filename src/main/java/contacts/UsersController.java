package main.java.contacts;

import main.java.contacts.models.User;
import main.java.contacts.models.Users;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

@RestController
@RequestMapping("/users")
public class UsersController {

	@RequestMapping("/{ID}")
	@ResponseBody
	public ResponseEntity<?> getUser(@PathVariable("ID") int id) {
		User user = UserStorage.getInstance().getUser(id);
		if (user == null) {
			HashMap<String, String> errorMessage = new HashMap<>();
			errorMessage.put("Error", "User doesn't exists!");
			return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}


	@RequestMapping({"", "/"})
	@ResponseBody
	public Users getUsers() {
		UserStorage userStorage = UserStorage.getInstance();
		return new Users(userStorage.getUsers());
	}


	@RequestMapping(method = RequestMethod.POST, value={"", "/"})
	@ResponseBody
	public ResponseEntity<?> addUser(@RequestBody User user) {
		HashMap<String, String> errorMessage = new HashMap<>();
		if (user.getLastName() == null) {

			errorMessage.put("Error:lastName", "Last name is required!");
		}
		if (user.getFirstName() == null) {

			errorMessage.put("Error:firstName", "First name is required");
		}
		if (!errorMessage.isEmpty()) {
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		System.out.println("In addUser");
		System.out.println(user.getID());
		User addedUser = UserStorage.getInstance().add(user);
		if (addedUser == null) {
			errorMessage.put("Error", "User already exists!");
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(addedUser, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{ID}")
	@ResponseBody
	public ResponseEntity<?> removeUser(@PathVariable("ID") int id) {
		System.out.println("In removeUser");
		User removedUser = UserStorage.getInstance().removeUser(id);
		if (removedUser == null) {
			HashMap<String, String> errorMessage = new HashMap<>();
			errorMessage.put("Error", "User doesn't exists!");
			return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(removedUser, HttpStatus.OK);
		}
	}
}