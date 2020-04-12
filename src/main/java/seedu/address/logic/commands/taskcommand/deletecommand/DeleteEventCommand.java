package seedu.address.logic.commands.taskcommand.deletecommand;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.calender.Task;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TASK;

/**
 * Deletes an event.
 */

public class DeleteEventCommand extends DeleteTaskCommand {
    public static final String COMMAND_WORD = "eventDelete";
    public static final String MESSAGE_SUCCESS = "Event Deleted: ";
    public static final String MESSAGE_FAIL = "No such event exists";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Delete event. Format of input should be:"
            + " eventDelete index/{num} "
            + "Example: eventDelete index/2\n";

    private final Task eventToDelete;

    public DeleteEventCommand(Task eventToDelete) {
        requireNonNull(eventToDelete);
        this.eventToDelete = eventToDelete;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (Task.getEventList().size() < eventToDelete.getIndex()) {
            return new CommandResult(MESSAGE_FAIL);
        }

        List<Task> lastShownList = model.getEventList();
        Task removed = lastShownList.get(eventToDelete.getIndex() - 1);
        model.deleteEvent(removed);

        model.sortEventList();
        model.updateEventList(PREDICATE_SHOW_ALL_TASK);

        return new CommandResult(MESSAGE_SUCCESS + removed);
    }

    public Task getEventToDelete() {
        return this.eventToDelete;
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteEventCommand // instanceof handles nulls
                && eventToDelete.equals(((DeleteEventCommand) other).getEventToDelete()));
    }
}
