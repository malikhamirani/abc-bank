package com.abc.accountTypes;

import java.text.SimpleDateFormat;

import com.abc.Account;
import com.abc.DateProvider;
import com.abc.Transaction;

public class MaxiSavingsAccount extends Account {
	
	private int lastWithdrawalDate = -1;
	
	protected static ThreadLocal<SimpleDateFormat> transactionDateFormatter = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd");
		}

	};

	public MaxiSavingsAccount(int accountType) {
		super(accountType);
	}
	
	@Override
	public synchronized void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("amount must be greater than zero");
		} else {
			transactions.add(new Transaction(-amount));
			lastWithdrawalDate = Integer
					.parseInt(transactionDateFormatter.get().format(DateProvider.getInstance().now()));
		}

	}

	@Override
	public double interestEarned() {
		double amount = sumTransactions();
		/*
		 * if (amount <= 1000) return amount * 0.02; if (amount <= 2000)
		 * return 20 + (amount-1000) * 0.05; return 70 + (amount-2000) *
		 * 0.1;
		 */
		/**
		 * Change Maxi-Savings accounts to have an interest rate of 5%
		 * assuming no withdrawals in the past 10 days otherwise 0.1%
		 */
		int today = Integer.parseInt(transactionDateFormatter.get().format(DateProvider.getInstance().now()));
		if (lastWithdrawalDate < 0 || today - lastWithdrawalDate < 10) {
			return amount * 0.1;
		} else {
			return amount * 0.05;
		}
	}
	
	

}
