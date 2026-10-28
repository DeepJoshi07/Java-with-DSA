import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graphs {
    static class Edge {
        int src;
        int dst;
        int wt;

        public Edge(int src, int dst, int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                q.add(i);
                bfsUtil(graph, visited, q);
            }
        }

    }

    private static void bfsUtil(ArrayList<Edge>[] graph, boolean visited[], Queue<Integer> q) {

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (Edge e : graph[curr]) {
                if (!visited[e.dst]) {
                    visited[e.dst] = true;
                    q.add(e.dst);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfsUtil(graph, i, visited);
            }
        }
    }

    private static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean visited[]) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visited[e.dst]) {
                dfsUtil(graph, e.dst, visited);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dst, boolean visited[]) {
        if (src == dst) {
            return true;
        }
        visited[src] = true;

        for (Edge e : graph[src]) {
            if (!visited[e.dst] && hasPath(graph, e.dst, dst, visited)) {
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, visited, i, -1)) {
                    return true;
                }
                ;
            }
        }
        return false;
    }

    private static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean visited[], int curr, int parent) {
        visited[curr] = true;
        for (Edge e : graph[curr]) {
            if (!visited[e.dst]) {
                if (detectCycleUtil(graph, visited, e.dst, curr)) {
                    return true;
                }
            } else if (visited[e.dst] && e.dst != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (Edge e : graph[curr]) {
                        if (color[e.dst] == -1) {
                            q.add(e.dst);
                            int nextColor = color[e.src] == 0 ? 1 : 0;
                            color[e.dst] = nextColor;
                        } else if (color[e.dst] == color[e.src]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCycleUtil(graph, visited, stack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean visited[], boolean stack[], int curr) {
        visited[curr] = true;
        stack[curr] = true;

        for (Edge e : graph[curr]) {
            System.out.println(curr + " -> " + e.dst);
            if (stack[e.dst]) {
                System.out.println("Cycle found at " + e.dst);
                return true;
            }
            if (!visited[e.dst] && isCycleUtil(graph, visited, stack, e.dst)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topologicalSortUtil(graph, visited, s, i);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }

    private static void topologicalSortUtil(ArrayList<Edge>[] graph, boolean visted[], Stack<Integer> s, int curr) {
        visted[curr] = true;
        for (Edge e : graph[curr]) {
            if (!visted[e.dst]) {
                topologicalSortUtil(graph, visted, s, e.dst);
            }
        }
        s.push(curr);
    }

    private static void calIndegree(ArrayList<Edge>[] graph, int indigree[]) {
        for (int i = 0; i < graph.length; i++) {
            for (Edge e : graph[i]) {
                indigree[e.dst]++;
            }
        }
    }

    public static void topologicalSort2(ArrayList<Edge>[] graph) {
        int indegree[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        calIndegree(graph, indegree);

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (Edge e : graph[curr]) {
                indegree[e.dst]--;
                if (indegree[e.dst] == 0) {
                    q.add(e.dst);
                }
            }
        }
        System.out.println();
    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dst, StringBuilder sb) {
        if (src == dst) {
            System.out.println(sb.toString() + dst);
            return;
        }

        for (Edge e : graph[src]) {
            printAllPaths(graph, e.dst, dst, sb.append(e.src));
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p1) {
            return this.path - p1.path;
        }
    }

    public static void dijkstras(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.n]) {
                visited[curr.n] = true;
                for (Edge e : graph[curr.n]) {
                    int u = e.src;
                    int v = e.dst;
                    int wt = e.wt;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void bellmenFordAlgorithm(ArrayList<Edge>[] graph, int src) {
        int V = graph.length;
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < V-1; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[j] == null)
                    continue;
                for (Edge e : graph[j]) {
                    int u = e.src;
                    int v = e.dst;
                    int wt = e.wt;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;

                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void bellmenFordAlgorithm2(ArrayList<Edge> edgeGraph, int src, int V) {
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < V-1 ; i++) {
            for (int j = 0;j < edgeGraph.size();j++) {
                Edge e = edgeGraph.get(j);
                int u = e.src;
                int v = e.dst;
                int wt = e.wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;

                }

            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    static class Pair2 implements Comparable<Pair2>{
        int v;
        int cost;

        public Pair2(int v,int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override 
        public int compareTo(Pair2 p1){
            return this.cost - p1.cost;
        }
    }

    public static void prims(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair2> pq = new PriorityQueue<>();
        pq.add(new Pair2(0, 0));
        int finalCost = 0;
        // ArrayList<Edge> al = new ArrayList<>();

        while(!pq.isEmpty()){
            Pair2 curr = pq.remove();
            if(!visited[curr.v]){
                visited[curr.v] = true;
                finalCost += curr.cost;
                
                for(Edge e:graph[curr.v]){
                    pq.add(new Pair2(e.dst,e.wt));
                }
            }
        }
        System.out.println("final cost is: "+finalCost);
        // for(Edge e : al){
        //     System.out.println(e.src+" to "+e.dst+" cost is "+e.wt );
        // }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] g = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            g[i] = new ArrayList<>();
        }

        g[0].add(new Edge(0, 1, 5));

        g[1].add(new Edge(1, 0, 5));
        g[1].add(new Edge(1, 2, 1));
        g[1].add(new Edge(1, 3, 3));

        g[2].add(new Edge(2, 1, 1));
        g[2].add(new Edge(2, 4, 2));
        g[2].add(new Edge(2, 3, 1));

        g[3].add(new Edge(3, 1, 3));
        g[3].add(new Edge(3, 2, 1));

        g[4].add(new Edge(4, 2, 2));

        for (int i = 0; i < g[2].size(); i++) {
            Edge e = g[2].get(i);
            System.out.println(e.dst);
        }
        System.out.println();

        System.out.println("---------------- Question 1 -----------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[7];

        for (int i = 0; i < 7; i++) {
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

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

        bfs(graph);
        System.out.println();
        System.out.println("---------------- Question 2 -----------------");
        dfs(graph);
        System.out.println();
        System.out.println("---------------- Question 3 -----------------");
        System.out.println(hasPath(graph, 0, 5, new boolean[graph.length]));
        System.out.println("---------------- Question 4 -----------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph2 = new ArrayList[5];

        for (int i = 0; i < graph2.length; i++) {
            graph2[i] = new ArrayList<>();
        }

        graph2[0].add(new Edge(0, 1, 1));
        graph2[0].add(new Edge(0, 2, 1));
        graph2[0].add(new Edge(0, 3, 1));

        graph2[1].add(new Edge(1, 0, 1));
        graph2[1].add(new Edge(1, 2, 1));

        graph2[2].add(new Edge(2, 1, 1));
        graph2[2].add(new Edge(2, 0, 1));

        graph2[3].add(new Edge(3, 0, 1));
        graph2[3].add(new Edge(3, 4, 1));

        graph2[4].add(new Edge(4, 3, 1));

        System.out.println(detectCycle(graph2));
        System.out.println("---------------- Question 5 -----------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph3 = new ArrayList[5];

        for (int i = 0; i < graph3.length; i++) {
            graph3[i] = new ArrayList<>();
        }

        graph3[0].add(new Edge(0, 1, 1));
        graph3[0].add(new Edge(0, 2, 1));

        graph3[1].add(new Edge(1, 0, 1));
        graph3[1].add(new Edge(1, 3, 1));

        graph3[2].add(new Edge(2, 0, 1));
        graph3[2].add(new Edge(2, 4, 1));

        graph3[3].add(new Edge(3, 1, 1));
        graph3[3].add(new Edge(3, 4, 1));

        graph3[4].add(new Edge(4, 3, 1));
        // graph3[4].add(new Edge(4, 2, 1));

        System.out.println(isBipartite(graph3));
        System.out.println("---------------- Question 6 -----------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph4 = new ArrayList[4];

        for (int i = 0; i < graph4.length; i++) {
            graph4[i] = new ArrayList<>();
        }

        graph4[0].add(new Edge(0, 2, 1));
        graph4[1].add(new Edge(1, 0, 1));
        graph4[2].add(new Edge(2, 3, 1));
        graph4[3].add(new Edge(3, 0, 1));
        System.out.println(isCycle(graph4));
        System.out.println("---------------- Question 7 -----------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph5 = new ArrayList[6];

        for (int i = 0; i < graph5.length; i++) {
            graph5[i] = new ArrayList<>();
        }

        graph5[2].add(new Edge(2, 3, 1));

        graph5[3].add(new Edge(3, 1, 1));

        graph5[4].add(new Edge(4, 0, 1));
        graph5[4].add(new Edge(4, 1, 1));

        graph5[5].add(new Edge(5, 0, 1));
        graph5[5].add(new Edge(5, 2, 1));

        topologicalSort(graph5);
        System.out.println("---------------- Question 8 -----------------");
        topologicalSort2(graph5);
        System.out.println("---------------- Question 9 -----------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph6 = new ArrayList[6];

        for (int i = 0; i < graph6.length; i++) {
            graph6[i] = new ArrayList<>();
        }
        graph6[0].add(new Edge(0, 3, 1));

        graph6[2].add(new Edge(2, 3, 1));

        graph6[3].add(new Edge(3, 1, 1));

        graph6[4].add(new Edge(4, 0, 1));
        graph6[4].add(new Edge(4, 1, 1));

        graph6[5].add(new Edge(5, 0, 1));
        graph6[5].add(new Edge(5, 2, 1));
        printAllPaths(graph6, 5, 1, new StringBuilder(""));
        System.out.println("---------------- Question 10 -----------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph7 = new ArrayList[6];

        for (int i = 0; i < graph7.length; i++) {
            graph7[i] = new ArrayList<>();
        }

        graph7[0].add(new Edge(0, 1, 2));
        graph7[0].add(new Edge(0, 2, 4));

        graph7[1].add(new Edge(1, 3, 7));
        graph7[1].add(new Edge(1, 2, 1));

        graph7[2].add(new Edge(2, 4, 3));

        graph7[3].add(new Edge(3, 5, 1));

        graph7[4].add(new Edge(4, 3, 2));
        graph7[4].add(new Edge(4, 5, 5));

        dijkstras(graph7, 0);
        System.out.println("---------------- Question 11 -----------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph8 = new ArrayList[5];

        for (int i = 0; i < graph8.length; i++) {
            graph8[i] = new ArrayList<>();
        }

        graph8[0].add(new Edge(0, 1, 2));
        graph8[0].add(new Edge(0, 2, 4));

        graph8[1].add(new Edge(1, 2, -4));

        graph8[2].add(new Edge(2, 3, 2));

        graph8[3].add(new Edge(3, 4, 4));

        graph8[4].add(new Edge(4, 1, -1));

        bellmenFordAlgorithm(graph8, 0);

        ArrayList<Edge> edgeGraph = new ArrayList<>();

        edgeGraph.add(new Edge(0, 1, 2));
        edgeGraph.add(new Edge(0, 2, 4));
        edgeGraph.add(new Edge(1, 2, -4));
        edgeGraph.add(new Edge(2, 3, 2));
        edgeGraph.add(new Edge(3, 4, 4));
        edgeGraph.add(new Edge(4, 1, -1));

        bellmenFordAlgorithm2(edgeGraph, 0, 5);

        System.out.println("---------------- Question 12 -----------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph9 = new ArrayList[5];

        for (int i = 0; i < graph9.length; i++) {
            graph9[i] = new ArrayList<>();
        }

        graph9[0].add(new Edge(0,1,10));
        graph9[0].add(new Edge(0,2,15));
        graph9[0].add(new Edge(0,3,30));

        graph9[1].add(new Edge(1,0,10));
        graph9[1].add(new Edge(1,3,40));

        graph9[2].add(new Edge(2,0,15));
        graph9[2].add(new Edge(2,3,50));

        graph9[3].add(new Edge(3,1,40));
        graph9[3].add(new Edge(3,2,50));
        prims(graph9);
        System.out.println("---------------- Question 12 -----------------");
        System.out.println("---------------- Question 12 -----------------");

    }
}