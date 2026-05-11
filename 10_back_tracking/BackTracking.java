public class BackTracking{
    public static void printArray(int arr[]){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void changeArray(int arr[],int i,int val){
        if(i == arr.length){
            printArray(arr);
            return;
        }

        arr[i] = val;
        changeArray(arr, i+1, val+1);
        arr[i] = arr[i] - 2;
    }

    public static void allSubstring(String str,int i,StringBuilder sb){
        if(i == str.length()){
            if(sb.length() == 0){
                System.out.println("Null");
            }else{
                System.out.println(sb.toString());
            }
            return;
        }
        sb.append(str.charAt(i));
        allSubstring(str, i+1, sb);
        sb.deleteCharAt(sb.length()-1);
        allSubstring(str, i+1, sb);
    }

    public static void allPermutation(String s,StringBuilder sb){
        if(s.length() == 0){
            System.out.println(sb.toString());
            return;
        }
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            String newString = s.substring(0,i)+ s.substring(i+1);
            allPermutation(newString, sb.append(ch));
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public static <T> void printBoard(T board[][]){
        System.out.println("----------- Board -----------");
        for(T rows[]:board){
            for(T cell:rows){
                System.out.print(cell+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void nQueens(Character board[][],int row){
        if(row == board.length){
            printBoard(board);
            return;
        }

        for(int i = 0;i < board[0].length;i++){
            if(isSafe(board,row,i)){
                board[row][i] = 'Q';
                nQueens(board, row+1);
                board[row][i] = 'X';
            }
        }
    }

    public static boolean isNQueens(Character board[][],int row){
        if(row == board.length){
            return true;
        }

        for(int i = 0;i < board[0].length;i++){
            if(isSafe(board,row,i)){
                board[row][i] = 'Q';
                if(isNQueens(board, row+1)){
                    return true;
                };
                board[row][i] = 'X';
            }
        }
        return false;
    }

    public static int count = 0;
    public static void nQueensCount(Character board[][],int row){
        if(row == board.length){
            count++;
            return;
        }

        for(int i = 0;i < board[0].length;i++){
            if(isSafe(board,row,i)){
                board[row][i] = 'Q';
                nQueensCount(board, row+1);
                board[row][i] = 'X';
            }
        }
    }

    private static boolean isSafe(Character board[][],int row,int col){
        for(int i = row-1;i >= 0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        for(int i = row,j = col; i >= 0 && j >= 0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i = row,j = col; i >= 0 && j < board[0].length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    
    public static int gridWays(int n,int m,int i,int j){
        if(i == n && j == m)return 1;

        if(i > n || j > m)return 0;

        int way1 = gridWays(n, m, i+1, j);
        int way2 = gridWays(n, m, i, j+1);

        return way1 + way2;
    }

    public static int factorial(int n){
        if(n == 0)return 1;

        return n * factorial(n-1);
    }

    public static int gridWays2(int n,int m){
        return factorial(n+m-2) /(factorial(n-1) * factorial(m-1));
    }
    public static void main(String args[]){
        System.out.println("---------------------- Question 1 -------------------------");
        int arr[] = new int[5];
        changeArray(arr,0,1);
        printArray(arr);
        System.out.println("---------------------- Question 2 -------------------------");
        allSubstring("abc",0,new StringBuilder(""));
        System.out.println("---------------------- Question 3 -------------------------");
        allPermutation("abc",new StringBuilder());
        System.out.println("---------------------- Question 4 -------------------------");
        Character board[][] = new Character[5][5];
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                board[i][j] = 'X';
            }
        }
        // printBoard(board);
        nQueens(board, 0);
        System.out.println("----------------");
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                board[i][j] = 'X';
            }
        }
        System.out.println(isNQueens(board, 0));
        System.out.println("----------------");
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                board[i][j] = 'X';
            }
        }
        nQueensCount(board, 0);
        System.out.println("the total way to put n queens on board are : "+count);
        System.out.println("---------------------- Question 5 -------------------------");
        System.out.println(gridWays(4, 4, 1, 1));
        System.out.println(gridWays2(4, 4));
        System.out.println("---------------------- Question 6 -------------------------");
        System.out.println("---------------------- Question 7 -------------------------");
        System.out.println("---------------------- Question 8 -------------------------");
    }
}