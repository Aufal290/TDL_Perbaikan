public class Task {
    private String description;
    private String deadline;

    public Task(String description, String deadline) {
        this.description = description;
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
