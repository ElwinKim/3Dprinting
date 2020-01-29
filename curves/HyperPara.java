package curves;
import java.lang.*;
/**
 * The curve z=(x/10)^3 - 3*(x/10)*(y/10)^2 from (-10,-10) to (10,10)
 * @author      Byeongjin Kim
 * @version     1.0              
 */
public class HyperPara implements Curve {
	/**
	 * Return the minimum X value of this curve
	 * @return minimum X value
	 */
	public double getMinX() {
		return -10;
	}
	
	/**
	 * Return the minimum Y value of this curve
	 * @return minimum Y value
	 */
	public double getMinY() {
		return -10;
	}
	
	/**
	 * Return the maximum X value of this curve
	 * @return maximum X value
	 */
	public double getMaxX() {
		return 10;
	}
	
	/**
	 * Return the maximum Y value of this curve
	 * @return maximum Y value
	 */
	public double getMaxY() {
		return 10;
	} 
	
	/**
	 * Return the step size for the grid used to plot this grid.
	 * @return step size
	 */
	public double getStepSize() {
		return 1;
	}
	
	/**
	 * Create the Z value for Monkey Saddle
	 * @param x the X value
	 * @param y the Y value
	 * @return The Z value
	 */
	public double getZ(double i, double j) {
		double x=Math.abs(i/2);
		double y=Math.abs(j/2);
		return (x*x/16 - y*y/9)*2+10;
	}

	/**
	 * Name of curve (same as filename)
	 * @return Name of curve
	 */
	public String getName()
	{
		return "HyperParaboloid";
	}


}
