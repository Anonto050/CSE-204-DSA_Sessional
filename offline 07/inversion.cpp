#include<bits/stdc++.h>

using namespace std;


long long int getInvCount(long long int arr[], long long int n)
{
    long long int inv_count = 0;
    for (long long int i = 0; i < n - 1; i++)
        for (long long int j = i + 1; j < n; j++)
            if (arr[i] > arr[j])
                inv_count++;

    return inv_count;
}

main()
{
    long long int t;
    cin>>t;
    cin>>ws;
    while(t--)
    {
        long long int i;
        long long int arr[200000];
        long long int n;
        cin>>n;
        cin>>ws;

        for(i=0; i<n; i++)
        {
            string x;
            getline(cin,x);
            if(x.empty()){
                break;
            }
            else{
            arr[i] = stoi(x);
            }
        }
        //int n = sizeof(arr) / sizeof(arr[0]);

        long long int ans = getInvCount(arr, n);

        cout <<ans<< endl;
    }
    return 0;
}
