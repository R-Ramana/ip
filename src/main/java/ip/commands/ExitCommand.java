package ip.commands;

import ip.ui.Ui;

public class ExitCommand extends Command {

    public ExitCommand() {
        isExit = true;
    }

    /**
     * Prints goodbye message if user inputs "bye"
     *
     * @param ui User Interface Object
     */
    @Override
    public void execute(Ui ui) {
        Ui.printFarewellMessage();
    }
}
