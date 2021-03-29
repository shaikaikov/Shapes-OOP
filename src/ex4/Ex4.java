package ex4;
import java.awt.Color;

import ex4.geometry.*;
/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 * 
 *
 */

/**
 * 
 * @author shai kaikov
 * this class represent the Ex4 class-class with GUI_Shape_Collection
 * parameter.all the implementations of the functions and the constructors are here.
 *
 */
public class Ex4 implements Ex4_GUI{

	private GUI_Shape_Collection go;
	/**
	 * @param g-the GUI_Shape_Collection parameter that with that
	 * I point the go parameter to him.
	 */
	@Override
	public void init(GUI_Shape_Collection g) {
		this.go=g;

	}

	/**
	 * @return the GUI_Shape_Collection object(the object that
	 * belong to the Ex4 object).
	 * 
	 */
	@Override
	public GUI_Shape_Collection getShape_Collection() {
		if(this.go!=null) {
			return this.go;
		}
		else {
			this.go=new Shape_Collection();
			return this.go;
		}


	}

	/**
	 * here I create the GUI and represent the shapes.
	 * I pass on loop(on array of the collection) one by one
	 * and check if according to the parameters if to draw the shape with
	 * full color or not.in addition here I set the color of the shape-according the color parameter.
	 * in the end I show the draws.
	 */
	@Override
	public void show() {

		for (int i=0;i<this.go.size();i++) {
			if(this.go.get(i).getShape() instanceof Point2D) {
				StdDraw.setPenColor(this.go.get(i).getColor());
				StdDraw.point(((Point2D)this.go.get(i).getShape()).x(), ((Point2D)this.go.get(i).getShape()).y());
				
			}
		
			else if(this.go.get(i).getShape() instanceof Triangle2D) {
				StdDraw.setPenColor(this.go.get(i).getColor());
				if(this.go.get(i).isFilled()) {
					Point2D [] arp=this.go.get(i).getShape().getPoints();
					double[] x=new double[3];
					double [] y=new double[3];
					for(int r=0;r<arp.length;r++) {
						x[r]=arp[r].x();
						y[r]=arp[r].y();
					}
					StdDraw.filledPolygon(x, y);
				}
				else {
					Point2D [] arp=this.go.get(i).getShape().getPoints();
					double[] x=new double[3];
					double [] y=new double[3];
					for(int r=0;r<arp.length;r++) {
						x[r]=arp[r].x();
						y[r]=arp[r].y();
					}
					StdDraw.polygon(x, y);
				}
			}
			else if(this.go.get(i).getShape() instanceof Circle2D) {
				StdDraw.setPenColor(this.go.get(i).getColor());
				if(this.go.get(i).isFilled()) {
					double rad=((Circle2D)this.go.get(i).getShape()).getRadius();
					Point2D p=((Circle2D)this.go.get(i).getShape()).centerOfMass();
					StdDraw.filledCircle(p.x(), p.y(), rad);
				}
				else {
					double rad=((Circle2D)this.go.get(i).getShape()).getRadius();
					Point2D p=((Circle2D)this.go.get(i).getShape()).centerOfMass();
					StdDraw.circle(p.x(), p.y(), rad);

				}
			}

			else if(this.go.get(i).getShape() instanceof Rect2D) {
				StdDraw.setPenColor(this.go.get(i).getColor());
				if(this.go.get(i).isFilled()) {

					Point2D center=this.go.get(i).getShape().centerOfMass();
					Point2D[] arp=this.go.get(i).getShape().getPoints();
					double x=(arp[1].x()-arp[0].x())/2;
					double y=(arp[1].y()-arp[0].y())/2;
					StdDraw.filledRectangle(center.x(), center.y(),x, y);

				}
				else{
					Point2D center=this.go.get(i).getShape().centerOfMass();
					Point2D[] arp=this.go.get(i).getShape().getPoints();
					double x=(arp[1].x()-arp[0].x())/2;
					double y=(arp[1].y()-arp[0].y())/2;
					StdDraw.rectangle(center.x(), center.y(), x, y);
				}
			}
			else if(this.go.get(i).getShape() instanceof Segment2D) {
				StdDraw.setPenColor(this.go.get(i).getColor());
				Point2D[] ps=((Segment2D)this.go.get(i).getShape()).getPoints();
				StdDraw.line(ps[0].x(),ps[0].y(),ps[1].x(),ps[1].y());
				

			}
			
	

		}

		StdDraw.show();

	}
	

	/**
	 * @return the data of the object-in String.
	 */
	@Override
	public String getInfo() {
		return (this.go.toString());
	}
}