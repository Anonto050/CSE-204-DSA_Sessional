class Arr<E> implements Stack<E> {
    private int maxSize; // Maximum size of stack
    private int top; // Index for top Object
    private E[] listArray; // Array holding stack
    private int direction;
    private int length;

    Arr(int size) {
        maxSize = size;
        top = 0;
        direction = 1;
        listArray = (E[]) new Object[size];
    }

    @SuppressWarnings("unchecked")
        // Generic array allocation
    Arr(E[] items,int direction) {

        maxSize = items.length;
        if(direction==-1) {
            top = maxSize;
            length = 0;
        }
        else
            top = 0;
        this.direction = direction;
        listArray = (E[]) new Object[maxSize];
        listArray = items;
    }


    public void resize(E[] items){
        maxSize = 2*maxSize;
        E[] tempArray = (E[])new Object[maxSize];
        for(int i=0;i< items.length;i++)
            tempArray[i] = items[i];
        listArray = (E[])new Object[maxSize];
        listArray = tempArray;
    }

    public void clear() {
        if(direction==1) {
            top = 0;
        }
        else{
            length = 0;
        }
    }

    public void push(E it) {
        if(direction==1) {
            if(top >= maxSize) {
                resize(listArray);
            }
            listArray[top++] = it;
        }
        else{

            if(top==0){
                resize(listArray);
                top++;
                for(int i = length;i>0;i--)
                    listArray[i] = listArray[i-1];
            }
            listArray[--top]=it;
            length++;
        }
    }

    public E pop() {
        if(direction==1) {
            assert top != 0 : "Stack is empty";
            return listArray[--top];
        }
        else{
            top++;
            length--;
            return listArray[top-1];
        }
    }

    public E topValue() {
        if(direction==1) {
            assert top != 0 : "Stack is empty";
            return listArray[top - 1];
        }
        else{
            return listArray[top];
        }
    }

    @Override
    public void setDirection(int direction) {
           this.direction = direction;
           if(direction==-1) {
               top = maxSize;
               length = 0;
           }
    }

    public int length() {
        if(direction==1) {
            return top;
        }
        else{
            return length;
        }
    }
}
