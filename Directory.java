import java.util.ArrayList; 

public class Directory implements Component{
	
	private String name;
	private ArrayList <Component> children;
	private int size;
	private int count;


	
	public Directory(String n) {
		name = n;
		children = new ArrayList<Component>(); // initialising an ArrayList that can hold both Files and Directories; 
		size = 0; // hard-coding size to 0 as the size of Directories must not factor into total size calculations;
		count = 0; // hard=coding count to 0 as Directories must not count toward total items stored in a parent Directory;
	}
	
	//Returning the name of the Directory;
	public String getName() {
		return name;
	}
	
	// A method calculating the total size of all Files stored in a Directory
	public int getSize() {
		int tmp = 0; // a temporary variable
		for(Component a: children) {
			tmp += a.getSize();
		}
		return tmp;
	}
	
	// A method calculating the total number of Files stored in a Directory
	public int getCount() {
		int tmp = 0;
		for(Component a: children) {
			tmp += a.getCount();
		}
		return tmp;
	}
			
	public String display(String prefix) {

		String display = name + ": (count=" + getCount() + ", size=" + getSize() + ")\n" + prefix;
		
		// the for each loop below is iterating through the list of children and calling the display method relevant to each Component;
		for(Component a: children) {
			display += prefix + a.display("\t"); 	
		}
		return display;
	}
	
	public void add(Component c) {
		children.add(c);
	}

	public void remove(Component c) {
		children.remove(c);
	}
	
	public Component search(String name) {

		File n = new File("null",0); // initialising a new File with the name "null"

		for(Component a : children) {
			// if the File is in the root Directory; it will return an instance of itself in this case;
			if (a instanceof File && a.getName().equals(name)) {
				return this;
				}
			/* if the File is in a sub-Directory, it will return an instance of the sub-Directory;
			 * !a.search(name).getName().equals("null") searches the sub-Directory and, if the result of the comparison is not "null", then it 
			 * means that a Component with the same name as the String passed into the search() method exists within;*/
			else if(a instanceof Directory && !a.search(name).getName().equals("null")) { // identifying a Directory object;
				return a;
				}
			//if the File is not inside the sub-Directory, continue iterating through children;
			else {
				continue;
			}
		}

		return n; // returning the "null" File if the name cannot be found in children;
		}
}
