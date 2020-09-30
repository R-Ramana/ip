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

    /**
     * Calls the method to filter tasks that contain a keyword and returns that newly narrowed ArrayList
     * Prints out the narrowed Task List
     * Filters out to ensure no blank keyword is inputted
     *
     * @param ui User Interface Object
     */
    @Override
    public void execute(Ui ui) {

        // Ensure no blank keyword when finding for Tasks
        if(keyword.isBlank()) {
            ExceptionMessage.printNoDescriptionExceptionMessage();
            return;
        }

        ArrayList<Task> tasks = TaskManager.findTasks(keyword);
        Ui.printFilterTaskMessage(tasks);
    }
}
