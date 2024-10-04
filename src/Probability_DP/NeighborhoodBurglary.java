package Probability_DP;

public class NeighborhoodBurglary {

    public static double answerOne(int[] valuables, double[] probE, double[] probO, int n){

        double res = 0.0;

        for (int i = 0; i<n;i++){
            res += probE[i] * valuables[i];
        }
        return res;
    }

    public static double answerTwo(int[] valuables, double[] probE, double[] probO, int n){

        // A = "Second House success", B = "Third House success"

        if (valuables[2] < valuables[1] ){
            return 0.0;
        }

        if (valuables[1] < valuables[0]){
            return 0.0;
        }

        // calc Pr[A]
        double prA = 0.0;

        if ((valuables[1] - valuables[0]) % 2 == 0){
            prA = probE[1];
        } else {
            prA = probO[1];
        }

        //calc Pr[B]

        double prBandA = 0.0;
        double prBnotA = 0.0;
        double prB = 0.0;

        if ((valuables[2]-valuables[1]) % 2 == 0){
            prBandA = probE[2];
        } else {
            prBandA = probO[2];
        }

        if ((valuables[2]-valuables[0])% 2 == 0){
            prBnotA = probE[2];
        } else {
            prBnotA = probO[2];
        }

        prB = prA * prBandA + (1-prA)*prBnotA;

        return (prA * prBandA) / prB;

    }

    public static double answerThree(int houseIndex, int lastHouseValuables,int[] valuables, double[]probE, double[] probO, double[][] memo){

        //avoud out of bounds
        if (houseIndex >= valuables.length){
            return 0;
        }

        //Re-use already computed values

        if (memo[houseIndex][lastHouseValuables] != -1){
            return memo[houseIndex][lastHouseValuables];
        }

        int currentValuables = valuables[houseIndex];

        // vi < vj, skip House

        if (currentValuables < lastHouseValuables){
            double result = answerThree(houseIndex + 1, lastHouseValuables, valuables,probE,probO,memo);
            memo[houseIndex][lastHouseValuables] = result;
            return result;
        }

        //Decide even or odd probability

        double successProb = (currentValuables - lastHouseValuables) % 2 == 0 ? probE[houseIndex] : probO[houseIndex];

        // I robb House i, so i have prob * (valuables[i] + expectedValue of starting at house i+1, with vj = valuables[i])
        double expectedBreakIn = successProb * (currentValuables + answerThree(houseIndex + 1, currentValuables, valuables,probE,probO,memo));

        // i fail to rob House i, so i have 1-prob * expectedValue of starting at house i+1 with vj not changed

        double expectedSkip = (1 - successProb) * answerThree(houseIndex + 1, lastHouseValuables,valuables,probE,probO,memo);

        //expected Value starting at house i
        double result = expectedBreakIn + expectedSkip;

        //save result in memo table
        memo[houseIndex][lastHouseValuables] = result;
        return result;
    }
}
