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
        System.out.println("-------------------- Question 8 ---------------------");
        System.out.println("-------------------- Question 9 ---------------------");
        System.out.println("-------------------- Question 10 ---------------------");
        System.out.println("-------------------- Question 11 ---------------------");
        System.out.println("-------------------- Question 12 ---------------------");
        System.out.println("-------------------- Question 13 ---------------------");
        System.out.println("-------------------- Question 14 ---------------------");
        System.out.println("-------------------- Question 15 ---------------------");
        System.out.println("-------------------- Question 16 ---------------------");
    }
}
