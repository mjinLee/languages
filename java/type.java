/**
 * variable
 * 
 */

public class type {
    //** 변수 이름 생성 규칙 */
    /*
    * 변수는 이름을 가지고 있는 메모리 공간
    * 영문자(대소문자), 숫자, 언더스코어(_), 달러($)로만 구성
    * 숫자로 시작할 수 없음
    * 변수 이름 사이에는 공백을 포함할 수 없음
    * 미리 정의된 키워드는 사용할 수 없음
    * 기본형 변수
    * - 정수형 byte short int long
    * - 실수형 float double
    * - 문자형 char
    * - 논리형 boolean
    */
    int num1, num2;
    double num3 = 3.14;
    double num4 = 1.23, num5 = 3.45;
    double nu1,nu2;
    //nu1=1.23, nu2=3.4; // Syntax error; 이미 선언된 여러 변수를 동시에 초기화 불가

    /** 상수 */
    /* 
     * 상수도 이름을 가지고 있는 메모리 공간
     * 상수는 선언과 동시에 반드시 초기화해야 함; c++(const), java(final)
     * 상수의 이름은 일반적으로 모두 대문자를 사용하여 선언
     * 여러 단어로 이루어진 이름의 경우 언더스코어(_) 사용하여 구분함
     */ 
    final int AGES = 3;

    // 리터럴(literal)은 그자체로 값을 의미; 데이터가 저장된 메모리 공간을 가리키는 이름 X
    int var = 30; // 30 이 바로 리터럴
    final int AGES2 = 100; // 100 이 리터럴
    /*
     * 정수형 : 123, -456 ..  byte(1 byte), short(2), int(4), long(8)
     * 실수형 : 3.14, -23.4 .. float(4), double(8)
     * 논리형 : true, false  boolean(1)
     * 문자형(char) : 'a', 'Z' .. char(2) 
     * 문자열(string) : "java", "자바"
     * null : null
     * - 3.14와 같은 실수형 리터럴을 그대로 사용하면, 해당 리터럴은 실수형 타입 중에서도
     * double형으로 인식할 것. 하지만 실수형 리터럴 맨 뒤에 F나 f를 추가하면, 해당 실수형
     * 리터럴을 float형으로 인식
     *  - L 또는 l : long 형 ex. 12345L ..
     *  - F 또는 f : float 형 ex. 1.234F, 4.3f ..
     *  - D 또는 d : double 형 ex. 1.34D, 2.46d ..
     */
    
    public static void main(String[] args) {
        
        
    }
}
