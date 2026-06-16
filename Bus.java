package bus_reservation_system;

import java.util.logging.Logger;

public class Bus extends Vehicle {

    private static final Logger LOGGER = Logger.getLogger(Bus.class.getName());

    private final String route;
    private final String type;
    private final int normalPrice;
    private final int fullPrice;

    public Bus(String busNo, int seatCount, String route, String type,
               int normalPrice, int fullPrice) {

        super(busNo, seatCount);

        this.route = route;
        this.type = type;
        this.normalPrice = normalPrice;
        this.fullPrice = fullPrice;
    }

    public void reduceSeats(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        seatCount -= amount;
    }

    public void restoreSeats(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        seatCount += amount;
    }

    public String getRoute() {
        return route;
    }

    public String getType() {
        return type;
    }

    public int getNormalPrice() {
        return normalPrice;
    }

    public int getFullPrice() {
        return fullPrice;
    }

    @Override
    public void display() {
        LOGGER.info(() ->
                "\n-----------------------------------" +
                        "\nBus No: " + vehicleNo +
                        "\nRoute: " + route +
                        "\nType: " + type +
                        "\nSeats Available: " + seatCount +
                        "\nNormal Price: " + normalPrice +
                        "\nFull Price: " + fullPrice +
                        "\n-----------------------------------"
        );
    }
}