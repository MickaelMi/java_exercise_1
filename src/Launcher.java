import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Launcher {
    public static void main(String[] args) throws IOException {
        System.out.println("Mot de bienvenue !");
        Scanner scan = new Scanner(System.in);
        int nbr1 = 0, nbr2 = 1, nbr3 = 0, i;
        while (true) {
            String str = scan.nextLine();
            if (str.equals("quit")) {
                System.out.println("Command " + str);
                break;
            } else if (str.equals("fibo")) {
                System.out.println("Choisissez un nombre pour fibo");
                int  count = Integer.valueOf(scan.nextLine());
                for (i = 2; i <= count; ++i) {
                    nbr3 = nbr1 + nbr2;
                    nbr1 = nbr2;
                    nbr2 = nbr3;
                }
                System.out.print(" " + nbr3);
                System.out.println(" ");
            }else{
                    System.out.println("Unknown Command");
            }
        }
        String str2 = scan.nextLine();
        Path path = Paths.get(str2);
        String content = java.nio.file.Files.readString(path);
        //content = content.replaceAll("\\."," ");
        //content = content.replaceAll(","," ");
        //content = content.replaceAll(";"," ");
        //content = content.replaceAll("\\?"," ");
        //content = content.replaceAll("!"," ");
        content = content.toLowerCase(Locale.ROOT);
        String[] words = content.split(" ");
        List<String> list = Arrays.asList(words);
        Map<Object, Integer> frequencyMap = list.stream()
                .collect(toMap(
                        s -> s, // key is the word
                        s -> 1, // value is 1
                        Integer::sum));
        List<Object> top10 = list.stream()
                .sorted(comparing(frequencyMap::get).reversed()) // sort by descending frequency
                .distinct() // take only unique values
                .limit(3)   // take only the first 10
                .collect(toList()); // put it in a returned list

        System.out.println("top3 = " + top10);
    }
}

