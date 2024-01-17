package DS;

/**
 * @author Md. Rakin
 */
public class AVL<T extends Comparable<T>> implements tree<T> {
    private Node<T> root;
    private int nodeCount = 0;

    @Override
    /**
     * Insert data into the tree
     * @param data
     * @return void
     */
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            root = insert(root, data);
        }
        nodeCount++;
    }

    private Node<T> insert(Node<T> node, T data) {
        // Perform standard BST insert
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        } else {
            // Duplicate data not allowed
            return node;
        }

        // Update height of this ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // Get the balance factor
        int balance = getBalance(node);

        // If unbalanced, then there are 4 cases

        // Left Case
        if (balance > 1 && data.compareTo(node.left.data) < 0) {
            return rightRotate(node);
        }

        // Right, Right Case
        if (balance < -1 && data.compareTo(node.right.data) > 0) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && data.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && data.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (possibly new) root node
        return node;
    }

    @Override
    /**
     * Delete node from the tree
     * @param node
     * @return void
     *
     */
    public void delete(Node<T> data) {
        root = delete(root, data.data);
        nodeCount--;
    }

    /**
     * Delete node from the tree
     *
     * @param root
     * @param key
     * @return Node<T>
     */
    private Node<T> delete(Node<T> root, T key) {
        // Perform standard BST delete
        if (root == null) {
            return root;
        }
        if (key.compareTo(root.data) < 0) {
            root.left = delete(root.left, key);
        } else if (key.compareTo(root.data) > 0) {
            root.right = delete(root.right, key);
        } else {
            // node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node<T> temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }
                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else { // One child case
                    root = temp; // Copy the contents of the non-empty child
                }
            } else {
                // node with two children: get the inorder
                // successor (smallest in the right subtree)
                Node<T> temp = minValueNode(root.right);
                // copy the inorder successor's data to this node
                root.data = temp.data;
                // delete the inorder successor
                root.right = delete(root.right, temp.data);
            }
        }
        // if the tree had only one node then return
        if (root == null) {
            return root;
        }
        // update height of the current node
        root.height = max(height(root.left), height(root.right)) + 1;
        // get the balance factor
        int balance = getBalance(root);
        // if the node becomes unbalanced
        // Left Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        // Right, Right Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }
        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    @Override
    /**
     * Traverse the tree
     * @param tech
     * @return void
     */
    public void traverse(travarseTech tech) {
        if (tech == travarseTech.INORDER) {
            inorder(root);
        } else if (tech == travarseTech.PREORDER) {
            preorder(root);
        } else if (tech == travarseTech.POSTORDER) {
            postorder(root);
        }
    }

    /**
     * Traverse the tree in inorder
     *
     * @param node
     * @return void
     */
    private void inorder(Node<T> node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    /**
     * Traverse the tree in preorder
     *
     * @param node
     * @return void
     */
    private void preorder(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    /**
     * Traverse the tree in postorder
     *
     * @param node
     * @return void
     */
    private void postorder(Node<T> node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    /**
     * Search the tree for data
     *
     * @param data
     * @return T
     */
    @Override
    public T search(T data) {
        Node<T> result = search(root, data);
        return result == null ? null : result.data;
    }

    private Node<T> search(Node<T> node, T data) {
        if (node == null || node.data == data) {
            return node;
        }
        if (node.data.compareTo(data) > 0) {
            return search(node.left, data);
        }
        return search(node.right, data);
    }

    /**
     * Getters and Setters
     */
    @Override
    public Node<T> getRoot() {
        return root;
    }

    /**
     * Getters and Setters
     */
    @Override
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /**
     * nodeCount
     *
     * @return int
     */
    @Override
    public int nodeCount() {
        return nodeCount;
    }

    /**
     * height
     *
     * @return int
     */
    @Override
    public int height() {
        return root == null ? -1 : root.height;
    }

    // Helper methods for AVL Tree

    /**
     * minValueNode
     *
     * @param node
     * @return Node<T>
     */
    public Node<T> minValueNode(Node<T> node) {
        Node<T> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private int height(Node<T> node) {
        return node == null ? -1 : node.height;
    }

    /**
     * getBalance
     *
     * @param node
     * @return int
     */
    private int getBalance(Node<T> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    /**
     * rightRotate
     *
     * @param y
     * @return Node<T>
     */
    private Node<T> rightRotate(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }

    /**
     * leftRotate
     *
     * @param x
     * @return Node<T>
     */
    private Node<T> leftRotate(Node<T> x) {
        Node<T> y = x.right;
        Node<T> T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    /**
     * max
     *
     * @param a
     * @param b
     * @return int
     */
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * Tree Copy/Clone
     *
     *
     * @return AVL<T>
     */
    public AVL<T> cloneTree() {
        AVL<T> clonedTree = new AVL<>();
        clonedTree.root = cloneNode(root);
        clonedTree.nodeCount = nodeCount;
        return clonedTree;
    }

    private Node<T> cloneNode(Node<T> node) {
        if (node == null) {
            return null;
        }

        Node<T> clonedNode = new Node<>(node.data);
        clonedNode.left = cloneNode(node.left);
        clonedNode.right = cloneNode(node.right);
        clonedNode.height = node.height;

        return clonedNode;
    }

    /**
     * Find Lowest Common Ancestor
     *
     *
     * @return AVL<T>
     */

    public T findLCA(T node1, T node2) {
        return findLCA(root, node1, node2);
    }

    private T findLCA(Node<T> root, T node1, T node2) {
        if (root == null) {
            return null;
        }

        // If both nodes are smaller than the root, LCA must be in the left subtree
        if (node1.compareTo(root.data) < 0 && node2.compareTo(root.data) < 0) {
            return findLCA(root.left, node1, node2);
        }

        // If both nodes are greater than the root, LCA must be in the right subtree
        if (node1.compareTo(root.data) > 0 && node2.compareTo(root.data) > 0) {
            return findLCA(root.right, node1, node2);
        }

        // If one node is smaller and the other is greater, or one of them is equal to the root,
        // then the current root is the LCA
        return root.data;
    }

    /**
     * Subtree Search
     *
     *
     * @return AVL<T>
     */

    public boolean isSubtree(AVL<T> subtree) {
        return isSubtree(root, subtree.getRoot());
    }

    private boolean isSubtree(Node<T> root, Node<T> subtreeRoot) {
        if (subtreeRoot == null) {
            // An empty tree is always a subtree
            return true;
        }

        if (root == null) {
            // The main tree is empty, so the subtree cannot be present
            return false;
        }

        // Check if the current subtree is equal to the main tree rooted at this node
        if (isEqual(root, subtreeRoot)) {
            return true;
        }

        // Recursively check in the left and right subtrees
        return isSubtree(root.left, subtreeRoot) || isSubtree(root.right, subtreeRoot);
    }

    private boolean isEqual(Node<T> node1, Node<T> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.data.equals(node2.data) && isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);
    }

    /**
     * Path Sum
     *
     *
     * @return AVL<T>
     */

    public boolean hasPathSum(T sum) {
        return hasPathSum(root, sum);
    }

    private boolean hasPathSum(Node<T> node, T remainingSum) {
        if (node == null) {
            return false;
        }

        // Update the remaining sum by subtracting the current node's data
        T newRemainingSum = subtract(remainingSum, node.data);

        // Check if the current node is a leaf and if the remaining sum is zero
        if (node.left == null && node.right == null && compare(newRemainingSum, 0) == 0) {
            return true; // Found a path with the given sum
        }

        // Recursively check in the left and right subtrees
        return hasPathSum(node.left, newRemainingSum) || hasPathSum(node.right, newRemainingSum);
    }

    // Helper methods for numeric operations
    private T subtract(T a, T b) {
        // Implement subtraction logic here
        // This will depend on the actual type of T (e.g., Integer, Double)
        // For simplicity, assuming T is a numeric type
        return (T) Integer.valueOf(((Number) a).intValue() - ((Number) b).intValue());
    }

    private int compare(T a, int value) {
        // Implement comparison logic here
        // This will depend on the actual type of T (e.g., Integer, Double)
        // For simplicity, assuming T is a numeric type
        return Integer.compare(((Number) a).intValue(), value);
    }





        /**
         * Diameter Calculation
         *
         * @return int
         */
        public int calculateDiameter() {
            return calculateDiameter(root);
        }

        private int calculateDiameter(Node<T> root) {
            if (root == null) {
                return 0;
            }

            // Calculate the height of the left and right subtrees
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            // Calculate the diameter recursively for left and right subtrees
            int leftDiameter = calculateDiameter(root.left);
            int rightDiameter = calculateDiameter(root.right);

            // Return the maximum of the following three values:
            // 1. Diameter of the left subtree
            // 2. Diameter of the right subtree
            // 3. Sum of the heights of left and right subtrees + 1 (1 is for the current root)
            return Math.max(Math.max(leftDiameter, rightDiameter), leftHeight + rightHeight + 1);
        }



    }















