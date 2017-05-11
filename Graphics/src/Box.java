/**
 * @author ewenw
 * May 10, 2017
 */

public class Box extends Shape3D{
	public Box(Point3D origin, float size){
		super(origin);
		// close side
		super.addPoint(new Point3D(-size, -size, -size));
		super.addPoint(new Point3D(-size, size, -size));
		super.addPoint(new Point3D(size, size, -size));
		super.addPoint(new Point3D(size, -size, -size));
		// far side
		super.addPoint(new Point3D(-size, -size, size));
		super.addPoint(new Point3D(-size, size, size));
		super.addPoint(new Point3D(size, size, size));
		super.addPoint(new Point3D(size, -size, size));
		// left
		super.addPoint(new Point3D(-size, -size, -size));
		super.addPoint(new Point3D(-size, size, -size));
		super.addPoint(new Point3D(-size, size, size));
		super.addPoint(new Point3D(-size, -size, size));
		// right
		super.addPoint(new Point3D(size, -size, -size));
		super.addPoint(new Point3D(size, size, -size));
		super.addPoint(new Point3D(size, size, size));
		super.addPoint(new Point3D(size, -size, size));
		// top
		super.addPoint(new Point3D(size, size, -size));
		super.addPoint(new Point3D(size, size, size));
		super.addPoint(new Point3D(-size, size, size));
		super.addPoint(new Point3D(-size, size, -size));
		// bottom
		super.addPoint(new Point3D(size, -size, -size));
		super.addPoint(new Point3D(size, -size, size));
		super.addPoint(new Point3D(-size, -size, size));
		super.addPoint(new Point3D(-size, -size, -size));	
	}
}
