package bus_reservation_system;

public class Passenger extends User {

    public Passenger(String name, String phone) {
        super(name, phone);
    }

    @Override
    public void displayInfo() {
        System.out.println("Passenger Name: " + name + ", Phone: " + phone);
    }
}
