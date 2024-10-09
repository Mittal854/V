// public class BackTracking {

//     public static void printPermutation(String str, String perm, int ind) // tc--O(n*n!)
//     {
//         if (str.length() == 0) {
//             System.out.println(perm);
//             return;
//         }
//         for (int i = 0; i < str.length(); i++) {
//             String newS = str.substring(0, i) + str.substring(i + 1);
//             printPermutation(newS, perm + str.charAt(i), ind + 1);
//         }
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String str = sc.nextLine();
//         printPermutation(str, "", 0);
//         sc.close();
//     }
// }

//N-Queens

// public class BackTracking {

//     public static boolean isSafe(char[][] board, int row, int col) {
//         for (int i = 0; i < col; i++) {
//             if (board[row][i] == 'Q') {
//                 return false;
//             }
//         }

//         for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
//             if (board[r][c] == 'Q') {
//                 return false;
//             }
//         }

//         for (int r = row, c = col; r < board.length && c >= 0; r++, c--) {
//             if (board[r][c] == 'Q') {
//                 return false;
//             }
//         }

//         return true;
//     }

//     public static void saveBoard(List<List<String>> allBoard, char[][] board) {
//         List<String> newB = new ArrayList<>();
//         for (int i = 0; i < board.length; i++) {
//             StringBuilder row = new StringBuilder();
//             for (int j = 0; j < board.length; j++) {
//                 if (board[i][j] == 'Q') {
//                     row.append("Q");
//                 } else {
//                     row.append(".");
//                 }
//             }
//             newB.add(row.toString());

//         }
//         allBoard.add(newB);
//     }

//     public static void helper(List<List<String>> allBoard, char[][] board, int col) {
//         if (col == board.length) {
//             saveBoard(allBoard, board);
//             return;
//         }

//         for (int i = 0; i < board.length; i++) {
//             if (isSafe(board, i, col)) {
//                 board[i][col] = 'Q';
//                 helper(allBoard, board, col + 1);
//                 board[i][col] = '.';
//             }
//         }
//     }

//     public static List<List<String>> nQueens(int n) {
//         List<List<String>> allBoard = new ArrayList<>();
//         char[][] board = new char[n][n];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 board[i][j] = '.';
//             }
//         }
//         helper(allBoard, board, 0);
//         return allBoard;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         List<List<String>> Chess = nQueens(n);
//         for (int i = 0; i < Chess.size(); i++) {
//             for (String row : Chess.get(i)) {
//                 System.out.println(row);
//             }
//             System.out.println();
//         }
//         sc.close();
//     }
// }

//Sudoko Solver

import java.util.Scanner;

public class BackTracking {

    public static boolean isSafe(char[][]board,int row,int col,int num)
    {
        for(int i=0;i<board.length;i++)
        {
            if(board[i][col]==(char)(num+'0')){
                return false;
            }
            if(board[row][i]==(char)(num+'0')){
                return false;
            }
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++)
        {
            for(int j=sc;j<sc+3;j++)
            {
                if(board[i][j]==(char)(num+'0'))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean helper(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }
        int nrow=0;
        int ncol=0;
        if (col != board.length-1) {
            nrow = row;
            ncol = col + 1;
        } else {
            nrow = row + 1;
            ncol = 0;
        }
        if (board[row][col] != '.') {
            if (helper(board, nrow, ncol)) {
                return true;
            }

        }
        else{
            for(int i=1;i<=9;i++)
            {
                if(isSafe(board,row,col,i))
                {
                    board[row][col]=(char)(i+'0');
                    if(helper(board,nrow,ncol)){
                        return true;
                    }
                    else{
                        board[row][col]='.';
                    }
                }
            }
        }
        return false;
    }

    public static void sudoko(char[][] board) {
        helper(board,0,0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        sudoko(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}