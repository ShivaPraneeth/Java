// FinalProject
// Written by: (Shiva Praneeth(2091461) and Sruthi Podupati(1995568))
/*
 Description:It help in keeping track of the number and types of pizzas she has cooked
  on a given day and to produce statistics regarding the choices her customers made.
  Extra Features:
  In this project we can also place the order for combo (coke, fries and nuggets) and 
  calculating the cost of it. 
  we can order the water bottles and display the number of water bottles ordered.
  we included the statistics regarding the combos.
 */
package Final_Project;

import java.util.Scanner;
public class DeluxePizza{
	private String size;
	private int cheeseTopping;
	private int pepperoniTopping;
	private int mushroomTopping;
	private boolean stuffedWithCheese;
	private int veggieTopping;
	static int numberOfPizzas = 0;
	
	static String cat;
	Scanner sc=new Scanner(System.in);
	// Constructors
	//-------------
	public DeluxePizza()
	{ 
		// Initializations
		size = "";
		cheeseTopping = 0;
		pepperoniTopping = 0;
		mushroomTopping = 0;
		stuffedWithCheese = false;
		veggieTopping = 0;
		numberOfPizzas =numberOfPizzas +1;
	}
// parameterised constructor
	public DeluxePizza( String sz, int cheese, int pepperoni, int mushroom, boolean stuffed, int veggie)
	{
		size = sz.toUpperCase();
		cheeseTopping = cheese;
		pepperoniTopping = pepperoni;
		mushroomTopping = mushroom;		
		stuffedWithCheese = stuffed;
		veggieTopping = veggie;
		numberOfPizzas =numberOfPizzas +1;
	}
	
	//copy constructor
	public DeluxePizza(DeluxePizza p)
	{
		this.size=p.size;
		this.cheeseTopping = p.cheeseTopping;
		this.pepperoniTopping = p.pepperoniTopping;
		this.mushroomTopping = p.mushroomTopping;		
		this.stuffedWithCheese = p.stuffedWithCheese;
		this.veggieTopping = p.veggieTopping;
		numberOfPizzas =numberOfPizzas +1;
	}

	// Accessor methods
	//-----------------
	public String getSize()
	{ return size;
	}

	public int getCheeseTopping()
	{
		return cheeseTopping;
	}

	public int getPepperoniTopping()
	{
		return pepperoniTopping;
	}

	public int getMushroomTopping()
	{
		return mushroomTopping;
	}
	
	public boolean getStuffedWithCheese()
	{
		return stuffedWithCheese;
	}
	
	public int getVeggieTopping()
	{
		return veggieTopping;
	}
	
	public int getNumberOfPizzas()
	{
		return numberOfPizzas;
	}
	//Mutator methods
	//---------------
	public void setSize(String sz)
	{
		size = sz.toUpperCase();
	}

	public void setCheeseTopping(int cheese)
	{
		cheeseTopping = cheese;
	}

	public void setPepperoniTopping(int pepperoni)
	{
		pepperoniTopping = pepperoni;
	}

	public void setMushroomTopping(int mushroom)
	{
		mushroomTopping = mushroom;
	}
	
	public void setStuffedWithCheese(boolean stuffed)
	{
		stuffedWithCheese = stuffed;
	}

	public void setVeggieTopping(int veggie)
	{
		veggieTopping = veggie;
	}
	
		
   ///calcCost() method to add $2, $4 or $6 dollars for cheese stuffed dough depending
	//on the size of the pizza as well as an extra $3 per vegetable toppings
	public double calcCost()
	{
		double cost = 0;
		if(size.equals("SMALL") && stuffedWithCheese)
			cost = 12;
		else if (size.equals("MEDIUM") && stuffedWithCheese)
			cost = 16;
		else if (size.equals("LARGE") && stuffedWithCheese)
			cost = 20;
		else if(size.equals("SMALL"))
			cost = 10;
		else if (size.equals("MEDIUM"))
			cost = 12;
		else if (size.equals("LARGE"))
			cost = 14;
		return cost +( (cheeseTopping + pepperoniTopping + mushroomTopping) * 2) +( veggieTopping*3);	
	}
// equals() method so that 2 pizzas are considered equal if they have the same non- static attributes.
	public boolean equals(DeluxePizza pizza2)
	{
		return size.equals(pizza2.size) && cheeseTopping == pizza2.cheeseTopping
				&& pepperoniTopping == pizza2.pepperoniTopping 
				&& mushroomTopping == pizza2.mushroomTopping && veggieTopping==pizza2.veggieTopping
				&& stuffedWithCheese == pizza2.stuffedWithCheese;
	}
   //Modify the toString() method so that when an object of type DeluxePizza is printed all of the attributes
	public String toString(int number)
	{
		return "Pizza "+number+"\n\tPizza size: "+ size +"\n\tCheese filled dough: "+stuffedWithCheese+"\n\tNumber of cheese toppings:"+ cheeseTopping
				+"\n\tNumber of pepperoni toppings: "+pepperoniTopping + "\n\tNumber of mushroom toppings:  " + mushroomTopping +
				"\n\tNumber of vegetable toppings:"+ veggieTopping + "\n\tPrice: $" + calcCost();
	}
	
	
	
	}
// usage of Inheritance
class Combo extends DeluxePizza
{
	String size;
	int nuggets;
	String coke;
	static int numberOfcombos = 0; 

	public Combo()
	{
		size="";
		numberOfcombos=numberOfcombos+1;
		nuggets= 0;
		coke="";
	}
	
	public Combo(String sz, int n, String c) {
		size=sz.toUpperCase();
		nuggets=n;
		coke=c.toUpperCase();
		numberOfcombos=numberOfcombos+1;
	}
	//accessor and mutator methods
	public String getSize()
	{
		return size;
	}
	public void setSize(String sz)
	{
		size = sz.toUpperCase();
	}
	public String getCoke()
	{
		return coke;
	}
	public void setCoke(String c)
	{
		size = c.toUpperCase();
	}
	public int getnuggets()
	{
		return nuggets;
	}
	public void setNuggets(int n)
	{
		nuggets=n;
	}
	
	public double Cost()
	{
		double cost=0;
		if(size.equalsIgnoreCase("SMALL") && coke.equalsIgnoreCase("SMALL") )
			cost = 2;
		else if (size.equalsIgnoreCase("MEDIUM") && coke.equalsIgnoreCase("SMALL") )
			cost = 3;
		else if (size.equalsIgnoreCase("LARGE")&& coke.equalsIgnoreCase("SMALL"))
			cost = 4;	
		else if (size.equalsIgnoreCase("SMALL") &&coke.equalsIgnoreCase("MEDIUM"))
			cost = 3;
		else if (size.equalsIgnoreCase("SMALL") &&coke.equalsIgnoreCase("LARGE"))
			cost = 4;
		else if (size.equalsIgnoreCase("MEDIUM")&&coke.equalsIgnoreCase("MEDIUM"))
			cost=4;
		else if (size.equalsIgnoreCase("MEDIUM")&&coke.equalsIgnoreCase("LARGE"))
          cost=5;
		else if (size.equalsIgnoreCase("LARGE")&& coke.equalsIgnoreCase("Medium"))
		{
			cost=5;
		}
		else if(size.equalsIgnoreCase("LARGE")&& coke.equalsIgnoreCase("LARGE"))
		{
		cost=6;
		}
		double cs=cost +(nuggets* 2);
		return cs;
	}
	
}