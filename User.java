package bus_reservation_system;

public abstract class User {
    protected String name;
    protected String phone;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public abstract void displayInfo();
}
