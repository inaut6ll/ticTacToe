import java.util.Arrays;
public class Game
{
    private static String[][] board;
    private static int size;

    public Game(int size){
        this.size = size;
        board = new String[size][size];
    }
    
    public String[][] getBoard() {
        return board;
    }
    
    public void printBoard() {
        System.out.println("");
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println("");
        }
    }

    public void setO(int row, int col)
    {
        board[row][col] = " O  "; 
    }
    
    public void setX(int row, int col)
    {
        board[row][col] = " X  ";
    }
    
    public static boolean checkRows(String OX) {
        for (int row = 0; row < size; row++) {
            int count = 0;
            for (int col = 0; col < board[0].length; col++) {
               if (board[row][col] != null && board[row][col].equals(OX)) {
                   count++;
               }
            }
            if (count == size) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkCols(String OX) {
        for (int col = 0; col < board[0].length; col++) {
            int count = 0;
            for (int row = 0; row < size; row++) {
               if (board[row][col] != null && board[row][col].equals(OX)) {
                   count++;
               }
            }
            if (count == size) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkDiags(String OX) {
        int count = 0;
        for (int row = 0; row < size; row++) {
            if (board[row][row] != null && board[row][row].equals(OX)) {
                count++;
            }
        }
        if (count == size) {
            return true;
        }
        count = 0;
        for (int row = 0; row < size; row++) {
            if (board[row][size - 1 - row] != null && board[row][size - 1 - row].equals(OX)) {
                count++;
            }
        }
        if (count == size) {
            return true;
        }
        return false;
    }
    
    public boolean checkWin(String ox) {
        if (Game.checkRows(ox) || Game.checkCols(ox) || Game.checkDiags(ox)){
            return true;
        }
        return false;
    }
    
    public boolean checkAvailable(int row, int col) {
        if (board[row][col] == null) {
            return true;
        }
        return false;
    }
    
    public int checkPosWinRow(String OX) { //fix: returns when it's not supposed to
        for (int row = 0; row < size; row++) {
            int count = 0;
            for (int col = 0; col < board[0].length; col++) {
               if (board[row][col] != null && board[row][col].equals(OX)) {
                   count++;
               }
            }
            if (count == size - 1) {
                return row;
            }
        }
        return -1;
    }
    
    public int checkColOfRow(int row) {
         for (int col = 0; col < board[0].length; col++) {
             if (board[row][col] == null) {
                 return col;
             }
         }
         return -1; 
    }
    
    public int checkPosWinCol(String OX) {
        for (int col = 0; col < board[0].length; col++) {
            int count = 0;
            for (int row = 0; row < size; row++) {
               if (board[row][col] != null && board[row][col].equals(OX)) {
                   count++;
               }
            }
            if (count == size - 1) {
                return col;
            }
        }
        return -1;
    }
    
    public int checkRowOfCol(int col) {
        for (int row = 0; row < board[0].length; row++) {
             if (board[row][col] == null) {
                 return row;
             }
         }
         return -1; 
    }
    
    public boolean checkPosWinDiag1(String OX) {
        int count = 0;
        for (int row = 0; row < size; row++) {
           if (board[row][row] != null && board[row][row].equals(OX)) {
                count++;
           }
           if (count == size - 1) {
                return true;
           }
        }
        return false;
    }
    
    public int getPosWinDiag1() {
        for (int row = 0; row < size; row++) {
            if (board[row][row] == null) {
                return row;
            }
        }
        return -1;
    }
    
    public boolean checkPosWinDiag2(String OX) {
        int count = 0;
        for (int row = 0; row < size; row++) {
            if (board[row][size - 1 - row] != null && board[row][size - 1 - row].equals(OX)) {
                count++;
            }
            if (count == size) {
                return true;
            }
        }
        return false;
    }
    
    public int getPosWinDiag2() {
        for (int row = 0; row < size; row++) {
            if (board[row][size - 1 - row] == null) {
                return row;
            }
        }
        return -1;
    }
    
    public boolean checkFilled() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == null) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void resetGame() {
        Arrays.fill(board, null);
    }
}
