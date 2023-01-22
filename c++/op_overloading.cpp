/**
 * - 연산자 오버로딩(operator overloading) : 하나의 연산자를 여러 의미로 사용할 수 있음;
 * 사용자 정의 타입까지 확장할 수 있으며, 클래스도 하나의 타입임을 확실히 보여줌
 * - 연산자 함수 : 연산자를 오버로딩하기 위해 연산자 함수를 사용
 *      operator오버로딩할연산자(매개변수목록) // operator 키워드 사용, 공백 없이 연결
 * - 연산자 함수는 복잡한 함수 이름 대신 간편하게 연산자를 사용할 수 있음
 *      Position Position::operator-(const Position& other){
 *          return Position((x_+other.x_)/2,(y_+other.y_)/2);
 *      } // 두 지점의 중간 지점의 좌표를 구하는 예제
 *      => 뺄셈 연산자(-)를 두 Position 객체 사이의 중간 좌표를 구하는 연산으로 오버로딩
 *      => 연산자 오버로딩을 하지 않으면 컴파일러는 두 Position 객체의 뺄셈 연산은 지원
 *        하지 않는다며 오류를 발생시킬 것
 * - 연산자 함수의 정의)
 *  1 클래스의 멤버 함수로 정의하는 방법
 *  2 전역 함수로 정의하는 방법
 *  - 이 두 방법의 차이는 인수의 개수뿐만 아니라 private 멤버에 대한 접근 여부도 있음;
 *   연산자 함수를 전역 함수로 정의해야 할 경우, private 멤버에 대한 접근을 위해 C++에서
 *   제공하는 프렌드 함수를 사용할 수 있음
 *      Position Position::operator-(const Position& pos1, const Position& pos2){
 *          return Position((pos1.x_+pos2.x_)/2,(pos1.y_+pos2.y_)/2);
 *      } // 뺄셈 연산자의 오버로딩 예제를 전역 함수로 정의한 예제
 *      => 전역 함수는 private 멤버인 x_와 y_에 접근하지 못하므로, friend 키워드를
 *        사용하여 프렌드 함수로 선언하고 있음
 * 
*/
#include <iostream>
using namespace std;

class Position{
private:
	double x_;
	double y_;
public:
	Position(double x, double y);	// 생성자 
	void Display();
	Position operator-(const Position& other);	// - 연산자 함수 
};

int main(void){
	Position pos1 = Position(3.3, 12.5);
	Position pos2 = Position(-14.4, 7.8);
	Position pos3 = pos1 - pos2;
	
	pos3.Display();
	return 0;
}

Position::Position(double x, double y){
	x_ = x;
	y_ = y;
}

Position Position::operator-(const Position& other){
	return Position((x_ + other.x_)/2, (y_ + other.y_)/2);
}

void Position::Display(){
	cout << "두 지점의 중간 지점의 좌표는 x좌표 : " << this->x_ << ", y좌표 : " << this->y_ << endl;
}