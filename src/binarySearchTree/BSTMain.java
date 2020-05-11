package binarySearchTree;

/**
 * @author ckf48
 */
public class BSTMain {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (var num : nums) {
            bst.add(num);
        }

        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.afterOrder();

    }
}
