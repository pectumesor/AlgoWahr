package Probability_DP;

public class GameOfSkill {

    public static double firstQuestion (double[] prob){

        double friend = (double)1/6;
        return friend * (prob[2] + prob[4] + prob[6]);
    }

    public static double secondQuestion(double[] prob){


        double prX7 = (prob[1]*prob[6])*2 + (prob[2]*prob[5])*2 + (prob[3]*prob[4])*2;

        double pr3And7 = prob[3] * prob[4];

        return pr3And7/prX7;

    }

    public static double thirdQuestion(double[]prob, int n, double[] memo, int j){

        if (j >= n){
            return 0.0;
        }

        if (memo[j] != -1){
            return memo[j];
        }

        double expecValue = 0.0;
        for (int i = 1; i<=6;i++){

            expecValue += prob[i]*(thirdQuestion(prob,n,memo,j+i) + 1);
        }
        memo[j] = expecValue;
        return memo[j];
    }

    public static void main(String[] args) {

    }
}
