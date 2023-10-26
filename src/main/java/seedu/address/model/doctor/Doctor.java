package seedu.address.model.doctor;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.person.Address;
import seedu.address.model.person.Age;
import seedu.address.model.person.Email;

import seedu.address.model.person.Gender;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
public class Doctor {
    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Gender gender;
    private final Age age;
    private final Address address;
    private ArrayList<Appointment> appointments = new ArrayList<>();

    /**
     * Every field must be present and not null.
     */
    public Doctor(Name name, Phone phone, Email email, Gender gender, Age age, Address address) {
        requireAllNonNull(name, phone, email, gender, age, address);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }


    public Gender getGender() {
        return gender;
    }
    public Age getAge() {
        return age;
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSameDoctor(Doctor otherDoctor) {
        if (otherDoctor == this) {
            return true;
        }

        return otherDoctor != null
                && otherDoctor.getName().equals(getName());
    }


    /**
     * Returns true if both persons have the same name, phone number and nric fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Doctor)) {
            return false;
        }

        Doctor otherDoctor = (Doctor) other;
        return name.equals(otherDoctor.name)
                && phone.equals(otherDoctor.phone)
                && email.equals(otherDoctor.email)
                && address.equals(otherDoctor.address);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, gender, age, address);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("gender", gender)
                .add("age", age)
                .add("address", address)
                .add("appointments", appointments)
                .toString();
    }

}