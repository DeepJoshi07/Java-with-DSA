public class Sorting{

    public static void printArray(int arr[]){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void bubbleSort(int arr[]){
        for(int i = 0;i < arr.length-1;i++){
            boolean swap = false;
            for(int j = 0;j < arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
        printArray(arr);
    }
   
    public static void selectionSort(int arr[]){}
   
    public static void insertionSort(int arr[]){}
   
    public static void countingSort(int arr[]){}
    public static void main(String args[]){
        System.out.println("--------------------- Question 1 --------------------------");
        int arr1 [] = {9,8,7,6,5,4,3,2,1};
        bubbleSort(arr1);
        System.out.println("--------------------- Question 2 --------------------------");
        int arr2 [] = {9,8,7,6,5,4,3,2,1};
        selectionSort(arr2);
        System.out.println("--------------------- Question 3 --------------------------");
        int arr3 [] = {9,8,7,6,5,4,3,2,1};
        insertionSort(arr3);
        System.out.println("--------------------- Question 4 --------------------------");
        int arr4 [] = {9,8,7,6,5,4,3,2,1};
        countingSort(arr4);
        System.out.println("--------------------- Question 5 --------------------------");
        // int arr5 [] = {9,8,7,6,5,4,3,2,1};
    }
}