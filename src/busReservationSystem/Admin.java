package busReservationSystem;

public class Admin {

    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";



    public boolean login(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public void displayInfo() {};
}
