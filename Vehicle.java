package busReservationSystem;

public abstract class Vehicle {
    protected String vehicleNo;
    protected int seatCount;

    protected Vehicle(String vehicleNo, int seatCount) {
        this.vehicleNo = vehicleNo;
        this.seatCount = seatCount;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public abstract void display();
}
