package day26;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateDifferenceCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		System.out.print("Enter the first date (yyy-MM-dd): ");
		String firstDateInput = scanner.nextLine();
		LocalDate firstDate = LocalDate.parse(firstDateInput,formatter);
		
		System.out.print("Enter the second date (yyy-MM-dd): ");
		String secondDateInput = scanner.nextLine();
		LocalDate secondDate = LocalDate.parse(secondDateInput,formatter);
		
		long daysBetween = ChronoUnit.DAYS.between(firstDate, secondDate);
		
		System.out.println("Number of days between " + firstDate + " and" + secondDate + ": " + daysBetween);
		
		scanner.close();
		
		
	}

}
