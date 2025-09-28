package Example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 9, 1, 5, 6};
        MergeSort.sort(arr1);
        System.out.println("MergeSort: " + Arrays.toString(arr1));

        int[] arr2 = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        QuickSort.sort(arr2);
        System.out.println("QuickSort: " + Arrays.toString(arr2));

        int[] arr3 = {12, 3, 5, 7, 4, 19, 26};
        int k = 3;
        int kth = DeterministicSelect.select(arr3, k);
        System.out.println(k + "-th smallest: " + kth);

        ClosestPair.Point[] points = {
            new ClosestPair.Point(2, 3),
            new ClosestPair.Point(12, 30),
            new ClosestPair.Point(40, 50),
            new ClosestPair.Point(5, 1),
            new ClosestPair.Point(12, 10),
            new ClosestPair.Point(3, 4)
        };
        double dist = ClosestPair.closest(points);
        System.out.println("Closest pair distance: " + dist);
    }
}
