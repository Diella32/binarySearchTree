package binarySearchTreePD;

public class Student {
 
	int id;
	String name; 
	public Student(int idUsed, String nameUsed) {
		id = idUsed;
		name = nameUsed; 
		
	}
	public void setId(int idUsed) {
		id = idUsed; 
	}
	
	public int getKey() {
		return id; 
	}
	
	public String getElement() {
		return name;
	}
	public void setName(String nameUsed) {
		name = nameUsed; 
	}
}
