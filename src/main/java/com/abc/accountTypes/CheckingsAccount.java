package com.abc.accountTypes;

import com.abc.Account;

public class CheckingsAccount extends Account {

	public CheckingsAccount(int accountType) {
		super(accountType);
	}

	@Override
	public double interestEarned() {
		double amount = sumTransactions();
		if (amount <= 1000)
			return amount * 0.001;
		else
			return 1 + (amount - 1000) * 0.002;
	}
	
	

}
