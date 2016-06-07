package com.abc;

import java.util.ArrayList;
import java.util.List;


public abstract class Account {

	public static final int CHECKING = 0;
	public static final int SAVINGS = 1;
	public static final int MAXI_SAVINGS = 2;
	// storing the last transation date as integer
	

	

	private final int accountType;
	public List<Transaction> transactions;

	public Account(int accountType) {
		this.accountType = accountType;
		this.transactions = new ArrayList<Transaction>();
	}

	public synchronized void deposit(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("amount must be greater than zero");
		} else {
			transactions.add(new Transaction(amount));
		}
	}

	public synchronized void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("amount must be greater than zero");
		} else {
			transactions.add(new Transaction(-amount));
			
		}

	}

	/**
	 * Method overridden by implementing classes
	 * @return
	 */
	public abstract double interestEarned();

	public double sumTransactions() {
		return checkIfTransactionsExist(true);
	}

	private double checkIfTransactionsExist(boolean checkAll) {
		double amount = 0.0;
		for (Transaction t : transactions)
			amount += t.amount;
		return amount;
	}

	public int getAccountType() {
		return accountType;
	}

	/**
	 * ideally we should have a unique account id
	 */
	@Override
	public int hashCode() {
		return accountType;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj != null && obj instanceof Account) {
			Account acc = (Account) obj;
			if (this.accountType == acc.accountType) {
				return true;
			}

		}
		return false;
	}

}
