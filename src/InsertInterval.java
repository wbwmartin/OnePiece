import Utils.Interval;

import java.util.ArrayList;
import java.util.List;

//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//		You may assume that the intervals were initially sorted according to their start times.
//
//		Example 1:
//		Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
//		Example 2:
//		Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//
//		This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

public class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
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
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(6, 9));
        Interval interval = new Interval(2, 5);
        List<Interval> res = insert(list, interval);
        for (Interval i : res) {
            System.out.println(i.start + " " + i.end); // 1 5; 6 9
        }
    }
}
