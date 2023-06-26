class AQueue<E> implements Queue<E> {
    private static final int defaultSize = 10;
    private int maxSize; // Maximum size of queue
    private int front; // Index of front element
    private int rear; // Index of rear element
    private E[] listArray; // Array holding queue elements


    AQueue() {
        this(defaultSize);
    }

    @SuppressWarnings("unchecked")
        // For generic array
    AQueue(int size) {
        maxSize = size + 1; // One extra space is allocated
        rear = 0;
        front = 1;
        listArray = (E[]) new Object[maxSize]; // Create listArray
    }

    AQueue(E[] items){
        maxSize = items.length;
        rear = 0;
        front = 1;
        listArray = (E[]) new Object[maxSize];
        listArray = items;
    }

    public void resize(E[] items){
        maxSize = 2*(maxSize-1)+1;
        E[] tempArray = (E[])new Object[maxSize];
        for(int i=0;i< items.length;i++)
            tempArray[i] = items[i];
        listArray = (E[])new Object[maxSize];
        listArray = tempArray;
    }

    public void clear() {
        rear = 0;
        front = 1;
    }

    public void enqueue(E it) {
        if(length()==maxSize-1)
        {
            resize(listArray);
        }
        assert ((rear + 2) % maxSize) != front : "Queue is full";
        if(length()==0)
        {
            rear=0;
            front =1;
        }
        rear = (rear + 1) % maxSize; // Circular increment
        listArray[rear] = it;
    }

    public E dequeue() {
        assert length() != 0 : "Queue is empty";
        E it = listArray[front];
        front = (front + 1) % maxSize; // Circular increment
        return it;
    }

    public E frontValue() {
        assert length() != 0 : "Queue is empty";
        return listArray[front];
    }

    public int length() {
        return ((rear + maxSize) - front + 1) % maxSize;
    }

    @Override
    public E rearValue() {
        if(rear==front-1)
            return null;
        return listArray[rear];
    }

    @Override
    public E leaveQueue() {
        if(rear==front-1)
            return null;
        E it = listArray[rear];
        rear = (rear-1)%maxSize;
        return it;
    }
    public void reverse(AQueue q){
        AQueue q2 = new AQueue();
        if(q.length()==0)
            return ;
        E it = (E) q.dequeue();
        reverse(q);
        q2.enqueue(it);
        System.out.print(it+" ");
    }
}
