import java.util.*;

//There are a total of n courses you have to take, labeled from 0 to n - 1.
//
//        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//        Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//        There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
//        For example:
//
//        2, [[1,0]]
//        There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
//
//        4, [[1,0],[2,0],[3,1],[3,2]]
//        There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
//
//        Note:
//        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//        You may assume that there are no duplicate edges in the input prerequisites.
//        click to show more hints.
//
//        Hints:
//        This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
//        Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
//        Topological sort could also be done via BFS.

public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        boolean[][] map = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            map[prerequisites[i][1]][prerequisites[i][0]] = true;
        }
        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
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

    public static int[] findOrder2(int numCourses, int[][] prerequisites) {
        // Write your code here
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue queue = new LinkedList();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = (int) queue.poll();
            order[count] = course;
            count++;
            int n = edges[course].size();
            for (int i = n - 1; i >= 0; i--) {
                int pointer = (int) edges[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                }
            }
        }

        if (count == numCourses)
            return order;

        return new int[0];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] pre = {{1, 0}, {2, 1}, {3, 2}, {1, 3}};
        int[][] pre2 = {{1, 0}, {2, 1}, {3, 2}};
        int[] res = findOrder2(n, pre);
        int[] res2 = findOrder2(n, pre2);
        for (Integer i : res) {
            System.out.print(i + " "); // []
        }
        for (Integer i : res2) {
            System.out.print(i + " "); // [0 1 2 3]
        }
    }
}
