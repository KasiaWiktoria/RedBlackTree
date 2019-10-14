/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stankiek
 */
public class Node implements Comparable<Node>{
    
    private int key;
    private char value;
    private Node left;
	private Node right;
	private Node up;
	private char color;

    public Node(int key, char value){

    	this.key = key;
    	this.value = value;
		this.color = 'b';
	}

	public boolean isRoot(){
    	if(up == null)
    		return true;
    	else
    		return false;
	}
	public boolean hasLeft(){
    	if(left == null)
    		return true;
    	else
    		return false;
	}

	public boolean hasRight(){
		if(right == null)
			return true;
		else
			return false;
	}

	@Override
	public int compareTo(Node o){
		return key - o.key;
	}

	public int getKey(){
    	return key;
    }

	public void setKey(int k){
    	this.key = k;
    }

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
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

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}
}
