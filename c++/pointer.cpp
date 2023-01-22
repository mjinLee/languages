#include<iostream>
using namespace std;

/**
 * - 주소값 : 데이터가 저장된 메모리의 시작 주소
 * - 포인터 : 메모리의 주소값을 저장하는 변수; 포인터 변수
 *      int n = 100; // 변수의 선언
 *      int *ptr = &n; // 포인터의 선언
 *   - 주소 연산자(&) : 변수의 이름 앞에 사용; 변수의 주소값 반환
 *   - 참조 연산자(*) : 포인터의 이름이나 주소 앞에 사용; 포인터에 저장된 주소에 저장되어
 *      있는 값을 반환
 *   - 포인터 동시 선언
 *      int *ptr1, *ptr2;
 *   - 포인터 선언한 후 참조 연산자(*)를 사용하기 전에 포인터는 반드시 초기화되어야 함;
 *    초기화하지 않은 채로 참조 연산자를 사용하게 되면, 위치를 알 수 없는 메모리에 저장
 *      타입 *포인터이름 = &변수이름;   |   타입 *포인터이름 = &주소값;
 *   - 선언된 포인터는 참조연산자(*)를 사용하여 참조할 수 있음
 *      int x = 7; // 변수 선언
 *      int *ptr = &x; // 포인터 선언
 *      int **pptr = &ptr; // 포인터 참조
 *   - 포인터변수는 메모리에서 변수의 위치를 나타내는 주소를 다루는 변수이므로, 크기는
 *     일반적으로 CPU에 따라 결정
 *   - 워드(word) : CPU가 한 번에 처리할 수 있는 데이터의 크기
 *     1바이트는 8비트; 32비트 시스템-32비트 / 8비트=4, 즉 4바이트가 1워드로 처리
 *     64비트 시스템-64비트 / 8비트=8, 즉 8바이트가 1워드로 처리
*/
/**
 * - 포인터 연산 : 값을 증가시키거나 감소시키는 등의 제한된 연산만 가능
 * - 포인터끼리 덧셈, 곱셈, 나눗셈은 의미가 없음; 뺄셈은 두 포인터 사이의 상대적 거리를
 *  를 나타냄; 포인터에 정소를 더하거나 뺄 수는 있지만, 실수와의 연산은 허용X; 포인터끼리
 *  대입하거나 비교할 수 있음
 * - int형 포인터의 증가폭은 int형 타입의 크기인 4바이트만큼 증가
*/
/**
 * - 포인터와 배열 : 배열의 이름은 그 값을 변경할 수 없는 상수라는 점을 제외하면 포인터와
 * 같음; 배열의 이름을 포인터처럼 사용할 수 있고, 포인터를 배열의 이름처럼 사용할 수 있음;
 * 배열의 이름이 주소로 해석되며, 해당 배열의 첫 번째 요소의 주소와 같음
*/
/**
 * - 메모리의 동적할당(dynamic allocation) : 데이터영역과 스택영역에 할당되는 메모리의
 * 크기는 컴파일 타임에 미리 결정됨; 하지만 힙 영역의 크기는 프로그램이 실행되는 도중인
 * 런 타임에 사용자가 직접 결정; 이렇게 런 타임에 메모리를 할당받는 것을 메모리의 동적
 * 할당이라고 함
 * - 포인터의 가장 큰 목적은 런 타임에 이름 없는 메모리를 할당받아 포인터에 할당하여, 
 * 할당받은 메모리에 접근하는 것
 * - C언어에서는 malloc() 함수, calloc() 함수 등의 라이브러리 함수 제공
 * - C++에서도 C언어의 라이브러리 함수 사용해 메모리의 동적 할당 및 해제 가능
 * - C++에서는 메모리의 동적 할당 및 해제를 위한 더욱 효과적인 방법을 new 연산자와 
 * delete 연산자를 통해 제공
*/
/**
 * - new 연산자 : 타입* 포인터이름 = new 타입;
 * - 첫 번째 타입은 데이터에 맞는 포인터를 선언하기 위해, 두 번째 타입은 메모리의 종류를
 * 지정하기 위함; 사용할 수 있는 메모리가 부족하여 새로운 메모리를 만들지 못했다면, new
 * 연산자는 널 포인터 반환
 * - new 연산자는 자유 기억 공간(free store)이라고 불리는 메모리 공간(memory pool)에
 * 객체를 위한 메모리를 할당
 * - new 연산자를 통해 할당받은 메모리는 따로 이름이 없으므로 해당 포인터로만 접근할 수 있음
 * 
 * - delete 연산자 : delete 포인터이름;
 * - C언어에서는 free() 함수를 이용하여 동적으로 할당받은 메모리를 다시 운영체제로 반환
 * - C++에서는 delete 연산자를 사용하여, 더 이상 사용하지 않는 메모리를 반환
*/
int main(){
    int n1 = 123;
    double n2 = 3.14;
    int* ptr_n1 = &n1;
    double* ptr_n2 = &n2;
    cout<<"포인터의 크기 : "<<sizeof(ptr_n1)<<endl; // 4
    cout<<"포인터 ptr_n1이 가리키는 주소값 : "<<ptr_n1<<endl; // 0x61ff04
    cout<<"포인터 ptr_n1이 가리키는 주소에 저장된 값 : "<<*ptr_n1<<endl; // 123

    // 포인터와 배열
    int arr[3]={10,20,30};
    int* ptr_arr = arr; // 포인터에 배열의 이름을 대입
    cout<<"배열이름 이용해 배열요소에 접근 : "<<arr[0]<<","<<arr[1]<<","<<arr[2]<<endl; // 10,20,30
    cout<<"포인터 이용해 배열요소에 접근 : "<<ptr_arr[0]<<","<<ptr_arr[1]<<","<<ptr_arr[2]<<endl; // 10,20,30
    cout<<"배열이름 이용한 배열크기 계산 : "<<sizeof(arr)<<endl; // 12
    cout << "포인터를 이용한 배열의 크기 계산 : " << sizeof(ptr_arr); //4
    // => 포인터에 배열의 이름을 대입한 후, 해당 포인터를 배열의 이름처럼 사용
    // - 배열이름을 이용한 크기 계산 : 배열의 크기가 int형인 배열 요소 3개의 크기인 12바이트 출력
    // - 포인터를 이용한 크기 계산 : 배열의 크기가 아닌 포인터 변수 자체의 크기 출력

    // 배열의 포인터 연산
    // 배열의 이름을 포인터처럼 사용
    cout<<"배열의 이름을 이용하여 배열 요소에 접근 : "<<arr[0]<<","<<arr[1]<<","<<arr[2]<<endl; // 10,20,30
    cout<<"배열이름으로 포인터 연산을 해 배열 요소에 접근 : "<<*(arr+0)<<","<<*(arr+1)<<*(arr+2); // 10,20,30
    // => arr이 배열의 이름이거나 포인터이고 n이 정수일 때, arr[n]==*(arr+n)

    // new, delete 연산자
    int* ptr_int = new int;
    *ptr_int = 100;
    double* ptr_double = new double;
    *ptr_double = 100.123;
    cout << "int형 숫자의 값 : " << *ptr_int << endl; // 100
    cout << "int형 숫자의 메모리 주소 : " << ptr_int << endl; // 0x1036d90
    delete ptr_int;
    delete ptr_double;
    // => new 연산자를 통해 생성한 메모리가 아닌 변수를 선언하여 생성한 메모리는 delete
    // 연산자로 해제할 수 없음; delete 연산자는 반드시 new 연산자를 통해 할당된 메모리를
    // 해제할 때에만 사용; 한 번 해제한 메모리를 다시 해제하려고 시도하면 오류가 발생

    return 0;
}