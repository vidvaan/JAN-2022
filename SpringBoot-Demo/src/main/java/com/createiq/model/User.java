package com.createiq.model;

public class User {
	private String firstName;
	private String lastName;
	private String nationality;

	public User(String firstName, String lastName, String nationality) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", nationality=" + nationality + "]";
	}

}
