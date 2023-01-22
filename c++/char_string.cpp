#include<iostream>
#include<string>
using namespace std;
/**
 * - 문자열(string) : C언어 스타일의 문자열, string 클래스를 이용한 문자열
 * - C언어 스타일의 문자열 : C++에서는 큰따옴표("")를 사용해 표현되는 문자열을 문자열 상수
 * 라고 함; 해당 문자열이 이름을 가지고 있지 않으며, 문자열의 내용 또한 변경할 수 없기 때문;
 * C++에서 문자형 배열을 선언하면 이 배열이 곧 문자열 변수
 * - C++에서는 문자열 길이에 제한을 두지 않음
 * - 널(NULL) 문자 : 문자형 배열로 선언된 문자열 변수는 문자열의 끝(NULL문자;'\0';아스키코드값(0));
 * 널 문자 유무로 문자형 데이터 배열과 실제 문자열을 서로 구분; 문자열을 저장하기 위한
 * 문자형 배열을 선언할 때에는 반드시 널 문자까지 포함
 * - C++에서는 C언어 스타일의 문자열을 처리하기 위해 C 라이브러리의 문자열 처리 함수를 
 * 사용할 수 있음; cstring 헤더 파일을 포함해야 함
*/
/**
 * - string 클래스 : string 헤더파일 포함; string 클래스는 std 네임스페이스에 속해
 * 있으므로, using 지시자를 사용하거나 해당 네임스페이스를 참조해야 함
 * - 문자열 선언 시 길이가 0인 string 객체 생성 -> 문자열 초기화하면 문자열 길이를 자동으로
 * 조절 => 문자형 배열보다 편리, 안전
 * 
 * - string 메소드 : 문자열 처리 함수
 *  => length(), size(), append(), find(), compare(), replace(), capacity(), max_size()
*/

