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
public class Game {
    public Point pP;
    private final char[][] board;
    public int wScore;
    public int bScore;
    public int remaining;
    private final char[] boardX = new char[]{'1', '2', '3', '4', '5', '6', '7', '8'};

    public Game() {


        board = new char[][]{
                {'_', '_', '_', '_', '_', '_', '_', '_', },
                {'_', '_', '_', '_', '_', '_', '_', '_', },
                {'_', '_', '_', '_', '_', '_', '_', '_', },
                {'_', '_', '_', 'W', 'B', '_', '_', '_', },
                {'_', '_', '_', 'B', 'W', '_', '_', '_', },
                {'_', '_', '_', '_', '_', '_', '_', '_', },
                {'_', '_', '_', '_', '_', '_', '_', '_', },
                {'_', '_', '_', '_', '_', '_', '_', '_', }, };
    }

    public char[][] getBoard() {
        return board;
    }

    public void displayBoard(Game b) { // check

        System.out.print("  ");
        for (int i = 0; i < boardX.length; i++) {
            System.out.print(boardX[i] + " ");

        }

        for (int i = 1; i <= board.length; i++) {
            System.out.println();
            System.out.print(i);
            System.out.print(" ");
            for (int j = 0; j < board.length; j++) {

                System.out.print(board[i - 1][j] + " ");

            }

        }

    }

    //There are three cases black win = -1, white win = 1, draw = 0

    public int gameResult(Point[] whitePlaceableLocations, Point[] blackPlaceableLocations) {

        int wCount = 0;
        int bCount = 0;

        for (Point p : whitePlaceableLocations) {
            if (p.x != -1 && p.y != -1) {
                wCount++;
            } // MEANS THAT THERE IS A POINT IN THE ARRAY
        }

        for (Point p : blackPlaceableLocations) {
            if (p.x != -1 && p.y != -1) {
                bCount++;
            } // MEANS THAT THERE IS A POINT IN THE ARRAY
        }

        if (bCount > wCount) {
            return -1;
        }

        if (bCount < wCount) {
            return 1;
        }

        if (bCount == wCount) {
            return 0;
        }

        return 3;
    }

