package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.timeslots.Timeslots;

/**
 * An UI component that displays information of a {@code Appointment}.
 */
public class TimeSlotCard extends UiPart<Region> {

    private static final String FXML = "TimeSlotCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Timeslots timeslots;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label date;
    @FXML
    private Label hour;

    /**
     * Creates a {@code AppointmentCode} with the given {@code Appointment} and index to display.
     */
    public TimeSlotCard(Timeslots timeslots, int displayedIndex) {
        super(FXML);
        this.timeslots = timeslots;
        id.setText(displayedIndex + ". ");
        date.setText(timeslots.getDate().toString());
        hour.setText(String.valueOf(timeslots.getHour()));
    }
}