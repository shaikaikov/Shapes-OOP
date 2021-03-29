package ex4.geometry;
/**
 * This class represents a 2D point in the plane.
 * Do NOT change this class! It would be used as is for testing.
 * Ex4: you should NOT change this class!
 * @author boaz.benmoshe
 */


public class Point2D implements GeoShape{
    public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
    public static final Point2D ORIGIN = new Point2D(0,0);
    private double _x,_y;
    /**
     * 
     * @param x
     * @param y
     * constructor
     */
    public Point2D(double x,double y) {
    	_x=x; _y=y;
    }
    /**
     * 
     * @param p
     * constructor
     */
    public Point2D(Point2D p) {
       this(p.x(), p.y());
    }
    /**
     * 
     * @param s-String
     * constructor
     */
    public Point2D(String s) {
        try {
            String[] a = s.split(",");
            _x = Double.parseDouble(a[0]);
            _y = Double.parseDouble(a[1]);
        }
        catch(IllegalArgumentException e) {
            System.err.println("ERR: got wrong format string for Point2D init, got:"+s+"  should be of format: x,y");
            throw(e);
        }
    }
    /**
     * 
     * @return x
     */
    public double x() {return _x;}
    /**
     * 
     * @return y
     */
    public double y() {return _y;}
    /**
     * 
     * @return x-in int
     */
    public int ix() {return (int)_x;}
    /**
     * 
     * @return y-in int
     */
    public int iy() {return (int)_y;}
    /**
     * 
     * @param p
     * @return new point after the sum of p and original point
     */
    public Point2D add(Point2D p) {
    	Point2D a = new Point2D(p.x()+x(),p.y()+y());
    	return a;
    }
    /**
     * @return data of point-in String
     */
    @Override
    public String toString()
    {
        return _x+","+_y;
    }
    /**
     * 
     * @return distance between original point and 0,0 point
     */

    public double distance()
    {
        return this.distance(ORIGIN);
    }
    /**
     * @param p2-point
     * @return distance between original point and p2
     */
    public double distance(Point2D p2)
    {
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double t = (dx*dx+dy*dy);
        return Math.sqrt(t);
    }

    /**
     * @param p=point
     * @return true or false
     * Check of the p equal to the original point.
     */
    public boolean equals(Object p)
    {
        if(p==null || !(p instanceof Point2D)) {return false;}
        Point2D p2 = (Point2D)p;
        return ( (_x==p2._x) && (_y==p2._y));
    }
    public boolean close2equals(Point2D p2, double eps)
    {
        return ( this.distance(p2) < eps );
    }
    public boolean close2equals(Point2D p2)
    {
        return close2equals(p2, EPS);
    }
    /**
     * This method returns the vector between this point and the target point. The vector is represented as a Point2D.
     * @param target
     * @return vector(by point)
     */
    public Point2D vector(Point2D target) {
    	double dx = target.x() - this.x();
    	double dy = target.y() - this.y();
    	return new Point2D(dx,dy);
    }
    /**
     * @param ot-point
     * @return true or false.
     * Check of the p equal to the original point.
     */
	@Override
	public boolean contains(Point2D ot) {
		// TODO Auto-generated method stub
		return this.equals(ot);
	}
	/**
	 * @ return the point
	 */
	@Override
	public Point2D centerOfMass() {
		// TODO Auto-generated method stub
		return new Point2D(this);
	}
	/**
	 * @return 0
	 */
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * @return 0
	 */
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * @param vec-point2D
	 * set the new location of the point by the move the point with vec point
	 */
	@Override
	public void move(Point2D vec) {
		this._x += vec.x();
		this._y += vec.y();
	}
	/**
	 * @return the copy of the point(new object)
	 */
	@Override
	public GeoShape copy() {
		return new Point2D(this);
	}
	/**
	 * @return the array points of the point(one point)
	 */
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[1];
		ans[0] =new Point2D(this);
		return ans;
	}
}
