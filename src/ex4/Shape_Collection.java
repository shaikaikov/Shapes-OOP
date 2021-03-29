package ex4;

import java.awt.Color;
import java.io.File;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;
/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * 
 *
 */
/**
 * 
 * @author shai kaikov
 * this class represent the Shape_Collection class-class with GUI_Shape arr and his size(parameters).
 * all the implementations of the functions and the constructors are here.
 *
 */
public class Shape_Collection implements GUI_Shape_Collection{
	private GUI_Shape [] arr;
	private int size=0;


	/**
	 * @param i-index of the array.
	 * @return the element in index i
	 */
	@Override
	public GUI_Shape get(int i) {
		return this.arr[i];
	}

	/**
	 * @return size-the size of the array
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * @param i- the index of the array
	 * @return the element that have been removed.
	 * in start I create new array of GUI_Shape
	 * in the loop I pass element after element(and copy them to the new array) and when I in the 
	 * element in index i-I remove him(by replace him with the next element) and change my boolean flag-sign to
	 * true-this sign help me in the future in the loop to push back the next elements(in the new array)
	 * in the end I put the pointer of the object to the new array.
	 */
	@Override
	public GUI_Shape removeElementAt(int i) {
		GUI_Shape[] t=new GUI_Shape[this.arr.length-1];
		GUI_Shape item=null;
		boolean sign=false;
		for(int j=0;j<t.length;j++) {
			if(i==j) {
				item=this.arr[j];
				t[j]=this.arr[j+1];
				sign=true;
			}

			else if(sign==false) {
				t[j]=this.arr[j];
			}
			else if(sign==true) {
				t[j]=this.arr[j+1];
			}
		}
		this.arr=t;
		this.size--;
		return item;

	}
	
	/**
	 * @param s- the element I want to add
	 * @param i- the index of the array
	 * in start I create new array of GUI_Shape
	 * in the loop I pass element after element(and copy them to the new array) and when I in the 
	 * element in index i-I add him and change my boolean flag-sign to
	 * true-this sign help me in the future in the loop to push forward the next elements(in the new array)
	 * in the end I put the pointer of the object to the new array.
	 */
	@Override
	public void addAt(GUI_Shape s, int i) {

		GUI_Shape[] t=new GUI_Shape[this.size+1];
		boolean sign=false;
		for(int j=0;j<t.length;j++) {
			if(i==j) {
				t[j]=s;
				sign=true;
			}

			else if(sign==false) {
				t[j]=this.arr[j];
			}
			else if(sign==true) {
				t[j]=this.arr[j-1];
			}
		}
		this.arr=t;
		this.size++;

	}
	/**
	 * @param s-the element that I want to add.
	 * I create a new array of GUI_Shape and do copy of the old array
	 * in the end of the new array I add the new element.
	 * in the end I put the pointer of the object to the new array.
	 */
	@Override
	public void add(GUI_Shape s) {
		GUI_Shape[] t=new GUI_Shape[this.size+1];
		for(int j=0;j<t.length-1;j++) {

			t[j]=this.arr[j];
		}
		this.arr=t;
		this.size++;
		this.arr[this.size-1]=s;

	}
	/**
	 * @return sh-the new copy of the object.
	 * in this function I create new object-and do loop to copy the elements from the
	 * old object to the new object.
	 */

	@Override
	public GUI_Shape_Collection copy() {
		Shape_Collection sh=new Shape_Collection();
		for(int i=0;i<this.arr.length;i++) {
			sh.add(this.arr[i].copy());
		}
		return sh;


	}

