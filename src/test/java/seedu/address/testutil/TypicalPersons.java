package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

import static seedu.address.logic.commands.CommandTestUtil.*;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withGender("F")
            .withAge(12)
            .withEthnic("Eurasian")
            .withNric("T1234567E")
            .withPhone("94351253")
            .withTags("friends").build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier")
            .withPhone("98765432")
            .withEmail("johnd@example.com")
            .withGender("M")
            .withAge(42)
            .withEthnic("Eurasian")
            .withNric("T0000000Z")
            .withAddress("123 NUS DRIVE")
            .withTags("owesMoney", "friends")
            .withAppointments("appointment1 details", "01-01-2024").build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com")
            .withGender("M")
            .withAge(22)
            .withEthnic("Eurasian")
            .withNric("T1234567E").withAddress("wall street").build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com")
            .withGender("M")
            .withAge(25)
            .withEthnic("Chinese")
            .withNric("T1234567E").withAddress("10th street").withTags("friends").build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com")
            .withGender("F")
            .withAge(32)
            .withEthnic("Eurasian")
            .withNric("T1234567E").withAddress("michegan ave").build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com")
            .withGender("F")
            .withAge(120)
            .withEthnic("Malay")
            .withNric("T1234567E")
            .withAddress("little tokyo").build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com")
            .withGender("M")
            .withAge(100)
            .withEthnic("Indian")
            .withNric("T1234567E").withAddress("4th street").build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com")
            .withGender("F")
            .withAge(0)
            .withEthnic("Chinese")
            .withNric("T1234567E").withAddress("little india").build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com")
            .withGender("F")
            .withAge(12)
            .withEthnic("Eurasian")
            .withNric("T1234567E").withAddress("chicago ave").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY)
            .withGender(VALID_GENDER_AMY)
            .withAge(VALID_AGE_AMY)
            .withEthnic(VALID_ETHNIC_AMY)
            .withNric(VALID_NRIC_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB)
            .withGender(VALID_GENDER_BOB)
            .withAge(VALID_AGE_BOB)
            .withEthnic(VALID_ETHNIC_BOB)
            .withNric(VALID_NRIC_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
