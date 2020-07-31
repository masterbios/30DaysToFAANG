package Day22_MixedQuestions;

import Day12_Bits.FindMSB;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInAStream {

    PriorityQueue<Integer> max; // first half
    PriorityQueue<Integer> min; // second half

    public FindMedianInAStream() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }

    public void add(int val) {
        max.add(val);
        min.add(max.poll());
        if (min.size() > max.size()) max.add(min.poll());
    }

    public double getMedian() {
        double ans = 0.0d;
        if (min.size() != max.size()) ans = max.peek();
        else {
            ans = min.peek() + max.peek();
            ans /= 2.0d;
        }
        return ans;
    }
}
