package AddTwo;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
    
        int[] tests = new int[]{3, 3};

        Solution solution = new Solution();
        int[] results = solution.twoSum(tests, 6);

        System.out.println(results[0]);
        System.out.println(results[1]);

    }

    public int[] twoSum(int[] nums, int target) {
    
        // 暴力搜索，最坏情况，搜两次，
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

    // 第一个访问的问题在于，对于每一个 X，都要依次遍历所有的元素来查抄 target - X
    // 所以，提高效率的方法就在于把查找 target - X 的时间，缩短为 O(1), 利用 hash 表
    public int[] twoHashSum(int[] nums, int target) {

        Map<Integer, Integer> table = new HashMap<Integer, Integer>();

        for(int i=0; i < nums.length; i++) {
            if (table.containsKey(nums[i])) {
                return new int[]{i, table.get(nums[i])};
            }
            table.put(nums[i], i);
        }

        return new int[0];
    }
}