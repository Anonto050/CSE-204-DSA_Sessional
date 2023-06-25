class BSTNode<E> implements BinNode<E> {
    private E element;
    private BSTNode<E> left;
    private BSTNode<E> right;

    public BSTNode() { left = right = null; }
    public BSTNode(E val)
    { left = right = null;element = val; }

    public BSTNode(E val,
                   BSTNode<E> l, BSTNode<E> r)
    { left = l; right = r; element = val; }

    public E element() { return element; }
    public void setElement(E v) { element = v; }

    public BSTNode<E> left() { return left; }
    public void setLeft(BSTNode<E> p) { left = p; }

    public BSTNode<E> right() { return right; }
    public void setRight(BSTNode<E> p) { right = p; }

    public boolean isLeaf()
    { return (left == null) && (right == null); }
}

