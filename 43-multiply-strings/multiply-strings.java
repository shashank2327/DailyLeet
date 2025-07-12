class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int[] res = new int[num1.length() + num2.length()];
        int n1 = num1.length();
        int n2 = num2.length();
        
        for (int i = n1 - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                int mul = d1 * d2 + res[i + j + 1];
                
                res[i + j + 1] = mul % 10;
                res[i + j] += mul / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int r : res) {
            if (!(sb.length() == 0 && r == 0)) {
                sb.append(r);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}