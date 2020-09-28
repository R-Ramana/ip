package ip.commands;

import ip.storage.Storage;
import ip.task.Task;
import ip.task.TaskManager;
import ip.ui.Ui;
import ip.ui.exception.ExceptionMessage;

public class DoneCommand extends Command {

    private final int taskId;

    /**
     * Constructor to set Task ID
     *
     * @param taskId Task ID
     */
    public DoneCommand(int taskId) {
        this.taskId = taskId;
    }

    /**
     * Checks to ensure ID is within the bounds
     * If so, it marks the task as completed, update the file (duke.txt) and prints out a confirmation message.
     *
     * @param ui User Interface Object
     */
    @Override
    public void execute(Ui ui) {
        Task task;
        // Check that id is valid
        try {
            task = TaskManager.markAsDone(taskId);
        } catch (IndexOutOfBoundsException e) {
            ExceptionMessage.printNoTaskIdMessage();
            return;
        }

        Storage.replaceDoneStatus(task.getDescription());
        Ui.printDoneMessage(task);
    }
}
