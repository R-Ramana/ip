package ip.commands;

import ip.storage.Storage;
import ip.task.Task;
import ip.task.TaskManager;
import ip.ui.Ui;
import ip.ui.exception.ExceptionMessage;

import java.io.IOException;

public class DeleteCommand extends Command {

    private final int num;

    public DeleteCommand(int num) {
        this.num = num;
    }

    /**
     * Checks to ensure ID is within the bounds
     * If so, removes the task, updates the file (duke.txt) and prints out a confirmation message.
     *
     * @param ui User Interface object
     */
    @Override
    public void execute(Ui ui) {
        Task task;
        try {
            task = TaskManager.deleteTask(num);
            Storage.removeLine(task.getDescription());
        } catch (IndexOutOfBoundsException | IOException e) {
            ExceptionMessage.printNoTaskIdMessage();
            return;
        }

        Ui.printDeleteMessage(task);
    }
}
