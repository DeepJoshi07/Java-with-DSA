import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {
   

    public static void main(String[] args) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        pq1.add(7);
        pq1.add(1);
        pq1.add(5);
        pq1.add(2);
        pq1.add(9);

        while (!pq1.isEmpty()) {
            System.out.println(pq1.remove());
        }
        System.out.println("-------------- reverse ------------------");
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.add(7);
        pq2.add(1);
        pq2.add(5);
        pq2.add(2);
        pq2.add(9);

        while (!pq2.isEmpty()) {
            System.out.println(pq2.remove());
        }
    }
}