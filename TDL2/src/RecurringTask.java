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
}
