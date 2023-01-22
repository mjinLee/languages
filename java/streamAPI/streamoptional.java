package streamAPI;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * - Optional 클래스
 * - java.util.Optional<T> 클래스 : Optional<T> 클래스는 Integer나 Double 클래스처럼
 * 'T'타입의 객체를 포장해 주는 래퍼 클래스(Wrapper class); 따라서 Optional 인스턴스는 모든
 * 타입의 참조 변수를 저장할 수 있음
 * - 이러한 Optional 객체를 사용하면 예상치 못한 NullPointerException 예외를 제공되는 메소드
 * 로 간단히 회피할 수 있음; 즉, 복잡한 조건문 없이도 널(null) 값으로 인해 발생하는 예외를 
 * 처리할 수 있게됨
 */

public class streamoptional {
    public static void main(String[] args) {
        /* Optional 객체의 생성
         * - of() 메소드나 ofNullable() 메소드를 사용하여 Optional 객체를 생성할 수 있음
         * - of() 메소드는 null이 아닌 명시된 값을 가지는 Optional 객체를 반환
         * - 만약 of() 메소드를 통해 생성된 Optional 객체에 null이 저장되면
         *  NullPointerException 예외가 발생
         * - 만약 참조 변수의 값이 만에 하나 null이 될 가능성이 있다면, ofNullable() 메소드를
         *  사용하여 Optional 객체를 생성하는 것이 좋음
         * - ofNullable() 메소드는 명시된 값이 null이 아니면 명시된 값을 가지는 Optional 객체를
         *  반환하며, 명시된 값이 null이면 비어있는 Optional 객체를 반환
         */
        Optional<String> opt = Optional.ofNullable("자바 Optional 객체");
        System.out.println(opt.get()); // 자바 Optional 객체

        /* Optional 객체에 접근
         * - get() 메소드를 사용하면 Optional 객체에 저장된 값에 접근할 수 있음
         * - 만약 Optional 객체에 저장된 값이 null이면, NoSuchElementException 예외가 발생
         * - get() 메소드를 호출하기 전에 isPresent() 메소드를 사용하여 Optional 객체에
         *  저장된 값이 null인지 아닌지를 먼저 확인한 후 호출하는 것이 좋음
         */
        // isPresent() 메소드를 이용하여 좀 더 안전하게 Optional 객체에 저장된 값에 접근
        Optional<String> opt1 = Optional.ofNullable("자바 Optional 객체");
        if(opt1.isPresent()) {
            System.out.println(opt1.get());        
        }
        /*
         * - 다음과 같은 메소드를 사용하여 null 대신에 대체할 값을 지정할 수도 있음
         *  1 orElse() 메소드 : 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지 않으면
         *   인수로 전달된 값을 반환
         *  2 orElseGet() 메소드 : 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지
         *   않으면 인수로 전달된 람다 표현식의 결과값을 반환
         *  3 orElseThrow() 메소드 : 저장된 값이 존재하면 그 값을 반환하고, 값이 존재하지
         *   않으면 인수로 전달된 예외를 발생시킴
         */
        Optional<String> opt3 = Optional.empty(); // Optional를 null로 초기화
        System.out.println(opt3.orElse("빈 Optional 객체"));
        System.out.println(opt3.orElseGet(String::new));

        /*
         * - 기본 타입의 Optional 클래스 : 자바에서는 IntStream 클래스와 같이 기본 타입
         *  스트림을 위한 별도의 Optional 클래스를 제공
         *  1 OptionalInt 클래스
         *  2 OptionalLong 클래스
         *  3 OptionalDouble 클래스
         * - 반환 타입이 Optional<T> 타입이 아니라 해당 기본 타입이라는 사실만 제외하면 거의
         *  모든 면에서 비슷
         * - 또한, Optional 객체에서 get() 메소드를 사용하여 저장된 값에 접근할 수 있는 
         *  것처럼 클래스별로 저장된 값에 접근할 수 있는 다음과 같은 메소드를 제공
         *      클래스	         저장된 값에 접근하는 메소드
         *      Optional<T>	      T get()
         *      OptionalInt	      int getAsInt()
         *      OptionalLong	  long getAsLong()
         *      OptionalDouble    double getAsDouble()
         */
        IntStream str = IntStream.of(4, 2, 1, 3);
        OptionalInt result = str.findFirst();      
        System.out.println(result.getAsInt()); // 4

    }
}
