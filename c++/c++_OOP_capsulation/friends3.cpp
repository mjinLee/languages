/**
 * - 프렌드 멤버 함수 : 프렌드 클래스란 해당 클래스의 모든 멤버 함수가 특정 클래스의 프렌드
   가 됨; 하지만 멤버 함수에 따라 특정 클래스의 프렌드 설정이 필요 없는 멤버 함수도 있음;
   예제에서 ShowDiagonal() 함수는 Rect 클래스의 private 멤버에 직접 접근하도록 구현; 하지만
   ShowSize() 함수는 Rect 클래스의 public 인터페이스만으로 구현되어 있음; 따라서 Display 
   클래스에서 Rect 클래스에 대해 프렌드 설정이 필요한 함수는 ShowDiagonal() 함수뿐임;
   이처럼 프렌드 멤버 함수란 해당 클래스의 특정 멤버 함수만을 프렌드로 지정하는 것을 의미;
   이것은 프렌드 설정이 꼭 필요한 함수에 대해서만 접근을 허락하므로, 정보 은닉(data hiding) 
   및 캡슐화(encapsulation) 개념에 더욱 가깝게 구현할 수 있게 됨 
*/
#include <iostream>
#include <cmath>
using namespace std;

class Rect;

class Display{
public:
	void ShowSize(const Rect& target);
	void ShowDiagonal(const Rect& target);
};

class Rect{
private:
	double height_;
	double width_;
public:
	Rect(double height, double width);	// 생성자 
	void height() const;
	void width() const;
	friend void Display::ShowDiagonal(const Rect& target);	// 프렌드 멤버 함수 선언 
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
	cout << "이 사각형의 높이는 " << this->height_ <<endl;
}

void Rect::width() const{
	cout << "이 사각형의 너비는 " << this->width_ <<endl;
}

void Display::ShowSize(const Rect& target){
	target.height();
	target.width();
}

void Display::ShowDiagonal(const Rect& target){
	double diagonal;
	diagonal = sqrt(pow(target.height_, 2) + pow(target.width_, 2));
	
	cout << "이 사각형의 대각선의 길이는 " << diagonal <<endl;
}

/**
 * - 전방 선언(forward declaration) : Rect 클래스는 Display 클래스를 참조하고, Display
  클래스는 Rect 클래스를 참조하고 있음; 두 클래스의 선언 내에서 서로를 참조하고 있는 상황을
  순환 참조(circular reference)라고 함; 이러한 순환 참조를 피하기 위해서는 한 클래스를 
  다른 클래스의 앞에 미리 선언하는 전방 선언(forward declaration)을 사용해야 함
        class 클래스이름;
   - 위의 예제에서는 순환 참조를 피하고자 Rect 클래스를 전방 선언하였음; 또한, 프렌드 멤버 
   함수를 선언할 때에는 각 클래스의 선언 위치도 신경 써야 함; 앞선 예제에서는 Rect 클래스와
   Display 클래스를 다음과 같은 순서로 선언하였음
        class Rect;          // 전방 선언
        class Display {...}; // Display 클래스 선언
        class Rect {...};    // Rect 클래스 선언
   - 만약 다음과 같이 순서를 바꾸면 컴파일러는 오류를 발생시킬 것임
        class Display;       // 전방 선언
        class Rect {...};    // Rect 클래스 선언
        class Display {...}; // Display 클래스 선언
    => Rect 클래스 내에서 ShowDiagonal() 함수가 프렌드로 선언된 것을 처리하기 전에, 
    컴파일러는 이미 ShowDiagonal() 함수의 선언을 알고 있어야만 함; 따라서 순서를 바꾸게 
    되면 컴파일러는 프렌드로 선언된 ShowDiagonal() 함수를 알지 못하므로, 오류를 발생시킴
*/