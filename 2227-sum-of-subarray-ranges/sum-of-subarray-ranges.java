class Solution {
    public long subArrayRanges(int[] nums) {
        long minSum = min(nums);
        long maxSum = max(nums);
        return maxSum - minSum;
    }
    public long min(int[] arr) {
        int MOD = (int)(1e9 + 7);
        long res = 0;
        Stack<int[]> stack = new Stack<>(); // (index, value)

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < stack.peek()[1]) {
                int[] popped = stack.pop();
                int j = popped[0];
                int m = popped[1];
                
                int left = stack.isEmpty() ? (j + 1) : (j - stack.peek()[0]);
                int right = i - j;
                res = (res + (long)m * left * right);
            }
            stack.push(new int[]{i, arr[i]});
        }

        for (int i = 0; i < stack.size(); i++) {
            int[] element = stack.get(i);
            int j = element[0];
            int n = element[1];
            
            int left = i > 0 ? (j - stack.get(i - 1)[0]) : (j + 1);
            int right = arr.length - j;
            res = (res + (long)n * left * right);
        }
        
        return res;
    }

    public long max(int[] arr) {
        int MOD = (int)(1e9 + 7);
        long res = 0;
        Stack<int[]> stack = new Stack<>(); // (index, value)

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek()[1]) {
                int[] popped = stack.pop();
                int j = popped[0];
                int m = popped[1];
                
                int left = stack.isEmpty() ? (j + 1) : (j - stack.peek()[0]);
                int right = i - j;
                res = (res + (long)m * left * right);
            }
            stack.push(new int[]{i, arr[i]});
        }

        for (int i = 0; i < stack.size(); i++) {
            int[] element = stack.get(i);
            int j = element[0];
            int n = element[1];
            
            int left = i > 0 ? (j - stack.get(i - 1)[0]) : (j + 1);
            int right = arr.length - j;
            res = (res + (long)n * left * right);
        }
        
        return res;
    }
}