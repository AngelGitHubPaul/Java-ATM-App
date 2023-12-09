package ATMApp;

import java.util.ArrayList;

public class Account {
	// the name of the account
	private String name;
	
	// the account ID number
	private String uuid;
	
	// the user object that owns this account
	private User holder;
	
	// the list of transactions for this account
	private ArrayList<Transaction> transactions;
	
	/*
	 * Create a new Account
	 * @param name 		the name of the account
	 * @param holdert 	the user object that holds this account
	 * @param theBank 	the bank that issues the account
	 */
	public Account(String name, User holder, Bank theBank) {
		// set the account name and holder
		this.name = name;
		this.holder = holder;
		
		// get new account UUID
		this.uuid = theBank.getNewAccountUUID();
		
		// initialize transactions
		this.transactions = new ArrayList<Transaction>();
	}
	
	/*
	 * Return the user's UUID
	 * @return 	the uuid
	 */
	public String getUUID() {
		return this.uuid;
	}
}
