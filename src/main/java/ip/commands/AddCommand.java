package ip.commands;

import ip.storage.Storage;
import ip.task.Task;
import ip.task.TaskManager;
import ip.ui.Ui;
import ip.ui.exception.DukeException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AddCommand extends Command {
    private char command;
    private String description;
    private String duration;
    private LocalDate date;
    private LocalTime time;

    /**
     * Takes in a char for command (D for deadline and E for Event)
     * Sets the command, description, date and time.
     *
     * @param command D, E to distinguish what type of task to add
     * @param description Task description
     * @param date task deadline/start date (might be null)
     * @param time task deadline/start time (might be null)
     */
    public AddCommand(char command, String description, String duration, LocalDate date, LocalTime time) {
        this.command = command;
        this.description = description;
        this.duration = duration;
        this.date = date;
        this.time = time;
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
     * Deadline and Event cases formats date and time if it was inputted by the user.
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
            String updatedDuration = duration;
            if(date != null && time != null ) {
                String updatedDate = date.format(DateTimeFormatter.ofPattern("MMM dd, YYYY"));
                String updatedTime = time.format(DateTimeFormatter.ISO_LOCAL_TIME);
                updatedDuration = updatedDate + " " + updatedTime;
            }
            task = TaskManager.addDeadline(description, updatedDuration);
            Storage.writeToFile(task.getIsDone(), command, description, updatedDuration);
            break;
        case 'E':
            updatedDuration = duration;
            if(date != null && time != null ) {
                String updatedDate = date.format(DateTimeFormatter.ofPattern("MMM dd, YYYY"));
                String updatedTime = time.format(DateTimeFormatter.ISO_LOCAL_TIME);
                updatedDuration = updatedDate + " " + updatedTime;
            }
            task = TaskManager.addEvent(description, updatedDuration);
            Storage.writeToFile(task.getIsDone(), command, description, updatedDuration);
            break;
        default:
            throw new DukeException("Invalid command. Please try again!");
        }

        ui.printAddTaskMessage(task);
    }

}