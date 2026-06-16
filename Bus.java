package bus_reservation_system;

import java.util.logging.Logger;

public class Bus extends Vehicle {

    private static final Logger LOGGER = Logger.getLogger(Bus.class.getName());

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
        LOGGER.info("-----------------------------------");
        LOGGER.info("Bus No: " + vehicleNo);
        LOGGER.info("Route: " + route);
        LOGGER.info("Type: " + type);
        LOGGER.info("Seats Available: " + seatCount);
        LOGGER.info("Normal Price: " + normalPrice);
        LOGGER.info("Full Price: " + fullPrice);
        LOGGER.info("-----------------------------------");
    }
}