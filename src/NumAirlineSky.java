import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class NumAirlineSky {
	
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static class Point implements Comparable<Point> {
        int value;
        int type;
        Point(int value, int type) {
            this.value = value;
            this.type = type;
        }
        
        @Override
        public int compareTo(Point p) {
            if (this.value == p.value) {
                return this.type - p.type;
            } else {
                return this.value - p.value;
            }
        }

    }
    
	public static int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        int max = 0;
        int count = 0;
        int n = airplanes.size();
        List<Point> points = new ArrayList<Point>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(airplanes.get(i).start, 1));
            points.add(new Point(airplanes.get(i).end, 0));
        }
        Collections.sort(points);
        for (int i = 0; i < 2 * n; i++) {
            if (points.get(i).type == 1) {
                max = Math.max(max, ++count);
            } else {
                count--;
            }
        }
        return max;
    }
    
    // unit test
    public static void main(String[] args) {
    	List<Interval> a = new ArrayList<Interval>();
    	a.add(new Interval(1, 10));
    	a.add(new Interval(2, 3));
    	a.add(new Interval(5, 8));
    	a.add(new Interval(3, 7));

    	System.out.println(countOfAirplanes(a)); // 3
    }
}
