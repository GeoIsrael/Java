package telran.view;

import java.time.LocalDate;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public interface InputOutput {

	String getString(String prompt);

	void display(Object object);
	
	default void displayLine(Object object) {
		display(object + "\n");
	}
	
	default <R> R getObject(String prompt, String wrongPrompt,
			Function<String, R> mapper) {
		do {
			String str = getString(prompt);
			try {
				return mapper.apply(str);
			} catch (Exception e) {
				displayLine(wrongPrompt);
			}
		} while (true);
		
	}
	
	default String getString(String prompt, Predicate<String> predicate) {
		do {
			String str = getString(prompt);
			if (predicate.test(str)) {
				return str;
			}else {
				displayLine("Sorry, don't match the predicate");
			}
			
		} while (true);
	}
	
	default String getString(String prompt, Set<String> options) {
		do {
			String str = getString(prompt);
			if (options.contains(str)) {
				return str;
			}else {
				displayLine("Wrong option");
			}
		} while (true);
	}
	
	default Integer getInteger(String prompt) {
		return getObject(prompt, "It's not an integer number",
				Integer::parseInt);
	}
	
	default Integer getInteger(String prompt, int min, int max) {
		do {
			Integer num = getInteger(prompt);
			if (num >= min && num <= max) {
				return num;
			}else {
				displayLine("It's not an integer in the range ["+
			min +" - " + max + "]");
			}
		} while (true);
		
	}
	
	default Double getDouble(String prompt, Predicate<Double> predicate) {
		do {
			Double num = getObject(prompt, "It's not an double number",
					Double::parseDouble);
			if (predicate.test(num)) {
				return num;
			}else {
				displayLine("Number don't match the predicate");
			}
		} while (true);
	}
	
	default LocalDate getDate(String prompt) {
		return getObject(prompt, "It's not valid date formate",
				LocalDate::parse);
	}
	
	default LocalDate getDate(String prompt, LocalDate from,
			LocalDate to) {
		do {
			LocalDate date = getDate(prompt);
			if (date.isBefore(to) && date.isAfter(from)) {
				return date;
			} else {
				displayLine("It's not an date in the range");
			}
		} while (true);
	}

}






