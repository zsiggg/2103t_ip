import java.io.IOException;

public abstract class AddCommand extends Command {
    protected Task task;

    public AddCommand(String command, Task task) {
        super(command);
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList, Storage storage) throws IOException {
        taskList.add(this.task, super.command, storage);
    }

    @Override
    public void execute(TaskList taskList, Storage storage, Ui ui) {
        try {
            this.execute(taskList, storage);
        } catch (IOException e) {
            ui.println(e.getMessage());
            return;
        }
        ui.printWithDivider(String.format("Got it. I've added this task:\n  %s", this.task.toString()));
    }
}
