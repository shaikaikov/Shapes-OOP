package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;
import org.junit.jupiter.api.Test;
import java.awt.Color;
import java.text.DecimalFormat;
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
 * @author shai kaikov
 * the tests here are for Circle2D class
 *
 */
class Circle2D_test {

	@Test
	void circle2D_test() {
	Point2D p=new Point2D(0,0.0);
	Point2D p1=new Point2D(-23.33,4.55);
	Circle2D se=new Circle2D(p,3.1);
	Circle2D se1=new Circle2D(p1,2.4);
	Point2D[] pa=se.getPoints();
	Point2D[] pa1=se1.getPoints();
	assertTrue(pa[0].equals(p));
	double dx=0;
	double dy=0;
	String strdx = String.format("%.2f", pa[1].x());
	String strdy = String.format("%.2f", pa[1].y());
	pa[1]=new Point2D(Double.parseDouble(strdx),Double.parseDouble(strdy));
	assertTrue(pa[1].equals(new Point2D(0,3.1)));
	assertTrue(pa1[0].equals(p1));
	dx=0;
	dy=0;
	strdx = String.format("%.2f", pa1[1].x());
	strdy = String.format("%.2f", pa1[1].y());
	pa1[1]=new Point2D(Double.parseDouble(strdx),Double.parseDouble(strdy));
	assertTrue(pa1[1].equals(new Point2D(-23.33,6.95)));
	}
	
