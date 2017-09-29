import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {
	
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, Comparator.comparing((Interval interval) -> interval.start));
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (res.isEmpty()) {
                res.add(cur);
            } else {
                Interval prev = res.get(res.size() - 1);
                if (prev.end >= cur.start) {
                    prev.end = Math.max(prev.end, cur.end);
                } else {
                    res.add(cur);
                }
            }
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	List<Interval> a = new ArrayList<>();
    	a.add(new Interval(1, 3));
    	a.add(new Interval(2, 6));
    	a.add(new Interval(8, 10));
    	a = merge(a);
    	for (Interval i: a) {
    		System.out.println(i.start + " " + i.end); // 1 6 | 8 10
    	}
    }
}