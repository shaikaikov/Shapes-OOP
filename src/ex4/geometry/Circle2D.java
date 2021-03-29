package ex4.geometry;
/** 
 * This class represents a 2D circle in the plane. Please make sure you update it 
 * according to the GeoShape interface.
 * Ex4: you can update this class (additional documentation is needed)!
 * @author boaz.benmoshe
 *
 */
//ask if need to complete something in this class.
public class Circle2D implements GeoShape{
	private Point2D _center;
	private double _radius;
	
	/**
	 * 
	 * @param cen-center of circle
	 * @param rad-the radius of the circle
	 * @throws RuntimeException -if the radius negative.
	 * here the constructor for build the circle.
	 */
	public Circle2D(Point2D cen, double rad)throws RuntimeException {
		if (rad<0) {
			this._radius=1;
			throw new RuntimeException("radius must be positive");
		}
		else {
			this._radius = rad;
		}
		this._center = new Point2D(cen);
		
	}
	/**
	 * 
	 * @return the radius
	 */
	public double getRadius() {return this._radius;}
	/**
	 * @return the data of the object in String
	 */
	 @Override
	    public String toString()
	    { return _center.toString()+", "+_radius;}
	 /**
	  * @param point
	  * @return boolean true or false if the point in the circle or if not
	  */
	@Override
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist<=this._radius;
		
	}
	/**
	 * @return new object-point of the center of the circle
	 */
	@Override
	public Point2D centerOfMass() {
		return new Point2D(this._center);
	}
	/**
	 * @return the area of the circle-by the equation of the are circle
	 */
	@Override
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}
	/**
	 * @return the perimeter of the circle-by the equation of the are circle
	 */
	@Override
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}
	/**
	 * @param vec-point2D
	 * set the new location of the circle by the move the center point with vec point
	 */
	@Override
	public void move(Point2D vec) {
		_center.move(vec);
	}
	/**
	 * @return the copy of the circle(new object)
	 */
	@Override
	public GeoShape copy() {
		return new Circle2D(_center, _radius);
	}
	/**
	 * @return the array points of the circle(the center point and the y+radius and x in the second point)
	 */
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[2];
		ans[0] =new Point2D(this._center);
		ans[1] = new Point2D(ans[0].x(), ans[0].y()+this._radius);
		return ans;
	}

}