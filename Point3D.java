/**
 * To get x,y,z value and calculate normal facet in Point3D
 */

public class Point3D {
	double x = 0d;
	double y = 0d;
	double z = 0d;


	/**Get parameter and save into x,y,z variabels
	 *
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(double x, double y, double z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Make string from Point3D
	 * @return x,y,z
	 */
	public String toString() {
		return "" + x + " " + y + " " + z + "";
	}

	/**
	 * To get x value
	 * @return x
	 */
	public double getX() {
		return x;
	}

	/**
	 * To get y value
	 * @return y
	 */
	public double getY() {
		return y;
	}

	/**
	 * To get z value
	 * @return z
	 */
	public double getZ() {
		return z;
	}

	/**
	 * To get Point3D Calculate normal facet
	 * @param v1
	 * @param v2
	 * @param v3
	 * @return Point3D
	 */
	static Point3D calNormal(Point3D v1, Point3D v2, Point3D v3) {//refernce type

		double i1 = v1.x - v2.x;
		double j1 = v1.y - v2.y;
		double k1 = v1.z - v2.z;
		double i2 = v1.x - v3.x;
		double j2 = v1.y - v3.y;
		double k2 = v1.z - v3.z;
		double x = j1 * k2 - k1 * j2;
		double y = k1 * i2 - i1 * k2;
		double z = i1 * j2 - j1 * i2;


		double len= Math.sqrt(x*x + y*y + z*z);

		return new Point3D(x/len, y/len, z/len);
	}


}
