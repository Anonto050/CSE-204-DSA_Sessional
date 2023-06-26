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
public class LList<E> implements list<E>{
    private Link<E> head;
    private Link<E> tail;
    protected Link<E> curr;
    private int cnt;

    LList() {
        curr = tail = head = new Link<E>(null);
        cnt = 0;
    }

    LList(int size,E[] items) {
        cnt = size;
        int i;
        head = curr = tail = new Link<E>(null);
        for(i=0;i<cnt;i++){
            tail = tail.setNext(new Link<E>(items[i],null));
        }
    }

    public void clear() {
        head.setNext(null);
        curr = tail = head = new Link<E>(null); // Create header
        cnt = 0;
    }

    public void insert(E it) {
        curr.setNext(new Link<E>(it, curr.next()));
        if (tail == curr) tail = curr.next();
        cnt++;
    }

    public void append(E it) {
        tail = tail.setNext(new Link<E>(it, null));
        cnt++;
    }

    public E remove() {
        if (curr.next() == null) return null;
        E it = curr.next().element();
        if (tail == curr.next()) tail = curr;
        curr.setNext(curr.next().next());
        cnt--;
        return it;
    }

    public void moveToStart() {
        curr = head;
    }

    public void moveToEnd() {
        //curr = tail;
        Link<E> temp = head;
        int i;
        for (i = 0; temp.next() != tail; i++)
            temp = temp.next();
        curr = temp;
    }

    /**
     * Move curr one step left; no change if now at front
     */
    public void prev() {
        if (curr == head) return;
        Link<E> temp = head;

        while (temp.next() != curr) temp = temp.next();
        curr = temp;
    }

    public void next() {
        if (curr.next() != tail) curr = curr.next();
    }

    public int length() {
        return cnt;
    }

    public int currPos() {
        Link<E> temp = head;
        int i;
        for (i = 0; curr != temp; i++)
            temp = temp.next();
        return i;
    }

    public void moveToPos(int pos) {
        assert (pos >= 0) && (pos <= cnt) : "Position out of range";
        curr = head;
        for (int i = 0; i < pos; i++) curr = curr.next();
    }

    public E getValue() {
        if (curr.next() == null) return null;
        return curr.next().element();
    }

    @Override
    public int Search(E item) {
        Link<E> temp = head;
        while(temp!=null){
            if(item==temp.element()){
                return 1;
            }
            temp = temp.next();
        }
        return -1;
    }
}

