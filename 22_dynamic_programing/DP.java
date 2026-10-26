import java.util.Arrays;
import java.util.HashSet;

public class DP{
    public static void printMatrix(int matrix[][]){
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void printMatrix2(boolean matrix[][]){
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

    public static boolean targetSumSubset(int numbers[],int sum){
        boolean dp[][] = new boolean[numbers.length+1][sum+1];
        for(int i = 0;i < dp.length;i++){
            dp[i][0] = true;
        }

        for(int i = 1;i < dp.length;i++){
            for(int j = 1;j < dp[0].length;j++){
                int val = numbers[i-1];
                if(val <= j && dp[i-1][j-val] == true){
                    dp[i][j] = true;
                }else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        printMatrix2(dp);
        return dp[numbers.length][sum];
    }

    public static int unboundedKnapsack(int val[],int weight[],int W){
        int dp[][] = new int[val.length+1][W+1];
        for(int i = 0;i < dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j = 0;j < dp[0].length;j++){
            dp[0][j] = 0;
        }
        for(int i = 1;i < dp.length;i++){
            for(int j = 1;j < dp[0].length;j++){
                int v = val[i-1];
                if(weight[i-1] <= j){
                    dp[i][j] = Math.max(v + dp[i][j-weight[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[val.length][W];
    }
    
    public static int coinChange(int coins[],int change){
        int dp[][] = new int[coins.length+1][change+1];
        for(int i = 0;i < dp.length;i++){
            dp[i][0] = 1;
        }
        for(int j = 0;j < dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i = 1;i < dp.length;i++){
            for(int j = 1;j < dp[0].length;j++){
                int val = coins[i-1];
                if(val <= j){
                    dp[i][j] = dp[i][j-val] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][change];
    }
   
    public static int rodCutting(int len[],int price[],int totalRod){
        int dp[][] = new int[price.length+1][totalRod+1];
        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1;i < dp.length;i++){
            for(int j = 1;j < dp[0].length;j++){
                if(len[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1]+ dp[i][j-len[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[price.length][totalRod];
    }
    
    public static int lcs(String s1,int m,String s2,int n){
        if(m < 0 || n < 0)return 0;

        if(s1.charAt(m) == s2.charAt(n)){
            return lcs(s1, m-1, s2, n-1) + 1;
        }else{
            int ans1 = lcs(s1, m-1, s2, n);
            int ans2 = lcs(s1, m, s2, n-1);
            return Math.max(ans1, ans2);
        }
    }

    public static int lcs2(String s1,int m,String s2,int n,int dp[][]){
        if(m < 0 || n < 0)return 0;

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(s1.charAt(m) == s2.charAt(n)){
            dp[m][n] = lcs2(s1, m-1, s2, n-1,dp) + 1;
            return dp[m][n];
        }else{
            int ans1 = lcs2(s1, m-1, s2, n,dp);
            int ans2 = lcs2(s1, m, s2, n-1,dp);
            dp[m][n] = Math.max(ans1, ans2);
            return dp[m][n];
        }
    }
    
    public static int lcs3(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1;i < dp.length;i++ ){
            for(int j = 1;j < dp[0].length;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }
    
    public static int lcSubstring(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;

        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1;i < dp.length;i++){
            for(int j = 1;j < dp[0].length;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
    
    public static int lcsArrays(int a1[],int a2[]){
        int n = a1.length;
        int m = a2.length;
        int dp[][] = new int[n+1][m+1];

        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1;i < dp.length;i++){
            for(int j = 1;j < dp[0].length;j++){
                if(a1[i-1] == a2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int lis(int arr[]){
        // longest increasing subsequence
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i < arr.length;i++){
            hs.add(arr[i]);
        }

        int temp[] = new int[hs.size()];
        int i = 0;
        for(int j: hs){
            temp[i] = j;
            i++;
        }
        Arrays.sort(temp);
        return lcsArrays(arr, temp);
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
        int numbers[] = {4,2,7,1,3};
        int sum =10;
        System.out.println(targetSumSubset(numbers,sum));
        System.out.println("--------------------- Question 5 -----------------------");
        System.out.println(unboundedKnapsack(val,weight,W));
        System.out.println("--------------------- Question 6 -----------------------");
        int coins[] = {2,5,3,6};
        int change = 10;
        System.out.println(coinChange(coins, change));
        System.out.println("--------------------- Question 7 -----------------------");
        int len[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int totalRod = len.length;
        System.out.println(rodCutting(len,price,totalRod));
        System.out.println("--------------------- Question 8 -----------------------");
        String str1 = "abcdge";
        String str2 = "abedg";
        // lowest common subsequeance
        System.out.println(lcs(str1,str1.length()-1,str2,str2.length()-1));
        System.out.println("-----------");
        int dp2[][] = new int[str1.length()+1][str2.length()+1];
        for(int i = 0;i < dp2.length;i++){
            for(int j = 0;j < dp2[0].length;j++){
                dp2[i][j] = -1;
            }
        }
        System.out.println(lcs2(str1, str1.length()-1, str2, str2.length()-1, dp2));
        System.out.println("-----------");
        System.out.println(lcs3(str1,str2));
        System.out.println("--------------------- Question 9 -----------------------");
        // Longest common substring
        String s3 = "ABCDE";
        String s4 = "ABGCE";
        System.out.println(lcSubstring(s3,s4));
        System.out.println("--------------------- Question 10 -----------------------");
        // Longest increasing subsequence
        int arr1[] = {50,3,10,7,40,80};
        System.out.println(lis(arr1));
        System.out.println("--------------------- Question 11 -----------------------");
        System.out.println("--------------------- Question 12 -----------------------");
        System.out.println("--------------------- Question 13 -----------------------");
    }
}