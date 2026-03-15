class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class MinimalTree {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = createMinimalBST(array);
        System.out.println("Root of minimal BST: " + root.data);
        System.out.print("In-order traversal: ");
        printInOrder(root);
        System.out.println();
        System.out.println("Height of tree: " + getHeight(root));
    }

    public static TreeNode createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    private static TreeNode createMinimalBST(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(array[mid]);
        n.left = createMinimalBST(array, start, mid - 1);
        n.right = createMinimalBST(array, mid + 1, end);
        return n;
    }

    private static void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
