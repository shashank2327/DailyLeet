class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> stack = new Stack<>();
        // int[] nextGreater = new int[n];
        // Arrays.fill(nextGreater, -1);
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = n - 1; i >= 0; i--) {
            int nextGreater = -1;
            while (!stack.isEmpty()) {
                if (stack.peek() > nums2[i]) {
                    nextGreater = stack.peek();
                    break;
                }
                stack.pop();
            }
            stack.push(nums2[i]);
            map.put(nums2[i], nextGreater);
        }

        int m = nums1.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int num = nums1[i];
            result[i] = map.get(num);
        }


        return result;
    }
}