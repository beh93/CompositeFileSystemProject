package file1002151;

public class File implements Component{
	
	private String name; 
	private int size; 
	private int count;
	
	
	public File(String n, int s) {
		name = n;
		size = s;
		count = 1; // hard-coding count as 1 because each file counts as a single unit toward the total number of Files inside a Directory
	}
	
	// Returning the name of a File
	public String getName() {
		return name;
	}
	
	//Returning the size of a File, to be used in the mirroring method in Directory
	public int getSize() {
		return size;
	}
	
	// Returning the count of a File, to be used in the mirroring method in Directory
	public int getCount(){
			return count;
		}
	
	// Displaying the name of the File, along with its size;
	public String display(String prefix) {
		return name + " (" + size + ")\n";
		}
	
	// Returning null as Files are not capable of returning instances of Directories;
	public Component search(String name) {
		return null;
	}

}