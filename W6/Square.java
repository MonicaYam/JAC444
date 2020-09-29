package shapes;

public class Square extends Rectangle{

	public Square(double s) throws Exception{
		super(s,s);
	}

	@Override
	public void setWidth(double s) throws Exception {
		super.setWidth(s);
		super.setHeight(s);

	}

	@Override
	public void setHeight(double s) throws Exception{
		super.setWidth(s);
		super.setHeight(s);
	}
}
