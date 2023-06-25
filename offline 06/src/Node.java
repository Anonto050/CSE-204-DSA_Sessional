public class Node
{
    int vertice;
    int distance;
    int [] parent;
    Node(int n)
    {
        parent= new int[n];
    }
    int getVertice()
    {
        return vertice;
    }
    int getDistance()
    {
        return distance;
    }
    int getParent(int x)
    {
        return parent[x];
    }
    void setVertice(int vertice)
    {
        this.vertice = vertice;
    }
    void setDistance(int distance)
    {
        this.distance=distance;
    }
    void setParent(int vertice,int index) {
        this.parent[index] = vertice;
    }
}
