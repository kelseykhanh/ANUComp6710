package comp1110.exam;

/**
 * COMP1110 Final Exam, Question 1.3 (harder)
 *
 * 5 Marks
 */
public class Q1Bishop {
    /**
     * In this question you will be given an array representing an 8 x 8  chess
     * board,  and a coordinate representing the location of a black bishop.
     * You must calculate the value of "black bishop moves" for that situation.
     *
     * Black bishop moves is a number that represents the smallest number of
     * consecutive moves (uninterrupted by any other player) it takes for
     * a black bishop to reach a white chess piece.   If there's no way to
     * reach a white chess piece the black bishop moves is -1.   If the
     * black bishop can reach a white piece in one move, then the black bishop
     * moves is 1, etc.
     *
     * Each move, the black bishop can move on any of the four diagonals until
     * it reaches the edge of the board, a black piece, or a white piece.  The
     * black bishop must not move off the board or onto another black piece
     * (it must stop before it reaches either obstruction).
     *
     * Important: unlike in a real chess game, in this problem, the only piece
     * that moves is the black bishop, and it always moves strictly on diagonals.
     * All other pieces are stationary during the problem.  The types of the
     * chess pieces (pawn, rook, queen, etc), are therefore irrelevant.  Only
     * the color (black/white) and position matters.
     *
     * Chess locations are labelled as follows:
     *
     *        a b c d e f g h
     *      8 * . * * . * . .
     *      7 . * . * . . . .
     *      6 . . . . . . . .
     *      5 . . . . . o . .
     *      4 . . . . . . . .
     *      3 . . o . . . . .
     *      2 . o . . o . . .
     *      1 . o o . o o o o
     *
     * In this illustration, black pieces are indicated with '*' and white pieces
     * with 'o'.  Empty locations are marked with a '.'.
     *
     * If the above board was given and the black bishop was at c8, then
     * the black bishop moves would be -1 because the black piece at c8 can't
     * move: the two upper diagonals would take the piece off the board, while
     * the two lower diagonals are blocked by black pieces at b7 and d7.
     *
     * If the above board was given and the black bishop was at f8, then
     * the black bishop moves would be 2.   From f8, the bishop can't move on
     * the two upper diagonals because they take it off the board.  It can
     * move on the lower diagonals, but neither path encounters a white piece.
     * However, if the black bishop moves to h6, it can reach the white piece
     * at c1 on the next move, so the black bishop moves number is 2.
     *
     * This path is marked with '#'s below.
     *
     *        a b c d e f g h
     *      8 * . * * . * . .
     *      7 . * . * . . # .
     *      6 . . . . . . . #
     *      5 . . . . . o # .
     *      4 . . . . . # . .
     *      3 . . o . # . . .
     *      2 . o . # o . . .
     *      1 . o o . o o o o
     *
     * There are other ways to reach a white piece in the same number of moves
     * (e.g. c5 to g1, b4 to c3 and a3 to b2.)
     *
     * The chessboard is represented by an String of 64 chars, with the
     * character '.' representing an empty square, 'o' representing
     * a white piece, and '*' representing a black piece.  The first element
     * in the array is for square a1, the next is b1, and the last element
     * in the array is for square h8.
     *
     * The black bishop position is represented as a two character string
     * that represents a chess position (eg f8 or c8).
     *
     * @param board The chess board, represented as a string composed of 64
     *              characters: '.' (empty), 'o' (white), and '*' (black), with
     *              the first character representing position a1, the second b1,
     *              etc, and the last representing h8.
     * @param bb The black bishop position, a two-character string referencing
     *           the position of the black bishop (eg a3).
     * @return The black bishop number; the minimum number of consecutive moves
     * of the black bishop before it reaches a white piece, or -1 if it cannot
     * reach a white piece.
     */
    public static int blackBishopMoves(String board, String bb) {
        return 0;  // FIXME complete this method
    }


    /**
     * This method takes a board string and returns a string that displays
     * the board in a readable format.   It may be useful when you are
     * debugging, and is used by the tests to help you visualize the
     * results.
     *
     * @param board A board string
     * @return A formatted board
     */
    public static String pretty(String board) {
        String result = "  a b c d e f g h\n";
        for (int r = 8; r > 0; r--) {
            result += r + " ";
            for (int c = 0; c < 8; c++) {
                result += board.charAt(((r - 1) * 8) + c) + " ";
            }
            result += "\n";
        }
        return result;
    }
}
