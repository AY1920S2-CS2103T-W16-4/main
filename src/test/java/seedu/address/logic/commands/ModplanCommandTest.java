package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.ModPlanCommand.SWITCHED_MESSAGE;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class ModplanCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_switch_success() {
        CommandResult expectedCommandResult = new CommandResult(SWITCHED_MESSAGE, false, false, true);
        assertCommandSuccess(new ModPlanCommand(), model, expectedCommandResult, expectedModel);
    }
}
