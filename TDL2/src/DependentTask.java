public class DependentTask extends Task {
    private int dependent;

    public DependentTask(String description, String deadline, int dependent) {
        super(description, deadline);
        this.dependent = dependent;
    }

    public int getDependent() {
        return dependent;
    }

    public void setDependent(int dependent) {
        this.dependent = dependent;
    }
}