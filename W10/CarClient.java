package WS10;

import java.rmi.Naming;

/**
 * Client code for workshop10.
 * try to connect localhost:7777 and use CarRegistrationService
 * @author MonicaYam
 *
 */
public class CarClient {
	Car obj = null;

	public static void main(String[] args){
		System.out.println("Registration new car.");

		try {
			Car car = new Car("Corolla", "White", 30000);
			System.out.println("--- New Car Information ---");
			System.out.println(car.toString());

			CarIntrface ci = (CarIntrface) Naming.lookup("rmi://localhost:7777/CarRegistrationService");
			car.setPlate(ci.carRegistration(car));
			System.out.println("Success to registered new car.");
			System.out.println("--- Registered Car Information ---");
			System.out.println(car.toString());

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
