package seedu.address.model.calender;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * <h1> Event Class </h1>
 * Returns an extended type of Task, Event, where events can be scheduled onto the calender
 */

public class Event extends Task {

    public static final String MESSAGE_CONSTRAINTS = "Please enter valid Date in the format DD-MM-YYYY";
    protected String on;
    protected String operation;
    protected int index;

    /**
     * Constructor for task class
     *
     * @param description describes content of event
     * @param on describes the date the event is scheduled on
     */
    public Event(String description, String on, String operation) {
        super(description);
        requireAllNonNull(operation);
        this.on = on;
        this.operation = operation;
    }

    public Event(int index, String operation) {
        super("Delete task");
        requireAllNonNull(operation);
        this.index = index;
        this.operation = operation;
    }

    /**
     * dummy docs.
     * @param date
     * @return
     */
    public static boolean isValidDate(String date) {

        try {
            String[] splittedDate = date.split("-");
            int month = Integer.parseInt(splittedDate[1]);
            int day = Integer.parseInt(splittedDate[0]);

            if (month < 1 || month > 12) {
                return false;
            }

            if (day < 1 || day > 31) {
                return false;
            }

            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    @Override
    public String getDate() {
        return this.on;
    }

    @Override
    public String getOperation() {
        return this.operation;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + on + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Event)) {
            return false;
        }

        Event otherTask = (Event) other;
        System.out.println(otherTask.getDescription().equals(getDescription()));
        System.out.println(otherTask.getDate().equals(this.getDate()));
        return otherTask.getDescription().equals(getDescription())
                && otherTask.getDate().equals(this.getDate());

    }
}
