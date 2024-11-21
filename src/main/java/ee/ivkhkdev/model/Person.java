package ee.ivkhkdev.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Person implements Serializable {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate birthdate;
    private String gender;
    private String bank;

    public Person() {
        this.id = UUID.randomUUID();
    }
    public Person(String firstName, String lastName, String phone, LocalDate brithdate, String gender, String bank) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.birthdate = brithdate;
        this.gender = gender;
        this.bank = bank;


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
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return birthdate == person.birthdate && id.equals(person.id) && firstName.equals(person.firstName) && lastName.equals(person.lastName) && phone.equals(person.phone) && gender.equals(person.gender) && bank.equals(person.bank);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + birthdate.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + bank.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName +'\''
                + ", lastName='" + lastName +'\''
                + ", phone='" + phone +'\''
                + ", brithdate=" + birthdate + '\'' +
                ", gender='" + gender + '\'' +
                ", bank='" + bank + '\'' +
                "}";
    }
}
