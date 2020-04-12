package seedu.address.logic.commands.taskcommand.addcommand;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.calender.Task;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TASK;

/**
 * Adds an event
 */

public class AddEventCommand extends Command {
    public static final String COMMAND_WORD = "eventAdd";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds event. Format of input should be:"
            + " eventAdd desc/<description> on/{DD-MM-YYYY}\n "
            + "Example: eventAdd desc/NUS Open Day on/02-04-2020";

    public static final String MESSAGE_SUCCESS = "Event added: ";

    private final Task eventToAdd;

    public AddEventCommand (Task event) {
        requireNonNull(event);
        eventToAdd = event;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.isEmptyEvent(eventToAdd)) {
            throw new CommandException("There is no event to be added!");
        }

        model.addEvent(eventToAdd);
        model.sortEventList();
        model.updateEventList(PREDICATE_SHOW_ALL_TASK);
        return new CommandResult(MESSAGE_SUCCESS + eventToAdd);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddEventCommand // instanceof handles nulls
                && eventToAdd.equals(((AddEventCommand) other).eventToAdd));
    }
}
