package telran.days;

public class WeekDayTestAppl {

	public static void main(String[] args) {
		displayCommentWeekDay(WeekDay.MON);

	}

	private static void displayCommentWeekDay(WeekDay day) {
		switch (day) {
		case SUN:
			System.out.println("First working day for Israel and week end in other countries");
			break;
		case SAT:
			System.out.println("week end");
			break;
		case FRI:
			System.out.println("week end for Israel");
			break;

		default:
			System.out.println("regular working day");
		}
		
	}

}
