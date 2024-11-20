package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Person implements Serializable {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate brithdate;

    public Person() {
        this.id = UUID.randomUUID();
    }
    public Person(String firstName, String lastName, String phone, LocalDate brithdate) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.brithdate = brithdate;

    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public LocalDate getBrithdate() {
        return brithdate;
    }
    public void setBrithdate(LocalDate brithdate) {
        this.brithdate = brithdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return brithdate == person.brithdate && id.equals(person.id) && firstName.equals(person.firstName) && lastName.equals(person.lastName) && phone.equals(person.phone);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName +'\''
                + ", lastName='" + lastName +'\''
                + ", phone='" + phone +'\''
                + ", brithdate=" + brithdate + '\'' +
                "}";
    }
}
