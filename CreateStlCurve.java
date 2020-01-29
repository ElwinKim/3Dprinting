import curves.Curve;
import java.util.ArrayList;
import java.util.List;

/**
 * Application to create a text STL file for a Cone curve
 * @author      Byeongjin Kim kim00404@algonquinlive.com
 * @version     1.0              
 */

public class CreateStlCurve {
	private List<List<Point3D>> list = new ArrayList<>();

	/**
	 * Create a matrix of points
	 */
	public void createMatrix(Curve curve)
	{

		double maxX = curve.getMaxX();
		double maxY = curve.getMaxY();
		double minX = curve.getMinX();
		double minY = curve.getMinY();
		double stepSize = curve.getStepSize();

		int xSize = (int)((maxX-minX)/stepSize + 1);
		int ySize = (int)((maxY-minY)/stepSize + 1);
		list = new ArrayList<List<Point3D>>(ySize);

		double xValue, yValue = 0;
		for (int y = 0; y< ySize; y++)
		{
			List<Point3D> row = new ArrayList<Point3D>();
			list.add(row);
			xValue=0;

            for(int x=0; x<xSize; x++)
            {
                row.add(new Point3D(xValue,yValue,curve.getZ(xValue+minX, yValue+minY)));
                xValue+=stepSize;
            }
            yValue+=stepSize;
		}

	}


	/**
	 * Create Solid based on values in matrix
	 * @param name Name of the solid
	 * @return Generated solid
	 */
	public Solid createSolid(String name)
	{
		Solid solid = new Solid(name);


		int height=list.size()-1;
		int width=list.get(0).size()-1;

		// Create curve
		for(int h=0; h<height; h++)
		{
			for(int w=0; w<width; w++)
			{
				// as viewed from above
				solid.addFacet(
						list.get(h).get(w),    // bottom left
						list.get(h).get(w+1),  // bottom rights
						list.get(h+1).get(w+1),// top right
						list.get(h+1).get(w)
				); // top left
			}
		}

		// Create bottom edge
		Point3D p = new Point3D(0,0,0);
		for(int w=0; w < width ; w++)
		{
			solid.addFacet(
					 p,    // bottom left
					new Point3D(w+1,0,0),  // bottom rights
					list.get(0).get(w+1),// top right
					list.get(0).get(w)
			);
		}

		// Create top edge
		for(int h=0; h < height ; h++)
		{
			solid.addFacet(
					new Point3D(h+1, height, 0),    // bottom left
					new Point3D(h, height,0),  // bottom rights
					list.get(height).get(h),// top right
					list.get(height).get(h+1)
			);
		}

		// Create left edge
		for(int h=0; h < height ; h++)
		{
			solid.addFacet(
					new Point3D(0, h+1, 0),    // bottom left
					new Point3D(0, h,0),  // bottom rights
					list.get(h).get(0),// top right
					list.get(h+1).get(0)
			);
		}

		// Create right edge
		for(int h=0; h < height ; h++)
		{
			solid.addFacet(
					new Point3D(width, h, 0),    // bottom left
					new Point3D(width, h+1,0),  // bottom rights
					list.get(h+1).get(width),// top right
					list.get(h).get(width)
			);
		}

		// Create base
	
			solid.addFacet(
					new Point3D(0, 0, 0),    // bottom left
					new Point3D(0, height,0),  // bottom rights
					new Point3D(width, height,0),// top right
					new Point3D(width, 0,0)
			);

		return solid;
	}

	/**
	 * Print the points to the console
	 */
	public void printMatrix()
	{
		for(List<Point3D> row : list)
		{
			for(Point3D value : row)
				System.out.print("("+value+") ");
			System.out.println();
		}
	}
	
	/**
	 * Application main
	 * @param arg Commandline argument (not used)
	 */

}
