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
 * @author shai kaikov
 * the tests here are for Point2D class
 *
 */
class Point2D_test {

	@Test
	void Point2D_test_x_y() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.33,4.55);
		Point2D p2=new Point2D(6,7);
		assertEquals(0,p.x());
		assertEquals(0,p.y());
		assertEquals(-23.33,p1.x());
		assertEquals(4.55,p1.y());
		assertEquals(6,p2.x());
		assertEquals(7,p2.y());
		
	}
	
	@Test
	void Point2D_test_p() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.33,4.55);
		Point2D p2=new Point2D(p);
		Point2D p3=new Point2D(p1);
		assertTrue(p.equals(p2));
		assertTrue(p1.equals(p3));
		
	}
	
	@Test
	void Point2D_test_ps() {
		Point2D p=new Point2D("0,0.0");
		Point2D p1=new Point2D("-23.33,4.55");
		Point2D p2=new Point2D(0,0.0);
		Point2D p3=new Point2D(-23.33,4.55);
		assertTrue(p.equals(p2));
		assertTrue(p1.equals(p3));
		
	}
	@Test
	void Point2D_test_x() {
		Point2D p=new Point2D("0,0.0");
		Point2D p1=new Point2D("-23.33,4.55");
		assertEquals(0,p.x());
		assertEquals(-23.33,p1.x());
		
	}
	@Test
	void Point2D_test_y() {
		Point2D p=new Point2D("0,0.0");
		Point2D p1=new Point2D("-23.33,4.55");
		assertEquals(0,p.y());
		assertEquals(4.55,p1.y());
		
	}
	@Test
	void Point2D_test_add() {
		Point2D p=new Point2D("10,0.2");
		Point2D p1=new Point2D("-23.33,4.55");
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p3=new Point2D(1.1,-1.1);
		Point2D p4=new Point2D(-13.33,4.75);
		Point2D p5=new Point2D(0,0);
		double dx=0;
		double dy=0;
		String sx="";
		String sy="";
		Point2D p0=p.add(p1);
		dx=p0.x();
		dy=p0.y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		p0=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue((p0.equals(p4)));
		p0=p2.add(p3);
		dx=p0.x();
		dy=p0.y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		p0=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue((p0.equals(p5)));
		
	}
	@Test
	void Point2D_test_Tostring() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p3=new Point2D(1.1,-1.1);
		Point2D p4=new Point2D(-13.33,4.75);
		Point2D p5=new Point2D(0,0);
		assertTrue(p2.toString().equals("-1.1,1.1"));
		assertTrue(p3.toString().equals("1.1,-1.1"));
		assertTrue(p4.toString().equals("-13.33,4.75"));
		assertTrue(p5.toString().equals("0.0,0.0"));
		
	}
	@Test
	void Point2D_test_distnce_0() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p3=new Point2D(1.1,-1.1);
		Point2D p4=new Point2D(-13.33,4.75);
		Point2D p5=new Point2D(0,0);
		double dx=0;
		String sx="";
		dx=p2.distance();
		sx=String.format("%.2f", dx);
		dx=(Double.parseDouble(sx)) ;
		assertEquals(1.56,dx);
		
		
	}
	
	@Test
	void Point2D_test_distnce() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p3=new Point2D(1.1,-1.1);
		Point2D p4=new Point2D(-13.33,4.75);
		Point2D p5=new Point2D(0,0);
		double dx=0;
		String sx="";
		dx=p2.distance(p3);
		sx=String.format("%.2f", dx);
		dx=(Double.parseDouble(sx)) ;
		assertEquals(3.11,dx);
		dx=p4.distance(p5);
		sx=String.format("%.2f", dx);
		dx=(Double.parseDouble(sx)) ;
		assertEquals(14.15,dx);
		
		
	}
	@Test
	void equals_test() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p3=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(0,0);
		Point2D p5=new Point2D(0,0);
		assertTrue(p2.equals(p3));
		assertTrue(p4.equals(p5));
	}
	 
	@Test
	void vector() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p3=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(-4.5,7);
		Point2D p5=new Point2D(3.1,8);
		assertTrue(new Point2D(0,0).equals(p2.vector(p3)));
		assertTrue(new Point2D(7.6,1).equals(p4.vector(p5)));
	}
	
	@Test
	void contains_test() {
		Point2D p3=new Point2D(-1.1,1.1);
		Point2D p5=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(-4.5,7);
		assertFalse(p3.contains(p4));
		assertTrue(p3.contains(p5));
	}
	@Test
	void centerOfMass_test() {
		
		Point2D p3=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(-4.5,7);
		assertTrue(p4.equals(p4.centerOfMass()));
		assertTrue(p3.equals(p3.centerOfMass()));
	}
	@Test
	void area_test() {
		Point2D p3=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(-4.5,7);
		assertEquals(0,p3.area());
		assertEquals(0,p4.area());
	}
	@Test
	void perimeter_test() {
		Point2D p3=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(-4.5,7);
		assertEquals(0,p3.perimeter());
		assertEquals(0,p4.perimeter());
	}
	@Test
	void move_test() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p3=new Point2D(-1.1,1.1);
		Point2D p4=new Point2D(-4.5,7);
		Point2D p5=new Point2D(3.1,8);
		p2.move(p3);
		p4.move(p5);
		double dx=0;
		double dy=0;
		String sx="";
		String sy="";
		dx=p2.x();
		dy=p2.y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		p2=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue((new Point2D(-2.2,2.2)).equals(p2));
		dx=p4.x();
		dy=p4.y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		p4=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue(new Point2D(-1.4,15).equals(p4));
	}
	@Test
	void copy_test() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D p3=(Point2D) p2.copy();
		Point2D p4=new Point2D(-4.5,7);
		Point2D p5=(Point2D) p4.copy();
		assertTrue(p3.equals(p2));
		assertTrue(p4.equals(p5));
	}
	@Test
	void getPoints_test() {
		Point2D p2=new Point2D(-1.1,1.1);
		Point2D[] p3=p2.getPoints();
		Point2D p4=new Point2D(-4.5,7);
		Point2D []p5=p4.getPoints();
		assertTrue(p3[0].equals(p2));
		assertTrue(p4.equals(p5[0]));
	}

}
