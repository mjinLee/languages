/**
 * - 생성자(constructor) : 객체의 생성과 동시에 멤버 변수를 초기화해줌; 클래스 생성자의
 * 이름은 해당 클래스 이름과 같음
 *  1 생성자는 초기화를 위한 데이터를 인수로 전달받을 수 있음
 *  2 생성자는 반환값이 없지만, void형으로 선언하지 않음
 *  3 객체를 초기화하는 방법이 여러 개 존재할 경우에는 오버로딩 규칙에 따라 여러 개의 
 *  생성자를 가질 수 있음
 * - 클래스의 생성자는 어떠한 반환값도 명시하지 않음
 *   => 클래스의 생성자 원형
 *       Book(const string& title, int total_page);
 * - 클래스 생성자의 원형은 클래스 선언의 public 영역에 포함되어야 함
 *   => 클래스의 생성자 원형에 따라 생성자 함수 선언
 *       Book::Book(const string& title, int total_page){
 *           title_ = title; // 책 제목 초기화
 *           total_page_ = total_page; // 책의 총 페이지 초기화
 *           current_page_ = 0; // 현재 페이지를 0으로 초기화
 *           set_percent(); // 총 페이지와 현재 페이지로 해당 책을 읽은 정도를 초기화
 *       }
 * - 생성자의 호출 : 클래스에서 객체를 생성할 때마다 해당 클래스의 생성자가 컴파일러에
 * 의해 자동으로 호출됨
 *   => int main(void) {
            Book web_book("HTML과 CSS", 350); // 생성자의 암시적 호출
            //Book web_book = Book("HTML과 CSS", 350); // 생성자의 명시적 호출
            // 생성자가 호출되어 멤버 변수인 percent_가 초기화되었는지를 확인
            cout << web_book.percent_;
            return 0;
        }
        Book::Book(const string& title, int total_page) {
            title_ = title;
            total_page_ = total_page;
            current_page_ = 0;
            set_percent();
        }
        void Book::set_percent() {
            percent_ = (double) current_page_ / total_page_ * 100;
        }
     => 생성자가 호출되었는지를 멤버 변수 percent_의 초기화 여부로 확인
     => 멤버 변수 percent_는 생성자에 포함된 private 멤버 함수인 set_percent() 함수에
      의해서만 0으로 초기화되기 때문
*/