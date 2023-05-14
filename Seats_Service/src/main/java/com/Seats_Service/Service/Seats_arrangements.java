package com.Seats_Service.Service;

import java.util.*;



public class Seats_arrangements {
	
	public String[][] pvrA1() {
		
		// seatmap for rows mapping
			Map<Integer, String> seatmap = new HashMap<>();

			int seatmapkey = 1 ;
			
			for (char i = 'a' ; i <= 'j' ;i++) {
	          	String seatmapvalue =  String.valueOf(i);                   	
	          	seatmap.put(seatmapkey ++ , seatmapvalue);     
			}
			
			Set<Map.Entry<Integer, String>>  seatmapset = seatmap.entrySet();		
			for(Map.Entry<Integer, String > seatmapitr : seatmapset) {
//				System.out.println(seatmapitr.getKey() +" | " + seatmapitr.getValue());
			}
			
			
			String [] [] pvrseatA1 = new String [11] [11] ;
			
			for(int i  = 1 ; i < pvrseatA1.length; i ++) {
				 String rowvalue =  seatmap.get(i);
				 
				for(int j  = 1 ; j < pvrseatA1[i].length ; j++) {	
					
					pvrseatA1[i][j] = rowvalue + Integer.toString(j);
					
					//System.out.print(pvrseatA1[i][j] + " ") ;	
					
				}
				//System.out.println();
	}
			return pvrseatA1;
	}

	
	public  String[][] pvrA2() {
		
		// seatmap for rows mapping
					Map<Integer, String> seatmap = new HashMap<>();

					int seatmapkey = 1 ;
					
					for (char i = 'a' ; i <= 'z' ;i++) {
			          	String seatmapvalue =  String.valueOf(i);                   	
			          	seatmap.put(seatmapkey ++ , seatmapvalue);     
					}
					
					Set<Map.Entry<Integer, String>>  seatmapset = seatmap.entrySet();		
//					for(Map.Entry<Integer, String > seatmapitr : seatmapset) {
//						System.out.println(seatmapitr.getKey() +" | " + seatmapitr.getValue());
//					}
					
					String [] [] pvrseatA2 = new String [21] [21] ;
					
					for(int i  = 1 ; i < pvrseatA2.length; i ++) {
						 String rowvalue =  seatmap.get(i);
						 
						for(int j  = 1 ; j < pvrseatA2[i].length ; j++) {	
							
							pvrseatA2[i][j] = rowvalue + Integer.toString(j);
							
						//	System.out.print(pvrseatA2[i][j] + " ") ;	
						
						}
					//	System.out.println();		
			}
					return pvrseatA2;
		
	}
	
	public String[][] agsA1seats(){
	  
	      String[][]  agsA1seats  = new String [11][21];
		
	      char row = 'a' ;
	      
			for(int i = 1 ; i < agsA1seats.length ; i++) {		    
				for(int j = 1 ; j < agsA1seats[i].length ; j++) {				
					agsA1seats[i][j] = row + String.valueOf(j);				
					//System.out.print(agsA1seats[i][j] + " ");					
	}
		         row ++;
				//	System.out.println();
}
			return agsA1seats ;	
}
	
       public String[][] agsA2seats(){

	      
	      String[][]  agsA2seats  = new String [13][11];
			
	      char row = 'a' ;
	      
			for(int i = 1 ; i < agsA2seats.length ; i++) {		    
				for(int j = 1 ; j < agsA2seats[i].length ; j++) {				
					agsA2seats[i][j] = row + String.valueOf(j);				
				//	System.out.print(agsA2seats[i][j] + " ");					
	}
		         row ++;
				//	System.out.println();
}
	      
			return agsA2seats ;
}
  
     public String[][] inoxA1seats(){
    	 
             String [][] inoxA1seats = new String[11][11];
             
             char rowvalue = 'a' ;             
             for(int i = 1 ; i < inoxA1seats.length ; i++ ) {
            	 for(int j =  1  ; j < inoxA1seats[i].length ; j ++ ) {            		 
            	inoxA1seats[i][j] = rowvalue + String.valueOf(j) ;            		 
            	 }
            	 rowvalue++;
            	// System.out.println();
             }
             
		return inoxA1seats;
    	 
     }
     
     public String[][] inoxA2seats(){
    	 
         String [][] inoxA2seats = new String[12][11];
         
         char rowvalue = 'a' ;             
         for(int i = 1 ; i < inoxA2seats.length ; i++ ) {
        	 for(int j =  1  ; j < inoxA2seats[i].length ; j ++ ) {            		 
        	inoxA2seats[i][j] = rowvalue + String.valueOf(j) ;            		 
        	 }
        	 rowvalue++;
        	
         }
         
	return inoxA2seats;
	 
 }


}
