package work.with.exceptions.HWexceptions;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " "+lastName;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee employee1 = (Employee) other;
        return lastName.equals(employee1.lastName) && firstName.equals(employee1.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName + lastName);
    }
}
