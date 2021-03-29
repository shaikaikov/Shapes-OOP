package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;





import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.util.Scanner;

import ex4.Ex4;
import ex4.Ex4_Const;
import ex4.GUIShape;
import ex4.GUI_Shape;
import ex4.GUI_Shape_Collection;
import ex4.Shape_Comp;
import ex4.StdDraw;
import ex4.geometry.*;
/**
 * 
 * @author shai kaikov.
 * here are all the tests for the functions and constructors of the GUIShape class.
 * 
 *
 */
class GUIShape_test {

	@Test
	void gUIShape_test() {

		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		assertTrue(g1.getShape().equals(p));
		Point2D[] arp=g2.getShape().getPoints();
		assertTrue(arp[0].equals(new Point2D(2,0)));
		assertTrue(arp[1].equals(new Point2D(-4.3,5)));
		assertTrue(arp[2].equals(new Point2D(5,6)));
		assertTrue(g1.isFilled());
		assertFalse(g2.isFilled());
		assertEquals(1,g1.getTag());
		assertEquals(2,g2.getTag());
		assertEquals(Color.black.getRGB(),g1.getColor().getRGB());
		assertEquals(Color.red.getRGB(),g2.getColor().getRGB());
		GUI_Shape g0= new  GUIShape(null,false,null,2);
        assertNull(g0.getColor());
        assertNull(g0.getShape());
	}

	@Test
	void GUIShapeD_test() {
		GUI_Shape g1=new GUIShape();
		assertNull(g1.getColor());
		assertNull(g1.getShape());
		assertEquals(false,g1.isFilled());
		assertEquals(0,g1.getTag());	

	}
	@Test
	void getShape_test() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		Segment2D se=new Segment2D(new Point2D(2.3,4),new Point2D(-1,-4.4));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		GUI_Shape g3=new GUIShape(se,true,Color.red,3);
		assertTrue(g1.getShape().equals(p));
		Point2D[] arp=g2.getShape().getPoints();
		assertTrue(arp[0].equals(new Point2D(2,0)));
		assertTrue(arp[1].equals(new Point2D(-4.3,5)));
		assertTrue(arp[2].equals(new Point2D(5,6)));
		Point2D[] arp1=g3.getShape().getPoints();
		assertTrue(arp1[0].equals(new Point2D(2.3,4)));
		assertTrue(arp1[1].equals(new Point2D(-1,-4.4)));
		GUI_Shape g0=new GUIShape();
		assertNull(g0.getShape());
	    
	}
	@Test
	void setShape_test() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		Segment2D se=new Segment2D(new Point2D(2.3,4),new Point2D(-1,-4.4));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		assertTrue(g1.getShape().equals(p));
		g1.setShape(t);
		Point2D[] arp=g1.getShape().getPoints();
		assertTrue(arp[0].equals(new Point2D(2,0)));
		assertTrue(arp[1].equals(new Point2D(-4.3,5)));
		assertTrue(arp[2].equals(new Point2D(5,6)));
		g1.setShape(se);
		Point2D[] arp1=g1.getShape().getPoints();
		assertTrue(arp1[0].equals(new Point2D(2.3,4)));
		assertTrue(arp1[1].equals(new Point2D(-1,-4.4)));
		g1.setShape(null);
		assertNull(g1.getShape());
	}
	@Test
	void isFilled_test() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		Segment2D se=new Segment2D(new Point2D(2.3,4),new Point2D(-1,-4.4));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		GUI_Shape g3=new GUIShape(se,true,Color.red,3);
		assertTrue(g1.isFilled());
		assertFalse(g2.isFilled());
		assertTrue(g3.isFilled());
		
	}
	@Test
	void setFilled_test() {
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		g2.setFilled(true);
		assertTrue(g2.isFilled());
		g2.setFilled(false);
		assertFalse(g2.isFilled());
		g2.setFilled(false);
		assertFalse(g2.isFilled());
	}
	@Test
	void getColor_test() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		assertEquals(Color.black.getRGB(),g1.getColor().getRGB());
		assertEquals(Color.red.getRGB(),g2.getColor().getRGB());
		GUI_Shape g0=new GUIShape();
		assertNull(g0.getColor());
	}
	@Test
	void setColor_test() {
		
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		GUI_Shape g2=new GUIShape(t,false,Color.orange,2);
		g2.setColor(Color.black);
		assertEquals(Color.black.getRGB(),g2.getColor().getRGB());
		g2.setColor(Color.red);
		assertEquals(Color.red.getRGB(),g2.getColor().getRGB());
		g2.setColor(null);
		assertNull(g2.getColor());
	}
	@Test
	void getTag_test() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		assertEquals(1,g1.getTag());
		assertEquals(2,g2.getTag());
	}
	@Test
	void setTag_test() {
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		GUI_Shape g2=new GUIShape(t,false,Color.orange,2);
		g2.setTag(5);
		assertEquals(5,g2.getTag());
		g2.setTag(2);
		assertEquals(2,g2.getTag());
	}
	@Test
	void copy_test() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		GUI_Shape g3=g1.copy();
		GUI_Shape g4=g2.copy();
		assertTrue(g1.getShape().equals(g3.getShape()));
		Point2D[] arp=g2.getShape().getPoints();
		Point2D[] arp1=g4.getShape().getPoints();
		assertTrue(arp[0].equals(arp1[0]));
		assertTrue(arp[1].equals(arp1[1]));
		assertTrue(arp[2].equals(arp1[2]));
		assertEquals(g3.isFilled(),g1.isFilled());
		assertEquals(g4.isFilled(),g2.isFilled());
		assertEquals(1,g3.getTag());
		assertEquals(2,g4.getTag());
		assertEquals(Color.black.getRGB(),g3.getColor().getRGB());
		assertEquals(Color.red.getRGB(),g4.getColor().getRGB());
	}
	
	@Test
	void toString_test() {
		Circle2D c=new Circle2D(new Point2D(-0.2,1),3);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		GUI_Shape g1=new GUIShape(c,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		assertTrue(g1.toString().equals("Circle2D,-0.2,1.0, 3.0,true,-16777216,1"));
		assertTrue(g2.toString().equals("Triangle2D,2.0,0.0,-4.3,5.0,5.0,6.0,false,-65536,2"));
		
	}
}


