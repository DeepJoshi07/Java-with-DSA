import java.util.Arrays;

public class DP{
    public static void printMatrix(int matrix[][]){
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int fibonachhi(int num,int arr[]){
        if(num == 0 || num == 1)return num;

        if(arr[num] != 0){
            return arr[num];
        }

        int fibo = fibonachhi(num-1, arr) + fibonachhi(num-2, arr);
        arr[num] = fibo;
        return fibo;
    }

    public static int fibonachhi2(int num){
        int dp[] = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2;i <= num;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[num];
    }

    public static int countingStairs(int stairs,int ways[]){
        if(stairs == 0)return 1;
        if(stairs < 0)return 0;
        if(ways[stairs] != -1){
            return ways[stairs];
        }
        ways[stairs] = countingStairs(stairs-1, ways) + countingStairs(stairs-2, ways);
        return ways[stairs];
    }

    public static int countingStairs2(int stairs){
        int dp[] = new int[stairs+1];
        dp[0] = 1;

        for(int i = 1;i < dp.length;i++){
            if(i == 1){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[stairs];
    }
    public static int knapsack(int val[],int weight[],int W,int items){
        if(W == 0 || items == 0)return 0;

        if(weight[items] <= W){
            int ans1 = val[items] + knapsack(val, weight, W-weight[items], items-1);
            int ans2 = knapsack(val, weight, W, items-1);
            return Math.max(ans1, ans2);
        }else{
            return knapsack(val, weight, W, items-1);
        }
    }

    public static int knapsack2(int val[],int weight[],int W,int items,int dp[][]){
        if(W == 0 || items == 0)return 0;

        if(dp[items][W] != -1){
            return dp[items][W];
        }

        if(weight[items] <= W){
            int ans1 = val[items] + knapsack(val, weight, W-weight[items], items-1);
            int ans2 = knapsack(val, weight, W, items-1);
            dp[items][W] = Math.max(ans1, ans2);
            return dp[items][W];
        }else{
            dp[items][W] = knapsack(val, weight, W, items-1);
            return dp[items][W];
        }
    }

    public static int knapsack3(int val[],int wt[],int W){
        int dp[][] = new int[val.length+1][W+1];
        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        for(int i = 0;i < dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j = 0;j < dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i = 1;i < dp.length;i++){
            for(int j = 1;j < dp[0].length;j++){
                if(wt[i-1] <= j){
                    int include = val[i-1] + dp[i-1][j-wt[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include,exclude);
                }else{
                    int exclude = dp[i-1][j];
                    dp[i][j] = exclude;
                }
            }
        }

        printMatrix(dp);

        return dp[val.length][W];
    }
   
     public static void main(String[] args) {
        System.out.println("--------------------- Question 1 -----------------------");
        int num = 6;
        int arr[] = new int[num+1];
        for(int i = 0;i < arr.length;i++){
            arr[i] = 0;
        }
        System.out.println(fibonachhi(num,arr));
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("-----------");
        System.out.println(fibonachhi2(num));
        System.out.println("--------------------- Question 2 -----------------------");
        int stairs = 6;
        int ways[] = new int[stairs+1];
        Arrays.fill(ways, -1);
        System.out.println(countingStairs(stairs,ways));
        System.out.println("------------");
        System.out.println(countingStairs2(stairs));
        System.out.println("--------------------- Question 3 -----------------------");
        int val[] = {15,14,10,45,30};
        int weight[] = {2,5,1,3,4};
        int W = 7;
        System.out.println(knapsack(val,weight,W,val.length-1));
        System.out.println("------------");
        int dp[][] = new int[val.length+1][W+1];
        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack2(val, weight, W, val.length-1,dp)); 
        System.out.println("------------");
        System.out.println(knapsack3(val, weight, W));
        System.out.println("--------------------- Question 4 -----------------------");
    
        System.out.println("--------------------- Question 5 -----------------------");
        System.out.println("--------------------- Question 6 -----------------------");
    }
}