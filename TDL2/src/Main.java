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
            System.out.println("2. Tambah Tugas Prioritas");
            System.out.println("3. Hapus Tugas");
            System.out.println("4. Tampilkan Tugas");
            System.out.println("5. Keluar");
            String choice = masuk(input, "Pilih");
    
            if (choice.equals("1")) {
                String tdlDescription = masuk(input, "Masukkan deskripsi tugas");
                String tdlDeadline = masuk(input, "Masukkan deadline tugas (dd/mm/yyyy)");
                taskManager.addTask(tdlDescription, tdlDeadline);
            } else if (choice.equals("2")) {
                String tdlDescription = masuk(input, "Masukkan deskripsi tugas prioritas");
                String tdlDeadline = masuk(input, "Masukkan deadline tugas prioritas (dd/mm/yyyy)");
                int priority = Integer.parseInt(masuk(input, "Masukkan prioritas tugas (1-5)"));
                taskManager.addPriorityTask(tdlDescription, tdlDeadline, priority);
            } else if (choice.equals("3")) {
                int number = Integer.parseInt(masuk(input, "Masukkan nomor tugas yang ingin Anda hapus"));
                boolean removed = taskManager.removeTask(number);
                if (removed) {
                    System.out.println("Tugas berhasil dihapus.");
                } else {
                    System.out.println("Nomor tugas tidak ada.");
                }
            } else if (choice.equals("4")) {
                System.out.println("Daftar Tugas:");
                List<Task> tasks = taskManager.getTaskList();
                for (int i = 0; i < tasks.size(); i++) {
                    Task task = tasks.get(i);
                    if (task instanceof PriorityTask) {
                        PriorityTask priorityTask = (PriorityTask) task;
                        System.out.println((i + 1) + ". " + task.getDescription() + " (Deadline: " + task.getDeadline() + ", Prioritas: " + priorityTask.getPriority() + ")");
                    } else {
                        System.out.println((i + 1) + ". " + task.getDescription() + " (Deadline: " + task.getDeadline() + ")");
                    }
                }
            } else if (choice.equals("5")) {
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
