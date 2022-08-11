import java.util.Scanner;
import java.util.*;
public class Obat {
	
    public static void main (String[] args) {
    	Scanner input = new Scanner (System.in);
    	
    	int umur ;
    	String JK;
    	int BB ;
    	
    	System.out.println ("Masukan umur anda= " );
    	umur = input.nextInt();
    	
    	System.out.println ("Masukan Jenis kelamin P/L =");
    	JK = input.next();
    	
    	System.out.println ("Masukan  BB anda = ");
    	BB = input.nextInt();
    	
    
		
    	System.out.println ("Umur anda adalah = " +umur);
    	System.out.println ("Jenis Kelamin  anda adalah = " +JK);
    	System.out.println ("Berat badan anda adalah = " +BB);
    	
    	
    	if(BB >150 && JK.equals("L")){
    		System.out.println ("Obat anda adalah jenis kapsul");
    	}else if( umur <= 21 && JK.equals("P") && BB <=150){
    		System.out.println ("Obat anda adalah jenis  kapsul");
    	}else if( umur >= 21 && JK.equals("L") && BB >=150){
    		System.out.println ("Obat anda adalah jenis  pil");
    	}else if( umur <= 21 && JK.equals("L") && BB >=150){
    		System.out.println ("Obat anda adalah jenis  pil");
    	}else if( umur <= 21 && JK.equals("L") && BB <150){
    		System.out.println ("Obat anda adalah jenis  tablet");
    	}else if( BB <150 && JK.equals("P")){
    		System.out.println ("Obat anda adalah jenis  tablet");
    	}else{
    		System.out.println ("Tidak diberikan obat");
    	}
    }
    
    	
  	
    
}