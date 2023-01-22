#include <iostream>
using namespace std;

int main(){
    // 숫자를 10진수, 8진수, 16진수로 출력
    int a = 10;
    cout << "10진수 : "<< a << endl; // 10
    cout << oct;
    cout << "8진수 : "<< a << endl; // 12
    cout << hex;
    cout << "16진수 : "<< a << endl; // a

    // 포인터 리터럴 상수 : 널 포인터 표현을 위해 포인터를 0으로 초기화해왔으나,
    // c++11 부터는 nullptr 키워드 제공(포인터 타입이며, 정수형으로 변환불가)

    // 이진 리터럴 상수 (c++14부터)
    //auto a = 0B010111;
    // auto 키워드는 c++11 부터 변수 선언 시 초기값과 같은 타입으로 변수를 선언할
    // 수 있도록 해줌

    // 심볼릭 상수 : 선언과 동시에 반드시 초기화해야 함
    const int num = 10;

    // 타입 변환
    double res1 = 5+3.14; // 8.14 => 데이터 손실 최소화 위해 자동 타입 변환
    double res2 = 5.0f+3.14; // 8.14
    // char형 → short형 → int형 → long형 → float형 → double형 → long double형
    // 산술 연산 시 bool형 데이터인 true는 1로, false는 0으로 자동 타입 변환
    int num1 = 1; int num2 = 4;
    double re1 = num1/num2; // 0
    double re2 = (double)num1/num2; // 0.25
    double re3 = double(num1)/num2; // 0.25    
}
/**
 * 정수형 : int
 * 실수형 : float, double, long double
 * 문자형 : char
 * bool형 : bool
*/