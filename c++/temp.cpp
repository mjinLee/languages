// #include <math.h>
// #include <cmath> // 둘 다 가능
// #define : 함수나 상수를 단순화해주는 매크로 정의
/**
 * - 네임스페이스 : 클래스, 함수, 변수 등은 std라는 이름 공간에 저장되어 있음
 * - 표준 헤더 파일인 iostream 내의 정의를 사용하려면,
 *      #include <iostream>
 *      #define TEXT "c++"
 *      int main(){ std::cout << TEXT; return 0; }
 * - using namespace std; // std라는 네임스페이스에 속한 정의들은 네임스페이스를
 * 붙이지 않아도 사용할 수 있음
 * - C++의 모든 것은 객체로 표현되므로, 입출력을 담당하는 수단 또한 모두 객체임
 *  => cout 객체로 출력(std::cout<<출력할데이터;),
 *     cin 객체로 입력(std::cin>>저장할변수;)
 *  - c언어처럼 printf() 함수나 scanf() 함수도 가능
 *  - C++ 표준 입출력 객체는 입출력 데이터의 타입을 자동으로 변환시켜줌
*/
#include <iostream>
#define TEXT "C++"
using namespace std;

int main(){
    cout << TEXT;
    
    int num;
    cout << "숫자 입력 : ";
    cin >> num;
    cout << "입력된 숫자는 "<< num << "입니다."<< endl;
    return 0;
}