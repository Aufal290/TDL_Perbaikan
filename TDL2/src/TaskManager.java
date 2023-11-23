import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> taskList = new ArrayList<>();


    public void addRecurringTask(String tdlDescription, String tdlDeadline, int recurringInterval) {
        RecurringTask task = new RecurringTask(tdlDescription, tdlDeadline, recurringInterval);
        taskList.add(task);
    }

    public void addDependentTask(String description, String deadline, int dependent) {
        DependentTask task = new DependentTask(description, deadline, dependent);
        taskList.add(task);
    }

    public void addUrgentTask(String description, String deadline, int urgent) {
        UrgentTask task = new UrgentTask(description, deadline, urgent);
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

    public void displayAllTasks() {
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("\nTask " + (i + 1));
            taskList.get(i).displayTaskDetails();
        }
    }

    public void addTask(String tdlDescription, String tdlDeadline) {
    }
}