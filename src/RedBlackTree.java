public class RedBlackTree<K extends Comparable<K>,V> {

    public Node root;

    public RedBlackTree(Node root){
        this.root = root;
    }

    public static void checkRight(Node tmp, Node n){
        while(tmp.getRight().compareTo(n) < 0) {
            if (tmp.hasRight())
                tmp = tmp.getRight();
            else
                tmp.setRight(n);
        }
    }

    public static void checkLeft(Node tmp, Node n){
        while (tmp.getLeft().compareTo(n) > 0) {
            if (tmp.hasLeft())
                tmp = tmp.getLeft();
            else
                tmp.setLeft(n);
        }
    }

    public void add(Node n){

        Node tmp = root;

        while(tmp.hasRight()) {
            checkRight(tmp, n);
            if (tmp.compareTo(n) == 0)
                tmp.setValue(n.getValue());
            checkLeft(tmp, n);
        }
    }

    public void leftRotation(Node n){

    }

    public void rightRotation(Node n){

    }

    
}
