package leetcode.medium;

public class _134GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gasSum = 0;
        int costSum = 0;
        int pathSum = 0;
        int costsSum = 0;
        int res = 0;


        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (costSum > gasSum){
            return -1;
        }

        for (int i = 0; i < gas.length; i++) {
            costsSum += cost[i];
            pathSum += gas[i];

            if (costsSum > pathSum){
                res = i + 1;
            }
        }

        return res;
    }
}
