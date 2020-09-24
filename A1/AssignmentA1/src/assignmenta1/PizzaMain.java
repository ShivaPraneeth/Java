// ----------------------------------------------------- 
//Assignment 1
// QUESTION Three: Classes(Pizza) 
// Written by: (Shiva Praneeth Pabhathi, Sruthi Podupati and 2091461, 1995568) 
/*
 * PURPOSE:
 The program below is regarding Creating 3 different pizzas:
 First one with the default constructor, and for the 2nd and third one prompt the user. 
 It Compares the 3 pizzas and display a message saying whether they are identical in content or not. 
 if they are not identical,Change the first pizza’s content to be the same as one of the other ones. 
 Compare the 3 pizzas again and display a message saying whether they are identical in content or not as well as their contents
 *DESIGNING THE CODE:
 we created pizza 1 with default constructor and the other two with parameterized constructor
 and then we initialized the parameterized constructors
 we wrote the methods for printing pizzas and comparing pizzas 
 we used the equals method for comparing the pizzas 
 */
package assignmenta1;
import java.util.Scanner;
public class PizzaMain {

	public static void main(String[] args) {
		// to read user input
		Scanner sc = new Scanner(System.in);
		//Declaring variables
		String sz;
		int cheese, pepperoni, mushroom;

		//Creating pz1 object with default constructor
		Pizza pz1 = new Pizza();

		//Creating pz2,pz3 object with parameterized constructor
		Pizza pz2, pz3;

		System.out.println("Welcome to the Pizza Store!!!");

		// prompts the user to place the order 
		System.out.print("Please place order for 1st pizza in the following order.\n" + "Size: SMALL, LARGE, MEDIUM:");
		sz = sc.nextLine();
		System.out.println("Indicate the number of each of the following toppings.\n"  +"Cheese, Pepperoni and Mushroom");
		cheese = sc.nextInt();
		pepperoni = sc.nextInt();
		mushroom = sc.nextInt();
		System.out.print("Please place order for 2nd pizza in the following order. \n"+"Size: SMALL, LARGE, MEDIUM:");
		// Initializing Second pizza object
		pz2 = new Pizza(sz, cheese, pepperoni, mushroom);
		sz = sc.next();
		System.out.println("Indicate the number of each of the following toppings.");
		System.out.println("Cheese, Pepperoni and Mushroom");
		cheese = sc.nextInt();
		pepperoni = sc.nextInt();
		mushroom = sc.nextInt();

		// Initializing Third pizza object
		pz3 = new Pizza(sz, cheese, pepperoni, mushroom);

		// calling the method for Printing pizzas
		displayPizzas(pz1,pz2,pz3);

		// Calling the method for comparing pizzas
		comparingPizzas(pz1,pz2,pz3);

		// Changing first pizza's content
		pz1 = new Pizza(sz, cheese, pepperoni, mushroom);

		// Printing out the information of all three pizzas after modifying
		System.out.println("\nHere is the three pizzas after modifying\n");

		// calling the method for comparing pizzas
		comparingPizzas(pz1,pz2,pz3);

		// calling the method for printing the pizzas
		displayPizzas(pz1,pz2,pz3);

		System.out.println("Enjoy the pizzas and have a great day !!!");

		sc.close();
	}

	// method for printing out the information of all three pizzas
	static void displayPizzas(Pizza pz1, Pizza pz2, Pizza pz3) {
		System.out.println("Here are the three pizzas");
		System.out.println("A pizza with "+pz1.getCheeseTopping()+" cheese topping(s) , "+pz1.getPepperoniTopping()+" pepporoni topping(s), "+pz1.getMushroomTopping()+" mushroom topping(s) cost $"+pz1.calcCost());
		System.out.println("A pizza with "+pz2.getCheeseTopping()+" cheese topping(s) , "+pz2.getPepperoniTopping()+" pepporoni topping(s), "+pz2.getMushroomTopping()+" mushroom topping(s) cost $"+pz2.calcCost());
		System.out.println("A pizza with "+pz3.getCheeseTopping()+" cheese topping(s) , "+pz3.getPepperoniTopping()+" pepporoni topping(s), "+pz3.getMushroomTopping()+" mushroom topping(s) cost $"+pz3.calcCost());
	}

	// method for comparing all three pizzas
	static void comparingPizzas(Pizza pz1, Pizza pz2, Pizza pz3) {
		System.out.println("Result of comparison");
		// checks whether the first pizza is same as the second pizza by using equals method
		if(pz1.equals(pz2))
			System.out.println("Pizza 1st and 2nd are same");
		else if(pz1.equals(pz3))
			System.out.println("Pizza 1st and 3rd are same");
		else if(pz2.equals(pz3))
			System.out.println("Pizza 2nd and 3rd are same");
		else
			System.out.print("No pizza are same");
	}



}


