package heaps;

import java.util.*;

public class NearestCar {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int index;

        public Point(int index, int x, int y, int distSq) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.distSq = distSq;
        }

        @Override
        public int compareTo(Point other) {
            return this.distSq - other.distSq;
        }
    }

    public static void main(String[] args) {
        int[][] points = {{3,3}, {5,-1}, {-2,4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int distSq = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            Point point = new Point(i, points[i][0], points[i][1], distSq);
            pq.add(point);
        }

        // Nearest k cars:
        for (int i = 0; i < k; i++) {
            System.out.println("C"+pq.remove().index);
        }
    }
}
