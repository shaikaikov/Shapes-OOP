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
 * the tests here are for Triangle2D class
 *
 */
class Triangle2D_test {

	@Test
	void triangle2D_test() {
		Point2D p1=new Point2D(0,0.0);
		Point2D p2=new Point2D(-1.2,3);
		Point2D p3=new Point2D(6.1,4.5);
		Point2D p4=new Point2D(1,1);
		Point2D p5=new Point2D(2,2);
		Point2D p6=new Point2D(0,-3.56);
		Triangle2D se=new Triangle2D(p1,p2,p3);
		Triangle2D se1=new Triangle2D(p4,p5,p6);
		Point2D[] pa=se.getPoints();
		Point2D[] pa1=se1.getPoints();
		assertTrue(pa[0].equals(p1));
		assertTrue(pa[1].equals(p2));
		assertTrue(pa[2].equals(p3));
		assertTrue(pa1[0].equals(p4));
		assertTrue(pa1[1].equals(p5));
		assertTrue(pa1[2].equals(p6));
		
	}
	
	@Test
	void triangle2D_test_contains() {
		Point2D p1=new Point2D(0,0.0);
		Point2D p2=new Point2D(-1.2,3);
		Point2D p3=new Point2D(6.1,4.5);
		Point2D p4=new Point2D(1,1);
		Point2D p5=new Point2D(2,2);
		Point2D p6=new Point2D(0,-3.56);
		Triangle2D se=new Triangle2D(p1,p2,p3);
		Triangle2D se1=new Triangle2D(p4,p5,p6);
		Point2D d1=new Point2D(12,12);
		Point2D d4=new Point2D(12,13);
		Point2D d2=new Point2D(8,8.5);
		Point2D d3=new Point2D(5,4);
		assertEquals(false,se.contains(d1));
		assertEquals(false,se.contains(d4));
		assertEquals(true,se.contains(d3));
		assertEquals(false,se1.contains(d3));
		assertEquals(true,se1.contains(new Point2D(0,-3.56)));
		assertEquals(true,se1.contains(new Point2D(1.2,0.7)));
		
	}
	
	@Test
	void triangle2D_test_centermass() {
		Point2D p1=new Point2D(0,0.0);
		Point2D p2=new Point2D(-1.2,3);
		Point2D p3=new Point2D(6.1,4.5);
		Point2D p4=new Point2D(1,1);
		Point2D p5=new Point2D(2,2);
		Point2D p6=new Point2D(0,-3.56);
		Triangle2D se=new Triangle2D(p1,p2,p3);
		Triangle2D se1=new Triangle2D(p4,p5,p6);
		Point2D d1=new Point2D(1.63,2.5);
		Point2D d2=new Point2D(1,-0.19);
		double dx=0;
		double dy=0;
		String strdx = String.format("%.2f", se.centerOfMass().x());
		String strdy = String.format("%.2f", se.centerOfMass().y());
		dx=(Double.parseDouble(strdx));
		dy=(Double.parseDouble(strdy));
		Point2D p0=new Point2D(dx,dy);
		assertTrue(p0.equals(d1));
		strdx = String.format("%.2f", se1.centerOfMass().x());
		strdy = String.format("%.2f", se1.centerOfMass().y());
		dx=(Double.parseDouble(strdx));
		dy=(Double.parseDouble(strdy));
	    p0=new Point2D(dx,dy);
		assertTrue(p0.equals(d2));
		
		
	}
	
	
	@Test
	void triangle2D_test_area() {
		Point2D p1=new Point2D(0,0.0);
		Point2D p2=new Point2D(-1.2,3);
		Point2D p3=new Point2D(6.1,4.5);
		Point2D p4=new Point2D(1,1);
		Point2D p5=new Point2D(2,2);
		Point2D p6=new Point2D(0,-3.56);
		Triangle2D se=new Triangle2D(p1,p2,p3);
		Triangle2D se1=new Triangle2D(p4,p5,p6);	
		double dx=0;
		String strdx = String.format("%.3f", se.area());
		dx=(Double.parseDouble(strdx));
		assertEquals(11.85,dx);
		strdx = String.format("%.3f", se1.area());
		dx=(Double.parseDouble(strdx));
		assertEquals(1.78,dx);
		
		
		
	}
	
	@Test
	void triangle2D_test_perimeter() {
		Point2D p1=new Point2D(0,0.0);
		Point2D p2=new Point2D(-1.2,3);
		Point2D p3=new Point2D(6.1,4.5);
		Point2D p4=new Point2D(1,1);
		Point2D p5=new Point2D(2,2);
		Point2D p6=new Point2D(0,-3.56);
		Triangle2D se=new Triangle2D(p1,p2,p3);
		Triangle2D se1=new Triangle2D(p4,p5,p6);
		double d1=18.264;
		double d2=11.991;		
		double dx=0;
		String strdx = String.format("%.3f", se.perimeter());
		dx=(Double.parseDouble(strdx));
		assertEquals(d1,dx);
		strdx = String.format("%.3f", se1.perimeter());
		dx=(Double.parseDouble(strdx));
		assertEquals(d2,dx);
		
		
		
		
	}
	
