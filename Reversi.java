import java.util.Scanner;

/**
 * Reversi Game
 *
 * The program runs a model simulation of the
 * game Othello/Reversi. The game relies upon
 * user input in order to function.
 *
 * @author Shivom Patel, lab sec 813
 * @version October 17, 2018
 */

public class Reversi { // another change made

    public static boolean isEmpty(Point[] p) {

        for (Point point : p) {
            if (point.x != -1 && point.y != -1) {
                return false;
            }
        }

        return true;
    }

    //Check whether a Point is the Points array or not

    public static boolean contains(Point[] points, Point p) { // Check if this makes sense!!!!

        for (Point point : points) {
            if (p.x > 0 && p.y > 0 && p.x <= 8 && p.y <= 8 && point.x == p.x - 1 && point.y == p.y - 1) {
                return true;
            }
        }

        return false;

    }

    public static void start(Game g) {


        boolean continu = true;
        int gameResult;
        Scanner in = new Scanner(System.in);


        while (continu) {

            boolean passTurn = true;


            ////////////////////////////////////////////////////////////////////////////////////
            if (passTurn) {

                Point[] blackLocations = g.getPlaceableLocations('B', 'W');

                Point[] whiteLocations = g.getPlaceableLocations('W', 'B');

                if (isEmpty(blackLocations)) {
                    if (g.gameResult(whiteLocations, blackLocations) == 1) {

                        System.out.println("White wins: " + g.wScore + ":" + g.bScore);
                        return;
                    }

                    if (g.gameResult(whiteLocations, blackLocations) == -1) {
                        System.out.println("Black wins: " + g.bScore + ":" + g.wScore);
                        return;
                    }

                    if (g.gameResult(whiteLocations, blackLocations) == 0) {
                        System.out.println("It is a draw.");
                        return;
                    }

                }

                g.showPlaceableLocations(blackLocations, 'B', 'W');
                g.displayBoard(g);

                System.out.println("\n");
                System.out.println("Place move (Black): row then column: ");

                String choice = in.nextLine();


                if (choice.equals("exit")) {
                    System.out.println("Exiting!");
                    return;
                }


                while (choice.length() != 2 || Character.isLetter(choice.charAt(0)) && Character.isLetter(choice.charAt(1))) { // change made

                    System.out.println("Invalid move!\nPlace move (Black): row then column:");
                    choice = in.nextLine();

                    if (choice.equals("exit")) {
                        System.out.println("Exiting!");
                        return;
                    }

                }

                Point point = new Point(Integer.parseInt(choice.substring(0, 1)), Integer.parseInt(choice.substring(1, 2)));

                while (!contains(blackLocations, point)) {
                    System.out.println("Invalid move!\nPlace move (Black): row then column:");
                    choice = in.nextLine();

                    if (choice.equals("exit")) {
                        System.out.println("Exiting!");
                        return;
                    }

                    while (choice.length() != 2 || Character.isLetter(choice.charAt(0)) &&
                            Character.isLetter(choice.charAt(1)) ){

                        System.out.println("Invalid move!\nPlace move (Black): row then column:");
                        choice = in.nextLine();

                        if (choice.equals("exit")) {

                            System.out.println("Exiting!");

                            return;
                        }


                    }

                    point = new Point(Integer.parseInt(choice.substring(0, 1)), Integer.parseInt(choice.substring(1, 2)));

                }


                g.placeMove(point, 'B', 'W');

                g.updateScores();

                System.out.println("Black: " + g.bScore + " White: " + g.wScore);
                System.out.println();


                passTurn = false;

            }

            /////////////////////////////////////////////////////////////////////////////////
            if (!passTurn) {

                Point[] blackLocations = g.getPlaceableLocations('B', 'W');

                Point[] whiteLocations = g.getPlaceableLocations('W', 'B');

                if (isEmpty(blackLocations)) {
                    if (g.gameResult(whiteLocations, blackLocations) == 1) {
                        System.out.println("White wins: " + g.wScore + ":" + g.bScore);
                        return;
                    }

                    if (g.gameResult(whiteLocations, blackLocations) == -1) {
                        System.out.println("Black wins: " + g.bScore + ":" + g.wScore);
                        return;
                    }

                    if (g.gameResult(whiteLocations, blackLocations) == 0) {
                        System.out.println("It is a draw.");
                        return;
                    }

                }

                //Point[] whiteLocations = g.getPlaceableLocations('W', 'B');
                g.showPlaceableLocations(whiteLocations, 'W', 'B');
                g.displayBoard(g);

                System.out.println("\n");
                System.out.println("Place move (White): row then column: ");

                String choice = in.nextLine();


                if (choice.equals("exit")) {

                    System.out.println("Exiting!");

                    return;
                }

                while (choice.length() != 2 || Character.isLetter(choice.charAt(0)) &&
                        Character.isLetter(choice.charAt(1)) ){

                    System.out.println("Invalid move!\nPlace move (White): row then column:");
                    choice = in.nextLine();

                    if (choice.equals("exit")) {

                        System.out.println("Exiting!");

                        return;
                    }


                }

                Point point = new Point(Integer.parseInt(choice.substring(0, 1)), Integer.parseInt(choice.substring(1, 2)));

                while (!contains(whiteLocations, point)) {
                    System.out.println("Invalid move!\nPlace move (White): row then column:");
                    choice = in.nextLine();
                    //point = new Point(Integer.parseInt(choice.substring(0, 1)), Integer.parseInt(choice.substring(1, 2)));



                    if (choice.equals("exit")) {

                        System.out.println("Exiting!");

                        return;
                    }

                    while (choice.length() != 2 || Character.isLetter(choice.charAt(0)) &&
                            Character.isLetter(choice.charAt(1)) ){

                        System.out.println("Invalid move!\nPlace move (White): row then column:");
                        choice = in.nextLine();

                        if (choice.equals("exit")) {

                            System.out.println("Exiting!");

                            return;
                        }


                    }

                    point = new Point(Integer.parseInt(choice.substring(0, 1)), Integer.parseInt(choice.substring(1, 2)));
                }

                g.placeMove(point, 'W', 'B');

                g.updateScores();

                System.out.println("White: " + g.wScore + " Black: " + g.bScore);
                System.out.println();


                passTurn = true;

            }


        }


    }

    public static void main(String[] args) {
        Game b = new Game();

        start(b);

    }
}
