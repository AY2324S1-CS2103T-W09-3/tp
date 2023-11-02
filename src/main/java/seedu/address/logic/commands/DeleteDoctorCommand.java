package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.doctor.Doctor;
import seedu.address.model.person.Person;
import seedu.address.model.timeslots.Timeslot;

/**
 * Deletes a doctor identified using its displayed index in the clinic records.
 */
public class DeleteDoctorCommand extends Command {

    public static final String COMMAND_WORD = "delete_doctor";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the doctor with the index number used in the clinic records.\n"
            + "Parameters: INDEX (must be a positive integer in the list)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_DOCTOR_SUCCESS = "Deleted Doctor: %1$s from clinic records";

    private final Index targetIndex;

    public DeleteDoctorCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();
        List<Doctor> doctorList = model.getFilteredDoctorList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_DOCTOR_DISPLAYED_INDEX);
        }

        Doctor doctorToDelete = doctorList.get(targetIndex.getZeroBased());
        model.deleteDoctor(doctorToDelete);

        ArrayList<Appointment> doctorAppointments = doctorToDelete.getAppointments();
        for (Appointment appointment : doctorAppointments) {
            model.deleteAppointment(appointment);
            Person patient = appointment.getPatient();
            int appointmentIndex = patient.getAppointments().indexOf(appointment);
            patient.deleteAppointment(appointmentIndex);

            Timeslot timeslotToAdd = new Timeslot(appointment.getDateTime().toLocalDate(),
                    appointment.getDateTime().getHour());
            model.addAvailableTimeSlot(timeslotToAdd);
        }

        return new CommandResult(String.format(MESSAGE_DELETE_DOCTOR_SUCCESS, Messages.formatDoctor(doctorToDelete)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeleteDoctorCommand)) {
            return false;
        }

        DeleteDoctorCommand otherDeleteDoctorCommand = (DeleteDoctorCommand) other;
        return targetIndex.equals(otherDeleteDoctorCommand.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}