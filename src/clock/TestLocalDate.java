package clock;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class TestLocalDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * LocalDate 表示了一个确切的日期，比如 2014-03-11。
		 * 该对象值是不可变的，用起来和LocalTime基本一致。
		 * 下面的例子展示了如何给Date对象加减天/月/年。
		 * 另外要注意的是这些对象是不可变的，操作返回的总是一个新实例
		 */
		LocalDate today = LocalDate.now();
		System.out.println("today:"+today);
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		System.out.println("tomorrow:"+tomorrow);
		LocalDate yesterday = tomorrow.minusDays(2);
		System.out.println("yesterday:"+yesterday);
		LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
		System.out.println("independenceDay:"+independenceDay);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
		System.out.println("dayOfWeek:"+dayOfWeek);
		DateTimeFormatter germanFormatter = DateTimeFormatter
				.ofLocalizedDate(FormatStyle.MEDIUM)
				.withLocale(Locale.GERMAN);
		LocalDate XMAS = LocalDate.parse("24.12.2014", germanFormatter);//从字符串解析一个LocalDate类型
		System.out.println("XMAS:"+XMAS);
	}

}
