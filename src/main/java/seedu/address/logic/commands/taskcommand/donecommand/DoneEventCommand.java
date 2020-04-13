package seedu.address.logic.commands.taskcommand.donecommand;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.calender.Task;

/**
 * Mark an event in calendar as done.
 */

public class DoneEventCommand extends DoneCommand {
    public static final String MESSAGE_SUCCESS = "Event done: ";
    public static final String MESSAGE_FAIL = "No such event exists";

    private final Task eventDone;

    public DoneEventCommand(Task eventDone) {
        requireNonNull(eventDone);
        this.eventDone = eventDone;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (Task.getEventList().size() < eventDone.getIndex()) {
            return new CommandResult(MESSAGE_FAIL);
        }

        List<Task> lastShownList = model.getEventList();
        Task completed = lastShownList.get(eventDone.getIndex() - 1);
        completed.markAsDone();

        model.sortEventList();
        model.updateEventList(Model.PREDICATE_SHOW_ALL_TASK);

        return new CommandResult(MESSAGE_SUCCESS + completed);
    }
}
