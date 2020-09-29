package W9;

import java.util.ArrayList;
import java.util.List;

/**
 *  Shared account for Workshop9
 *  it contains List<Money> for variable
 *  withdraw and deposit method as their account's feature
 * @author MonicaYam
 *
 */
public class SharedAccount {
	List<Money> moneyList = new ArrayList<Money>();

	SharedAccount(List<Money> ml){
		if(ml != null) {
			moneyList = ml;
		}
	}

	public void setMoneyList(List<Money> ml) {
		if(ml != null) {
			moneyList = ml;
		}
	}
	public List<Money> getMoneyList(){
		return moneyList;
	}

	/**
	 * the code for withdraw feature for Shared Account.
	 * @param currency
	 * @param amount
	 */
	public void withdraw(String currency, double amount ) {
		Thread activeThread = Thread.currentThread();
		System.out.println("Thread named: " + activeThread.getName() + " going to withdraw...");
		Money temp = null;
		boolean found = false;
		int i = 0;
		synchronized(this) {
			for(Money m:moneyList) {
				if(m.getCurrency().equals(currency)) {
					temp = m;
					found = true;
				}
				if(!found) {
					i++;
				}
			}

			if(found) {
				if(temp.getBalance() < amount) { //BE CAREFUL!
					System.out.println("Less balance; waiting for deposit...");
					try {
						wait();
					} catch(Exception e) {
						e.printStackTrace();
					}
				}

				temp.setBalance(temp.getBalance() - amount);
				moneyList.set(i, temp);
				System.out.printf("[withdraw]current balance for %s(s) is %g  \n", temp.getCurrency(), temp.getBalance());
				System.out.println("Thread named: " + activeThread.getName() + " withdraw completed...");
			}
		}
	}

	/**
	 * the code for deposit feature for Shared Account.
	 * @param currency
	 * @param amount
	 */
	public void deposit(String currency, double amount) {
		Thread activeThread = Thread.currentThread();
		System.out.println("Thread named: " + activeThread.getName() + " going to deposit...");
		Money temp = null;
		boolean found = false;
		int i = 0;
		// Here, is the point there could be problems with concurrency, so we an synchronize the following code.
		synchronized(this) {
			for(Money m:moneyList) {
				if(m.getCurrency().equals(currency)) {
					temp = m;
					found = true;
				}
				if(!found) {
					i++;
				}
			}

			if(found) {
				temp.setBalance(temp.getBalance() + amount);
				moneyList.set(i, temp);
				System.out.printf("[deposit]current balance for %s(s) is %g  \n", temp.getCurrency(), temp.getBalance());
				System.out.println("Thread named: " + activeThread.getName() + " deposit completed... ");
				notify();
			}
		}
	}
}
