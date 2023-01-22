package APIclass;
/**
 * - wrapper 클래스 : 프로그램에 따라 기본 타입의 데이터를 객체로 취급해야 하는 경우가 있음
 * 예를 들어, 메소드의 인수로 객체 타입만이 요구되면, 기본 타입의 데이터를 그대로 사용할 수
 * 없음. 이때에는 기본 타입의 데이터를 먼저 객체로 변환한 후 작업을 수행해야 함
 * => 8개의 기본 타입에 해당하는 데이터를 객체로 포장해 주는 클래스를 래퍼 클래스라고 함.
 * => 각각의 타입에 해당하는 데이터를 인수로 전달받아, 해당 값을 가지는 객체로 만들어줌
 * - java.lang 패키지에 포함되어 제공
 * - 기본 타입 : byte short int long float double char boolean
 * - 래퍼 클래스 : Byte Short Integer Long Float Double Character Boolean
 * - 래퍼클래스는 산술 연산을 위해 정의된 클래스가 아니므로, 인스턴스에 저장된 값을 변경할
 * 수 없음. 단지, 값을 참조하기 위해 새로운 인스턴스를 생성하고, 생성된 인스턴스의 값만을
 * 참조할 수 있음
 * - 기본 타입의 데이터 -> 래퍼 클래스의 인스턴스로 변환 : 박싱(Boxing)
 * - 래퍼 클래스의 인스턴스에 저장된 값 -> 다시 기본 타입의 데이터로 꺼내는 과정 : 언박싱
 * - JDK 1.5부터는 박싱과 언박싱이 필요한 상황에서 자바 컴파일러가 자동으로 처리해줌; 이렇게
 * 자동화된 박싱과 언박싱을, 오토 박싱과 오토 언박싱이라고 부름
 */

public class wrapperClass {
    public static void main(String[] args) {
        // boxing, unboxing, auto boxing, auto unboxing
        Integer num = new Integer(17); // boxing
        int n = num.intValue(); // unboxing
        System.out.println(n); // 17

        Character ch = 'X'; // Character ch = new Character('X'); // auto boxing
        char c = ch; // char c = ch.charValue(); // auto unboxing
        System.out.println(c); // X

        // auto boxing과 auto unboxing을 통해 기본 타입과 래퍼 클래스 간의 연산
        Integer num1 = new Integer(7); // 박싱
        Integer num2 = new Integer(3); // 박싱
        int int1 = num1.intValue();    // 언박싱
        int int2 = num2.intValue();    // 언박싱
        Integer result1 = num1 + num2; // 10 
        Integer result2 = int1 - int2; // 4
        int result3 = num1 * int2;     // 21
        // 내부적으로 래퍼 클래스인 피연산자를 오토언박싱하여 기본 타입끼리의 연산 수행

        // 래퍼클래스의 비교 연산도 오토언박싱을 통해 가능하지만,
        // 인스턴스에 저장된 값의 동등 여부 판단은 비교 연산자인 동등 연산자(==)를 사용해서는
        // 안 되며, equals() 메소드를 사용
        // 래퍼 클래스도 객체이므로 동등 연산자(==)를 사용하게 되면, 두 인스턴스의 값을 비교
        // 하는 것이 아니라 두 인스턴스의 주소값을 비교
        Integer n1 = new Integer(10);
        Integer n2 = new Integer(20);
        Integer n3 = new Integer(10);
        System.out.println(n1 < n2);       // true
        System.out.println(n1 == n3);      // false
        System.out.println(n1.equals(n3)); // true
        // 따라서 서로 다른 두 인스턴스를 동등 연산자(==)로 비교하게 되면,
        // 언제나 false 값을 반환
        // 그러므로 인스턴스에 저장된 값의 동등 여부를 정확히 판단하려면 equals() 메소드 사용
    }
}
