/**
 * - 디폴트 생성자(default constructor) : 객체가 생성될 때 사용자가 초깃값을 명시하지
 * 않으면, 컴파일러가 자동으로 제공하는 생성자; 사용자로부터 인수를 전달받지 않으므로,
 * 매개변수를 가지지 않음; 대부분 0이나 NULL, 빈 문자열 등으로 초기화
 * - 디폴트 생성자의 원형 : Book::Book(){}
 *  => 클래스에 생성자가 단 하나도 정의되지 않았을 때만, 컴파일러에 의해 자동으로 제공;
 *   초깃값을 명시하지 않고 객체를 생성하고 싶다면, 사용자가 직접 디폴트 생성자를 정의해야 함
 * - 디폴트 생성자의 정의 : 사용자가 직접 디폴트 생성자를 정의하는 방법
 *  1 함수 오버로딩을 이용한 방법 : Book();
 *   => 매개변수를 가지지 않는 또 하나의 생성자를 정의할 수 있음
 *  2 디폴트 인수를 이용한 방법 : Book::Book(const string& title="web",int total_page="100");
 *   => 모든 인수에 디폴트 값을 명시하면, 인수를 전달하지 않고도 객체를 생성할 수 있는
 *     디폴트 생성자가 됨
 *  => 클래스는 단 하나의 디폴트 생성자만을 가질 수 있으므로, 둘 중 한 가지 방법으로만
 *    디폴트 생성자를 정의해야 함
 * - 디폴트 생성자를 가지는 객체의 선언
 *  1 Book web_book;             // 디폴트 생성자의 암시적 호출
 *  2 Book web_book = Book();    // 디폴트 생성자의 명시적 호출
 *  3 Book *ptr_book = new Book; // 디폴트 생성자의 암시적 호출
 *  => 디폴트 생성자를 암시적으로 호출하고 싶을 때에는 괄호(())를 사용해서는 안 됨
*/

/**
 * - 복사 생성자
 * - 얕은 복사와 깊은 복사)
 * - 얕은 복사란 값을 복사하는 것이 아닌, 값을 가리키는 포인터를 복사하는 것; 변수의 생성
 * 에서 대입 연산자를 이용한 값의 복사는 문제가 되지 않지만, 객체에서는 문제가 발생할 수도
 * 있음; 특히 객체의 멤버가 메모리 공간의 힙(heap) 영역을 참조할 경우엔 문제가 발생
 * - 복사 생성자(copy constructor) : 자신과 같은 클래스 타입의 다른 객체에 대한 참조를
 * 인수로 전달받아, 그 참조를 가지고 자신을 초기화하는 방법; 새롭게 생성되는 객체가 원본
 * 객체와 같으면서도, 완전한 독립성을 가지게 해줌; 복사 생성자를 이용한 대입은 깊은 복사를
 * 통한 값의 복사이기 때문
 *  => 복사 생성자의 원형 : Book(const Book&);
 *  - 복사생성자는 주로,
 *    1 객체가 함수에 인수로 전달될 때
 *    2 함수가 객체를 반환값으로 반환할 때
 *    3 새로운 객체를 같은 클래스 타입의 기존 객체와 똑같이 초기화할 때
 * 
*/
#include<iostream>
using namespace std;
#include<string>

class Book
{
private:
    int current_page_;
    void set_percent();
public:
    Book(const string& title, int total_page);
    Book(const Book&); // 복사 생성자의 원형 정의
    string title_;
    int total_page_;
    double percent_;
    void Move(int page);
    void Open();
    void Read();
};

int main(void){
    Book web_b("html and css", 350);
    // 복사생성자를 이용해 새롭게 생성되는 html_b 객체를 같은 클래스의 web_b 객체로 초기화
    Book html_b(web_b); // 복사생성자 사용 : Book html_b = Book(web_b);
    cout<<"1 title : "<<web_b.title_<<", pages : "<<web_b.total_page_<<endl;
    cout<<"2 title : "<<html_b.title_<<", pages : "<<html_b.total_page_<<endl;
    return 0;
}
// 1 title : html and css, pages : 350
// 2 title : html and css, pages : 350

Book::Book(const string& title, int total_page)
{
    title_ = title;
    total_page_ = total_page;
    current_page_ = 0;
    set_percent();
}

Book::Book(const Book& origin){ // 복사 생성자의 선언
    title_ = origin.title_;
    total_page_ = origin.total_page_;
    current_page_ = origin.current_page_;
    percent_ = origin.percent_;
}

void Book::set_percent(){
    percent_ = (double)current_page_/total_page_*100;
}