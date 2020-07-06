import java.time.Year;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NonLeapYear implements TemporalAdjuster {      //temporal это все временное
	int nYears;           //поле количество лет
	
	
	
	public NonLeapYear(int nYears) {       //инициализируется конструктором
		this.nYears = nYears;  
	}



	@Override
	public Temporal adjustInto(Temporal temporal) {               //
		int count = 0;
		while(count<nYears)                                       //в цикле
		{
			temporal = temporal.plus(1, ChronoUnit.YEARS);        //прибавляю изменяется ChronoUnit на 1 год 
			if(!Year.isLeap(temporal.get(ChronoField.YEAR)))      //проверка не является ли год високосным?
			{
				count++;                                          //если не является то увеличиваем счетчик лет
			}
		}
		
		return temporal;               //возврат
	}

}
