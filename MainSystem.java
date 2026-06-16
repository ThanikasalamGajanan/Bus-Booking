package bus_reservation_system;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public final class MainSystem {

    private static final Logger LOGGER =
            Logger.getLogger(MainSystem.class.getName());

    private static final int ADD_BUS = 1;
    private static final int VIEW_BUSES = 2;
    private static final int MAKE_BOOKING = 3;
    private static final int VIEW_BOOKINGS = 4;
    private static final int CANCEL_BOOKING = 5;
    private static final int ADMIN_LOGIN = 6;
    private static final int EXIT = 7;

    private MainSystem() {
        // Prevent instantiation
    }

    public static void main(String[] args) {

        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);

        boolean loggedInAsAdmin = false;
        boolean running = true;

        while (running) {

            displayMenu();

            int option = readInt(scanner);

            switch (option) {

                case ADD_BUS:
                    loggedInAsAdmin = addBus(
                            scanner, buses, loggedInAsAdmin);
                    break;

                case VIEW_BUSES:
                    viewBuses(buses);
                    break;

                case MAKE_BOOKING:
                    makeBooking(scanner, buses, bookings);
                    break;

                case VIEW_BOOKINGS:
                    viewBookings(bookings);
                    break;

                case CANCEL_BOOKING:
                    cancelBooking(scanner, buses, bookings);
                    break;

                case ADMIN_LOGIN:
                    loggedInAsAdmin = adminLogin(scanner, admin);
                    break;

                case EXIT:
                    LOGGER.info(
                            "Thank you for using the Bus Reservation System!");
                    running = false;
                    break;

                default:
                    LOGGER.warning("Invalid option!");
            }
        }

        scanner.close();
        admin.displayInfo();
    }

    private static void displayMenu() {
        LOGGER.info("""
                === BUS RESERVATION SYSTEM ===
                1. Add Bus (Admin Only)
                2. View Buses
                3. Make Booking
                4. View Bookings
                5. Cancel Booking
                6. Admin Login
                7. Exit
                """);
    }

    private static int readInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            LOGGER.warning("Please enter a valid number.");
            return -1;
        }
    }

    private static boolean addBus(
            Scanner scanner,
            ArrayList<Bus> buses,
            boolean loggedInAsAdmin) {

        if (!loggedInAsAdmin) {
            LOGGER.warning(
                    "Access Denied! Log in as Admin first.");
            return false;
        }

        System.out.print("Enter Bus No: ");
        String busNo = scanner.nextLine();

        if (AvailabilityChecker.findBus(buses, busNo) != null) {
            LOGGER.warning("Bus already exists!");
            return true;
        }

        System.out.print("Enter Seat Count: ");
        int seatCount = readInt(scanner);

        System.out.print("Enter Route: ");
        String route = scanner.nextLine();

        System.out.print("Enter Type (AC/Non-AC): ");
        String type = scanner.nextLine();

        System.out.print("Enter Normal Ticket Price: ");
        int normalPrice = readInt(scanner);

        System.out.print("Enter Full Ticket Price: ");
        int fullPrice = readInt(scanner);

        buses.add(new Bus(
                busNo,
                seatCount,
                route,
                type,
                normalPrice,
                fullPrice));

        LOGGER.info("Bus added successfully!");
        return true;
    }

    private static void viewBuses(ArrayList<Bus> buses) {

        if (buses.isEmpty()) {
            LOGGER.info("No buses available.");
            return;
        }

        LOGGER.info("--- AVAILABLE BUSES ---");

        for (Bus bus : buses) {
            bus.display();
        }
    }

    private static void makeBooking(
            Scanner scanner,
            ArrayList<Bus> buses,
            ArrayList<Booking> bookings) {

        System.out.print("Enter Bus No: ");
        String busNo = scanner.nextLine();

        Bus selectedBus =
                AvailabilityChecker.findBus(buses, busNo);

        if (selectedBus == null) {
            LOGGER.warning("Bus not found!");
            return;
        }

        System.out.print("Enter Seats Required: ");
        int seats = readInt(scanner);

        if (!AvailabilityChecker.checkSeats(selectedBus, seats)) {
            LOGGER.warning("Not enough seats available!");
            return;
        }

        System.out.print("Enter Passenger Name: ");
        String passengerName = scanner.nextLine();

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        Passenger passenger =
                new Passenger(passengerName, phone);

        selectedBus.reduceSeats(seats);

        bookings.add(
                new Booking(passenger, seats, busNo));

        LOGGER.info("Booking Successful!");
    }

    private static void viewBookings(
            ArrayList<Booking> bookings) {

        if (bookings.isEmpty()) {
            LOGGER.info("No bookings found.");
            return;
        }

        LOGGER.info("--- BOOKING DETAILS ---");

        for (Booking booking : bookings) {
            booking.display();
        }
    }

    private static void cancelBooking(
            Scanner scanner,
            ArrayList<Bus> buses,
            ArrayList<Booking> bookings) {

        if (bookings.isEmpty()) {
            LOGGER.info("No bookings to cancel.");
            return;
        }

        System.out.print(
                "Enter Passenger Name to Cancel: ");

        String cancelName = scanner.nextLine();

        Booking bookingToCancel = null;

        for (Booking booking : bookings) {
            if (booking.getPassengerName()
                    .equalsIgnoreCase(cancelName)) {

                bookingToCancel = booking;
                break;
            }
        }

        if (bookingToCancel == null) {
            LOGGER.warning("Booking not found!");
            return;
        }

        Bus busToRestore =
                AvailabilityChecker.findBus(
                        buses,
                        bookingToCancel.getBusNo());

        if (busToRestore != null) {
            busToRestore.restoreSeats(
                    bookingToCancel.getSeatAmount());
        }

        bookings.remove(bookingToCancel);

        LOGGER.info(
                "Booking Cancelled Successfully!");
    }

    private static boolean adminLogin(
            Scanner scanner,
            Admin admin) {

        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        if (admin.login(username, password)) {
            LOGGER.info("Admin login successful!");
            return true;
        }

        LOGGER.warning(
                "Incorrect username or password.");
        return false;
    }
}