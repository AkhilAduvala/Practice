public class SyncCounter {

    private int count;

    public synchronized void increment() {
        count++; // Not thread-safe
    }

    public int getCount() {
        return count; // Not thread-safe
    }
}
