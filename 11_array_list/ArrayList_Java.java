import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_Java{
    // Collections.sort()
    // Collections => class
    // Collection => interface
    // COllections.sort(list,Collections.reverseOrder())

    public static void printArrayList(ArrayList<Integer>al){
        for(int i = 0;i < al.size();i++){
            System.out.print(al.get(i)+" ");
        }
        System.out.println();
    }

    public static void printReverseArrayList(ArrayList<Integer>al){
        for(int i = al.size()-1;i >= 0;i--){
            System.out.print(al.get(i)+" ");
        }
        System.out.println();
    }

    public static int findMaximum(ArrayList<Integer>al){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < al.size();i++){
            if(max < al.get(i)){
                max = al.get(i);
            }
        }
        return max;
    }

    public static void swap(ArrayList<Integer>al,int idx1,int idx2){
        int temp = al.get(idx1);
        al.set(idx1,al.get(idx2));
        al.set(idx2,temp);
    }

    public static int maxWaterInContainer(ArrayList<Integer>height){
        int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;

        while(lp < rp){
            int he = Math.min(height.get(rp), height.get(lp));
            int wi = rp - lp;
            int currWater = he * wi;
            maxWater = Math.max(maxWater, currWater);

            if(lp < rp){
                lp++;
            }else{
                rp++;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        // can only initialized with non primitive values like... Integer,String,Boolean
        // part of java collection fram work
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<String> al2 = new ArrayList<>();
        ArrayList<Boolean> al3 = new ArrayList<>();

        // O(1)
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        System.out.println(al);

        // O(1)
        System.out.println(al.get(2));

        // O(n)
        System.out.println(al.remove(2));
        System.out.println(al);

        // O(n)
        al.set(2, 3);
        System.out.println(al);

        // O(n)
        al.add(2,10);
        System.out.println(al);

        System.out.println(al.contains(10));

        System.out.println(al.size());

        printArrayList(al);

        printReverseArrayList(al);

        System.out.println(findMaximum(al));

        System.out.println(al);

        swap(al, 2, 4);

        System.out.println(al);

        Collections.sort(al);
        System.out.println(al);
        Collections.sort(al,Collections.reverseOrder());
        System.out.println(al);

        // ----------------------------------------------------------
        System.out.println("--------------------------");
        // nasted arraylist

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        a1.add(5);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(6);
        a2.add(7);
        a2.add(8);
        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(9);
        a3.add(10);
        a3.add(11);
        a3.add(12);
        a3.add(13);

        a.add(a1);
        a.add(a2);
        a.add(a3);

        System.out.println(a);

        for(int i = 0;i < a.size();i++){
            ArrayList<Integer> curr = a.get(i);
            for(int j = 0;j < curr.size();j++){
                System.out.print(curr.get(j)+" ");
            } 
            System.out.println();
        }
        System.out.println("--------------------------");

        // ----------------------------------------------------------

        System.out.println("--------------------- Question 1 -----------------------");
        ArrayList<Integer> height =  new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(maxWaterInContainer(height));
    }
}