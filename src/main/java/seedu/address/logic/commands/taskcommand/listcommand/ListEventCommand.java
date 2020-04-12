package seedu.address.logic.commands.taskcommand.listcommand;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;

public class ListEventCommand extends Command {

    public static final String MESSAGE_SUCCESS = "Listed all Events";
    public static final String COMMAND_WORD = "listEvent";


    public ListEventCommand() {
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.updateEventList(Model.PREDICATE_SHOW_ALL_TASK);

        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {

        return false;
    }
}
