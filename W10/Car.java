package WS10;

import java.io.Serializable;
/**
 * Car class for workshop10
 * contains model, color, plate and mileage
 * @author MonicaYam
 *
 */
public class Car implements Serializable {
	private String model;
	private String color;
	private String plate;
	private int mileage;

	Car(String m, String c, int mlg){
		if(!m.isEmpty() && m != null) {
			model = m;
		}

		if(!c.isEmpty() && c != null) {
			color = c;
		}

		mileage = mlg;
		plate = "Undefined";
	}

	public void setModel(String m) {
		if(!m.isEmpty() && m != null) {
			model = m;
		}
	}

	public String getModel() {
		return model;
	}

	public void setColor(String c) {
		if(!c.isEmpty() && c != null) {
			color = c;
		}
	}

	public String getColor() {
		return color;
	}

	public void setMirage(int ml) {
		if(ml > 0) {
			mileage= ml;
		}
	}

	public int getMileage() {
		return mileage;
	}

	public void setPlate(String p) {
		if(!p.isEmpty() && p != null) {
			plate = p;
		}
	}

	public String getPlate() {
		return plate;
	}

	@Override
	public String toString() {
		return String.format("Model: %s, Color: %s, Milage: %s, Plate: %s%n", this.getModel(), this.getColor(), this.getMileage(), this.getPlate());
	}
}
