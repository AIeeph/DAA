package DAA;

public class DeterministicSelect {
    public static int select(int[] a, int k, Metrics m) {
        return select(a, 0, a.length, k, m);
    }

    private static int select(int[] a, int l, int r, int k, Metrics m) {
        while (true) {
            int n = r - l;
            if (n <= 10) {
                java.util.Arrays.sort(a, l, r);
                return a[l + k];
            }
            int numGroups = (n + 4) / 5;
            for (int i = 0; i < numGroups; i++) {
                int gl = l + i * 5;
                int gr = Math.min(gl + 5, r);
                java.util.Arrays.sort(a, gl, gr);
                int median = gl + (gr - gl) / 2;
                swap(a, l + i, median);
            }
            int pivot = select(a, l, l + numGroups, numGroups / 2, m);
            int[] pivotRange = partitionAround(a, l, r, pivot);
            int leftSize = pivotRange[0] - l;
            int midSize = pivotRange[1] - pivotRange[0];
            if (k < leftSize) {
                r = pivotRange[0];
            } else if (k < leftSize + midSize) {
                return pivot;
            } else {
                k -= leftSize + midSize;
                l = pivotRange[1];
            }
            if (m != null) m.recursionDepth++;
        }
    }

    private static int[] partitionAround(int[] a, int l, int r, int pivotVal) {
        int i = l, lt = l, gt = r;
        while (i < gt) {
            if (a[i] < pivotVal) {
                swap(a, lt++, i++);
            } else if (a[i] > pivotVal) {
                swap(a, --gt, i);
            } else i++;
        }
        return new int[]{lt, gt};
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
