package ip.commands;

import ip.ui.Ui;
import ip.ui.exception.DukeException;

public class Command {
    protected boolean isExit = false;

    /**
     * Child classes override this method.
     * Execute respective commands.
     *
     * @param ui User Interface Object
     * @throws DukeException
     */
    public void execute(Ui ui) throws DukeException {
        throw new DukeException("Error encountered. Please try again");
    }

    /**
     * Returns the status of isExit (only true if ExitCommand)
     *
     * @return isExit status
     */
    public boolean getIsExit() {
        return isExit;
    }
}
