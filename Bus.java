 package bus_reservation_system;;

public class Bus extends Vehicle {

    private String route;
    private String type;
    private int normalPrice;
    private int fullPrice;

    public Bus(String busNo, int seatCount, String route, String type,
               int normalPrice, int fullPrice) {
        super(busNo, seatCount);
        this.route = route;
        this.type = type;
        this.normalPrice = normalPrice;
        this.fullPrice = fullPrice;
    }

    public void reduceSeats(int amount) {
        seatCount -= amount;
    }

    public void restoreSeats(int amount) {
        seatCount += amount;
    }

    @Override
    public void display() {
        System.out.println("-----------------------------------");
        System.out.println("Bus No: " + vehicleNo);
        System.out.println("Route: " + route);
        System.out.println("Type: " + type);
        System.out.println("Seats Available: " + seatCount);
        System.out.println("Normal Price: " + normalPrice);
        System.out.println("Full Price: " + fullPrice);
        System.out.println("-----------------------------------");
    }
}
