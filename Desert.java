import java.util.Scanner;

public class Desert {
    private Scanner scan = new Scanner(System.in);

    public int findTreasure() {
        int value;
        value = (int) (Math.random() * 500);
        return value;
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}