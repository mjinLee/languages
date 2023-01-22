#include<iostream>
using namespace std;
/**
 * - 매크로 함수(macro function) : 인라인 함수와 비슷한 기능
 * - #define 선행처리 지시문에 인수로 함수의 정의를 전달함으로써, 함수처럼 동작하는
 * 매크로를 만들 수 있음; 이러한 매크로를 함수 같은 매크로 또는 매크로 함수라고 함 
 * - 매크로 함수는 일반 함수와는 달리 단순 치환만 해주므로, 일반 함수와 똑같은 방식으로
 * 동작하지 않음; 매크로 함수를 일반 함수처럼 사용하기 위해서는 모든 인수를 괄호로 감싸야 함
 * - C++의 인라인 함수는 단순 치환이 아닌 함수의 모든 코드를 호출된 자리에 인라인 코드로
 *  삽입해 주는 것; 따라서 일반 함수처럼 값이나 수식을 인수로 전달할 수 있으며, 매개변수
 *  타입에 맞춘 자동 타입 변환도 지원
*/
/*#include <stdio.h>
#define SQR(X) ((X)*(X))

int main(void){
    int result;
    int x = 5;
    puts(SQR(10));
    puts(SQR(x));
    puts(SQR(x+3));
    return 0;
}*/
// 매크로 함수 예제를 인라인 함수로 작성
inline int Sqr(int x) { return x * x; } 

int main(void){
    int result;
    int x = 5;
    cout << "계산 결과 : " << Sqr(10) << endl;
    cout << "계산 결과 : " << Sqr(x) << endl;
    cout << "계산 결과 : " << Sqr(x+3) << endl;
    return 0;
}