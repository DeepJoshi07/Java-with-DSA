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

    static class CarInfo implements Comparable<CarInfo>{
        int x,y,idx;
        int distenceSquare;

        public CarInfo(int idx,int x,int y,int ds){
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.distenceSquare = ds;
        }

        @Override
        public int compareTo(CarInfo c){
            return this.distenceSquare - c.distenceSquare;
        }
    }
    public static void kNearestCars(int arr[][],int k){
        PriorityQueue<CarInfo> pq = new PriorityQueue<>();
        for(int i = 0;i < arr.length;i++){
            int distSq = arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1];
            pq.add(new CarInfo(i,arr[i][0], arr[i][1], distSq));
        }

        for(int i = 0;i < k;i++){
            System.out.println("C"+pq.remove().idx);
        }
    }

    public static void connectNRopes(int ropes[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i < ropes.length;i++){
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size() > 1){
            int c1 = pq.remove();
            int c2 = pq.remove();
            cost += c1 + c2;
            pq.add(c1+c2);
        }
        System.out.println("minimum cost to connect n ropes is : "+cost);
    }

    static class ArmyRow implements Comparable<ArmyRow>{
        int soldiers,idx;
        public ArmyRow(int soldiers,int idx){
            this.idx = idx;
            this.soldiers = soldiers;
        }

        @Override
        public int compareTo(ArmyRow a){
            if(this.soldiers == a.soldiers){
                return this.idx - a.idx;
            }
            return this.soldiers - a.soldiers;
        }
    }

    public static void weakestSoldierRow(int arr[][]){
        PriorityQueue<ArmyRow> pq = new PriorityQueue<>();
        for(int i = 0;i < arr.length;i++){
            int count = 0;
            for(int j = 0;j < arr[0].length;j++){
                count += arr[i][j] == 1? 1:0;
            }
            pq.add(new ArmyRow(count, i));
        }

        while(!pq.isEmpty()){
            System.out.print("S"+pq.remove().idx+" ");
        }
        System.out.println();
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
        System.out.println("----------------------- Question 1 ---------------------------");
        int pts[][] = {{3,3},{5,-1,},{-2,4}};
        int k = 2;
        kNearestCars(pts,k);
        System.out.println("----------------------- Question 2 ---------------------------");
        int ropes[] = {4,3,2,6};
        connectNRopes(ropes);
        System.out.println("----------------------- Question 3 ---------------------------");
        int army [][] = {
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0},
        };
        weakestSoldierRow(army);
        System.out.println("----------------------- Question 4 ---------------------------");
        System.out.println("----------------------- Question 5 ---------------------------");
    }
}