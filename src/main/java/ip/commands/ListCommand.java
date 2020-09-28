package ip.commands;

import ip.task.Task;
import ip.ui.Ui;

public class ListCommand extends Command {
    private Task Task;

    /**
     * Prints list of all available tasks in the ArrayList
     *
     * @param ui User Interface Object
     */
    @Override
    public void execute(Ui ui) {
        ui.printListTasksMessage();
    }
}
