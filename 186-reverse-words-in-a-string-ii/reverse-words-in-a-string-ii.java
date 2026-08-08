class Solution {

    void reverseWords(char[] s, int left, int right) {
        while (left < right - 1) {
            char temp = s[left];
            s[left] = s[right - 1];
            s[right - 1] = temp;
            left++;
            right--;
        } 
    }

    public void reverseWords(char[] s) {
        int n = s.length;

        // Reversing the whole array;
        reverseWords(s, 0, n);

        // revers each sub string;
        int left = 0;
        int right = 0;

        while (right <= n) {
            if (right == n || s[right] == ' ') {
                reverseWords(s, left, right);
                right++;
                left = right;
            } else {
                right++;
            }
        }
    }
}