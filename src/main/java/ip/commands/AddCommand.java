package ip.commands;

import ip.storage.Storage;
import ip.task.Task;
import ip.task.TaskManager;
import ip.ui.Ui;
import ip.ui.exception.DukeException;

public class AddCommand extends Command {
    private final char command;
    private final String description;
    private String duration;

    /**
     * Takes in a char for command (D for deadline and E for Event)
     * Sets the command, description and time.
     *
     * @param command D, E to distinguish what type of task to add
     * @param description Task description
     * @param duration Start Time if E and End Time if D
     */
    public AddCommand(char command, String description, String duration) {
        this.command = command;
        this.description = description;
        this.duration = duration;
    }

    /**
     * Takes in a char for command (T for todo)
     * Sets the command and description.
     *
     * @param command T to set it as a todo task
     * @param description Task description
     */
    public AddCommand(char command, String description) {
        this.command = command;
        this.description = description;
    }

    /**
     * Based on command [T, D, E], add a todo, deadline or event (Refer to TaskManager Class)
     * Updates the duke.txt file (refer ti Storage Class)
     * Prints confirmation message that the task has been added
     *
     * @param ui User Interface Object
     * @throws DukeException if invalid command
     */
    // Solution adapted from https://github.com/hughjazzman/ip/blob/master/src/main/java/ip/commands/AddCommand.java
    @Override
    public void execute(Ui ui) throws DukeException {
        Task task;

        switch(command){
        case 'T':
            task = TaskManager.addTodo(description);
            Storage.writeToFile(task.getIsDone(), command, description);
            break;
        case 'D':
            task = TaskManager.addDeadline(description, duration);
            Storage.writeToFile(task.getIsDone(), command, description, duration);
            break;
        case 'E':
            task = TaskManager.addEvent(description, duration);
            Storage.writeToFile(task.getIsDone(), command, description, duration);
            break;
        default:
            throw new DukeException("Invalid command. Please try again!");
        }

        ui.printAddTaskMessage(task);
    }

}