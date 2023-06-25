#include <bits/stdc++.h>
using namespace std;

int assignHole(int mices[], int holes[],
			int n, int m)
{
	if (n != m)
		return -1;

	// Sort the arrays
	sort(mices, mices + n);
	sort(holes, holes + m);

	// Finding max difference between
	// ith mice and hole
	int max = 0;
	for(int i = 0; i < n; ++i)
	{
		if (max < abs(mices[i] - holes[i]))
			max = abs(mices[i] - holes[i]);
	}
	return max;
}

int main()
{

	// Position of mouses
	int mices[] = { 4, -4, 2 };

	// Position of holes
	int holes[] = { 4, 0, 5 };

	// Number of mouses
	int n = sizeof(mices) / sizeof(mices[0]);

	// Number of holes
	int m = sizeof(holes) / sizeof(holes[0]);

	// The required answer is returned
	// from the function
	int minTime = assignHole(mices, holes, n, m);

	cout << "The last mouse gets into the hole in time:"
		<< minTime << endl;

	return 0;
}

