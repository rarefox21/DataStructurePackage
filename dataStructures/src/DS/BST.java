package DS;

public class BST<T extends Comparable<T> > implements tree<T>{
    private Node<T> root;

    @Override
    /**
     * Insert data into the tree
     * @param data
     * @return void
     */
    public void insert(T data) {
        Node<T> temp = root;
        Node<T> newNode = new Node<T>(data);
        if (temp == null){
            root = newNode;
        }
        else{
            while (temp != null){
                if (temp.getData().compareTo(data) > 0){
                    if (temp.getLeft() == null){
                        temp.setLeft(newNode);
                        return;
                    }
                    else{
                        temp = temp.getLeft();
                    }
                }
                else{
                    if (temp.getRight() == null){
                        temp.setRight(newNode);
                        return;
                    }
                    else{
                        temp = temp.getRight();
                    }
                }
            }
        }
    }

    @Override
    /**
     * Delete node from the tree
     * @param node
     * @return void
     *
     */
    public void delete(Node<T> node) {
        Node<T> temp = root;
        Node<T> parent = null;
        while (temp != null){
            if (temp.getData().compareTo(node.getData()) == 0){
                break;
            }
            else if (temp.getData().compareTo(node.getData()) > 0){
                parent = temp;
                temp = temp.getLeft();
            }
            else{
                parent = temp;
                temp = temp.getRight();
            }
        }
        if (temp == null){
            return;
        }
        if (temp.getLeft() == null && temp.getRight() == null){
            if (parent == null){
                root = null;
            }
            else if (parent.getLeft() == temp){
                parent.setLeft(null);
            }
            else{
                parent.setRight(null);
            }
        }
        else if (temp.getLeft() == null){
            if (parent == null){
                root = temp.getRight();
            }
            else if (parent.getLeft() == temp){
                parent.setLeft(temp.getRight());
            }
            else{
                parent.setRight(temp.getRight());
            }
        }
        else if (temp.getRight() == null){
            if (parent == null){
                root = temp.getLeft();
            }
            else if (parent.getLeft() == temp){
                parent.setLeft(temp.getLeft());
            }
            else{
                parent.setRight(temp.getLeft());
            }
        }
        else{
            Node<T> successor = temp.getRight();
            Node<T> successorParent = null;
            while (successor.getLeft() != null){
                successorParent = successor;
                successor = successor.getLeft();
            }
            if (successorParent == null){
                successor.setLeft(temp.getLeft());
                if (parent == null){
                    root = successor;
                }
                else if (parent.getLeft() == temp){
                    parent.setLeft(successor);
                }
                else{
                    parent.setRight(successor);
                }
            }
            else{
                successorParent.setLeft(successor.getRight());
                successor.setLeft(temp.getLeft());
                successor.setRight(temp.getRight());
                if (parent == null){
                    root = successor;
                }
                else if (parent.getLeft() == temp){
                    parent.setLeft(successor);
                }
                else{
                    parent.setRight(successor);
                }
            }
        }
    }

    @Override
    /**
     * Traverse the tree
     * @param tech
     * @return void
     */
    public void traverse(travarseTech tech) {
        if (tech == travarseTech.INORDER){
            inOrder(root);
        }
        else if (tech == travarseTech.PREORDER){
            preOrder(root);
        }
        else if (tech == travarseTech.POSTORDER){
            postOrder(root);
        }
        else if (tech == travarseTech.LEVELORDER){
            levelOrder(root);
        }
    }

    @Override
    /**
     * Search for data in the tree
     * @param data
     * @return T
     */
    public T search(T data) {
        Node<T> temp = root;
        while (temp != null){
            if (temp.getData().compareTo(data) == 0){
                return temp.getData();
            }
            else if (temp.getData().compareTo(data) > 0){
                temp = temp.getLeft();
            }
            else{
                temp = temp.getRight();
            }
        }
        return null;
    }

    @Override

    /**
     * Get the root of the tree
     * @param root
     * @return Node<T>
     *
     */
    public Node<T> getRoot() {
        if (root == null){
            return null;
        }
        return root;
    }

    @Override
    /**
     * Set the root of the tree
     * @param root
     * @return void
     */
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    @Override
    /**
     * Get the number of nodes in the tree
     * @param root
     * @return int
     */
    public int nodeCount() {
        Node<T> temp = root;
        int count = 0;
        queue<Node<T>> q = new queue<Node<T>>(100);
        q.enqueue(temp);
        while (!q.isEmpty()){
            Node<T> temp2 = q.front();
            count++;
            q.dequeue();
            if (temp2.getLeft() != null){
                q.enqueue(temp2.getLeft());
            }
            if (temp2.getRight() != null){
                q.enqueue(temp2.getRight());
            }
        }
        return count;
    }

