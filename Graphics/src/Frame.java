/**
 * @author ewenw
 * May 10, 2017
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Frame extends JPanel {
	public static Point3D eye = new Point3D(400f, 400f, 800f);
	public Timer timer;
	public static List<Shape3D> shapes;
	
	// create test shapes
	public static void createShapes(){
		shapes = new ArrayList<Shape3D>();
		Box box = new Box(new Point3D(200, 200, 50), 50);
		Shape3D triangle = new Shape3D(new Point3D(500, 500, 200));
		triangle.addPoint(new Point3D(-50, -50, 0));
		triangle.addPoint(new Point3D(-50, 50, 0));
		triangle.addPoint(new Point3D(50, 50, 0));
		addShapes(box.getShapes());
		shapes.add(triangle);
		}
	
	public void moveEye(Point3D p){
		eye.move(p.x(), p.y(), p.z());
	}
	
	public static Point2D getProjection(Point3D p){
		double x = eye.z() * (p.x() - eye.x()) / (eye.z() + p.z()) + eye.x();
		double y = eye.z() * (p.y() - eye.y()) / (eye.z() + p.z()) + eye.y();
		Point2D p2 = new Point2D.Double(x, y);
		return p2;
	}
	
	public Frame() {
		this.setBackground(Color.white);
		JFrame frame = new JFrame();
		frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
        	  @Override
        	  public void run() {
        		update();      		
        	  }
        }, 0, 50);
    }
	
	public void update(){
		for (Shape3D s: shapes)
		{
			s.update();
		}
		this.validate();
		this.repaint();
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for (Shape3D s: shapes)
		{
			s.draw(g);
		}
	}

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	createShapes();
                new Frame();
            }
        });
    }
    
    // add append new shapes list into list
 	public static void addShapes(List<Shape3D> shapesList){
 		for(Shape3D s: shapesList)
 		{
 			shapes.add(s);
 		}
 	}
}
