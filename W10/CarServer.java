package WS10;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Server side code for workshop 10.
 * bind 7777 as working for CarRegistrationService
 * @author MonicaYam
 *
 */
public class CarServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				// Create the object implemtation
				CarImpl obj = new CarImpl();

				// Remember to run rmiregistry first!
				Registry reg = LocateRegistry.createRegistry(7777);
				reg.rebind("CarRegistrationService", obj);


				System.out.println("CarRegistrationService bound in registry");
				System.out.println("CarRegistrationService is running");
			} catch (Exception e) {
				System.err.println("Problem: " + e);
				System.exit(1);
			}
	}

}
