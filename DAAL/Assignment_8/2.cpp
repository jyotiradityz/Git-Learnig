#include <bits/stdc++.h>
#define ll long long int
using namespace std;
int main()
{
   int n = 0;
   int sum = 0;
   while(n != -1){
	   cin>>n;
	   if(n < 100 && n >= 0){
	   	sum += n;
	   }else{
	   	if(sum)cout<<sum<<"\n";
	   	sum = 0;
	   	if(n != -1) cout<<n<<"\n";
	   }
   }	
   if(sum)cout<<sum<<"\n";
 return 0;
}