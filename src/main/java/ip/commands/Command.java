package ip.commands;

import ip.ui.exception.DukeException;
import ip.filemanager.FileManager;
import ip.ui.Ui;

public class Command {
    protected boolean isExit = false;

    public void execute(Ui ui, TaskList tasks, Storage... storage) throws DukeException {
        FileManager.writeToFile();
    }

    public boolean getIsExit() {
        return isExit;
    }
}
