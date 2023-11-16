public class UrgentTask extends Task {
    private int urgent;

    public UrgentTask(String description, String deadline, int urgent) {
        super(description, deadline);
        this.urgent = urgent;
    }

    public int getUrgent() {
        return urgent;
    }

    public void setUrgent(int urgent) {
        this.urgent = urgent;
    }
}