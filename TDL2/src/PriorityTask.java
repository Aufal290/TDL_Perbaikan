public class PriorityTask extends Task {
    private int priority;

    public PriorityTask(String description, String deadline, int priority) {
        super(description, deadline);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
