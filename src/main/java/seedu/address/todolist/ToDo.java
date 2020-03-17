package seedu.address.todolist;

/**
 * Returns an extended type of Task, To Dos, where general tasks are added
 */

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
