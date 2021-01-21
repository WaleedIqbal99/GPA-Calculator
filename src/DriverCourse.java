// -------------------------------------------------------
// Assignment 3 Question 2b
// Written by: Waleed Iqbal 40112596
// For COMP 248 Section W – Winter 2019
// March 25th, 2019
// --------------------------------------------------------

/*This driver class tests the course object. I use three Course objects for three different
 * courses and use the toString method to display the information for each.
 */

public class DriverCourse {

	public static void main(String[] args) {
		
		//Creating three Courses objects
		Course c1 = new Course("COMP248", 3.5, "A+");
		Course c2 = new Course("COMP232", 3, "B");
		Course c3 = new Course("MATH123", 4, "B+");
		
		//Displaying content of each course
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

	}
}
