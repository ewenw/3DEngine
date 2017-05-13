import java.util.ArrayList;
import java.util.List;

/**
 * @author ewenw
 * May 10, 2017
 */

public class Box {
	private List<Shape3D> shapes;
	
	public Box(Point3D origin, float width){
		shapes = new ArrayList<Shape3D>();
		
		shapes.add(new Plane(origin, new Point3D(-width/2, -width/2, -width/2), new Point3D(width/2, -width/2, width/2)));
		shapes.add(new Plane(origin, new Point3D(-width/2, -width/2, -width/2), new Point3D(width/2, width/2, -width/2)));
		shapes.add(new Plane(origin, new Point3D(-width/2, -width/2, width/2), new Point3D(width/2, width/2, width/2)));
		shapes.add(new Plane(origin, new Point3D(width/2, width/2, width/2), new Point3D(-width/2, width/2, -width/2)));
		
	}
	
	public List<Shape3D> getShapes(){
		return shapes;		
	}
}
