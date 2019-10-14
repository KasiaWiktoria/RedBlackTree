public class RedBlackTree<K extends Comparable<K>,V> {

    public Node root;

    public RedBlackTree(Node root){
        this.root = root;
    }

    public void add(Node n){

        Node tmp = root;

        while(tmp.hasRight()) {
            while(tmp.getRight().compareTo(n) < 0) {
                if (tmp.hasRight())
                    tmp = tmp.getRight();
                else
                    tmp.setRight(n);
            }
            if (tmp.compareTo(n) == 0)
                tmp.setValue(n.getValue());

            while (tmp.getLeft().compareTo(n) > 0) {
                if (tmp.hasLeft())
                    tmp = tmp.getLeft();
                else
                    tmp.setLeft(n);
            }
        }
    }

    public void leftRotation(Node n){

    }

    public void rightRotation(Node n){

    }

    
}
