/**
 * - 인터페이스 : 다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서, 다른 클래스
 *  사이의 중간 매개 역할까지 하는 담당하는 일종의 추상 클래스를 의미
 * - 인터페이스는 오로지 추상 메소드와 상수만을 포함할 수 있음
 * - 클래스와 달리 인터페이스의 모든 필드는 public static final, 모든 메소드는
 *  public abstract 이어야 함; 모든 인터페이스에 공통으로 적용되는 부분이므로 
 *  제어자는 생략 가능
 *  => 접근제어자 interface 인터페이스이름{
 *      public static final 타입 상수이름 = 값;
 *      public abstract 메소드이름(매개변수목록);
 *  } // 선언
 *  => class 클래스이름 implements 인터페이스이름 { } // 구현
 */
interface Animal { public abstract void cry(); }
class Cat implements Animal{
    public void cry(){
        System.out.println("야옹");
    }
}
class Dog implements Animal {
    public void cry(){
        System.out.println("멍멍");
    }
}

// - 상속과 구현을 동시에 할 수 있음. 인터페이스는 인터페이스로부터만 상속 받을 수 있으며,
// 여러 인터페이스를 상속받을 수 있음
// - 인터페이스를 사용한 다중 상속 예)
// Cats 클래스와 Dogs 클래스는 각각 Animals와 Pet이라는 두 개의 인터페이스를 동시에 구현
interface Animals { public abstract void crying(); }
interface Pet { public abstract void playing(); }
class Cats implements Animals, Pet{
    public void crying(){
        System.out.println("야옹야옹");
    }
    public void playing(){
        System.out.println("놀자");
    }
}
class Dogs implements Animals, Pet{
    public void crying(){
        System.out.println("멍멍멍멍");
    }
    public void playing(){
        System.out.println("산책");
    }
}

// 클래스를 이용하여 다중 상속을 하면 메소드 출처의 모호성 등의 문제발생 우려
// 인터페이스를 이용하여 다중 상속하게 되면, 메소드 호출의 모호성 방지
interface Ani { public abstract void cr(); }
interface Ca extends Ani { public abstract void cr(); }
interface Da extends Ani { public abstract void cr(); }
class Mypet implements Ca, Da{
    public void cr(){
        System.out.println("멍멍 야옹야옹");
    }
}
// - Ca 인터페이스와 Da 인터페이스를 동시에 구현한 Mypet 클래스에서만 cr() 메소드를 정의
// 하므로, 메소드 호출의 모호성이 없음

public class interfaces {
    public static void main(String[] args) {
        // interface
        Cat myC = new Cat();
        Dog myD = new Dog();
        myC.cry(); myD.cry();

        // interface 다중 상속
        Cats ca = new Cats();
        Dogs da = new Dogs();
        ca.crying(); ca.playing();
        da.crying(); da.playing();

        // 
        Mypet p = new Mypet();
        p.cr();
    }
}

/**
 * 인터페이스의 장점
인터페이스를 사용하면 다중 상속이 가능할 뿐만 아니라 다음과 같은 장점
1. 대규모 프로젝트 개발 시 일관되고 정형화된 개발을 위한 표준화가 가능
2. 클래스의 작성과 인터페이스의 구현을 동시에 진행할 수 있으므로, 개발 시간을 단축
3. 클래스와 클래스 간의 관계를 인터페이스로 연결하면, 클래스마다 독립적인 프로그래밍이 가능
 */

 /**
  * - 내부 클래스(inner class) : 하나의 클래스 내부에 선언된 또 다른 클래스; 이러한 내부
   클래스는 외부 클래스에 대해 두 개의 클래스가 서로 긴밀한 관계를 맺고 있을 때 선언
    class Outer { // 외부 클래스
        class Inner { // 내부 클래스

        }
    }
    - 내부 클래스에서 외부 클래스의 멤버에 손쉽게 접근 가능
    - 서로 관련 있는 클래스를 논리적으로 묶어서 표함함으로써, 코드의 캡슐화를 증가시킴
    - 외부에서는 내부 클래스에 접근할 수 없으므로, 코드의 복잡성을 줄일 수 있음
    - 종류)
     1 정적 클래스(static class) : 외부 클래스 영역에 선언된 클래스 중에서 static
      키워드를 가지는 클래스
     2 인스턴스 클래스(instance class) : 외부 클래스 영역에 선언된 클래스 중에서
      static 키워드를 가지지 않는 클래스
     3 지역 클래스(local class) : 외부 클래스의 메소드나 초기화 블록에 선언된 클래스
     4 익명 클래스(anonymous class) : 다른 내부 클래스와는 달리 이름을 가지지 않는 클래스;
      익명 클래스는 클래스의 선언과 동시에 객체를 생성하므로, 단 하나의 객체만을 생성하는
      일회용 클래스; 따라서 생성자를 선언할 수도 없으며, 오로지 단 하나의 클래스나 단 하나의
      인터페이스를 상속받거나 구현할 수 있을 뿐; 매우 제한적인 용도에 사용되며, 구현해야 하는
      메소드가 매우 적은 클래스를 구현할 때 사용됨
      => // 익명 클래스는 선언과 동시에 생성하여 참조변수에 대입함
       클래스이름 참조변수이름 = new 클래스이름(){
            // 메소드의 선언
       };
  */
