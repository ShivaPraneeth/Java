public class Pizza {
	private String size;
	private int cheeseTopping;
	private int pepperoniTopping;
	private int mushroomTopping;
	
	
	// Constructors
	//-------------
	public Pizza()
	{
		size = "";
	}
	
	public Pizza( String sz, int cheese, int pepperoni, int mushroom)
	{
		size = sz.toUpperCase();
		cheeseTopping = cheese;
		pepperoniTopping = pepperoni;
		mushroomTopping = mushroom;		
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
	
	// Other methods
	public int calcCost()
	{
		int cost = 0;
		if(size.equals("SMALL"))
			cost = 10;
		else if (size.equals("MEDIUM"))
			cost = 12;
		else if (size.equals("LARGE"))
			cost = 14;
		return cost + (cheeseTopping + pepperoniTopping + mushroomTopping) * 2;	
	}
	
	public boolean equals(Pizza pizza2)
	{
		return size.equals(pizza2.size) && cheeseTopping == pizza2.cheeseTopping
		&& pepperoniTopping == pizza2.pepperoniTopping 
		&& mushroomTopping == pizza2.mushroomTopping;
	}
	
	public String toString()
	{
		return "A " + size + " pizza with "+ cheeseTopping + " cheese topping(s), " +
		       pepperoniTopping + " pepperoni topping(s) and " + mushroomTopping +
		       " mushroom topping(s) cost $" + calcCost();
	}

}
