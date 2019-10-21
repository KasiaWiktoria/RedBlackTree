public class Node <K extends Comparable<K>,V>{
    private K key;
    private  V value;
    private Node up;
    private Node left;
    private Node right;
    private boolean isRed;

    public Node(){
    }

    public Node(K key, V value){
        this.key = key;
        this.value = value;
        this.isRed = true;
    }

    public void changeColor(){
        if(this.isRed())
            this.setRed(false);
        else
            this.setRed(true);
    }


    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node getUp() {
        return up;
    }

    public void setUp(Node up) {
        this.up = up;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }
}
