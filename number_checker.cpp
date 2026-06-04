#include <iostream>
#include <string>
using namespace std;
int main() {
  string str;
  cin >> str;
  int flag = 0;
  for (char ch : str) {
      flag |= (1 << (ch - '1'));
  }
if (flag == (1 << 26) - 1)
    cout << "Contains all numbers";
else
    cout << "Does not contains all numbers";
return 0;
}
