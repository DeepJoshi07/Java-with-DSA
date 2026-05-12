public class BackTracking {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void changeArray(int arr[], int i, int val) {
        if (i == arr.length) {
            printArray(arr);
            return;
        }

        arr[i] = val;
        changeArray(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    public static void allSubstring(String str, int i, StringBuilder sb) {
        if (i == str.length()) {
            if (sb.length() == 0) {
                System.out.println("Null");
            } else {
                System.out.println(sb.toString());
            }
            return;
        }
        sb.append(str.charAt(i));
        allSubstring(str, i + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        allSubstring(str, i + 1, sb);
    }

    public static void allPermutation(String s, StringBuilder sb) {
        if (s.length() == 0) {
            System.out.println(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String newString = s.substring(0, i) + s.substring(i + 1);
            allPermutation(newString, sb.append(ch));
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static <T> void printBoard(T board[][]) {
        System.out.println("----------- Board -----------");
        for (T rows[] : board) {
            for (T cell : rows) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void nQueens(Character board[][], int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                nQueens(board, row + 1);
                board[row][i] = 'X';
            }
        }
    }

    public static boolean isNQueens(Character board[][], int row) {
        if (row == board.length) {
            return true;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                if (isNQueens(board, row + 1)) {
                    return true;
                }
                ;
                board[row][i] = 'X';
            }
        }
        return false;
    }

    public static int count = 0;

    public static void nQueensCount(Character board[][], int row) {
        if (row == board.length) {
            count++;
            return;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                nQueensCount(board, row + 1);
                board[row][i] = 'X';
            }
        }
    }

    private static boolean isSafe(Character board[][], int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static int gridWays(int n, int m, int i, int j) {
        if (i == n && j == m)
            return 1;

        if (i > n || j > m)
            return 0;

        int way1 = gridWays(n, m, i + 1, j);
        int way2 = gridWays(n, m, i, j + 1);

        return way1 + way2;
    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }

    public static int gridWays2(int n, int m) {
        return factorial(n + m - 2) / (factorial(n - 1) * factorial(m - 1));
    }

    public static boolean solveSudoku(Integer sudoku[][], int row, int col) {
        if (row == 9)
            return true;

        int nextRow = row, nextCol = col + 1;
        if (nextCol == sudoku.length) {
            nextRow++;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return solveSudoku(sudoku, nextRow, nextCol);
        }

        for (int i = 1; i <= sudoku.length; i++) {
            if (isSafePlace(sudoku, row, col, i)) {
                sudoku[row][col] = i;
                if (solveSudoku(sudoku, nextRow, nextCol))
                    return true;
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafePlace(Integer sudoku[][], int row, int col, int digit) {
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }

        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void findWayInMaze(Character maze[][], int i, int j) {
        if (i == maze.length - 1 && j == maze[0].length - 1) {
            maze[i][j] = '1';
            printBoard(maze);
            maze[i][j] = '0';
            return;
        }
        if (i >= maze.length || j >= maze[0].length)
            return;

        if (maze[i][j] == 'X')
            return;

        maze[i][j] = '1';
        findWayInMaze(maze, i + 1, j);
        findWayInMaze(maze, i, j + 1);
        maze[i][j] = '0';
    }

    public static void allDigitsCombinations(String keypad[], int d1, int d2, int i, int j) {
        if (i == keypad[d1 - 1].length())
            return;

        if (j == keypad[d2 - 1].length()) {
            allDigitsCombinations(keypad, d1, d2, i + 1, 0);
            return;
        }

        char ch1 = keypad[d1 - 1].charAt(i);
        char ch2 = keypad[d2 - 1].charAt(j);

        System.out.println(ch1 + "" + ch2);

        allDigitsCombinations(keypad, d1, d2, i, j + 1);
    }

    public static boolean knightTour(Integer knightBoard[][], int dx[], int dy[], int row, int col, int move) {
        int n = knightBoard.length;
        if (move == n*n+1) return true;

        for (int i = 0; i < dx.length; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (isSafeForKnight(knightBoard, nextRow, nextCol)) {
                knightBoard[nextRow][nextCol] = move;
                if (knightTour(knightBoard, dx, dy, nextRow, nextCol, move + 1)) {
                    return true;
                }
                knightBoard[nextRow][nextCol] = 0;
            }

        }
        return false;
    }

    private static boolean isSafeForKnight(Integer board[][], int row, int col) {
        int n = board.length;
        return row >= 0 && col >= 0 && row < n && col < n && board[row][col] == 0;
    }

    public static void main(String args[]) {
        System.out.println("---------------------- Question 1 -------------------------");
        int arr[] = new int[5];
        changeArray(arr, 0, 1);
        printArray(arr);
        System.out.println("---------------------- Question 2 -------------------------");
        allSubstring("abc", 0, new StringBuilder(""));
        System.out.println("---------------------- Question 3 -------------------------");
        allPermutation("abc", new StringBuilder());
        System.out.println("---------------------- Question 4 -------------------------");
        Character board[][] = new Character[5][5];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 'X';
            }
        }
        // printBoard(board);
        nQueens(board, 0);
        System.out.println("----------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 'X';
            }
        }
        System.out.println(isNQueens(board, 0));
        System.out.println("----------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 'X';
            }
        }
        nQueensCount(board, 0);
        System.out.println("the total way to put n queens on board are : " + count);
        System.out.println("---------------------- Question 5 -------------------------");
        System.out.println(gridWays(4, 4, 1, 1));
        System.out.println(gridWays2(4, 4));
        System.out.println("---------------------- Question 6 -------------------------");
        Integer[][] sudoku = {
                { 9, 0, 0, 5, 0, 8, 0, 0, 7 },
                { 0, 8, 0, 3, 0, 2, 9, 0, 5 },
                { 0, 5, 4, 0, 0, 0, 0, 8, 0 },
                { 0, 7, 0, 6, 8, 0, 0, 3, 2 },
                { 1, 0, 0, 0, 0, 4, 0, 0, 8 },
                { 5, 0, 0, 2, 1, 9, 0, 6, 0 },
                { 0, 0, 0, 9, 0, 6, 0, 0, 1 },
                { 7, 2, 6, 0, 0, 1, 0, 4, 0 },
                { 0, 0, 1, 4, 7, 0, 0, 5, 6 }
        };
        System.out.println(solveSudoku(sudoku, 0, 0));
        printBoard(sudoku);
        System.out.println("---------------------- Question 7 -------------------------");
        Character maze[][] = {
                { '0', '0', '0', '0' },
                { 'X', '0', 'X', '0' },
                { '0', '0', '0', '0' },
                { '0', 'X', '0', '0' },
        };
        findWayInMaze(maze, 0, 0);
        System.out.println("---------------------- Question 8 -------------------------");
        String keypad[] = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        allDigitsCombinations(keypad, 2, 3, 0, 0);
        System.out.println("---------------------- Question 9 -------------------------");
        Integer knightBoard[][] = new Integer[6][6];
        for (int i = 0; i < knightBoard.length; i++) {
            for (int j = 0; j < knightBoard[0].length; j++) {
                knightBoard[i][j] = 0;
            }
        }
        int dx[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
        int dy[] = { 1, -1, 1, -1, 2, -2, 2, -2 };
        knightBoard[0][0] = 1;
        System.out.println(knightTour(knightBoard, dx, dy, 0, 0, 2));
        printBoard(knightBoard);
        System.out.println("---------------------- Question 10 -------------------------");
    }
}