    /**
     * @param comp-Comparator object.
     * here I do sort to the array according the kind of the Comparator
     */
	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		Arrays.sort(this.arr,comp);
	}

	/**
	 * remove all the elements from the array.
	 * here I just pointing the array to null and reset size to zero
	 */
	@Override
	public void removeAll() {
		this.size=0;
		this.arr=null;
	}
	/**
	 * @param file-the name of the file I want to write all the data(in String).
	 * just open file-and I start to write all the data to the file(by loop-the loop on the array).
	 * in the end I close the file.
	 */
	@Override
	public void save(String file) { 
		try {
			FileWriter mywriter=new FileWriter(file);
			for(int i=0;i<this.size;i++) {
				String temp="";
				temp="GUIShape,";
				temp=temp+((this.arr[i].getColor().getRed()*65536)+(this.arr[i].getColor().getGreen()*256)+this.arr[i].getColor().getBlue())+",";
				temp=temp+this.arr[i].isFilled()+",";
				temp=temp+this.arr[i].getTag()+",";
			    if(this.arr[i].getShape() instanceof Point2D) {
			    	temp=temp+"Point2D,"+this.arr[i].getShape().toString();
			    }
			    else if(this.arr[i].getShape() instanceof Segment2D) {
			    	temp=temp+"Segment2D,"+this.arr[i].getShape().toString();
			    }
			    else if(this.arr[i].getShape() instanceof Circle2D) {
			    	temp=temp+"Circle2D,"+this.arr[i].getShape().toString();
			    }
			    else if(this.arr[i].getShape() instanceof Rect2D) {
			    	temp=temp+"Rect2D,"+this.arr[i].getShape().toString();
			    }
			    else if(this.arr[i].getShape() instanceof Triangle2D) {
			    	temp=temp+"Triangle2D,"+this.arr[i].getShape().toString();
			    }
			    mywriter.write(temp+"\n");
				
			}
			mywriter.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * @param file-the name of the file that I want to load from him the data into
	 * the Shape_Collection object.
	 * this function its little bit complicated to be explain
	 * but this function in short play a lot of the String functions and
	 * more of functions that have connect to the String class.in the end I get the all data I
	 * need.I will not explain more in the reason that the logic here is a lot to explain.
	 * in the end I close the file that I have read from him.
	 */
	@Override
	public void load(String file) {
		try {
			File f=new File(file);
			Scanner myReader=new Scanner(f);
			while(myReader.hasNextLine()) {
				String data=myReader.nextLine();
				int counter=0;
				String temp="";
				String ob="";
				int color=0;
				int tag=0;
				boolean flag=true;

				for(int i=0;i<data.length();i++) {
					if(data.charAt(i)!=',') {
						temp=temp+data.charAt(i);
					}
					else if(data.charAt(i)==',') {
						if(counter==0) {
							counter++;
							temp="";
						}
						else if(counter==1) {
							counter++;
							
							color=Integer.parseInt(temp);
							temp="";
						}
						else if(counter==2) {
							counter++;
							flag=Boolean.parseBoolean(temp);
							temp="";
						}
						else if(counter==3) {

							counter++;
							tag=Integer.parseInt(temp);
							temp="";
						}
						else if(counter==4) {
							counter=0;

							if(temp.equals("Segment2D")) {
								double a=0;
								double b=0;
								double c=0;
								double d=0;
								temp="";
								ob=data.substring(i+1);
								for(int j=0;j<ob.length();j++) {
									if(ob.charAt(j)!=',' && j+1!=ob.length()) {
										temp=temp+ob.charAt(j);
									}
									else if(ob.charAt(j)==',') {
										if(counter==0) {
											counter++;
											a=Double.parseDouble(temp);
											temp="";
										}
										else if(counter==1) {
											counter++;
											b=Double.parseDouble(temp);
											temp="";
										}
										else if(counter==2) {
											counter++;
											c=Double.parseDouble(temp);
											temp="";
										}

									}
									else if(j+1==ob.length()) {
										temp=temp+ob.charAt(j);
										d=Double.parseDouble(temp);
										temp="";
									}
								}
								Segment2D s=new Segment2D(new Point2D(a,b),new Point2D(c,d));
								Color co=new Color(color);
								GUIShape item=new GUIShape(s,flag,co,tag);
								this.add(item);
								break;
							}
							
							else if(temp.equals("Point2D")) {
								double a=0;
								double b=0;
								temp="";
								ob=data.substring(i+1);
								for(int j=0;j<ob.length();j++) {
									if(ob.charAt(j)!=',' && j+1!=ob.length()) {
										temp=temp+ob.charAt(j);
									}
									else if(ob.charAt(j)==',') {
										if(counter==0) {
											counter++;
											a=Double.parseDouble(temp);
											temp="";
										}

									}
									else if(j+1==ob.length()) {
										temp=temp+ob.charAt(j);
										b=Double.parseDouble(temp);
										temp="";
									}
								}
								Point2D s=new Point2D(a,b);
								Color co=new Color(color);
								GUIShape item=new GUIShape(s,flag,co,tag);
								this.add(item);
                                break;
							}
							
							else if(temp.equals("Circle2D")) {
								double a=0;
								double b=0;
								double c=0;
								temp="";
								ob=data.substring(i+1);
								for(int j=0;j<ob.length();j++) {
									if(ob.charAt(j)!=',' && j+1!=ob.length()) {
										temp=temp+ob.charAt(j);
									}
									else if(ob.charAt(j)==',') {
										if(counter==0) {
											counter++;
											a=Double.parseDouble(temp);
											temp="";
										}
										else if(counter==1) {
											counter++;
											b=Double.parseDouble(temp);
											temp="";
										}

									}
									else if(j+1==ob.length()) {
										temp=temp+ob.charAt(j);
										c=Double.parseDouble(temp);
										temp="";
									}
								}
								Circle2D s=new Circle2D(new Point2D(a,b),c);
								Color co=new Color(color);
								GUIShape item=new GUIShape(s,flag,co,tag);
								this.add(item);
								break;
							}
							
							else if(temp.equals("Triangle2D")) {
								double a=0;
								double b=0;
								double c=0;
								double d=0;
								double e=0;
								double g=0;
								temp="";
								ob=data.substring(i+1);
								for(int j=0;j<ob.length();j++) {
									if(ob.charAt(j)!=',' && j+1!=ob.length()) {
										temp=temp+ob.charAt(j);
									}
									else if(ob.charAt(j)==',') {
										if(counter==0) {
											counter++;
											a=Double.parseDouble(temp);
											temp="";
										}
										else if(counter==1) {
											counter++;
											b=Double.parseDouble(temp);
											temp="";
										}
										else if(counter==2) {
											counter++;
											c=Double.parseDouble(temp);
											temp="";
										}
										else if(counter==3) {
											counter++;
											d=Double.parseDouble(temp);
											temp="";
										}
										else if(counter==4) {
											counter++;
											e=Double.parseDouble(temp);
											temp="";
										}

									}
									else if(j+1==ob.length()) {
										temp=temp+ob.charAt(j);
										g=Double.parseDouble(temp);
										temp="";
									}
								}
								Triangle2D s=new Triangle2D(new Point2D(a,b),new Point2D(c,d),new Point2D(e,g));
								Color co=new Color(color);
								GUIShape item=new GUIShape(s,flag,co,tag);
								this.add(item);
								break;
							}
							
							else if(temp.equals("Rect2D")) {
								double a=0;
								double b=0;
								double c=0;
								double d=0;
								temp="";
								ob=data.substring(i+1);
								for(int j=0;j<ob.length();j++) {
									if(ob.charAt(j)!=',' && j+1!=ob.length()) {
										temp=temp+ob.charAt(j);
									}
									else if(ob.charAt(j)==',') {
										if(counter==0) {
											counter++;
											a=Double.parseDouble(temp);
											temp="";
										}
										else if(counter==1) {
											counter++;
											b=Double.parseDouble(temp);
											temp="";
										}
										else if(counter==2) {
											counter++;
											c=Double.parseDouble(temp);
											temp="";
										}

									}
									else if(j+1==ob.length()) {
										temp=temp+ob.charAt(j);
										d=Double.parseDouble(temp);
										temp="";
									}
								}
								Rect2D s=new Rect2D(new Point2D(a,b),new Point2D(c,d));
								Color co=new Color(color);
								GUIShape item=new GUIShape(s,flag,co,tag);
								this.add(item);
								break;
							}

						}
					}

				}
			}
			myReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * @return new object in kind of Rect2D.
	 * this object will be the bounding box of the GUI.
	 * I pass(in loop-on the array) the element-one by one and in the and
	 * I take the maximum and minimum-x and y-and with that I build the new bound
	 * rectangle object
	 */
	@Override
	public Rect2D getBoundingBox() {
		double Maxx=0;
		double Maxy=0;
		double Minx=0;
		double Miny=0;
		
		for(int i=0;i<size;i++) {
			  if(this.arr[i].getShape() instanceof Point2D) {
			    	Maxx=Math.max(Maxx, ((Point2D)this.arr[i].getShape()).x());
			    	Minx=Math.min(Minx, ((Point2D)this.arr[i].getShape()).x());
			     	Maxy=Math.max(Maxy, ((Point2D)this.arr[i].getShape()).y());
			    	Miny=Math.min(Miny, ((Point2D)this.arr[i].getShape()).y());
			    }
			    else if(this.arr[i].getShape() instanceof Segment2D) {
			    	Point2D [] ps=((Segment2D)this.arr[i].getShape()).getPoints();
			    	Maxx=Math.max(Maxx, ps[0].x());
			    	Maxx=Math.max(Maxx, ps[1].x());
			    	Minx=Math.min(Minx, ps[0].x());
			    	Minx=Math.min(Minx, ps[1].x());
			    	Maxy=Math.max(Maxy, ps[0].y());
			    	Maxy=Math.max(Maxy, ps[1].y());
			    	Miny=Math.min(Miny, ps[0].y());
			    	Miny=Math.min(Miny, ps[1].y());
			    	
			    }
			    else if(this.arr[i].getShape() instanceof Circle2D) {
			    	double rad=((Circle2D)this.arr[i].getShape()).getRadius();
			    	Point2D center=((Circle2D)this.arr[i].getShape()).centerOfMass();
			    	
			    	double posx=center.x()+rad;
			    	double negx=center.x()-rad;
			    	double posy=center.y()+rad;
			    	double negy=center.y()-rad;
			    	
			     	Maxx=Math.max(Maxx, posx);
			    	Maxx=Math.max(Maxx, negx);
			    	Minx=Math.min(Minx, posx);
			    	Minx=Math.min(Minx, negx);
			    	Maxy=Math.max(Maxy, posy);
			    	Maxy=Math.max(Maxy, negy);
			    	Miny=Math.min(Miny, posy);
			    	Miny=Math.min(Miny, negy);
			    	
			    }
			    else if(this.arr[i].getShape() instanceof Rect2D) {
			    	Point2D [] ps=((Rect2D)this.arr[i].getShape()).getPoints();
			    	Maxx=Math.max(Maxx, ps[0].x());
			    	Maxx=Math.max(Maxx, ps[1].x());
			    	Minx=Math.min(Minx, ps[0].x());
			    	Minx=Math.min(Minx, ps[1].x());
			    	Maxy=Math.max(Maxy, ps[0].y());
			    	Maxy=Math.max(Maxy, ps[1].y());
			    	Miny=Math.min(Miny, ps[0].y());
			    	Miny=Math.min(Miny, ps[1].y());
			    }
			    else if(this.arr[i].getShape() instanceof Triangle2D) {
			    	Point2D [] ps=((Triangle2D)this.arr[i].getShape()).getPoints();
			    	Maxx=Math.max(Maxx, ps[0].x());
			    	Maxx=Math.max(Maxx, ps[1].x());
			    	Maxx=Math.max(Maxx, ps[2].x());
			    	Minx=Math.min(Minx, ps[0].x());
			    	Minx=Math.min(Minx, ps[1].x());
			    	Minx=Math.min(Minx, ps[2].x());
			    	Maxy=Math.max(Maxy, ps[0].y());
			    	Maxy=Math.max(Maxy, ps[1].y());
			    	Maxy=Math.max(Maxy, ps[2].y());
			    	Miny=Math.min(Miny, ps[0].y());
			    	Miny=Math.min(Miny, ps[1].y());
			    	Miny=Math.min(Miny, ps[2].y());
			    }
		}
		return (new Rect2D(new Point2D(Minx,Miny),new Point2D(Maxx,Maxy)));
	}
	/**
	 * @return the data of the object-in String
	 */
	@Override
	public String toString() {
		String st="";
		for(int i=0;i<size;i++) {
			st=st+this.arr[i].toString()+"\n";
		}
		return st;
	}
}