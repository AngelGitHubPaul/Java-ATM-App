package ATMApp;

import java.util.ArrayList;

public class User {
	// first name of the user
	private String firstName;
	
	// last name of the user
	private String lastName;
	
	// id number of the user
	private String uuid;
	
	// the MD5 hash of the user's ping number
	private byte pinHash[];
	
	// the list of accounts for this user
	private ArrayList<Account> accounts; 	

}
