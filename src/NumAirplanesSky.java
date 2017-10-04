import Utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Given an interval list which are flying and landing time of the flight.
// How many airplanes are on the sky at most?
//
//        Notice
//
//        If landing and flying happens at the same time, we consider landing should happen at first.
//
//        Have you met this question in a real interview? Yes
//        Example
//        For interval list
//
//        [
//        [1,10],
//        [2,3],
//        [5,8],
//        [4,7]
//        ]
//        Return 3

public class NumAirplanesSky {

    public static class Point {
        private int value;
        private int type;

        Point(int value, int type) {
            this.value = value;
            this.type = type;
        }

        public int getValue() {
            return this.value;
        }

        public int getType() {
            return this.type;
        }

    }

    public static int countOfAirplanes(List<Interval> airplanes) {
        int max = 0;
        int count = 0;
        int n = airplanes.size();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(airplanes.get(i).start, 1));
            points.add(new Point(airplanes.get(i).end, 0));
        }
        Collections.sort(points, Comparator.comparing(Point::getValue).thenComparing(Point::getType));
        for (int i = 0; i < 2 * n; i++) {
            if (points.get(i).getType() == 1) {
                max = Math.max(max, ++count);
            } else {
                count--;
            }
        }
        return max;
    }

    // unit test
    public static void main(String[] args) {
        List<Interval> a = new ArrayList<>();
        a.add(new Interval(1, 10));
        a.add(new Interval(2, 3));
        a.add(new Interval(5, 8));
        a.add(new Interval(3, 7));

        System.out.println(countOfAirplanes(a)); // 3
    }
}
