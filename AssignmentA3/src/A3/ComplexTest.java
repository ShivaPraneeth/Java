package A3;
//----------------------------------------------------- 
/*Assignment 3
QUESTION TWO:COMPLEX NUMBERS
Written by: (Shiva Praneeth Pabhathi, Sruthi Podupati and 2091461, 1995568) 
DESIGNING THE CODE:
This program explains about complex numbers 
User will enter the real and imaginary values of two equations and reversing the equation adding an integer value to the equation
isequal method to check whether the equations are same.
calledmoveBy for adding an integer value
reverse method for returning a new complex number with the coordinates reversed.
*/
import java.util.Scanner;

public class ComplexTest  {
	public static void main(String[] args) {
		{
			// to  read input from user
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the real and imaginary values of First Equation:");
			Complex eq1=new Complex(sc.nextInt(),sc.nextInt());
			System.out.println("Enter the real and imaginary values of Second Equation:");
			Complex eq2=new Complex(sc.nextInt(),sc.nextInt());
			// for printing the equations
			System.out.println("The Equation1 is:");
			System.out.println(eq1);
			System.out.println("The Equation2 is:");
			System.out.println(eq2);
			System.out.println("Equation2 (after reversed) : ");
			// calling reverse method
			eq2=eq2.reverse(eq2);
			System.out.println(eq2);
			eq1=eq2.reverse(eq2);
			System.out.println("Equation1 is changed to: " +eq1);
			// accepting an integer value from the user
			System.out.println("Enter the value of a which will be added to two equations: ");
			int a=sc.nextInt();
			System.out.println("Enter the value of b which will be added to two equations: ");
			int b=sc.nextInt();
			// calling the method for adding the integer
			eq1.calledmoveBy(a, b);
			System.out.println("The equation after adding the value to equation 1: "+eq1);
			eq2.calledmoveBy(a, b);
			System.out.println("The equation after adding the value to equation 2: "+eq2);
			// checking the equations whether they are equal by calling the isequal method.
			if (eq1.isEqual(eq1,eq2))
			{
	            System.out.println("Equations are Same");
			}
	        else
	        {
	            System.out.println("Equations are Different");
	        }
			
	 sc.close();
			
		}

	}

}
