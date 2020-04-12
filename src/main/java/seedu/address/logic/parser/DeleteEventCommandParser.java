package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_INDEX;

import java.util.stream.Stream;

import seedu.address.logic.commands.taskcommand.deletecommand.DeleteEventCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.calender.Task;



/**
 * Parses input arguments and creates a new DeleteModuleCommand object
 */

public class DeleteEventCommandParser implements Parser<DeleteEventCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns an DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */

    @Override
    public DeleteEventCommand parse(String args) throws ParseException {

        ArgumentMultimap argMultimap1 =
            ArgumentTokenizer.tokenize(args, PREFIX_TASK_INDEX);

        if (arePrefixesPresent(argMultimap1, PREFIX_TASK_INDEX)
                && argMultimap1.getPreamble().isEmpty()) {
            Task event = ParserUtil.parseRemoveEvent(argMultimap1.getValue(PREFIX_TASK_INDEX).get());
            return new DeleteEventCommand(event);
        } else {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    DeleteEventCommand.MESSAGE_USAGE));
        }
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
