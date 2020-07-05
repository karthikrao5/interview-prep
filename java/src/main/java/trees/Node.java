package trees;

public class Node {
    Node left;
    Node right;
    int value;
    int height;

//    red is true black is false
    boolean color;

    public Node(int value) {
        right = null;
        left = null;
        this.value = value;
        height = 0;
        color = true;
    }
}
