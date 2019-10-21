import java.util.Random;

public class Main {

    public static void main(String[] args) {

        RedBlackTree<Integer, Double> treeID = new RedBlackTree<>();

        treeID.setValue(64, 7.1);
        treeID.setValue(864, 2.3);
        treeID.setValue(109, 2.3);
        treeID.setValue(23, 2.3);
        treeID.setValue(41, 4.1);
        treeID.setValue(58, 8.7);
        treeID.setValue(132, 2.4);
        treeID.setValue(614, 7.1);
        treeID.setValue(489, 6.9);
        treeID.setValue(25, 5.9);
        treeID.setValue(16, 1.6);
        treeID.setValue(236, 2.3);
        treeID.setValue(141, 4.1);
        treeID.setValue(158, 8.7);
        treeID.setValue(112, 2.4);
        treeID.setValue(1, 7.1);
        treeID.setValue(3, 89.1);

        System.out.println("Drzewo czerwono-czarne o kluczach Integer, zawierające wartości Double");
        System.out.println("_______________________________________________________________________");
        treeID.print();

        RedBlackTree<Double, Double> treeDD = new RedBlackTree<>();

        treeDD.setValue(2.5, 5.9);
        treeDD.setValue(0.16, 1.6);
        treeDD.setValue(23.6, 2.3);
        treeDD.setValue(0.141, 4.1);
        treeDD.setValue(1.58, 8.7);
        treeDD.setValue(112.0, 2.4);
        treeDD.setValue(1.4, 7.1);
        treeDD.setValue(8.3, 89.1);
        treeDD.setValue(6.84, 7.1);
        treeDD.setValue(86.4, 2.3);
        treeDD.setValue(10.9, 2.3);
        treeDD.setValue(0.23, 2.3);
        treeDD.setValue(41.9, 4.1);
        treeDD.setValue(5.8, 8.7);
        treeDD.setValue(13.2, 2.4);
        treeDD.setValue(6.14, 7.1);
        treeDD.setValue(4.89, 6.9);

        System.out.println("Drzewo czerwono-czarne o kluczach Double, zawierające wartości Double");
        System.out.println("_______________________________________________________________________");

        treeDD.print();

        RedBlackTree<Integer,Integer> treeII = new RedBlackTree<>();

        treeII.setValue(17, 14);
        treeII.setValue(84, 23);
        treeII.setValue(609, 3);
        treeII.setValue(123, 83);
        treeII.setValue(91, 41);
        treeII.setValue(58, 87);
        treeII.setValue(32, 24);
        treeII.setValue(614, 71);
        treeII.setValue(99, 69);
        treeII.setValue(215, 59);
        treeII.setValue(74, 16);
        treeII.setValue(36, 73);
        treeII.setValue(111, 1);
        treeII.setValue(18, 87);
        treeII.setValue(112, 4);
        treeII.setValue(1, 71);
        treeII.setValue(3, 89.1);

        System.out.println("Drzewo czerwono-czarne o kluczach Integer, zawierające wartości Integer");
        System.out.println("_______________________________________________________________________");

        treeII.print();
    }

    private static void setVWithTime(RedBlackTree<Integer, Integer> tree, int n) {
        long start = System.nanoTime();
        tree.setValue(n, n);
        long nanoTime = System.nanoTime() - start;
    }

    private static void getVWithTime(RedBlackTree<Integer, Integer> tree, int n) {
        tree.setValue(n, n);
        long start = System.nanoTime();
        tree.getValue(n);
        long nanoTime = System.nanoTime() - start;
        System.out.println(nanoTime);
    }


}