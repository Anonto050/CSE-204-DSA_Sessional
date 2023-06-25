#include <bits/stdc++.h>
#include<cctype>
using namespace std;

long long int cnt;
long long int a[200005];

void Merge(long long int a[],long long int l,long long int m,long long int r)
{
    long long int p[r-l+1];
    long long int k=0,i,j;
    i=l;
    j=m+1;
    while(k<(r-l+1))
    {
        if(i<=m&&j<=r)
        {
            if(a[i]<=a[j])
            {
                p[k]=a[i];
                i++;
            }
            else
            {
                p[k]=a[j];
                cnt=cnt+m-i+1;
                j++;
            }
        }
        else if(i<=m)
        {
            p[k]=a[i];
            i++;

        }
        else
        {
            p[k]=a[j];
            j++;
        }
        k++;

    }
    for(k=0; k<r-l+1; k++)
        a[l+k]=p[k];

}

void mergesort(long long int a[],long long int l,long long int r)
{
    if(l<r)
    {
        long long int m=(l+r)/2;
        mergesort(a,l,m);
        mergesort(a,m+1,r);
        Merge(a,l,m,r);
    }
}


int main()
{
    long long int t;
    cin>>t;
    while(t--)
    {
        long long int i;
        long long int n;
        cin>>n;
        cnt = 0;
        for(i=0; i<n; i++)
        {
            cin>>a[i];
        }

        mergesort(a,0, n-1);

        cout<<cnt<<endl;
    }
    return 0;
}


