
import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        int second = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            // Found nums[i] < nums[k] < nums[j]
            if (nums[i] < second) {
                return true;
            }

            // nums[i] can become the "2" candidate
            while (!st.isEmpty() && nums[i] > st.peek()) {
                second = st.pop();
            }

            st.push(nums[i]);
        }

        return false;
    }
}
