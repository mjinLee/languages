/**
 * - 정적 멤버 변수(static member variable) : 정적 멤버는 클래스에는 속하지만, 객체 별로
  할당되지 않고 클래스의 모든 객체가 공유하는 멤버를 의미; 멤버 변수가 정적(static)으로 
  선언되면, 해당 클래스의 모든 객체에 대해 하나의 데이터만이 유지 관리됨; 정적 멤버 변수는 
  클래스 영역에서 선언되지만, 정의는 파일 영역에서 수행; 외부 연결(external linkage)을 
  가지므로, 여러 파일에서 접근할 수 있음
  - 정적 멤버 변수에도 클래스 멤버의 접근 제한 규칙이 적용되므로, 클래스의 멤버 함수나 
  프렌드만이 접근할 수 있음; 하지만 정적 멤버 변수를 외부에서도 접근할 수 있게 하고 싶으면, 
  정적 멤버 변수를 public 영역에 선언하면 됨
*/
// 모든 Person 객체가 같이 공유하는 person_count_라는 정적 멤버 변수를 선언하는 예제
#include <iostream>
using namespace std;

class Person{
private:
	string name_;
	int age_;
public:
	static int person_count_;	// 정적 멤버 변수의 선언 
    // - 이 정적 멤버는 Person 객체가 생성될 때마다 1씩 증가하여, 현재까지 총 몇 개의 
    // Person 객체가 생성되었는지를 알려줌
	Person(const string& name, int age);	// 생성자 
	~Person() { person_count_--; }			// 소멸자 
	void ShowPersonInfo();
};

int Person::person_count_ = 0;	// 정적 멤버 변수의 정의 및 초기화 

int main(void){
	Person hong("길동", 29);
	hong.ShowPersonInfo();
	Person lee("순신", 35);
	lee.ShowPersonInfo();
	
	return 0;
}

Person::Person(const string& name, int age){
	name_ = name;
	age_ = age;
	cout << ++person_count_ << " 번째 사람이 생성되었음" << endl;
}

void Person::ShowPersonInfo(){
	cout << "이 사람의 이름은 " << name_ << "이고, 나이는 " << age_ << endl;
}