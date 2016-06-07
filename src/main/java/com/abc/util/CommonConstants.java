package com.abc.util;

public class CommonConstants {

	public static enum AccountTypes {
		CHECKING(0,"Checking Account"), SAVINGS(1,"Savings Account"), MAXI_SAVINGS(2,"Maxi Savings Account");

		private int typeId;
		private String description;

		private AccountTypes(int typeId, String description) {
			this.typeId = typeId;
			this.description = description;

		}
		
		public int getAccountTypeId() {
			return typeId;
		}
		
		public String getAccountDescription() {
			return description;
		}
	};
	
	public static final String NEW_LINE = "\n";
}
