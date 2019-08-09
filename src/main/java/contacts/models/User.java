package main.java.contacts.models;

public class User implements Comparable<User> {
	private int ID;
	private String firstName;
	private String lastName;

	public User(int ID, String firstName, String lastName) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/*
	* Sort by last name
	*/
	@Override
	public int compareTo(User user) {
		return this.lastName.compareTo(user.getLastName());
	}

	/*
	* firstname and lastname match
	*/
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;
		if (ID == user.ID) return true;
		if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
		return lastName != null ? lastName.equals(user.lastName) : user.lastName == null;
	}
}