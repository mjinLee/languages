#include<iostream>
using namespace std;
/**
 * - 함수 : 반환타입 함수이름(매개변수목록);
 * - 인수 전달 방법 : 
 *    1 값에 의한 전달(call by value) 
 *    2 참조에 의한 전달(call by reference)
 * - main()함수의 인수 전달 :
 *    void(또는 int)main(int argc, char *argv[]);
 *      => main(인수로 전달되는 문자열의 개수, 인수로 전달된 각각의 문자열이 포함된 배열)
*/
// 값에 의한 전달
void Local(int);
// 참조에 의한 전달
void Lo(int&);

int main(void){
    int var =10;
    // 값에 의한 전달
    Local(var);
    // 참조에 의한 전달
    Lo(var);

    return 0;
}

void Local(int num){
    num += 10;
}
// => Local()함수의 매개변수 num은 인수로 변수 var의 값을 전달받음
// 함수 내에서 매개변수 num의 값을 아무리 변경하더라도 원래 인수로 전달된 변수 var의 값은 절대 변경되지 않음

void Lo(int& num){
    num += 10;
}
// Lo()함수의 매개변수 num은 인수로 변수 var의 참조를 전달받음
// 함수 내에서 참조자 num의 값을 변경하면 원래 인수인 변수 var의 값도 같이 변경됨