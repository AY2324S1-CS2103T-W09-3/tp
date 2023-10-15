package seedu.address.model.util;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                    new Gender("M"), new Age(21), Ethnicity.valueOf("Chinese"),
                        new Nric("T1341367E"), new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                    new Gender("F"), new Age(16), Ethnicity.valueOf("Chinese"),
                        new Nric("T1231437E"), new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                    new Gender("F"), new Age(60), Ethnicity.valueOf("Eurasian"),
                        new Nric("T5443267E"), new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                    new Gender("M"), new Age(55), Ethnicity.valueOf("Chinese"),
                        new Nric("T1290127E"), new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                    new Gender("M"), new Age(42), Ethnicity.valueOf("Malay"),
                        new Nric("T1432567E"), new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                    new Gender("M"), new Age(33), Ethnicity.valueOf("Indian"),
                        new Nric("T1236312E"), new Address("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    public static Set<Appointment> getAppointmentSet(String... strings) {
        if (strings.length % 2 != 0) {
            throw new IllegalArgumentException("Arguments must be provided in pairs (details, LocalDateTime).");
        }

        Set<Appointment> appointments = new HashSet<>();

        for (int i = 0; i < strings.length; i += 2) {
            String details = strings[i];
            LocalDateTime dateTime = LocalDateTime.parse(strings[i + 1]); // Parse the string to LocalDateTime
            appointments.add(new Appointment(details, dateTime));
        }

        return appointments;
    }

}
