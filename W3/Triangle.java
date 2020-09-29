package shapes;

/**
 * Triangle class implements Shape
 * setter and getter for sideA, sideB, sideC and caliculate Perimeter
 * @param sideA, sideB, sideC
 * @author MonicaYam
 * @version 2.0
 *
 */

public class Triangle implements Shape {
	private double sideA;
	private double sideB;
	private double sideC;

	public Triangle(double a, double b, double c) throws TriangleException {
		if(a > 0 && b > 0 && c > 0) {
			if((a+b)>c && (a+c)>b && (b+c)>a) {
				sideA = a;
				sideB = b;
				sideC = c;
			}else {
				throw new TriangleException("Invalid side(s)!");
			}
		}else{
			throw new TriangleException("Invalid side(s)!");
		}
	}

	public boolean isTriangle(double a, double b, double c) {
		return ((a+b)>c && (a+c)>b && (b+c)>a)? true:false;
	}

	public void setSideA(double a) throws TriangleException {
		if(a > 0 && (getSideB() + getSideC()) > a) {
			sideA = a;
		}else{
			throw new TriangleException("Invalid side(s)!");
		}
	}

	public double getSideA() {
		return sideA;
	}

	public void setSideB(double b) throws TriangleException  {
		if(b > 0 && (getSideA() + getSideC()) > b) {
			sideB = b;
		}else{
			throw new TriangleException("Invalid side(s)!");
		}
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideC(double c) throws TriangleException  {
		if(c > 0 && (getSideA() + getSideB()) > c) {
			sideC = c;
		}else{
			throw new TriangleException("Invalid side(s)!");
		}
	}

	public double getSideC() {
		return sideC;
	}
	@Override
	public double getPerimeter() {
		return getSideA() + getSideB() + getSideC();
	}

	@Override
	public String toString() {
		return String.format("%s {s1=%s, s2=%s, s3=%s}",this.getClass().getSimpleName(), this.getSideA(),this.getSideB(),this.getSideC());
	}
}
