#include<bits/stdc++.h>
#include<algorithm>

using namespace std;

int edit_distance(string X,string Y,int m,int n){
 int dp[m+1][n+1];
 int i,j;

 for(i=0;i<=m;i++){
    for(j=0;j<=n;j++){
        if(i==0){
            dp[i][j] = j;
        }
        else if(j==0){
             dp[i][j] = i;
        }
        else if(X[i-1]==Y[j-1]){
            dp[i][j] = dp[i-1][j-1];
        }
        else
        {
            dp[i][j] = 1 + min({dp[i-1][j],dp[i][j-1],dp[i-1][j-1]});
        }
    }
 }
 return dp[m][n];
}

int main(){
 int t;
 cin>>t;

while(t!=0){
 string X,Y;

 getline(cin>>ws,X);
 getline(cin,Y);

 int m = X.length();
 int n = Y.length();

 cout<<edit_distance(X,Y,m,n)<<endl;
 t--;
}

 return 0;
}


