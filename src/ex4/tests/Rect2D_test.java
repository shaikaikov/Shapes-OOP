package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

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
 * the tests here are for Rect2D class
 *
 */

class Rect2D_test {

	@Test
    void rect2D_test() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-2.55,4.55);
		Point2D p2=new Point2D(6,7);
		Rect2D re=new Rect2D(p,p1);
		Rect2D re1=new Rect2D(p2,(new Point2D(10,10)));
		Point2D[] pa=re.getPoints();
		Point2D[] pa1=re1.getPoints();
		assertTrue(pa[0].equals(new Point2D(-2.55,0.0)));
		assertTrue(pa[1].equals(new Point2D(0,4.55)));
		assertTrue(pa1[0].equals(p2));
		assertTrue(pa1[1].equals(new Point2D(10,10)));
	}
	
	@Test
	void rect2D_test_contains() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(23,23);
		Point2D p2=new Point2D(6,7);
		Point2D p10=new Point2D(10.000,10);
		Point2D p3=new Point2D(-7,7.0);
		Point2D p4=new Point2D(-7,7.0);
		Rect2D se=new Rect2D(p,p1);
		Rect2D se1=new Rect2D(p2,p10);
		Rect2D se2=new Rect2D(p3,p4);
		Point2D d1=new Point2D(12,12);
		Point2D d4=new Point2D(12,122);
		Point2D d2=new Point2D(8,8.5);
		Point2D d3=new Point2D(-7,7.0);
		assertEquals(true,se.contains(d1));
		assertEquals(false,se.contains(d4));
		assertEquals(true,se2.contains(d3));
		assertEquals(true,se1.contains(d2));
		assertEquals(false,se1.contains(new Point2D(8,11.1)));
		
	}
	@Test
	void rect2D_test_centermass() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.3,4.5);
		Point2D p2=new Point2D(6,7);
		Point2D p10=new Point2D(10.000,10);
		Point2D p3=new Point2D(-7,7.0);
		Point2D p4=new Point2D(-7,7.0);
		Rect2D re=new Rect2D(p,p1);
		Rect2D re1=new Rect2D(p2,p10);
		Rect2D re2=new Rect2D(p3,p4);
		Point2D d1=new Point2D(-11.65,2.25);
		Point2D d2=new Point2D(8,8.5);
		Point2D d3=new Point2D(-7,7.0);
		assertTrue(re.centerOfMass().equals(d1));
		assertTrue(re1.centerOfMass().equals(d2));
		assertTrue(re2.centerOfMass().equals(d3));
		
	}
	
	
	@Test
	void rect2D_test_area() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.3,4.5);
		Point2D p2=new Point2D(6,7);
		Point2D p10=new Point2D(10.000,10);
		Point2D p3=new Point2D(-7,7.0);
		Point2D p4=new Point2D(-7,7.0);
		Rect2D re=new Rect2D(p,p1);
		Rect2D re1=new Rect2D(p2,p10);
		Rect2D re2=new Rect2D(p3,p4);
		double d1=104.85;
		double d2=12;
		double d3=0;
		double dx=0;
		String strdx = String.format("%.3f", re.area());
		dx=(Double.parseDouble(strdx));
		assertEquals(d1,dx);
		strdx = String.format("%.3f", re1.area());
		dx=(Double.parseDouble(strdx));
		assertEquals(d2,dx);
		strdx = String.format("%.3f", re2.area());
		dx=(Double.parseDouble(strdx));
		assertEquals(d3,dx);
		
		
		
		
		
	}
	
	@Test
	void rect2D_test_perimeter() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.3,4.5);
		Point2D p2=new Point2D(6,7);
		Point2D p10=new Point2D(10.000,10);
		Point2D p3=new Point2D(-7,7.0);
		Point2D p4=new Point2D(-7,7.0);
		Rect2D re=new Rect2D(p,p1);
		Rect2D re1=new Rect2D(p2,p10);
		Rect2D re2=new Rect2D(p3,p4);
		double d1=55.6;
		double d2=14;
		double d3=0;
		double dx=0;
		String strdx = String.format("%.3f", re.perimeter());
		dx=(Double.parseDouble(strdx));
		assertEquals(d1,dx);
		strdx = String.format("%.3f", re1.perimeter());
		dx=(Double.parseDouble(strdx));
		assertEquals(d2,dx);
		strdx = String.format("%.3f", re2.perimeter());
		dx=(Double.parseDouble(strdx));
		assertEquals(d3,dx);
		
		
		
	}
	
	@Test
	void rect2D_test_move() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.33,4.55);
		Point2D p2=new Point2D(6,7);
		Point2D p10=new Point2D(10.000,10);
		Rect2D re=new Rect2D(p,p1);
		Rect2D re1=new Rect2D(p2,p10);
	    re.move(new Point2D(p2));
	    re.move(new Point2D(p));
	    re1.move(new Point2D(p1));
	    Point2D p4=new Point2D(6,7);
	    Point2D p5=new Point2D(-17.33,11.55);
	    Point2D p6=new Point2D(-17.33,11.55);
	    Point2D p7=new Point2D(-13.33,14.55);
	    Point2D[] pa=re.getPoints();
		Point2D[] pa1=re1.getPoints();
		double dx=pa[0].x();
		double dy=pa[0].y();
		String strdx = String.format("%.2f", dx);
		String strdy=String.format("%.2f", dy);
		pa[0]=new Point2D(Double.parseDouble(strdx),Double.parseDouble(strdy)) ;
		assertTrue(pa[0].equals(new Point2D(-17.33,7.0)));
		dx=pa[1].x();
		dy=pa[1].y();
		strdx = String.format("%.2f", dx);
		strdy=String.format("%.2f", dy);
		pa[1]=new Point2D(Double.parseDouble(strdx),Double.parseDouble(strdy)) ;
		assertTrue(pa[1].equals(new Point2D(6,11.55)));
		dx=pa1[0].x();
		dy=pa1[0].y();
		strdx = String.format("%.2f", dx);
		strdy=String.format("%.2f", dy);
		pa1[0]=new Point2D(Double.parseDouble(strdx),Double.parseDouble(strdy)) ;
		assertTrue(pa1[0].equals(new Point2D(-17.33,11.55)));
		dx=pa1[1].x();
		dy=pa1[1].y();
		strdx = String.format("%.2f", dx);
		strdy=String.format("%.2f", dy);
		pa1[1]=new Point2D(Double.parseDouble(strdx),Double.parseDouble(strdy)) ;
		assertTrue(pa1[1].equals(new Point2D(-13.33,14.55)));
		
		
	}
	
	@Test
	void rect2D_test_copy() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.33,4.55);
		Point2D p2=new Point2D(6,7);
		Rect2D re=new Rect2D(p,p1);
		Rect2D re1=new Rect2D(p2,(new Point2D(10,10)));
		Rect2D re2=(Rect2D) re.copy();
		Rect2D re3=(Rect2D) re1.copy();
		Point2D[] pa=re.getPoints();
		Point2D[] pa1=re1.getPoints();
		Point2D[] pa2=re2.getPoints();
		Point2D[] pa3=re3.getPoints();
		assertTrue(pa[0].equals(pa2[0]));
		assertTrue(pa[1].equals(pa2[1]));
		assertTrue(pa1[0].equals(pa3[0]));
		assertTrue(pa1[1].equals(pa3[1]));
		
	}
	
	@Test
	void rect2D_test_getPoints() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.33,4.55);
		Point2D p2=new Point2D(6,7);
		Rect2D re=new Rect2D(p,p1);
		Rect2D re1=new Rect2D(p2,(new Point2D(10,10)));
		Point2D[] pa=re.getPoints();
		Point2D[] pa1=re1.getPoints();
		assertTrue(pa[0].equals(new Point2D(p1.x(),p.y())));
		assertTrue(pa[1].equals(new Point2D(p.x(),p1.y())));
		assertTrue(pa1[0].equals(p2));
		assertTrue(pa1[1].equals(new Point2D(10,10)));
		
	}
	@Test
	void rect2D_test_tostring() {
		Point2D p=new Point2D(0,0.0);
		Point2D p1=new Point2D(-23.33,4.55);
		Point2D p2=new Point2D(6,7);
		Rect2D re=new Rect2D(p,p1);
		Rect2D re1=new Rect2D(p2,(new Point2D(10,10)));
		assertTrue(re.toString().equals("0.0,0.0,-23.33,4.55"));
		assertTrue((re1.toString()).equals("6.0,7.0,10.0,10.0"));
		
	}

}
