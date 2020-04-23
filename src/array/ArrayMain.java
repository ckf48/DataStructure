package array;

/**
 * @author ckf48
 */
public class ArrayMain {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array.toString());
        array.add(1, 100);
        System.out.println(array.toString());
        array.addFirst(-1);
        System.out.println(array.toString());
        array.remove(2);
        System.out.println(array.toString());
        array.remove(4);
        System.out.println(array.toString());
    }
}
