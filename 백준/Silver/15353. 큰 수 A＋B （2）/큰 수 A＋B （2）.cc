#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

// 큰 수 덧셈 함수
string addBigNumbers(const string& A, const string& B) {
    string result = "";
    int carry = 0;
    int lenA = A.size(), lenB = B.size();

    // 두 숫자를 오른쪽부터 왼쪽으로 한 자리씩 더함
    for (int i = 0; i < max(lenA, lenB); i++) {
        int digitA = (i < lenA) ? A[lenA - 1 - i] - '0' : 0;
        int digitB = (i < lenB) ? B[lenB - 1 - i] - '0' : 0;
        
        int sum = digitA + digitB + carry;
        carry = sum / 10;
        result += (sum % 10) + '0';
    }

    // 마지막 자리에서 올림수가 있는 경우 추가
    if (carry) {
        result += carry + '0';
    }

    // 결과를 뒤집어 원래 순서로 만들어줌
    reverse(result.begin(), result.end());
    return result;
}

int main() {
    string A, B;
    cin >> A >> B;

    string sum = addBigNumbers(A, B);
    cout << sum << endl;

    return 0;
}

