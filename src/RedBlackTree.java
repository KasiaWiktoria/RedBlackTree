import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RedBlackTree<K extends Comparable<K>, V> implements MapInterface {
    private Node root;
    private Node nil;

    public RedBlackTree() {
        root = null;
        nil = new Node();
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getNil() {
        return nil;
    }

    public void setNil(Node nil) {
        this.nil = nil;
    }

    @Override
    public void setValue(Comparable key, Object value) {
        if (root == null) {
            root = new Node(key, value);
            root.setRight(nil);
            root.setLeft(nil);
            root.setUp(nil);
            root.setRed(false);
        } else {
            Node tmp = root;
            Node n = new Node(key, value);
            while (n.getUp() == null) {
                if (key.compareTo(tmp.getKey()) > 0) {
                    if (tmp.getRight() != nil) {
                        tmp = tmp.getRight();
                    } else {
                        n.setUp(tmp);
                        n.setLeft(nil);
                        n.setRight(nil);
                        n.setRed(true);
                        tmp.setRight(n);
                        if (tmp.isRed())
                            fixRBT(n);
                    }
                }
                else if (key.compareTo(tmp.getKey()) == 0) {
                    tmp.setValue(value);
                }
                else if (key.compareTo(tmp.getKey()) < 0) {
                    if (tmp.getLeft() != nil) {
                        tmp = tmp.getLeft();
                    } else {
                        n.setUp(tmp);
                        n.setLeft(nil);
                        n.setRight(nil);
                        n.setRed(true);
                        tmp.setLeft(n);
                        if (tmp.isRed())
                            fixRBT(n);
                    }
                }
            }
        }
    }

    @Override
    public Object getValue(Comparable key) {
        Node tmp = root;
        while (key.compareTo(tmp.getKey()) != 0) {
            if (key.compareTo(tmp.getKey()) < 0 && tmp.getLeft() != nil) {
                tmp = tmp.getLeft();
            } else if (key.compareTo(tmp.getKey()) > 0 && tmp.getRight() != nil) {
                tmp = tmp.getRight();
            } else
                return null;
        }
        return tmp.getValue();
    }

    public Node leftRotation(Node n) {
        Node b = n.getRight();
        Node bLeft = n.getRight().getLeft();

        if(n.getUp().getLeft() == n){
            b.setUp(n.getUp());
            n.getUp().setLeft(b);
            n.getRight().getLeft().setUp(n);
            b.setLeft(n);
            n.setUp(b);
            n.setRight(bLeft);

        }else {
            b.setUp((n.getUp()));
            n.getUp().setRight(b);
            n.getRight().getLeft().setUp(n);
            b.setLeft(n);
            n.setUp(b);
            n.setRight(bLeft);
        }
        if(n == root){
            root = b;
        }
        return b;
    }

    public Node rightRotation(Node n) {
        Node b = n.getLeft();
        Node bRight = n.getLeft().getRight();

        if(n.getUp().getRight() == n){
            b.setUp(n.getUp());
            n.getUp().setRight(b);
            n.getLeft().getRight().setUp(n);
            b.setRight(n);
            n.setUp(b);
            n.setLeft(bRight);
        }else if(n.getUp().getLeft() == n){
            b.setUp((n.getUp()));
            n.getUp().setLeft(b);
            n.getLeft().getRight().setUp(n);
            b.setRight(n);
            n.setUp(b);
            n.setLeft(bRight);
        }
        if(n == root){
            root = b;
        }
        return b;
    }

    public void fixRBT(Node n) {
        if (n != nil && n.getUp().getUp() != nil && n.getUp().isRed()) {
            //father as left son
            if (n.getUp().getUp().getLeft() == n.getUp()) {
                //case 1
                if (n.getUp().getUp().getRight().isRed()) {
                    System.out.println("lewy syn, 1");
                    n.getUp().setRed(false);
                    n.getUp().getUp().getRight().setRed(false);
                    if (n.getUp().getUp().getUp() != nil) {
                        n.getUp().getUp().setRed(true);
                        fixRBT(n.getUp().getUp());
                    }
                }//case2
                else if (n.getUp().getRight() == n) {
                    System.out.println("lewy syn, 2");
                    n = leftRotation(n.getUp()).getLeft();
                    fixRBT(n);
                }//case 3
                else if (n.getUp().getLeft() == n) {
                    System.out.println("lewy syn, 3");
                    n.setUp(rightRotation(n.getUp().getUp()));
                    n.getUp().changeColor();
                    n.getUp().getRight().changeColor();
                }
            }//father as right son
            else if (n.getUp().getUp().getRight() == n.getUp()) {
                // case 1
                if (n.getUp().getUp().getLeft().isRed()) {
                    System.out.println("prawy syn, 1");
                    n.getUp().setRed(false);
                    n.getUp().getUp().getLeft().setRed(false);
                    if (n.getUp().getUp().getUp() != nil) {
                        n.getUp().getUp().setRed(true);
                        n = n.getUp().getUp();
                        fixRBT(n);
                    }
                    // case 2
                } else if (n.getUp().getLeft() == n) {
                    System.out.println("prawy syn, 2");
                    n = rightRotation(n.getUp()).getRight();
                    fixRBT(n);
                    // case 3
                } else if (n.getUp().getRight() == n) {
                    System.out.println("prawy syn, 3");
                    n.setUp(leftRotation(n.getUp().getUp()));
                    n.getUp().changeColor();
                    n.getUp().getLeft().changeColor();
                }
            }
        }
    }

    public int treeHeight() {
        int hr = 1, hl = 1;
        Node r = root;
        Node l = root;
        while (r.getRight() != nil || l.getLeft() != nil ) {
            if (r.getRight() != nil) {
                r = r.getRight();
                hr++;
            }
            if (l.getLeft() != nil ) {
                l = l.getLeft();
                hl++;
            }
        }
        if (hr > hl)
            return hr;
        else
            return hl;
    }

    public void print(){

        Node head = root;
        HashSet<Node> previous = new HashSet<>();
        printP(head,previous);
    }

    public void printP(Node head, HashSet<Node> previous){

        previous.add(head);

        if(root == null)
            return;

        if(head.getUp() == nil)
            System.out.println("KORZEŃ");
        System.out.print("Klucz: " + head.getKey() + "  ");
        System.out.print("Wartość: " + head.getValue() + "  ");
        System.out.println("czy czerwony: " + head.isRed());
        System.out.print("Ojciec: " + head.getUp().getKey() + "     ");
        System.out.print("Lewy: " + head.getLeft().getKey() + "   ");
        System.out.println("Prawy: " +  head.getRight().getKey() + "   ");
        System.out.println("\n");

        if(head.getLeft() != nil && !previous.contains(head.getLeft())){
            printP(head.getLeft(),previous);
        }else if (head.getRight() != nil && !previous.contains(head.getRight())){
            printP(head.getRight(),previous);
        }else {
            while((head.getLeft() == nil || previous.contains(head.getLeft())) && ((head.getRight() == nil) || previous.contains(head.getRight()))){
                head = head.getUp();
            }
            if(head.getRight() != nil && !previous.contains(head.getRight())){
                head =head.getRight();
            }else if (head.getLeft() != nil && !previous.contains(head.getLeft())){
                head = head.getLeft();
            }
            if(head != null)
                printP(head,previous);
        }
    }
}
