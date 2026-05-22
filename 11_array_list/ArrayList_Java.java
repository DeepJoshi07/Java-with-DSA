import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ArrayList_Java {
    // Collections.sort()
    // Collections => class
    // Collection => interface
    // Collections.sort(list,Collections.reverseOrder())
    // modulos arithmetic

    // O(n)
    public static void printArrayList(ArrayList<Integer> al) {
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
        System.out.println();
    }
    // O(n)
    public static void printReverseArrayList(ArrayList<Integer> al) {
        for (int i = al.size() - 1; i >= 0; i--) {
            System.out.print(al.get(i) + " ");
        }
        System.out.println();
    }
    // O(n)
    public static int findMaximum(ArrayList<Integer> al) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < al.size(); i++) {
            if (max < al.get(i)) {
                max = al.get(i);
            }
        }
        return max;
    }
    // O(1)
    public static void swap(ArrayList<Integer> al, int idx1, int idx2) {
        int temp = al.get(idx1);
        al.set(idx1, al.get(idx2));
        al.set(idx2, temp);
    }
    // O(n)
    public static int maxWaterInContainer(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() - 1;

        while (lp < rp) {
            int he = Math.min(height.get(rp), height.get(lp));
            int wi = rp - lp;
            int currWater = he * wi;
            maxWater = Math.max(maxWater, currWater);

            if (lp < rp) {
                lp++;
            } else {
                rp++;
            }
        }
        return maxWater;
    }
    // O(n)
    public static boolean pairSum(ArrayList<Integer> nums, int sum) {
        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            if (nums.get(left) + nums.get(right) == sum) {
                return true;
            }
            if (nums.get(left) + nums.get(right) < sum) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
    // O(n)
    public static boolean pairSum2(ArrayList<Integer> nums, int sum) {
        // sorted and roteted array
        int breakingPoint = -1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                breakingPoint = i;
                break;
            }
        }
        if (breakingPoint == -1)
            return false;

        System.out.println(breakingPoint);
        int lp = breakingPoint;
        int rp = breakingPoint - 1;
        int n = nums.size();
        // must be size not size-1
        while (lp != rp) {
            if (nums.get(lp) + nums.get(rp) == sum) {
                return true;
            }

            if (nums.get(lp) + nums.get(rp) < sum) {
                lp = (lp + 1) % n;
                // clock wise
            } else {
                rp = (n + rp - 1) % n;
                // anti/counter clock wise
            }
        }
        return false;
    }

    public static boolean isMonotonic(ArrayList<Integer> al) {
        boolean increment = true;
        boolean decrement = true;

        for (int i = 1; i < al.size(); i++) {
            if (al.get(i) > al.get(i - 1)) {
                decrement = false;
            } else if (al.get(i) < al.get(i - 1)) {
                increment = false;
            }
        }
        return (increment || decrement);
    }

    public static void lonelyNumbers(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            boolean left = i > 0 && Math.abs(nums.get(i) - nums.get(i - 1)) <= 1;
            boolean right = i < nums.size() - 1 && Math.abs(nums.get(i) - nums.get(i + 1)) <= 1;
            if (!left && !right) {
                al.add(nums.get(i));
            }
        }
        System.out.println(al);
    }

    public static void mostFrequentNumber(ArrayList<Integer> al) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < al.size(); i++) {
            if (hm.containsKey(al.get(i))) {
                hm.put(al.get(i), hm.getOrDefault(al.get(i), 0) + 1);
            } else {
                hm.put(al.get(i), 1);
            }
        }

        int mostFrequent = 0;
        int freq = 0;
        for (int key : hm.keySet()) {
            if (hm.get(key) > freq) {
                mostFrequent = key;
                freq = hm.get(key);
            }
        }
        System.out.println("most freq number is : " + mostFrequent);
    }

    public static void butifulArrayList(ArrayList<Integer> al, int size, int start, int increment) {
        if (start + increment > size) {
            al.add(start);
            return;
        }
        butifulArrayList(al, size, start, increment * 2);
        butifulArrayList(al, size, start + increment, increment * 2);
    }

    public static ArrayList<Integer> butifulArrayList2(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);

        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            for(Integer el : result){
                if(el * 2 <= n)al.add(el*2);
            }
             for(Integer el : result){
                if((el * 2 - 1) <= n)al.add(el*2-1);
            }
            result = al;
        }
        return result;
    }

    public static void main(String[] args) {
        // can only initialized with non primitive values like... Integer,String,Boolean
        // part of java collection fram work
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<String> al4 = new ArrayList<>();
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
        al.add(2, 10);
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
        Collections.sort(al, Collections.reverseOrder());
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

        for (int i = 0; i < a.size(); i++) {
            ArrayList<Integer> curr = a.get(i);
            for (int j = 0; j < curr.size(); j++) {
                System.out.print(curr.get(j) + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------");

        // ----------------------------------------------------------

        System.out.println("--------------------- Question 1 -----------------------");
        ArrayList<Integer> height = new ArrayList<>();
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
        System.out.println("--------------------- Question 2 -----------------------");
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        System.out.println(pairSum(nums, 5));
        System.out.println("--------------------- Question 3 -----------------------");
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(11);
        numbers.add(15);
        numbers.add(6);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        System.out.println(pairSum2(numbers, 16));
        System.out.println("--------------------- Question 4 -----------------------");
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(1);
        al1.add(2);
        al1.add(2);
        al1.add(3);
        // -----------
        // al1.add(1);
        // al1.add(3);
        // al1.add(2);
        // ----------
        // al1.add(5);
        // al1.add(4);
        // al1.add(3);
        // al1.add(2);
        // al1.add(1);

        System.out.println(isMonotonic(al1));
        System.out.println("--------------------- Question 5 -----------------------");
        ArrayList<Integer> al5 = new ArrayList<>();
        // al5.add(10);
        // al5.add(5);
        // al5.add(6);
        // al5.add(8);
        // -------------
        al5.add(1);
        al5.add(3);
        al5.add(5);
        al5.add(3);
        lonelyNumbers(al5);
        System.out.println("--------------------- Question 6 -----------------------");
        ArrayList<Integer> al6 = new ArrayList<>();
        al6.add(100);
        al6.add(100);
        al6.add(2);
        al6.add(5);
        al6.add(8);
        al6.add(2);
        al6.add(9);
        al6.add(2);
        mostFrequentNumber(al6);
        System.out.println("--------------------- Question 7 -----------------------");
        // 2 1 4 3
        ArrayList<Integer> al7 = new ArrayList<>();
        butifulArrayList(al7, 5, 1, 1);
        System.out.println(al7);
        ArrayList<Integer> res = butifulArrayList2(4);
        System.out.println(res);
    }
}