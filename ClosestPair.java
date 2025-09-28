package DAA;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {
    public static double closest(Point[] pts, Metrics m) {
        Point[] byX = pts.clone();
        Arrays.sort(byX, Comparator.comparingDouble(p -> p.x));
        Point[] buf = new Point[pts.length];
        return rec(byX, buf, 0, pts.length, m);
    }

    private static double rec(Point[] a, Point[] buf, int l, int r, Metrics m) {
        int n = r - l;
        if (n <= 3) {
            double best = Double.POSITIVE_INFINITY;
            for (int i = l; i < r; i++)
                for (int j = i + 1; j < r; j++)
                    best = Math.min(best, dist(a[i], a[j]));
            return best;
        }
        int mid = (l + r) >>> 1;
        double xm = a[mid].x;
        double dl = rec(a, buf, l, mid, m);
        double dr = rec(a, buf, mid, r, m);
        double d = Math.min(dl, dr);

        Arrays.sort(a, l, r, Comparator.comparingDouble(p -> p.y));
        int mpos = 0;
        for (int i = l; i < r; i++) {
            if (Math.abs(a[i].x - xm) < d) buf[mpos++] = a[i];
        }
        for (int i = 0; i < mpos; i++) {
            for (int j = i + 1; j < mpos && (buf[j].y - buf[i].y) < d; j++) {
                d = Math.min(d, dist(buf[i], buf[j]));
                if (m != null) m.comparisons++;
            }
        }
        return d;
    }

    private static double dist(Point a, Point b) {
        double dx = a.x - b.x, dy = a.y - b.y;
        return Math.hypot(dx, dy);
    }

    public static class Point {
        public final double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
