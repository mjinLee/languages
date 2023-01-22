/**
 * - 람다 표현식(lambda expression) : 메소드를 하나의 식으로 표현
 *   - 메소드
 *      int min(int x, int y){ return x < y ? x : y; }
 *   - 람다 표현식
 *      (x, y) -> x < y ? x : y;
 *  => 메소드를 람다 표현식으로 표현하면, 클래스를 작성하고 객체를 생성하지 않아도 메소드를 
 * 사용할 수 있음
 * - 그런데 자바에서는 클래스의 선언과 동시에 객체를 생성하므로, 단 하나의 객체만을 생성할 수
 * 있는 클래스를 익명 클래스라고 함; 따라서 자바에서 람다 표현식은 익명 클래스와 같다고 할 수 있음
 *   - 익명 클래스
 *      new Object(){
 *          int min(int x, int y){ return x < y ? x : y; }
 *      }
 * - 람다 표현식은 메소드의 매개변수로 전달될 수도 있으며, 메소드의 결괏값으로 반환될 수도 있음;
 * 따라서 람다 표현식을 사용하면, 기존의 불필요한 코드를 줄여주고, 작성된 코드의 가독성을 높여줌
 * - Java SE 8부터는 이러한 람다 표현식을 사용하여 자바에서도 함수형 프로그래밍을 할 수 있게 되었음
 */
/**
 * - 람다 표현식 작성 : 화살표기호(->)를 사용하여 작성
 *  => (매개변수목록) -> { 함수몸체 }
 * - 1. 매개변수의 타입을 추론할 수 있는 경우에는 타입을 생략할 수 있음
 *   2. 매개변수가 하나인 경우에는 괄호(())를 생략할 수 있음
 *   3. 함수의 몸체가 하나의 명령문만으로 이루어진 경우에는 중괄호({})를 생략할 수 있음
 *     (이때 세미콜론(;)은 붙이지 않음)
 *   4. 함수의 몸체가 하나의 return 문으로만 이루어진 경우에는 중괄호({})를 생략할 수 없음
 *   5. return 문 대신 표현식을 사용할 수 있으며, 이때 반환값은 표현식의 결괏값이 됨
 *     (이때 세미콜론(;)은 붙이지 않음)
 */
/**
 * - 함수형 인터페이스(functional interface) : 람다 표현식을 사용할 때는 람다 표현식을 
 * 저장하기 위한 참조 변수의 타입을 결정해야 함
 *  => 참조변수의타입 참조변수의이름 = 람다 표현식
 * - 위의 문법처럼 람다 표현식을 하나의 변수에 대입할 때 사용하는 참조 변수의 타입을 
 * 함수형 인터페이스라고 부름
 * - 함수형 인터페이스는 추상 클래스와는 달리 단 하나의 추상 메소드만을 가져야 함; 또한, 다음과
 * 같은 어노테이션(annotation)을 사용하여 함수형 인터페이스임을 명시할 수 있음
 *  => @FunctionalInterface
 * - 어노테이션을 인터페이스의 선언 앞에 붙이면, 컴파일러는 해당 인터페이스를 함수형 인터페이스로 
 * 인식; 자바 컴파일러는 이렇게 명시된 함수형 인터페이스에 두 개 이상의 메소드가 선언되면 오류 발생
 */
// functional interface
@FunctionalInterface
interface Calc { // 함수형 인터페이스 선언
    public int min(int x, int y);
}

public class lambda {
    public static void main(String[] args) {
        // lambda expression
        new Thread(new Runnable() {
            public void run(){
                System.out.println("전통적인 방식의 일회용 스레드 생성");
            }
        }).start();
        new Thread(()->{
            System.out.println("람다 표현식을 사용한 일회용 스레드 생성");
        }).start();

        // functional interface
        Calc minNum = (x,y) -> x<y ? x : y; // 추상 메소드 구현
        System.out.println(minNum.min(3, 4)); // 함수형 인터페이스 사용
    }
}

// 자바는 java.util.function 패키지를 통해 여러 상황에서 사용할 수 있는 다양한 함수형 
// 인터페이스를 미리 정의하여 제공
// java.util.function 패키지에 대한 더 자세한 사항은 'Package java.util.function' 참고