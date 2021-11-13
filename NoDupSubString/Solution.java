package NoDupSubString;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> subStrings = new HashMap<>();
        
        while(left <= right && right < s.length()) {

            // contains duplicates
            if (subStrings.containsKey(s.charAt(right))) {
                //calculate max length
                if (subStrings.size() > maxLength) {
                    maxLength = subStrings.size();
                }

                
                // restart from current dup position
                left = subStrings.get(s.charAt(right)) + 1;
                
                //reset
                subStrings.clear();
                for(int i=left; i < right; i++) {
                    subStrings.put(s.charAt(i), i);
                }
            }
            
            // add current position value to map
            subStrings.put(s.charAt(right), right);

            //move right cursor forward.
            right += 1;
        }

        if (maxLength < subStrings.size()) {
            maxLength = subStrings.size();
        }

        return maxLength;
    }
}