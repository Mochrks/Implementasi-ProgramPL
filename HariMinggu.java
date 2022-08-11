import java.util.Calendar;
import java.util.GregorianCalendar;

public class HariMinggu {
	
	public static void main(String[] args) {
		// 1 januari 1900 hingga 31 desember 2000
		Calendar date = new GregorianCalendar();
		date.set(1901, Calendar.JANUARY, 1);
		
		int minggu = 0;
		
		while((date.get(Calendar.YEAR) <= 2000)) {
			if(date.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) {
				minggu++;
			}
			date.add(Calendar.MONTH, 1);
		}
		System.out.println("Selama abad ke-20 ada " + minggu + " Minggu pada tanggal satu bulan antara 1 Januari 1900 hingga 31 Desember 2000.");
	}
}
