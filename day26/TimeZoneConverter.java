package day26;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneConverter {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		System.out.println("Enter the date and time (yyyy-MM-dd HH:mm): ");
		String dateTimeInput = scanner.nextLine();
		LocalDateTime localDateTime = LocalDateTime.parse(dateTimeInput,formatter);
		
		System.out.println("Enter the source timzone (e.g., America/New_York):");
		String sourceTimeZone = scanner.nextLine();
		ZoneId sourceZoneId = ZoneId.of(sourceTimeZone);
		
		System.out.println("Enter the target timeZone (e.g., Asia/Tokyo): ");
		String targetTimeZone = scanner.nextLine();
		ZoneId targetZoneId = ZoneId.of(targetTimeZone);
		
		ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(localDateTime, sourceZoneId);
		ZonedDateTime targetZonedDatetime = sourceZonedDateTime.withZoneSameInstant(targetZoneId);
		
		System.out.println("The time in " + targetTimeZone + " is : " + targetZonedDatetime.format(formatter));

	}

}
