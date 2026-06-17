package bus_reservation_system;

// Base class for all vehicles
public abstract class Vehicle {

    // Vehicle number
    protected String vehicleNo;

    // Number of seats
    protected int seatCount;

    // Constructor
public abstract class Vehicle {

    // Unique identifier of the vehicle (e.g., bus number)
    protected String vehicleNo;

    // Total number of seats available in the vehicle
    protected int seatCount;

    protected Vehicle(String vehicleNo, int seatCount) {
        this.vehicleNo = vehicleNo;
        this.seatCount = seatCount;
    }

    // Get vehicle number
    public String getVehicleNo() {
        return vehicleNo;
    }

    // Get seat count
    public int getSeatCount() {
        return seatCount;
    }

    // Display vehicle details
    public abstract void display();
}