#include<iostream>
using namespace std;
/**
 * - 구조체 : 사용자 정의 타입; 다양한 타입의 변수 집합을 하나의 타입으로 나타낸 것;
 * 구조체를 구성하는 변수를 구조체의 멤버 또는 멤버 변수라고 함
 * - 변수뿐만 아니라 함수까지도 멤버 변수로 가질 수 있음
 * - C++의 구조체는 타입일 뿐만 아니라, 객체 지향 프로그래밍의 핵심이 되는 class의 기초가 됨
 * - 구조체 선언)
 *      struct 구조체이름{
 *          멤버변수타입 멤버변수이름
 *      };
 * - struct 구조체이름 구조체변수이름;
 * - c++에서는 구조체 변수를 선언할 때 struct 키워드 생략 가능
 * - 구조체 멤버로 접근 : 구조체변수이름.멤버변수이름
 * - 구조체 변수 초기화 : 구조체변수이름 = {멤버변수1의초기값,멤버변수2의초기값,..};
 * - 구조체 정의에서 멤버 변수가 정의된 순서에 따라 차례대로 초깃값이 설정되며, 나머지
 * 멤버 변수는 0으로 초기화됨
 * 
 * - 함수와 구조체 : 함수를 호출할 때 전달되는 인수나, 함수가 종료될 때 반환되는 반환값
 * 으로도 구조체를 사용할 수 있음; 방식은 기본 타입과 완전히 같으며, 구조체를 가리키는
 * 포인터나 구조체의 한 멤버 변수만을 사용할 수도 있음 
 * - 구조체를 인수로 전달하는 방식은 함수가 원본 구조체의 복사본을 가지고 작업하므로 안전
 * - 함수의 인수로 구조체의 주소를 직접 전달하는 예제)
 *      int CalcProperty(Prop*);
        int main(void) {
            ...
            hong_prop = CalcProperty(&hong); // 구조체의 주소를 함수의 인수로 전달함.
            ...
        }
        int CalcProperty(Prop* money) {
            money->savings = 100; // 호출된 함수에서 원본 구조체의 데이터를 변경
            return (money->savings - money->loan);
        }  
        // 홍길동의 재산은 적금 100원에 대출 4000000원을 제외한 총 -3999900원
     => 구조체를 가리키는 포인터를 인수로 전달하는 방식은 구조체의 복사본이 아닌 주소 
       하나만을 전달하므로 빠름; 하지만 호출된 함수에서 원본 구조체에 직접 접근하므로,
       원본 데이터의 보호 측면에서는 매우 위험
   - CalcProperty() 함수처럼 const 키워드를 사용하여 함수에 전달된 인수를 함수 내에서는
    직접 수정할 수 없도록 하는 것이 좋음
        Prop InitProperty(void);
        int CalcProperty(const Prop*);
        int main(void) {
            ...
            hong = InitProperty();
            hong_prop = CalcProperty(&hong); // 구조체의 멤버 변수를 함수의 인수로 전달함
            ...
        }
        Prop InitProperty(void) {
            Prop hong_prop = {10000000, 4000000};
            return hong_prop; // 구조체를 함수의 반환값으로 반환
            //=> 함수는 한 번에 하나의 데이터만을 반환; 구조체를 사용하면 한 번에 여러 개의 데이터를 반환할 수 있음
        }       
        int CalcProperty(const Prop* money) {
            // const 키워드를 사용하여 구조체의 데이터를 직접 수정하는 것을 방지
            //money->savings = 100; // 호출된 함수에서 원본 구조체의 데이터를 변경
            //=> 원본 구조체에 대한 수정을 시도할 경우 컴파일 오류 발생
            return (money->savings - money->loan);
        }        
*/
struct book
{
    string title;
    string author;
    int price;
};

struct Prop
{
    int savings;
    int loan;
};

int CalcProperty(int,int); // 함수

int main(void){
    // 구조체
    book web_book = {"html","peter",28000};
    book java_book = {"java","parker"};
    cout<<"**book list**"<<endl;
    cout<<"제목 : "<<web_book.title<<", 저자 : "<<web_book.author<<", 가격 : "<<web_book.price<<endl;
    cout<<"제목 : "<<java_book.title<<", 저자 : "<<java_book.author<<", 가격 : "<<java_book.price<<endl;
    /* **book list**
       제목 : html, 저자 : peter, 가격 : 28000
       제목 : java, 저자 : parker, 가격 : 0
    */
   // C++11부터는 구조체 변수를 초기화할 때에 대입 연산자(=)를 생략할 수 있으나, narrowing(축소 변환)은 지원하지 않음

    // 함수와 구조체
    int peter_prop;
    Prop peter = {10000000, 4000000};
    // 구조체의 멤버 변수를 함수의 인수로 전달
    peter_prop = CalcProperty(peter.savings,peter.loan);
    cout<<"peter의 재산은 적금 "<<peter.savings<<"원에 대출 "<<peter.loan<<"원을 제외한 총 "<<peter_prop<<"원";
    // peter의 재산은 적금 10000000원에 대출 4000000원을 제외한 총 6000000원

    return 0;
}

int CalcProperty(int s,int l){
    return (s-l);
}