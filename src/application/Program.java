package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int room = sc.nextInt();
			System.out.print("Check-in: ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out: ");
			Date checkout = sdf.parse(sc.next());

			Reservation reservation = new Reservation(room, checkin, checkout);
			System.out.println("Reservation " + reservation);

			System.out.println("\nEnter data to update the reservation:");
			System.out.print("Check-in date: ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date: ");
			checkout = sdf.parse(sc.next());

			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation " + reservation);
		} catch (ParseException e) {
			System.out.println("Invalid date format.");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		} finally {
			sc.close();
		}
	}
}
