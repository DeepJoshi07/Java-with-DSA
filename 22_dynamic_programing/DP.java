import java.util.Arrays;

public class DP{
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

        System.out.println("--------------------- Question 4 -----------------------");
    
        System.out.println("--------------------- Question 5 -----------------------");
        System.out.println("--------------------- Question 6 -----------------------");
    }
}