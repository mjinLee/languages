/**
 * - 프렌드 클래스 : 두 클래스가 기능상으로 서로 밀접한 관계에 있고, 상대방의 private 멤버에
  접근해야만 한다면 클래스 자체를 프렌드로 선언하는 것이 좋음; 프렌드 클래스란 해당 클래스의
  모든 멤버 함수가 특정 클래스의 프렌드인 클래스를 의미
        friend class 클래스이름;

        friend class Display; // Display 클래스의 모든 멤버 함수는 Rect 클래스에 대한 
         프렌드 접근 권한을 부여받게 됨; 즉, Display 클래스의 모든 멤버 함수는 Rect 클래스
         의 모든 멤버에 접근할 수 있음   
*/
#include <iostream>
#include <cmath>
using namespace std;

class Rect{
private:
	double height_;
	double width_;
public:
	Rect(double height, double width);	// 생성자 
	void height() const;
	void width() const;
	friend class Display;	// 프렌드 클래스 선언 
};

class Display{
public:
	void ShowSize(const Rect& target);
	void ShowDiagonal(const Rect& target);
};

int main(void){
	Rect rect01(10, 20);
	
	Display rect_display;
	rect_display.ShowSize(rect01);
	rect_display.ShowDiagonal(rect01);
	
	return 0;
}

Rect::Rect(double height, double width){
	height_ = height;
	width_ = width;
}

void Rect::height() const{
	cout << "이 사각형의 높이는 " << this->height_ << endl;
}

void Rect::width() const{
	cout << "이 사각형의 너비는 " << this->width_ << endl;
}

void Display::ShowSize(const Rect& target){
	target.height();
	target.width();
}

void Display::ShowDiagonal(const Rect& target){
	double diagonal;
	diagonal = sqrt(pow(target.height_, 2) + pow(target.width_, 2));
    // cmath 헤더 파일에 포함된 sqrt() 함수는 제곱근을, pow(a,b)는 a의 b승(ab) 값을 구해주는 함수
	
	cout << "이 사각형의 대각선의 길이는 " << diagonal << endl;
}