/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author stankiek
 */
public class RedBlackTree<K extends Comparable<K>,V> {

    /**
     * @param args the command line arguments
     */

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

    public void leftRotation(){
        
    }


    public static void main(String[] args) {

        Node n1 = new Node(7, 'c');
        Node n2 = new Node(4, 'r');
        Node n3 = new Node(5, 'f');
        Node n4 = new Node(8, 'g');
        Node n5 = new Node(2, 'x');

        RedBlackTree tree = new RedBlackTree(n1);
        tree.add(n2);
        tree.add(n3);
        tree.add(n4);
        tree.add(n5);



    }
    
}
