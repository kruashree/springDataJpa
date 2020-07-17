package io.pivotal.university.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
// @Embeddable annotation is used on a class whose instances are stored as a part of an owning entity.
// Each of the persistent properties or fields of the embedded object is mapped to the database table for the owner entity.
@Embeddable
public class Person {
    @Column
    private String firstName;

    @Column
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
