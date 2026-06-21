import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s) {
            return this.rank - s.rank;
        }
    }

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
        System.out.println("-------------- with objects ------------------");
        PriorityQueue<Student> pq3 = new PriorityQueue<>();
        pq3.add(new Student("deep", 5));
        pq3.add(new Student("harman", 2));
        pq3.add(new Student("jacob", 4));
        pq3.add(new Student("jimmy", 3));
        pq3.add(new Student("roman", 1));

        while (!pq3.isEmpty()) {
            System.out.println(pq3.peek().name + ", " + pq3.peek().rank);
            pq3.remove();
        }
    }
}