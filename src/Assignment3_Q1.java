// -------------------------------------------------------
// Assignment 3 Question 1
// Written by: Waleed Iqbal 40112596
// For COMP 248 Section W – Winter 2019
// March 25th, 2019
// --------------------------------------------------------

/*This program calculate the GPA of the user. It starts off by prompting the user to enter all the information needed
 * to do so while error checking him with error messages. After acquiring the needed information, the user gets an option
 * menu which he can choose from. With option 1, the user can get his current GPA, credits and the courses with their info.
 * Option 2 calculates the new GPA. Option 3 allows the user to delete a course while option 4 lets the user add one. Finally,
 * option 5 exits the program. The user can choose an option as many times as he desires until he chooses to exit.
 */

//Importing Scanner
import java.util.Scanner;

public class Assignment3_Q1 {

	public static void main(String[] args) {
		//Initializing scanner
		Scanner kb = new Scanner(System.in);
		
		//Displaying welcome message
		System.out.println("******************************************************");
		System.out.println("*** Welcome to the bested GPA calculator ever...   ***");
		System.out.println("*** The program will ask you first to enter the    ***");
		System.out.println("*** number of credits you have accumulated so far. ***");
		System.out.println();
		System.out.println("*** If this is your very first semester, please    ***");
		System.out.println("*** enter 0.\t\t\t\t\t   ***");
		System.out.println("******************************************************");
		System.out.println();
		
		//Declaring variables and initializing gpa to zero because it will be reinitialized in an if statement
		//and declaring and initializing a constant for maximum number of courses
		int cur_credits, nbcourses;
		double gpa = 0;
		final int MAXCOURSES = 10;
		
		//Declaring and initializing 4 arrays with a size of maximum courses
		String[] coursenames = new String[MAXCOURSES];
		String[] lettergrades = new String[MAXCOURSES];
		double[] coursecredits = new double[MAXCOURSES];
		double[] coursegrades = new double [MAXCOURSES];
		
		//Prompting user to enter number of credits and initializing
		System.out.print("Please enter how many credits you have accumulated so\n"
				+ "far not including your current semester: ");
		cur_credits = kb.nextInt();
		//Error checking the user so that credits is always positive
		while (cur_credits<0)
		{
			System.out.println("");
			System.out.println("ERROR: number of past credits has to be a positive number.");
			System.out.println("");
			System.out.print("Please enter how many credits you have accumulated so\n"
					+ "far not including your current semester: ");
			cur_credits = kb.nextInt();
			System.out.println("");
		}
		//Checking if it's user's first semester so that we don't need to ask for GPA
		//and asking for GPA if it isn't first semester
		if (cur_credits > 0)
		{
			System.out.print("Please enter your current GPA: ");
			gpa = kb.nextDouble();
			//Error checking so that GPA is always valid (between 0 and 4.3)
			while (gpa<0 || gpa>4.3)
			{
				System.out.println("");
				System.out.println("ERROR: a valid gpa is between 0 to 4.3 inclusive");
				System.out.println("");
				System.out.print("Please enter your current GPA: ");
				gpa = kb.nextDouble();
				System.out.println("");
			}
		}
		//Prompting user for number of courses and error checking to make sure it's less than the maximum courses
		//and that the number of courses is more than 1
		System.out.print("Please enter how many courses you want to add to the GPA calculator: ");
		nbcourses = kb.nextInt();
		while (nbcourses > MAXCOURSES)
		{
			System.out.println("\nERROR: this system can only support 10 courses.\n");
			System.out.print("Please enter how many courses you want to add to the GPA calculator: ");
			nbcourses = kb.nextInt();
		}
		while (nbcourses<1)
		{
			System.out.println("");
			System.out.println("ERROR: number of courses has to be a positive number.");
			System.out.println("");
			System.out.print("Please enter how many courses you want to add to the GPA calculator: ");
			nbcourses = kb.nextInt();
		}
		//Using a for loop to prompt the user for information on each class and error checking so that the info is valid
		for (int i = 0; i < nbcourses; i++)
		{
			System.out.println("");
			System.out.print("Please enter the name of course number " + (i+1) + ": ");
			coursenames[i] = kb.next();
			System.out.print("Please enter the number of credits of course number " + (i+1) + ": ");
			coursecredits[i] = kb.nextDouble();
			while (coursecredits[i]<1)
			{
				System.out.println("");
				System.out.println("ERROR: course credit has to be a positive number.");
				System.out.println("");
				System.out.print("Please enter the number of credits of course number " + (i+1) + ": ");
				coursecredits[i] = kb.nextInt();
			}
			System.out.print("Please enter the letter grade of course number " + (i+1) + ": ");
			lettergrades[i] = kb.next();
			while (!lettergrades[i].equals("A+") && !lettergrades[i].equals("A") && !lettergrades[i].equals("A-") && !lettergrades[i].equals("B+") &&
					!lettergrades[i].equals("B") && !lettergrades[i].equals("B-") && !lettergrades[i].equals("C+") && !lettergrades[i].equals("C") &&
					!lettergrades[i].equals("C-") && !lettergrades[i].equals("D+") && !lettergrades[i].equals("D") && !lettergrades[i].equals("D-") &&
					!lettergrades[i].equals("FNS"))
			{
				System.out.println("");
				System.out.println("ERROR: course grade has to be one of the following...\n "
						+ "A+, A, A-, B+, B, B-, C+, C, C-, D+, D, D-, FNS");
				System.out.println("");
				System.out.print("Please enter the letter grade of course number " + (i+1) + ": ");
				lettergrades[i] = kb.next();
			}
		}
		//Converting the letter grades of each course to grade points
		for (int i = 0; i < nbcourses; i++)
			switch (lettergrades[i])
			{
			case "A+": coursegrades[i]=4.30;
			break;
			case "A": coursegrades[i]=4.00;
			break;
			case "A-": coursegrades[i]=3.70;
			break;
			case "B+": coursegrades[i]=3.30;
			break;
			case "B": coursegrades[i]=3.00;
			break;
			case "B-": coursegrades[i]=2.70;
			break;
			case "C+": coursegrades[i]=2.30;
			break;
			case "C": coursegrades[i]=2.00;
			break;
			case "C-": coursegrades[i]=1.70;
			break;
			case "D+": coursegrades[i]=1.30;
			break;
			case "D": coursegrades[i]=1.00;
			break;
			case "D-": coursegrades[i]=0.70;
			break;
			case "FNS": coursegrades[i]=0.00;
			}
		
		//Declaring an int for the option menu
		int option;
		
		//Using a do while loop for the options menu so that the user can use the program until he exits
		do
		{
		System.out.println("\nPlease choose one of the following options\n"
				+ "Press 1: to display the courses in the system\n"
				+ "Press 2: to display the new GPA\n"
				+ "Press 3: to delete a course\n"
				+ "Press 4: to add a course\n"
				+ "Press 5: to exit the program");	
		option = kb.nextInt();
		//Error checking so that the user always inputs a valid option
		while (option<1 || option>5)
		{
			System.out.println("");
			System.out.println("Menu option has to be between 1 and 5 inclusive.");
			System.out.println("");
			option = kb.nextInt();
			System.out.println("");
		}
		
		//Using a switch to handle the menu options
		switch (option)
		{
		//Displaying user's current GPA, accumulated credits and courses with their info
		case 1:
		{
			System.out.println("Your current GPA is: " + gpa);
			System.out.println("Your accumulated credits so far: " + cur_credits);
			System.out.println("Course Number\t\tCourse Name\t\tCourse Credit\tCourse Grade");
			for (int i = 0; i < nbcourses; i++)
				System.out.println((i+1) + "\t\t\t" + coursenames[i] + "\t\t\t" + coursecredits[i] + "\t\t" + lettergrades[i]);
		}
		break;
		//Calculating user's new GPA
		case 2:
		{
		//Converting letter grade to points again because the user might have added courses with option 4
			for (int i = 0; i < nbcourses; i++)
				switch (lettergrades[i])
				{
				case "A+": coursegrades[i]=4.30;
				break;
				case "A": coursegrades[i]=4.00;
				break;
				case "A-": coursegrades[i]=3.70;
				break;
				case "B+": coursegrades[i]=3.30;
				break;
				case "B": coursegrades[i]=3.00;
				break;
				case "B-": coursegrades[i]=2.70;
				break;
				case "C+": coursegrades[i]=2.30;
				break;
				case "C": coursegrades[i]=2.00;
				break;
				case "C-": coursegrades[i]=1.70;
				break;
				case "D+": coursegrades[i]=1.30;
				break;
				case "D": coursegrades[i]=1.00;
				break;
				case "D-": coursegrades[i]=0.70;
				break;
				case "FNS": coursegrades[i]=0.00;
				}
			//Declaring and initializing variables for GPA calculation and then calculating it and displaying it
			double x, y, a, xsum=0, ysum=0, newgpa;
			for (int i = 0; i<nbcourses; i++)
			{
				a = coursegrades[i]*coursecredits[i];
				xsum += a;
			}
			for (int i = 0; i<nbcourses; i++)
				ysum += coursecredits[i];
			x = (gpa*cur_credits)+xsum;
			y = cur_credits + ysum;
			newgpa = x/y;
			System.out.println("Your new GPA is: " + newgpa);
		}
		break;
		//Deleting a course
		case 3:
		{
			int deleteoption;
			//Displaying courses for user to check which one to delete
			System.out.println("Course Number\t\tCourse Name\t\tCourse Credit\tCourse Grade");
			for (int i = 0; i < nbcourses; i++)
				System.out.println((i+1) + "\t\t\t" + coursenames[i] + "\t\t\t" + coursecredits[i] + "\t\t" + lettergrades[i]);
			System.out.print("Please enter the course number you want to delete: ");
			deleteoption = kb.nextInt();
			//Reinitializing the arrays after user deleted a course
			for (int i = (deleteoption-1); i < nbcourses; i++)
			{
				coursenames[i] = coursenames[i+1];
				lettergrades[i] = lettergrades[i+1];
				coursecredits[i] = coursecredits[i+1];
				coursegrades[i] = coursegrades[i+1];
			}
			//Removing a course
			nbcourses -= 1;
		}
		break;
		//Adding a course
		case 4:
		{
			nbcourses += 1;
			//Checking if adding a course would pass the maximum limit of courses and displaying an error message
			if (nbcourses > MAXCOURSES)
			{
				nbcourses -= 1;
				System.out.println("ERROR: this system can only support 10 courses.");
				break;
			}
			//Deleting a course and reinitializing the elements of the arrays
			System.out.print("Please enter the name of course number " + nbcourses + ": ");
			coursenames[nbcourses-1] = kb.next();
			System.out.print("Please enter the number of credits of course number " + nbcourses + ": ");
			coursecredits[nbcourses-1] = kb.nextDouble();
			System.out.print("Please enter the letter grade of course number " + nbcourses + ": ");
			lettergrades[nbcourses-1] = kb.next();
		}
		break;
		case 5:
			//Exiting program and displaying closing message
			System.out.println("All done! Goodluck! ");
		}
				
		}
		while (option!=5);
		
		//Closing scanner
		kb.close();
	}

}
