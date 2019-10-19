/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stankiek
 */
public class Node<K extends  Comparable<K>,V> {
    
    private K key;
    private V value;
    private Node left;
	private Node right;
	private Node up;
	private boolean isRed;


    public Node(K key, V value){

    	this.key = key;
    	this.value = value;
		this.isRed = true;
	}

	public K getKey(){
    	return key;
    }

	public void setKey(K k){
    	this.key = k;
    }

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
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

	public Node getUp() {
		return up;
	}

	public void setUp(Node up) {
		this.up = up;
	}

	public boolean isRed() {
		return isRed;
	}

	public void setIsRed(boolean isRed) {
		this.isRed = isRed;
	}
}
