import java.util.*;

public class Arrays {
    public static int linearSearch(int arr[],int key){
        if(arr[0] == key)return 0;
        if(arr[arr.length-1] == key)return arr.length-1;

        for(int i = 0;i < arr.length;i++){
            if(arr[i] == key)return i;
        }
        return -1;
    } 

    public static int binarySearch(int arr[],int key){
        int si = 0;
        int ei = arr.length-1;

        while(si <= ei){
            int mid = si + (ei-si)/2;
            if(arr[mid] == key)return mid;
            if(arr[mid] > key){
                ei = mid-1;
            }else{
                si = mid + 1;
            }
        }
        return -1;
    }
    
    public static void reverseArray(int arr[]){
        int size = arr.length;
        for(int i = 0;i < size/2;i++){
            int temp = arr[i];
            arr[i] = arr[size-1-i];
            arr[size-1-i] = temp;
        }
    }

    public static void printArray(int arr[]){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static void pairsInArray(int arr[]){
        int total = 0;
        for(int i = 0;i < arr.length;i++){
            for(int j = i+1;j < arr.length;j++){
                System.out.print("("+arr[i]+","+arr[j]+")");
                total += 1;
            }
            System.out.println();
        }
        System.out.println("total is : "+total);
    }

    public static void printSubArrays(int arr[]){
        int maxSum = 0;
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr.length;j++){
                int currSum = 0;
                for(int k = i;k <= j;k++){
                    System.out.print(arr[k]+" ");
                    currSum += arr[k];
                }
                maxSum = Math.max(maxSum, currSum);
                if(currSum == 0)continue;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("maximum sum is : "+maxSum);
    }
    
    public static int largest(int arr[]){
        int maximum = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] > maximum){
                maximum = arr[i];
            }
        }
        return maximum;
    }
    
    public static int maxSumInSubArrayPrefix(int arr[]){
        int prefixSum [] = new int[arr.length];
        prefixSum[0] = arr[0];
        for(int i = 1;i < arr.length;i++){
            prefixSum[i] = arr[i] + prefixSum[i-1];
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length;i++){
            for(int j = i;j < arr.length;j++){
                int currSum = i == 0?prefixSum[j]:prefixSum[j]-prefixSum[i-1];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
    
    public static int kadansMaxSubArraySum(int arr[]){
        int maxSum = arr[0];
        int currSum = arr[0];
        for(int i = 1;i < arr.length;i++){
            currSum = Math.max(arr[i],(currSum+arr[i]));
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
    
    public static int trapingRainWater(int arr[]){
        int nextLeftLargest[] = new int [arr.length];
        int nextRightLargest[] = new int [arr.length];
        nextLeftLargest[0] = arr[0];
        for(int i = 1;i < arr.length;i++){
            nextLeftLargest[i] = Math.max(arr[i], nextLeftLargest[i-1]);
        }
         nextRightLargest[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length-2;i >= 0;i--){
            nextRightLargest[i] = Math.max(arr[i], nextRightLargest[i+1]);
        }
        int totalWater = 0;
        for(int i = 0;i < arr.length;i++){
            totalWater += Math.min(nextLeftLargest[i], nextRightLargest[i]) - arr[i];
        }
        return totalWater;
    }
   
    public static int maxStockProfit(int arr[]){
        int maxProfit = Integer.MIN_VALUE;
        int buyPrice = Integer.MAX_VALUE;

        for(int i = 0;i < arr.length;i++){
            if(buyPrice > arr[i]){
                buyPrice = arr[i];
            }else{
                maxProfit = Math.max(maxProfit,(arr[i]-buyPrice));
            }
        }
        return Math.max(maxProfit, 0);
    }

    public static boolean containDuplicate(int arr[]){
        for(int i = 0;i < arr.length;i++){
            for(int j = i+1;j < arr.length;j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static int targetInRoutatedArray(int arr[],int target){
        int minIdx = searchMin(arr);
        if(arr[minIdx] <= target && target <= arr[arr.length-1]){
            return search(arr,minIdx,arr.length-1,target);
        }else{
            return search(arr,0,minIdx,target);
        }
    }

    private static int search(int arr[],int l,int r,int target){
        int left = l;
        int right = r;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int searchMin(int arr[]){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(mid > 0 && arr[mid] < arr[mid-1]){
                return mid;
            }
            if(arr[left] <= arr[mid] && arr[mid] > arr[right]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    
    public static int trapingRainWater2(int arr[]){
        int left = 0,right = arr.length-1,leftMax = arr[left],rightMax = arr[right], res = 0;
        while(left < right){
            if(arr[leftMax] < arr[rightMax]){
                left++;
                leftMax = Math.max(arr[left],leftMax);
                res += leftMax - arr[left];
            }else{
                right--;
                rightMax = Math.max(arr[right],rightMax);
                res += rightMax - arr[right];
            }
        }
        return res;
    }
   
    public static void triplets(int arr[]){
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for(int i = 0;i < arr.length;i++){
            for(int j = i+1;j < arr.length;j++){
                for(int k = j+1;k < arr.length;k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(arr[i]);
                        triplet.add(arr[j]);
                        triplet.add(arr[k]);
                        Collections.sort(triplet);
                        list.add(triplet);
                    }
                }
            }
        }
        list = new ArrayList<List<Integer>>(new LinkedHashSet<List<Integer>>(list));
        System.out.println(list);
    }
    public static void main(String args[]){
        System.out.println("-------------------- Question 1 ---------------------");
        int nums[] = {9,4,5,6,7,1,2,4,3};
        System.out.println(linearSearch(nums, 5));
        System.out.println("-------------------- Question 2 ---------------------");
        int sortedNums [] = {1,3,5,7,9,11,13,14,15,16};
        System.out.println(linearSearch(sortedNums, 9));
        System.out.println("-------------------- Question 3 ---------------------");
        reverseArray(sortedNums);
        printArray(sortedNums);
        System.out.println("-------------------- Question 4 ---------------------");
        pairsInArray(sortedNums);
        System.out.println("-------------------- Question 5 ---------------------");
        printSubArrays(sortedNums);
        System.out.println("-------------------- Question 6 ---------------------");
        System.out.println(largest(sortedNums));
        System.out.println("-------------------- Question 7 ---------------------");
        System.out.println("maximum subArray Sum : "+ maxSumInSubArrayPrefix(sortedNums));
        System.out.println("-------------------- Question 8 ---------------------");
        System.out.println(kadansMaxSubArraySum(sortedNums));
        System.out.println("-------------------- Question 9 ---------------------");
        int height [] = {4,2,0,6,3,2,5};
        System.out.println(trapingRainWater(height));
        System.out.println("-------------------- Question 10 ---------------------");
        int prices [] = {7,1,5,3,6,4};
        System.out.println(maxStockProfit(prices));
        System.out.println("-------------------- Question 11 ---------------------");
        int nums2[] = {1,2,3,4,5,6,1};
        System.out.println(containDuplicate(nums2));
        System.out.println("-------------------- Question 12 ---------------------");
        int routatedArray[] = {4,5,6,7,0,1,2};
        System.out.println(targetInRoutatedArray(routatedArray, 1));
        System.out.println("-------------------- Question 13 ---------------------");
        // int height2[] = {0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};
        int height2[] = {4,2,0,3,2,5};
        System.out.println(trapingRainWater2(height2));
        System.out.println("-------------------- Question 14 ---------------------");
        int numArray[] = {-1,0,1,2,-1,-4};
        triplets(numArray);
        System.out.println("-------------------- Question 15 ---------------------");
        System.out.println("-------------------- Question 16 ---------------------");
    }
}
