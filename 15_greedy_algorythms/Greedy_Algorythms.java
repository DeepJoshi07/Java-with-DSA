import java.util.*;
import java.util.Arrays;

public class Greedy_Algorythms {
    public static void activitySelection(int start[],int end[]){
        int activities[][] = new int[start.length][3];
        for(int i = 0;i < start.length;i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> al = new ArrayList<>();
        al.add(activities[0][0]);
        int last = activities[0][2];
        int maxActivities = 1;

        for(int i = 1;i < start.length;i++){
            if(activities[i][1] >= last){
                al.add(activities[i][0]);
                last = activities[i][2];
                maxActivities++;
            }
        }

        for(int i = 0;i < al.size();i++){
            System.out.print("A"+al.get(i)+" ");
        }
        System.out.println();
        System.out.println("total activities are = "+ maxActivities);
    }

    public static void fractionalKnapsack(int val[],int weight[],int totalWeight){
        double ratio[][] = new double[val.length][2];
        
        for(int i = 0;i < val.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = (double)val[i]/weight[i];
        }

        Arrays.sort(ratio,Comparator.comparingDouble(o -> o[1]));
        double maxValue = 0;

        for(int i = val.length-1;i >= 0;i--){
            int idx = (int)ratio[i][0];
            if(totalWeight >= weight[idx]){
                totalWeight -= weight[idx];
                maxValue += val[idx];
            }else{
                maxValue += ratio[i][1] * totalWeight;
                totalWeight = 0;
            }
        }
        System.out.println("maximum value in knapsack is = "+maxValue);
    }

    public static void minSumAbsDifference(int A[],int B[]){
        Arrays.sort(A);
        Arrays.sort(B);

        int minimumDifference = 0;

        for(int i = 0;i < A.length;i++){
            minimumDifference += Math.abs(A[i]-B[i]);
        }

        System.out.println("minimum absolute difference = "+ minimumDifference);
    }

    public static void maxLengthchainOfPair(int pairs[][]){
        Arrays.sort(pairs,Comparator.comparingInt(o -> o[1]));

        int length = 1;
        int last = pairs[0][1];

        for(int i = 1;i < pairs.length;i++){
            int curr = pairs[i][0];
            if(curr > last){
                length++;
                last = pairs[i][1];
            }
        }

        System.out.println("the max length of chain is = "+length);
    }

    public static void indianCoin(Integer coins[],int change){
        Arrays.sort(coins,Comparator.reverseOrder());
        int totalCoins = 0;
        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 0;i < coins.length;i++){
            while(coins[i] <= change){
                totalCoins++;
                change -= coins[i];
                al.add(coins[i]);
            }
        }

        System.out.println("Total minimum coin change = "+totalCoins);
        for(Integer val:al){
            System.out.print(val+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("----------------- Question 1 ---------------");
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        activitySelection(start,end);
        System.out.println("----------------- Question 2 ---------------");
        int val[] = {60,100,120};
        int weight[] = {10,20,30};
        fractionalKnapsack(val,weight,50);
        System.out.println("----------------- Question 3 ---------------");
        int A[] = {4,1,8,7};
        int B[] = {2,3,6,5};
        minSumAbsDifference(A,B);
        System.out.println("----------------- Question 4 ---------------");
        int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        maxLengthchainOfPair(pairs);
        System.out.println("----------------- Question 5 ---------------");
        Integer coins [] = {1,2,5,10,20,50,100,500,2000};
        indianCoin(coins,1059);
        System.out.println("----------------- Question 6 ---------------");
        System.out.println("----------------- Question 7 ---------------");
        System.out.println("----------------- Question 8 ---------------");
        System.out.println("----------------- Question 9 ---------------");
        System.out.println("----------------- Question 10 ---------------");
    }
}
