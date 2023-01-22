#include<iostream>
using namespace std;
// 중첩된 구조체
// 구조체를 정의할 때 멤버 변수로 또 다른 구조체를 포함할 수 있음
struct Name
{
    string first;
    string last;
};
struct Friends
{
    Name first_name; // Friends 구조체는 Name 구조체를 멤버 변수로 포함
    string addr;
    string job;
};

// 구조체의 크기 : 멤버 변수들의 크기에 따라 결정
// 구조체의 크기가 언제나 멤버 변수들의 크기 총합과 일치하는 것은 아님
struct TypeSize
{
    char a; // sizeof(char) : 1
    int b; // sizeof(int) : 4
    double c; // sizeof(double) : 8
}; // sizeof(TypeSize) : 16
/**
 * - 구조체를 메모리에 할당할 때 컴파일러는 프로그램의 속도 향상을 위해 바이트 패딩
 * (byte padding)이라는 규칙을 이용
 * - 구조체는 다양한 크기의 타입을 멤버 변수로 가질 수 있는 타입; 하지만 컴파일러는 
 * 메모리의 접근을 쉽게 하려고 크기가 가장 큰 멤버 변수를 기준으로 모든 멤버 변수의 
 * 메모리 크기를 맞추게 됨; 이것을 바이트 패딩이라고 하며, 이때 추가되는 바이트를 
 * 패딩 바이트(padding byte)라고 함
 * - 크기가 가장 큰 double형 타입의 크기인 8바이트가 기준이 되고, 맨 처음 char형 멤버 
 * 변수를 위해 8바이트가 할당되며, 할당되는 1바이트를 제외한 7바이트가 남게 됨; 그다음 
 * int형 멤버 변수는 남은 7바이트보다 작으므로, 그대로 7바이트 중 4바이트를 할당하고 
 * 3바이트가 남게 됨; 마지막 double형 멤버 변수는 8바이트인데 남은 공간은 3바이트뿐이므로
 * 다시 8바이트를 할당받음; 따라서 이 구조체의 크기는 총 16바이트가 되며, 
 * 그중에서 패딩 바이트는 3바이트가 됨
*/
int main(void){
    

    return 0;
}