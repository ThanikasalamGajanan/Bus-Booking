package busReservationSystem;

import java.util.ArrayList;

/**
 * Utility class responsible for checking bus availability
 * and validating seat requests.
 */

public class AvailabilityChecker {

    /**
     * Searches for a bus using its bus number.
     *
     * @param buses List of available buses
     * @param busNo Bus number to search for
     * @return Matching Bus object if found, otherwise null
     */

    public static Bus findBus(ArrayList<Bus> buses, String busNo) {
        for (Bus b : buses) {
            // Compare the given bus number with each bus in the list
            if (b.getVehicleNo().equals(busNo)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Checks whether the requested number of seats is available.
     *
     * @param bus            Selected bus
     * @param seatsRequested Number of seats requested by the passenger
     * @return true if enough seats are available, otherwise false
     */

    public static boolean checkSeats(Bus bus, int seatsRequested) {

        // Ensure the bus exists and has sufficient seats available
        return bus != null && bus.getSeatCount() >= seatsRequested;
    }
}
