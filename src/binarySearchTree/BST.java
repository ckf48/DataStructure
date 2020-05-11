package binarySearchTree;

/**
 * @author ckf48
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {

        if (root == null) {
            root = new Node(e);
            size++;
        } else {
//            add(root, e);
            add2(root, e);
        }
    }

    //向以root为根的二分搜索树中插入元素e,递归算法

    private void add(Node root, E e) {
        if (e.equals(root.e)) {
            return;
        } else if (e.compareTo(root.e) < 0 && root.left == null) {
            root.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(root.e) > 0 && root.right == null) {
            root.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(root.e) < 0) {
            add(root.left, e);
        } else {
            add(root.right, e);
        }
    }

    //向以root为根的二分搜索树中插入元素e,递归算法
    //返回插入新节点后二分搜索树的根

    private Node add2(Node root, E e) {
        if (root == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(root.e) < 0) {
            root.left = add2(root.left, e);
        } else if (e.compareTo(root.e) > 0) {
            root.right = add2(root.right, e);
        }

        return root;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    public boolean contains(Node root, E e) {
        if (root == null) {
            return false;
        }

        if (e.compareTo(root.e) == 0) {
            return true;
        } else if (e.compareTo(root.e) < 0) {
            return contains(root.left, e);
        } else {
            return contains(root.right, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }

    public void afterOrder() {
        afterOrder(root);
    }

    private void afterOrder(Node root) {
        if (root == null) {
            return;
        }

        afterOrder(root.left);
        afterOrder(root.right);
        System.out.println(root.e);
    }
}
