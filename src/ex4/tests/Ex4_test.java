package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.util.Scanner;

import ex4.Ex4;
import ex4.Ex4_Const;
import ex4.Ex4_GUI;
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
 * here are part of the tests for the functions and  of the Ex4 class(the others
 * are GUI implementations-and that why they don't have tests).
 * 
 *
 */
class Ex4_test {

	@Test
	void ex4_test() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		GUI_Shape_Collection G=new Shape_Collection();
		G.add(g1);
		G.add(g2);
		Ex4_GUI E=new Ex4();
		E.init(G);
		GUI_Shape temp=G.get(0);
		GUI_Shape temp1=G.get(1);
		GUI_Shape temp2=E.getShape_Collection().get(0);
		GUI_Shape temp3=E.getShape_Collection().get(1);
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
	void getShape_Collection_test() {
		Point2D p=new Point2D(-0.2,1);
		Triangle2D t=new Triangle2D(new Point2D(2,0),new Point2D(-4.3,5),new Point2D(5,6));
		GUI_Shape g1=new GUIShape(p,true,Color.black,1);
		GUI_Shape g2=new GUIShape(t,false,Color.red,2);
		GUI_Shape_Collection G=new Shape_Collection();
		G.add(g1);
		G.add(g2);
		Ex4_GUI E=new Ex4();
		E.init(G);
		GUI_Shape temp=G.get(0);
		GUI_Shape temp1=G.get(1);
		GUI_Shape temp2=E.getShape_Collection().get(0);
		GUI_Shape temp3=E.getShape_Collection().get(1);
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

}
