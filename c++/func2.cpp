#include<iostream>
using namespace std;
/**
 * - 재귀 호출(recursive call) : 함수 내부에서 함수가 자기자신을 또다시 호출;
 * 반드시 재귀 호출을 중단하도록 조건이 변경될 명령문을 포함해야 함
 * - 재귀 호출이 무한히 반복되면, 실행 직후 스택 오버플로우에 의해 종료될 것
*/
/*int RecursiveSum(int n){
    if(n == 1) // 재귀호출 중단하기 위한 조건문
        return 1;
    return n + RecursiveSum(n-1);
}*/

/**
 * - 함수 포인터 : 프로그램에서 정의된 함수는 프로그램이 실행될 때 모두 메인 메모리에
 * 올라감; 이때 함수의 이름은 메모리에 올라간 함수의 시작 주소를 가리키는 포인터 상수가
 * 됨; 이렇게 함수의 시작 주소를 가리키는 포인터 상수를 함수 포인터라고 부름
 * - 포인터 상수 : 포인터 변수가 가리키고 있는 주소 값을 변경할 수 없는 포인터
 * - 상수 포인터 : 상수를 가리키는 포인터
 * - 함수 포인터의 포인터 타입은 함수의 반환값과 매개변수에 의해 결정됨; 즉 함수의 원형을
 * 알아야만 해당 함수에 맞는 함수 포인터를 만들 수 있음
 *      함수 원형 : void Func(int,int);
 *      함수 포인터 : void (*ptr_func)(int,int);
 *      - 연산자 우선순위 때문에 ptr_func을 괄호로 둘러싸야 정상 작동될 것
 * - 함수 포인터는 함수를 또 다른 함수의 인수로 전달할 때 유용
 * 
 * - 널 포인터(null pointer) : 포인터를 초기화할 때 0이나 NULL을 대입하여 초기화한 포인터;
 * 아무것도 가리키지 않는 포인터
 * 
 * - 함수 포인터의 표기법 단순화)
 *  1 typedef 키워드 : 복잡한 함수 포인터형에 새로운 이름을 붙일 수 있음
 *      typedef double (*CalcFunc)(double,double); // 함수 포인터에 CalcFunc이라는 새로운 이름을 붙임
 *      CalcFunc ptr_func = calc;
 *  2 auto 키워드(c++11~) : 복잡한 함수 포인터형으로 자동 타입 변환할 수 있음
 *      auto ptr_func = calc;
*/
// 함수 포인터를 사용하여 사용자의 입력에 따라 4개의 사칙연산 함수 중 하나를 선택
// 선택된 함수를 함수 포인터를 사용하여 Calculator() 함수에 인수로 전달
double Add(double, double);
double Sub(double, double);
double Mul(double, double);
double Div(double, double);
//double Calculator(double , double, double (*func)(double, double));
// typedef 키워드를 이용한 새로운 이름 선언
typedef double (*Arith)(double,double);
double Calculator(double,double,Arith);

int main(void){
    //double (*calc)(double, double) = NULL; // 함수 포인터 선언
    // typedef 키워드 이용한 함수 포인터 선언
    Arith calc = NULL;
    double num1 = 3, num2 = 4, result = 0;
    char oper = '*';
    switch (oper){
        case '+' :
            calc = Add;
            break;
        case '-':
            calc = Sub;
            break;
        case '*':
            calc = Mul;
            break;
        case '/':
            calc = Div;
            break;
        default:
            cout << "사칙연산(+, -, *, /)만을 지원";
            break;
    }
    result = Calculator(num1, num2, calc);
    cout << "사칙 연산의 결과는 " << result;
    return 0;
}

double Add(double num1, double num2) { return num1 + num2; }
double Sub(double num1, double num2) { return num1 - num2; }
double Mul(double num1, double num2) { return num1 * num2; }
double Div(double num1, double num2) { return num1 / num2; }
//double Calculator(double num1, double num2, double (*func)(double, double)) { return func(num1, num2); }
//typedef 이용한 함수 정의
double Calculator(double num1, double num2, Arith func){ return func(num1,num2); }