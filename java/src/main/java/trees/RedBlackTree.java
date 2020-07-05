package trees;

public class RedBlackTree {
    private Node root;

    public RedBlackTree() {
        root = null;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            root.color = false;
        }
    }

    public String postOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        postOrderTraversal(root, sb);
        return sb.toString();
    }

    public void postOrderTraversal(Node curr, StringBuilder sb) {
        if (curr == null) {
            return;
        }

        postOrderTraversal(curr.left, sb);
        postOrderTraversal(curr.right, sb);
        sb.append(String.format("%d,", curr.value));
    }
}
