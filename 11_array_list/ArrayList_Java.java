import java.util.ArrayList;

public class ArrayList_Java{
    public static void main(String[] args) {
        // can only initialized with non primitive values like... Integer,String,Boolean
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
    }
}