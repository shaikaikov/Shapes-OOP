package ex4.geometry;
/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author shai kaikov.
 * here all the functions and constructors of the Triangle2D class.
 *
 */
public class Triangle2D implements GeoShape{
	
	private Point2D p1;
	private Point2D p2;
	private Point2D p3;
	/**
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 * Constructor for Triangle2D
	 */
	public Triangle2D(Point2D p1,Point2D p2,Point2D p3){
		this.p1=new Point2D(p1);
		this.p2=new Point2D(p2);
		this.p3=new Point2D(p3);
		
	}
	/**
	 * https://www.quora.com/How-do-I-check-whether-a-given-point-lies-inside-a-triangle-whose-coordinates-are-given
	 * @param point ot.
	 * @return true or false.
	 * I check in Internet how to check if point inside triangle.
	 * just calculate the area with ot point with the others two points that 
	 * belong to the triangle -than I did sum and equal to the original triangle area-
	 * if equal than the point inside the triangle-else its outside
	 */
	
	@Override
	public boolean contains(Point2D ot) {
		   double ABC = this.area();
		   Triangle2D TPBC=new Triangle2D(ot,this.p2,this.p3);
		   Triangle2D TAPC=new Triangle2D(this.p1,ot,this.p3);
		   Triangle2D TABP=new Triangle2D(this.p1,this.p2,ot);
		  
		     
		   double PBC = TPBC.area();
		   double APC=TAPC.area();
		   double ABP=TABP.area();
		   double d1=ABC;
		   String st1 = String.format("%.5f", d1);
		   d1=(Double.parseDouble(st1));
		   double d2=PBC+APC+ABP;
		   String st = String.format("%.5f", d2);
		   d2=(Double.parseDouble(st));
		   return (d1 == d2); 
	}

	/**
	 * @return the center of triangle(point)
	 * use the equation-midpoint
	 */
	@Override
	public Point2D centerOfMass() {
		double px=((this.p1.x()+this.p2.x()+this.p3.x())/3);
		double py=((this.p1.y()+this.p2.y()+this.p3.y())/3);
		return new Point2D(px,py);
		
	}

	/**
	 * https://en.wikipedia.org/wiki/Heron%27s_formula
	 * d = peremiter/2;
	 * area = Math.sqrt((d-a)(d-b)(d-c)),  a,b,c are the edges length
	 * Calculate according the equation.
	 * @return the area of triangle
	 */
	@Override
	public double area() {
	double d=(this.perimeter()/2);
	double a=this.p1.distance(this.p2);
	double b=this.p1.distance(this.p3);
	double c=this.p2.distance(this.p3);
	return (Math.sqrt(d*(d-a)*(d-b)*(d-c)));
	}

	/**
	 * return the perimeter of triangle-use the function if the point distance
	 */
	@Override
	public double perimeter() {
		return (this.p1.distance(this.p2)+this.p1.distance(this.p3)+this.p2.distance(this.p3));
	}

	/**
	 * @param vec-point2D
	 * set the new location of the triangle by the move the points with vec point
	 */
	@Override
	public void move(Point2D vec) {
		this.p1.move(vec);
		this.p2.move(vec);
		this.p3.move(vec);
		
	}

	/**
	 * @return the copy of the triangle(new object)
	 */
	@Override
	public GeoShape copy() {
		return new Triangle2D(this.p1,this.p2,this.p3);
	}

	/**
	 * @return the array points of the triangle(three points)
	 */
	@Override
	public Point2D[] getPoints() {
		Point2D[] trangle=new Point2D[3];
	    trangle[0]=new Point2D(this.p1);
	    trangle[1]=new Point2D(this.p2);
	    trangle[2]=new Point2D(this.p3);
	    return trangle;
		
	}
	/**
	 * @return the data of the object in String
	 */
	@Override
	public String toString() {
		return this.p1.toString()+","+this.p2.toString()+","+this.p3.toString();
	}
}
