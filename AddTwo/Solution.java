package AddTwo;

public class Solution {

    public static void main(String[] args) {
    
        int[] tests = new int[]{3, 3};

        Solution solution = new Solution();
        int[] results = solution.twoSum(tests, 6);

        System.out.println(results[0]);
        System.out.println(results[1]);

    }

    public int[] twoSum(int[] nums, int target) {
    
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] + value == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }
}