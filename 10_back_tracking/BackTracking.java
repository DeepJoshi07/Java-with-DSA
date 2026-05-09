public class BackTracking{
    public static void printArray(int arr[]){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void changeArray(int arr[],int i,int val){
        if(i == arr.length){
            printArray(arr);
            return;
        }

        arr[i] = val;
        changeArray(arr, i+1, val+1);
        arr[i] = arr[i] - 2;
    }

    public static void allSubstring(String str,int i,StringBuilder sb){
        if(i == str.length()){
            if(sb.length() == 0){
                System.out.println("Null");
            }else{
                System.out.println(sb.toString());
            }
            return;
        }
        sb.append(str.charAt(i));
        allSubstring(str, i+1, sb);
        sb.deleteCharAt(sb.length()-1);
        allSubstring(str, i+1, sb);
    }

    public static void allPermutation(String s,StringBuilder sb){
        if(s.length() == 0){
            System.out.println(sb.toString());
            return;
        }
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            String newString = s.substring(0,i)+ s.substring(i+1);
            allPermutation(newString, sb.append(ch));
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String args[]){
        System.out.println("---------------------- Question 1 -------------------------");
        int arr[] = new int[5];
        changeArray(arr,0,1);
        printArray(arr);
        System.out.println("---------------------- Question 2 -------------------------");
        allSubstring("abc",0,new StringBuilder(""));
        System.out.println("---------------------- Question 3 -------------------------");
        allPermutation("abc",new StringBuilder());
        System.out.println("---------------------- Question 1 -------------------------");
        System.out.println("---------------------- Question 1 -------------------------");
        System.out.println("---------------------- Question 1 -------------------------");
        System.out.println("---------------------- Question 1 -------------------------");
    }
}