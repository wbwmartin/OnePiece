
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
    	
    }
}
