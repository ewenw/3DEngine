import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ewenw
 * May 10, 2017
 */

public class Box {
	private List<Shape3D> shapes;
	
	public Box(Point3D origin, float size){
		shapes = new ArrayList<Shape3D>();
		
		float len = size / 2;
		
		shapes.add(new Plane(origin, new Point3D(len, -len, -len), new Point3D(-len, len, -len), Color.green));
		shapes.add(new Plane(origin, new Point3D(len, -len, -len), new Point3D(-len, -len, len), Color.red));
		shapes.add(new Plane(origin, new Point3D(-len, len, len), new Point3D(len, len, -len)));
		shapes.add(new Plane(origin, new Point3D(-len, len, len), new Point3D(len, -len, len), Color.ORANGE)); 
		// shapes.add(new Plane(origin, new Point3D(-len, len, len), new Point3D(len, -len, -len), Color.CYAN)); 
		// shapes.add(new Plane(origin, new Point3D(len, -len, -len), new Point3D(len, len, -len), Color.BLUE));
		
		
		
	}
	
	public List<Shape3D> getShapes(){
		return shapes;		
	}
}
