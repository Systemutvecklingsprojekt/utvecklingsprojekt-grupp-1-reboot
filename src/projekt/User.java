/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import projekt.helpers.Database;

/**
 *
 * @author Amand
 */
public class User
{

	private int userID;
	private String firstName;
	private String lastName;
	private String email;
	private String admin;
	private String password;

	public User(int id)
	{
		this.userID = id;
		createUser();

	}

	private void createUser()
	{
		try {
			this.firstName = Database.fetchSingle("Select FIRSTNAME from User where USERID = " + userID);
			this.lastName = Database.fetchSingle("Select LASTNAME from User where USERID = " + userID);
			this.password = Database.fetchSingle("Select PASSWORD from User where USERID = " + userID);
			this.email = Database.fetchSingle("Select EMAIL from User where USERID = " + userID);
			this.admin = Database.fetchSingle("Select ADMINSTATUS from User where USERID = " + userID);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public int getUserID()
	{
		return userID;
	}

	public String getEmail()
	{
		return email;
	}

	public String getAdmin()
	{
		return admin;
	}

	public String getPassword()
	{
		return password;
	}

}
