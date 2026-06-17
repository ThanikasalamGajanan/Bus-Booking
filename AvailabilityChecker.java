package bus_reservation_system;

import java.util.ArrayList;

public class AvailabilityChecker {

    public static Bus findBus(ArrayList<Bus> buses, String busNo) {
        for (Bus b : buses) {
            if (b.getVehicleNo().equals(busNo)) {
                return b;
            }
        }
        return null;
    }

    public static boolean checkSeats(Bus bus, int seatsRequested) {
        return bus != null && bus.getSeatCount() >= seatsRequested;
    }
}
