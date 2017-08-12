import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NumberIslandsII {
	
	static class Point {
		 int x;
		 int y;
		 Point() { x = 0; y = 0; }
		 Point(int a, int b) { x = a; y = b; }
	}
	
	private static class UnionFind {
		
        private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        public UnionFind(int m, int n) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int id = convertToId(i, j, n);
                    map.put(id, id);
                }
            }
        }
        
        public int find(int x) {
			while (x != map.get(x)) {
				x = map.get(x);
			}
			return x;
		}
        
        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                map.put(fx, fy);
            }
        }
    }
    
    private static int convertToId(int x, int y, int n) {
        return x * n + y;
    }
    
    public static List<Integer> numIslands2(int m, int n, Point[] operators) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        if (operators == null || operators.length == 0) {
            return res;
        }
        UnionFind uf = new UnionFind(m, n);
        boolean[][] island = new boolean[m][n];
        int count = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (Point p : operators) {
            int x = p.x;
            int y = p.y;
            if (island[x][y]) {
                continue;
            }
            count++;
            island[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int id = convertToId(x, y, n);
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || !island[nx][ny]) {
                    continue;
                }
                int nid = convertToId(nx, ny, n);
                int fa = uf.find(id);
                int fn = uf.find(nid);
                if (fa != fn) {
                    count--;
                    uf.union(id, nid);
                }
            }
            res.add(count);
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	Point[] points = new Point[4];
    	points[0] = new Point(0, 0);
    	points[1] = new Point(0, 1);
    	points[2] = new Point(2, 2);
    	points[3] = new Point(2, 1);
    	List<Integer> res = numIslands2(3, 3, points);
    	System.out.println(res); // 1 1 2 2
    }
}
