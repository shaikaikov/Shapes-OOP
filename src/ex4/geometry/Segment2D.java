package ex4.geometry;

import ex4.Ex4_Const;
/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author shai kaikov.
 * here all the functions and constructors of the Segment2D class.
 *
 */
public class Segment2D implements GeoShape{

	private Point2D p1;
	private Point2D p2;

	/**
	 * 
	 * @param p1
	 * @param p2
	 * Constructor for Segment2D
	 */
	public Segment2D(Point2D p1,Point2D p2){
		this.p1=new Point2D(p1);
		this.p2=new Point2D(p2);
	}

	/**
	 * @param point-ot.
	 * @return true or false.
	 * first I build the linear equation of the segment and check if
	 * the point ot in the linear equation if not false-else I check if ot
	 * between the two points of the segment-if not false else-true.
	 */
	@Override
	public boolean contains(Point2D ot) {
		double m=0;
		double n=0;
		boolean flag=false;
		if(!this.p1.equals(this.p2)) {
			m=((this.p2.y()-this.p1.y())/(this.p2.x()-this.p1.x()));
			n=(-m*this.p1.x())+this.p1.y();
			flag=true;
		}

		double maxx=Math.max(this.p1.x(), this.p2.x());
		double minx=Math.min(this.p1.x(), this.p2.x());
		double maxy=Math.max(this.p1.y(), this.p2.y());
		double miny=Math.min(this.p1.y(), this.p2.y());

		boolean Cheakm=true;
		if(flag) {
			Cheakm=(ot.y()==((ot.x()*m)+n));
		}
		return Cheakm && ((maxx>=ot.x()) && (minx<=ot.x()) && (maxy>=ot.y()) && (miny<=ot.y()));
	}

	/**
	 * @return the center of the segment(point)
	 * use the equation-midpoint
	 */
	@Override
	public Point2D centerOfMass() {
		double x1=((this.p1.x()+this.p2.x())/2);
		double y1=((this.p1.y()+this.p2.y())/2);
		Point2D pr=new Point2D(x1,y1);
		return pr;
	}

	/**
	 * @return 0.segment have no area
	 */
	@Override
	public double area() {
		return 0;
	}

	/**
	 * @return perimeter- 2*length of the segment
	 */
	@Override
	public double perimeter() {
		return (2*(this.p1.distance(this.p2)));
	}

	/**
	 * @param vec-point2D
	 * set the new location of the segment by the move the points with vec point
	 */
	@Override
	public void move(Point2D vec) {
		this.p1.move(vec);
		this.p2.move(vec);
	}

	/**
	 * 
	 * @return the copy of the segment(new object)
	 */
	 
	
	@Override
	public GeoShape copy() {
		return new Segment2D(this.p1,this.p2);
	}
	/**
	 * @return the array points of the segment(three points)
	 */
	@Override
	public Point2D[] getPoints() {
		Point2D[] segment=new Point2D[2];
		segment[0]=new Point2D(this.p1);
		segment[1]=new Point2D(this.p2);
		return segment;
	}
	/**
	 * @return the data of the object in String
	 */
	@Override
	public String toString() {
		return this.p1.toString()+","+this.p2.toString();
	}



}