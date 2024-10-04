package Flow_Exercises;

import HelperCode.Graph;

public class GrandTheftAlligator {
    public static void main(String[] args) {

        int n = 6;
        int m = 4;
        int r = 2;

        Graph grandTheft = new Graph(n+3);

        int algoVille = 0;
        int zoo = 3;
        int headquarters = 5;
        int zooIn = n+1;
        int zooOut = n+2;

        int maxK = 0;

        int[] u = {0,0,1,2,3,3};
        int[] v = {1,2,3,3,4,5};
        int[] k = {4,7,3,7};

        for(int i = 0; i <m ; i++){
            maxK += k[i];

            if (u[i] == zoo){
                grandTheft.addEdge(zooOut,v[i],k[i]);
            } else if (v[i] == zoo){
                grandTheft.addEdge(u[i],zooIn,k[i]);
            } else {
                grandTheft.addEdge(u[i],v[i],k[i]);
            }
        }

        for (int i = m; i < u.length; i++){
            if (u[i] == zoo){
                grandTheft.addEdge(zooOut,v[i],maxK);
            } else if (v[i] == zoo){
                grandTheft.addEdge(u[i],zooIn,maxK);
            } else {
                grandTheft.addEdge(u[i],v[i],maxK);
            }
        }


        int zooCap = grandTheft.computeMaximumFlow(0,zooIn);
        grandTheft.addEdge(zooIn,zooOut,zooCap);

        int res = grandTheft.computeMaximumFlow(zooIn,headquarters);

        if(res >= maxK){
            System.out.println("RICH");
        } else {
            System.out.println(res);
        }


    }
}
