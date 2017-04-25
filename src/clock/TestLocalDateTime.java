package clock;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestLocalDateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime sylvester = LocalDateTime.of(2014,Month.DECEMBER,31,23,59,59);
		System.out.println("LocalDateTime:"+sylvester);
		DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
		System.out.println("dayOfWeek:"+dayOfWeek);
		Month month = sylvester.getMonth();
		System.out.println("month:"+month);
		Instant instant = sylvester//只要附加上时区信息，就可以将其转换为一个时间点Instant对象，Instant时间点对象可以很容易的转换为老式的java.util.Date
				.atZone(ZoneId.systemDefault())
				.toInstant();
		System.out.println("instant:"+instant);
		Date legacyDate = Date.from(instant);
		System.out.println("legacyDate:"+legacyDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd,yyyy-HH:mm");
		LocalDateTime parsed = LocalDateTime.parse("Nov 03,2014-07:13", formatter);//通过模板格式得到LocalDateTime
		System.out.println("parsed:"+parsed);
		String string = formatter.format(parsed);//转化为format格式的String
		System.out.println("string:"+string);
	}

}
