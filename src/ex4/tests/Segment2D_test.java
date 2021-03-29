package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;




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
 * the tests here are for Segment2D class
 *
 */
class Segment2D_test {

	@Test
	void segment2D_test() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.33,4.55);
		Point2D p2=new Point2D(6,7);
		Segment2D se=new Segment2D(p,p1);
		Segment2D se1=new Segment2D(p2,(new Point2D(10,10)));
		Point2D[] pa=se.getPoints();
		Point2D[] pa1=se1.getPoints();
		assertTrue(pa[0].equals(p));
		assertTrue(pa[1].equals(p1));
		assertTrue(pa1[0].equals(p2));
		assertTrue(pa1[1].equals(new Point2D(10,10)));
		
	}
	@Test
	void Segment2D_test_contains() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(23,23);
		Point2D p2=new Point2D(6,7);
		Point2D p10=new Point2D(10.000,10);
		Point2D p3=new Point2D(-7,7.0);
		Point2D p4=new Point2D(-7,7.0);
		Segment2D se=new Segment2D(p,p1);
		Segment2D se1=new Segment2D(p2,p10);
		Segment2D se2=new Segment2D(p3,p4);
		Point2D d1=new Point2D(12,12);
		Point2D d4=new Point2D(12,13);
		Point2D d2=new Point2D(8,8.5);
		Point2D d3=new Point2D(-7,7.0);
		assertEquals(true,se.contains(d1));
		assertEquals(false,se.contains(d4));
		assertEquals(true,se2.contains(d3));
		assertEquals(true,se1.contains(d2));
		assertEquals(false,se1.contains(new Point2D(8,8.6)));
		
	}
	@Test
	void Segment2D_test_centermass() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.3,4.5);
		Point2D p2=new Point2D(6,7);
		Point2D p10=new Point2D(10.000,10);
		Point2D p3=new Point2D(-7,7.0);
		Point2D p4=new Point2D(-7,7.0);
		Segment2D se=new Segment2D(p,p1);
		Segment2D se1=new Segment2D(p2,p10);
		Segment2D se2=new Segment2D(p3,p4);
		Point2D d1=new Point2D(-11.65,2.25);
		Point2D d2=new Point2D(8,8.5);
		Point2D d3=new Point2D(-7,7.0);
		assertTrue(se.centerOfMass().equals(d1));
		assertTrue(se1.centerOfMass().equals(d2));
		assertTrue(se2.centerOfMass().equals(d3));
		
	}
	
	
	@Test
	void Segment2D_test_area() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.3,4.5);
		Segment2D se=new Segment2D(p,p1);
		assertEquals(0,se.area());
		
		
		
		
		
	}
	
	@Test
	void Segment2D_test_perimeter() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.3,4.5);
		Point2D p2=new Point2D(6,7);
		Point2D p10=new Point2D(10.000,10);
		Point2D p3=new Point2D(-7,7.0);
		Point2D p4=new Point2D(-7,7.0);
		Segment2D se=new Segment2D(p,p1);
		Segment2D se1=new Segment2D(p2,p10);
		Segment2D se2=new Segment2D(p3,p4);
		double d1=47.461;
		double d2=10;
		double d3=0;
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
	void Segment2D_test_move() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.33,4.55);
		Point2D p2=new Point2D(6,7);
		Point2D p10=new Point2D(10.000,10);
		Segment2D se=new Segment2D(p,p1);
		Segment2D se1=new Segment2D(p2,p10);
	    se.move(new Point2D(p2));
	    se.move(new Point2D(p));
	    se1.move(new Point2D(p1));
	    Point2D p4=new Point2D(6,7);
	    Point2D p5=new Point2D(-17.33,11.55);
	    Point2D p6=new Point2D(-17.33,11.55);
	    Point2D p7=new Point2D(-13.33,14.55);
	    Point2D[] pa=se.getPoints();
		Point2D[] pa1=se1.getPoints();
		double dx=0;
		double dy=0;
		String sx="";
		String sy="";
		dx=pa[0].x();
		dy=pa[0].y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		pa[0]=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue(pa[0].equals(p4));
		dx=pa[1].x();
		dy=pa[1].y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		pa[1]=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue(pa[1].equals(p5));
		dx=pa1[0].x();
		dy=pa1[0].y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		pa1[0]=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue(pa1[0].equals(p6));
		dx=pa1[1].x();
		dy=pa1[1].y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		pa1[1]=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue(pa1[1].equals(p7));
		
		
	}
	
	@Test
	void Segment2D_test_copy() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.33,4.55);
		Point2D p2=new Point2D(6,7);
		Segment2D se=new Segment2D(p,p1);
		Segment2D se1=new Segment2D(p2,(new Point2D(10,10)));
		Segment2D se2=(Segment2D) se.copy();
		Segment2D se3=(Segment2D) se1.copy();
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
	void Segment2D_test_getPoints() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.33,4.55);
		Point2D p2=new Point2D(6,7);
		Segment2D se=new Segment2D(p,p1);
		Segment2D se1=new Segment2D(p2,(new Point2D(10,10)));
		Point2D[] pa=se.getPoints();
		Point2D[] pa1=se1.getPoints();
		assertTrue(pa[0].equals(p));
		assertTrue(pa[1].equals(p1));
		assertTrue(pa1[0].equals(p2));
		assertTrue(pa1[1].equals(new Point2D(10,10)));
		
	}
	@Test
	void Segment2D_test_tostring() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.33,4.55);
		Point2D p2=new Point2D(6,7);
		Segment2D se=new Segment2D(p,p1);
		Segment2D se1=new Segment2D(p2,(new Point2D(10,10)));
		assertTrue(se.toString().equals("0.0,0.0,-23.33,4.55"));
		assertTrue((se1.toString()).equals("6.0,7.0,10.0,10.0"));
		
	}

}
