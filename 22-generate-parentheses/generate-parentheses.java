class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(result, n, 0, 0, "");
        return result;
    }

    public void solve(List<String> list, int n, int ob, int cb, String s) {
        // base condition;
        if (ob == n && cb == n) {
            list.add(s);
            return;
        }

        if (ob == n) {
            solve(list, n, ob, cb + 1, s + ")");
        } else if (ob == cb) {
            solve(list, n, ob + 1, cb, s + "(");
        } else {
            solve(list, n, ob + 1, cb, s + "(");
            solve(list, n, ob, cb + 1, s + ")");
        }
    }
} 


// The main idea over here is ->
// if (open bracket used == n; then we must use close bracket now);
// if (open bracket == close bracket); then we must use open bracket again;
// else append both;