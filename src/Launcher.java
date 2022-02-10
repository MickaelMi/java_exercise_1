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
            } else if (str.equals("fibo")) {
                System.out.println("Choisissez un nombre pour fibo");
                int nbr1 = 0, nbr2 = 1, nbr3, i, count = Integer.valueOf(scan.nextLine());
                for (i = 2; i <= count; ++i) {
                    nbr3 = nbr1 + nbr2;
                    nbr1 = nbr2;
                    nbr2 = nbr3;
                    System.out.print(" " + nbr3);
                }
                System.out.println(" ");
            }else{
                    System.out.println("Unknown Command");
            }
        }
    }
}

