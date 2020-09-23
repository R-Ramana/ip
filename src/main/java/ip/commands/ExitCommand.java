package ip.commands;

public class ExitCommand extends Command {
    public static final String EXIT_COMMAND = "bye";

    public ExitCommand() {
        isExit = true;
    }
}
