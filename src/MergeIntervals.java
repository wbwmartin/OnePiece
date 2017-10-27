import Utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, Comparator.comparing((Interval interval) -> interval.start));
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= pre.end) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                res.add(pre);
                pre = cur;
            }
        }
        res.add(pre);
        return res;
    }

    public static void main(String[] args) {
        List<Interval> a = new ArrayList<>();
        a.add(new Interval(1, 3));
        a.add(new Interval(2, 6));
        a.add(new Interval(8, 10));
        a = merge(a);
        for (Interval i : a) {
            System.out.println(i.start + " " + i.end); // 1 6 | 8 10
        }
    }
}
