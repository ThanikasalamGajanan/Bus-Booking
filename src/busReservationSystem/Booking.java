package busReservationSystem;

import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents a booking in the bus reservation system.
 */
public class Booking {

    private static final Logger LOGGER =
            Logger.getLogger(Booking.class.getName());

    private static final String SEPARATOR =
            "-----------------------------------";

    private final Passenger passenger;
    private final int seatAmount;
    private final String busNo;

    /**
     * Creates a booking.
     *
     * @param passenger the passenger
     * @param seatAmount number of seats booked
     * @param busNo bus number
     */
    public Booking(final Passenger passenger,
                   final int seatAmount,
                   final String busNo) {

        this.passenger = Objects.requireNonNull(
                passenger, "Passenger cannot be null");

        this.busNo = Objects.requireNonNull(
                busNo, "Bus number cannot be null").trim();

        if (seatAmount <= 0) {
            throw new IllegalArgumentException(
                    "Seat amount must be greater than zero");
        }

        this.seatAmount = seatAmount;
    }

    /**
     * Displays booking information.
     */
    public void display() {
        passenger.displayInfo();
        LOGGER.info(() -> "Seats Booked: " + seatAmount);
        LOGGER.info(() -> "Bus Number: " + busNo);
        LOGGER.info(SEPARATOR);
    }

    public String getPassengerName() {
        return passenger.getName();
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public String getBusNo() {
        return busNo;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}