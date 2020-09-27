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
