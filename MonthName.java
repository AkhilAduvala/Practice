/*
 * Name : Ashwidhi Chidimilla
 * Roll No :
 * Course :
 * */

import java.util.HashMap;
import java.util.Map;

/*
* @author Ashiwdhi Chidimilla
*
* monthName class to know the name of month
* */
public class MonthName
{
	/*
	* @author Ashiwdhi Chidimilla
	*
	* month_name method to find the month
	*
	* @param int month number
	* @return month name
	* */
	public static String month_name( int month )
	{
		String result;
	
		// add the months in the map to use for lookup
		Map<Integer, String> monthMap = new HashMap<>();
		monthMap.put(1, "January");
		monthMap.put(2, "February");
		monthMap.put(3,"March");
		monthMap.put(4,"April");
		monthMap.put(5, "May");
		monthMap.put(6, "June");
		monthMap.put(7, "July");
		monthMap.put(8, "August");
		monthMap.put(9, "September");
		monthMap.put(10, "October");
		monthMap.put(11, "November");
		monthMap.put(12, "December");

		//if the month key is not in the monthMao, we return error
        result = monthMap.getOrDefault(month, "error");
		
		return result;
	}


	/*
	* main method from the program execution starts
	* */
	public static void main( String[] args )
	{
		System.out.println( "Month 1: " + month_name(1) );
		System.out.println( "Month 2: " + month_name(2) );
		System.out.println( "Month 3: " + month_name(3) );
		System.out.println( "Month 4: " + month_name(4) );
		System.out.println( "Month 5: " + month_name(5) );
		System.out.println( "Month 6: " + month_name(6) );
		System.out.println( "Month 7: " + month_name(7) );
		System.out.println( "Month 8: " + month_name(8) );
		System.out.println( "Month 9: " + month_name(9) );
		System.out.println( "Month 10: " + month_name(10) );
		System.out.println( "Month 11: " + month_name(11) );
		System.out.println( "Month 12: " + month_name(12) );
		System.out.println( "Month 43: " + month_name(43) );
	}
}
