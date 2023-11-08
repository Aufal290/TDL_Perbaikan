import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> taskList = new ArrayList<>();

    public void addTask(String description, String deadline) {
        Task task = new Task(description, deadline);
        taskList.add(task);
    }

    public void addPriorityTask(String description, String deadline, int priority) {
        PriorityTask task = new PriorityTask(description, deadline, priority);
        taskList.add(task);
    }

    public boolean removeTask(int number) {
        if (number >= 1 && number <= taskList.size()) {
            taskList.remove(number - 1);
            return true;
        }
        return false;
    }

    public List<Task> getTaskList() {
        return taskList;
    }
}
