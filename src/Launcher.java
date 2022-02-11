import java.util.Scanner;
import java.io.IOException;
import java.util.List;

public class Launcher {
    public static void main(String[] args) throws IOException {
        System.out.println("Mot de bienvenue !");
        List<Command> commands = List.of(
                new Quit(),
                new Fibo(),
                new Freq()
        );

        Scanner scan = new Scanner(System.in);
        do {
            String instruction = scan.nextLine();
            boolean found = false;
            for (var i : commands) {
                if (i.name().equals(instruction)) {
                    if (i.run(scan))
                        return;

                    found = true;
                }
            }
            if (!found)
                System.out.println("Unknown command");
        } while (true);
    }
}