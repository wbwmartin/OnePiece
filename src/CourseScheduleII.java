import java.util.Stack;


public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        boolean[][] map = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            map[prerequisites[i][1]][prerequisites[i][0]] = true;
        }
        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<Integer>();
        boolean circle = false;
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!helper(map, visited, stack, i)) {
                    circle = true;
                    break;
                }
            }
        }
        if (!circle) {
            int i = 0;
            while (!stack.empty()) {
                res[i++] = stack.pop();
            }
            return res;
        } else {
        	return new int[0];
        }
    }
    
    private static boolean helper(boolean[][] map, int[] visited, Stack<Integer> stack, int index) {
        visited[index] = 1;
        for (int i = 0; i < visited.length; i++) {
            if (map[index][i]) {
                if (visited[i] == 1) {
                    return false;
                }
                if (visited[i] == 0 && !helper(map, visited, stack, i)) {
                    return false;
                }
            }
        }
        stack.push(index);
        visited[index] = 2;
        return true;
    }
    
    // unit test
    public static void main(String[] args) {
    	int n = 4;
    	int[][] pre = {{1, 0}, {2, 1}, {3, 2}, {1, 3}};
    	int[] res = findOrder(n, pre);
    	for (Integer i : res) {
    		System.out.print(i + " ");
    	}
    }
}
