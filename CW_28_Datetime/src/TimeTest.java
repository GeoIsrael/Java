import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class TimeTest {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(now);
		LocalDate date = LocalDate.parse("1799-06-05");
	//	LocalDate date = LocalDate.parse("1799/06/05"); Not ISO format
		System.out.println(date);
		now = LocalDate.now().withYear(1812);
		System.out.println(now);
		date = LocalDate.of(1982, 9, 12);
		System.out.println(date);
		LocalDate birthDateAS = LocalDate.parse("1799-06-06");
		LocalDate barMizvaAS = birthDateAS.plusYears(13);
		System.out.println("Pushkin's birthDate: "+birthDateAS + 
				" and Pushkin's bar mizva date: " + barMizvaAS);
		//======================================================
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		//======================================================
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		System.out.println(dateTime.getDayOfMonth());
		System.out.println(dateTime.plusDays(500));
		System.out.println(dateTime);
		System.out.println(dateTime.getDayOfWeek());
		//=====================================================
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		zdt = ZonedDateTime.now(ZoneId.of("GMT-4"));
		System.out.println(zdt);
		System.out.println("==============================================================");
//		for(String str : ZoneId.getAvailableZoneIds())
//		{
//			System.out.println(str);
//		}
		ZonedDateTime myDate = ZonedDateTime.of(2019, 1, 31,12,12,9,0,ZoneId.of("Asia/Jerusalem"));
		System.out.println(myDate);
		YearMonth ym = YearMonth.now();
		System.out.println(ym);
		MonthDay md = MonthDay.now();
		System.out.println(md);
		Month m = Month.FEBRUARY;
		System.out.println(m.maxLength());
		//==========================================
		LocalDateTime ldt = LocalDateTime.now();
		LocalDateTime tomorrowTime = ldt.plusDays(1);
		System.out.println(ldt.isBefore(tomorrowTime));
		Duration duration = Duration.between(ldt, tomorrowTime.plusDays(1));
		System.out.println(duration);
		Period period = Period.between(LocalDate.from(ldt), LocalDate.from(tomorrowTime));
		System.out.println(period);
		
		long l = ChronoUnit.MINUTES.between(ldt, tomorrowTime);          //наибелее часто используется
		System.out.println(l);
		//=============================================
		
		for(Month month:Month.values())           
		{
			System.out.println(month);
		}
		//===========================================
		Instant timeStump = Instant.now();                               //внутри наносекунды, метод Instant
		System.out.println(timeStump);                               //timeStump.getNano()
		//===========================================        Форматирование и преобразование из строк
		LocalDateTime current = LocalDateTime.now().plusMonths(2);            
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMMM/yyyy HH:mm");     //система без new
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MMMM/yyyy", Locale.forLanguageTag("he"));
		System.out.println(current.format(dtf));
		System.out.println(current.format(dtf2));
		DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld = LocalDate.parse("10/09/2020", dtf3);
		System.out.println(ld);
		
	//========================================================================
		
		LocalDate newDate = ld.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
		System.out.println(newDate);
		newDate = ld.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));       //класс TemporalAdjusters содержит методы
		System.out.println(newDate);										//DayOfWeek энумератор дней недели
		System.out.println(ld.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.println(ld.with(TemporalAdjusters.lastDayOfMonth()));
		System.out.println(ld.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
		
		System.out.println(ld.with(new NonLeapYear(10)).getYear());     //отдельный класс с имплементацией интерфейса TemporalAdjaster
		
	}

}
