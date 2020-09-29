package W9;

/**
 * Deposit class for Workshop9
 * it contains SharedAccount for variable.
 * implements Runnable class to use run method.
 * @author MonicaYam
 *
 */
public class Deposit implements Runnable {
	private SharedAccount account;

	Deposit(SharedAccount a){
		account = a;
	}

	public void run() {
		Thread activeThread = Thread.currentThread();

		System.out.println("Thread named: " + activeThread.getName() + " about to deposit\n");
		for(int i = 0; i < 6; i++) {
			account.deposit("pound", 1);
			account.deposit("euro", 1);
			account.deposit("dollar", 1);

			try {
				Thread.sleep((long)(Math.random() *1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
