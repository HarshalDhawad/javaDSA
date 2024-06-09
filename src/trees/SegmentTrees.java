package trees;

public class SegmentTrees {


    public class Node{
        Node left;
        Node right;
        int data;
        int startInterval;
        int endInterval;

        public Node(int startInterval , int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }


    }
    Node root;

    //creation of segment tree

    public SegmentTrees(int[] arr){
        this.root = constructTree(arr , 0 , arr.length-1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if(start == end ){
            Node leaf = new Node(start ,end);
            leaf.data = arr[start];
            return leaf;
        }
        Node node = new Node(start,end);

        int mid = (start + end)/2;

        node.left = this.constructTree(arr , start , mid);
        node.right = this.constructTree(arr , mid+1 , end);

        node.data = node.left.data + node.right.data;
        return node;

    }

//    display of tree
    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str = "";

        if(node.left!=null){
            str += "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " =>";
        }
        else{
            str+="no left child";
        }

//        for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

        if(node.right!=null){
            str += "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data + " =>";
        }
        else{
            str+="no right child";
        }

        System.out.println(str + "\n");

//        recursion call

        if(node.left!=null){
            display(node.left);
        }
        if(node.right!=null){
            display(node.right);
        }
    }

    //query

    public int query(int qstart , int qend){
        return this.query(root ,qstart,qend );
    }

    private int query(Node node , int qstart , int qend){
        if(node.startInterval >= qstart && node.endInterval <=qend){
            //completly inside
            return node.data;
        }
        else if(node.startInterval > qend || node.endInterval< qstart){
            //completly outside
            return 0;
        }
        else{
//            partially inside
            return this.query(node.left , qstart,qend) + this.query(node.right,qstart,qend);
        }
    }

    //update

    public void update(int index,int value){
        this.root.data = update(this.root,index,value);
    }
    private int update(Node node , int index,int value){
        if(index>=node.startInterval && index<=node.endInterval){
            if(index==node.startInterval && index==node.endInterval){
                node.data = value ;
                return node.data;
            }
            else{
                int leftans = update(node.left , index,value);
                int rightans = update(node.right , index,value);
                node.data = leftans + rightans;
                return node.data;
            }
        }
        else{
            return node.data;
        }
    }

}
