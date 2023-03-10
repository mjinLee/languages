#include<iostream>
using namespace std;
/**
 * - 유효 범위(scope) : 하나의 변환 단위 내에서 해당 변수가 사용될 수 있는 범위;
 *  함수 내에서 선언된 변수는 함수 내에서만 사용할 수 있음; 함수 밖에서 선언된 변수는
 *  변수가 선언된 이후에 나오는 모든 함수에서 사용할 수 있음
 * - C++ 표준에서는 파일이라는 용어 대신에 변환 단위라는 용어를 사용
 * - 연결(linkage) : 해당 변수를 사용할 수 있는 파일의 접근 가능 여부를 나타냄
 * - 외부 연결(external linkage)을 가지는 변수는 여러 파일에서 사용할 수 있음
 * - 내부 연결(internal linkage)을 가지는 변수는 하나의 파일에서만 사용할 수 있음
 * - 함수 내에서 선언된 변수는 함수 밖에서는 사용할 수 없으므로 연결을 가지지 않음
 * - C++ 변수는 유효 범위, 연결 등을 기준으로 나뉨
 *  1 자동 변수(automatic variable)
 *  2 레지스터 변수(register variable) : 변수를 선언할 때 register 키워드를 붙여 선언;
 *   C언어에서 이렇게 선언된 레지스터 변수는 CPU의 레지스터 메모리에 저장되어 빠르게 접근할
 *   수 있게 됨; 하지만 컴퓨터의 레지스터는 매우 작은 크기의 메모리이므로, 이 영역에 변수를
 *   선언하기 힘든 경우도 많음; 그럴 때 C 컴파일러는 해당 변수를 그냥 지역변수로 선언;
 *   C++11 이전에는 C++에서도 register 키워드가 위와 같은 의미로 사용되었으나, C++11부터는
 *   단순히 해당 변수가 자동 변수라는 것을 의미하는 역할로만 사용
 *  3 정적 변수(static variable) : C++에서 정적 변수는 프로그램이 실행되는 내내 유지되는 변수;
 *   이러한 정적 변수는 메모리상의 데이터(data) 영역에 저장되며, 초기화하지 않으면 0으로 자동 초기화;
 *   C++에서는 다음과 같이 세 가지 유형의 정적 변수를 제공)
 *    1 연결을 가지지 않는 정적 변수
 *    2 내부 연결을 가지는 정적 변수
 *    3 외부 연결을 가지는 정적 변수
 */
/**
 * - 자동 변수 : 블록 내에서 선언된 변수를 의미하며, 함수의 매개변수도 여기에 포함;
 *  변수가 선언된 블록 내에서만 유효하며, 블록이 종료되면 메모리에서 사라짐; 메모리상의
 *  스택(stack) 영역에 저장되며, 초기화하지 않으면 의미 없는 값(쓰레깃값)으로 초기화;
 *  C언어의 지역 변수(local variable)와 같은 의미로 사용

void Local(void);
int main(void){
    int i=5, var = 10;
    cout<<"main()함수 내의 자동변수 var : "<<var<<endl; // 10
    if(i<10){
        Local(); // 20
        int var = 30; 
        cout<<"if문 내의 자동변수 var : "<<var<<endl; // 30
    }
    cout<<"현재 자동변수 var : "<<var<<endl; // 10
    return 0;
}
void Local(void){
    int var = 20;
    cout<<"Local()함수 내의 자동변수 var : "<<var<<endl; // 20
}
// 같은 이름의 변수 var은 모두 다른 중괄호({}) 영역에서 선언되었으며, 이러한 중괄호 영역을 블록(block)이라고 함
// 변수의 유효 범위는 변수가 선언된 블록을 기준으로 설정되며, 해당 블록이 끝나면 모든 자동 변수는 메모리에서 사라지게 됨
// 위의 예제에서처럼 변수의 이름으로 같은 이름을 여러 번 사용하는 것은 매우 잘못된 방법
// 한 블록 내에서 같은 이름의 변수를 또다시 선언하려고 하면 컴파일러는 오류를 발생
*/

