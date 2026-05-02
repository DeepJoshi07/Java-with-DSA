public class DivideConquer{

    public static void printArray(int arr[]){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[],int si,int ei){
        if(si >= ei)return;

        int mid = si + (ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);

        merge(arr,si,mid,ei);
    }

    private static void merge(int arr[],int si,int mid,int ei){
        int i = si;
        int j = mid+1;
        int k = 0;
        int temp [] = new int[ei-si+1];

        while(i <= mid && j <= ei){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j <= ei){
            temp[k++] = arr[j++];
        }

        for(k = 0,i = si;k < temp.length;i++,k++){
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[],int si,int ei){
        if(si >= ei)return;

        int pivotIdx = pivot(arr,si,ei);

        quickSort(arr, si, pivotIdx-1);
        quickSort(arr, pivotIdx+1, ei);
    }

    private static int pivot(int arr[],int si,int ei){
        int pivotValue = arr[si];
        int k = si;
        
        for(int j = si+1;j <= ei;j++){
            if(arr[j] <= pivotValue){
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
    public static void main(String args[]){
        System.out.println("---------------------- Question 1 ------------------------");
        int arr1[] = {9,8,7,6,5,4,3,2,1};
        mergeSort(arr1,0,arr1.length-1);
        printArray(arr1);
        System.out.println("---------------------- Question 2 ------------------------");
        int arr2[] = {9,8,7,6,5,4,3,2,1};
        quickSort(arr2,0,arr2.length-1);
        printArray(arr2);
        System.out.println("---------------------- Question 3 ------------------------");
        System.out.println("---------------------- Question 4 ------------------------");
        System.out.println("---------------------- Question 5 ------------------------");
        System.out.println("---------------------- Question 6 ------------------------");
    }
}