package shapes;

/**
 * Circle class is implementing Shape class and caliculate Perimeter
 * @param radius
 * @author MonicaYam
 * @version 2.0
 *
 */
public class Circle implements Shape {
	private double radius;
	private ShapeArea area = () -> (this.getRadius() * this.getRadius()) * Math.PI;

	public Circle(double r) throws Exception {
		if(r > 0) {
			radius = r;
		}else {
			throw new Exception("Invalid radius!");
		}
	}

	public void setRadius(double r) throws Exception {
		if(r > 0) {
			radius = r;
		}else {
			throw new Exception("Invalid radius!");
		}
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double getPerimeter() {
		return (getRadius() * 2) * Math.PI;
	}


	@Override
	public String toString() {
		return String.format("%s {r=%s}, perimeter = %g, area = %g ",this.getClass().getSimpleName(), this.getRadius(), this.getPerimeter(), area.getArea());
	}
}