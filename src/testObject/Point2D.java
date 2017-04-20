package testObject;

public class Point2D {

	public int x,y;
	public Point2D() {
		x=0;y=0;
		return;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o==null){return false;}
		if(this==o){return true;}
		if(!(o instanceof Point2D)){return false;}
		Point2D in=(Point2D)o;
		
		if(x!=in.x || y!=in.y)
		{
			return false;
		}
		
		return true;
	}


	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}
	
	

}
