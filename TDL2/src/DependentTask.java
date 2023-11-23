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

    @Override
    public void displayTaskDetails() {
        System.out.println("Deskripsi: " + getDescription());
        System.out.println("Deadline: " + getDeadline());
        System.out.println("Tugas yang Bergantung: " + getDependent());
    }
}