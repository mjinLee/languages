/**
 * - 클래스 상속(class inheritance) : 기존에 정의되어 있는 클래스의 모든 멤버 변수와 멤버
   함수를 물려받아, 새로운 클래스를 작성하는 것을 의미
   - 기존에 정의되어 있던 클래스를 기초 클래스(base class) 또는 부모 클래스(parent class), 
   상위 클래스(super class)
   - 상속을 통해 새롭게 작성되는 클래스를 파생 클래스(derived class) 또는 자식 클래스
   (child class), 하위 클래스(sub class)
   - 상속은 기존에 작성된 클래스를 재활용할 수 있음; 공통적인 부분은 기초 클래스에 미리
   작성하여, 파생 클래스에서 중복되는 부분을 제거할 수 있음
   - 파생 클래스(derived class) : 기초 클래스의 모든 특성을 물려받아 새롭게 작성된 클래스
        class 파생클래스이름 : 접근제어지시자 기초클래스이름[,접근제어지사자 기초클래스이름, ..]{
            // 파생 클래스 멤버 리스트
        }
   - 접근 제어 지시자는 기초 클래스의 멤버를 사용할 수 있는 파생 클래스의 접근 제어 권한을 설정함;
   이때 접근 제어 지시자를 생략하면, 파생 클래스의 접근 제어 권한은 private으로 기본 설정됨
   - 쉼표(,)를 사용하여 상속받을 기초 클래스를 여러 개 명시할 수 있음; 이때 파생 클래스가
   상속받는 기초 클래스가 하나이면 단일 상속, 여러 개이면 다중 상속이라고 함
   - 파생 클래스의 특징)
    1 반드시 자신만의 생성자를 작성해야 함
    2 기초 클래스의 접근할 수 있는 모든 멤버 변수들이 저장됨
    3 기초 클래스의 접근할 수 있는 모든 멤버 함수를 사용할 수 있음
    4 필요한 만큼 멤버를 추가할 수 있음
   - 파생 클래스의 생성자는 기초 클래스의 생성자를 사용하고 있음; 파생 클래스의 생성자가 
   기초 클래스의 private 멤버에 접근할 수 없기 때문; 따라서 기초 클래스의 생성자를 사용
   해야만 기초 클래스의 private 멤버를 초기화할 수 있음; 이때 기초 클래스의 생성자를 명시
   하지 않으면, 프로그램은 기초 클래스의 디폴트 생성자를 사용하게 됨
   - 파생 클래스의 객체가 생성되는 순서)
    1 파생 클래스의 객체를 생성하면, 프로그램은 제일 먼저 기초 클래스의 생성자를 호출함;
     이때 기초 클래스 생성자는 상속받은 멤버 변수의 초기화를 진행함
    2 파생 클래스의 생성자가 호출됨
    3 반대로 파생 클래스의 수명이 다하면, 먼저 파생 클래스의 소멸자가 호출되고, 그 후에 
     기초 클래스의 소멸자가 호출됨
*/
#include <iostream>
using namespace std;

class Person {
private:
	string name_;
	int age_;
public:
	Person(const string& name, int age);	// 기초 클래스 생성자의 선언 
	void ShowPersonInfo();
};

class Student : public Person { // Person 클래스를 상속받는 Student 클래스
private:
	int student_id_;
public:
	Student(int sid, const string& name, int age);	// 파생 클래스 생성자의 선언 
};

int main(void){
	Student hong(123456789, "길동", 29);
	hong.ShowPersonInfo();
	
	return 0;
}

Person::Person(const string& name, int age)	{ // 기초 클래스 생성자의 정의 
	name_ = name;
	age_ = age;
}

void Person::ShowPersonInfo(){
	cout << name_ << "의 나이는 " << age_ << "살" << endl;
}

Student::Student(int sid, const string& name, int age) : Person(name, age){	// 파생 클래스 생성자의 정의 
	student_id_ = sid;
}