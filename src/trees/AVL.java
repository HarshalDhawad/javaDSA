package trees;

import java.util.Scanner;

public class AVL {
    public AVL(){}

    public class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
    private Node root;

    //    inserted value
    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

//    insert sorted array

    public void populateSorted(int[] nums){
        populateSorted(nums,0,nums.length);
    }
    private void populateSorted(int[] nums , int start , int end){
        if (start >= end) {
            return;
        }
        int mid= (start+end)/2;
        insert(nums[mid]);
        populateSorted(nums , start , mid);
        populateSorted(nums, mid+1,end);
    }

//Insertions

    public void insert(int value){
        root = insert(value , root);
    }

    private Node insert(int value , Node node){
        if(node==null){
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left) , height(node.right))+1;
        return rotate(node);
    }

    private Node rotate(Node node){
//        left-heavy
        if(height(node.left) - height(node.right) > 1 ){
//            left-left-case
            if(height(node.left.left) - height(node.left.right) > 0){
                return rotateright(node);
            }
//            left-right-case
            if(height(node.left.left) - height(node.left.right) < 0){
               node.left =  rotateleft(node);
               return rotateright(node);
            }
        }
//      right-heavy
        if(height(node.left) - height(node.right) < -1 ){
//            right-right-case
            if(height(node.right.left) - height(node.right.right) < 0){
                return rotateleft(node);
            }
//            right-left-case
            if (height(node.left.left) - height(node.left.right) < 0){
                node.right = rotateright(node);
                return rotateleft(node);
            }
        }

        return node;
    }

    private Node rotateright(Node p) {
        Node  c = p.left;
        Node t = c.right;

         c.right = p;
         p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }

    private Node rotateleft(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;
    }
    public int height() {
        return height(root);
    }
    private int height(Node node) {
        if(node==null){
            return -1;
        }
        return node.height;
    }
//display

    public void display(){
        display(root , "root node : ");
    }

    private void display(Node node, String details) {
        if(node == null){
            return ;
        }
        System.out.println(details + node.value);
        display(node.left , "left child of" + node.value + " : ");
        display(node.right , "right child of" + node.value + " : ");
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
}
