
// ----------------------------------------------------- 
// Assignment 1
// QUESTION One: Printing Patterns
// Written by: (Shiva Praneeth Pabhathi, Sruthi Podupati and 2091461, 1995568) 
/*
	PURPOSE:
	The below Java program prints one among the subsequent patterns supported the user choice of a pattern number,
	which must be between 1 and 4, or 5 to quit
	and an input value, which must be larger than 0 and smaller than 10, and consistent with the following:
	1.If the user enters any invalid pattern number, then the program displays a message indicating that input was invalid
	and request the user to either enter an accurate pattern number or 5 to quit the whole program.
	That is, an entry of 5 would simply terminate the program.
	2.Once the pattern number is correctly supplied, the program requests the user to enter the input value.
	If the user enters any invalid value that's not within the expected range(1-9), then the program should reject this entry
	and asks the user to re-enter another value; this is able to repeat indefinitely until a good value is entered.
	3.Upon the entry of a good input value, the program must check whether this value is odd or maybe .
	If the user enters an odd number, then the program would draw a pattern with odd number of rows.
	If the user enters an even number, then the program would draw a pattern with even number of rows
	DESIGNING THE CODE:
 * The code consists of object created through the class name through which the methods are called 
	when user selects the pattern by entering the choice
	Initially we created methods for each pattern and called those methods by using switch
 *  We created printPattern method for user understanding which consists of print statements  .
 *  executePattern method which consists of switch case which is the main part of code where everything is evaluated from user choice
	    i.e for the printing the pattern user wants, 5 for terminating the program 
 * In each case we are  calling different methods in and in default case which allows the user to re-enter the value
	      if he choices other than 1 to 5 which creates a looping in the program which is done by calling the same method 
	      in the default method.
 *  Once user selects the pattern he want he is asked for how many rows he wants to print which must be more than 0 and 
	    less done 10 . It is achieved by using if condition. 
 *  If the user fails to enter the number of rows accordingly he is alerted by showing 
	 " Woops!rows number is a illegal choice. Try again" which allows the user to re enter the number of rows 
	   it continues until the user enter the proper number of rows.
 *  After entering number of rows the number of rows is checked whether its even or odd and prints the pattern
	    accordingly(mainly for 4th pattern) its done by using if condition. 
 */
