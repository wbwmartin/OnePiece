import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class NumOverlapIntervals {

	private static class Interval {
		int start;
		int end;
		private Interval(int s, int e) { start = s; end = e; }
	}
	
	private static class Point implements Comparable<Point>{
		int val;
		boolean isStart;
		private Point(int val, boolean isStart) {
			this.val = val;
			this.isStart = isStart;
		}
		public int compareTo(Point p) {
			if (this.val < p.val) {
				return -1;
			} else if (this.val > p.val) {
				return 1;
			} else if (this.isStart && !p.isStart) {
				return -1;
			} else if (!this.isStart && p.isStart) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	public static int getOverlappingCount(Interval[] A) {
		int max = 0;
		int count = 1;
		if (A == null || A.length == 0) {
			return max;
		}
		List<Point> points = new ArrayList<Point>();
		for (int i = 0; i < A.length; i++) {
			points.add(new Point(A[i].start, true));
			points.add(new Point(A[i].end, false));
		}
		Collections.sort(points);
		for (int i = 0; i < points.size(); i++) {
			if (points.get(i).isStart) {
				count++;
				max = Math.max(max, count);
			} else {
				count--;
			}
		}
		return max;
	}
	
	// unit test
    public static void main(String[] args) {
    	Interval[] A = new Interval[4];
    	A[0] = new Interval(1, 5);
    	A[1] = new Interval(10, 15);
    	A[2] = new Interval(5, 10);
    	A[3] = new Interval(20, 30);
    	System.out.println(getOverlappingCount(A)); // 3
    }
}
