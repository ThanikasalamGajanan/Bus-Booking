package busReservationSystem;

import java.util.Objects;

/**
 * Abstract base class representing a system user.
 */
public abstract class User {

    private final String name;
    private final String phone;

    /**
     * Creates a new user.
     *
     * @param name  user's name
     * @param phone user's phone number
     * @throws NullPointerException if name or phone is null
     */
    protected User(String name, String phone) {
        this.name = Objects.requireNonNull(name, "Name cannot be null").trim();
        this.phone = Objects.requireNonNull(phone, "Phone cannot be null").trim();
    }

    /**
     * Returns the user's name.
     *
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the user's phone number.
     *
     * @return phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Displays user information.
     */
    public abstract void displayInfo();
}