    public Point[] getPlaceableLocations(char player, char opponent) { // check


        Point[] placeablePositions = new Point[64];

        for (int i = 0; i < placeablePositions.length; i++) {
            placeablePositions[i] = new Point(-1, -1);
        } // sets the value of each point in the array to 0,0 so that it is not null in the position


        // rest of the elements are null therefore there is a nullpointerexception
        int counter = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == player) {

                    ////////////////////////////////////////////////////////////////////////////////
                    if (j - 1 >= 0 && board[i][j - 1] == opponent) { //left of opponent
                        int k = 1;
                        int p = 1;
                        while (j - p >= 0 && board[i][j - p] == opponent) {
                            k++;
                            p++;
                        }
                        if (j - p >= 0 && board[i][j - p] == '_') {
                            placeablePositions[counter++] = new Point(i, j - p);

                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////

                    if (j + 1 < 8 && board[i][j + 1] == opponent) { //right of opponent
                        int k = 1;
                        int p = 1;
                        while (j + p < 8 && board[i][j + p] == opponent) {
                            k++;
                            p++;
                        }
                        if (j + p < 8 && board[i][j + p] == '_') {
                            placeablePositions[counter++] = new Point(i, j + p);

                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////

                    if (i + 1 < 8 && board[i + 1][j] == opponent) { //down
                        int k = 1;
                        int p = 1;
                        while (i + k < 8 && board[i + k][j] == opponent) {
                            k++;
                            p++;
                        }
                        if (i + k < 8 && board[i + k][j] == '_') {
                            placeablePositions[counter++] = new Point(i + k, j);
                        }

                    }
                    ////////////////////////////////////////////////////////////////////////////////

                    if (i - 1 >= 0 && board[i - 1][j] == opponent) { //up
                        int k = 1;
                        int p = 1;
                        while (i - k >= 0 && board[i - k][j] == opponent) {
                            k++;
                            p++;
                        }
                        if (i - k >= 0 && board[i - k][j] == '_') {
                            placeablePositions[counter++] = new Point(i - k, j);
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////


                    if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == opponent) { // northwest
                        int k = 1;
                        int p = 1;
                        while (i - k >= 0 && j - p >= 0 && board[i - k][j - p] == opponent) {
                            k++;
                            p++;
                        }
                        if (i - k >= 0 && j - p >= 0 && board[i - k][j - p] == '_') {
                            placeablePositions[counter++] = new Point(i - k, j - p);
                        }

                    }
                    ////////////////////////////////////////////////////////////////////////////////

                    if (i - 1 >= 0 && j + 1 < 8 && board[i - 1][j + 1] == opponent) { // northeast
                        int k = 1;
                        int p = 1;
                        while (i - k >= 0 && j + p < 7 && board[i - k][j + p] == opponent) {
                            k++;
                            p++;
                        }
                        if (i - k >= 0 && j + p < 8 && board[i - k][j + p] == '_') {
                            placeablePositions[counter++] = new Point(i - k, j + p);
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////

                    if (i + 1 < 8 && j - 1 >= 0 && board[i + 1][j - 1] == opponent) { // southwest
                        int k = 1;
                        int p = 1;
                        while (i + k < 8 && j - p >= 0 && board[i + k][j - p] == opponent) {
                            k++;
                            p++;
                        }
                        if (i + k < 8 && j - p >= 0 && board[i + k][j - p] == '_') {
                            placeablePositions[counter++] = new Point(i + k, j - p);
                        }
                    }
                    ////////////////////////////////////////////////////////////////////////////////

                    if (i + 1 < 8 && j + 1 < 8 && board[i + 1][j + 1] == opponent) { // southeast
                        int k = 1;
                        int p = 1;
                        while (i + k < 8 && j + p < 8 && board[i + k][j + p] == opponent) {
                            k++;
                            p++;
                        }
                        if (i + k < 8 && j + p < 8 && board[i + k][j + p] == '_') {
                            placeablePositions[counter++] = new Point(i + k, j + p);
                        }

                    }
                    ////////////////////////////////////////////////////////////////////////////////
                }
            }
        }


        //Point[] placeablePositions = new Point[64];
        //showPlaceableLocations(placeablePositions, player, opponent);

        return placeablePositions;
    }

    public void showPlaceableLocations(Point[] locations, char player, char opponent) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = '_';
                }

            }

        }


        for (Point p : locations) {
            if (p.x != -1 && p.y != -1) {
                board[p.x][p.y] = '*';
            }

        }

//        for (Point p : locations) {
//            board[p.x][p.y] = '_';
//        }
//        for (Point p : locations) {
//            System.out.println(p.x + " " + p.y);
//
//        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void placeMove(Point p, char player, char opponent) {

        //System.out.println(p.x + " " + p.y);
        //System.out.println(board[p.x - 1][p.y - 1]);

        p.x = p.x - 1;
        p.y = p.y - 1;

        // board[p.x][p.y] = player;

        ////////////////////////////////////////////////////////////////////////////////
        //p.y < 7 && board[p.x][p.y] == '*' && board[p.x][p.y + 1] == opponent && board[p.x][p.y + 2] != '_'
        // && board[p.x][p.y + 2] != '*' && board[p.x][p.y + 2] != opponent

        if (p.y + 1 < 8 && board[p.x][p.y + 1] == opponent) { // right```

            int j = 1;

            while (p.y + j < 8 && board[p.x][p.y + j] == opponent) {

                j++;
            }


            if (p.y + j < 8 && board[p.x][p.y + j] == player && board[p.x][p.y + j] != '*') {

                for (int i = p.y; i < p.y + j; i++) {
                    board[p.x][i] = player;
                }
            }


        }
        ////////////////////////////////////////////////////////////////////////////////
//p.y > 1 && board[p.x][p.y] == '*' && board[p.x][p.y - 1] == opponent && board[p.x][p.y - 2] != '_' &&
// board[p.x][p.y - 2] != '*' && board[p.x][p.y - 2] != opponent
        if (p.y - 1 >= 0 && board[p.x][p.y - 1] == opponent && board[p.x][p.y - 1] != '*' && board[p.x][p.y - 1] != '_') { // left```
            int j = 1;

            while (p.y - j >= 0 && board[p.x][p.y - j] == opponent) {

                j++;
            }

            if (p.y - j >= 0 && board[p.x][p.y - j] == player && board[p.x][p.y - j] != '*') {

                for (int i = p.y - j; i < p.y; i++) {
                    board[p.x][i] = player;
                }
            }

        }

        ////////////////////////////////////////////////////////////////////////////////
// p.x > 1 && board[p.x][p.y] == '*' && board[p.x - 1][p.y] == opponent && board[p.x - 2][p.y]
// != '_' && board[p.x - 2][p.y] != '*' && board[p.x - 2][p.y] != opponent
        if (p.x - 1 >= 0 && board[p.x - 1][p.y] == opponent && board[p.x - 1][p.y] != '*' && board[p.x - 1][p.y] != '_') { // up
            int i = 1;

            while (p.x - i >= 0 && board[p.x - i][p.y] == opponent) {
                i++;

            }

            if (p.x - i >= 0 && board[p.x - i][p.y] == player && board[p.x - i][p.y] != '*' && board[p.x - i][p.y] != '_') {

                for (int j = p.x - i; j < p.x; j++) {
                    board[j][p.y] = player;
                }
            }

        }

        ////////////////////////////////////////////////////////////////////////////////
// p.x < 7 && board[p.x][p.y] == '*' && board[p.x + 1][p.y] == opponent &&  board[p.x + 2][p.y] != '_' &&
// board[p.x + 2][p.y] != '*' &&  board[p.x + 2][p.y] != opponent
        if (p.x + 1 < 8 && board[p.x + 1][p.y] == opponent && board[p.x + 1][p.y] != '*' && board[p.x + 1][p.y] != '_') { // down ```
            int i = 1;


            while (p.x + i < 8 && board[p.x + i][p.y] == opponent) {
                i++;
            }

            if (p.x + i < 8 && board[p.x + i][p.y] == player) {

                for (int j = p.x + i; j > p.x; j--) {
                    board[j][p.y] = player;
                }
            }

        }

        ////////////////////////////////////////////////////////////////////////////////
// p.x - 2 >= 0 && p.y - 2 >= 0 && board[p.x][p.y] == '*' && board[p.x - 2][p.y - 2] != '*'
// && board[p.x - 2][p.y - 2] != opponent && board[p.x - 1][p.y - 1] == opponent)
        if (p.x - 1 >= 0 && p.y - 1 >= 0 && board[p.x - 1][p.y - 1] == opponent) { // northwest
            int i = 1;
            int j = 1;

            while (p.x - i >= 0 && p.y - j >= 0 && board[p.x - i][p.y - j] == opponent) {
                i++;
                j++;
            }


            if (p.x - i >= 0 && p.y - j >= 0 && board[p.x - i][p.y - j] == player) {//////////
//                for (int k = p.x; k > p.x - i; k--) {
//                    for (int l = p.y; l > p.y - i; l--) {
//                        board[k][l] = player;
//
//                    }
//
//                }
                int k = p.x;
                int l = p.y;

                while (k > p.x - i && l > p.y - j) {
                    board[k][l] = player;
                    k--;
                    l--;

                }

            }
        }

        ////////////////////////////////////////////////////////////////////////////////
// p.x + 2 <= 7 && p.y + 2 <= 7 && board[p.x][p.y] == '*' && board[p.x + 2][p.y + 2] != '*'
// && board[p.x + 2][p.y + 2] != opponent && board[p.x + 1][p.y + 1] == opponent

        if (p.x + 1 < 8 && p.y + 1 < 8 && board[p.x + 1][p.y + 1] == opponent) { // southeast
            int i = 1;
            int j = 1;

            while (p.x + i < 8 && p.y + j < 8 && board[p.x + i][p.y + j] == opponent) {

                i++;
                j++;

            }

            if (p.x + i < 8 && p.y + j < 8 && board[p.x + i][p.y + j] == player) {
//                for (int k = p.x; k < p.x + i; k++) {
//                    for (int l = p.y; l < p.x + j; l++) {
//                        board[k][l] = player;
//                    }
//                }

                int k = p.x;
                int l = p.y;

                while (k < p.x + i && l < p.y + j) {
                    board[k][l] = player;
                    k++;
                    l++;

                }


            }


        }

        ////////////////////////////////////////////////////////////////////////////////
//p.x - 2 >= 0 && p.y + 2 <=7 && board[p.x][p.y] == '*' && board[p.x - 2][p.y + 2] != '*' &&
// board[p.x - 2][p.y + 2] != opponent &&  board[p.x - 1][p.y + 1] == opponent
        if (p.x - 1 >= 0 && p.y + 1 < 8 && board[p.x - 1][p.y + 1] == opponent) { // northeast
            int i = 1;
            int j = 1;

            while (p.x - i >= 0 && p.y + j < 8 && board[p.x - i][p.y + j] == opponent) {
                i++;
                j++;
            }

            if (p.x - i >= 0 && p.y + j < 8 && board[p.x - i][p.y + j] == player) {

//                for (int k = p.x; k > p.x - i; k--) {
//                    for (int l = p.y; l < p.y + j; l++) {
//                        board[k][l] = player;
//                    }
//                }

                int k = p.x;
                int l = p.y;

                while (k >= 0 && l < 8 && k > p.x - i && l < p.y + j) {
                    board[k][l] = player;
                    k--;
                    l++;

                }


            }


        }

        ////////////////////////////////////////////////////////////////////////////////
//board[p.x][p.y] == '*' && board[p.x + 1][p.y - 1] == opponent && board[p.x + 2][p.y - 2]
// != '*' && board[p.x + 2][p.y - 2] != opponent
        if (p.x + 1 < 8 && p.y - 1 >= 0 && board[p.x + 1][p.y - 1] == opponent) { // southwest
            int i = 1;
            int j = 1;

            while (p.x + i < 8 && p.y - j >= 0 && board[p.x + i][p.y - j] == opponent) {
                i++;
                j++;
            }

            if (p.x + i < 8 && p.y - j >= 0 && board[p.x + i][p.y - j] == player) {

//                for (int k = p.x; k < p.x + i; k++) {
//                    for (int l = p.y; l > p.y - j; l--) {
//                        board[k][l] = player;
//                    }
//
//                }
                int k = p.x;
                int l = p.y;

                while (k >= 0 && l < 8 && k < p.x + i && l > p.y - j) {
                    board[k][l] = player;
                    k++;
                    l--;

                }


            }

        }
        board[p.x][p.y] = player;


    }

    /////////////////////////////////////////////////////////////////////////////
    public void updateScores() { // check
        this.wScore = 0;
        this.bScore = 0;
        this.remaining = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == 'B') {
                    this.bScore++;
                }

                if (board[i][j] == 'W') {
                    this.wScore++;
                }

                this.remaining++;

            }

        }

    }
}
