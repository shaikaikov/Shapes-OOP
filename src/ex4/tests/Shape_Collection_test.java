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
import ex4.Shape_Collection;
import ex4.Shape_Comp;
import ex4.StdDraw;
import ex4.geometry.*;


/**
 * 
 * @author shai kaikov.
 * here are all the tests for the functions and  of the Shape_Collection class.
 * 
 *
 */
class Shape_Collection_test {

	@Test
	void get_test() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		GUI_Shape_Collection G=new Shape_Collection();
		G.add(g1);
		G.add(g2);
		GUI_Shape temp=G.get(0);
		GUI_Shape temp1=G.get(1);
		assertTrue(g1.getShape().equals(temp.getShape()));
		Point2D[] arp=g2.getShape().getPoints();
		Point2D[] arp1=temp1.getShape().getPoints();
		assertTrue(arp[0].equals(arp1[0]));
		assertTrue(arp[1].equals(arp1[1]));
		assertTrue(arp[2].equals(arp1[2]));
		assertEquals(temp.isFilled(),g1.isFilled());
		assertEquals(temp1.isFilled(),g2.isFilled());
		assertEquals(1,temp.getTag());
		assertEquals(2,temp1.getTag());
		assertEquals(Color.black.getRGB(),temp.getColor().getRGB());
		assertEquals(Color.red.getRGB(),temp1.getColor().getRGB());
		
		
	}
	
	@Test
	void size_test(){
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		Segment2D se=new Segment2D(new Point2D(2.3,4),new Point2D(-1,-4.4));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		GUI_Shape g3=new GUIShape(se,true,Color.red,3);
		GUI_Shape_Collection G=new Shape_Collection();
		G.add(g1);
		G.add(g2);
		G.add(g3);
		assertEquals(3,G.size());
		GUI_Shape g0=new GUIShape();
		G.add(g0);
		assertEquals(4,G.size());
		G.removeElementAt(1);
		assertEquals(3,G.size());
		G.removeAll();
		assertEquals(0,G.size());
		
		
	}
	@Test
	void removeElementAt_test() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		Segment2D se=new Segment2D(new Point2D(2.3,4),new Point2D(-1,-4.4));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		GUI_Shape g3=new GUIShape(se,true,Color.red,3);
		GUI_Shape_Collection G=new Shape_Collection();
		G.add(g1);
		G.add(g2);
		G.add(g3);
		GUI_Shape g0=new GUIShape();
		G.add(g0);
		G.removeElementAt(1);
		assertEquals(g3,G.get(1));
		G.removeElementAt(2);
		assertEquals(g3,G.get(1));
		assertEquals(g1,G.get(0));
		
		
	}
	@Test 
	void addAt_test() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		Point2D p1=new Point2D(-33,16);
		Triangle2D t1=new Triangle2D(new Point2D(54,-0.2),new Point2D(-45.3,9),new Point2D(-35,8));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		GUI_Shape g3=new GUIShape(p1,true,Color.gray,3);
		GUI_Shape g4=new GUIShape(t1,false,Color.orange,4);
		GUI_Shape_Collection G=new Shape_Collection();
		G.add(g1);
		G.add(g2);
		G.addAt(g3, 1);
		GUI_Shape temp=G.get(1);
		assertTrue(g3.getShape().equals(temp.getShape()));
		assertEquals(3,temp.getTag());
		assertEquals(Color.gray.getRGB(),temp.getColor().getRGB());
		assertEquals(temp.isFilled(),g3.isFilled());
	    G.addAt(g4, 0);
		GUI_Shape temp1=G.get(0);
		Point2D[] arp=g4.getShape().getPoints();
		Point2D[] arp1=temp1.getShape().getPoints();
		assertTrue(arp[0].equals(arp1[0]));
		assertTrue(arp[1].equals(arp1[1]));
		assertTrue(arp[2].equals(arp1[2]));
		assertEquals(temp1.isFilled(),g4.isFilled());
		assertEquals(4,temp1.getTag());
		assertEquals(Color.orange.getRGB(),temp1.getColor().getRGB());
		
	}
	@Test
	void add_test(){
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		GUI_Shape_Collection G=new Shape_Collection();
		G.add(g1);
		G.add(g2);
		GUI_Shape temp=G.get(0);
		GUI_Shape temp1=G.get(1);
		assertTrue(g1.getShape().equals(temp.getShape()));
		Point2D[] arp=g2.getShape().getPoints();
		Point2D[] arp1=temp1.getShape().getPoints();
		assertTrue(arp[0].equals(arp1[0]));
		assertTrue(arp[1].equals(arp1[1]));
		assertTrue(arp[2].equals(arp1[2]));
		assertEquals(temp.isFilled(),g1.isFilled());
		assertEquals(temp1.isFilled(),g2.isFilled());
		assertEquals(1,temp.getTag());
		assertEquals(2,temp1.getTag());
		assertEquals(Color.black.getRGB(),temp.getColor().getRGB());
		assertEquals(Color.red.getRGB(),temp1.getColor().getRGB());
	}
	@Test
	void copy_test() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		GUI_Shape_Collection G=new Shape_Collection();
		G.add(g1);
		G.add(g2);
		GUI_Shape_Collection G1=G.copy();
		GUI_Shape temp=G.get(0);
		GUI_Shape temp1=G.get(1);
		GUI_Shape temp2=G1.get(0);
		GUI_Shape temp3=G1.get(1);
		assertTrue(temp2.getShape().equals(temp.getShape()));
		Point2D[] arp=temp3.getShape().getPoints();
		Point2D[] arp1=temp1.getShape().getPoints();
		assertTrue(arp[0].equals(arp1[0]));
		assertTrue(arp[1].equals(arp1[1]));
		assertTrue(arp[2].equals(arp1[2]));
		assertEquals(temp.isFilled(),temp2.isFilled());
		assertEquals(temp1.isFilled(),temp3.isFilled());
		assertEquals(1,temp2.getTag());
		assertEquals(2,temp3.getTag());
		assertEquals(Color.black.getRGB(),temp2.getColor().getRGB());
		assertEquals(Color.red.getRGB(),temp3.getColor().getRGB());
	}
	
	@Test
	void sort_test() {
		Circle2D c=new Circle2D(new Point2D(-0.2,1),3);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		Point2D p1=new Point2D(-33,16);
		Triangle2D t1=new Triangle2D(new Point2D(54,-0.2),new Point2D(-45.3,9),new Point2D(-35,8));
		GUI_Shape g1=new GUIShape(c,true,Color.black,2);
		GUI_Shape g2=new GUIShape(t,false,Color.red,3);
		GUI_Shape g3=new GUIShape(p1,true,Color.gray,1);
		GUI_Shape g4=new GUIShape(t1,false,Color.orange,4);
		GUI_Shape_Collection G=new Shape_Collection();
		G.add(g1);
		G.add(g2);
		G.add(g3);
		G.add(g4);
		Shape_Comp comp = new Shape_Comp(0);
		G.sort(comp);
		for(int i=1;i<=G.size();i++) {
			assertEquals(i,G.get(i-1).getTag());
		}
		comp=new Shape_Comp(1);
		G.sort(comp);
		for(int i=0;i<G.size();i++) {
			assertEquals(4-i,G.get(i).getTag());
		}
		comp=new Shape_Comp(2);
		G.sort(comp);
		double dx=0;
		double dx1=0;
		double dx2=0;
		double dx3=0;
		String sx="";
		String sx1="";
		String sx2="";
		String sx3="";
		sx = String.format("%.3f",G.get(0).getShape().area());
		dx=(Double.parseDouble(sx));
		sx1 = String.format("%.3f",G.get(1).getShape().area());
		dx1=(Double.parseDouble(sx1));
		sx2 = String.format("%.3f",G.get(2).getShape().area());
		dx2=(Double.parseDouble(sx2));
		sx3 = String.format("%.3f",G.get(3).getShape().area());
		dx3=(Double.parseDouble(sx3));
		assertEquals(0,dx);
		assertEquals(2.27,dx1);
		assertEquals(26.4,dx2);
		assertEquals(28.274,dx3);
		comp=new Shape_Comp(3);
		G.sort(comp);
		sx = String.format("%.3f",G.get(0).getShape().area());
		dx=(Double.parseDouble(sx));
		sx1 = String.format("%.3f",G.get(1).getShape().area());
		dx1=(Double.parseDouble(sx1));
		sx2 = String.format("%.3f",G.get(2).getShape().area());
		dx2=(Double.parseDouble(sx2));
		sx3 = String.format("%.3f",G.get(3).getShape().area());
		dx3=(Double.parseDouble(sx3));
		assertEquals(28.274,dx);
		assertEquals(26.4,dx1);
		assertEquals(2.27,dx2);
		assertEquals(0,dx3);
		comp=new Shape_Comp(4);
		G.sort(comp);
		sx = String.format("%.3f",G.get(0).getShape().perimeter());
		dx=(Double.parseDouble(sx));
		sx1 = String.format("%.3f",G.get(1).getShape().perimeter());
		dx1=(Double.parseDouble(sx1));
		sx2 = String.format("%.3f",G.get(2).getShape().perimeter());
		dx2=(Double.parseDouble(sx2));
		sx3 = String.format("%.3f",G.get(3).getShape().perimeter());
		dx3=(Double.parseDouble(sx3));
		assertEquals(0,dx);
		assertEquals(18.85,dx1);
		assertEquals(24.105,dx2);
		assertEquals(199.451,dx3);
		comp=new Shape_Comp(5);
		G.sort(comp);
		sx = String.format("%.3f",G.get(0).getShape().perimeter());
		dx=(Double.parseDouble(sx));
		sx1 = String.format("%.3f",G.get(1).getShape().perimeter());
		dx1=(Double.parseDouble(sx1));
		sx2 = String.format("%.3f",G.get(2).getShape().perimeter());
		dx2=(Double.parseDouble(sx2));
		sx3 = String.format("%.3f",G.get(3).getShape().perimeter());
		dx3=(Double.parseDouble(sx3));
		assertEquals(199.451,dx);
		assertEquals(24.105,dx1);
		assertEquals(18.85,dx2);
		assertEquals(0,dx3);
		comp=new Shape_Comp(6);
		G.sort(comp);
	    assertEquals(G.get(0),g1);
	    assertEquals(G.get(1),g3);
	    assertEquals(G.get(2),g2);
	    assertEquals(G.get(3),g4);
		
	}
	@Test
	void removeAll_test() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		Point2D p1=new Point2D(-33,16);
		Triangle2D t1=new Triangle2D(new Point2D(54,-0.2),new Point2D(-45.3,9),new Point2D(-35,8));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		GUI_Shape g3=new GUIShape(p1,true,Color.gray,3);
		GUI_Shape g4=new GUIShape(t1,false,Color.orange,4);
		GUI_Shape_Collection G=new Shape_Collection();
		G.add(g1);
		G.add(g2);
		G.addAt(g3, 1);
		G.removeAll();
		assertEquals(0,G.size());
		Point2D p11=new Point2D(-33,16);
		Triangle2D t11=new Triangle2D(new Point2D(54,-0.2),new Point2D(-45.3,9),new Point2D(-35,8));
		GUI_Shape g5=new GUIShape(p11,true,Color.gray,3);
		GUI_Shape g6=new GUIShape(t11,false,Color.orange,4);
		G.add(g5);
		G.add(g6);
		assertEquals(2,G.size());
		G.removeAll();
		assertEquals(0,G.size());
	}
	
	@Test
	void getBoundingBox() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		Point2D p1=new Point2D(-33,16);
		Triangle2D t1=new Triangle2D(new Point2D(54,-0.2),new Point2D(-45.3,9),new Point2D(-35,8));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		GUI_Shape g3=new GUIShape(p1,true,Color.gray,3);
		GUI_Shape g4=new GUIShape(t1,false,Color.orange,4);
		GUI_Shape_Collection G=new Shape_Collection();
		G.add(g1);
		G.add(g2);
		G.addAt(g3, 1);
		G.add(g4);
		Rect2D re=G.getBoundingBox();
		Point2D[] arp=re.getPoints();
		assertTrue(arp[0].equals(new Point2D(-45.3,-0.2)));
		assertTrue(arp[1].equals(new Point2D(54,16)));
	}
	
	

}
