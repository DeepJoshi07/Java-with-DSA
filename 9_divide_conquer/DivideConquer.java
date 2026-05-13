import java.util.*;
import java.util.Arrays;
public class DivideConquer {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printStringArray(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // O(nlogn)
    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei)
            return;

        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);

        merge(arr, si, mid, ei);
    }

    private static void merge(int arr[], int si, int mid, int ei) {
        int i = si;
        int j = mid + 1;
        int k = 0;
        int temp[] = new int[ei - si + 1];

        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }
    }

    // O(n^2) worst case
    // O(nlogn) best case
    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei)
            return;

        int pivotIdx = pivot(arr, si, ei);

        quickSort(arr, si, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, ei);
    }

    private static int pivot(int arr[], int si, int ei) {
        int pivotValue = arr[si];
        int k = si;

        for (int j = si + 1; j <= ei; j++) {
            if (arr[j] <= pivotValue) {
                k++;
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = pivotValue;
        arr[si] = arr[k];
        arr[k] = temp;

        return k;
    }

    // O(logn) both time and space
    public static int searchInSortedAndRoutatedArray(int arr[], int si, int ei, int target) {
        if (si > ei)
            return -1;

        int mid = si + (ei - si) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] >= arr[si]) {
            if (target >= arr[si] && target < arr[mid]) {
                return searchInSortedAndRoutatedArray(arr, si, mid - 1, target);
            } else {
                return searchInSortedAndRoutatedArray(arr, mid + 1, ei, target);
            }
        } else {
            if (target > arr[mid] && target <= arr[ei]) {
                return searchInSortedAndRoutatedArray(arr, mid + 1, ei, target);
            } else {
                return searchInSortedAndRoutatedArray(arr, si, mid - 1, target);
            }
        }
    }

    // O(nlogn)
    public static void sortStringArray(String str[], int si, int ei) {
        if (si >= ei)
            return;

        int mid = si + (ei - si) / 2;

        sortStringArray(str, si, mid);
        sortStringArray(str, mid + 1, ei);

        mergeStringArray(str, si, mid, ei);
    }

    private static void mergeStringArray(String str[], int si, int mid, int ei) {
        int i = si;
        int j = mid + 1;
        String temp[] = new String[ei - si + 1];
        int k = 0;

        while (i <= mid && j <= ei) {
            if (str[i].compareToIgnoreCase(str[j]) < 0) {
                temp[k++] = str[i++];
            } else {
                temp[k++] = str[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = str[i++];
        }

        while (j <= ei) {
            temp[k++] = str[j++];
        }

        for (k = 0, i = si; k < temp.length; i++, k++) {
            str[i] = temp[k];
        }
    }

    // O(nlogn)
    public static int majorityElement(int nums[], int si, int ei) {
        if (si == ei)
            return nums[si];

        int mid = si + (ei - si) / 2;

        int left = majorityElement(nums, si, mid);
        int right = majorityElement(nums, mid + 1, ei);

        int countLeft = countInRange(nums, si, mid, left);
        int countRight = countInRange(nums, mid + 1, ei, right);

        return countLeft > countRight ? left : right;
    }

    private static int countInRange(int nums[], int si, int ei, int num) {
        int count = 0;
        for (int i = si; i <= ei; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    // O(nlogn)
    public static int inversionCount(int arr[],int si, int ei){
       int count = 0;
        if(si < ei){
            int mid = si + (ei-si)/2;
            count = inversionCount(arr, si, mid);
            count += inversionCount(arr, mid+1, ei);
            count += inversionSort(arr, si, mid, ei);
        }
        return count;
    }

    private static int inversionSort(int arr[],int si,int mid,int ei){
        int i = si;
        int j = mid+1;
        int k = 0;
        int temp[] = new int[ei-si+1]; 
        int count = 0;
        while(i <= mid && j <= ei){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
                count += (mid-i+1);
            }
        }

        while(i <= mid){
            temp[k++]=arr[i++];
        }

        while(j <= ei){
            temp[k++]=arr[j++];
        }

        for(k = 0,i = si;k < temp.length;k++,i++){
            arr[i] = temp[k];
        }
        return count;

    }

    private static int getMax(int arr[],int n){
        int max = arr[0];
        for(int i = 1;i < n;i++){
            if(max < arr[i]) max = arr[i];
        }
        return max;
    }

    private static void countSort(int arr[],int n, int exp){
        // arr = [4, 2, 2, 8, 3, 3, 1]
        // count = [0, 1, 2, 2, 1, 0, 0, 0, 1]
        // count2 = [0, 1, 3, 5, 6, 6, 6, 6, 7]
        // count2 = [0, 1-1, 3-1-1, 5-1-1, 6, 6, 6, 6-1, 7]
        // output = [1,2,2,3,3,4,8]
        int output[] = new int[n];
        int count [] = new int[10];
        int i;
        Arrays.fill(count,0);

        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void radixSort(int arr[],int n){
        int max = getMax(arr, n);
        for(int exp = 1;max/exp > 0;exp*=10){
            countSort(arr, n, exp);
        }
    }

    
    public static void main(String args[]) {
        System.out.println("---------------------- Question 1 ------------------------");
        int arr1[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        mergeSort(arr1, 0, arr1.length - 1);
        printArray(arr1);
        System.out.println("---------------------- Question 2 ------------------------");
        int arr2[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        quickSort(arr2, 0, arr2.length - 1);
        printArray(arr2);
        System.out.println("---------------------- Question 3 ------------------------");
        int arr3[] = { 4, 5, 6, 7, 0, 1, 2, 3 };
        System.out.println(searchInSortedAndRoutatedArray(arr3, 0, arr3.length - 1, 0));
        System.out.println("---------------------- Question 4 ------------------------");
        String stringArray[] = {"sun","earth","mars","mercury"};
        sortStringArray(stringArray, 0, stringArray.length-1);
        printStringArray(stringArray);
        System.out.println("---------------------- Question 5 ------------------------");
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums, 0, nums.length-1));
        System.out.println("---------------------- Question 6 ------------------------");
        int arr4[] = {2,4,1,3,5};
        System.out.println(inversionCount(arr4,0,arr4.length-1));
        System.out.println("---------------------- Question 7 ------------------------");
        int arr5[] = {2,4,1,3,5};
        radixSort(arr5, arr5.length);
        printArray(arr5);
    }
} 