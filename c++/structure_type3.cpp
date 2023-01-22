#include<iostream>
using namespace std;
/**
 * - 공용체(union) : union 키워드 사용; 모든 면에서 구조체와 같으나, 모든 멤버 변수가
 * 하나의 메모리 공간을 공유한다는 점만 다름; 모든 멤버 변수가 같은 메모리를 공유하기
 * 때문에 공용체는 한 번에 하나의 멤버 변수밖에 사용할 수 없음
 * - 공용체는 순서가 규칙적이지 않고, 미리 알 수 없는 다양한 타입의 데이터를 저장할 수 
 * 있도록 설계된 타입; 크기가 가장 큰 멤버 변수의 크기로 메모리를 할당받음; 공용체 배열을
 * 사용하면, 같은 크기로 구성된 배열 요소에 다양한 크기의 데이터를 저장할 수 있음
 * - 공용체에 저장된 값의 의미는 값을 저장할 때 공용체의 어떤 멤버 변수를 사용했는지에 따라
 * 달리 해석됨; 공용체가 어떤 멤버 변수를 사용하여 저장했는지를 별도의 변수로 저장하든가 
 * 하여, 사용할 때에도 같은 멤버 변수를 사용해야 함
*/
// 공용체의 한 멤버 변수만을 초기화하면, 나머지 멤버 변수들도 모두 같은 데이터를 공유함
union ShareData
{
    unsigned char a; // unsigned : 0을 포함한 양수만 가짐
    unsigned short b;
    unsigned int c;
};

/**
 * - 열거체(enumerated types) : 새로운 타입을 선언하면서 동시에 그 타입이 가질 수 있는 
 * 정수형 상숫값도 같이 명시
 * - 열거체를 이용하면 가독성이 높아지고, 변수가 지니는 값에 의미를 부여할 수 있음
 * - enum 키워드 사용하여 선언
 * - 상숫값을 따로 명시하지 않으면 0부터 시작, 그 다음은 바로 앞의 상숫값보다 1만큼 증가
 * 되며 정의됨
*/
enum Weather {SUNNY = 0, CLOUD = 10, RAIN = 20, SNOW = 30};

int main(void){
    // 공용체
    ShareData var;
    var.c = 0x12345678;
    cout << hex; // x
    cout << var.a << endl; // 5678
    cout << var.b << endl; // 12345678
    //cout << var.c; // 305419896

    // 열거체
    int input;
    Weather wt;
    cout << "오늘의 날씨를 입력해 주세요 : " << endl;
    cout << "(SUNNY=0, CLOUD=10, RAIN=20, SNOW=30)" << endl;
    cin >> input;
    wt = (Weather)input;
    switch (wt){
        case SUNNY:
            cout << "오늘의 날씨는 맑아요";
            break;
        case CLOUD:
            cout << "오늘의 날씨는 흐리네요";
            break;
        case RAIN:
            cout << "오늘의 날씨는 비가 오네요";
            break;
        case SNOW:
            cout << "오늘의 날씨는 눈이 내려요";
            break;
        default:
            cout << "정확한 상숫값을 입력해 주세요";
            break;
    }
    cout << endl << "열거체 Weather의 각 상숫값은 " << SUNNY << ", " << CLOUD << ", "<< RAIN << ", " << SNOW << "입니다.";

    return 0;
}