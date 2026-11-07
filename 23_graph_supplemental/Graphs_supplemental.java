import java.util.ArrayList;
import java.util.Stack;

public class Graphs_supplemental {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, Stack<Integer> s, boolean visited[]) {
        visited[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visited[e.dest]) {
                topSort(graph, e.dest, s, visited);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visited[]) {
        visited[curr] = true;
        System.out.print(curr + " ");
        for (Edge e : graph[curr]) {
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    public static void kosarajus(ArrayList<Edge>[] graph) {
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topSort(graph, i, s, visited);
            }
        }
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] transpose = new ArrayList[graph.length];
        for (int i = 0; i < transpose.length; i++) {
            transpose[i] = new ArrayList<>();
        }

        for (int i = 0; i < transpose.length; i++) {
            for (Edge e : graph[i]) {
                transpose[e.dest].add(new Edge(e.dest, e.src, e.wt));
            }
        }

        visited = new boolean[transpose.length];

        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!visited[curr]) {
                System.out.println("--SCC--");
                dfs(transpose, curr, visited);
                System.out.println();
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        int dt[] = new int[graph.length];
        int low[] = new int[graph.length];
        int time[] = new int[1];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfsTarjan(graph, i, -1, visited, dt, low, time);
            }
        }
    }

    public static void dfsTarjan(ArrayList<Edge>[] graph, int curr, int parent, boolean visited[], int dt[], int low[],
            int time[]) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time[0];

        for (Edge e : graph[curr]) {
            int neighbor = e.dest;
            if (neighbor == parent) {
                continue;
            } else if (!visited[neighbor]) {
                dfsTarjan(graph, neighbor, curr, visited, dt, low, time);
                low[curr] = Math.min(low[curr], low[neighbor]);
                if (dt[curr] < low[neighbor]) {
                    System.out.println("Bridge : " + curr + " ----> " + neighbor);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[neighbor]);
            }
        }
    }

    public static void dfsAP(ArrayList<Edge>[] graph,int curr,int parent,int dt[],int low[],boolean visited[],int time[],boolean isAp[]){
        visited[curr] = true;
        dt[curr] = low[curr] = ++time[0];
        int children = 0;
        for(Edge e : graph[curr]){
            int neighbor = e.dest;
            if(neighbor == parent){
                continue;
            }else if(visited[neighbor]){
                low[curr] = Math.min(low[curr],dt[neighbor]);
            }else{
                dfsAP(graph, e.dest, curr, dt, low, visited, time,isAp);
                low[curr] = Math.min(low[curr],low[neighbor]);
                if(parent != -1 && dt[curr] <= low[neighbor]){
                    isAp[curr] = true;
                }
                children++;
            }
        }
        if(parent == -1 && children > 1){
            isAp[curr] = true;
        }
    }

    public static void articulationPoint(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        int dt[] = new int[graph.length];
        int low[] = new int[graph.length];
        int time[] = new int[1];
        boolean isAp[] = new boolean[graph.length];

        for(int i = 0;i < graph.length;i++){
            if(!visited[i]){
                dfsAP(graph, i, -1, dt, low, visited, time,isAp);
            }
        }

        for(int i = 0;i < isAp.length;i++){
            if(isAp[i]){
                System.out.println("articulation point => "+i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("----------------- Question 1 ---------------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));

        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 4, 1));
        kosarajus(graph);
        System.out.println("----------------- Question 2 ---------------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph1 = new ArrayList[6];
        for (int i = 0; i < graph1.length; i++) {
            graph1[i] = new ArrayList<>();
        }
        graph1[0].add(new Edge(0, 1, 1));
        graph1[0].add(new Edge(0, 2, 1));
        graph1[0].add(new Edge(0, 3, 1));

        graph1[1].add(new Edge(1, 0, 1));
        graph1[1].add(new Edge(1, 2, 0));

        graph1[2].add(new Edge(2, 0, 1));
        graph1[2].add(new Edge(2, 1, 1));

        graph1[3].add(new Edge(3, 0, 1));
        graph1[3].add(new Edge(3, 4, 0));
        graph1[3].add(new Edge(3, 5, 1));

        graph1[4].add(new Edge(4, 3, 1));
        graph1[4].add(new Edge(4, 5, 1));

        graph1[5].add(new Edge(5, 3, 1));
        graph1[5].add(new Edge(5, 4, 1));

        tarjanBridge(graph1);
        System.out.println("--------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph2 = new ArrayList[6];
        for (int i = 0; i < graph2.length; i++) {
            graph2[i] = new ArrayList<>();
        }
        graph2[0].add(new Edge(0, 1, 1));
        graph2[0].add(new Edge(0, 2, 1));
        graph2[0].add(new Edge(0, 3, 1));

        graph2[1].add(new Edge(1, 0, 1));
        graph2[1].add(new Edge(1, 2, 0));

        graph2[2].add(new Edge(2, 0, 1));
        graph2[2].add(new Edge(2, 1, 1));

        graph2[3].add(new Edge(3, 0, 1));
        graph2[3].add(new Edge(3, 4, 0));

        graph2[4].add(new Edge(4, 3, 1));

        tarjanBridge(graph2);
        System.out.println("----------------- Question 3 ---------------------");
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph3 = new ArrayList[5];
        for (int i = 0; i < graph3.length; i++) {
            graph3[i] = new ArrayList<>();
        }
        graph3[0].add(new Edge(0,1,1));
        graph3[0].add(new Edge(0,2,1));
        graph3[0].add(new Edge(0,3,1));

        graph3[1].add(new Edge(1,0,1));
        graph3[1].add(new Edge(1,2,1));

        graph3[2].add(new Edge(2,0,1));
        graph3[2].add(new Edge(2,1,1));

        graph3[3].add(new Edge(3,0,1));
        graph3[3].add(new Edge(3,4,1));

        graph3[4].add(new Edge(4,3,1));
        articulationPoint(graph3);
    }
}