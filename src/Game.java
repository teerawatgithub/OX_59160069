import java.util.Scanner;

public class Game {
    private static OX ox;
    private static Scanner sc = new Scanner(System.in);
    private static int col;
    private static int row;

    public static void main(String[] args) {
        ox = new OX();
        while(true){
            printTable();
            input();

            ox.switchPlayer();
        }
    }

    private static void input() {
        boolean canPush = true;
        do {
            System.out.print(ox.getCurrentPlayer() + " Col :");
            col = sc.nextInt();
            System.out.print(ox.getCurrentPlayer() + " Row :");
            row = sc.nextInt();
            canPush = ox.push(col, row);
            if (!canPush)
                System.out.println("Please input number between 0-2");
        }while(!canPush);
    }

    private static void printTable() {
        System.out.print(ox.getTableString());
    }
}
