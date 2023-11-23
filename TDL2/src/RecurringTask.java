public class RecurringTask extends Task {
    private int recurringInterval;

    public RecurringTask(String description, String deadline, int recurringInterval) {
        super(description, deadline);
        this.recurringInterval = recurringInterval;
    }

    public int getRecurringInterval() {
        return recurringInterval;
    }

    public void setRecurringInterval(int recurringInterval) {
        this.recurringInterval = recurringInterval;
    }

    @Override
    public void displayTaskDetails() {
        System.out.println("Deskripsi: " + getDescription());
        System.out.println("Deadline: " + getDeadline());
        System.out.println("Interval Berulang: " + getRecurringInterval());
    }
}