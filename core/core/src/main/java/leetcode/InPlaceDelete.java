package leetcode;

public class InPlaceDelete {
    public int removeElement(int[] nums, int val) {
        int deletedCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (deletedCount > 0) {
                nums[i - deletedCount] = nums[i];
                nums[i] = 0;
            }

            if (num == val) {
                deletedCount++;
            }

        }
        return nums.length - deletedCount;
    }

    public int removeDuplicates(int[] nums) {
        int deletedCount = 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (deletedCount > 0) {
                nums[i - deletedCount] = num;
                nums[i] = 0;
            }
            if (num == nums[i - 1 - deletedCount]) {
                deletedCount++;
            }
        }

        return nums.length - deletedCount;
    }
}
