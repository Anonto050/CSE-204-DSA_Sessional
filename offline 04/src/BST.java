class BST<E extends Comparable> {
    private BSTNode<E> root;
    private int nodecount;

    BST() { root = null; nodecount = 0; }

    public BSTNode<E> getRoot() {
        return root;
    }

    public void clear() { root = null; nodecount = 0; }

    /**Insert*/
    public void insert(E e) {
        root = inserthelp(root, e);
        nodecount++;
        printhelp(root);
    }
    private BSTNode<E> inserthelp(BSTNode<E> rt,E e) {
        if (rt == null) return new BSTNode<E>(e);
        if (rt.element().compareTo(e) > 0)
            rt.setLeft(inserthelp(rt.left(), e));
        else
            rt.setRight(inserthelp(rt.right(), e));
        return rt;
    }

    /**Remove*/

    private BSTNode<E> getmax(BSTNode<E> rt) {
        if (rt.right() == null) return rt;
        return getmax(rt.right());
    }
    private BSTNode<E> deletemax(BSTNode<E> rt) {
        if (rt.right() == null) return rt.left();
        rt.setRight(deletemax(rt.right()));
        return rt;
    }
    private BSTNode<E> deletehelp(BSTNode<E> rt,E k) {
        if (rt == null) return null;
        if (rt.element().compareTo(k) > 0)
            rt.setLeft(deletehelp(rt.left(), k));
        else if (rt.element().compareTo(k) < 0)
            rt.setRight(deletehelp(rt.right(), k));
        else {
            if (rt.left() == null) return rt.right();
            else if (rt.right() == null) return rt.left();
            else {
                BSTNode<E> temp = getmax(rt.left());
                rt.setElement(temp.element());
                rt.setLeft(deletemax(rt.left()));
            }
        }
        return rt;
    }

    public void delete(E k) {
        E temp = findhelp(root, k); // First find it
        if (temp != null) {
            root = deletehelp(root, k); // Now remove it
            nodecount--;
            printhelp(root);
        }
        else{
            System.out.print("Invalid Operation");
        }
    }

    public E deleteAny() {
        if (root == null) return null;
        E temp = root.element();
        root = deletehelp(root, root.element());
        nodecount--;
        return temp;
    }

    /**Find*/

    private E findhelp(BSTNode<E> rt,E k) {
        if (rt == null) return null;
        if (rt.element().compareTo(k) > 0)
            return findhelp(rt.left(), k);
        else if (rt.element().compareTo(k) == 0) return rt.element();
        else return findhelp(rt.right(), k);
    }

    public boolean find(E k) {
        if(findhelp(root,k) == null)
            return false;
        return true;
    }

    private void printhelp(BSTNode<E> rt) {
        if (rt == null) return;
        if(rt.isLeaf()){
            System.out.print(rt.element());
        }
        else {
            System.out.print(rt.element());

            System.out.print("(");
            printhelp(rt.left());
            System.out.print(")");

            System.out.print("(");
            printhelp(rt.right());
            System.out.print(")");
        }
    }


    public int size() { return nodecount; }

    /**Traversals*/

    public void preorderhelp(BinNode rt)
    {
        if (rt == null) return;
        System.out.print(rt.element()+" ");
        preorderhelp(rt.left());
        preorderhelp(rt.right());
    }
    public void preorder(){
        preorderhelp(root);
    }

    public void postorderhelp(BinNode rt)
    {
        if (rt == null) return;

        postorderhelp(rt.left());
        postorderhelp(rt.right());
        System.out.print(rt.element()+" ");
    }
    public void postorder(){
        postorderhelp(root);
    }

    public void inorderhelp(BinNode rt)
    {
        if (rt == null) return;

        inorderhelp(rt.left());
        System.out.print(rt.element()+" ");
        inorderhelp(rt.right());
    }
    public void inorder(){
        inorderhelp(root);
    }

}