	@Test
	void triangle2D_test_move() {
		Point2D p1=new Point2D(0,0.0);
		Point2D p2=new Point2D(-1.2,3);
		Point2D p3=new Point2D(6.1,4.5);
		Point2D p4=new Point2D(1,1);
		Point2D p5=new Point2D(2,2);
		Point2D p6=new Point2D(0,-3.56);
		
		Triangle2D se=new Triangle2D(p1,p2,p3);
		Triangle2D se1=new Triangle2D(p4,p5,p6);
	    se.move(new Point2D(p2));
	    se.move(new Point2D(p1));
	    se1.move(new Point2D(p6));
	    Point2D p7=new Point2D(-1.2,3);
	    Point2D p8=new Point2D(-2.4,6);
	    Point2D p9=new Point2D(4.9,7.5);
	    Point2D p10=new Point2D(1,-2.56);
	    Point2D p11=new Point2D(2,-1.56);
	    Point2D p12=new Point2D(0,-7.12);
	    Point2D[] pa=se.getPoints();
		Point2D[] pa1=se1.getPoints();
		double dx=0;
		double dy=0;
		String sx="";
		String sy="";
		dx=pa[0].x();
		dy=pa[0].y();
		sx=String.format("%.1f", dx);
		sy=String.format("%.1f", dy);
		pa[0]=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue(pa[0].equals(p7));
		dx=pa[1].x();
		dy=pa[1].y();
		sx=String.format("%.1f", dx);
		sy=String.format("%.1f", dy);
		pa[1]=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue(pa[1].equals(p8));
		dx=pa[2].x();
		dy=pa[2].y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		pa[2]=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue(pa[2].equals(p9));
		dx=pa1[0].x();
		dy=pa1[0].y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		pa1[0]=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue(pa1[0].equals(p10));
		dx=pa1[1].x();
		dy=pa1[1].y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		pa1[1]=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue(pa1[1].equals(p11));
		dx=pa1[2].x();
		dy=pa1[2].y();
		sx=String.format("%.2f", dx);
		sy=String.format("%.2f", dy);
		pa1[2]=new Point2D(Double.parseDouble(sx),Double.parseDouble(sy)) ;
		assertTrue(pa1[2].equals(p12));
		
		
		
		
		
	
	
	
		
		
	}
	
	@Test
	void triangle2D_test_copy() {
		Point2D p1=new Point2D(0,0.0);
		Point2D p2=new Point2D(-1.2,3);
		Point2D p3=new Point2D(6.1,4.5);
		Point2D p4=new Point2D(1,1);
		Point2D p5=new Point2D(2,2);
		Point2D p6=new Point2D(0,-3.56);
		
		Triangle2D se=new Triangle2D(p1,p2,p3);
		Triangle2D se1=new Triangle2D(p4,p5,p6);
		Triangle2D se2=(Triangle2D) se.copy();
		Triangle2D se3=(Triangle2D) se1.copy();
		Point2D[] pa=se.getPoints();
		Point2D[] pa1=se1.getPoints();
		Point2D[] pa2=se2.getPoints();
		Point2D[] pa3=se3.getPoints();
		assertTrue(pa[0].equals(pa2[0]));
		assertTrue(pa[1].equals(pa2[1]));
		assertTrue(pa[2].equals(pa2[2]));
		assertTrue(pa1[0].equals(pa3[0]));
		assertTrue(pa1[1].equals(pa3[1]));
		assertTrue(pa1[2].equals(pa3[2]));
		
	}
	
	@Test
	void triangle2D_test_getPoints() {
		Point2D p1=new Point2D(0,0.0);
		Point2D p2=new Point2D(-1.2,3);
		Point2D p3=new Point2D(6.1,4.5);
		Point2D p4=new Point2D(1,1);
		Point2D p5=new Point2D(2,2);
		Point2D p6=new Point2D(0,-3.56);
		
		Triangle2D se=new Triangle2D(p1,p2,p3);
		Triangle2D se1=new Triangle2D(p4,p5,p6);
		Point2D[] pa=se.getPoints();
		Point2D[] pa1=se1.getPoints();
		assertTrue(pa[0].equals(p1));
		assertTrue(pa[1].equals(p2));
		assertTrue(pa[2].equals(p3));
		assertTrue(pa1[0].equals(p4));
		assertTrue(pa1[1].equals(p5));
		assertTrue(pa1[2].equals(p6));
		
	}
	@Test
	void triangle2D_test_tostring() {
		Point2D p1=new Point2D(0,0.0);
		Point2D p2=new Point2D(-1.2,3);
		Point2D p3=new Point2D(6.1,4.5);
		Point2D p4=new Point2D(1,1);
		Point2D p5=new Point2D(2,2);
		Point2D p6=new Point2D(0,-3.56);
		
		Triangle2D se=new Triangle2D(p1,p2,p3);
		Triangle2D se1=new Triangle2D(p4,p5,p6);
		Point2D[] pa=se.getPoints();
		Point2D[] pa1=se1.getPoints();
		assertTrue(se.toString().equals("0.0,0.0,-1.2,3.0,6.1,4.5"));
		assertTrue((se1.toString()).equals("1.0,1.0,2.0,2.0,0.0,-3.56"));
		
	}

}
