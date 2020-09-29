package WS10;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * implementation file for car interface
 * @author MonicaYam
 *
 */
public class CarImpl extends UnicastRemoteObject implements CarIntrface {
	public CarImpl() throws RemoteException {
		super();
	}


	public String carRegistration(Car car) throws RemoteException{
			return String.valueOf(car.hashCode());
	}
}
