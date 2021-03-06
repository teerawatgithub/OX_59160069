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
            if(ox.checkWin(col, row)){
                printTable();
                System.out.println(ox.getCurrentPlayer() + " " + "Win");
                printScore("X win: " + ox.getScoreX(), "O win: ", ox.getScoreO(), "Draw: ", ox.getScoreDraw());
                ox.reset();
                continue;
            }
            if(ox.isDraw()){
                printTable();
                printScore("Draw", "X win: ", ox.getScoreX(), "O win: ", ox.getScoreO());
                System.out.println("Draw: " + ox.getScoreDraw());
                ox.reset();
                continue;
            }
            ox.switchPlayer();
        }
    }

    private static void printScore(String s, String s2, int scoreO, String s3, int scoreDraw) {
        System.out.println(s);
        System.out.println(s2 + scoreO);
        System.out.println(s3 + scoreDraw);
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
