package shapes;

/**
 * Parallelogram class implements Shape class
 * over ride getPerimeter to caliculate this Perimeter
 * @param width, height
 * @author MonicaYam
 * @version 2.0
 *
 */
public class Parallelogram implements Shape{
	private double width;
	private double height;

	public Parallelogram(double w, double h) throws ParallelogramException{
		if(w > 0 && h > 0) {
			width = w;
			height = h;

		}else {
			throw new ParallelogramException("Invalid side!");
		}
	}

	public void setWidth(double w) throws ParallelogramException {
		if(w > 0) {
			width = w;
		}else {
			throw new ParallelogramException("Invalid side!");
		}
	}

	public double getWidth() {
		return width;
	}

	public void setHeight(double h) throws ParallelogramException {
		if(h > 0) {
			height =  h;
		}else {
			throw new ParallelogramException("Invalid side!");
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
		return String.format( "%s {w=%s, h=%s} ", this.getClass().getSimpleName(), this.getWidth(), this.getHeight());
	}
}
