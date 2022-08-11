
public class Problem019 {
	public static final int SUNDAY = 0;
	public static final int MONDAY = 1;
	public static final int FIRST  = 1;

	public static void main(String[] args) { 
		SundayGenerator sunday = new SundayGenerator(MONDAY);
		DOMGenerator dom = new DOMGenerator(1900,1,1, 2000,12,31);

		int count = 0;
		int j = 0;
		// Note: this skips the very first day, but we know that is not a solution.
		while(dom.hasNext()) {

			// // Use to spot-check days of the week.
			//if(j>=36650 && j<=36660) { 
			//	StringBuffer sb = new StringBuffer();
			//	sb.append(dom.year);
			//	sb.append("-");
			//	sb.append(dom.month);
			//	sb.append("-");
			//	sb.append(dom.day);
			//	sb.append(" ---> ");
			//	sb.append(dow(sunday.dow));
			//	System.out.println(sb.toString());
			//}
			int thisdow = sunday.next();
			int thisdom = dom.next();
			if(thisdow==SUNDAY && thisdom==FIRST){
				// Careful.
				if(dom.year>1900) { 
					count++;
				}
			}
			j++;
		}
		System.out.println(Integer.toString(count));
			
	}

	public static String dow(int i) { 
		if(i==0) { 
			return "Sun";
		} else if(i==1) { 
			return "Mon";
		} else if(i==2) { 
			return "Tue";
		} else if(i==3) { 
			return "Wed";
		} else if(i==4) { 
			return "Thu";
		} else if(i==5) { 
			return "Fri";
		} else if(i==6) { 
			return "Sat";
		} else {
			return "XXXXXXXXX";
		}
	}

}


/** SundayGenerator class
 * keeps track of the day of the week.
 * 
 * This is really just a glorified 
 * modular int counter wrapper.
 */
class SundayGenerator { 
	int dow;
	public SundayGenerator(int dow) { 
		this.dow = dow;
	}
	public int next() {
		// Advance dow by one
		dow = (dow+1)%7;

		// Return it
		return dow;
	}
}

/** DOMGenerator stores year, month, and day, 
 * and increments it internally to return the correct
 * day of the month.
 */
class DOMGenerator { 
	int year, month, day;
	int endyear, endmonth, endday;
	final int[] DOM = {31,28,31,30,31,30,31,31,30,31,30,31};
	public DOMGenerator(int startyear, int startmonth, int startday,
						int endyear,   int endmonth,   int endday) { 
		this.year  = startyear;
		this.month = startmonth;
		this.day   = startday;
		this.endyear  = endyear;
		this.endmonth = endmonth;
		this.endday   = endday;
	}
	/** Returns true if we are not at the end date. */
	public boolean hasNext() { 
		return !(year==endyear && month==endmonth && day==endday);
	}
	/** Returns true if year is a leap year. */
	public boolean isLeapYear(int year) { 
		if(year%4==0) { 
			if(year%100==0 && year%400!=0) { 
				return false;
			} else {
				return true;
			}
		}
		return false;
	}
	/** Advance by one day, and return the day of the month. */
	public int next() { 
		//System.out.println(this.year+"-"+this.month+"-"+this.day);
		if(month==12) {
			if(day==31) { 
				// Last day of year, increment year
				month=1;
				day=1;
				year++;
			} else {
				day++;
			}

		} else if(month==2) {
			// Deal with leap year
			if(day==28) { 
				if(isLeapYear(this.year)) {
					// Feb 29
					day++;
				} else {
					// March 1
					day = 1;
					month++;
				}
			} else if(day==29) { 
				day = 1;
				month++;
			} else {
				day++;
			}
		} else {
			// Just a normal month of a normal year.
			if(day==DOM[month-1]) {
				// End of the month. Already dealt with Dec 31st case.
				day = 1;
				month++;
			} else {
				day++;
			}
		}

		return day;
	}
}