int main(){
    // 문자열 입력
    //const int SIZE = 20;
    //char addr[SIZE], name[SIZE];
    /*cout<<"이름 : ";
    cin>>name;
    cout<<"도시 : ";
    cin>>addr; */
    // => cin 객체는 띄어쓰기를 포함한 탭 문자, 캐리지 리턴 문자 등을 모두 문자열의 끝으로 인식
    // 띄어쓰기를 포함한 문자열을 전부 입력받으려면 cin 객체의 get() 메소드를 사용
    /*cout<<"이름 : ";
    cin.get(name,SIZE).get();
    cout<<"도시 : ";
    cin.get(addr,SIZE).get();*/
    // => 20바이트 이상의 이름을 입력할 경우, 도시명을 입력받지 못하는 문제점
    /*cout<<"이름 : ";
    cin.get(name,SIZE).ignore(SIZE,'\n');
    cout<<"도시 : ";
    cin.get(addr,SIZE).ignore(SIZE,'\n');*/
    // => 20바이트 이상의 문자열을 입력해도 20바이트까지만 받음
    // C언어 스타일의 문자열 입력에서는 입력할 문자열의 길이를 미리 알고 있어야 함
    // => C++에서 제공하는 string 클래스 이용
    string addr, name;
    cout<<"이름 : ";
    getline(cin,name);
    cout<<"도시 : ";
    getline(cin,addr);
    cout<<addr<<" 도시에 사는 "<<name<<" 님,"; 

    // string 클래스
    string dog;
    cout<<"변수 길이 : "<<dog.length()<<endl; // 0
    dog = "abcd";
    cout<<"변수 길이 : "<<dog.length()<<endl; // 4
    cout<<"첫 글자 : "<<dog[0]; // a
    // string 클래스의 length(),size() 메소드 : string 객체의 현재 길이를 알 수 있음

    // 문자열 처리
    // C언어 - 문자형 배열 사이의 대입 : strcpy(), strncpy()
    // C++ string객체 : 대입 연산자(=)
    string str1 = "C++ is language";
    string str2;
    str2=str1;
    cout<<str2; // C++ is language
    // 문자형 배열 사이의 추가나 결합 : strcat(), strncat()
    // string 객체 : 복합 대입 연산자(+=), append()
    string s1 = "C++ is";
    string s2 = "language";
    string s3;
    s3 = s1 + s2; // 문자열 결합
    cout << s3 << endl; // C++ is language
    s1 += s2; // 문자열 추가
    cout << s1 << endl; // C++ is language

    // 문자열 입출력
    // cin 객체는 한 단어 단위로 수행
    // 문자열을 한 행(line)씩 읽고 싶을 때는 getline() 사용
    string name, subject;
    cout << "이름 : ";
    getline(cin, name); // getline(cin객체, 문자열저장할string객체변수);
    cout << "좋아하는 과목 : ";
    getline(cin, subject);
    cout << name << "님이 좋아하는 과목은 " << subject << "입니다";

    // string method
    // length() : 문자열 길이
    // size() : string 객체가 메모리에서 실제 사용하고 있는 크기
    string st1;
    string st2 = "c++ programming";
    cout<<st1.length()<<endl; // 0
    cout<<st2.size()<<endl; // 15
    // append() : 하나의 문자열 끝에 다른 문자열 추가
    string st3,st4,st5;
    st3.append("c++ is language"); // c++ is language
    st4.append("C++ programming",4,7); // program
    st5.append(4,'X'); // XXXX
    // find() : 특정 문자열을 찾아, 그 시작 위치를 반환
    // 찾을 문자열을 찾지 못하면, string::size_type의 string::npos라는 상수를 반환
    // 정적 상수인 string::npos는 string 클래스에 static const size_type= -1 로 명시
    string str = "C++ Programming";
    cout << str.find("Pro") << endl; // 4
    cout << str.find('r') << endl; // 5
    if (str.find("Pro", 5) != string::npos){
        cout << "해당 문자열을 찾았습니다.";
    }else{
        cout << "해당 문자열을 찾지 못했습니다.";
    } // 해당 문자열을 찾지 못했습니다.
    // compare() : 두 문자열 간의 내용 비교
    /* compart() 메소드의 반환값이 참(true)이 되는 경우
        1 str1.compare(str2) == 0 // str1과 str2이 같을 경우
        2 str1.compare(str2) < 0  // str1이 str2보다 사전 편찬순으로 앞에 있을 경우
        3 str1.compare(str2) > 0  // str1이 str2보다 사전 편찬순으로 뒤에 있을 경우
    */
    string str3 = "ABC";
    string str4 = "ABD";
    if (str3.compare(str4) == 0){
        cout << str3 << "이 " << str4 << "와 같습니다.";
    } else if (str3.compare(str4) < 0){
        cout << str3 << "이 " << str4 << "보다 사전 편찬 순으로 앞에 있습니다.";
    } else{
        cout << str3 << "이 " << str4 << "보다 사전 편찬 순으로 뒤에 있습니다.";
    } // ABC가(이) ABD보다 사전 편찬 순으로 앞에 있습니다.
    // replace() : 특정 문자열을 찾아, 그 문자열을 다른 문자열로 대체
    // replace(대체할문자열의시작위치, 대체할문자열의길이, 새로운문자열);
    // replace() 메소드를 사용 전에 find() 메소드를 사용하여 해당 문자열 존재여부 파악
    string ss1 = "c++ is language";
    string ss2 = "cool";
    string ss3 = "awesome";
    string::size_type index = ss1.find(ss2);
    if(index != string::npos)
        ss1.replace(index,ss2.length(),ss3);
    cout << ss1; // c++ is language awesome
    // capacity() : 해당 문자열을 재대입(reallocation)받지 않고 저장할 수 있는 최대 문자열의 길이 반환
    // max_size() : 해당 문자열이 최대한 대입받으면 가질 수 있는 최대 문자열의 길이 반환
    string str = "C++ Programming";
    cout << "length : " << str.length() << endl; // 15
    cout << "capacity : " << str.capacity() << endl; // 15
    cout << "max_size : " << str.max_size(); // 2147483647


    return 0;
}