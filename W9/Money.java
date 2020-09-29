package W9;

/**
 * Money class for Workshop9
 * it contains String currency and double balance
 * @author MonicaYam
 *
 */
public class Money {
	private String currency;
    private double balance;

	Money(String c, double b){
		currency = c;
		balance = b;
	}

	public void setCurrency(String c) {
		currency = c;
	}

	public String getCurrency() {
		return currency;
	}

	public void setBalance(double b) {
		balance = b;
	}
	public double getBalance() {
		return balance;
	}
}
