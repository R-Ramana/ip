package ip.commands;

import ip.task.Task;
import ip.ui.Ui;

public class ListCommand extends Command {
    private Task Task;

    @Override
    public void execute(Ui ui) {
        ui.printListTasksMessage(Task);
    }
}
