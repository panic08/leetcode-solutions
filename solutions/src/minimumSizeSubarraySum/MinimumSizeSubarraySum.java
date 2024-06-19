package minimumSizeSubarraySum;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0;

        int minLen = Integer.MAX_VALUE;
        int tempSum = 0;

        for (int r = 0; r < nums.length; r++) {
            tempSum += nums[r];

            while (tempSum >= target) {
                minLen = Math.min(minLen, r - l + 1);

                tempSum -= nums[l];
                l++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }


        return minLen;
    }
}
