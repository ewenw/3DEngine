/**
 * @author ewenw
 * May 10, 2017
 */

public class Plane extends Shape3D{
	public Plane(Point3D origin, Point3D p1, Point3D p2){
		super(origin);
		super.addPoint(new Point3D(p1.x(), p1.y(), p1.z()));
		super.addPoint(new Point3D(p1.x(), p2.y(), p2.z()));
		super.addPoint(new Point3D(p2.x(), p2.y(), p2.z()));
		super.addPoint(new Point3D(p2.x(), p1.y(), p1.z()));
	}
}
