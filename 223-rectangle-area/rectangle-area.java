class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        boolean flag = false;
        int minTop = Math.min(ay2, by2);
        
        if (!(minTop <= ay2 && minTop >= ay1 && minTop <= by2 && minTop >= by1)) {
            flag = true;
        }
        
        int maxBottom = Math.max(by1, ay1);
        if (!(maxBottom <= ay2 && maxBottom >= ay1 && maxBottom <= by2 && maxBottom >= by1)) {
            flag = true;
        }
        
        int minRight = Math.min(bx2, ax2);
        if (!(minRight <= bx2 && minRight >= bx1 && minRight <= ax2 && minRight >= ax1)) {
            flag = true;
        }
        
        int maxLeft = Math.max(ax1, bx1);
        if (!(maxLeft <= bx2 && maxLeft >= bx1 && maxLeft <= ax2 && maxLeft >= ax1)) {
            flag = true;
        }
        
        if (minTop < maxBottom || minRight < maxLeft) flag = true;
        
        
        int overlap = 0;
        if (!flag) {
            overlap = (minTop - maxBottom) * (minRight - maxLeft);
        }
        
        int area1 = (ay2 - ay1) * (ax2 - ax1);
        int area2 = (by2 - by1) * (bx2 - bx1);
        
        
        return area1 + area2 - overlap;
    }
}