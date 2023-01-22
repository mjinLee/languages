/**
 * - 정적 멤버 함수(static member function) :  클래스의 멤버 함수도 정적으로 선언할 수 있음;
    해당 클래스의 객체를 생성하지 않고도, 클래스 이름만으로 호출할 수 있음
        일반 멤버 함수의 호출 : 객체이름.멤버함수이름();
        정적 멤버 함수의 호출 : 클래스이름.멤버함수이름();
   - 정적 멤버 함수의 선언 : static 키워드 사용
    1 객체를 생성하지 않고 클래스 이름만으로 호출할 수 있음
    2 객체를 생성하지 않으므로, this 포인터를 가지지 않음
    3 특정 객체와 결합하지 않으므로, 정적 멤버 변수밖에 사용할 수 없음
*/
#include <iostream>
using namespace std;

class Person{
private:
	string name_;
	int age_;
public:
	static int person_count_;	// 정적 멤버 변수의 선언 
	static int person_count();	// 정적 멤버 함수의 선언 
    // 정적 멤버 변수인 person_count_의 값을 출력하기 위해서 정적 멤버 함수 person_count()를 선언
	Person(const string& name, int age);	// 생성자 
	~Person() { person_count_--; }			// 소멸자 
	void ShowPersonInfo();
};

int Person::person_count_ = 0;	// 정적 멤버 변수의 정의 및 초기화 

int main(void){
	Person hong("길동", 29);
	Person lee("순신", 35);
	cout << "현재까지 생성된 총 인원 수는 " << Person::person_count() << "명" << endl;
	
	return 0;
}

Person::Person(const string& name, int age){
	name_ = name;
	age_ = age;
	cout << ++person_count_ << " 번째 사람이 생성되었음" << endl;
}

void Person::ShowPersonInfo(){
	cout << "이 사람의 이름은 " << name_ << "이고, 나이는 " << age_ << "살" << endl;
}

int Person::person_count(){		// 정적 멤버 함수의 정의 
	return person_count_;
}

/**
 * - 상수 멤버 변수 : 한 번 초기화하면, 그 값을 변경할 수 없는 멤버 변수를 의미
        const 타입 멤버변수이름;
   - 클래스 전체에 걸쳐 사용되는 중요한 상수는 상수 멤버 변수로 정의하여 사용하는 것이 좋음
*/
/**
 * - 상수 멤버 함수 : 호출한 객체의 데이터를 변경할 수 없는 멤버 함수를 의미
        함수의원형 const;
   - 호출한 객체의 데이터를 단순히 읽기만 하는 멤버 함수는 상수 멤버 함수로 정의하는 것이
    정보 보호 측면에서도 좋음
*/