	@Test
	void circle2D_test_getRadius() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(-4.5,7);
		Point2D p5=new Point2D(3.1,8);
		Circle2D se=new Circle2D(p2,2.5);
		Circle2D se1=new Circle2D(p4,1.3);
		Circle2D se2=new Circle2D(p5,4);
		assertEquals(2.5,se.getRadius());
		assertEquals(1.3,se1.getRadius());
		assertEquals(4,se2.getRadius());
	}
	
	@Test
	void circle2D_test_tostring() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(-4.5,7);
		Point2D p5=new Point2D(3.1,8);
		Circle2D se=new Circle2D(p2,2.5);
		Circle2D se1=new Circle2D(p4,1.3);
		Circle2D se2=new Circle2D(p5,4);
		assertTrue(se.toString().equals("-1.1,1.1, 2.5"));
		assertTrue((se1.toString()).equals("-4.5,7.0, 1.3"));
		assertTrue((se2.toString()).equals("3.1,8.0, 4.0"));
	}
	
	@Test
	void circle2D_test_contains() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(-4.5,7);
		Point2D p5=new Point2D(3.1,8);
		Circle2D se=new Circle2D(p2,2.5);
		Circle2D se1=new Circle2D(p4,1.3);
		Circle2D se2=new Circle2D(p5,4);
		Point2D d1=new Point2D(12,12);
		Point2D d4=new Point2D(12,13);
		Point2D d2=new Point2D(8,8.5);
		Point2D d3=new Point2D(-7,7.0);
		assertEquals(false,se.contains(d1));
		assertEquals(true,se.contains(new Point2D(-1.2,1.3)));
		assertEquals(false,se.contains(d4));
		assertEquals(false,se2.contains(d3));
		assertEquals(false,se1.contains(d2));
		assertEquals(false,se1.contains(new Point2D(8,8.6)));
		
	}
	@Test
	void circle2D_test_centermass() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(-4.5,7);
		Point2D p5=new Point2D(3.1,8);
		Circle2D se=new Circle2D(p2,2.5);
		Circle2D se1=new Circle2D(p4,1.3);
		Circle2D se2=new Circle2D(p5,4);
		Point2D d1=new Point2D(-1.1,1.1);
		Point2D d2=new Point2D(-4.5,7);
		Point2D d3=new Point2D(3.1,8);
		assertTrue(se.centerOfMass().equals(d1));
		assertTrue(se1.centerOfMass().equals(d2));
		assertTrue(se2.centerOfMass().equals(d3));
		
	}
	
	
	@Test
	void circle2D_test_area() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(-4.5,7);
		Point2D p5=new Point2D(3.1,8);
		Circle2D se=new Circle2D(p2,2.5);
		Circle2D se1=new Circle2D(p4,1.3);
		Circle2D se2=new Circle2D(p5,4);
		double d1=19.635;
		double d2=5.309;
		double d3=50.265;
		double dx=0;
		String strdx = String.format("%.3f", se.area());
		dx=(Double.parseDouble(strdx));
		assertEquals(d1,dx);
		strdx = String.format("%.3f", se1.area());
		dx=(Double.parseDouble(strdx));
		assertEquals(d2,dx);
		strdx = String.format("%.3f", se2.area());
		dx=(Double.parseDouble(strdx));
		assertEquals(d3,dx);
		
		
		
		
		
	}
	
	@Test
	void circle2D_test_perimeter() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(-4.5,7);
		Point2D p5=new Point2D(3.1,8);
		Circle2D se=new Circle2D(p2,2.5);
		Circle2D se1=new Circle2D(p4,1.3);
		Circle2D se2=new Circle2D(p5,4);
		double d1=15.708;
		double d2=8.168;
		double d3=25.133;
		double dx=0;
		String strdx = String.format("%.3f", se.perimeter());
		dx=(Double.parseDouble(strdx));
		assertEquals(d1,dx);
		strdx = String.format("%.3f", se1.perimeter());
		dx=(Double.parseDouble(strdx));
		assertEquals(d2,dx);
		strdx = String.format("%.3f", se2.perimeter());
		dx=(Double.parseDouble(strdx));
		assertEquals(d3,dx);
		
	}	
	@Test
	void circle2D_test_move() {
		
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p3=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(-4.5,7);
		Point2D p5=new Point2D(3.1,8);
		Circle2D se=new Circle2D(p2,2.5);
		Circle2D se1=new Circle2D(p4,1.3);
	    se.move(p3);
	    se1.move(p5);
		double dx=0;
		double dy=0;
		String sx="";
		String sy="";
		Point2D []arp1=se.getPoints();
		Point2D[] arp2=se1.getPoints();
		dx=arp1[0].x();
		dy=arp1[0].y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		p2=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue((new Point2D(-2.2,2.2)).equals(p2));
		dx=arp2[0].x();
		dy=arp2[0].y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		p4=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue(new Point2D(-1.4,15).equals(p4));
		
		
	}
	
	@Test
	void circle2D_test_copy() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.33,4.55);
		Point2D p2=new Point2D(6,7);
		Circle2D se=new Circle2D(p,2.1);
		Circle2D se1=new Circle2D(p2,1);
		Circle2D se2=(Circle2D) se.copy();
		Circle2D se3=(Circle2D) se1.copy();
		Point2D[] pa=se.getPoints();
		Point2D[] pa1=se1.getPoints();
		Point2D[] pa2=se2.getPoints();
		Point2D[] pa3=se3.getPoints();
		assertTrue(pa[0].equals(pa2[0]));
		assertTrue(pa[1].equals(pa2[1]));
		assertTrue(pa1[0].equals(pa3[0]));
		assertTrue(pa1[1].equals(pa3[1]));
		
	}
	
	
	
	@Test
	void circle2D_test_getPoints() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.33,4.55);
		Circle2D se=new Circle2D(p,3.1);
		Circle2D se1=new Circle2D(p1,2.4);
		Point2D[] pa=se.getPoints();
		Point2D[] pa1=se1.getPoints();
		assertTrue(pa[0].equals(p));
		double dx=0;
		double dy=0;
		String strdx = String.format("%.2f", pa[1].x());
		String strdy = String.format("%.2f", pa[1].y());
		pa[1]=new Point2D(Double.parseDouble(strdx),Double.parseDouble(strdy));
		assertTrue(pa[1].equals(new Point2D(0,3.1)));
		assertTrue(pa1[0].equals(p1));
		dx=0;
		dy=0;
		strdx = String.format("%.2f", pa1[1].x());
		strdy = String.format("%.2f", pa1[1].y());
		pa1[1]=new Point2D(Double.parseDouble(strdx),Double.parseDouble(strdy));
		assertTrue(pa1[1].equals(new Point2D(-23.33,6.95)));
		
	}
	
	
	
	

}
