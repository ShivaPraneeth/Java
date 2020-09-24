package Assignment;

import java.util.ArrayList;
import java.util.Random;

public class Train {
	
	private int metroId=(int)(Math.random() * (1000 - 1 + 1) + 1);;
	private int stationNum;
	private String direction;
	private int passTotal;
	String dir[]= {"North","South","East","West"};//it is used to generate the lane
    Random rand=new Random();
	ArrayList<Integer> stadir=new ArrayList<>();//used to generate path
	int[] waiting=new int[15];
	int waitingPpl;
	int boarding;
	int random=(int)(Math.random() * (1000 - 1 + 1) + 1);

	public  Train() {
		                        //default constructer
		this.stationNum=0;
		this.direction="east";
		this.passTotal=0;
		this.waitingPpl=0;
		
				
	}
	
	
	public Train(int id)//constructer with parameter
	{
		this.metroId=id;
		this.stationNum=0;
		this.direction="east";
		this.passTotal=0;
	}
	public int getWaitingPpl(int i) {
		return waiting[i];
	}
	public int getMetroId() {
		return this.metroId;
	}
	public void setMetroId(int metroId) {
		this.metroId = metroId;
	}
	public int getStationNum() {
		return stationNum;
	}
	public void setStationNum(int stationNum) {
		this.stationNum = stationNum;
	}
	public int getPassTotal() {
		return passTotal;
	}
	public void setPassTotal(int passTotal) {
		this.passTotal = passTotal;
	}
	
   public String determineDir(int stations,int lane) {//generating random path
	  for(int i=0;i<stations;i++) {
		                        
		   waiting[i]=0;
	   }
	  
	   return dir[lane-1];
	   
   }
   public int calc(int BoardingPpl,int LeavingPpl,int stationNum) {
	   
	  
	   passTotal=passTotal+BoardingPpl-LeavingPpl;//passtotal is calculated
	   
	   if(passTotal>250) {
		   waitingPpl=passTotal-250;//waiting people are calculated
		   passTotal=250;
		   waiting[stationNum]=waitingPpl;
	   }
	   else {
		   waiting[stationNum]=0;
	   }
	   
	   return passTotal;
   }
   public String revdir( int lane) {
	   if(dir[lane-1]=="North") {
		   return "South";
	   }
	   else if(dir[lane-1]=="South") {
		   return "North";
	   }
	   else if(dir[lane-1]=="East") {
		   return "West";
	   }
	   else  {
		   return "East";
	   }
	   
	   
   }
   
 
   
   
   
}

	
		

	

