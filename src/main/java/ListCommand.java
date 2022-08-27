public class ListCommand extends Command {
    public ListCommand(String command) {
        super(command);
    }

    @Override
    public void execute(TaskList taskList) {
        return;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        String s = taskList.toString();
        if (s.isEmpty()) {
            ui.println("🙁 OOPS!!! There are no tasks in your list yet.");
        } else {
            ui.printWithDivider(String.format("Here are the tasks in your list:\n%s", s));
        }
    }
}