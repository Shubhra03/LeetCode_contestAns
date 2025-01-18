class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        int diff = 0;
        for (int i = 1; i < nums.length; i++) {
            diff = Math.abs(nums[i] - nums[i - 1]);

            if (max < diff)
                max = diff;
        }
        diff = Math.abs(nums[nums.length - 1] - nums[0]);

        if (max < diff)
            max = diff;

        return max;

    }
}