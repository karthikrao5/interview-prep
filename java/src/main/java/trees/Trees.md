# Trees

Binary search tree: Each node right child is greater than current and left is less than current

Worst case a tree with only right children, devolves into a linked list with O(n) worst case search

Solve problem with balancing the tree

Two main types of balanced trees:

1. AVL Tree
2. Red Black Tree

## AVL Tree

AVL tree guarantees O(log n) lookup by balancing the left and right subtree
of each node based on the balance factor being no more than 1

Balance factor of a node is the length of the right subtree minus the length of the left subtree. (or the difference between the two, no negatives)

If the balance factor of a node becomes more than 1, a rotation is needed to balance

![AVL tree insertion with rotation example](../assets/AVL_INSERTION2-1.jpg)

There are 4 rotation situations:
1. right rotation
2. left rotation
3. right-left rotation
4. left-right rotation

For a right rotation, the node below the node with BF of 2 becomes the new root of the subtree
![AVL Tree right rotation](../assets/avl_right_rotation.jpg)

for a right-left rotation, a left rotation followed by a right rotation


## Programmatically determine when to do a rotation and which type

Insertion happens like any BST, traverse the tree checking each node with the val to insert
and move left if the current node is greater than the value or right if the value is greater than the current node

Once in position, the recursion stack will start unraveling and at each point, recalculate the height and balance factor of each node.

This is where you determine which nodes need to be rotated.

Once the val has been inserted, recalculate the height of the current node (the parent of the one you inserted)

`curr.height = getHeight(curr);`

Once the value has been updated, calculate the balance factor by subtracting the height of the left subtree from the height of the right subtree.

As soon as the current node has a BF of more than 1, rotate on that node. 

A negative BF means the tree is right heavy (BF = height(leftSubtree) - height(rightSubtree))
A positive BF means the tree is left heavy since the left subtree is longer than the right.

Positive BF:
1. if the node's left child is also left heavy, perform one right rotation
2. If the node's left is not left heavy, a left right rotation to balance
 
 
 Negative BF:
 1. left rotation (if a node's right child is right heavy (BF of -1))
 2. right left rotation (if a node's right child is left heavy (BF of 0 or 1))
 