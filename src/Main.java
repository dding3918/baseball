import com.sun.source.tree.ForLoopTree;
import javax.sound.midi.Receiver;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String title = sc.nextLine();

        int score = (int)Math.floor(sc.nextDouble());
        sc.nextLine();

        String[] recipes = new String[10];

        for (int i = 0; i < recipes.length; i++) {
            recipes[i] = sc.nextLine();
        }
        System.out.println();
        System.out.println("[" + title + "]");
        System.out.println(score + " (" + ((double) score / 5) * 100 + "%)");

        for (int i = 0; i < recipes.length; i++) {
            System.out.println((i+1) + "." + recipes[i]);
        }

    }
}