// -----------------------------------------------------
package assignmenta1;
import java.util.Scanner;
public class PrintingPatterns {
	// to read input from user
	Scanner sc =new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Shiva Praneeth and Sruthi Triangle/Diamond Printer");
		// object creation to access the methods
		PrintingPatterns p = new PrintingPatterns();
		// calling the methods using object p
		p.printPattern();
		p.executePattern();

	}

	void patternOne()
	{
		//console statement
		System.out.println("How many rows do you want to print?(More than one please)");
		int rows =sc.nextInt();
		//checks whether the rows is in between 1-9
		if(rows>0 && rows<10)
		{
			//initializes i to 1 and increased by 1 until the i is greater than rows
			for(int i=1;i<=rows;i++)
			{
				//initializes j with rows and decreased by 1 until the j is greater than rows
				for(int j=rows;j>=i;j--)
				{
					//prints the number for the pattern
					System.out.print(j);
				}
				//print to next line after creating a row and creates the pattern
				System.out.println(" ");
			}
		}
		else
		{
			//prints the rows used to in between 1-9
			System.out.println("Enter a valid number which lies between 1 to 10");
			//this allows the user to re-enter the number of rows until he satisfy's the condition
			patternOne();
		}
		//for asking the user if he want to print one more pattern
		printPattern();
		//for printing the pattern accordingly to the user choice
		executePattern();

	}

	void patternTwo()
	{
		System.out.println("How many rows do you want to print?(More than one please)");
		int rows =sc.nextInt();
		//checks whether the rows is in between 1-9
		if(rows>0 && rows<10)
		{
			for(int i=1;i<=rows;i++)
			{
				for(int j=rows;j>=i;j--)
				{
					//for printing empty spaces 
					System.out.print(" ");
				}
				for(int k=1;k<=i;k++)
				{
					//prints the number
					System.out.print(k);
				}
				//prints in the next-line after one complete row 
				System.out.println(" ");
			}
		}
		else
		{
			//Displays a message stating number is invalid 
			System.out.println("Enter a valid number which lies between 1 to 10");
			//for re-allowing the user to enter the number of rows
			patternTwo();
		}
		//for asking the user if he want to print one more pattern
		printPattern();
		//for printing the pattern accordingly to the user choice
		executePattern();

	}
	void patternThree()
	{
		System.out.println("How many rows do you want to print?(More than one please)");
		int rows=sc.nextInt();
		//checks whether the rows is in between 1-9
		if(rows>0 && rows<10)
		{ 

			for (int i = 1; i <= rows; i++) 
			{
				for (int j = 1; j < i; j++) 
				{
					System.out.print(" ");
				}

				for (int k = i; k <= rows; k++) 
				{ 
					System.out.print(k); 
				} 

				System.out.println(); 
			} 
		}
		else
		{
			System.out.println("Enter a valid number which lies between 1 to 10");
			//re-allows the user to re-enter the number of rows
			patternThree();
		}
		//for asking the user if he want to print one more pattern
		printPattern();
		//for printing the pattern accordingly to the user choice
		executePattern();
	}
	void patternFour()
	{
		System.out.println("How many rows do you want to print?(More than one please)");//prompts the user regarding the number of rows
		int rows=sc.nextInt();
		//checks whether the rows is in between 1-9
		if(rows>0 && rows<10)
		{
			//checks whether the number of rows is odd
			if(rows%2==1)                
			{
				for (int i = 1; i <= rows; i++) {

					for (int j = 1; j <= rows - i; j++)
						System.out.print(" ");
					//if i is not a multiple of 2 then k is printed in that particular place
					if(i%2==1)
						for (int k = 1; k <= i; k++)
							System.out.print(k + " ");

					System.out.println();

				}
				int m=rows-1;
				for (int i = 1; i <= m; i++)
				{

					for (int j = 1; j <= i; j++)
						System.out.print(" ");
					//if i is a multiple of 2 then k is printed in that particular place
					if(i%2==0)
						for (int k = 1; k <= rows-i ; k++)
							System.out.print(k + " ");

					System.out.println();

				}
			}
			else
			{
				for (int i = 1; i <= rows; i++) {
					for (int j = 1; j <= rows - i; j++) {
						System.out.print(" ");
					}
					if(i%2==1)
					{
						for (int k = 1; k <= i; k++) {
							System.out.print(k +" ");
						}
					}
					System.out.println();

				}
				for (int i = 1; i <= rows; i++)
				{
					for (int j = 1; j <= i; j++)
					{
						System.out.print(" ");
					}
					if(i%2==1) {
						for (int k = 1; k <= rows-i ; k++) {
							System.out.print(k +  " ");
						}
					}
					System.out.println();

				}


			}
		}


		else
		{
			System.out.println("Enter a valid number which lies between 1 to 10");
			// allows the user to re-enter the number of rows
			patternFour();
		}
		//for asking the user if he want to print one more pattern
		printPattern();
		//for printing the pattern accordingly to the user choice
		executePattern();
	}
	//Methods which shows 4 patterns and allows the user to select 
	void printPattern()
	{

		//prompts for pattern
		System.out.println("Which pattern do you want to print?");
		System.out.println("1) 54321 " +           " 2)   1 " +               " 3) 12345" +          "   4)  1 " + 
				" \n   5432 " +             "      12 " +            "     2345" +          "     1 2 3 " + 
				"\n   543 " +                 "      123 " +             "      345" +          "   1 2 3 4 5 " +  
				"\n   54 " +               "      1234 " +               "       45" +          "     1 2 3 " + 
				" \n   5"  +                "       12345 " +            "        5"  +          "       1 ");
		//prompts for quitting the program
		System.out.println("Enter your choice( 5 to Quit):"); 
	}

	//its the main part of code


	void executePattern()
	{
		//n is the choice of the user i.e to print which pattern.
		int n=sc.nextInt();
		// switch evaluates according upon the user choice
		switch(n)
		{
		case 1: 
			// calling Pattern1 method
			patternOne();
			break;

		case 2:
			//calling Pattern2 method
			patternTwo();
			break;
		case 3:
			//calling Pattern3 method
			patternThree();
			break;
		case 4:
			//calling Pattern4 method
			patternFour();
			break;
		case 5:
			//console statement
			System.out.println("Hope you enjoyed triangles and diamond patterns");
			//To Terminate the program
			System.exit(0);
			break;
		default:
			//print user entry is an invalid and asks him to re-enter the choice
			System.out.println("Woops!"+ n +" "+"is a illegal choice. Try again");
			//5 for termination of program
			System.out.println("enter 5 for exiting the program");
			//executePattern method is used for continuity  i.e this situation continues until the user enters a proper choice
			executePattern();
			break;

		}
		//closing the scanner class and sc is the object.
		sc.close();
	}
}







