#include<iostream>
using namespace std;
/**
 * - 프렌드(friend) : 객체의 private 멤버는 해당 객체의 public 멤버 함수를 통해서만 접근할
 * 수 있음; 경우에 따라서는 해당 객체의 멤버 함수가 아닌 함수도 private 멤버에 접근해야만
   할 경우가 발생함; 매번 private 멤버에 접근하기 위한 새로운 public 멤버 함수를 작성하는
   것은 매우 비효율적 => friend 라는 새로운 접근 제어 키워드 제공
   - 프렌드는 지정한 대상에 한해 해당 객체의 모든 멤버에 접근할 수 있는 권한을 부여해줌
   - 전역함수, 클래스, 멤버함수의 형탤 사용할 수 있음
   - 프렌드 함수 선언 : friend 클래스이름 함수이름(매개변수목록)
   - 프렌드 함수는 클래스 선언부에 그 원형이 포함되지만, 클래스의 멤버 함수는 아님; 멤버
   함수와 같은 접근 권한을 가짐; friend 키워드는 함수의 원형에서만 사용해야 하며, 함수의
   정의에서는 사용하지 않음
   - 프렌드 선언은 클래스 선언부의 public, private, protected 영역 등 어디에나 위치할 수
   있으며, 위치에 따른 차이는 전혀 없음
   - 프렌드의 필요성 : 이항 연산자를 오버로딩할 때 프렌드의 필요성이 자주 발생; 멤버함수는
   왼쪽 피연산자인 객체가 호출하는 형태이므로, 이항 연산자의 매개변수 순서나 타입에 민감;
   멤버 함수가 아닌 함수를 사용하면 해당 객체의 private 멤버에 접근할 수 없게 됨; 이때
   사용하는 것이 프렌드
        Rect Rect::operator*(double mul) const {
            return Rect(height_*mul, width_*mul);
        } // 사각형을 나타내는 Rect 클래스를 정의하면서, 크기를 조절하기 위해 곱셈 연산자(*)를
         오버로딩하는 예제
         => 
*/
class Rect{
private:
	double height_;
	double width_;
public:
	Rect(double height, double width);	// 생성자 
	void DisplaySize();
	Rect operator*(double mul) const;
    // 멤버함수 원형의 맨 마지막에 const 키워드를 추가하면, 멤버 함수를 상수 멤버로 정의할 수 있음
    // 상수 멤버 함수란 자신이 호출하는 객체를 수정하지 않는 읽기 전용 함수
    friend Rect operator*(double mul, const Rect& origin); // 프렌드 함수
};

/*int main(void){
	Rect origin_rect(10, 20);
	Rect changed_rect = origin_rect * 2;
	// Rect changed_rect = 3 * origin_rect;	// 피연산자의 순서를 바꾸어 실행하면 오류발생
    // 멤버함수는 왼쪽 피연산자인 객체가 호출하는 형태가 되어야 하기 때문
    // 두 구문이 모두 정상 작동하기 위해서는 매개변수의 순서가 다른 operator*() 함수를
    // 객체가 호출하지 않는 전역함수로 작성해야 함
    // 그 전역함수가 private 멤버인 height_와 width_에 접근하기 위해서는 friend 키워드를 추가해야 함  
	changed_rect.DisplaySize();
	return 0;
}*/
int main(void){
	Rect origin_rect(10, 20);
	Rect rect01 = origin_rect * 2;
	Rect rect02 = 3 * origin_rect;
	
	rect01.DisplaySize();
	rect02.DisplaySize();
	return 0;
}

Rect::Rect(double height, double width){
	height_ = height;
	width_ = width;
}

void Rect::DisplaySize(){
	cout << "이 사각형의 높이는 " << this->height_ << "이고, 너비는 " << this->width_ << endl;
}

Rect Rect::operator*(double mul) const {
	return Rect(height_ * mul, width_ * mul);
}

Rect operator*(double mul, const Rect& origin){
	return origin * mul;
}