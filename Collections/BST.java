class BST {
    class Node {
        private Node left;
        private Node right;
        int data;
        int size;
        int height;
        public Node (int data) {
            this.data = data;
            left = right = null;
            size = height = 1;
        }
    }
    Node root;
    BST() {
        root = null;
    }
    public int size() {
        return size(root);
    }
    private int size (Node r) {
        if(r == null) return 0;
        else return r.size;
    }
    public int rank(int val) {
        int t = rank(root,val);
        if(t==-1) System.out.print("not found ");
        return t;
    }
    private int rank(Node r,int val) {
        if(r == null) return -1;
        if(val == r.data) {
            return 1 + size(r.left);
        }
        if(val < r.data) return rank(r.left,val);
        else if( val > r.data) {
            int t = rank(r.right,val);
            if(t == -1) return t;
            else return 1 + t + size(r.left);
        }
        return -1;
    }
    public void inorder() {
        inorder(root);
    }
    private void inorder(Node head) {
        if(head == null) return;
        inorder(head.left);
        System.out.println(head.data);
        inorder(head.right);
    }
    public int hight() {
        return hight(root);
    }
    private int hight(Node r) {
        if(r==null) return 0; 
        return r.height;
    }
    public void insert(int key) {
        root = insert(root,key);
    }
    private Node insert (Node r,int key) {
        if(r==null) {
            return new Node(key);
        }
        if(key<r.data) {
            r.left = insert(r.left,key);
        }
        else if(key > r.data) {
            r.right = insert(r.right,key);
        }
        else return r;
        r.size++; 
        r.height = 1 + Math.max(hight(r.left),hight(r.right));
        r = avlBalance(r);
        return r;
    }
    private Node avlBalance(Node root) {
        int balance = hight(root.left) - hight(root.right);
        if(balance > 1) {
            if( hight(root.left.left) - hight(root.left.right) < 0) root.left = leftRotate(root.left);
            root = rightRotate(root);
        }
        else if(balance < -1) {
            if( hight(root.right.right) - hight(root.right.left) < 0) root.right = rightRotate(root.right);
            root = leftRotate(root);
        }
        return root;
    }
    private Node leftRotate(Node root) {
        Node temp = root;
        root = root.right;
        temp.right = root.left;
        root.left = temp;
        root.left.height = 1 + Math.max( hight(root.left.left), hight(root.left.right));
        root.left.size = 1 + size(root.left.left) + size(root.left.right);
        root.height = 1 + Math.max( hight(root.left), hight(root.right));
        root.size = 1 + size(root.left) + size(root.right);
        return root;
    }
    private Node rightRotate(Node root) {
        Node temp = root;
        root = root.left;
        temp.left = root.right;
        root.right = temp;
        root.right.height = 1 + Math.max( hight(root.right.left), hight(root.right.right));
        root.right.size = 1 + size(root.right.left) + size(root.right.right);
        root.height = 1 + Math.max( hight(root.left), hight(root.right));
        root.size = 1 + size(root.left) + size(root.right);
        return root;
    }
    public void convToLL() {
        root = convToLL(root);
    }
    private Node convToLL(Node n) {
        if(n.left == null) {
            return n;
        }
        convToLL(n.left);
        return n;
    }
    public static void main(String[] args) {
        BST head = new BST();
        head.insert(5);
        head.insert(1);
        head.insert(4);
        head.insert(6);
        head.insert(2);
        head.insert(3);
        head.inorder();
        System.out.println("size = " + head.size());
        System.out.println("height = " + head.hight());
        System.out.println(head.rank(1));
        System.out.println(head.rank(2));
        System.out.println(head.rank(3));
        System.out.println(head.rank(4));
        System.out.println(head.rank(5));
        System.out.println(head.rank(6));
        System.out.println(head.rank(7));
    }
}
