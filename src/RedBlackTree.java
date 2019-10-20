public class RedBlackTree<K extends Comparable<K>, V> implements MapInterface{
    private Node root;
    private Node nil;

    public RedBlackTree(){
        root = null;
        nil = new Node();
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    @Override
    public void setValue(Comparable key, Object value) {
        if(root == null) {
            root = new Node(key, value);
            root.setRight(nil);
            root.setLeft(nil);
            root.setUp(nil);
            root.setRed(false);
        }
        else {
            Node tmp = root;
            Node n = new Node(key,value);
            while (n.getUp() == null) {
                while (key.compareTo(tmp.getKey()) > 0) {
                    if (tmp.getRight() != nil) {
                        tmp = tmp.getRight();
                    } else {
                        n.setUp(tmp);
                        n.setLeft(nil);
                        n.setRight(nil);
                        n.setRed(true);
                        tmp.setRight(n);
                        if(tmp.isRed())
                            fixRBT(n);
                    }
                }
                if (key.compareTo(tmp.getKey()) == 0) {
                    tmp.setValue(value);
                }
                while (key.compareTo(tmp.getKey()) < 0) {
                    if (tmp.getLeft() != nil) {
                        tmp = tmp.getLeft();
                    } else {
                        n.setUp(tmp);
                        n.setLeft(nil);
                        n.setRight(nil);
                        n.setRed(true);
                        tmp.setLeft(n);
                        if(tmp.isRed())
                            fixRBT(n);
                    }
                }
            }
        }
    }

    @Override
    public Object getValue(Comparable key) {
        Node tmp = root;
        while (key.compareTo(tmp.getKey()) != 0){
            if(key.compareTo(tmp.getKey()) < 0 && tmp.getLeft() != nil){
                tmp = tmp.getLeft();
            }else if(key.compareTo(tmp.getKey()) > 0 && tmp.getRight() != nil){
                tmp = tmp.getRight();
            }else
                return null;
        }
        return tmp.getValue();
    }


    public void fixRBT(Node n) {
        Node upUp = n.getUp().getUp();

        while (n.getUp().isRed()) {

            // case 1
            if ((n.getUp().getUp().getLeft().getLeft() == n || n.getUp().getUp().getLeft().getRight() == n) && n.getUp().getUp().getRight().isRed()) {
                n.getUp().setRed(false);
                n.getUp().getUp().getRight().setRed(false);
                if (n.getUp().getUp().getUp() != nil) {
                    n.getUp().getUp().setRed(true);
                    n = n.getUp().getUp();
                }
            }

            // case 2
            if (n.getUp().getUp().getLeft().getRight() == n && !n.getUp().getUp().getRight().isRed()) {
                n = n.leftRotation();
//                Node tmp = n.getUp();
//                n.setLeft(n.getUp());
//                n.getUp().setUp(n);
//                n.setUp(tmp.getUp());
//                n = n.getLeft();
            }else if (n.getUp().getUp().getRight().getLeft() == n && !n.getUp().getUp().getLeft().isRed()) {
                n = n.rightRotation();
//                Node tmp = n.getUp();
//                n.setRight(n.getUp());
//                n.getUp().setUp(n);
//                n.setUp(tmp.getUp());
//                n = n.getRight();
            }

            // case 3
            if (n.getUp().getUp().getLeft().getLeft() == n && !n.getUp().getUp().getRight().isRed()) {
                n.setUp(n.getUp().getUp().rightRotation());
                n.getUp().changeColor();
                n.getUp().getRight().changeColor();
            }else if (n.getUp().getUp().getRight().getRight() == n && !n.getUp().getUp().getLeft().isRed()){
                n.setUp(n.getUp().getUp().leftRotation());
                n.getUp().changeColor();
                n.getUp().getLeft().changeColor();
            }
        }
    }

    public void wypiszDzieci(Node x, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println("Dla węzła " + x.getKey() + " dzieci to:");
        if (x.getLeft() != nil) {
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println("L: " + x.getLeft().getKey() + " " + x.getLeft().isRed());
            wypiszDzieci(x.getLeft(), level + 1);
        } else {
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println("L - nill");
        }
        if (x.getRight() != nil) {
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println("R: " + x.getRight().getKey() + " " + x.getRight().isRed());
            wypiszDzieci(x.getRight(), level + 1);
        } else {
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println("R - nill");
        }
    }
}
