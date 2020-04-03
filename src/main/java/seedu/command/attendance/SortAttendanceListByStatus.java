package seedu.command.attendance;

import seedu.attendance.AttendanceList;
import seedu.command.Command;
import seedu.exception.PacException;
import seedu.ui.UI;

/**
 * Class representing an attendance related command to sort the attendanceList of a specific event.
 * Sorts the attendanceList according to Status of the student, 'N' will be found before 'Y'.
 */
public class SortAttendanceListByStatus extends Command {

    protected UI ui;
    protected AttendanceList attendances;
    protected String eventName;

    public SortAttendanceListByStatus(AttendanceList attendances, String eventName) {
        this.eventName = eventName;
        this.attendances = attendances;
        this.ui = new UI();
    }

    /**
     * Method to sort an attendance list according to status.
     */
    private void sort() {
        if (attendances.isEmpty()) {
            UI.display("An empty list cannot be sorted");
        } else {
            attendances.sortByStatus();
            ui.sortAttendanceByStatus(eventName);
        }
    }

    @Override
    public void execute() throws PacException {
        sort();
    }
}
