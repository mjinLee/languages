#include<iostream>
using namespace std;

int main(){
    // 비교 연산자
    int n1 = 3; int n2 = 7;
    cout << "!= : " << (n1 != n2) << endl; // 1
    cout << ">= : " << (n1 >= n2) << endl; // 0

    // 논리 연산자
    int nu1=3, nu2=-7;
    bool re1, re2;
    re1 = (nu1 > 0) && (nu1 < 5); // 1
    re2 = (nu2 < 0) || (nu2 > 10); // 1
    cout << "! : "<< !re2 << endl; // 0

    // 비트 연산자
    // - &(AND), |(OR),^(XOR),~(NOT,1의 보수), <<(left shift), >>(right shift)
    int num1 = 15; int num2=8;
    cout << "~ : "<< (~num1) << endl; // -16
    cout << "<< : "<< (num2<<2) << endl; // 32
    cout << ">> : "<< (num2>>2) << endl; // 2

    // 삼항 연산자 : '조건식 ? 반환값1 : 반환값2'
    int num3=11; int num4=10; int res;
    res = (num3<num4) ? num3 : num4;
    cout << "둘 중 더 작은 수는 " << res << endl; // 10

    // sizeof 연산자 : 해당 변수나 상수값에 해당하는 타입의 크기 반환

    /* - 범위 지정 연산자(::)
        1 ::식별자
        2 클래스이름::식별자
        3 네임스페이스::식별자
        4 열거체::식별자
       - 멤버 포인터 연산자('.*' ,'->*')
        1 클래스타입의객체.*멤버이름
        2 클래스타입객체의포인터->*멤버이름
     */

    // typeid 연산자 : 객체의 타입에 관한 정보 확인
}