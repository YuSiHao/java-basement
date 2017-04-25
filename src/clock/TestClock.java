package clock;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;



public class TestClock {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clock clock = Clock.systemDefaultZone();//Clock类提供了访问当前日期和时间的方法，Clock是时区敏感的
		long millis = clock.millis();//获取当前的微妙数
		System.out.println(millis);
		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant);
		System.out.println("instant:"+instant);
		System.out.println("legacyDate:"+legacyDate);
		System.out.println(ZoneId.getAvailableZoneIds());//在新API中时区使用ZoneId来表示。时区可以很方便的使用静态方法of来获取到。 时区定义了到UTS时间的时间差，在Instant时间点对象到本地日期对象之间转换的时候是极其重要的
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());
		LocalTime now1 = LocalTime.now(zone1);//LocalTime 定义了一个没有时区信息的时间
		LocalTime now2 = LocalTime.now(zone2);
		System.out.println(now1.isBefore(now2));  // false
		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
		System.out.println(hoursBetween);       // -4
		System.out.println(minutesBetween);     // -239
		LocalTime localTime = LocalTime.of(12, 24, 52);//LocalTime 提供了多种工厂方法来简化对象的创建，包括解析时间字符串
		System.out.println("localTime:"+localTime);
		DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);
		LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
		System.out.println("leetTime:"+leetTime);
	}
}
