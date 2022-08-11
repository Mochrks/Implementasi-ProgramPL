import java.util.Scanner;

public class ReverseString{
	public static void main(String[] arg){
		
		ReverseString rs =new ReverseString();
		Scanner input =new Scanner(System.in);
		System.out.print("Masukan String/kata : ");
		String  str = input.nextLine();	
			
		System.out.println("Hasil proses reverse String/kata : "+rs.reverse(str));
	}
	static String reverse(String s){
		String rs="";
		for(int j=s.length();j>0;--j){
		rs =rs+(s.charAt(j-1)); 
		}
		return rs;
	}
}