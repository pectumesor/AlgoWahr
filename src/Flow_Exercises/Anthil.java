package Flow_Exercises;

import HelperCode.Graph;

public class Anthil {


    public void computePaths(){

        int n = 4;
        int s = 1;
        int d = 4;

        Graph anthil = new Graph(n);

        //Add paths in the sun. Capacity is d to be able to flow one ant per shadow
        //path if needed
        anthil.addEdge(0,3,d); anthil.addEdge(3,0,d);

        //maxFlow = minCut of the Graph with only sunny edges
        int sunPaths = anthil.computeMaximumFlow(0,n-1);

        //Add the edges in the shadow
        anthil.addEdge(0,1,1); anthil.addEdge(1,0,1);
        anthil.addEdge(1,3,1); anthil.addEdge(3,1,1);
        anthil.addEdge(0,2,1); anthil.addEdge(2,0,1);
        anthil.addEdge(2,3,1); anthil.addEdge(3,2,1);

        //Total flow in the entire graph
        int totalPaths = anthil.computeMaximumFlow(0,n-1);

        //By dividing the capacity, we get the minimal amount of sunny edges we can remove
        //in order to disconnect the graph (min-Cut).
        int minimumSunDestroyed = sunPaths/d;

        //Minimum amount of shadow edge we have to remove to disconnect the graph.
        int minCutTotalGraph = totalPaths - sunPaths;

        System.out.println("Minimum Sunny edges: " + minimumSunDestroyed);
        System.out.println("Minimum Cut: " + minCutTotalGraph);
    }

    public static void main(String[] args) {
        Anthil anthil = new Anthil();
        anthil.computePaths();
    }

}
