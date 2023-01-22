/**
 * - 상속
 * - 자식 클래스는 부모 클래스의 필드와 메소드만이 상속되며, 생성자와 초기화 블록은 
 *  상속되지 않음; 부모 클래스의 접근 제어가 private이나 default로 설정된 멤버는
 *  자식 클래스에서 상속받지만 접근할 수는 없음
 */
class Parent { // 부모 클래스
    private int a =10;
    public int b=20;
}
class Child extends Parent { // 자식 클래스
    public int c =30;
    void display(){
        //System.out.println(a); // 상속받은 private 필드 참조 -> 불가
        System.out.println(b); // 상속받은 public 필드 참조
        System.out.println(c); // 자식 클래스에서 선언한 public 필드 참조
    }
}

/**
 * - Object 클래스 : 모든 클래스의 부모 클래스가 되는 클래스; 자바의 모든 클래스는
 *  자동으로 Object 클래스의 모든 필드와 메소드를 상속받게 됨
 * - 별도로 extends 키워드를 사용하여 Object 클래스의 상속을 명시하지 않아도
 *  Object 클래스의 모든 멤버를 자유롭게 사용할 수 있음
 */

/**
 * - super 키워드 : 부모 클래스로부터 상속받은 필드나 메소드를 자식 클래스에서 참조하는
 *  데 사용하는 참조 변수
 * - 인스턴스 변수의 이름과 지역 변수의 이름이 같을 경우 인스턴스 변수 앞에 this 
 *  키워드를 사용하여 구분할 수 있었음
 * - 부모 클래스의 멤버와 자식 클래스의 멤버 이름이 같을 경우 super 키워드를 사용하여
 *  구별할 수 있음
 * - => super 참조 변수를 사용하여 부모 클래스의 멤버에 접근할 수 있음; this와 
 *   마찬가지로 super 참조 변수를 사용할 수 있는 대상도 인스턴스 메소드뿐이며,
 *   클래스 메소드에서는 사용할 수 없음
 */
class P { int a = 10; }
class C extends P {
    int a = 20;
    void dis(){
        System.out.println(a); // 20
        System.out.println(this.a); // 20
        System.out.println(super.a); // 10
    }
}

/**
 * - super() 메소드 : this() 메소드가 같은 클래스의 다른 생성자를 호출할 때 사용된다면,
 *  super() 메소드는 부모 클래스의 생성자를 호출할 때 사용
 * - 부모 클래스의 생성자를 명시적으로 호출하지 않는 모든 자식 클래스의 생성자 첫 줄에
 *  super(); 를 추가하여, 부모 클래스의 멤버를 초기화할 수 있게됨
 */
class Parent1 {
    int a;
    Parent1(){ a = 10; }
    Parent1(int n){ a = n; }
}
class Child1 extends Parent1 {
    int b;
    Child1(){
        super();
        //super(40); // n = 40 으로 초기화되어 a 변수에 40이 들어감
        b=20;
    }
    void see(){
        System.out.println(a);
        System.out.println(b);
    }
}

public class inheritance {     
    public static void main(String[] args) {
        // 상속
        Child ch = new Child();
        ch.display();

        // super
        C c = new C();
        c.dis();

        // super()
        Child1 ch1 = new Child1();
        ch1.see();
    }
}