package busReservationSystem;

public class Booking {
    //manage passengers booking details and display them while need

    private Passenger passenger;
    private int seatAmount;
    private String busNo;

    public Booking(Passenger passenger, int seatAmount, String busNo) {
        this.passenger = passenger;
        this.seatAmount = seatAmount;
        this.busNo = busNo;
    }

    public void display() {
        passenger.displayInfo();
        System.out.println("Seats Booked: " + seatAmount);
        System.out.println("Bus Number: " + busNo);
        System.out.println("-----------------------------------");
    }

    public String getPassengerName() {
        return passenger.name;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public String getBusNo() {
        return busNo;
    }
}
