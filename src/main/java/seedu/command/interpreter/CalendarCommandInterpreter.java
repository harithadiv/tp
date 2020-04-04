package seedu.command.interpreter;

import seedu.command.Command;
import seedu.command.calendar.AddSemester;
import seedu.event.EventList;
import seedu.exception.PacException;
import seedu.parser.CalendarParser;

public class CalendarCommandInterpreter extends CommandInterpreter {
    public CalendarCommandInterpreter(EventList eventList) {
        super(eventList);
    }

    @Override
    public Command decideCommand(String commandDescription) throws PacException {
        Command command;
        String description = commandDescription.toLowerCase();
        int semester = CalendarParser.getSemester(description);
        int year = CalendarParser.getYear(description, semester);

        switch (semester) {
        case 1:
        case 2:
            command = new AddSemester(eventList, year, semester);
            break;
        default:
            throw new PacException("Please give a valid semester number: s/1, s/2");
        }
        return command;
    }

}
