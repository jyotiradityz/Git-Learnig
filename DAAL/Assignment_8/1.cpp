#include <iostream>
using namespace std;

int main() {
    const int maxSize = 100; 
    int numbers[maxSize];
    int num;
    int count = 0;
    int index = 0;
    while (true) {
        cin >> num;
        if (num == -1) {
            break;
        }
        numbers[index] = num;
        index++;
    }

    for (int i = 0; i < index; i++) {
        if (numbers[i] % 6 == 0) {
            count++;
        }
    }

    cout  << count << endl;

return 0;
}
