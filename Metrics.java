package DAA;

public class Metrics {
    public long timeNs = 0;
    public long comparisons = 0;
    public long allocations = 0;
    public int recursionDepth = 0;

    @Override
    public String toString() {
        return String.format("timeNs=%d comps=%d allocs=%d depth=%d",
                timeNs, comparisons, allocations, recursionDepth);
    }
}
