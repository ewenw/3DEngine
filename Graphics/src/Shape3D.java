/**
 * @author ewenw
 * May 10, 2017
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.LinkedList;


public class Shape3D {
	
	static Frame frame;
	private LinkedList<Point3D> points = new LinkedList<Point3D>();
	Point2D[] points2D;
	// center point of shape
	Point3D origin;
	
	public Shape3D(Point3D origin){
		this.origin = origin;
	}
	
	public void addPoint(Point3D p){
		points.add(p);
	}
	
	public void updateProjectedPoints(){
		points2D = new Point2D[points.size()];
		int i = 0;
		for (Point3D p: points)
		{
			points2D[i] = (Frame.getProjection(p.add(origin)));
			i++;
		}	
	}
	
	public void calculateOrigin(){
		double[] c = new double[3];
		for (Point3D p: points)
		{
			c[0] += p.x();
			c[1] += p.y();
			c[2] += p.z();		
		}
		int n = points.size();
		origin = new Point3D(c[0] / n, c[1] / n, c[2] / n);
	}
	
	public void rotate(double angX, double angY, double angZ){
		for (Point3D p: points)
		{
			// rotate around x
			double sin_x = Math.sin(angX);
			double cos_x = Math.cos(angX);
			double y = p.y() * cos_x - p.z() * sin_x;
			p.setZ(p.z() * cos_x + p.y() * sin_x);
			p.setY(y);
			// rotate around y
			double sin_y = Math.sin(angY);
			double cos_y = Math.cos(angY);
			double z = p.z() * cos_y + p.x() * sin_y;
			p.setX(p.x() * cos_y - p.z()  * sin_y);
			p.setZ(z);
			// rotate around z
			double sin_z = Math.sin(angZ);
			double cos_z = Math.cos(angZ);
			double x = p.x() * cos_z - p.y() * sin_z;	
			p.setY(p.y() * cos_z + p.x() * sin_z);
			p.setX(x);
			System.out.println(cos_z);
			System.out.println(sin_z);
		}		
	}
	
	public void update(){
		rotate(Math.toRadians(5), Math.toRadians(5), Math.toRadians(0));	
		updateProjectedPoints();		
	}
	
	protected void draw(Graphics g){	
		g.setColor(Color.blue);		
		for (int i = 0; i < points2D.length; i++)
		{	
			Point2D p1 = points2D[i];
	        if(i < points2D.length-1){
	        	Point2D p2 = points2D[i+1];
	        	g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
	        }
	        if(i==0){
	        	Point2D p3 = points2D[points2D.length - 1];
	        	g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p3.getX(), (int)p3.getY());
	        }
		}
	}	
	
}
