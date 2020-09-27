package ip.commands;

import ip.task.Task;
import ip.task.TaskManager;
import ip.ui.Ui;
import ip.ui.exception.ExceptionMessage;

import java.util.ArrayList;

public class FindCommand extends Command {

    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword.toUpperCase();
    }

    @Override
    public void execute(Ui ui) {

        // Ensure no blank keyword
        if(keyword == "") {
            ExceptionMessage.printNoDescriptionExceptionMessage();
            return;
        }

        ArrayList<Task> tasks = TaskManager.findTasks(keyword);
        Ui.printFilterTaskMessage(tasks);
    }
}
