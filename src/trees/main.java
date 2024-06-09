package trees;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        BInaryTree tree = new BInaryTree();
//        tree.populate(sc);
//        tree.prettydisplay();
//        tree.display();

//        BST tree = new BST();
////        int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10 };
//        int[] nums = {1,2,3,4,5,6,7,8,9};
////        tree.populateSorted(nums);
//        tree.populate(nums);
//        tree.display();
//        System.out.println(tree.balanced());


//        AVL tree = new AVL();
//
//        for(int i=0; i < 10; i++) {
//            tree.insert(i);
//        }
//        tree.display();
//        System.out.println(tree.height());


        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTrees tree = new SegmentTrees(arr);
         tree.display();

        System.out.println(tree.query(1, 6));
    }
    }





