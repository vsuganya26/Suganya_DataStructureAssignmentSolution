package com.gl.Driver;

import com.gl.Services.BSTConversionService;
import com.gl.Services.Node;

public class Main {
	
	public Node node;

    public static void main(String[] args) {

        Main bst = new Main();
        bst.node = new Node(50);
        bst.node.left = new Node(30);
        bst.node.right = new Node(60);
        bst.node.left.left = new Node(10);
        bst.node.left.right = new Node(40);

        System.out.println("Output (Right Skewed BST) : ");

        //Convert BST into right Skewed BST
        BSTConversionService.rightSkewedBST(bst.node);

        //Display Skewed Tree
        BSTConversionService.display(BSTConversionService.head);
    }

}
