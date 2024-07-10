package slidingWindowMaximum;

import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxSlidingWindow = new int[nums.length - k + 1];
        int maxSlidingWindowIndex = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            while (r - l + 1 > k) {
                if (!deque.isEmpty() && deque.getFirst().equals(nums[l])) {
                    deque.removeFirst();
                }

                l++;
            }

            while (!deque.isEmpty() && deque.getLast() < nums[r]) {
                deque.removeLast();
            }

            deque.addLast(nums[r]);

            if (r - l + 1 == k) {
                maxSlidingWindow[maxSlidingWindowIndex] = deque.getFirst();
                maxSlidingWindowIndex++;
            }
        }

        return maxSlidingWindow;
    }
}
