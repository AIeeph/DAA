package DAA;

public class MergeSort {
    private static final int INSERTION_CUTOFF = 32;

    public static void sort(int[] a, Metrics m) {
        int[] buf = new int[a.length];
        sort(a, buf, 0, a.length, m);
    }

    private static void sort(int[] a, int[] buf, int l, int r, Metrics m) {
        int n = r - l;
        if (n <= 1) return;
        if (n <= INSERTION_CUTOFF) {
            insertion(a, l, r, m);
            return;
        }
        int mid = (l + r) >>> 1;
        sort(a, buf, l, mid, m);
        sort(a, buf, mid, r, m);
        int i = l, j = mid, k = l;
        while (i < mid || j < r) {
            if (i < mid && (j >= r || a[i] <= a[j])) {
                buf[k++] = a[i++];
            } else {
                buf[k++] = a[j++];
            }
            if (m != null) m.comparisons++;
        }
        System.arraycopy(buf, l, a, l, n);
        if (m != null) m.allocations++;
    }

    private static void insertion(int[] a, int l, int r, Metrics m) {
        for (int i = l + 1; i < r; i++) {
            int v = a[i], j = i;
            while (j > l && a[j - 1] > v) {
                a[j] = a[j - 1];
                j--;
                if (m != null) m.comparisons++;
            }
            a[j] = v;
        }
    }
}
