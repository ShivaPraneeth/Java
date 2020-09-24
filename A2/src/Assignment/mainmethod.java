package Assignment;

import java.util.Scanner;
import java.util.Random;

public class mainmethod {

	public static void main(String[] args) {
		

		int BoardingPpl=0;//variables for main functions
		int LeavingPpl=0;
		int WaitingPpl=0;
		int stations=3;
		char ch='Y';
		String direction;
		Scanner input=new Scanner(System.in);
		Random rand=new Random();
		int lane=1;
		
System.out.println("Welcome to Metro Manager - Enjoy your metro"
		+ " experience\r\n" + 
	    "----------------------------------------- ");
System.out.println("Enter number of metro stations (minimum 3):  ");
		stations=input.nextInt();//here we take input for stations in number
		while(stations<3) {
			System.out.println("Error! must be greater than 2");
		    stations=input.nextInt();
			}
System.out.println("----------------------------------------------");
		
       
                                                //directions of the train 
          int [] lastWaiting=new int[stations];//This array is used to store last waiting time
          for(int i=0;i<lastWaiting.length;i++) {
        	  lastWaiting[i]=0;
          }
		
		
		System.out.println("1.North "  //here the lane is selescted from the user      
				+ "2 South "+
				"3.East "
				+ "4.West "
				
				);
		 lane=input.nextInt();
		while(lane<=0&&lane>5) {
		 lane=input.nextInt();
		}
		
		Train obj=new Train();//here we create an object called train
		obj.determineDir(stations, lane);
		while(ch=='y'||ch=='Y') {
		for(int j=0;j<2;j++) {//It loops two times once for train travelling 
			//in both directions that is forward and backward
			obj.setPassTotal(0);//We declare passtotal as 0 before entering the loop
		for(int i=0;i<stations;i++) {
			LeavingPpl=rand.nextInt(BoardingPpl+1);
			BoardingPpl=rand.nextInt(251);
		if(i==0) {
		System.out.println("------------------------------------");
		System.out.println("All in");
		System.out.println("(New Passengers waiting "+BoardingPpl+ ")");
	    System.out.println("--------------------------------------");
	    System.out.println("Passengers Left from last time "+lastWaiting[i] );
		}
		
if(i>0)	{	
System.out.println("Do you want to continue following Metro train "
		+obj.getMetroId()+ "?\r\n" + 
"Type \"y\" or \"Y\" for yes, anything else for no: ");//here the user will be asked as if they want to continue or not
			 ch=input.next().charAt(0);
			if(ch!='y'&&ch!='Y') {
				j=2;
				break;
				
			}
}
			
			
			
		
			if(j==0) {
			 direction=obj.determineDir(stations, lane);//  here the train follows the random path if the train goes in the direction what we have selected
			 //It is basically taking the direction of train with respect to station
			}
			else {
				 direction=obj.revdir(lane);//It takes the directions from stored array.
			}
			
			BoardingPpl=BoardingPpl+lastWaiting[i];//here waiting pepole are added to the boarding pepole
			int passTotal=obj.calc(BoardingPpl, LeavingPpl, i);//totoal people are calculated
			while(passTotal<0) {//If passTotal turns out to be negative
				LeavingPpl=rand.nextInt(BoardingPpl+1);
				passTotal=obj.calc(BoardingPpl, LeavingPpl, i);
			}
			WaitingPpl=obj.getWaitingPpl(i);//getting waiting people for that station
			lastWaiting[stations-(i+1)]=WaitingPpl;//Storing the waiting value for future reference.
			BoardingPpl=BoardingPpl-obj.getWaitingPpl(i);
			
			
				if(i==stations-1) {//if this is the last station
					LeavingPpl=passTotal;
					BoardingPpl=0;
					passTotal=obj.calc(BoardingPpl, LeavingPpl, i);
					WaitingPpl=0;
					lastWaiting[stations-(i+1)]=WaitingPpl;
					
				}
				

			
			
			
	if(i>0 && i<stations-1) {
		System.out.println("-------------------------------");
		System.out.println("In the middle\r\n" + 
				"(Passengers Left from last time "+lastWaiting[i]+")\r\n"  
				);
		System.out.println("-------------------------------");
	}
	if(i==stations-1) {
		System.out.println("-------------------------------");
		System.out.println("Last\r\n" );
		System.out.println("All Out");
		System.out.println("-------------------------------");
	}
	
System.out.println("Metro "+obj.getMetroId()+ " leaving station "+(i+1)+" "+direction+" with "+obj.getPassTotal()+" Passengers");			
System.out.println("Passenger(s) got off:"+LeavingPpl);

System.out.println("Passenger(s) got on: "+BoardingPpl);

System.out.println("Passenger(s) left behind waiting for next train:"+WaitingPpl);
       if(i==stations-1) {
    	   System.out.println("Do you want to continue following Metro train "
   				+obj.getMetroId()+ "?\r\n" + 
   		"Type \"y\" or \"Y\" for yes, anything else for no: ");//the user will be asked if they want to continue
    		 ch=input.next().charAt(0);
				if(ch!='y'&&ch!='Y') {
					j=2;
					break;
					
				}
}

		}
	
	
	}
	}
	
	
}


}

	
	

