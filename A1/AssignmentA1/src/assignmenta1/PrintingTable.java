// ----------------------------------------------------- 
//Assignment 1
// QUESTION Two: Printing Multiplication Table 
// Written by: (Shiva Praneeth Pabhathi, Sruthi Podupati and 2091461, 1995568) 

/*
 PURPOSE:
 * This program displays multiplication table from 1 to n with diagonal * .
 DESIGNING THE CODE:
 * The code consists of n - the multiplication table which is entered by the user and for printing * at diagonals 
   we used a condition rows==columns i.e the position of diagonal 
 * To maintain uniform spaces we used System.out.format and we can also use System.out.printf for the same functionality.
 */
package assignmenta1;

import java.util.Scanner;

public class PrintingTable {

	public static void main(String[] args){
		System.out.println("Enter the number:");
		//used to get user input
		Scanner sc=new Scanner(System.in);
		//n is the number entered by user
		int n=sc.nextInt();
		System.out.printf("	    ");
		for(int rows = 1; rows<=n;rows++ ) {
			// to get equal spaces between the numbers or uniformity spaces between rows 
			System.out.format("%10d",rows);
		}
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		for(int rows = 1 ;rows<=n;rows++) {
			// print left most column first
			System.out.format("%10d |",rows);
			for(int columns=1;columns<=n;columns++) {
				//checks whether row equal to column and then prints the statements in it.
				if(rows==columns)
				{
					String s="*";
					//prints the * at diagonal places
					System.out.format("%10s",s);
				}
				else
				{
					//print the product of rows and column and maintains the equal spaces between the rows and columns.
					System.out.format("%10d",rows*columns);
				}

			}
			//to print the value in next-line after the completion of row.
			System.out.println();

		}
		//closing the scanner class
		sc.close();
		//To Terminate the program
		System.exit(0);

	}
}


