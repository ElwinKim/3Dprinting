/**
 * This class is for getting three point, making facet and converting to String
 *
 */
public class Facet{
	Point3D normal;
	Point3D v1;
	Point3D v2;
	Point3D v3;

	/**
	 * To get Point3D three points and call calNormal for calculating normal facet
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	public Facet(Point3D p1, Point3D p2, Point3D p3) {
		v1 = p1;
		v2 = p2;
		v3 = p3;

		//For calculate normal facet.
		normal = normal.calNormal(v1, v2, v3);
	}

	/**
	 * to convert String
	 * @return facet normal and Point3D vertex value with String type
	 */
	public String toString() {
		return  "facet normal " + normal +"\n" + " outer loop \n" + "  vertex " + v1 
				+"\n" +"  vertex "+ v2 +"\n" + "  vertex " + v3 +"\n"
				+ " endloop \n" + "endfacet \n";
		
	}

}
