package General_Graph_Exercises;
import java.util.*;
import java.util.Set;

class Node{
    String name;
    int index;
    ArrayList<Node> outgoing;
    ArrayList<Node> incoming;


    Node(String name, int index){
        this.name = name;
        this.index = index;
        this.outgoing = new ArrayList<Node>();
        this.incoming = new ArrayList<Node>();
    }
}
public class PasswordGraph {

        int V;
        int E;
        boolean[] visited;
        boolean connected;
        int componnent;
        ArrayList<Node> nodes;

        PasswordGraph (int V){
            this.V = V;
            this.E = 0;
            this.componnent = 0;
            this.connected = true;
            visited = new boolean[V];
            nodes = new ArrayList<Node>();
        }

        void addNodes (Set<String> vertices){
            int count = 0;
            for(String e : vertices){
                Node curr = new Node(e,count);
                nodes.add(curr);
                count++;
            }
        }

        void addEdges(String[] edges){

            for(int i = 0; i<edges.length;i++){

                String suf = edges[i].substring(1);
                String pre = edges[i].substring(0,2);
                Node from = new Node ("",0);
                Node to = new Node ("",0);

                for (int j = 0; j<nodes.size();j++){
                    if (nodes.get(j).name.equals(suf)){
                        to = nodes.get(j);
                    }
                    if (nodes.get(j).name.equals(pre)){
                        from = nodes.get(j);
                    }
                }
                from.outgoing.add(to);
                to.incoming.add(from);
                E++;
            }
        }

        boolean checkEulerian(){
            if (E == 0) return false;
            int start = 0; int end = 0;
            for (int i = 0; i<V;i++){
                int out = nodes.get(i).outgoing.size();
                int in  = nodes.get(i).incoming.size();
                if (out - in > 1 || in - out > 1) return false;
                else if (out - in == 1) start++;
                else if (in - out == 1) end++;
            }
            return (end == 0 && start == 0) || (end == 1 && start == 1);
        }

        public Node startNode (){

            Node src = new Node("",0);
            for (int i = 0; i<V;i++){
                if (nodes.get(i).outgoing.size()-nodes.get(i).incoming.size() == 1){
                    src = nodes.get(i);
                    return src;
                }

                if (nodes.get(i).outgoing.size() > 0){
                    src = nodes.get(i);
                }
            }
            return src;
        }

        void DFS(Node source){

            Stack<Node> S = new Stack<>();
            S.push(source);
            visited[source.index] = true;

            while(!S.isEmpty()){
                Node u = S.pop();
                componnent++;
                for (int i = 0; i<u.outgoing.size();i++){
                    Node v = u.outgoing.get(i);
                    if (!visited[v.index]){
                        visited[v.index] = true;
                        S.push(v);
                    }
                }
            }
        }

        boolean setUp(){
            DFS(startNode());
            if (!checkEulerian()) return false;

            if (componnent == V) return true;
            return false;
        }

    public static void main(String[] args) {

            int n = 3;
            String[] words = {"abc","cde","bcd"};
            Set<String> vertices = new HashSet<>();
            for(int i = 0; i<n;i++){
                vertices.add(words[i].substring(1));
                vertices.add(words[i].substring(0,2));
            }

            PasswordGraph G = new PasswordGraph(vertices.size());
            G.addNodes(vertices);
            G.addEdges(words);

            String res = "no";
            if(G.setUp()) res = "yes";
            System.out.println(res);
    }
}
