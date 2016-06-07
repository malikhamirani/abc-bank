package com.abc.accountTypes;

import com.abc.Account;

public class SavingsAccount extends Account {

	public SavingsAccount(int accountType) {
		super(accountType);
	}

	@Override
	public double interestEarned() {
		double amount = sumTransactions();
		return amount * 0.001;
	}

}
