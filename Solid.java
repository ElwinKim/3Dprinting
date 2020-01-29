import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Get vertex value and facet, and make STL file and convert to String
 *
 */
public class Solid {
	String name;
	String result ="";
	List<Facet> facets = new ArrayList<>();

	int currentSize;
	
	public Solid() {
		
	}

	/**
	 * To get the name
	 * @param name
	 */
	public Solid(String name) {
		this.name = name;
	}

	/**
	 *  to add facet value to facet array list
	 * @param facet
	 * @return boolean
	 */
	public boolean addFacet(Facet facet) {
		for (int i=currentSize; i<=facets.size();) {
			facets.add(i, facet);
			currentSize++;
			if(facets.get(i)!=null)
				return false;
		}
		return true;
	}

	/**
	 * to get vertex and add facet values to facet array list
	 * @param vertex
	 * @return boolean
	 */
	public boolean addFacet(Point3D... vertex) {
		if(vertex.length< 3){
			return false;
		}
		else{
			for (int i=1; i< vertex.length - 1; i++){
				facets.add(new Facet(vertex[0], vertex[i], vertex[i+1]));
			}
			return true;
		}
	}

	/**
	 * To get Path value from CreateStlCurve
	 * and make STL file
	 * @param path
	 * @throws IOException
	 */
	public void toTextFile(Path path) throws IOException {
			FileWriter writer = new FileWriter(path.toString());
			writer.write(toString());
			writer.close();
	}

	/**
	 * to save facets to result and convert to String
	 * @return
	 */
	public String toString() {

		for (Facet a: facets) {
			result +="" + a;
		}
		return "solid " + name + "\n" + result + "endsolid " + name;
	}

	
}
