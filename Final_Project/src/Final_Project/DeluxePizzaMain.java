
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

public class DeluxePizzaMain {
	//declaring variables
	static final String PASSWORD = "deluxepizza";
	public static int no_of_pizzas;
	public static int no_of_combo;
	static String size;
	static int[] softDrinks = new int[1000];
	static int cheese ;
	static int pepperoni;
	static int mushroom;
	static int veggie;
	static String s;

	static String sm;
	static String coke;
	static int nuggets;
	static int bottles;
	//static int nugget_no;
	static int incorrect;
	static int combo_no;
	static boolean stuffed;
	public static DeluxePizza[] todaysPizzas;
	public static Combo[] todayscombo;
	static int no_of_bottles;
	public static void main(String[] args) {
		// to read user input
		Scanner sc = new Scanner(System.in);
		//Declaring variables
		int choice;
		System.out.println("=========================================================================");
		System.out.println("Mama Nancia, Welcome to the Pizzeria!!!");
		System.out.println("=========================================================================");
		System.out.println("Mama Nancia, How many pizza's would you like to prepare today?");
		no_of_pizzas=sc.nextInt();
		todaysPizzas = new DeluxePizza[no_of_pizzas];
		do{
			System.out.println("Mama Nancia, what do you want to do?\n"
					+ "1.	Enter a new pizza order (password required)\n"
					+ "2.	Change information of a specific order (password required)\n"
					+ "3.	Display details for all pizzas of a specific size (s/m/l)\n"
					+ "4.	Statistics on today’s pizzas and Combo\n"
					+ "5.      Do you want to place any combo(password required)\n"
					+ "6.      Do you want to add water bottles?\n"
					+ "7.	Quit\n"
					+ "Please enter your choice >");
			choice=sc.nextInt();
			//switch statement for execution of choices made
			switch(choice){
			case 1:
				int incorrect=0;
				do{
					System.out.println("Password please:");
					String password=sc.next();
					if(password.equals(PASSWORD)){

						System.out.println("How many pizza's would you like to enter?");
						int pizza_no=sc.nextInt();
						int array_index =0;
						for(int i=0; i<no_of_pizzas;i++){
							if(todaysPizzas[i]==null){
								array_index=i;
								break;
							}
						}
						if(pizza_no<=(no_of_pizzas-array_index)){

							for(int i=0; i<pizza_no; i++){
								System.out.println("Enter the size of Pizza(small/medium/large):");
								size=sc.next();
								System.out.println("Cheese in dough(true/false):");
								s= sc.next();
								stuffed=Boolean.parseBoolean(s);
								System.out.println("Enter the number of cheese topping, pepperoni topping,  mushroom topping, veggie topping : ");
								cheese=sc.nextInt();
								pepperoni=sc.nextInt();
								mushroom= sc.nextInt();
								veggie= sc.nextInt();
								todaysPizzas[array_index]=new DeluxePizza( size, cheese,pepperoni ,mushroom ,stuffed ,veggie );
								array_index++;
							}
							choice =0;
							break;

						}
						else{
							System.out.println("You only has enough ingredients to make "+ (no_of_pizzas-array_index) +" Pizzas.");
						}

					}else{
						incorrect=incorrect+1;
						//System.out.println("Incorrect Password");
						if(incorrect==3)
						{
							System.out.println("Sorry - you are not authorised to perform this action!");
						}
					}
				}while(incorrect!=3);	
				choice =0;
				break;
			case 2:
				incorrect=0;
				int select=0;
				do{
					System.out.println("Enter the password:");
					String password=sc.next();
					if(password.equals(PASSWORD)){
						incorrect=0;
						do{
							System.out.println("Enter the pizza number that you would like to update?");
							int array_index=sc.nextInt();
							if(array_index>no_of_pizzas ||todaysPizzas[array_index-1]==null){
								System.out.println("Mama Nancia, what do you want to do?\n"
										+ "1.	Enter another Pizza number\n"
										+ "2.	Quit\n"
										+ "3.	Go back to Main Menu\n"
										+ "Please enter your choice >");
								select=sc.nextInt();
							}
							else{
								String output= todaysPizzas[array_index-1].toString(array_index);
								System.out.println(output);
								int update_choice=0;
								do{
									System.out.println("Mama Nancia, what would you like to change?\n"
											+ "1.	Size\n"
											+ "2.	Cheese filled or not\n"
											+ "3.	Number of cheese toppings\n"
											+ "4.	Number of pepperoni toppings\n"
											+ "5.	Number of mushroom toppings\n"
											+ "6.	Number of vegetable toppings\n"
											+ "7.	Quit\n Enter choice >");
									update_choice= sc.nextInt();
									if(update_choice==1){
										System.out.println("Enter the size:(small,medium,large)");
										String size=sc.next();
										todaysPizzas[array_index-1].setSize(size);
									}
									else if(update_choice==2){
										System.out.println("Enter if the pizza should be filled or not?(y/n)");
										String s=sc.next();
										if(s.equalsIgnoreCase("y")){
											todaysPizzas[array_index-1].setStuffedWithCheese(true);
										}
										else{
											todaysPizzas[array_index-1].setStuffedWithCheese(false);
										}
									}
									else if(update_choice==3){
										System.out.println("Enter the number of cheese toppings:");
										int cheese=sc.nextInt();
										todaysPizzas[array_index-1].setCheeseTopping(cheese);
									}
									else if(update_choice==4){
										System.out.println("Enter the number of pepperoni toppings:");
										int pepperoni=sc.nextInt();
										todaysPizzas[array_index-1].setPepperoniTopping(pepperoni);
									}
									else if(update_choice==5){
										System.out.println("Enter the number of mushroom toppings:");
										int mushroom=sc.nextInt();
										todaysPizzas[array_index-1].setMushroomTopping(mushroom);
									}
									else if(update_choice==6){
										System.out.println("Enter the number of vegetable toppings:");
										int vegetable=sc.nextInt();
										todaysPizzas[array_index-1].setVeggieTopping(vegetable);
									}
									if(update_choice!=7 && update_choice>=1 && update_choice<=6){
										output= todaysPizzas[array_index-1].toString(array_index-1);
										System.out.println(output);
									}

								}while(update_choice!=7);
							}
						}while(select==1);
						if(select==3){choice=0;break;}
						if(select==2){break;}
					}else{
						incorrect=incorrect+1;
						System.out.println("Incorrect Password");
					}

				}while(incorrect!=3 && incorrect!=0);
				choice=0;
				break;
			case 3:
				System.out.println("Enter the size of the pizza(small, medium. large)");
				String sz=sc.next();
				pizzasOfSize(sz.toUpperCase());
				choice=0;
				break;


			case 4:
				int statistic_choice=0;
				do{
					System.out.println("Mama Nancia, what information would you like?\n"
							+ "1.	Cost and details of cheapest pizza\n"
							+ "2.	Cost and details of most costly pizza\n"
							+ "3.	Number of pizzas sold today\n"
							+ "4.	Number of pizzas of a specific size\n"
							+ "5.	Average cost of pizzas\n"
							+ "6.      Average  cost of combos\n"
							+ "7.      Details of combos\n"
							+ "8.      Number of water bottles ordered\n"
							+ "9.	Quit\n"
							+ "Enter our choice >");
					statistic_choice=sc.nextInt();
					if(statistic_choice==1){
						int min=lowestPrice();
						System.out.println(todaysPizzas[min].toString(min) +" is the cheapest pizza");
					}
					else if(statistic_choice==2){
						int max=highestPrice();
						System.out.println(todaysPizzas[max].toString(max) +" is the costly pizza");
					}
					else if(statistic_choice==3){
						System.out.println("Number of pizzas sold today:"+ todaysPizzas[0].getNumberOfPizzas());
					}
					else if(statistic_choice==4){
						System.out.println("Enter the size of the pizza(small, medium. large)");
						String sp_sz=sc.next();
						pizzasOfSize(sp_sz.toUpperCase());
					}
					else if(statistic_choice==5){
						int num=1;
						double price=0.0;
						for(int i=0;i<no_of_pizzas; i++){
							if(todaysPizzas[i]!=null){
								price=price+todaysPizzas[i].calcCost();
								num=num+1;
							}
						}
						System.out.println("Average: $"+price/(double)(num-1));
					}
					else if(statistic_choice==6){
						int num=1;
						double price=0.0;
						for(int i=0;i<no_of_combo; i++){
							if(todayscombo[i]!=null){
								price=price+todayscombo[i].Cost();
								num=num+1;
							}
						}
						System.out.println("Average: $"+price/(double)(num-1));
					}
					else if(statistic_choice==7){
						System.out.println("Combo Details");
						for(int i=0;i<no_of_combo; i++){
							if(todayscombo[i]!=null){
								int o=i+1;
								System.out.println("Order for "+o);
								System.out.println("size of fries: "+todayscombo[i].getSize());
								System.out.println("size of coke: "+todayscombo[i].getCoke());
								System.out.println("number of nuggets: "+todayscombo[i].getnuggets());
							}
						}

					}
					//price=price+todayscombo[combo_no].Cost();
					//System.out.println("Average: $"+price);	
					//	System.out.println("Average: $"+price/(double)(num-1));
					else if(statistic_choice==8){

						System.out.println("Number of water bottles ordered:"+bottles);
					}

				}while(statistic_choice!=9);
				choice=0;
				break;
			case 5:
				System.out.println("Mama Nancia,Enter the Maximum number combo's can be prepared by the ingredients we have?");
				no_of_combo=sc.nextInt();
				todayscombo = new Combo[no_of_combo];

				incorrect=0;

				do {
					System.out.println("Password Please:");
					String password= sc.next();
					if(password.equals(PASSWORD))
					{
						System.out.println("How many combos would you like to enter:");
						int combo_no=sc.nextInt();
						int index =0;
						for(int i=0; i<no_of_combo;i++){
							if(todayscombo[i]==null){
								index=i;
								break;
							}
						}
						if(combo_no<=(no_of_combo-index)){
							for(int i=0; i<combo_no; i++){
								System.out.println("Enter the size of fries(small/medium/large):");
								sm=sc.next();
								System.out.println("Enter the number of nuggets:");
								nuggets= sc.nextInt();
								System.out.println("Enter the size of Coke(small/medium/large):  ");
								coke=sc.next();

								todayscombo[index]=new Combo( sm, nuggets,coke );
								index++;

							}
							break;
						}



						else{
							System.out.println("You only has enough ingredients to make "+ (no_of_combo-index) +" Combo.");
						}
					}

					else
					{
						incorrect=incorrect+1;

					}

				}while(incorrect!=3);

				choice=0;
				break;

			case 6:
				System.out.println("enter the maximum number of bottles store contain:");
				incorrect=0;
				no_of_bottles = sc.nextInt();
				do {

					System.out.print("\nMama Nancia, Enter the number of water bottles you need?");
					bottles = sc.nextInt();
					if(bottles>no_of_bottles)
					{
						System.out.println("Sorry we don't have enough bottles");

					}
					else
					{
						System.out.println("Number of water bottles ordered: "+bottles);
					}
					incorrect=incorrect+1;

				}while(incorrect!=1);
				choice=0;

				/*for (int i = 0; i < no_of_bottles; i++) {
					softDrinks[i] = 1 + softDrinks[i];
					i++;
				}*/
				break;

			case 7:
				System.out.println("Enjoy the pizzas and have a great day !!!");
				return;
			default:
				choice=0;
			}

		}while(choice==0);


	}
	static void pizzasOfSize(String sz) {
		System.out.println("List of "+sz+" pizzas sold today");
		int count=0;
		for(int i=0; i<no_of_pizzas; i++){
			if(todaysPizzas[i]!=null){
				String size=todaysPizzas[i].getSize();
				if(size.equals(sz)){
					System.out.println(todaysPizzas[i].toString(i+1));
					count++;
				}	
			}
		}
		System.out.println("Our Chef, made "+count+" "+sz+" pizzas today!");
	}
	//static method in the driver called cheaperThan() which will list the number (index) and the price
	//of all pizzas less than the requested price.
	static double[] cheaperThan(double req_price) {
		int count=0;
		double price[];
		double cheaper_price[];
		for(int i=0; i<no_of_pizzas; i++){
			if(todaysPizzas[i]!=null){
				count++;
			}
		}
		price=new double[count];
		cheaper_price=new double[count];
		for(int i=0; i<count; i++){
			price[i]=todaysPizzas[i].calcCost();
		}
		for(int i=0; i<price.length; i++){
			if(price[i]<req_price){
				cheaper_price[i]=price[i];
			}
		}
		return cheaper_price;
	}
	//static method in the driver called lowestPrice() which will find and return the index of the pizza with the lowest price in the array.
	static int lowestPrice() {
		double price[];
		int count=0;
		double min;
		int index=0;
		for(int i=0; i<no_of_pizzas; i++){
			if(todaysPizzas[i]!=null){
				count++;
			}
		}
		price=new double[count];
		for(int i=0; i<count; i++){
			price[i]=todaysPizzas[i].calcCost();
		}
		min=price[0];
		for(int i=0; i<price.length; i++){
			if(min>price[i]){
				min=price[i];
				index=i;
			}
		}
		return index;
	}
	//static method in the driver called highestPrice() which will find and return the location
	//of the pizza with the highest price in the array.
	static int highestPrice() {
		double price[];
		double max;
		int index=0,count=0;
		for(int i=0; i<no_of_pizzas; i++){
			if(todaysPizzas[i]!=null){
				count++;
			}
		}
		price=new double[count];
		for(int i=0; i<count; i++){
			price[i]=todaysPizzas[i].calcCost();
		}
		max=price[0];
		for(int i=0; i<price.length; i++){
			if(max<price[i]){
				max=price[i];
				index=i;
			}
		}
		return index;
	}
	//separate static method in the driver called numberOPizzasOfSize() which will return the number of pizzas of the specified size.
	static int numberOPizzasOfSize(String sz) {
		int count=0;
		for(int i=0; i<no_of_pizzas; i++){
			if(todaysPizzas[i]!=null){
				String size=todaysPizzas[i].getSize();
				if(size.equals(sz)){
					System.out.println(todaysPizzas[i].toString(i+1));
					count++;
				}	
			}
		}
		return count;
	}


}