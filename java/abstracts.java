// 다형성(polymorphism)
// - 참조 변수의 타입 변환
class Parent { }
class Child extends Parent{ }
class Brother extends Parent{ }

/**
 * - 추상 메소드(abstract method) : 자식 클래스에서 반드시 오버라이딩해야만 사용 가능;
 *  추상 메소드가 포함된 클래스를 상속받는 자식 클래스는 반드시 추상 메소드를 구현해야
 *  => abstract 반환타입 메소드이름();
 * - 추상 클래스 : 하나 이상의 추상 메소드를 포함하는 클래스; 반드시 사용되어야 하는
 *  메소드를 추상 클래스에 추상 메소드로 선언해 놓으면, 이 클래스를 상속받는 모든
 *  클래스에서는 이 추상 메소드를 반드시 재정의해야 함
 *  => abstract class 클래스이름 {
 *      abstract 반환타입 메소드이름();
 *  }
 * - 추상 클래스는 동작이 정의되어 있지 않은 추상 메소드를 포함하고 있으므로, 
 *  인스턴스를 생성할 수 없음; 먼저 상속을 통해 자식 클래스를 만드록, 만든 자식 클래스
 *  에서 추상클래스의 모든 추상메소드를 오버라이딩하고 나서 자식 클래스의 인스턴스를
 *  생성할 수 있음
 *  => 추상클래스는 추상 메소드를 포함하고 있다는 점을 제외하면, 일반 클래스와 모든
 *   점이 같음. 즉, 생성자, 필드, 일반 메소드도 포함할 수 있음
 */
abstract class Animal{ abstract void cry(); }
class Cat extends Animal{ void cry(){ System.out.println("야옹"); } }
class Dog extends Animal{ void cry(){ System.out.println("멍멍"); } }

public class abstracts {
    public static void main(String[] args) {
        // 참조 변수의 타입 변환
        Parent pa01 = null;
        Child ch = new Child();
        Parent pa02 = new Parent();
        Brother br = null;

        pa01 = ch; // pa01 = (Parent)ch; // 타입 변환 생략 가능
        br = (Brother)pa02; // 타입 변환 생략할 수 없음
        //br = (Brother)ch; // 직접적인 상속관계가 아니므로, 불가

        // instanceof
        System.out.println(pa01 instanceof Object); // true
        System.out.println(pa01 instanceof Parent); // true
        System.out.println(pa01 instanceof Child); // false
        
        Parent c = new Child();
        System.out.println(pa01 instanceof Object); // true
        System.out.println(pa01 instanceof Parent); // true
        System.out.println(pa01 instanceof Child); // true

        // 추상 클래스와 추상 메소드
        //Animal a = new Animal(); // 추상클래스는 인스턴스를 생성할 수 없음
        Cat myc = new Cat();
        Dog myd = new Dog();
        myc.cry(); myd.cry();
    }
}
