#include<iostream>
using namespace std;
/**
 * - this 포인터
 * - 멤버 함수의 공유 : 하나의 클래스에서 생성된 인스턴스는 각각 독립된 메모리 공간에
 *  저장된 자신만의 멤버 변수를 가지지만, 멤버 함수는 모든 인스턴스가 공유
 * - 따라서 Book 클래스를 이용해 두 개의 인스턴스를 생성해도, ThickerBook()이라는 멤버
 *  함수는 하나만이 존재; 즉, 더 두꺼운 책의 이름을 출력해 주는 ThickerBook() 멤버
 *  함수는 두 인스턴스가 같이 공유
 *  - ThickerBook() 멤버 함수의 정의)
 *      const Book& Book::ThickerBook(const Book& comp_book){
 *          if(comp_book.total_page_ > total_page_)
 *              return comp_book;
 *          else
 *              return ???; // 자신을 호출한 인스턴스를 반환하는데 알 수가 없음
 *      }
 *  - ThickerBook() 멤버 함수 호출)
 *      web_book.ThickerBook(html_book);
 *  => 이때 ThickerBook() 멤버 함수는 자신을 호출한 객체가 web_book 객체임을 인수를
 *   통해 전달받아야만 함; 그래야만 else 문에서의 반환값을 정확히 명시할 수 있기 때문
 * 
 * - this 포인터 : 위와 같은 이유로 C++에서는 모든 멤버 함수가 자신만의 this 포인터를
 *  가지고 있음; 이 this 포인터는 해당 멤버 함수를 호출한 객체를 가리키게 되며, 호출된
 *  멤버 함수의 숨은 인수로 전달됨; 이렇게 하면 호출된 멤버 함수는 자신을 호출한 객체가
 *  무엇인지 정확히 파악할 수 있음
 *  => const Book& Book::ThickerBook(const Book& comp_book){
 *         if(comp_book.total_page_ > total_page_)
 *             return comp_book;
 *         else
 *             return *this; // 자신을 호출한 인스턴스를 반환
 *     }
 *  => this는 포인터이므로, 반환할 때에는 참조 연산자(*)를 사용하여 호출한 객체 그 자체
 *    를 반환해야 함
 *  => this 포인터는 암시적으로도 사용될 수 있지만, 가급적 화살표(->)연산자를 통해 
 *    명시적으로 사용하는 것이 좋음
 * - this 포인터의 특징)
 *   1 this 포인터는 클래스, 구조체 또는 열거체 타입의 비정적 멤버 함수에서만 사용할 수
 *   있음
 *   2 정적(static) 멤버 함수는 this 포인터를 가지지 않음
 *   3 this 포인터는 언제나 포인터 상수이며, 따라서 값을 재할당할 수 없음
*/
/*class Book{
    private:
        int current_page_;
        void set_percent();
    public:
        string title_;
        int total_page_;
        double percent_;
        void Move(int page);
        void Open();
        void Read();
        const Book& ThickerBook(const Book&);
};
int main(void){
    Book web_book("html",350);
    Book html_book("java",200);
    cout<<web_book.ThickerBook(html_book).title_;
    return 0;
}
Book::Book(const string& title, int total_page){
    title_ = title;
    total_page_ = total_page;
    current_page_=0;
    set_percent();
}
void Book::set_percent(){
    percent_ = (double)current_page_/total_page_*100;
}
const Book& Book::ThickerBook(const Book& comp_book){
    if(comp_book.total_page_ > this->total_page_)
        return comp_book;
    else  
        return *this;
}*/