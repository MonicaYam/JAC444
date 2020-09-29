package W9;

import java.util.ArrayList;
import java.util.List;

/**
 * multi thread and exclusive control program
 * @author MonicaYam
 *
 */
public class OnlineBankSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			List<Money> moneyList = new ArrayList<Money>();
			moneyList.add(new Money("dollar", 1));
			moneyList.add(new Money("euro", 2));
			moneyList.add(new Money("pound",3));

			SharedAccount account = new SharedAccount(moneyList);

			Deposit deposit = new Deposit(account);
			Withdraw withdraw = new Withdraw(account);


			Thread myThread = new Thread(deposit, "me");
			Thread myFriendsThread = new Thread(withdraw, "my friend");

			myThread.start();
			myFriendsThread.start();

			try {
				myThread.join();
				myFriendsThread.join();

				System.out.println("Done all transactions!");
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

	}
}
