package ex4.tests;

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
 * 
 * here the main-the program run for the jar file.
 * this task I did of course alone
 *
 */
public class Main {

	public static void main(String[] a) {
		Ex4 win = new Ex4();
		GUI_Shape_Collection sc = win.getShape_Collection();
		sc.load(a[0]);
		Rect2D bb = sc.getBoundingBox();
		Point2D min = bb.getPoints()[0], max = bb.getPoints()[1];
		double m0 = Math.min(min.x(), min.y());
		double m1 = Math.max(max.x(), max.y());
		Shape_Comp comp = new Shape_Comp(Integer.parseInt(a[1]));
		sc.sort(comp);
		StdDraw.setScale(m0-0.1,m1+0.1);
		System.out.println(sc);
		win.show();

	}

}
