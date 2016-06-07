* Malik Hamirani:
*Added Functionality for Account to Account transfer in synchronous manner.
*Modified the interest calculation methodology for Maxi Savings Account.java

* Deposit and withdraw methods in Account.java are now synchronized methods to avoid race conditions.
*Added StringBuilder in places of String concatenation
*Modified the Account class to make abstract and introduced child classes enabled runtime polymorphism and inheritance of common methods.

*Made dateProvider as eager loading singleton.
*Corrected the Bank.getFirstCustomer which was an obvious null pointer case, returning null, but ideally exception should be returned. Null can be handled by the calling method.

* Moved the common sting to a new UtilClass and used it as a static import
* Added AccountTypes enum to be used further in the classes. Currently not in in use
