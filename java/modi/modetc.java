package modi;

/**
 * - final 제어자 : 변경할 수 없다는 의미로 사용; 즉, 필드나 지역변수에 사용하면 값을 변경할 수 
 *  없는 상수(constant)가 됨; 클래스에 사용하면 해당 클래스는 다른 클래스가 상속받을 수
 *  없게 됨; 메소드에 사용하면 해당 메소드는 오버라이딩(overriding)을 통한 재정의를 할 수 없음
 * - final 제어자를 사용할 수 있는 대상 : 클래스, 메소드, 필드, 지역변수
 * - java에서는 다른 클래스의 private 멤버를 제외한 모든 메소드를 상속받을 수 있음
 * - method overriding : 상속받은 부모 클래스의 메소드를 재정의하여 사용하는 것 
 */
final class Car{ // 이 클래스는 상속을 통해 서브 클래스를 생성할 수 없음
    final int VAR = 0; // 이 필드는 상수화되어 값을 변경할 수 없음 
    final void brake(){ // 이 메소드는 오버라이딩을 통해 재정의할 수 없음
        final double MAX_NUM = 10.2; // 이 지역변수는 상수화되어 값 변경 불가
    }
}

/**
 * - static 제어자 : 공통적인 이라는 의미로 사용; 즉, 변수에 사용하면 해당 변수를 클래스 변수로
 *  만들어줌; 메소드에 사용하면 해당 메소드를 클래스 메소드로 만들어줌; 초기화 블록에도 사용가능
 * - 프로그램 시작시 최초에 단 한 번만 생성되고 초기화됨
 * - 인스턴스를 생성하지 않고도 바로 사용가능
 * - 해당 클래스의 모든 인스턴스가 공유함
 * => static 제어자를 사용할 수 있는 대상 : 메소드, 필드, 초기화 블록
 */
class Cat{
    static int var; // 클래스 필드(static 변수)
    static { // static 초기화 블록
        // 보통 클래스 필드의 초기화를 진행함
    }
    static void cute(){ // 클래스 메소드(static 메소드)
        
    }
}

/**
 * - abstract 제어자 : 추상적인 이라는 의미로 사용; 선언부만 있고 구현부가 없는 메소를 
 *  추상 메소드라 하며, 반드시 abstract 제어자를 붙여야 함; 하나 이상의 추상 메소드가 포함하고
 *  있는 추상 클래스도 반드시 abstract 제어자를 붙여야 함
 * => abstract 제어자를 사용할 수 있는 대상 : 클래스, 메소드
 */
abstract class Dog{ // 추상 클래스
    abstract void brave(); // 추상 메소드
}

/**
 * - 제어자의 조합 : 함께 사용할 수 있는 제어자
 * 클래스 - public,(default),final,abstract
 * 메소드 - 모든 접근 제어자,final,static,abstract
 * 필드 - 모든 접근 제어자,final,static
 * 지역변수 - final
 * 초기화블록 - static
 * - 클래스에 final과 abstract는 함께 사용 X
 * - 메소드에 static과 abstract는 함께 사용 X
 * - 메소드에 private과 abstract는 함께 사용 X
 * - 메소드에 pirvate과 final은 함께 사용 X
 */

public class modetc {
    public static void main(String[] args) {
        
    }
}
