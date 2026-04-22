import java.util.*;

public class Arrays_2D {
    // 2 ways to get stored in memory 
    // 1] row major
    // 2] column major

    public static boolean search(int matrix[][],int key){
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == key){
                    return true;
                }
            }
        }
        return false;
    }

    public static void spiralMatrix(int matrix[][]){
        int rowStart = 0,rowEnd = matrix.length-1;
        int colStart = 0,colEnd = matrix[0].length-1;

        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int i = colStart;i <= colEnd ;i++){
                System.out.print(matrix[rowStart][i]+" ");
            }
            for(int i = rowStart+1;i <= rowEnd ;i++){
                System.out.print(matrix[i][colEnd]+" ");
            }
            for(int i = colEnd-1;i >= colStart ;i--){
                if(rowStart == rowEnd)break;
                // for matrix like {{1,2},
                //                  {3,4},
                //                  {5,6},
                //                  {7,8}}
                System.out.print(matrix[rowEnd][i]+" ");
            }
            for(int i = rowEnd-1;i > rowStart ;i--){
                if(colStart == colEnd)break;
                // for matrix like {{1,2,3,4,},
                //                  {5,6,7,8}}
                // 
                System.out.print(matrix[i][colStart]+" ");
            }
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        System.out.println();
    }
    
    public static int diagonalSum(int matrix[][]){
        int sum = 0;
        for(int i = 0;i < matrix.length;i++){
            sum += matrix[i][i];
            if(i == matrix.length-1-i){
                continue;
            }
            sum += matrix[i][matrix.length-1-i];
        }
        return sum;
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int matrix[][] = new int[3][3];

        // for(int i = 0;i < matrix.length;i++){
        //     for(int j = 0;j < matrix[0].length;j++){
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }
        // for(int i = 0;i < matrix.length;i++){
        //     for(int j = 0;j < matrix[0].length;j++){
        //         System.out.print(matrix[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // sc.close();
        // System.out.println(search(matrix, 9));
        System.out.println("------------------------- Question 1 ------------------------");
        // int spiral[][] = {
        //     {1,2,3,4},
        //     {5,6,7,8},
        //     {9,10,11,12},
        //     {13,14,15,16}
        // };
        int spiral [][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        spiralMatrix(spiral);
        System.out.println("------------------------- Question 2 ------------------------");
        System.out.println(diagonalSum(spiral));
        System.out.println("------------------------- Question 3 ------------------------");
        System.out.println("------------------------- Question 4 ------------------------");
        System.out.println("------------------------- Question 5 ------------------------");
        System.out.println("------------------------- Question 6 ------------------------");
    }
}
