import java.util.Scanner;

public class User {
    private Scanner input;

    public User(Scanner input) {
        this.input = input;
    }
    public String login() {
        System.out.println("Masukkan Username: ");
        String username = input.nextLine();
        if (username.equals("aufa")) {
            return username;
        } else {
            System.out.println("Kamu siapa?.");
            return null;
        }
    }
    public Scanner getInput() {
        return input;
    }
    public void setInput(Scanner input) {
        this.input = input;
    }
}