

public class Kelipatan {
	public static void main(String[]args){
		long t = 1000;
		long sum = 0;
		
		
		for(int i =1; i<t; i++){
			
			if(i%3 == 0 || i%5 == 0 ){
				sum =sum + i;
			}
		}
		System.out.println ("Jumlah semua kelipatan 3 atau 5 dibawah 1000 =  "+sum);
	}
  
    
}