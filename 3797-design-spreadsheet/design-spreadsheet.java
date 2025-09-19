class Spreadsheet {

    int rows;
    int[][] sheet;
    // constructor
    public Spreadsheet(int rows) {
        sheet = new int[rows + 1][26];
    }

    //fun1
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 65;
        String r = cell.substring(1);
        int rw = Integer.parseInt(r);
        sheet[rw][col] = value;
    }

    // fun2
    public void resetCell(String cell) {
        int col = cell.charAt(0) - 65;
        String r = cell.substring(1);
        int rw = Integer.parseInt(r);
        sheet[rw][col] = 0;
    }


    // fun3
    public int getValue(String formula) {
        boolean f = formula.charAt(1) >= 65 && formula.charAt(1) <= 90;
        boolean s = false;
        for (int i = 2; i < formula.length(); i++) {
            if (formula.charAt(i) >= 65 && formula.charAt(i) <= 90) {
                s = true;
                break;
            }
        }
        int plusInd = 0;
        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '+') {
                plusInd = i;
                break;
            }
        }

        int ans = 0;
        if (f && s) {
            String r = formula.substring(plusInd + 2);
            int rw = Integer.parseInt(r);
            int val1 = sheet[rw][formula.charAt(plusInd + 1) - 65];
            String r1 = formula.substring(2, plusInd);
            int rw1 = Integer.parseInt(r1);
            int val2 = sheet[rw1][formula.charAt(1) - 65];
            return val1 + val2;
        } else if (f) {
            String r = formula.substring(2, plusInd);
            int rw = Integer.parseInt(r);
            int val1 = sheet[rw][formula.charAt(1) - 65];
            int val2 = Integer.parseInt(formula.substring(plusInd + 1));
            return val1 + val2;
        } else if (s) {
            String r = formula.substring(plusInd + 2);
            int rw = Integer.parseInt(r);
            int val1 = sheet[rw][formula.charAt(plusInd + 1) - 65];
            int val2 = Integer.parseInt(formula.substring(1, plusInd));
            return val1 + val2;
        } else {
            String v1 = formula.substring(1, plusInd);
            int val1 = Integer.parseInt(v1);
            String v2 = formula.substring(plusInd + 1);
            int val2 = Integer.parseInt(v2);
            return val1 + val2;
        }
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */