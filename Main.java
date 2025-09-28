package DAA;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        int[] a = new Random().ints(n, 0, 100).toArray();

        System.out.println("Original array:");
        System.out.println(Arrays.toString(a));

        int[] b1 = Arrays.copyOf(a, a.length);
        int[] b2 = Arrays.copyOf(a, a.length);
        int[] b3 = Arrays.copyOf(a, a.length);

        Metrics m1 = new Metrics();
        MergeSort.sort(b1, m1);
        System.out.println("\nMergeSort:");
        System.out.println(Arrays.toString(b1));

        Metrics m2 = new Metrics();
        QuickSort.sort(b2, m2);
        System.out.println("\nQuickSort:");
        System.out.println(Arrays.toString(b2));

        Metrics m3 = new Metrics();
        int median = DeterministicSelect.select(b3, b3.length / 2, m3);
        System.out.println("\nDeterministic Select median:");
        System.out.println(median);

        ClosestPair.Point[] pts = new ClosestPair.Point[]{
            new ClosestPair.Point(1, 2),
            new ClosestPair.Point(3, 4),
            new ClosestPair.Point(1.5, 2.2),
            new ClosestPair.Point(7, 8)
        };
        double d = ClosestPair.closest(pts, new Metrics());
        System.out.println("\nClosest pair distance: " + d);
    }
}
