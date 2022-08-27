public class DeleteCommand extends Command {
    private Task task;
    private int taskIndex;
    private TaskList taskList;

    private DeleteCommand(String command, Task task, int taskIndex, TaskList taskList) {
        super(command);
        this.task = task;
        this.taskIndex = taskIndex;
        this.taskList = taskList;
    }

    public static DeleteCommand of(String command, TaskList taskList) throws IllegalArgumentException {
        int taskIndex;
        try {
            taskIndex = Parser.getTaskIndex(command, taskList);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("🙁 OOPS!!! Provide a number to delete a task.\n");
        }

        Task task;
        try {
            task = taskList.get(taskIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(
                    String.format(
                            "🙁 OOPS!!! Provide a valid number (from 1 to %d) to delete a task.\n", taskList.size())
            );
        }
        return new DeleteCommand(command, task, taskIndex, taskList);
    }

    @Override
    public void execute(TaskList tasklist) {
        this.taskList.remove(taskIndex);
    };

    @Override
    public void execute(TaskList tasklist, Ui ui) {
        this.execute(tasklist);
        ui.printWithDivider(String.format("Noted. I've removed this task:\n  %s", this.task.toString()));
    }
}