import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs{
    static class Edge{
        int src;
        int dst;
        int wt;

        public Edge(int src,int dst, int wt){
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }

      public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] g = new ArrayList[V];

        for(int i = 0;i < V;i++){
            g[i] = new ArrayList<>();
        }

        g[0].add(new Edge(0,1,5));

        g[1].add(new Edge(1,0,5));
        g[1].add(new Edge(1,2,1));
        g[1].add(new Edge(1,3,3));

        g[2].add(new Edge(2,1,1));
        g[2].add(new Edge(2,4,2));
        g[2].add(new Edge(2,3,1));

        g[3].add(new Edge(3,1,3));
        g[3].add(new Edge(3,2,1));

        g[4].add(new Edge(4,2,2));

        for(int i = 0;i < g[2].size();i++){
            Edge e = g[2].get(i);
            System.out.println(e.dst);
        }
        System.out.println();

        System.out.println("---------------- Question 1 -----------------");
         @SuppressWarnings("unchecked")
        ArrayList<Edge> [] graph = new ArrayList[7];

        for(int i = 0;i < 7;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 0, 1));
        
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        
        graph[3].add(new Edge(3, 5, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));
        
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        
        graph[6].add(new Edge(6, 5, 1));

        bfs(graph);
        System.out.println();
        System.out.println("---------------- Question 2 -----------------");
        dfs(graph,graph[0].get(0).src,new boolean[graph.length]);
        System.out.println();
        System.out.println("---------------- Question 3 -----------------");
        System.out.println("---------------- Question 4 -----------------");
        System.out.println("---------------- Question 5 -----------------");
        System.out.println("---------------- Question 6 -----------------");
        System.out.println("---------------- Question 7 -----------------");
    }
}