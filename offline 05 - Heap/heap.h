#include<iostream>
#include<string>
#include<stdlib.h>
#include<vector>

using namespace std;

class Heap
{
    int* arr;
    int maxsize;
    int cnt;

    void swap(int& x, int& y)
    {
        int temp = x;
        x = y;
        y = temp;
    }


    bool isLeaf(int pos) const
    {
        return (pos >= cnt/2) && (pos < cnt);
    }
    int leftchild(int pos) const
    {
        return 2*pos + 1;
    }
    int rightchild(int pos) const
    {
        return 2*pos + 2;
    }
    int parent(int pos) const
    {
        return (pos-1)/2;
    }

    void maxHeapify(int i)
    {
        int l = leftchild(i);
        int r = rightchild(i);
        int largest = i;

        if (l<cnt && arr[l]>arr[i])
        {
            largest = l;
        }
        else
            largest = i;
        if(r<cnt && arr[r]>arr[largest])
        {
            largest = r;
        }
        if(largest != i)
        {
            swap(arr[i],arr[largest]);
            maxHeapify(largest);
        }

    }

    void buildHeap()
    {
        for (int i=cnt/2-1; i>=0; i--)
            maxHeapify(i);
    }

public:

    Heap(int n)
    {
        maxsize = n;
        arr = new int[maxsize];
        cnt = 0;
    }

    Heap(vector<int> &v)
    {
        cnt = 0;
        maxsize = v.size();
        arr = new int[maxsize];
        for(int x: v)
            arr [cnt++] = x;
        buildHeap();
    }

    ~Heap()
    {
        delete[] arr;
    }

    void insert(int item)
    {
        int curr = cnt++;
        arr[curr] = item;

        while ((curr!=0) && (arr[curr]>arr[parent(curr)]))
        {
            swap(arr[curr], arr[parent(curr)]);
            curr = parent(curr);
        }
    }

    int size()
    {
        return cnt;
    }

    int getMax()
    {
        if(cnt == 0)
            return -1;
        return arr[0];
    }

    int deleteKey()
    {
        swap(arr[0], arr[--cnt]);

        if (cnt != 0)
            maxHeapify(0);
        return arr[cnt];
    }
};

void heapsort(vector<int> &v)
{
    Heap heap(v);
    int n = 0;
    while(heap.size()>0)
    {
        v[n++] = heap.deleteKey();
    }
}
