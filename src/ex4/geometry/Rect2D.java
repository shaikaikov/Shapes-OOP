package ex4.geometry;
/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author shai kaikov.
 * here all the functions and constructors of the Rect2D class.
 */
//fix
public class Rect2D implements GeoShape{

	private Point2D p1;
	private Point2D p2;
	private Point2D p3;
	private Point2D p4;
	/**
	 * 
	 * @param p1
	 * @param p2
	 * 
	 * Constructor for Rect2D-create rectangle with four points
	 */
	public Rect2D(Point2D p1,Point2D p2){
		this.p1=new Point2D(p1);
		this.p3=new Point2D(p2);
		this.p2=new Point2D(p1.x(),p2.y());
		this.p4=new Point2D(p2.x(),p1.y());
	}
	
	
	/**
	 * @param point ot.
	 * @return true or false.
	 * here I used the array points of the rectangle and check if the point 
	 * between the max-min points.
	 */
	@Override
	public boolean contains(Point2D ot) {
		Point2D [] arrp=this.getPoints();
		return ((arrp[1].x()>=ot.x() && arrp[1].y()>=ot.y()) && (arrp[0].x()<=ot.x() && arrp[0].y()<=ot.y()));
	}
	/**
	 * @return the center of rectangle(point)
	 * use the equation-midpoint
	 */
	@Override
	public Point2D centerOfMass() {
		double midx=((this.p3.x()+this.p1.x())/2);
		double midy=((this.p3.y()+this.p1.y())/2);
		return new Point2D(midx,midy);
	}
	/**
	 * @return the area of rectangle
	 * work with the equation of area rectangle
	 */
	@Override
	public double area() {
		double per=(Math.abs(this.p2.distance(this.p1)))*(Math.abs(this.p3.distance(this.p2)));
		return per;
	}
	/**
	 * return the perimeter of rectangle-use the function if the point distance
	 */
	@Override
	public double perimeter() {
		return ((2*(Math.abs(this.p2.distance(this.p1))))+(2*(Math.abs(this.p3.distance(this.p2)))));
	}

	/**
	 * @param vec-point2D
	 * set the new location of the rectangle by the move the points with vec point
	 */
	@Override
	public void move(Point2D vec) {
		this.p1.move(vec);
		this.p2.move(vec);
		this.p3.move(vec);
		this.p4.move(vec);
	}
	/**
	 * @return the copy of the rectangle(new object)
	 */
	@Override
	public GeoShape copy() {
		return new Rect2D(this.p1,this.p3);
	}

	/**
	 * @return array of points=max and min-arr[0]-min.arr[1]-max
	 * I found the max and min-x and y of the points and than I equaled them 
	 * to the points and than returned the min-max points.
	 */
	@Override
	public Point2D[] getPoints() {
		Point2D [] arrp=new Point2D[2];
		double maxx=Math.max(Math.max(this.p1.x(),this.p2.x()),Math.max(this.p3.x(),this.p4.x()));
		double maxy=Math.max(Math.max(this.p1.y(),this.p2.y()),Math.max(this.p3.y(),this.p4.y()));
		double minx=Math.min(Math.min(this.p1.x(),this.p2.x()),Math.min(this.p3.x(),this.p4.x()));
		double miny=Math.min(Math.min(this.p1.y(),this.p2.y()),Math.min(this.p3.y(),this.p4.y()));
		if(this.p1.x()==maxx && this.p1.y()==maxy) {
			arrp[1]=new Point2D(this.p1);
		}
		else if(this.p2.x()==maxx && this.p2.y()==maxy) {
			arrp[1]=new Point2D(this.p2);
		}
		else if(this.p3.x()==maxx && this.p3.y()==maxy) {
			arrp[1]=new Point2D(this.p3);
		}
		else if(this.p4.x()==maxx && this.p4.y()==maxy) {
			arrp[1]=new Point2D(this.p4);
		}
		
		if(this.p1.x()==minx && this.p1.y()==miny) {
			arrp[0]=new Point2D(this.p1);
		}
		else if(this.p2.x()==minx && this.p2.y()==miny) {
			arrp[0]=new Point2D(this.p2);
		}
		else if(this.p3.x()==minx && this.p3.y()==miny) {
			arrp[0]=new Point2D(this.p3);
		}
		else if(this.p4.x()==minx && this.p4.y()==miny) {
			arrp[0]=new Point2D(this.p4);
		}
	
		return arrp;
	}
	/**
	 * @return the data of the object in String
	 */
	@Override
	public String toString() {
		return this.p1.toString()+","+this.p3.toString();
	}

}