package General_Graph_Exercises;
import java.util.*;


    public class DinnerTable{
        ArrayList<ArrayList<Integer>> graph;
        Set<Integer> sideOfTable;
        int V;
        int E;
        int bestFriend;
        boolean[] visited;
        boolean[] color;
        boolean bipartit;


        public DinnerTable(int n, int m, int r){
            this.graph = new ArrayList<>();
            sideOfTable = new TreeSet<>();
            V = n;
            E = m;
            bestFriend = r;
            bipartit = true;
            visited  = new boolean[V];
            color = new boolean[V];
        }

        public void addNodes(){
            for (int i = 0; i<V;i++){
                graph.add(new ArrayList<>());
            }
        }

        public void addEdge(int a, int b){
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        public void DFS(int v){

            visited[v] = true;
            for (int i = 0; i<graph.get(v).size();i++){
                if (!visited[graph.get(v).get(i)]){
                    color[graph.get(v).get(i)] = !color[v];
                    DFS(graph.get(v).get(i));
                } else if (color[graph.get(v).get(i)] == color[v]){
                    bipartit = false;
                }
            }
        }
        public void setUp(){

            for (int i = 0; i<V;i++){
                if (!visited[i]){
                    DFS(i);
                }
            }
            for (int i = 0; i<V;i++){
                if (color[i] == color[bestFriend]){
                    sideOfTable.add(i);
                }
            }
        }

        public static void main(String[] args) {

            String res = "";
            int n = 4;
            int m = 4;
            int r = 1;

            DinnerTable graph = new DinnerTable(n, m, r);
            graph.addNodes();

            graph.addEdge(0, 1);
            graph.addEdge(1, 2);
            graph.addEdge(2, 3);
            graph.addEdge(3, 0);

            graph.setUp();

            for(Integer e : graph.sideOfTable){
                res += e + " ";
            }

            if(!graph.bipartit) res = "no";

            System.out.println(res);
        }

    }
