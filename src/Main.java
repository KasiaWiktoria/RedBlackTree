public class Main {

    public static void main(String[] args) {

        RedBlackTree<Integer, Double> treeID = new RedBlackTree<>();

        treeID.setValue(23, 2.3);
        treeID.setValue(41, 4.1);
        treeID.setValue(58, 8.7);
        treeID.setValue(12, 2.4);
        treeID.setValue(25, 5.9);
        treeID.setValue(16, 1.6);
        System.out.println("Drzewo czerwono-czarne o kluczach Integer, zawierające wartości Double");
        System.out.println("_______________________________________________________________________");
        treeID.print(treeID.getRoot());

        RedBlackTree<Double, String> treeDS = new RedBlackTree<>();

        treeDS.print(treeDS.getRoot());
    }
}