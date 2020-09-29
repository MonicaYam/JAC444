package shapes;

/**
 * Square is extending Rectangle class.
 * Over ride setter for Width and Height and caliculate Perimeter.
 * @author MonicaYam
 * @version 2.0
 *
 */
public class Square extends Rectangle{

	public Square(double s) throws SquareException, ParallelogramException{
		super(s,s);
	}

	@Override
	public void setWidth(double s) throws ParallelogramException {
		super.setWidth(s);
		super.setHeight(s);

	}

	@Override
	public void setHeight(double s) throws ParallelogramException{
		super.setWidth(s);
		super.setHeight(s);
	}
}
