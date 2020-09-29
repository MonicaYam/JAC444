package shapes;

public class Rectangle implements Shape {
	private double width;
	private double height;
	private ShapeArea area = () -> this.getWidth() * this.getHeight();

	public Rectangle(double w, double h) throws Exception{
		if(w > 0 && h > 0) {
			width = w;
			height = h;

		}else {
			throw new Exception("Invalid side!");
		}
	}

	public void setWidth(double w) throws Exception {
		if(w > 0) {
			width = w;
		}else {
			throw new Exception("Invalid side!");
		}
	}

	public double getWidth() {
		return width;
	}

	public void setHeight(double h) throws Exception {
		if(h > 0) {
			height =  h;
		}else {
			throw new Exception("Invalid side!");
		}
	}

	public double getHeight() {
		return height;
	}

	@Override
	public double getPerimeter() {
		return  (getWidth() + getHeight())*2;
	}

	@Override
	public String toString() {
		return (this.getClass().getSimpleName().equals("Parallelogram"))?
			String.format( "%s {w=%s, h=%s}, perimeter = %g", this.getClass().getSimpleName(), this.getWidth(), this.getHeight(), this.getPerimeter()):
			String.format( "%s {w=%s, h=%s}, perimeter = %g, area = %g", this.getClass().getSimpleName(), this.getWidth(), this.getHeight(), this.getPerimeter(), area.getArea());
	}
}
