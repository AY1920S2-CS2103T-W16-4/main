package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.todolist.ToDo;

/**
 * Adds a todo.
 */

public class AddToDoCommand extends Command {

    public static final String COMMAND_WORD = "todo";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds todo. Format of input should be:"
            + " todo <description> \n" + "Example: todo water plants";

    public static final String MESSAGE_SUCCESS = "Todo added: ";

    public static final String MESSAGE_INVALID = "Your todo seems to be empty!";


    private final ToDo todoToAdd;


    public AddToDoCommand(ToDo todoToAdd) {
        requireNonNull(todoToAdd);
        this.todoToAdd = todoToAdd;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.isEmptyToDo(todoToAdd)) {
            throw new CommandException("There is no task to be added!");
        }

        model.addToDo(todoToAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, todoToAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof seedu.address.logic.commands.AddToDoCommand // instanceof handles nulls
                && todoToAdd.equals(((seedu.address.logic.commands.AddToDoCommand) other).todoToAdd));
    }
}

