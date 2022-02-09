import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Mot de bienvenue !");
        Scanner scan = new Scanner(System.in);
        while (true) {
            String str = scan.nextLine();
            if (str.equals("quit")) {
                System.out.println("Command " + str);
                break;
            } else {
                System.out.println("Unknown Command");
            }
        }
    }
}
