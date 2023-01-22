#include<iostream>
using namespace std;
/**
 * - 디폴트 인수(default argument) : 기본값이 미리 정의되어 있는 인수; 함수를 호출할 때
 *  인수를 전달하지 않으면, 함수는 자동으로 미리 정의되어 있는 디폴트 인수값을 사용
 * - 디폴트 인수의 설정)
 *  1 디폴트 인수는 함수의 원형에만 지정할 수 있음
    2 디폴트 인수는 가장 오른쪽부터 시작하여 순서대로만 지정할 수 있음
    3 가운데 인수들만 별도로 디폴트 인수를 지정할 수는 없음
    - 함수의 원형 예제)
     1 void Display(int x, int y, char ch, int z = 4);       // 가능
     2 void Display(int x, int y, char ch = 'a', int z = 4); // 가능
     3 void Display(int x, int y = 2, char ch, int z = 4);   // 오류
     4 void Display(int x = 1, int y = 2, char ch, int z);   // 오류
 * - 디폴트 인수가 설정된 함수의 호출 : 함수로 전달된 인수는 왼쪽부터 순서대로 매개변수
   목록에 대입됨; 디폴트 인수가 설정된 함수를 호출할 때에는 인수의 전달을 건너뛸 수 없음 
    - 함수의 호출 예제)
     void Display(int x, int y, char ch='a',int z =4); // 함수 원형
     1. Display(1, 2);         // 가능 -> display(1, 2, 'a', 4)와 같음
     2. Display(3, 4, 'b');    // 가능 -> display(3, 4, 'b', 4)와 같음
     3. Display(5, 6, 'c', 9); // 가능 -> display(5, 6, 'c', 8)와 같음
     4. Display(7, 8, , 9);    // 오류 : 인수 전달은 건너뛸 수 없음
 * - 디폴트 인수 : 인수의 개수를 달리하여 같은 함수를 호출
*/
double Multi(double,double=2);
int main(void){
    cout << Multi(3) << endl;    // Multi(3, 2)와 같음 : 3 * 3
    cout << Multi(3, 3) << endl; // 3 * 3 * 3
    cout << Multi(3, 4);         // 3 * 3 * 3 * 3
    return 0;
}
double Multi(double x, double n) {
    double result = x;
    for (int i = 1; i < n; i++){
        result *= x;
    }
    return result;
}



