/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    TreeNode root;
    TreeNode pointer;

    public BSTIterator(TreeNode root) {
        this.root = root;
        pointer = new TreeNode(-1);
    }
    
    public int next() {
        TreeNode successor = findSuccessor(root, pointer);
        pointer = successor;
        return pointer.val;
    }
    
    public boolean hasNext() {
        TreeNode successor = findSuccessor(root, pointer);
        if (successor == null) {
            return false; 
        } else {
            return true;
        }
    }

    public TreeNode findSuccessor(TreeNode root, TreeNode node) {
        TreeNode temp = root; // so that my root does not gets changed;
        TreeNode result = null;
        while (temp != null) {
            if (temp.val > node.val) {
                result = temp;
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return result;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */