public class Main {

    public static void main(String[] args) {

        RedBlackTree<Integer, Double> tree = new RedBlackTree<>();

        tree.setValue(7, 7.2);
        tree.print(tree.getRoot());
        tree.setValue(4, 4.1);
        tree.print(tree.getRoot());
        tree.setValue(8, 8.7);
        tree.print(tree.getRoot());
        tree.setValue(2, 2.4);
        tree.print(tree.getRoot());
        tree.setValue(5, 5.9);

        tree.print(tree.getRoot());
    }
}