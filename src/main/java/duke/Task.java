package duke;

/**
 * Tack class.
 * ToDo, Deadline, and Event classes inherit from this class.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for Task.
     *
     * @param description The content of the task entered by users.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public boolean getStatus() {
        return isDone;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Returns the status and content of tasks.
     *
     * @return A string of task information.
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Mark the status of the task to be done.
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Mark the status of the task to be incompleted.
     */
    public void unmark() {
        this.isDone = false;
    }
}
