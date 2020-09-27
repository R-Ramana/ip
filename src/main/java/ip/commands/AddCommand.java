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

    public AddCommand(char command, String description, String duration) {
        this.command = command;
        this.description = description;
        this.duration = duration;
    }

    public AddCommand(char command, String description) {
        this.command = command;
        this.description = description;
    }

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