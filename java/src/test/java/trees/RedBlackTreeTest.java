package trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {
    @Test
    void shouldBeAbleToInsertOneValue() {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(1);

        assertEquals("1,", tree.postOrderTraversal());
    }
}