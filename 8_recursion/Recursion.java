public class Recursion{
    public static void printNumbersNto1(int num){
        if(num == 0)return;
        System.out.println(num);
        printNumbersNto1(num-1);
    }

    public static void printNumbers1ToN(int number){
        if(number == 0)return;
        printNumbers1ToN(number-1);
        System.out.println(number);
    }

    public static int sumOfNnaturalNumbers(int num){
        if(num == 0)return 0;
        return num + sumOfNnaturalNumbers(num-1);
    }

    public static int printNthFibonachi(int n){
        if(n == 0 || n == 1)return n;
        return printNthFibonachi(n-1) + printNthFibonachi(n-2);
    }

    public static boolean arrSortedOrNot(int arr[],int size){
        if(size < 1)return true;
        
        if(arr[size] < arr[size-1]){
            return false;
        }

        return arrSortedOrNot(arr, size-1);
    }

    public static int firstOccurance(int arr[],int i,int target){
        if(i == arr.length-1)return -1;

        if(arr[i] == target)return i;

        return firstOccurance(arr, i+1, target);
    }

    public static void lastOccurance(int arr[],int i,int target){

    }
    public static void main(String args[]){
        System.out.println("-------------------------- Question 1 -----------------------");
        printNumbersNto1(10);
        System.out.println("-------------------------- Question 2 -----------------------");
        printNumbers1ToN(10);
        System.out.println("-------------------------- Question 3 -----------------------");
        System.out.println(sumOfNnaturalNumbers(10));
        System.out.println("-------------------------- Question 4 -----------------------");
        System.out.println(printNthFibonachi(11));
        System.out.println("-------------------------- Question 5 -----------------------");
        int arr [] = {1,2,3,4,5,6,2};
        System.out.println(arrSortedOrNot(arr, arr.length-1));
        System.out.println("-------------------------- Question 6 -----------------------");
        System.out.println(firstOccurance(arr,0,6));
        System.out.println("-------------------------- Question 7 -----------------------");
        
        System.out.println("-------------------------- Question 8 -----------------------");
        System.out.println("-------------------------- Question 9 -----------------------");
        System.out.println("-------------------------- Question 109 -----------------------");
    }
}