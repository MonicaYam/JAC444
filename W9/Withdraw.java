package W9;

/**
 * Withdraw class for Workshop9
 * it contains SharedAccount for variable.
 * implements Runnable class to use run method.
 * @author MonicaYam
 *
 */
public class Withdraw implements Runnable {
	private SharedAccount account;

	Withdraw(SharedAccount a){
		account = a;
	}

	public void run() {
		Thread activeThread = Thread.currentThread();

		System.out.println("Thread named: " + activeThread.getName() + " about to withdraw\n");
		for(int i = 0; i < 6; i++) {
			account.withdraw("pound", 1);

				try {
					Thread.sleep((long)(Math.random() *1000));
				}catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}

	}
}
