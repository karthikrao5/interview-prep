package trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AVLTreeTest {
    @Test
    void insertOneItem() {
        AVLTree tree = new AVLTree();

        tree.insert(1);

        assertEquals("1,", tree.inOrderTraversal());
    }

    @Test
    void insertTwoItemsInOrder() {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(1);

        assertEquals("1,10,", tree.inOrderTraversal());
    }

    @Test
    void insertThreeItemsInOrder() {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(1);
        tree.insert(11);

        assertEquals("1,10,11,", tree.inOrderTraversal());
    }

    @Test
    void insertRightRotation() {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(9);
        tree.insert(8);

        assertEquals("8,9,10,", tree.inOrderTraversal());
    }

    @Test
    void insertLeftRotation() {
        AVLTree tree = new AVLTree();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        assertEquals("1,2,3,", tree.inOrderTraversal());
    }

    @Test
    void insertLeftRightRotation() {
        AVLTree tree = new AVLTree();

        tree.insert(12);
        tree.insert(9);
        tree.insert(10);

        assertEquals("9,10,12,", tree.inOrderTraversal());
        assertEquals("9,12,10,", tree.postOrderTraversal());
    }

    @Test
    void insertRightLeftRotation() {
        AVLTree tree = new AVLTree();

        tree.insert(12);
        tree.insert(15);
        tree.insert(13);

        assertEquals("12,13,15,", tree.inOrderTraversal());
        assertEquals("12,15,13,", tree.postOrderTraversal());
    }

    @Test
    void largeInsert() {
        AVLTree tree = new AVLTree();

        tree.insert(14);
        tree.insert(12);
        tree.insert(1);
        tree.insert(0);
        tree.insert(6);
        tree.insert(4);
        tree.insert(9);

        BTreePrinter.printNode(tree.root);

        assertEquals("0,1,4,6,9,12,14,", tree.inOrderTraversal());
        assertEquals("0,4,1,9,14,12,6,", tree.postOrderTraversal());
    }

    @Test
    void largeInsert2() {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(9);
        tree.insert(8);
        tree.insert(7);
        tree.insert(6);

        assertEquals("6,7,8,9,10,", tree.inOrderTraversal());
        assertEquals("6,8,7,10,9,", tree.postOrderTraversal());
    }

    @Test
    void largeInsert3() {
        AVLTree tree = new AVLTree();

        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(12);

        assertEquals("10,12,15,20,", tree.inOrderTraversal());
        assertEquals("12,10,20,15,", tree.postOrderTraversal());

        tree.insert(11);

        BTreePrinter.printNode(tree.root);

        assertEquals("10,11,12,15,20,", tree.inOrderTraversal());
        assertEquals("10,12,11,20,15,", tree.postOrderTraversal());
    }

    @Test
    void largeInsert4() {
        AVLTree tree = new AVLTree();

        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(12);
        tree.insert(17);
        tree.insert(18);

        assertEquals("10,12,15,17,18,20,", tree.inOrderTraversal());
    }

    @Test
    void largeInsert5() {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(-10);
        tree.insert(-20);

        BTreePrinter.printNode(tree.root);

        assertEquals("-20,-10,5,10,15,", tree.inOrderTraversal());
    }

    @Test
    void largeInsert6() {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(-10);
        tree.insert(-5);

        BTreePrinter.printNode(tree.root);

        assertEquals("-10,-5,5,10,15,", tree.inOrderTraversal());
    }
}