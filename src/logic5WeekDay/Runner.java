package logic5WeekDay;

/**
 * 
 * известно первый день года (например, среда). 
 * вычислить какой день недели для любого заданного дня года (например 17 июня). условие что год не високосный
 *
 */
public class Runner {
	
	public static int getCountDayFromYearBegin (int day, int month) {
		int countDayFromYearBegin = 0;
		
		if (month == 1) {
			return --day;
		}
		
		for (int monthNumber = 1; monthNumber < month; monthNumber++) {
			//т.к. год - невисокосный и есть зависимость 
			if (monthNumber == 2) {
				countDayFromYearBegin += 28;
			}
			else if (monthNumber >= 1 && monthNumber <= 7) { // for 1, 3..7 month
				countDayFromYearBegin += 30 + monthNumber % 2;
			} else { // for 8..12 month
				countDayFromYearBegin += 30 + (monthNumber+1) % 2;
			}
		}
		countDayFromYearBegin += day;
		
		return --countDayFromYearBegin;
	}
	
	public static String getWeekDay (String date) {
		int day = Integer.parseInt(date.split(" ")[0]);
		 int month = Integer.parseInt(date.split(" ")[1]);
		 
		 int countDayFromYearBegin = getCountDayFromYearBegin(day, month);
		 
		 String weekDay = "";
		 
		 switch (countDayFromYearBegin % 7) {
		 	case 0: 
		 		weekDay = "Wednesday";
		 		break;
		 	case 1: 
		 		weekDay = "Thursday";
		 		break;
		 	case 2: 
		 		weekDay = "Friday";
		 		break;
		 	case 3: 
		 		weekDay = "Saturday";
		 		break;
		 	case 4: 
		 		weekDay = "Sunday";
		 		break;
		 	case 5: 
		 		weekDay = "Monday";
		 		break;
		 	case 6: 
		 		weekDay = "Tuesday";
		 		break;

		 }
		 return weekDay;
		
	}



	public static void main(String[] args) {		 
		 System.out.println(getWeekDay("01 01"));
		 System.out.println(getWeekDay("04 01"));
		 System.out.println(getWeekDay("15 02"));
		 System.out.println(getWeekDay("03 03"));
		 System.out.println(getWeekDay("28 09"));
		 System.out.println(getWeekDay("12 12"));

	}

}
