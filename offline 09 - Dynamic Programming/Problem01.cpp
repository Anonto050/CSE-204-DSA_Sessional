#include<bits/stdc++.h>

using namespace std;

int max(int a, int b)
{
    if(a>=b)
        return a;
    else
        return b;
}

int lcs( char *X, char *Y,char *LCS, int m, int n )
{
int L[m+1][n+1];
int i, j;

for (i=0; i<=m; i++)
{
    for (j=0; j<=n; j++)
    {
    if (i == 0 || j == 0)
        L[i][j] = 0;

    else if (X[i-1] == Y[j-1])
        L[i][j] = L[i-1][j-1] + 1;

    else
        L[i][j] = max(L[i-1][j], L[i][j-1]);
    }
}

  int length = L[m][n];

  LCS[length] = '\0';

  i = m, j = n;
  while (i > 0 && j > 0)
  {
    if (X[i-1] == Y[j-1])
    {
      LCS[length-1] = X[i-1];
      i--;
      j--;
      length--;
    }

    else if (L[i-1][j] >= L[i][j-1])
      i--;
    else
      j--;
  }

return L[m][n];
}

int main()
{
char X[50],Y[50];
cin>>X>>Y;

char LCS[50];

int m = strlen(X);
int n = strlen(Y);

cout<<lcs( X, Y,LCS, m, n )<<endl;
cout<<LCS;

return 0;
}
