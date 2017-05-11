/**
 * @author ewenw
 * May 10, 2017
 */

public class Point3D {
	private double x, y, z;
	
	public Point3D(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double x(){ return x;}
	public double y(){ return y;}
	public double z(){ return z;}
	
	public void setX(double x){ this.x = x;}
	public void setY(double y){ this.y = y;}
	public void setZ(double z){ this.z = z;}
	
	public void move(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point3D add(Point3D p){
		return new Point3D(x + p.x(), y + p.y(), z + p.z());
	}
}
