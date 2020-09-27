package ip.commands;

import ip.ui.Ui;
import ip.ui.exception.DukeException;

public class Command {
    protected boolean isExit = false;

    public void execute(Ui ui) throws DukeException {
        throw new DukeException("Error encountered. Please try again");
    }

    public boolean getIsExit() {
        return isExit;
    }
}
