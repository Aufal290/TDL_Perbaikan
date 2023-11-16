import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        User user = new User(input);
        TaskManager taskManager = new TaskManager();
        String username = user.login();
        if (username != null) {
            System.out.println("Haloooooo " + username);
            viewTdl(input, taskManager);
        } else {
            System.out.println("Kamu siapa?.");
        }
    }

    public static void viewTdl(Scanner input, TaskManager taskManager) {
        while (true) {
            System.out.println("MENU : ");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Tambah Depent Task");
            System.out.println("3. Tambah Recurring Task");
            System.out.println("4. Tambah Urgent Task");
            System.out.println("5. Hapus Tugas");
            System.out.println("6. Tampilkan Tugas");
            System.out.println("7. Keluar");
            String choice = masuk(input, "Pilih");
    
            if (choice.equals("1")) {
                String tdlDescription = masuk(input, "Masukkan deskripsi tugas");
                String tdlDeadline = masuk(input, "Masukkan deadline tugas (dd/mm/yyyy)");
                taskManager.addTask(tdlDescription, tdlDeadline);

            } else if (choice.equals("2")) {
                String tdlDescription = masuk(input, "Masukkan deskripsi Dependent Task");
                String tdlDeadline = masuk(input, "Masukkan deadline Dependent Task (dd/mm/yyyy)");
                int dependent = Integer.parseInt(masuk(input, "Masukkan Tugas yang Bergantung (1-5)"));
                taskManager.addDependentTask(tdlDescription, tdlDeadline, dependent);

            } else if (choice.equals("3")) {
                String tdlDescription = masuk(input, "Masukkan deskripsi Recurring Task");
                String tdlDeadline = masuk(input, "Masukkan deadline Recurring Task (dd/mm/yyyy)");
                int recurringInterval = Integer.parseInt(masuk(input, "Masukkan Interval Berulang (1 untuk harian, 7 untuk mingguan)"));
                taskManager.addRecurringTask(tdlDescription, tdlDeadline, recurringInterval);

            } else if (choice.equals("4")) {
                String tdlDescription = masuk(input, "Masukkan deskripsi Urgent Task");
                String tdlDeadline = masuk(input, "Masukkan deadline Urgent Task (dd/mm/yyyy)");
                int urgent = Integer.parseInt(masuk(input, "Masukkan Tingkat Urgensi (1-5)"));
                taskManager.addUrgentTask(tdlDescription, tdlDeadline, urgent);

                
            } else if (choice.equals("5")) {
                int number = Integer.parseInt(masuk(input, "Masukkan nomor tugas yang ingin Anda hapus"));
                boolean removed = taskManager.removeTask(number);
                if (removed) {
                    System.out.println("Tugas berhasil dihapus.");
                } else {
                    System.out.println("Nomor tugas tidak ada.");
                }

            } else if (choice.equals("6")) {
                System.out.println("Daftar Tugas:");
                List<Task> tasks = taskManager.getTaskList();
                for (int i = 0; i < tasks.size(); i++) {
                    Task task = tasks.get(i);
                    if (task instanceof UrgentTask) {
                        UrgentTask priorityTask = (UrgentTask) task;
                        System.out.println((i + 1) + ". " + task.getDescription() + " (Deadline: " + task.getDeadline() + ", Prioritas: " + priorityTask.getUrgent() + ")");
                    } else {
                        System.out.println((i + 1) + ". " + task.getDescription() + " (Deadline: " + task.getDeadline() + ")");
                    }
                }

            } else if (choice.equals("7")) {
                System.out.println("dadahhh");
                break;
            } else {
                System.out.println("Pilihan tidak ada");
            }
        }
    }
    
    public static String masuk(Scanner input, String info) {
        System.out.println(info + " : ");
        return input.nextLine();
    }
}
