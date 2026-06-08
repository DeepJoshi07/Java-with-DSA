import java.util.*;
import java.util.Arrays;
import java.util.stream.Gatherer.Integrator.Greedy;

public class Greedy_Algorythms {
//     ⚡ Greedy Algorithm Tricks
// Earliest Finish Wins  
// If tasks overlap (like meetings or activities), always pick the one that finishes earliest. This leaves maximum room for others.
// → Example: Activity Selection Problem.

// Highest Ratio First  
// When items have a value/weight tradeoff, sort by value per unit weight and take as much as possible.
// When items have a value/weight tradeoff, sort by value per unit weight and take as much as possible.
// → Example: Fractional Knapsack.

// Local Optimal Choice  
// At each step, ask: “If I make the best choice right now, does it block me from reaching the global optimum?”
// If the answer is no, greedy works.
// → Example: Huffman Coding (always merge two smallest frequencies).

// Sort + Sweep  
// Many greedy problems boil down to:

// Sort by a key (end time, ratio, cost).

// Sweep through, making the best choice at each step.
// → Example: Minimum number of platforms at a railway station.

// Proof by Exchange  
// To prove greedy works, use the “exchange argument”:

// Assume an optimal solution exists.

// Show you can swap greedy’s choice into it without hurting optimality.

// Therefore greedy is correct.
    public static void activitySelection(int start[], int end[]) {
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> al = new ArrayList<>();
        al.add(activities[0][0]);
        int last = activities[0][2];
        int maxActivities = 1;

        for (int i = 1; i < start.length; i++) {
            if (activities[i][1] >= last) {
                al.add(activities[i][0]);
                last = activities[i][2];
                maxActivities++;
            }
        }

        for (int i = 0; i < al.size(); i++) {
            System.out.print("A" + al.get(i) + " ");
        }
        System.out.println();
        System.out.println("total activities are = " + maxActivities);
    }

    public static void fractionalKnapsack(int val[], int weight[], int totalWeight) {
        double ratio[][] = new double[val.length][2];

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (double) val[i] / weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        double maxValue = 0;

        for (int i = val.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (totalWeight >= weight[idx]) {
                totalWeight -= weight[idx];
                maxValue += val[idx];
            } else {
                maxValue += ratio[i][1] * totalWeight;
                totalWeight = 0;
            }
        }
        System.out.println("maximum value in knapsack is = " + maxValue);
    }

    public static void minSumAbsDifference(int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);

        int minimumDifference = 0;

        for (int i = 0; i < A.length; i++) {
            minimumDifference += Math.abs(A[i] - B[i]);
        }

        System.out.println("minimum absolute difference = " + minimumDifference);
    }

    public static void maxLengthchainOfPair(int pairs[][]) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int length = 1;
        int last = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            int curr = pairs[i][0];
            if (curr > last) {
                length++;
                last = pairs[i][1];
            }
        }

        System.out.println("the max length of chain is = " + length);
    }

    public static void indianCoin(Integer coins[], int change) {
        Arrays.sort(coins, Comparator.reverseOrder());
        int totalCoins = 0;
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            while (coins[i] <= change) {
                totalCoins++;
                change -= coins[i];
                al.add(coins[i]);
            }
        }

        System.out.println("Total minimum coin change = " + totalCoins);
        for (Integer val : al) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.deadline = deadline;
            this.id = id;
            this.profit = profit;
        }
    }

    public static void jobSequencing(int jobInfo[][]) {

        ArrayList<Job> job = new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++) {
            job.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(job, ((a, b) -> b.profit - a.profit));

        int time = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < job.size(); i++) {
            Job curr = job.get(i);
            if (curr.deadline > time) {
                time++;
                al.add(curr.id);
            }
        }

        System.out.println("total jobs that can be done are = " + al.size());
        for (int i = 0; i < al.size(); i++) {
            System.out.print("id" + al.get(i) + " ");
        }
        System.out.println();

    }

    public static void chocola(Integer costHor[], Integer costVar[]) {
        Arrays.sort(costVar, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < costHor.length && v < costVar.length) {
            if (costHor[h] <= costVar[v]) {
                cost += hp * costVar[v];
                vp++;
                v++;
            } else {
                cost += vp * costHor[h];
                hp++;
                h++;
            }
        }

        while (h < costHor.length) {
            cost += vp * costHor[h];
            hp++;
            h++;
        }

        while (v < costVar.length) {
            cost += hp * costVar[v];
            vp++;
            v++;
        }

        System.out.println("total minimum cost of cuts = " + cost);
    }

    public static void balancedPartition(String str) {
        int length = str.length();
        int l = 0, r = 0;
        int ans = 0;

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (ch == 'R') {
                r++;
            } else if (ch == 'L') {
                l++;
            }

            if (l == r)
                ans++;
        }

        System.out.println("total number of balanced partition are : " + ans);
    }

    public static int kthOdd(int[] range, int K) {
        if (K <= 0)
            return 0;
        int L = range[0];
        int R = range[1];

        int count;
        if ((R & 1) == 1) { // R is odd
            count = (int) Math.ceil((R - L + 1) / 2.0);
            if (K > count)
                return 0;
            return R - 2 * K + 2; // K-th odd from end
        } else { // R is even
            count = (R - L + 1) / 2;
            if (K > count)
                return 0;
            return R - 2 * K + 1; // K-th odd from end
        }
    }

    public static char[] lexicoSmall(int n, int k) {
        char arr[] = new char[n];
        Arrays.fill(arr, 'a');
        for (int i = n - 1; i >= 0; i--) {
            k -= i;
            if (k >= 0) {
                if (k >= 26) {
                    arr[i] = 'z';
                    k -= 26;
                } else {
                    arr[i] = (char) (k + 97 - 1);
                    k -= arr[i] - 'a' + 1;
                }
            } else
                break;
            k += i;
        }
        return arr;
    }

    public static int findPlatforms(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int i = 0, j = 0;
        int platforms = 0, maxPlatforms = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms++;   // train arrives
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            } else {
                platforms--;   // train departs
                j++;
            }
        }
        return maxPlatforms;
    }
    
    public static void main(String[] args) {
        System.out.println("----------------- Question 1 ---------------");
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        activitySelection(start, end);
        System.out.println("----------------- Question 2 ---------------");
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        fractionalKnapsack(val, weight, 50);
        System.out.println("----------------- Question 3 ---------------");
        int A[] = { 4, 1, 8, 7 };
        int B[] = { 2, 3, 6, 5 };
        minSumAbsDifference(A, B);
        System.out.println("----------------- Question 4 ---------------");
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        maxLengthchainOfPair(pairs);
        System.out.println("----------------- Question 5 ---------------");
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        indianCoin(coins, 1059);
        System.out.println("----------------- Question 6 ---------------");
        int jobInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        jobSequencing(jobInfo);
        System.out.println("----------------- Question 7 ---------------");
        Integer costVar[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };
        chocola(costHor, costVar);
        System.out.println("----------------- Question 8 ---------------");
        String str = "LRRRRLLRLLRL";
        balancedPartition(str);
        System.out.println("----------------- Question 9 ---------------");
        int range[] = { -10, 10 };
        System.out.println(kthOdd(range, 8));
        System.out.println("----------------- Question 10 ---------------");
        char charArr[] = lexicoSmall(5, 42);
        System.out.println(new String(charArr));
        System.out.println("----------------- Question 11 ---------------");
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println("Minimum platforms needed = " + findPlatforms(arr, dep));
    }
}