    @Override
    /**
     * Get the height of the tree
     * @return int
     */
    public int height() {
        Node<T> temp = root;
        int height = 0;
        queue<Node<T>> q = new queue<Node<T>>(100);
        q.enqueue(temp);
        q.enqueue(null);
        while (!q.isEmpty()){
            Node<T> temp2 = q.front();
            q.dequeue();
            if (temp2 == null){
                height++;
                if (!q.isEmpty()){
                    q.enqueue(null);
                }
            }
            else{
                if (temp2.getLeft() != null){
                    q.enqueue(temp2.getLeft());
                }
                if (temp2.getRight() != null){
                    q.enqueue(temp2.getRight());
                }
            }
        }
        return height;
    }

    /**
     * Inorder traversal of the tree
     * @param root
     * @return void
     *
     */
    private void inOrder(Node<T> root){
        if (root == null){
            return;
        }
        inOrder(root.getLeft());
        System.out.println(root.getData());
        inOrder(root.getRight());
    }

    /**
     * Preorder traversal of the tree
     * @param root
     * @return void
     *
     */
    private void preOrder(Node<T> root){
        if (root == null){
            return;
        }
        System.out.println(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    /**
     * Postorder traversal of the tree
     * @param root
     * @return void
     *
     */
    private void postOrder(Node<T> root){
        if (root == null){
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.getData());
    }

    /**
     * Levelorder traversal of the tree
     * @param root
     * @return void
     *
     */
    private void levelOrder(Node<T> root){
        queue<Node<T>> q = new queue<Node<T>>(100);
        q.enqueue(root);
        while (!q.isEmpty()){
            Node<T> temp = q.front();
            System.out.println(temp.getData());
            q.dequeue();
            if (temp.getLeft() != null){
                q.enqueue(temp.getLeft());
            }
            if (temp.getRight() != null){
                q.enqueue(temp.getRight());
            }
        }
    }

    /**
     * Tree Copy/Clone

     * @return BST<T>
     */
    public BST<T> copy() {
        BST<T> newTree = new BST<>();
        newTree.root = copy(root);
        return newTree;
    }

    private Node<T> copy(Node<T> node) {
        if (node == null) {
            return null;
        }
        Node<T> newNode = new Node<>(node.getData());
        newNode.setLeft(copy(node.getLeft()));
        newNode.setRight(copy(node.getRight()));
        return newNode;
    }

    /**
     * count the number of nodes in the tree

     * @return int
     */
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }

    /**
     * lowest common ancestor
     * @param value1
     * @param value2
     * @return T
     */
    public T findLowestCommonAncestor(T value1, T value2) {
        return findLowestCommonAncestor(root, value1, value2);
    }

    private T findLowestCommonAncestor(Node<T> node, T value1, T value2) {
        if (node == null) {
            return null;
        }

        if (node.getData().compareTo(value1) > 0 && node.getData().compareTo(value2) > 0) {
            return findLowestCommonAncestor(node.getLeft(), value1, value2);
        } else if (node.getData().compareTo(value1) < 0 && node.getData().compareTo(value2) < 0) {
            return findLowestCommonAncestor(node.getRight(), value1, value2);
        } else {
            return node.getData();
        }
    }


    /**
     * subtree search
     * @param subtree
     * @return boolean
     *
     */
    public boolean isSubtree(BST<T> subtree) {
        return isSubtree(root, subtree.root);
    }

    private boolean isSubtree(Node<T> root, Node<T> subtreeRoot) {
        if (subtreeRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        return (root.getData().equals(subtreeRoot.getData()) &&
                isSubtree(root.getLeft(), subtreeRoot.getLeft()) &&
                isSubtree(root.getRight(), subtreeRoot.getRight()));
    }


    /**
     * path sum
     * @param targetSum
     * @return boolean
     *
     */
    public boolean hasPathSum(T targetSum) {
        return hasPathSum(root, targetSum);
    }

    private boolean hasPathSum(Node<T> node, T targetSum) {
        if (node == null) {
            return false;
        }

        targetSum = subtract(targetSum, node.getData());

        if (node.getLeft() == null && node.getRight() == null) {
            return targetSum.equals(0);
        }

        return hasPathSum(node.getLeft(), targetSum) || hasPathSum(node.getRight(), targetSum);
    }

    private T subtract(T a, T b) {
        // Implement subtraction logic based on your type T
        // Example: return a - b;
        return null;
    }

    /**
     * diameter calculation
     * @return int
     *
     */

    public int calculateDiameter() {
        return calculateDiameter(root);
    }

    private int calculateDiameter(Node<T> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        int leftDiameter = calculateDiameter(node.getLeft());
        int rightDiameter = calculateDiameter(node.getRight());

        return Math.max(Math.max(leftDiameter, rightDiameter), leftHeight + rightHeight + 1);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }


}
