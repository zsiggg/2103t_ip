public class ByeCommand extends Command {
    public ByeCommand(String command) {
        super(command);
    }

    @Override
    public void execute(TaskList taskList, Storage storage) {
        super.isExit = true;
    }

    @Override
    public void execute(TaskList taskList, Storage storage, Ui ui) {
        this.execute(taskList, storage);
        ui.printWithDivider("Bye. Hope to see you again soon!");
    }
}
