import java.util.ArrayList;
import java.util.Collections;

public class DisjoinSet {
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;

        public Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override 
        public int compareTo(Edge e){
            return this.wt - e.wt;
        }
    }

    static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i = 0;i < n;i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if(x == par[x]){
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a,int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] > rank[parB]){
            par[parB] = parA;
        }else{
            par[parA] = parB;
        }
    }

    public static void kruskalsMST(ArrayList<Edge> edges,int V){
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;

        for(int i = 0;count < V-1;i++){
            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);

            if(parA != parB){
                union(e.src,e.dest);
                mstCost += e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }
    public static void main(String[] args) {
        init();
        // System.out.println(find(3));
        // union(1, 3);
        // System.out.println(find(3));
        // union(2, 4);
        // union(3, 6);
        // union(1, 4);
        // System.out.println(find(3));
        // System.out.println(find(4));
        // union(1, 5);
        int V = 4;
        ArrayList<Edge> al = new ArrayList<>();
        createGraph(al);
        kruskalsMST(al, V);
    }
}