/**
 * - 정적변수
 *  1 연결을 가지지 않는 정적 변수 : 블록 내부에서 static 키워드를 사용하여 정의;
 *   지역변수와 전역변수의 특징을 모두 가짐; 이 변수는 전역 변수처럼 단 한 번만 초기화
 *   되며, 프로그램이 종료되어야 메모리상에서 사라짐; 또한, 지역 변수처럼 해당 블록
 *   내에서만 접근할 수 있음 

void Local(void);
void StaticVar(void);
int main(void){
    for (int i = 0; i < 3; i++){
        Local();
        StaticVar();
    }
    return 0;
}
void Local(void){
    int count = 1;
    cout << "Local() 함수 " << count << " 번째 호출" << endl;
    count++;
}
void StaticVar(void){
    static int static_count = 1; // 연결을 가지지 않는 정적 변수
    cout << "StaticVar() 함수 " << static_count << " 번째 호출" << endl;
    static_count++;
}
/* 지역 변수로 선언된 count와 연결을 가지지 않는 정적 변수로 선언된 static_count를 서로 비교
    =>  Local() 함수 1 번째 호출
        StaticVar() 함수 1 번째 호출
        Local() 함수 1 번째 호출
        StaticVar() 함수 2 번째 호출
        Local() 함수 1 번째 호출
        StaticVar() 함수 3 번째 호출
    => 지역 변수인 count는 함수의 호출이 끝날 때마다 메모리상에서 사라짐; 
       연결을 가지지 않는 정적 변수인 static_count는 함수의 호출이 끝나도 메모리상에서
       사라지지 않음; 그러므로 다음 함수 호출 때에도 이전의 데이터를 그대로 저장하고 있음;
       또한, static_count는 전역 변수와는 달리 자신이 선언된 StaticVar() 함수 이외의
       영역에서는 호출할 수 없음     
*/

/**
 * - 정적변수
 *  1 연결을 가지지 않는 정적 변수
 *  2 내부 연결을 가지는 정적 변수 : 유효 범위를 변환 단위로 가지는 변수에 static 키워드를
 *  사용하여 정의; 해당 변수를 포함하고 있는 변환 단위, 즉 현재 파일에서만 사용할 수 있음;
 *  이 변수는 하나의 파일 내의 모든 블록에서 접근할 수 있고, 또한 사용할 수 있음
*/
static int var; // 내부 연결을 가지는 정적 변수
void Local(void);
int main(void){
    cout << "변수 var의 초깃값 : " << var << endl;
    int i = 5;
    int var = 10; // 자동 변수 선언
    cout << "main() 함수 내의 자동 변수 var : " << var << endl;
    if (i < 10){
        Local();
        cout << "현재 변수 var의 값 : " << var << endl; // 자동 변수에 접근
    }
    cout << "더 이상 main() 함수에서는 정적 변수 var에 접근할 수가 없음" << endl;
    return 0;
}
void Local(void){
    var = 20; // 정적 변수의 값 변경
    cout << "Local() 함수 내에서 접근한 정적 변수 var의 값 : " << var << endl;
}
/* 
  => 변수 var의 초깃값 : 0
     main() 함수 내의 자동 변수 var : 10
     Local() 함수 내에서 접근한 정적 변수 var의 값 : 20
     현재 변수 var의 값 : 10
     더 이상 main() 함수에서는 정적 변수 var에 접근할 수가 없음
  => 정적 변수 var와 같은 이름의 자동 변수 var가 main() 함수 내부에서 선언; 
     이 자동 변수가 선언되기 전까지는 main() 함수에서도 정적 변수 var에 접근할 수 있음;
     하지만 자동 변수 var가 선언된 후에는 main() 함수에서 정적 변수 var로 접근할 방법이
     없어짐; 블록 내에서 선언된 자동 변수는 같은 이름의 정적 변수를 덮어쓰기 때문
  => C++에서는 하나의 파일 내의 모든 블록에서 데이터를 공유하기 위한 또 다른 방법으로 
     네임스페이스를 제공하고 있음
*/

/**
 * - 정적변수
 *  1 연결을 가지지 않는 정적 변수
 *  2 내부 연결을 가지는 정적 변수
 *  3 외부 연결을 가지는 정적 변수 : 유효 범위를 변환 단위로 가지는 변수; 
 *   이러한 외부 연결을 가지는 정적 변수를 전역 변수 또는 외부 변수라고 함;
 *   외부 변수는 해당 파일뿐만 아니라 외부 파일에서도 사용할 수 있는 변수; 
 *   외부 변수는 해당 변수를 사용하는 모든 파일에서 각각 extern 키워드를 사용하여 
 *   재선언되어야 사용할 수 있음
 * 
 *   => 파일1.cpp
 *      #include<iostream>
 *      using namespace std;
 *      int var = 10; // 외부 변수 정의
 *   => 파일2.cpp
 *      #include<iostream>
 *      using namespace std;
 *      #include "파일1.cpp"
 *      extern int var; // 외부 변수를 사용하기 위한 재선언
 *   => C++에서는 여러 파일에서 외부 변수가 사용될 경우, 오직 한 개의 파일에서만 
 *     외부 변수에 대한 정의를 할 수 있음; 이러한 원칙을 단일 정의의 원칙이라고 함
*/