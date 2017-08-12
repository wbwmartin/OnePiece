
public class CourseSchedule {

	// resursion, dfs
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 1) {
            return false;
        }
        boolean[][] map = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            map[prerequisites[i][1]][prerequisites[i][0]] = true;
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!helper(map, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean helper(boolean[][] map, int[] visited, int index) {
        visited[index] = 1;
        for (int i = 0; i < visited.length; i++) {
            if (map[index][i]){
                if (visited[i] == 1) {
                    return false;
                }
                if (visited[i] == 0 && !helper(map, visited, i)) {
                    return false;
                }
            }
        }
        visited[index] = 2;
        return true;
    }
    
    // unit test
    public static void main(String[] args) {
    	int n = 4;
    	int[][] pre = {{1, 0}, {2, 1}, {3, 2}, {1, 3}};
    	System.out.println(canFinish(n, pre)); // false
    }
}
