package ip.commands;

import ip.storage.Storage;
import ip.task.Task;
import ip.task.TaskManager;
import ip.ui.Ui;
import ip.ui.exception.ExceptionMessage;

public class DoneCommand extends Command {

    private final int taskId;

    public DoneCommand(int taskId) {
        this.taskId = taskId;
    }

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
