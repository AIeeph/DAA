The experimental results align well with the theoretical expectations derived from recurrence analysis.

MergeSort followed the predicted T(n) = 2T(n/2) + Θ(n) recurrence (Master Theorem Case 2), showing Θ(n log n) growth. The measured runtime matched the theory, with only small constant-factor effects from buffer reuse and insertion-sort cutoffs.

QuickSort behaved as expected under random pivots, with average Θ(n log n) runtime and recursion depth bounded by O(log n). The iterative handling of the larger partition reduced stack depth significantly, confirming the theoretical bound.

Deterministic Select matched the linear recurrence given by the Akra–Bazzi theorem, confirming its Θ(n) runtime in practice. The constants were larger than randomized selection, but performance was stable even on adversarial inputs.

Closest Pair of Points matched its theoretical Θ(n log n) bound, with the strip check remaining efficient and consistent with the theoretical “7–8 neighbor” guarantee.

Overall, the measurements confirmed the divide-and-conquer complexity results. Minor mismatches between theory and practice were explained by constant factors such as cache locality, recursion overhead, and input size thresholds.
