package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();

		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOn = sdf.parse(sc.next());

		if (!checkOn.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}

		else {
			Reservation reservation = new Reservation(number, checkIn, checkOn);
			System.out.println("Reservation " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");

			System.out.print("Room number: ");
			number = sc.nextInt();

			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOn = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOn);
			System.out.println("Reservation " + reservation);
		}

		sc.close();
	}

}