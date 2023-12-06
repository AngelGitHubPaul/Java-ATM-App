package ATMApp;

import java.util.ArrayList;

public class Account {
	// the name of the account
	private String name;
	
	// the current balance of the account
	private double balance;
	
	// the account ID number
	private String uuid;
	
	// the user object that owns this account
	private User holder;
	
	// the list of transactions for this account
	private ArrayList<Transaction> transactions;
	
}
