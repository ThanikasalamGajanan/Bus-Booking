package bus_reservation_system;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSystem {

    public static void main(String[] args) {

        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        Admin admin = new Admin();

        Scanner scanner = new Scanner(System.in);
        boolean loggedInAsAdmin = false;
        boolean running = true;

        while (running) {

            System.out.println("\n=== BUS RESERVATION SYSTEM ===");
            System.out.println("1. Add Bus (Admin Only)");
            System.out.println("2. View Buses");
            System.out.println("3. Make Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Admin Login");
            System.out.println("7. Exit");

            System.out.print("Enter an option: ");

            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("❌ Please enter a valid number.");
                continue;
            }

            switch (option) {


                case 1:
                    if (!loggedInAsAdmin) {
                        System.out.println("❌ Access Denied! Log in as Admin first.");
                        break;
                    }

                    System.out.print("Enter Bus No: ");
                    String busNo = scanner.nextLine();

                    if (AvailabilityChecker.findBus(buses, busNo) != null) {
                        System.out.println("❌ Bus with this number already exists!");
                        break;
                    }

                    System.out.print("Enter Seat Count: ");
                    int seatCount;
                    try {
                        seatCount = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("❌ Invalid seat count!");
                        break;
                    }

                    System.out.print("Enter Route: ");
                    String route = scanner.nextLine();

                    System.out.print("Enter Type (AC/Non-AC): ");
                    String type = scanner.nextLine();

                    System.out.print("Enter Normal Ticket Price: ");
                    int normalPrice = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Full Ticket Price: ");
                    int fullPrice = Integer.parseInt(scanner.nextLine());

                    buses.add(new Bus(busNo, seatCount, route, type, normalPrice, fullPrice));
                    System.out.println("✔ Bus added successfully!");
                    break;

                case 2:
                    if (buses.isEmpty()) {
                        System.out.println("No buses available.");
                    } else {
                        System.out.println("\n--- AVAILABLE BUSES ---");
                        for (Bus b : buses) b.display();
                    }
                    break;

                case 3:
                    System.out.print("Enter Bus No: ");
                    String bookBusNo = scanner.nextLine();

                    Bus selectedBus = AvailabilityChecker.findBus(buses, bookBusNo);
                    if (selectedBus == null) {
                        System.out.println("❌ Bus not found!");
                        break;
                    }

                    System.out.print("Enter Seats Required: ");
                    int seats;
                    try {
                        seats = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("❌ Invalid number!");
                        break;
                    }

                    if (!AvailabilityChecker.checkSeats(selectedBus, seats)) {
                        System.out.println("❌ Not enough seats available!");
                        break;
                    }

                    System.out.print("Enter Passenger Name: ");
                    String pName = scanner.nextLine();

                    System.out.print("Enter Phone: ");
                    String pPhone = scanner.nextLine();

                    Passenger passenger = new Passenger(pName, pPhone);

                    selectedBus.reduceSeats(seats);

                    bookings.add(new Booking(passenger, seats, bookBusNo));

                    System.out.println("✔ Booking Successful!");
                    break;

                case 4:
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings found.");
                    } else {
                        System.out.println("\n--- BOOKING DETAILS ---");
                        for (Booking b : bookings) b.display();
                    }
                    break;

                case 5:
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings to cancel.");
                        break;
                    }

                    System.out.print("Enter Passenger Name to Cancel: ");
                    String cancelName = scanner.nextLine();

                    Booking bookingToCancel = null;

                    for (Booking bk : bookings) {
                        if (bk.getPassengerName().equalsIgnoreCase(cancelName)) {
                            bookingToCancel = bk;
                            break;
                        }
                    }

                    if (bookingToCancel == null) {
                        System.out.println("❌ Booking not found!");
                        break;
                    }

                    Bus busToRestore = AvailabilityChecker.findBus(buses, bookingToCancel.getBusNo());
                    if (busToRestore != null) {
                        busToRestore.restoreSeats(bookingToCancel.getSeatAmount());
                    }

                    bookings.remove(bookingToCancel);
                    System.out.println("✔ Booking Cancelled Successfully!");
                    break;


                case 6:
                    System.out.print("Enter Admin Username: ");
                    String user = scanner.nextLine();

                    System.out.print("Enter Admin Password: ");
                    String pass = scanner.nextLine();

                    if (admin.login(user, pass)) {
                        loggedInAsAdmin = true;
                        System.out.println("✔ Admin login successful!");
                    } else {
                        System.out.println("❌ Incorrect username or password.");
                    }
                    break;


                case 7:
                    System.out.println("✨ Thank you for using the Bus Reservation System!");
                    running = false;
                    break;

                default:
                    System.out.println("❌ Invalid option!");
            }
        }

        scanner.close();
        admin.displayInfo();
    }
}
