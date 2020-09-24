package A3;

public class Complex {
	private int i; // Real Part
	private int j; // Imaginary Part
	

	//Constructor with 2 parameters
	public Complex(int x1,int y1)
	{
		this.i=x1;
		this.j=y1;
	}
	//Accessor method for Real number
	public int getRealNumber()
	{
		return i;
	}
	//Accessor method for Imaginary number
	public int getImaginaryNumber()
	{
		return j;
	}
	//Mutator method for Real Part
	public void setRealNumber(int x1)
	{
		i =x1;
	}

	//Mutator method for Imaginary Part
	public void setImaginaryNumber(int y1)
	{
		j=y1;
	}
	
	 

	//calledmoveBy for adding an integer value
	public void calledmoveBy(int a,int b)
	{
		i=i+a;
		j=j+b;
		//System.out.println(i+"i"+"+"+j+"j");
	}
	
	//Return method
	public Complex reverse(Complex eq)
	{
		return new Complex(this.j, this.i);
		
	}
	 public String toString() {
	        if (j == 0) return i +"";
	        if (i == 0) return j + "j";
	        if (j < 0) return i + " - " + (-j) + "j";
	        return i+" + " + j + "j";
	    }
	// Return method which return true if two complex number have the same coordinates   
	public boolean isEqual(Complex eq1,Complex eq2)
	{
		if (eq1.i==eq2.i && eq1.j==eq2.j)
			return true;
		else
			return false;
	}

}
