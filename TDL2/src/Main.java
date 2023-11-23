import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public class HistoryLogger{
        private static final String LOG_FILE_NAME = "history.log";
        private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        public static void logActivity(String activity){
            try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_NAME,true))){
                String logEntry = DATE_FORMAT.format(new Date()) + " " + activity;
                writer.println(logEntry);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    protected void logActivity(String activity) {
        HistoryLogger.logActivity(activity);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        User user = new User(input);
        TaskManager taskManager = new TaskManager();
        String username = user.login();
        if (username != null) {
            System.out.println("Haloooooo " + username);
            HistoryLogger.logActivity("Aplikasi dijalankan");
            viewTdl(input, taskManager);
        } else {
            System.out.println("Kamu siapa?.");
        }
    }

    public static void viewTdl(Scanner input, TaskManager taskManager) {
        while (true) {
            System.out.println("MENU : ");
            System.out.println("1. Tambah Dependent Task");
            System.out.println("2. Tambah Recurring Task");
            System.out.println("3. Tambah Urgent Task");
            System.out.println("4. Hapus Tugas");
            System.out.println("5. Tampilkan Tugas");
            System.out.println("6. Tampilkan Log Aktivitas");
            System.out.println("7. Keluar");
            String choice = masuk(input, "Pilih");
    
            if (choice.equals("1")) {
                String tdlDescription = masuk(input, "Masukkan deskripsi Dependent Task");
                String tdlDeadline = masuk(input, "Masukkan deadline Dependent Task (dd/mm/yyyy)");
                int dependent = Integer.parseInt(masuk(input, "Masukkan Tugas yang Bergantung (1-5)"));
                taskManager.addDependentTask(tdlDescription, tdlDeadline, dependent);
                HistoryLogger.logActivity("Menambahkan Dependent task -> " + tdlDescription);

            } else if (choice.equals("2")) {
                String tdlDescription = masuk(input, "Masukkan deskripsi Recurring Task");
                String tdlDeadline = masuk(input, "Masukkan deadline Recurring Task (dd/mm/yyyy)");
                int recurringInterval = Integer.parseInt(masuk(input, "Masukkan Interval Berulang (1 untuk harian, 7 untuk mingguan)"));
                taskManager.addRecurringTask(tdlDescription, tdlDeadline, recurringInterval);
                HistoryLogger.logActivity("Menambahkan Recurring task -> " + tdlDescription);

            } else if (choice.equals("3")) {
                String tdlDescription = masuk(input, "Masukkan deskripsi Urgent Task");
                String tdlDeadline = masuk(input, "Masukkan deadline Urgent Task (dd/mm/yyyy)");
                int urgent = Integer.parseInt(masuk(input, "Masukkan Tingkat Urgensi (1-5)"));
                taskManager.addUrgentTask(tdlDescription, tdlDeadline, urgent);
                HistoryLogger.logActivity("Menambahkan Urgent task -> " + tdlDescription);

                
            } else if (choice.equals("4")) {
                int number = Integer.parseInt(masuk(input, "Masukkan nomor tugas yang ingin Anda hapus"));

                if (number >= 1 && number <= taskManager.getTaskList().size()) {
                    Task removedTask = taskManager.getTaskList().get(number - 1);
                    boolean removed = taskManager.removeTask(number);

                if (removed) {
                    System.out.println("Tugas berhasil dihapus.");
                    HistoryLogger.logActivity("Menghapus task -> " + removedTask.getDescription());
                } else {
                    System.out.println("Nomor tugas tidak ada.");
                }
            }

            } else if (choice.equals("5")) {
                System.out.println("Daftar Tugas:");
                List<Task> tasks = taskManager.getTaskList();
                for (int i = 0; i < tasks.size(); i++) {
                    Task task = tasks.get(i);
                    if (task instanceof UrgentTask) {
                        UrgentTask priorityTask = (UrgentTask) task;
                        HistoryLogger.logActivity("Menampilkan task");
                        System.out.println((i + 1) + ". " + task.getDescription() + " (Deadline: " + task.getDeadline() + ", Prioritas: " + priorityTask.getUrgent() + ")");
                    } else {
                        System.out.println((i + 1) + ". " + task.getDescription() + " (Deadline: " + task.getDeadline() + ")");
                    }
                }

            } else if (choice.equals("6")) {
                tampilkanLogAktivitas(); 
                
            } else if (choice.equals("7")) {
                HistoryLogger.logActivity("Keluar");
                System.out.println("dadahhh");
                break;
            } else {
                System.out.println("Pilihan tidak ada");
            }
        }
    }

    public static void tampilkanLogAktivitas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(HistoryLogger.LOG_FILE_NAME))) {
            System.out.println("\nLog Aktivitas:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String masuk(Scanner input, String info) {
        System.out.println(info + " : ");
        return input.nextLine();
    }
}