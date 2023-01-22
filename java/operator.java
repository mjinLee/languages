
// instanceof 연산자
class A {}
class B extends A{}

public class operator {   

    public static void main(String[] args) {
        // 삼항 연산자(ternary operator) : 피연산자를 세 개 가지는 조건 연산자
        int n1=5, n2=7;
        int res;
        res = (n1 - n2 > 0) ? n1 : n2;
        System.out.println("두 정수 중 더 큰 수는 "+res+"임"); // 7   
        
        // instanceof 연산자 : 참조 변수가 참조하고 있는 인스턴스의 실제 타입을 반환
        // 해당 객체가 어떤 클래스나 인터페이스로부터 생성되었는지를 판별해줌
        // 인스턴스이름 instanceof 클래스또는인터페이스이름
        A a = new A();
        B b = new B();
        System.out.println(a instanceof A); // true
        System.out.println(b instanceof A); // true
        System.out.println(a instanceof B); // false
        System.out.println(b instanceof B); // true
    }
}
