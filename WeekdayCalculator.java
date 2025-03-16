/*
 * Name : Ashwidhi Chidimilla
 * Roll No :
 * Course :
 * */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * @author Ashiwdhi Chidimilla
 * WeekdayCalculator class to know the day of week a person is born
 * */
public class WeekdayCalculator
{
	/*
	 * main method from the program execution starts
	 * */
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to MCIS5103's fantastic birth-o-meter!");
		System.out.println();
		System.out.println("All you have to do is enter your birth date, and it will");
		System.out.println("tell you the day of the week on which you were born.");
		System.out.println();
		System.out.println("Some automatic tests....");
		System.out.println("12 10 2003 => " + weekday(12,10,2003));
		System.out.println(" 2 13 1976 => " + weekday(2,13,1976));
		System.out.println(" 2 13 1977 => " + weekday(2,13,1977));
		System.out.println(" 7  2 1974 => " + weekday(7,2,1974));
		System.out.println(" 1 15 2003 => " + weekday(1,15,2003));
		System.out.println("10 13 2000 => " + weekday(10,13,2000));
		System.out.println();

		System.out.println("Now it's your turn!  What's your birthday?");
		System.out.print("Birth date (mm dd yyyy): ");

		//read the input from user mm dd yyyy format
		int mm = keyboard.nextInt();
		int dd = keyboard.nextInt();
		int yyyy = keyboard.nextInt();

		// put a function call for weekday() here
		String result = weekday(mm, dd, yyyy);
		System.out.println("You were born on " + result + "!");
	}

	/*
	 * @author Ashiwdhi Chidimilla
	 *
	 * weekday method to find the day on which the user is born
	 * @param int mm, int dd, int yyyy
	 * @return String (day, month dd, yyyy)
	 * */

	public static String weekday( int mm, int dd, int yyyy )
	{
		int yy, total;
		String date = "";

		// bunch of calculations go here

		//no of years since 1900
		yy = yyyy - 1900;

		// adding the quotient of years since 1900 when divide by 4
		total = yy/4;

		//adding the above calculated to the years since 1900
		total += yy;

		//adding the day of the month to total
		total += dd;

		//adding the month_offset to the total
		total += monthOffset(mm);

		//check if the year is leap and month is jan/feb
		if(is_leap(yyyy) && (mm == 1 || mm == 2)){
			total -= 1;
		}

		date = weekdayName(total%7) + ", " + monthName(mm) + " " + dd + ", " + yyyy;

		return date;
	}


	// paste your functions from MonthName, WeekdayName, and MonthOffset here

	/*
	 * @author Ashiwdhi Chidimilla
	 *
	 * monthName method to find the corresponding month name
	 *
	 * @param int mm
	 * @return String (month)
	 * */
	public static String monthName(int mm){

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

		//if the month key is not in the monthMap, we return corresponding month name or error
		return monthMap.getOrDefault(mm, "error");
	}

	/*
	 * @author Ashiwdhi Chidimilla
	 *
	 * weekdayName method to find the corresponding day on of the week
	 *
	 * @param int day
	 * @return String (day of the week)
	 * */
	public static String weekdayName(int day){
		Map<Integer, String> weekMapping = new HashMap<>();
		weekMapping.put(1, "Sunday");
		weekMapping.put(2, "Monday");
		weekMapping.put(3, "Tuesday");
		weekMapping.put(4, "Wednesday");
		weekMapping.put(5, "Thursday");
		weekMapping.put(6, "Friday");
		weekMapping.put(0, "Saturday");

		return weekMapping.get(day);
	}

	/*
	 * @author Ashiwdhi Chidimilla
	 *
	 * monthOffset method to find the corresponding month offset as provided in the instructions
	 *
	 * @param int mm
	 * @return int monthOffSet
	 * */
	public static int monthOffset(int mm){
		return switch (mm){
			case 1 -> 1;
			case 2, 3, 11 -> 4;
			case 4, 7 -> 0;
			case 5 -> 2;
			case 6 -> 5;
			case 8 -> 3;
			case 9, 12 -> 6;
			default -> -1;
		};
	}

	/*
	 * is_leap method to check if the year is leap or not
	 *
	 * @param int year
	 * @return boolean
	 * */
	public static boolean is_leap( int year )
	{
		// years which are evenly divisible by 4 are leap years,
		// but years divisible by 100 are not leap years,
		// though years divisible by 400 are leap years
		boolean result;

		if ( year%400 == 0 )
			result = true;
		else if ( year%100 == 0 )
			result = false;
		else result = year % 4 == 0;
		
		return result;
	}

}
