#include<bits/stdc++.h>

using namespace std;

int cost[11][11];
int dp[11][(1<<11)];

int costFunc(int j,int mask,int& n)
{
    int totalCost = cost[j][j];

    for(int k = 0; k < n; k++)
    {

        if((mask & (1<<k)) == 0 && (k != j))
        {
            totalCost = totalCost + cost[j][k];
        }
    }

    return totalCost;
}

int visit(int i, int mask, int& n)
{
    if(i == n)
        return 0;

    if(dp[i][mask] != -1)
        return dp[i][mask];

    int answer = INT_MAX;
    int totalCost;

    for(int j = 0; j < n; j++)
    {
        if(mask&(1<<j))
        {
            totalCost = costFunc(j,mask,n);

            answer = min(answer, totalCost + visit(i+1, (mask^(1<<j)), n));
        }
    }

    return dp[i][mask] = answer;
}

int main()
{

    int t,n,m,x,i,j,k,q;

    memset(dp, -1, sizeof dp);

    cin >> n;
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
            cin >> cost[i][j];
    }
    cout << visit(0, (1<<n) - 1, n) << '\n';

    /*for(int x = 0; x < n; x++){
        for(int y =0; y<(1<<n); y++)
            cout<<dp[x][y]<<"  ";
        cout<<endl;
    }*/

    return 0;
}
