import java.util.ArrayList;

public class Person {

    private String firstName;
    private String lastName;
    private String house;

    public Person(String aFirstName, String aLastName, String aHouse) {
        this.firstName = aFirstName;
        this.lastName = aLastName;
        this.house = aHouse;

    }

    @Override
    public String toString() {
        return
                firstName +
                lastName +
                house;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



}
