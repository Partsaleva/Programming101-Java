package week1;
/*34. Friday Years
Have you every wondered how many fridays are there in one year?
The count can be 52 or 53, depending on the weeks of that year (leap or not) and the start of the year.
If an year contains 53 fridays, we call that "A Friday Year"
You are to implement a function, called friday_years(String start, String end), where start and end are integers, representing years.
The function should return the count of all friday years between [start, end]
friday_years(1000, 2000) = 178
friday_years(1753, 2000) = 44
friday_years(1990, 2015) = 4*/
public class FridayYears {

	public static void main(String[] args) {
		FridayYears year=new FridayYears();
		System.out.println(year.friday_years(1000, 2000));
		System.out.println(year.friday_years(1753, 2000));
		System.out.println(year.friday_years(1990, 2015));	

	}

	int friday_years(int start, int end){
		int fridayYears=0;
		int weekDay=0;
		for(int i=start; i<=end; i++){
			weekDay=weekDay%7+1;
			if(isLeapYear(i)){
				// Or if either of the first two days lands on a Friday during a leap year- 53 Fridays.
				if(weekDay%5==0||weekDay%4==0){
					fridayYears++;
				}
				//if its leap year next starts +2 weekDay (else from next)
				weekDay+=2;
				i++;
			}
			//if the year starts on a Friday in a non-leap year- 53 Fridays
			if(weekDay%5==0){
				fridayYears++;
			}
		}		
		return fridayYears;
	}
	
	
	private boolean isLeapYear(int year) {
	    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}
	

}