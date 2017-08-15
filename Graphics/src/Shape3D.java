/**
 * @author ewenw
 * May 10, 2017
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;


public class Shape3D {
	
	public boolean fill = true;
	Polygon poly;
	static Frame frame;
	private LinkedList<Point3D> points = new LinkedList<Point3D>();
	Point2D[] points2D;
	// center point of shape
	Point3D origin;
	public Color fillColor = Color.GRAY;
	public Color outlineColor = Color.BLACK;
	
	public Shape3D(Point3D origin, Color fillColor){
		this.origin = origin;
		this.fillColor = fillColor;
	}
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
	
	public double zDepth(){
		double z = 0;
		for (Point3D p: points)
		{
			z += p.z();	
		}
		int n = points.size();
		return z / n;
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
		}		
	}
	
	public void update(){
		rotate(Math.toRadians(1), Math.toRadians(1), Math.toRadians(0));
		updateProjectedPoints();		
	}
	
	protected void draw(Graphics g1){	
		Graphics2D g = (Graphics2D) g1;
		poly = new Polygon();
		for (int i = 0; i < points2D.length; i++)
		{	
			Point2D p1 = points2D[i];
	        poly.addPoint((int)p1.getX(), (int)p1.getY());
		}
		g.setColor(fillColor);	
		if (fill)
			g.fillPolygon(poly);
		g.setColor(outlineColor);	
		g.setStroke(new BasicStroke(2));
		g.drawPolygon(poly);
	}	
	
}
