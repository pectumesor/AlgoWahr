package General_Graph_Exercises;
import HelperCode.Algorithms;

public class RandomTriangles {

    public static double median (int n, double p){
        return Algorithms.binom(n,3) * Math.pow(p,3);
    }

    public static double varianz (int n, double p, double median){

        Algorithms alg = new Algorithms();

        double medianOfSrq = median + (alg.binom(n,2) * (n-2) * (n-3) * Math.pow(p,5)) +
                ( n * alg.binom(n-1,2) * alg.binom(n-3,2) * Math.pow(p,6)) +
                (alg.binom(n,3)*alg.binom(n-3,3)*Math.pow(p,6));


        return medianOfSrq - Math.pow(median,2);
    }
}
