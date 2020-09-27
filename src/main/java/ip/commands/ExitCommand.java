package ip.commands;

import ip.ui.Ui;

public class ExitCommand extends Command {

    public ExitCommand() {
        isExit = true;
    }

    @Override
    public void execute(Ui ui) {
        Ui.printFarewellMessage();
    }
}
