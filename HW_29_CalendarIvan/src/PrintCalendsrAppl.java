import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class PrintCalendsrAppl {
	private static final int DATE_WIDTH = 4;                     

	public static void main(String[] args) {
		int[] monthYear = args.length == 2 ? getMonthYear(args) : getCurrentMonthYear(); 
		
//		for (int i : monthYear) {
//			System.out.println(i);
//		}
//		System.out.println(monthYear[1]);     //в массиве два значенияя - 7 и 2020
		
		
		if (monthYear == null) {
			System.out.println("wrong input - usage: <month number> <year number>");
			return;
		}
		int month = monthYear[0];
		int year = monthYear[1];
		printMonthYear(month, year);

	}
	
	private static int[] getMonthYear(String[] args) {
		int res[] = new int[2];
		try {
			res[0] = Integer.parseInt(args[0]);
			res[1] = Integer.parseInt(args[1]);
			if (res[0] < 1 || res[0] > 12)
				return null;
			if (res[1] < 0)
				return null;

		} catch (NumberFormatException e) {
			return null;
		}
		return res;
	}
	private static int[] getCurrentMonthYear() {
		LocalDate current = LocalDate.now();
		return new int[] { current.getMonthValue(), current.getYear() };
	}

	private static void printMonthYear(int month, int year) {
		printTitle(month, year);     //печатает месяц и год
		printWeekDayNames();        //печатает имена дней недели
		printDates(month, year);    //печатает даты
		System.out.println();

	}
	private static void printTitle(int month, int year) {
		String monthName = getMonthName(month);
		System.out.printf("%10s%s %d\n", " ", monthName, year);

	}
	private static String getMonthName(int month) {
		Month enMonth = Month.of(month);
		return enMonth.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("en"));
	}
	private static void printWeekDayNames() {
		System.out.print("  ");
		for (int i = 1; i <= 7; i++) {
			System.out.print(getWeekDayName(i) + " ");
		}
		System.out.println();

	}

	private static String getWeekDayName(int i) {
		DayOfWeek dayOfWeek = DayOfWeek.of(i);
		return dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.forLanguageTag("en"));
	}
//--
	private static void printDates(int month, int year) {
		int firstColumn = getFirstColumn(month, year);
		printOffset(firstColumn);
		printNumbersFromOffset(firstColumn, month, year);

	}
	
	private static int getFirstColumn(int month, int year) {
		LocalDate firstDate = LocalDate.of(year, month, 1);
		return firstDate.getDayOfWeek().getValue();
	}

	private static void printOffset(int firstColumn) {
		for (int i = DATE_WIDTH; i <= firstColumn * DATE_WIDTH-1; i++) {
			System.out.print(" ");
		}

	}
	
	private static void printNumbersFromOffset(int firstColumn, int month, int year) {
		int nDays = getNumberOfDays(month, year);
		for (int i = 1; i <= nDays; i++) {
			System.out.printf("%" + DATE_WIDTH + "d", i);
			if (firstColumn == 7) {
				firstColumn = 1;
				System.out.println();
			} else {
				firstColumn++;
			}
		}
	}
	private static int getNumberOfDays(int month, int year) {
		YearMonth yearMonth = YearMonth.of(year, month);
		return yearMonth.lengthOfMonth();
	}
}
