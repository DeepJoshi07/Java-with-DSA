import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static int countDistinctElement(int arr[]){
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i < arr.length;i++){
            hs.add(arr[i]);
        }
        return hs.size();
    }
    public static void main(String[] args) {
        System.out.println("---------------------- inplementation ------------------------");
        HashSet<Integer> hs = new HashSet<>();
        hs.add(5);
        hs.add(8);
        hs.add(7);
        hs.add(1);
        hs.add(4);
        hs.add(2);
        hs.add(3);

        System.out.println(hs);
        System.out.println("-----------");
        System.out.println(hs.contains(3));
        System.out.println("-----------");
        System.out.println(hs.size());
        System.out.println("-----------");
        System.out.println(hs.remove(4));
        System.out.println("-----------");
        System.out.println(hs);
        System.out.println("-----------");
        System.out.println(hs.isEmpty());
        System.out.println("-----------");
        hs.clear();
        System.out.println("-----------");
        System.out.println(hs);

        HashSet<String> hs1 = new HashSet<>();
        hs1.add("delhi");
        hs1.add("mumbai");
        hs1.add("noida");
        hs1.add("bengluru");

        Iterator it = hs1.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("-----------------------------");

        for(String val: hs1){
            System.out.println(val);
        }

        System.out.println("---------------------- LinkedHashSet ------------------------");
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("delhi");
        lhs.add("mumbai");
        lhs.add("noida");
        lhs.add("bengluru");
        System.out.println(lhs);
        for(String val:lhs){
            System.out.println(val);
        }
        System.out.println("---------------------- Treeset ------------------------");
        TreeSet<String> ts = new TreeSet<>();
        ts.add("delhi");
        ts.add("mumbai");
        ts.add("noida");
        ts.add("bengluru");
        System.out.println(ts);
        for(String val:ts){
            System.out.println(val);
        }

        System.out.println("---------------------- Question 1 ----------------------");
        int arr [] = {1,4,6,8,9,2,3,4,1,2,4,7,8,0,9,4};
        System.out.println(countDistinctElement(arr));
        System.out.println("---------------------- Question 2 ----------------------");
        int arr1 [] = {1,2,3,4,5};
        int arr2 [] = {3,4,5,6,7};
        union(arr1,arr2);
        intersaction(arr1,arr2);
        System.out.println("---------------------- Question 3 ----------------------");
        System.out.println("---------------------- Question 4 ----------------------");
    }
}
