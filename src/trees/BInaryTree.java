package trees;

import java.util.Scanner;

public class BInaryTree {

    public BInaryTree(){

    }

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }
    private Node root;

    public  void populate(Scanner sc){
        System.out.println("Enter the value of root:");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc , root);
    }
    private void populate(Scanner sc , Node node){
        System.out.println("do you want enter left of : "+node.value);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("enter the value of left of : "+node.value);
            int value = sc.nextInt();
            node.left= new Node(value);
            populate(sc,node.left);
        }

        System.out.println("do you want enter right of : "+node.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("enter the value of right of : "+node.value);
            int value = sc.nextInt();
            node.right= new Node(value);
            populate(sc,node.right);
        }
    }

    public void display(){
        display(root,"");
    }

    private void display(Node node, String indent) {
        if(node==null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left , indent + "\t");
        display(node.right , indent + "\t");
    }

    public void prettydisplay(){
        prettydisplay(root , 0);
    }

    private void prettydisplay(Node node, int level) {
        if(node==null){
            return;
        }

        prettydisplay(node.right,level+1);

        if(level!=0){
            for(int i = 0 ;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|----->" + node.value);

        }
        else{
            System.out.println(node.value);
        }

        prettydisplay(node.left , level+1);
    }

//    pre - in - post order traversal
public void preOrder() {
    preOrder(root);
}

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        preOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.print(node.value + " ");
        preOrder(node.right);
    }

    public void postOrder() {
        preOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.value + " ");
    }

}
