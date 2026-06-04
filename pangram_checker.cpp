#include <iostream>
#include <string>
using namespace std;
int main() {
  string str;
  cin >> str;
  int flag = 0;
  for (char ch : str) {
      flag |= (1 << (ch - 'A'));
  }
if (flag == (1 << 26) - 1)
    cout << "Contains all letters";
else
    cout << "Does not contains all letters";
return 0;
}
