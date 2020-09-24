// ----------------------------------------------------- 
/*Assignment 3
 QUESTION ONE: RANDOM NUMBER GENERATOR 
 Written by: (Shiva Praneeth Pabhathi, Sruthi Podupati and 2091461, 1995568) 
 This program is about rolling two dices for n number of times for generating the probabilities of outcomes through math.random 
 and util.random
 Designing the code:
 we created methods possibleFrequency for should occur probabilities,
 utilFrequency for generating the probabilities randomly through util.random,
 MathFrequency  for generating the probabilities randomly through math.random,
 outcome for printing the randomly generated outcomes and we called them in the main method.
 */
package A3;
import java.util.Random;
import java.util.Scanner;

public class RandomNumberGeneratorDie {
	// declaring the variables
	int PossibleSum[][];
	static int no_of_sides;
	int PossibleFrequency[];
	int utilFrequency[];
	int mathFrequency[];
	static int roll;
	public RandomNumberGeneratorDie(int no_of_sides){
		PossibleSum = new int[no_of_sides+1][no_of_sides+1];
		PossibleFrequency = new int[no_of_sides+no_of_sides+1];
		utilFrequency = new int[no_of_sides+no_of_sides+1];
		mathFrequency = new int[no_of_sides+no_of_sides+1];
	}
  //possibleFrequency for should occur probabilities,
	public void PossibleFrequency(){
		for (int i = 1; i <PossibleSum.length ; i++) {
			for (int j = 1; j <PossibleSum[0].length ; j++) {
				PossibleSum[i][j] = i + j;
				PossibleFrequency[PossibleSum[i][j]]++;
			}
		}
	}
	//utilFrequency for generating the probabilities randomly through util.random
	public void utilFrequency(int roll){
		Random rand = new Random();
		for (int i = 1; i <=roll ; i++) {
			int die1 = rand.nextInt(no_of_sides) + 1;
			int die2 = rand.nextInt(no_of_sides) + 1;
			int sum = die1 + die2;
			utilFrequency[sum]++;
		}
	}
	//MathFrequency  for generating the probabilities randomly through math.random
	public void mathFrequency(int roll){
		for (int i = 1; i <=roll ; i++) {
			int die1 = (int)(Math.random() * (no_of_sides) + 1);
			int die2 = (int)(Math.random() * (no_of_sides) + 1);
			int sum = die1 + die2;
			mathFrequency[sum]++;
		}
	}
	//outcome for printing the randomly generated outcomes and we called them in the main method
	public void Outcome(int roll){
		System.out.printf(" ---------------------------------------------------------------------------------------\n");
		System.out.printf("|\tSum\t|\tShould Occur\t|\t %% Occured\t|\t %% Occured\t|\n");
		System.out.printf("|\t%3s\t|\t%12s\t|\t(util.Random)\t|\t(Math.random)\t|\n", "   ", "            ");
		System.out.printf(" ---------------------------------------------------------------------------------------\n");
		for(int i=2;i<=(no_of_sides+no_of_sides);i++){
			double PossiblePercentage = (100 * ((double)PossibleFrequency[i])/((double)(no_of_sides*no_of_sides)));
			String shouldOccur = "( " + PossibleFrequency[i]+") " + String.format("%.2f",PossiblePercentage) + "%";

			double utilPercentage = ((100 * ((double)utilFrequency[i]))/((double)(roll)));
			String shouldOccurUtil = "( " + utilFrequency[i]+") " + String.format("%.2f",utilPercentage) + "%";

			double mathPercentage = ((100 *((double)mathFrequency[i]))/((double)(roll)));
			String shouldOccurMath = "( " + mathFrequency[i]+") " + String.format("%.2f",mathPercentage) + "%";
			System.out.printf("|\t%3d\t|%20s\t|%20s\t|%20s\t|\n",i,shouldOccur,shouldOccurUtil,shouldOccurMath );
			System.out.printf(" ---------------------------------------------------------------------------------------\n");
		}
	}
	public static void main(String[] args) {
		System.out.println("%-0-1-2-3-4-5-6-7-8-9-0-1-2-3-4-5-6-7-8-9-0-%");
		System.out.println("%                                           %");
		System.out.println("%  How good is the Random Number generator  %");
		System.out.println("%                                           %");
		System.out.println("%-0-1-2-3-4-5-6-7-8-9-0-1-2-3-4-5-6-7-8-9-0-%");	
		Scanner sc=new Scanner(System.in);
		// reading the no of sides from the user
		System.out.println("What is the number of sides of each die ?");
		no_of_sides=sc.nextInt();
		// checking whether the number of sides not equal to zero
		if(no_of_sides==0)
		{
			System.out.println("Please Enter a valid number of sides:");
			no_of_sides=sc.nextInt();
		}
		// System.out.println("How many times do you want to roll dice? ");
		// roll=sc.nextInt();

		char ch;
		do{
           // creating the object for the class
			RandomNumberGeneratorDie r=new RandomNumberGeneratorDie(no_of_sides);
			r.PossibleFrequency();
			System.out.println("How many times do you want to roll dice? ");
			roll=sc.nextInt();
			// calling the methods through object
			r.utilFrequency(roll);
			r.mathFrequency(roll);
			r.Outcome(roll);
			System.out.println("Do you want to repeat with a different number of rolls? (any character to quit other than y) ");
			ch = sc.next().charAt(0);
		}while(ch == 'y' || ch == 'Y');
		System.out.println("Thank you for using the Random Generator Tester Application.");

		sc.close();

	}

}
