#include<iostream>
using namespace std;
/**
 * - C++에서 구조체의 모든 멤버는 외부에서 언제나 접근할 수 있음; 하지만 클래스는 객체 
 * 지향 프로그래밍의 기본 규칙 중 하나인 정보 은닉에 대해서도 생각해야만 함
 * - 접근 제어(access control) : 접근 제어 지시자를 사용해 클래스 외부에서의 직접적인
 *  접근을 허용하지 않는 멤버를 설정할 수 있도록 하여, 정보 은닉을 구체화하는 것을 의미
 *  1 public  2 private  3 protected
 * - 클래스의 기본 접근 제어 권한은 private이며, 구조체 및 공용체는 public
 * - C++ 클래스는 private 멤버로 정보를 은닉하고, public 멤버로 사용자나 프로그램과의
 *  인터페이스를 구축
 * 
 *  1 public : 선언된 클래스 멤버는 외부로 공개되며, 해당 객체를 사용하는 프로그램 
 *   어디에서나 직접 접근할 수 있음; public 멤버 함수는 해당 객체의 private 멤버와 
 *   프로그램 사이의 인터페이스 역할을 하게 됨; 프로그램은 이러한 public 멤버 함수를 
 *   통해 해당 객체의 private 멤버에도 접근할 수 있음
 *  2 private : 선언된 클래스 멤버는 외부에 공개되지 않으며, 외부에서 직접 접근할 수도
 *   없음; 프로그램은 private 멤버에 직접 접근할 수 없으며, 해당 객체의 public 멤버
 *   함수를 통해서만 접근할 수 있음; 클래스의 기본 접근 제어 권한은 private로 설정되어
 *   있으므로, 클래스 선언 시 private 접근 제어 지시자는 생략할 수 있음; 일반적으로
 *   private 멤버는 public 인터페이스를 직접 구성하지 않는 클래스의 세부적인 동작을
 *   구현하는 데 사용
 *  3 protected : 파생 클래스(derived class)와 관련된 접근 제어 지시자; protected 
 *   멤버는 파생 클래스에 대해서는 public 멤버처럼 취급되며, 외부에서는 private 멤버
 *   처럼 취급
 *   - protected 멤버에 접근할 수 있는 영역)
 *      1 이 멤버를 선언한 클래스의 멤버 함수
 *      2 이 멤버를 선언한 클래스의 프렌드
 *      3 이 멤버를 선언한 클래스에서 public 또는 protected 접근 제어로 파생된 클래스
*/
// 1 public 접근 제어 지시자
class Book{
    public:
        string title;
        int total_page;
        double percent_;
        void Move(int page);
        void Open();
        void Read();
};
// 2 private 접근 제어 지시자
class Book2{
    private: // 생략 가능
        int current_page_;
        void set_percent();
    public:
        string title;
        int total_page;
        double percent_;
        void Move(int page);
        void Open();
        void Read();
};