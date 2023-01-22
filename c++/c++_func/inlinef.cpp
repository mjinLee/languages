#include<iostream>
using namespace std;
/**
 * - C++에서의 함수 호출 과정 : 함수가 호출되면 우선 스택에 함수로 전달할 매개변수와 함께
 *  호출이 끝난 뒤 돌아갈 반환 주소값을 저장 -> 프로그램의 제어가 함수의 위치로 넘어와 
 *  함수 내에 선언된 지역 변수도 스택에 저장 -> 함수의 모든 코드를 실행하게 되고, 실행이
 *  전부 끝나면 반환값을 넘겨 줌 -> 프로그램의 제어는 스택에 저장된 돌아갈 반환 주소값으로
 *  이동하여, 스택에 저장된 함수 호출 정보를 제거
 * - 인라인 함수(inline function) : 호출될 때 일반적인 함수의 호출 과정을 거치지 않고,
 *  함수의 모든 코드를 호출된 자리에 바로 삽입하는 방식; 이 방식은 함수를 호출하는 데
 *  걸리는 시간은 절약되나, 함수 호출 과정으로 생기는 여러 이점을 포기하게 됨; 따라서 
 *  코드가 매우 적은 함수만을 인라인 함수로 선언하는 것이 좋음
 * - 인라인 함수의 선언 : inline 키워드는 함수의 원형이나 함수의 정의 어느 한 쪽에만 표기
 *  해도 되며, 양쪽 다 표기해도 상관없음
 *      inline 함수의원형 | inline 함수의정의
 * - 인라인 함수에서는 재귀 호출이 허용되지 않음
*/
/*inline int Sub(int x, int y) { return x - y; }
inline void Print(int x) { cout << "계산 결과 : " << x <<endl; }

int main(void){
    int num1 = 5, num2 = 3;
    int result;
    result = Sub(num1, num2);
    Print(result);
    return 0;
}*/

int main(void){
    int num1 = 5, num2 = 3;
    int result;
    {
        int x = num1, y = num2;
        result = x - y;
    }
    {
        int x = result;
        cout << "계산 결과 : " << x <<endl;
    }
    return 0;
}