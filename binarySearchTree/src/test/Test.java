package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



import binarySearchTreePD.Student;
import binarySearchTreePD.binarySearchTree;

public class Test {
	
	public static void Test1() {
		String fileUsed = "testdata.csv";
		String line = null;
		String dataType; 
		Student student;  
		String[] stringUsed; 
		
		binarySearchTree<Student, Integer> elementUsed = new binarySearchTree() ; 
        
		int id = 0; 


	try {
	         FileReader fileReader =  new FileReader("C:\\Users\\diell\\Downloads\\testdata.csv");

	         BufferedReader bufferedReader = new BufferedReader(fileReader);
	         
	         while((line = bufferedReader.readLine())!= null) {
	        	 stringUsed = line.split(","); 
	        	 student = new Student(Integer.parseInt(stringUsed[0]), stringUsed[1]); 
	        	 
	        	elementUsed.insert(student, student.getKey());

	        	
	         }
	}

	catch(FileNotFoundException ex) 
		 {
		   System.out.println( "Unable to open file '" +  fileUsed + "'");                
		 }
	catch(IOException ex) 
		 {
		    System.out.println (  "Error reading file '" + fileUsed + "'");   	
		 }
	
			System.out.println("Binary Tree Height: " + elementUsed.height());
			System.out.println("Search For: 782209");
			System.out.println("Search result: 782209 - " + elementUsed.search(782209).getElement());
			elementUsed.remove(782209).getElement();
			System.out.println("Removed 782209");
			System.out.println("Search for 782209");
			
		//	System.out.println(elementUsed.search(782209));
			System.out.print("Search 782209");
			if (elementUsed.search(782209) == null) {
				 System.out.println("" + " not found"); 
			 }	
	
	}

}
