package ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * 
 */
import java.awt.Color;

import ex4.geometry.*;

/**
 * 
 * @author shai kaikov
 * this class represent the GUIShape class-class with shape,flag,color and tag
 * parameters.all the implementations of the functions and the constructors are here.
 *
 */
public class GUIShape implements GUI_Shape{


	private GeoShape shape;
	private boolean flag;
	private Color color;
	private int tag;


	/**
	 * 
	 * @param shape
	 * @param flag-boolean
	 * @param color-color
	 * @param tag-kind of number
	 * Constructor-in the start I recognize the shape and with that I build the object
	 * -with all the rest of the parameters
	 */
	
	public GUIShape(GeoShape shape,boolean flag,Color color , int tag) {
		if(shape instanceof Point2D) {
			this.shape=new Point2D((Point2D)shape);
		}
		else if(shape instanceof Segment2D) {
			this.shape=((Segment2D)shape).copy();
		}
		else if(shape instanceof Circle2D) {
			this.shape=((Circle2D)shape).copy();
		}
		else if(shape instanceof Rect2D) {
			this.shape=((Rect2D)shape).copy();
		}
		else if(shape instanceof Triangle2D) {
			this.shape=((Triangle2D)shape).copy();
		}
		else {
			this.shape=null;
		}

		this.flag=flag;
		if(color==null) {
			this.color=null;
		}
		else {
			this.color=new Color(color.getRGB());
		}
		this.tag=tag;
	}

	/**
	 * default Constructor
	 */
	public GUIShape() {
		this.shape=null;
		this.flag=false;
		this.color=null;
		this.tag=0;
	}
	/**
	 * @return shape(the copy of the shape) else return null
	 */
	@Override
	public GeoShape getShape() {
		if(this.shape instanceof Point2D) {
			return new Point2D((Point2D)shape);
		}
		else if(this.shape instanceof Segment2D) {
			return ((Segment2D)shape).copy();
		}
		else if(this.shape instanceof Circle2D) {
			return ((Circle2D)shape).copy();
		}
		else if(this.shape instanceof Rect2D) {
			return ((Rect2D)shape).copy();
		}
		else if(this.shape instanceof Triangle2D) {
			return ((Triangle2D)shape).copy();
		}
		return null;
	}

	/**
	 * @param g- by him I set new shape for the GUIShape object(copy of g)
	 */
	@Override
	public void setShape(GeoShape g) {
		if(g instanceof Point2D) {
			this.shape=new Point2D((Point2D)g);
		}
		else if(g instanceof Segment2D) {
			this.shape=((Segment2D)g).copy();
		}
		else if(g instanceof Circle2D) {
			this.shape=((Circle2D)g).copy();
		}
		else if(g instanceof Rect2D) {
			this.shape=((Rect2D)g).copy();
		}
		else if(g instanceof Triangle2D) {
			this.shape=((Triangle2D)g).copy();
		}
		else { 
			this.shape=null;
		}
	}

	/**
	 * @return boolean for flag parameter
	 */
	@Override
	public boolean isFilled() {
		return this.flag;	

	}

	/**
	 * @param filled-set the boolean parameter for flag
	 */
	@Override
	public void setFilled(boolean filled) {
		this.flag=filled;
	}

	/**
	 * @return Color object(copy of him).if there is no color object-return null.
	 */
	@Override
	public Color getColor() {
		if(this.color==null) {
			return null;
		}
		else {
			return new Color(this.color.getRGB());

		}
	}
	/**
	 * @param cl -Color object.
	 * set color parameter to cl.if cl null set parameter color to null
	 */
	@Override
	public void setColor(Color cl) {
		if(cl==null) {
			this.color=null;
		}
		else {
			this.color=new Color(cl.getRGB());

		}
	}
	/**
	 * @return tag parameter
	 */
	@Override
	public int getTag() {
		return this.tag;
	}

	/**
	 * @param-tag.
	 * set tag parameter
	 */
	@Override
	public void setTag(int tag) {
		this.tag=tag;
	}

	/**
	 * @return copy of the GUIShape object.
	 */
	@Override
	public GUI_Shape copy() {
		return new GUIShape(this.shape,this.flag,this.color,this.tag);
	}
	/**
	 * @return the data of the object(String).
	 */
	@Override
	public String toString() {

		String t="GUIShape,";
		if(this.shape instanceof Point2D) {
			t=t+((color.getRed()*65536)+(this.color.getGreen()*256)+this.color.getBlue())+","+this.flag+","+this.tag;
			t=t+",Point2D,"+((Point2D)this.shape).toString();
			
		}
		else if(this.shape instanceof Segment2D) {
			t=t+((color.getRed()*65536)+(this.color.getGreen()*256)+this.color.getBlue())+","+this.flag+","+this.tag;
			t=t+",Segment2D,"+((Segment2D)this.shape).toString();
		}
		else if(this.shape instanceof Circle2D) {
			
			t=t+((color.getRed()*65536)+(this.color.getGreen()*256)+this.color.getBlue())+","+this.flag+","+this.tag;
			t=t+",Circle2D,"+((Circle2D)this.shape).toString();
		}
		else if(this.shape instanceof Rect2D) {
			t=t+((color.getRed()*65536)+(this.color.getGreen()*256)+this.color.getBlue())+","+this.flag+","+this.tag;
			t=t+",Rect2D,"+((Rect2D)this.shape).toString();
		}
		else if(this.shape instanceof Triangle2D) {
			t=t+((color.getRed()*65536)+(this.color.getGreen()*256)+this.color.getBlue())+","+this.flag+","+this.tag;
			t=t+",Triangle2D,"+((Triangle2D)this.shape).toString();
		}
		return t;
	}
}