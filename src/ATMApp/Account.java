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
	
	/**k
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
	
	/**
	 * Return the user's UUID
	 * @return 	the uuid
	 */
	public String getUUID() {
		return this.uuid;
	}
	
	public String getSummaryLine() {
		// get the accont's balance
		double balance = this.getBalance();
		
		// format the summary line, depending on the whether the balance is negative
		if(balance >= 0) {
			return String.format("%s : PHP%.02f : %s", this.uuid, balance, this.name);
		}else {
			return String.format("%s : PHP(%.02f) : %s", this.uuid, balance, this.name);
		}
	}
	
	/**
	 * Get the balance of account by adding the amouints of the transactions 
	 * @return	the balance value
	 */
	public double getBalance() {
		double balance = 0;
		for (Transaction t: this.transactions) {
			balance += t.getAmount();
		}
		return balance;
	}
	
	/**
	 * Print the transaction history of the account
	 */
	public void printTransHistory() {
		System.out.printf("\nTransaction history for account %s\n", this.uuid);
		for (int t = this.transactions.size()-1 ; t >= 0; t--) {
			System.out.println(this.transactions.get(t).getSummaryLine());
		}
		System.out.println();
	}
	
	/**
	 * Add a new transaction in this account
	 * @param amount	the amount transacted
	 * @param memo		the transaction memo
	 */
	public void addTransaction(double amount, String memo) {
		// create new transaction object and add it to our list
		Transaction newTrans = new Transaction(amount, memo, this);
		this.transactions.add(newTrans);
	}
}
