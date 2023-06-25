public class ArrList<E> implements list<E>{
        private int maxSize; // Maximum size of list
        private int listSize; // Current # of list items
        private int chunk_size;
        private int curr; // Position of current element
        private E[] listArray; // Array holding list elements

       ArrList(int size) {
           maxSize=size;
           chunk_size = size;
           listSize=0;
           curr=0;
           listArray = (E[])new Object[size];
       }

        @SuppressWarnings("unchecked") // Generic array allocation
        ArrList(int length,int size,E[] items) {
            maxSize = size;
            chunk_size =size;
            listSize = length;
            curr = 0;
            listArray = (E[])new Object[size];
            listArray = items;
        }

        public void resize(E[] items){
           maxSize = maxSize + chunk_size;
            E[] tempArray = (E[])new Object[maxSize];
            //tempArray = items;
            for(int i=0;i< listSize;i++)
                tempArray[i] = items[i];
            listArray = (E[])new Object[maxSize];
            listArray = tempArray;
        }

        public void clear()
        { listSize = curr = 0; }

        public void insert(E it) {
            if(listSize>=maxSize){
                resize(listArray);
            }
            for (int i=listSize; i>curr; i--)
                listArray[i] = listArray[i-1];
            listArray[curr] = it;
            listSize++;
        }

        public void append(E it) {
            if(listSize>=maxSize){
                resize(listArray);
            }
            listArray[listSize++] = it;
        }

        public E remove() {
            if ((curr<0) || (curr>=listSize))
                return null;
            E it = listArray[curr]; // Copy the element
            for(int i=curr; i<listSize-1; i++)
                listArray[i] = listArray[i+1];
            listSize--;
            return it;
        }
        public void moveToStart() { curr = 0; }
        public void moveToEnd() { curr = listSize-1; }
        public void prev() { if (curr != 0) curr--; }
        public void next() { if (curr < listSize) curr++; }
        public int length() { return listSize; }
        public int currPos() { return curr; }
        public void moveToPos(int pos) {
            assert (pos>=0) && (pos<=listSize) : "Pos out of range";
            curr = pos;
        }

        public E getValue() {
            assert (curr>=0) && (curr<listSize) :
                    "No current element";
            return listArray[curr];
        }

    @Override
    public int Search(E item) {
        if ((curr<0) || (curr>=listSize))
            return -1;
        for(int i=0; i<listSize; i++) {
            if (item == listArray[i])
                return 1;
        }
            return -1;
    }

}
