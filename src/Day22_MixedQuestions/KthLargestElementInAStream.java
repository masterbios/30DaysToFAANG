package Day22_MixedQuestions;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    PriorityQueue<Integer> min;
    int k;

    public KthLargestElementInAStream(int k) {
        this.min = new PriorityQueue<>();
        this.k = k;
    }

    public void add(int val) {
        if (min.size() >= k && val > min.peek()) {
            min.offer(val);
            min.poll();
        } else {
            min.offer(val);
        }
    }

    public int getKthLargest() {
        return min.peek();
    }
}
