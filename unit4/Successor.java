class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode(int data) {
        this.data = data;
    }
}

public class Successor {
    public static void main(String[] args) {
        // Constructing BST
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n8 = new TreeNode(8);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n10 = new TreeNode(10);

        n5.left = n3; n3.parent = n5;
        n5.right = n8; n8.parent = n5;
        n3.left = n1; n1.parent = n3;
        n3.right = n4; n4.parent = n3;
        n8.left = n7; n7.parent = n8;
        n8.right = n10; n10.parent = n8;

        System.out.println("Successor of 3 (has right child): " + (inOrderSuccessor(n3) != null ? inOrderSuccessor(n3).data : "null"));
        System.out.println("Successor of 4 (no right child, parent is 3): " + (inOrderSuccessor(n4) != null ? inOrderSuccessor(n4).data : "null"));
        System.out.println("Successor of 10 (last node): " + (inOrderSuccessor(n10) != null ? inOrderSuccessor(n10).data : "null"));
    }

    public static TreeNode inOrderSuccessor(TreeNode n) {
        if (n == null) return null;

        // Case 1: Node has right child -> successor is leftmost of right subtree
        if (n.right != null) {
            return leftMostChild(n.right);
        } else {
            // Case 2: Node has no right child -> successor is the first ancestor whose left child is also an ancestor of target
            TreeNode q = n;
            TreeNode x = q.parent;
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    private static TreeNode leftMostChild(TreeNode n) {
        if (n == null) return null;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
}
