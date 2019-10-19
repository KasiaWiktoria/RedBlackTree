import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RedBlackTree implements MapInterface {

    public Node root;
    public Node nil;

    public RedBlackTree(Node root){
        this.root = root;
        this.nil = new Node(-1,-1);
        this.nil.setIsRed(false);
        this.root.setUp(nil);
        this.root.setLeft(nil);
        this.root.setRight(nil);
    }

    public boolean hasLeft(Node n){
        if(n.getLeft() == nil)
            return false;
        else
            return true;
    }

    public boolean hasRight(Node n){
        if(n.getRight() == nil)
            return false;
        else
            return true;
    }

    public void add(Node n) {

        n.setRight(nil);
        n.setLeft(nil);
        Node tmp = root;

        while (n.getUp() == null){
            if (tmp.getKey().compareTo(n.getKey()) < 0) {
                if (hasRight(tmp)) {
                    tmp = tmp.getRight();
                }else{
                    tmp.setRight(n);
                    n.setUp(tmp);
                }
            } else if (tmp.getKey().compareTo(n.getKey()) > 0) {
                if (hasLeft(tmp)) {
                    tmp = tmp.getLeft();
                }else{
                    tmp.setLeft(n);
                    n.setUp(tmp);
                }
            } else
                tmp.setValue(n.getValue());
        }
        fixRBT(tmp,n);
    }

    public void fixRBT(Node tmp, Node n){
        if(root.isRed())
            root.setIsRed(false);

        if(tmp.isRed() && n.isRed() ){

            case1(tmp,n);
            case2(tmp, n);

//            //Case 2
//            Node upUp = tmp.getUp();
//            Node upR = tmp.getUp().getRight();
//            Node upL = tmp.getUp().getLeft();
//            if((upUp.getLeft() == tmp && upR.getColor() == 'b')) {
//                n.setLeft(tmp);
//                n.setUp(tmp.getUp());
//                tmp.setUp(n);
//
//                n = tmp;
//            }
        }
    }

    public void case1(Node tmp, Node n){

        while(n.getUp() != nil) {
            Node upUp = tmp.getUp();
            Node upR = tmp.getUp().getRight();
            Node upL = tmp.getUp().getLeft();

            if (hasLeft(upUp) && hasRight(upUp) && ((upUp.getLeft() == tmp && upR.isRed()) || (upUp.getRight() == tmp && upL.isRed()))) {
                upL.setIsRed(false);
                upR.setIsRed(false);
                if (upUp.getUp() != nil)
                    upUp.setIsRed(true);
            }
            n = upUp;
        }
    }

    public void case2(Node tmp, Node n){
        //Case 2.1
        Node upUp = tmp.getUp();
        Node upR = tmp.getUp().getRight();
        Node upL = tmp.getUp().getLeft();
        if(hasLeft(upUp) && hasRight(upUp) && (upUp.getLeft() == tmp && !upR.isRed() && tmp.getRight() == n)) {
            n.setLeft(tmp);
            n.setUp(tmp.getUp());
            tmp.setUp(n);

            n = tmp;
        }

        //Case 2.2
        if(hasLeft(upUp) && hasRight(upUp) && (upUp.getRight() == tmp && !upL.isRed() && tmp.getLeft() == n)) {
            n.setRight(tmp);
            n.setUp(tmp.getUp());
            tmp.setUp(n);

            n = tmp;
        }

        //Case 3.1
        if((hasLeft(upUp) && hasRight(upUp) && (upUp.getLeft() == tmp && !upR.isRed() && tmp.getLeft() == n))){
            tmp.setRight(upUp);
            tmp.setUp(upUp.getUp());
            upUp.setUp(tmp);

            tmp.setIsRed(false);
            upUp.setIsRed(true);
        }

        //Case 3.2
        if((hasLeft(upUp) && hasRight(upUp) && (upUp.getRight() == tmp && !upL.isRed() && tmp.getRight() == n))){
            tmp.setLeft(upUp);
            tmp.setUp(upUp.getUp());
            upUp.setUp(tmp);

            tmp.setIsRed(false);
            upUp.setIsRed(true);
        }
    }

    @Override
    public void setValue(Comparable key, Object value) {

    }

    @Override
    public Object getValue(Comparable key) {
        return null;
    }

    public int treeHeight(){
        int hr = 1, hl = 1;
        Node r = root;
        Node l = root;
        while(hasRight(r) || hasLeft(l)) {
            if(hasRight(r)) {
                r = r.getRight();
                hr++;
            }
            if(hasLeft(l)){
                l = l.getLeft();
                hl++;
            }
        }
        if(hr > hl)
            return hr;
        else
            return hl;
    }

    public void printTree(){

        int j = treeHeight();
        //int actualLevel = 0;

        //while (treeToArray()[actualLevel] != null)
        for (int actualLevel = 0; actualLevel < treeHeight() ; actualLevel++) {
            int actualNodeInLevel = 0;

            for (int i = j; i > 0; i--) {
                System.out.print("  ");
            }
            j--;

            System.out.print("\n    " + treeToArray()[actualLevel].get(0).getKey() + "\n");
            System.out.print(" aktualny węzęł: " + actualNodeInLevel +" \n");

            while (actualNodeInLevel < (2^actualLevel) && treeToArray()[actualLevel].get(actualNodeInLevel) != null) {
                System.out.print("Aktualny level: " + actualLevel + " ; " + actualNodeInLevel + " obrót pętli \n");
                System.out.print(treeToArray()[actualLevel].get(actualNodeInLevel).getValue());
                actualNodeInLevel++;

                for (int i = 0; i < actualLevel * 2; i++) {
                    System.out.print("  ");
                }

            }
            //actualLevel++;
        }
    }

    public ArrayList<Node>[] treeToArray(){
        HashMap<Node,Integer> previous = new HashMap<>();
        Node head = this.root;
        int j = treeHeight();
        ArrayList<Node> treeToPrint[] = new ArrayList[treeHeight()];

        while(hasLeft(head) || hasRight(head)) {

            int level = treeHeight() - j;
            previous.put(head, level);

            treeToPrint[level] = new ArrayList<>();
            //if(previous.values().contains(level))
            treeToPrint[level].add(head);

            if (hasLeft(head) && !previous.keySet().contains(head.getLeft())) {
                head = head.getLeft();
            } else if (hasRight(head) && !previous.keySet().contains(head.getRight())) {
                head = head.getRight();
            } else
                head = head.getUp();
            j--;
        }

        return treeToPrint;
    }

    public void print(){
        HashMap<Node,Integer> previous = new HashMap<>();
        Node head = this.root;
        int j = treeHeight();

        while( (head.getLeft() != nil || head.getRight() != nil) && head.getUp() != nil){
            int level = treeHeight() - j;

            System.out.print(head.getKey()+ "   "+head.getRight().getKey()+"    "+head.getLeft().getKey());


            if (hasLeft(head) && !previous.keySet().contains(head.getLeft())) {
                previous.put(head, level);
                head = head.getLeft();
            } else if (hasRight(head) && !previous.keySet().contains(head.getRight())) {
                head = head.getRight();
            } else if(head.getLeft() == nil && head.getRight() == nil ||  previous.keySet().contains((head.getLeft()))){
                head = head.getUp();
                j++;
            }
        }
        //while(head != nil);
        //; //poprawić warunek

        j--;
    }

    //    public static void checkRight(Node tmp, Node n){
//        if(tmp.hasRight()) {
//            while (tmp.getRight().getKey().compareTo(n.getKey()) < 0) {
//                if (tmp.hasRight())
//                    tmp = tmp.getRight();
//            }
//            if(!tmp.hasRight()) {
//                n.setUp(tmp);
//                tmp.setRight(n);
//            }
//        }
////        else {
////            n.setUp(tmp);
////            tmp.setRight(n);
////        }
//    }
//
//    public static void checkLeft(Node tmp, Node n){
//        if(tmp.hasLeft()) {
//            while (tmp.getLeft().getKey().compareTo(n.getKey()) > 0) {
//                if (tmp.hasLeft())
//                    tmp = tmp.getLeft();
//            }
//            if(!tmp.hasLeft()) {
//                n.setUp(tmp);
//                tmp.setLeft(n);
//            }
//        }
//        else{
//            n.setUp(tmp);
//            tmp.setLeft(n);
//        }
//    //poprzednia wersja add
//    public static void firstAdd(Node tmp, Node n){
//
//        if(tmp.hasRight()) {
//            while (tmp.hasRight()) {
//                checkRight(tmp, n);
//                if (tmp.getKey().compareTo(n.getKey()) == 0)
//                    tmp.setValue(n.getValue());
//                checkLeft(tmp, n);
//            }
//        }else if(tmp.hasLeft()){
//            while (tmp.hasLeft()){
//                checkLeft(tmp, n);
//                if (tmp.getKey().compareTo(n.getKey()) == 0)
//                    tmp.setValue(n.getValue());
//                checkRight(tmp, n);
//            }
//        }else if (tmp.getKey().compareTo(n.getKey()) == 0) {
//            tmp.setValue(n.getValue());
//        }else if (tmp.getKey().compareTo(n.getKey()) > 0) {
//            n.setUp(tmp);
//            tmp.setLeft(n);
//        }else if (tmp.getKey().compareTo(n.getKey()) < 0) {
//            n.setUp(tmp);
//            tmp.setRight(n);
//        }
//        //root = tmp;
//    }
}
