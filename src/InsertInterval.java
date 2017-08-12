import java.util.ArrayList;
import java.util.List;


public class InsertInterval {

	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();
		for (Interval interval : intervals) {
			if (interval.start > newInterval.end) {
				res.add(newInterval);
				newInterval = interval;
			} else if (interval.end < newInterval.start) {
				res.add(interval);
			} else {
				newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
			}
		}
		res.add(newInterval);
        return res;
    }
	
    // unit test
    public static void main(String[] args) {
    	List<Interval> a = new ArrayList<Interval>();
    	a.add(new Interval(1, 3));
    	a.add(new Interval(6, 9));
    	Interval b = new Interval(2, 5);
    	List<Interval> res = insert(a, b);
    	for (Interval i: res) {
    		System.out.println(i.start + " " + i.end); // 1 5; 6 9
    	}
    }
}
