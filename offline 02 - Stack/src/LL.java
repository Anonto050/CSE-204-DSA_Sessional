class Link<E> {
    private E element;
    private Link<E> next;

    Link(E it, Link<E> nextval)
    { element = it; next = nextval; }
    Link(Link<E> nextval) { next = nextval; }
    Link<E> next() { return next; }
    Link<E> setNext(Link<E> nextval)
    { return next = nextval; }
    E element() { return element; }
    E setElement(E it) { return element = it; }
}

class LL<E> implements Stack<E> {
    private Link<E> top; // Pointer to first element
    private int size; // Number of elements

    public LL() {
        top = null;
        size = 0;
    }

    public LL(int size) {
        top = null;
        size = 0;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public void push(E it) {
        top = new Link<E>(it, top);
        size++;
    }

    public E pop() {
        assert top != null : "Stack is empty";
        E it = top.element();
        top = top.next();
        size--;
        return it;
    }

    public E topValue() {
        assert top != null : "Stack is empty";
        return top.element();
    }

    @Override
    public void setDirection(int direction) {
        System.out.println("No use");
    }

    public int length() {
        return size;
    }
}
