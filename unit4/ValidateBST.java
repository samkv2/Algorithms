class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class ValidateBST {
    public static void main(String[] args) {
        // Valid BST
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        System.out.println("Is valid BST: " + checkBST(root));

        // Invalid BST
        TreeNode invalidRoot = new TreeNode(10);
        invalidRoot.left = new TreeNode(5);
        invalidRoot.right = new TreeNode(15);
        invalidRoot.left.right = new TreeNode(12); // Invalid: 12 > 10 but in left subtree

        System.out.println("Is valid BST (invalid tree): " + checkBST(invalidRoot));
    }

    public static boolean checkBST(TreeNode n) {
        return checkBST(n, null, null);
    }

    private static boolean checkBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }
        if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
            return false;
        }
        return true;
    }
}
