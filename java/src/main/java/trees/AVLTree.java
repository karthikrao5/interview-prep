package trees;

public class AVLTree {
    Node root;

    public AVLTree() {
        root = null;
    }

    public void insert(int val) {
        if (root == null) {
//            System.out.println("root is null inserting one value: " + val);
            root = new Node(val);
        } else {
            root = insertRecursively(root, val);
        }
    }

    private Node insertRecursively(Node curr, int val) {
//        System.out.println("Attempting to insert: " + val);
        if (curr == null) {
            return new Node(val);
        }
        if (curr.value > val) {
            curr.left = insertRecursively(curr.left, val);
        } else if (curr.value < val) {
            curr.right = insertRecursively(curr.right, val);
        } else {
            //cant have dupes
            return curr;
        }

        //after finding the right spot to put the node, check if tree is still AVL

        curr.height = height(curr);

        // check for rotation cases

        int currBalanceFactor = balanceFactor(curr);
//        System.out.println("Balance factor on node: " + curr.value + " is : " + currBalanceFactor);

        //left heavy
        if (currBalanceFactor == 2) {
            if (balanceFactor(curr.left) == 1) {
                //single right rotation
//                System.out.println("found right rotation around: " + curr.value);
                return rightRotation(curr);
            } else {
                //left right rotation
//                System.out.println("found left-right rotation around: " + curr.value);
                return leftRightRotation(curr);
            }
        }

        //right heavy
        if (currBalanceFactor == -2) {
            if (balanceFactor(curr.right) == -1) {
//                System.out.println("found left rotation around: " + curr.value);
                return leftRotation(curr);
            } else {
//                System.out.println("found right-left rotation around: " + curr.value);
                return rightLeftRotation(curr);
            }
        }

        return curr;
    }

    private Node rightRotation(Node a) {
        Node b = a.left;
        Node temp = b.right;

        b.right = a;
        a.left = temp;

        a.height = height(a);
        b.height = height(b);

        return b;
    }

    private Node leftRotation(Node a) {
        Node b = a.right;
        Node temp = b.left;

        b.left = a;
        a.right = temp;

        a.height = height(a);
        b.height = height(b);

        return b;
    }

    private Node leftRightRotation(Node a) {
        a.left = leftRotation(a.left);
        return rightRotation(a);
    }

    private Node rightLeftRotation(Node a) {
        a.right = rightRotation(a.right);
        return leftRotation(a);
    }

    private int balanceFactor(Node curr) {
        if (curr != null) {
            return height(curr.left) - height(curr.right);
        }

        return 0;
    }

    private int height(Node curr) {
        if (curr == null) {
            return -1;
        }

        return 1 + Math.max(height(curr.left), height(curr.right));
    }

    ////////////// print helper functions /////////////////
    public String postOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        postOrderTraversal(root, sb);
        return sb.toString();
    }

    private void postOrderTraversal(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left, sb);
        postOrderTraversal(node.right, sb);
        sb.append(String.format("%d,", node.value));
    }

    public String inOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        inOrderRecursive(root, sb);
        return sb.toString();
    }

    private void inOrderRecursive(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        inOrderRecursive(node.left, sb);
        sb.append(String.format("%d,", node.value));
        inOrderRecursive(node.right, sb);
    }
}