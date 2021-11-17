package com.gdstruc.module7;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Tree tree = new Tree();

        tree.insert(25);
        tree.insert(9);
        tree.insert(78);
        tree.insert(5);
        tree.insert(-21);
        tree.insert(-55);
        tree.insert(1);

        tree.traverseInOrder();
        System.out.println(tree.get(78));

        tree.getMin();
        tree.getMax();

        tree.traverseInOrderDescending();
    }
}
