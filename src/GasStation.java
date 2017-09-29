//There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
//
//        You have a car with an unlimited gas tank and it costs cost[i] of gas to travel
//          from station i to its next station (i+1).
//        You begin the journey with an empty tank at one of the gas stations.
//
//        Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
//
//        Note:
//        The solution is guaranteed to be unique.

public class GasStation {

    // iterative
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        int index = 0;
        int local = 0;
        int global = 0;
        for (int i = 0; i < cost.length; i++) {
            local += gas[i] - cost[i];
            global += gas[i] - cost[i];
            if (local < 0) {
                index = i + 1;
                local = 0;
            }
        }
        if (global < 0) {
            return -1;
        }
        return index;
    }

    // unit test
    public static void main(String[] args) {
        int[] gas = {1, 1, 3, 1};
        int[] cost = {2, 2, 1, 1};
        System.out.println(canCompleteCircuit(gas, cost)); // 2
    }
}
