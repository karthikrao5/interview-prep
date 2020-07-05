package trees;

public class Node {
    Node left;
    Node right;
    int value;
    int height;

    public Node(int value) {
        right = null;
        left = null;
        this.value = value;
        height = 0;
    }
}
