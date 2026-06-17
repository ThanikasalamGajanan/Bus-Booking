package bus_reservation_system;

/**
 * Abstract base class representing a vehicle in the reservation system.
 * Common properties such as vehicle number and seat count are defined here.
 * Specific vehicle types must implement the display() method.
 */
public abstract class Vehicle {

    // Unique identifier of the vehicle (e.g., bus number)
    protected String vehicleNo;

    // Total number of seats available in the vehicle
    protected int seatCount;

    /**
     * Creates a Vehicle object with the given vehicle number and seat capacity.
     *
     * @param vehicleNo Unique vehicle number
     * @param seatCount Total seating capacity of the vehicle
     */
    protected Vehicle(String vehicleNo, int seatCount) {
        this.vehicleNo = vehicleNo;
        this.seatCount = seatCount;
    }

    /**
     * Returns the vehicle number.
     *
     * @return vehicle number
     */
    public String getVehicleNo() {
        return vehicleNo;
    }

    /**
     * Returns the total seat capacity of the vehicle.
     *
     * @return number of seats
     */
    public int getSeatCount() {
        return seatCount;
    }

    /**
     * Displays vehicle details.
     * Must be implemented by all subclasses.
     */
    public abstract void display();
}