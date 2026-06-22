import java.util.ArrayList;

public class Heaps_Imp {
    ArrayList<Integer> al = new ArrayList<>();

    public void insert(int data) {
        al.add(data);

        int x = al.size() - 1;
        int parent = (x - 1) / 2;

        while (al.get(x) < al.get(parent)) {
            int temp = al.get(x);
            al.set(x, al.get(parent));
            al.set(parent, temp);

            x = parent;
            parent = (x - 1) / 2;
        }
    }

    public static void main(String[] args) {

    }
}
