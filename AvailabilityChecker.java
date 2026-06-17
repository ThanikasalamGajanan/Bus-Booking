package busReservationSystem;

import java.util.ArrayList;

// Used to check bus availability
public class AvailabilityChecker {

    // Find a bus using its number
    public static Bus findBus(ArrayList<Bus> buses, String busNo) {
        for (Bus b : buses) {

            // Check whether the bus number matches
            if (b.getVehicleNo().equals(busNo)) {
                return b;
            }
        }

        // Bus not found
        return null;
    }

    // Check if enough seats are available
    public static boolean checkSeats(Bus bus, int seatsRequested) {

        // Return true if seats are sufficient
        return bus != null && bus.getSeatCount() >= seatsRequested;
    }
}