package DAA;

import java.util.Random;

public class QuickSort {
    private static final Random R = new Random(1);

    public static void sort(int[] a, Metrics m) {
        shuffle(a);
        sort(a, 0, a.length, m);
    }

    private static void shuffle(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int j = R.nextInt(i + 1);
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    private static void sort(int[] a, int l, int r, Metrics m) {
        while (r - l > 1) {
            int p = partition(a, l, r, m);
            if (p - l < r - (p + 1)) {
                sort(a, l, p, m);
                l = p + 1;
            } else {
                sort(a, p + 1, r, m);
                r = p;
            }
            if (m != null) m.recursionDepth++;
        }
    }

    private static int partition(int[] a, int l, int r, Metrics m) {
        int pivot = a[l + R.nextInt(r - l)];
        int i = l, j = r - 1;
        while (i <= j) {
            while (i <= j && a[i] < pivot) {
                i++;
                if (m != null) m.comparisons++;
            }
            while (i <= j && a[j] > pivot) {
                j--;
                if (m != null) m.comparisons++;
            }
            if (i <= j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
            }
        }
        return j;
    }
}
