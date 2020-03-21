import java.util.*;

public class SimpleTicTacToe {

    static int spot;
    static Scanner position = new Scanner(System.in);
    static List<Integer> player1move = new ArrayList<>();
    static List<Integer> player2move = new ArrayList<>();

    public static void main(String[] args) {
        String [][] board = {{"1", "|", "2", "|", "3"},
                {"-", "+", "-", "+", "-"},
                {"4", "|", "5", "|", "6"},
                {"-", "+", "-", "+", "-"},
                {"7", "|", "8", "|", "9"}};
        printboard(board);
        boolean pickuser = true;
        while (true) {
            if (pickuser) {
                promptuser("player 1", "X");
                taketurn(board, spot, "player 1");
                player1move.add(spot);
            }
            else {
                promptuser("player 2", "O");
                taketurn(board, spot, "player 2");
                player2move.add(spot);
            }
            printboard(board);
            pickuser = !pickuser;
            winningcombos();
        }
    }

    public static void printboard (String[][] board) {
        for (String[] i: board) {
            for (String j: i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void promptuser(String player, String piece) {
        System.out.println("What position would you like to place an " + piece + " " + player + " ? (1-9):");
        spot = position.nextInt();
        while ((player1move.contains(spot) || player2move.contains(spot)) || spot > 9) {
            System.out.println("You can't pick that! Pick again please " + player);
            spot = position.nextInt();
        }
    }

    public static void taketurn (String[][] board, int num, String player) {
        String rest = "";
        if (player.equals("player 1")) {
            rest = "X";
        }
        else if (player.equals("player 2")) {
            rest = "O";
        }

        switch(num) {
            case 1:
                board[0][0] = rest;
                break;
            case 2:
                board[0][2] = rest;
                break;
            case 3:
                board[0][4] = rest;
                break;
            case 4:
                board[2][0] = rest;
                break;
            case 5:
                board[2][2] = rest;
                break;
            case 6:
                board[2][4] = rest;
                break;
            case 7:
                board[4][0] = rest;
                break;
            case 8:
                board[4][2] = rest;
                break;
            case 9:
                board[4][4] = rest;
                break;
            default:
                break;
        }
    }

    public static void winningcombos() {

        List<Integer> toprow = Arrays.asList(1, 2, 3);
        List<Integer> midrow = Arrays.asList(4, 5, 6);
        List<Integer> bottrow = Arrays.asList(7, 8, 9);
        List<Integer> leftcol = Arrays.asList(1, 4, 7);
        List<Integer> midcol = Arrays.asList(2, 5, 8);
        List<Integer> rightcol = Arrays.asList(3, 6, 9);
        List<Integer> diag1 = Arrays.asList(1, 5, 9);
        List<Integer> diag2 = Arrays.asList(3, 5, 7);

        List<List> winnin = new ArrayList<>();

        winnin.add(toprow);
        winnin.add(midrow);
        winnin.add(bottrow);
        winnin.add(leftcol);
        winnin.add(midcol);
        winnin.add(rightcol);
        winnin.add(diag1);
        winnin.add(diag2);

        for (List l: winnin) {
            if (player1move.containsAll(l)) {
                System.out.println("Congrats player 1, you've won!! Thanks for playing");
                System.exit(0);
            }
            else if (player2move.containsAll(l)) {
                System.out.println("Congrats player 2, you've won!! Thanks for playing");
                System.exit(0);
            }
        }
        if (player1move.size() + player2move.size() == 9) {
            System.out.println("There's no winner! Thanks for playing");
            System.exit(0);
        }
        System.out.println();
    }
}