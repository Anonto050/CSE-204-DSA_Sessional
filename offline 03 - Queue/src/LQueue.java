class Link<E>{
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

class LQueue<E> implements Queue<E> {
    private Link<E> front; // Pointer to front queue node
    private Link<E> rear; // Pointer to rear queue node
    private int size; // Number of elements in queue

    public LQueue() {
        init();
    }

    public LQueue(int size) {
        init();
    } // Ignore size

    private void init() {
        front = rear = new Link<E>(null);
        size = 0;
    }

    public void clear() {
        init();
    }

    public void enqueue(E it) {
        rear.setNext(new Link<E>(it, null));
        rear = rear.next();
        size++;
    }

    public E dequeue() {
        assert size != 0 : "Queue is empty";
        E it = front.next().element(); // Store dequeued value
        front.setNext(front.next().next()); // Advance front
        if (front.next() == null) rear = front; // Last Object
        size--;
        return it; // Return Object
    }

    public E frontValue() {
        assert size != 0 : "Queue is empty";
        return front.next().element();
    }

    public int length() {
        return size;
    }

    @Override
    public E rearValue() {
        return rear.element();
    }

    @Override
    public E leaveQueue() {
        Link temp = front;
        while(temp.next()!=rear){
            temp = temp.next();
        }
        E it = rear.element();
        rear = temp;
        rear.setNext(null);
        size--;
        return it;
    }
}