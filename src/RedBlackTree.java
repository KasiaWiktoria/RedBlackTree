public class RedBlackTree implements MapInterface {

    public Node root;

    public RedBlackTree(Node root){
        this.root = root;
    }

    public static void checkRight(Node tmp, Node n){
        if(tmp.hasRight()) {
            while (tmp.getRight().getKey().compareTo(n) < 0) {
                if (tmp.hasRight())
                    tmp = tmp.getRight();
                else
                    tmp.setRight(n);
            }
        }
    }

    public static void checkLeft(Node tmp, Node n){
        if(tmp.hasLeft()) {
            while (tmp.getLeft().getKey().compareTo(n) > 0) {
                if (tmp.hasLeft())
                    tmp = tmp.getLeft();
                else
                    tmp.setLeft(n);
            }
        }
    }

    public void add(Node n){

        Node tmp = root;

        while(tmp.hasRight()) {
            checkRight(tmp, n);
            if (tmp.getKey().compareTo(n) == 0)
                tmp.setValue(n.getValue());
            checkLeft(tmp, n);
        }
    }

    public void leftRotation(Node n){

    }

    public void rightRotation(Node n){

    }


    @Override
    public void setValue(Comparable key, Object value) {

    }

    @Override
    public Object getValue(Comparable key) {
        return null;
    }
}
