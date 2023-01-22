#include<iostream>
using namespace std;
/**
 * - function overloading : 디폴트 인수가 인수의 개수를 달리하여 같은 함수를 호출하는
 * 것이라면, 함수 오버로딩은 같은 이름의 함수를 중복하여 정의하는 거; 여러 함수를 하나의
 * 이름으로 연결해줌; 즉, 함수 오버로딩이란 같은 일을 처리하는 함수를 매개변수의 형식을 
 * 달리하여, 하나의 이름으로 작성할 수 있게 해주는 것; 이와 같은 함수 오버로딩은 객체
 * 지향 프로그래밍의 특징 중 다형성의 구현.
 * - 함수 시그니처 : 함수의 원형에 명시되는 매개변수 리스트; 만약 두 함수가 매개변수의
 * 개수와 그 타입이 모두 같다면, 이 두 함수의 시그니처는 같다고 할 수 있음; 즉, 함수의
 * 오버로딩은 서로 다른 시그니처를 갖는 여러 함수를 같은 이름으로 정의하는 것
 * - 함수 오버로딩의 예제 : C++ 컴파일러는 사용자가 오버로딩된 함수를 호출하면, 그것과 
 * 같은 시그니처를 가지는 함수의 원형을 찾아 호출
 *  - 함수의 원형 예제
 *   1 void Display(const char* str, int n); // 문자열 str을 n번 출력
 *   2 void Display(const char* str1, const char* str2); // 문자열 str1과 str2를 연달아 출력
 *   3 void Display(int x, int y); // x * y를 출력
 *   4 void Display(double x, double y); // x / y를 출력
 *   - 사용자가 Display() 함수를 호출하면, C++ 컴파일러는 자동으로 같은 시그니처를 
 *    가지는 함수의 원형을 찾아 호출
 *  - 함수의 호출 예제
 *   1 Display("C++", 3); // 1번 Display() 함수 호출 -> "C++C++C++"
 *   2 Display("C++", " Programming"); // 2번 Display() 함수 호출 -> "C++ Programming"
 *   3 Display(3, 4); // 3번 Display() 함수 호출 -> 12
 *   4 Display(4.2, 2.1); // 4번 Display() 함수 호출 -> 2
 *   5 Display(4.2, 3); // 3번과 4번 모두 호출 가능 -> 컴파일 오류가 발생
 *   - 5번과 같은 함수의 호출로 첫 번째 인수로는 double형의 인수를, 두 번째 인수로는 
 *    int형의 인수를 전달; 이와 같은 함수 호출은 3번과 4번 시그니처의 Display() 함수를 
 *    모두 호출할 수 있으므로, 모호한 호출이 됨; C++에서는 오버로딩한 함수의 이러한 모호한
 *    호출을 허용하지 않으며, 이럴 때에는 오류를 발생시킴
*/
void Shift(int, int);
void Shift(int, int, int);
void Shift(int, int, int, int); 

int main(void){
    Shift(1, 2);
    Shift(1, 2, 3);
    Shift(1, 2, 3, 4);
    return 0;
}
// 함수의 오버로딩은 매개변수의 타입뿐만 아니라 매개변수의 개수를 달리해도 작성할 수 있음