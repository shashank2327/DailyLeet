class Solution {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        List<String> parts = new ArrayList<>();

        int balance = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            balance += s.charAt(i) == '1' ? 1 : -1;

            if (balance == 0) {
                String inner = s.substring(start + 1, i);
                String optimised = "1" + makeLargestSpecial(inner) + "0";
                

                parts.add(optimised);
                start = i + 1;  
            }
        }

        parts.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (String part: parts) {
            sb.append(part);
        }

        return sb.toString();
    }
}