#include<bits/stdc++.h>

using namespace std;

int count_minStrokes(int a[],int l,int r,int h){
 if(l>=r)
    return 0;

 int m = l;
 for(int i=l;i<r;i++)
    if(a[i]<a[m])
        m = i;

 return min(r-l,count_minStrokes(a,l,m,a[m])+count_minStrokes(a,m+1,r,a[m])+a[m]-h);
}

int minStrokes(int a[],int n){
   return count_minStrokes(a,0,n,0);
}

int main(){
int n;
cin>>n;
int a[n];

for(int i=0;i<n;i++){
    cin>>a[i];
}
cout<<minStrokes(a,n)<<endl;
}
