import java.util.*;

//Given N buildings in a x-axis，each building is a rectangle and can be represented by a triple (start, end, height)，where start is the start position on x-axis, end is the end position on x-axis and height is the height of the building. Buildings may overlap if you see them from far away，find the outline of them。
//
//        An outline can be represented by a triple, (start, end, height), where start is the start position on x-axis of the outline, end is the end position on x-axis and height is the height of the outline.
//
//        Building Outline
//
//        Notice
//
//        Please merge the adjacent outlines if they have the same height and make sure different outlines cant overlap on x-axis.
//
//
//        Example
//        Given 3 buildings：
//
//        [
//        [1, 3, 3],
//        [2, 4, 4],
//        [5, 6, 1]
//        ]
//        The outlines are：
//
//        [
//        [1, 2, 3],
//        [2, 4, 4],
//        [5, 6, 1]
//        ]

public class BuildingOutlines {
    public static List<List<Integer>> buildingOutline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        Point[] points = new Point[buildings.length * 2];
        Map<Point, Point> map = new HashMap<>();
        for (int i = 0; i < buildings.length; i++) {
            Point start = new Point(buildings[i][0], 1, buildings[i][2]);
            Point end = new Point(buildings[i][1], 0, buildings[i][2]);
            points[2 * i] = start;
            points[2 * i + 1] = end;
            map.put(end, start);
        }
        Arrays.sort(points, Comparator.comparing(Point::getPos)
                .thenComparing((Point p1, Point p2) -> (p2.type - p1.type))
                .thenComparing((Point p1, Point p2) -> {
                    if (p1.type == 1) {
                        return p2.val - p1.val;
                    } else {
                        return p1.val - p2.val;
                    }
                }));
        Queue<Point> pq = new PriorityQueue<>(1, Comparator.comparing(Point::getVal).reversed()
                .thenComparing(Point::getPos));
        for (int i = 0; i < points.length; i++) {
            if (pq.isEmpty()) {
                pq.offer(points[i]);
                continue;
            }
            Point next = points[i];
            Point pre = pq.peek();
            if (next.type == 1) {
                pq.offer(next);
                Point cur = pq.peek();
                if (cur != pre && cur.pos != pre.pos) {
                    output(res, pre.pos, next.pos, pre.val);
                }
            } else {
                pq.remove(map.get(next));
                if (pq.isEmpty()) {
                    output(res, pre.pos, next.pos, pre.val);
                    continue;
                }
                Point cur = pq.peek();
                if (cur != pre) {
                    if (cur.val == pre.val) {
                        cur.pos = pre.pos;
                    } else {
                        output(res, pre.pos, next.pos, pre.val);
                        cur.pos = next.pos;
                    }
                }
            }
        }
        return res;
    }

    private static void output(List<List<Integer>> res, int start, int end, int height) {
        List<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        list.add(height);
        res.add(list);
    }

    private static class Point {
        int pos, type, val;

        Point(int pos, int type, int val) {
            this.pos = pos;
            this.type = type;
            this.val = val;
        }

        public int getPos() {
            return pos;
        }

        public int getType() {
            return type;
        }

        public int getVal() {
            return val;
        }
    }

    public static void main(String[] args) {
        int[][] buildings = {{1, 3, 3}, {2, 4, 4}, {5, 6, 1}};
        List<List<Integer>> res = buildingOutline(buildings);
        System.out.println(res);
    }
}

