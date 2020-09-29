package WS10;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface for Workshop10.
 * @author MonicaYam
 *
 */
public interface CarIntrface extends Remote {
	public String carRegistration(Car car) throws RemoteException;
}