package streamAPI;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/**
 * - 스트림 API : Java SE 8부터 도입;  데이터를 추상화하여 다루므로, 다양한 방식으로 저장된 
 * 데이터를 읽고 쓰기 위한 공통된 방법을 제공; 배열이나 컬렉션뿐만 아니라 파일에 저장된 데이터
 * 도 모두 같은 방법으로 다룰 수 있게 됨;
 *  - 특징)
 *  1 스트림은 외부 반복을 통해 작업하는 컬렉션과는 달리 내부 반복을 통해 작업을 수행
 *  2 스트림은 재사용이 가능한 컬렉션과는 달리 단 한 번만 사용할 수 있음
 *  3 스트림은 원본 데이터를 변경하지 않음
 *  4 스트림의 연산은 필터-맵 기반의 API를 사용하여 지연 연산을 통해 성능을 최적화
 *  5 스트림은 parallelStream() 메소드를 통한 손쉬운 병렬 처리를 지원
 *  - 동작 흐름)
 *  1 스트림 생성
 *    - 컬렉션, 배열, 가변 매개변수, 지정된 범위의 연속된 정수, 특정 타입의 난수들,
 *     람다 표현식, 파일, 빈 스트림
 *  2 스트림 중개 연산(스트림의 변환)
 *  3 스트림 최종 연산(스트림의 사용)
 */

public class streamapi {
    public static void main(String[] args) {
        // 스트림의 생성
        /* 컬렉션 Collection interface - stream() method
         * - Collection 인터페이스를 구현한 모든 List와 Set 컬렉션 클래스에서도 stream() 
         *  메소드로 스트림을 생성할 수 있음; 또한 parallelStream() 메소드를 사용하면 병렬
         *  처리가 가능한 스트림을 생성할 수 있음
         * - Stream 클래스의 forEach() 메소드는 해당 스트림의 요소를 하나씩 소모해가며 순차적
         *  으로 요소에 접근하는 메소드
         * - 같은 스트림으로는 forEach() 메소드를 한 번밖에 호출할 수 없음; 단, 원본 데이터의 요소
         *  를 소모하는 것은 아니므로, 같은 데이터에서 또 다른 스트림을 생성하여 forEach() 
         *  메소드를 호출하는 것은 가능
         */
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4); list.add(2); list.add(3); list.add(1);
        // 컬렉션에서 스트림 생성
        Stream<Integer> stream = list.stream();
        // forEach() 메소드를 이용한 스트림 요소의 순차 접근
        stream.forEach(System.out::println); // 4 2 3 1

        /* 배열 Arrays class - stream() method
         * - 기본 타입인 int, long, double 형을 저장할 수 있는 배열에 관한 스트림이 별도로 
         *  정의
         * - java.util.stream 패키지의 IntStream, LongStream, DoubleStream 인터페이스로
         *  각각 제공
         * - 전체 배열뿐만 아니라 배열의 특정 부분만을 이용하여 스트림을 생성할 수도 있음
         */
        String[] arr = new String[]{"넷", "둘", "셋", "하나"};
        // 배열에서 스트림 생성
        Stream<String> stream1 = Arrays.stream(arr);
        stream1.forEach(e -> System.out.print(e + " "));
        System.out.println(); // 넷 둘 셋 하나
        // 배열의 특정 부분만을 이용한 스트림 생성
        Stream<String> stream2 = Arrays.stream(arr, 1, 3);
        stream2.forEach(e -> System.out.print(e + " ")); // 둘 셋

        /* 가변 매개변수 variable parameter
         * - Stream 클래스의 of() 메소드를 사용하면 가변 매개변수(variable parameter)를 
         *  전달받아 스트림을 생성할 수 있음
         */
        // 가변 매개변수에서 스트림 생성
        Stream<Double> st = Stream.of(4.2, 2.5, 3.1, 1.9);
        st.forEach(System.out::println); // 4.2 2.5 3.1 1.9

        /* 지정된 범위의 연속된 정수
         * - 지정된 범위의 연속된 정수를 스트림으로 생성하기 위해 IntStream나 LongStream 
         *  인터페이스에는 range()와 rangeClosed() 메소드가 정의
         * - range() 메소드는 명시된 시작 정수를 포함하지만, 명시된 마지막 정수는 포함하지 
         *  않는 스트림을 생성
         * - rangeClosed() 메소드는 명시된 시작 정수뿐만 아니라 명시된 마지막 정수까지도 
         *  포함하는 스트림을 생성
         */
        IntStream st1 = IntStream.range(1, 4);
        st1.forEach(e -> System.out.print(e + " "));
        System.out.println(); // 1 2 3
        IntStream st2 = IntStream.rangeClosed(1, 4);
        st2.forEach(e -> System.out.print(e + " ")); // 1 2 3 4

        /* 특정 타입의 난수들
         * - Random 클래스에는 ints(), longs(), doubles()와 같은 메소드가 정의
         * - 매개변수로 스트림의 크기를 long 타입으로 전달받을 수 있음
         * - 만약 매개변수를 전달받지 않으면 크기가 정해지지 않은 무한 스트림을 반환; 이 때에는
         *  limit() 메소드를 사용하여 따로 스트림의 크기를 제한
         */
        IntStream str = new Random().ints(4);
        str.forEach(System.out::println);

        /* 람다 표현식
         * - 람다 표현식을 매개변수로 전달받아 해당 람다 표현식에 의해 반환되는 값을 요소로
         *  하는 무한 스트림을 생성하기 위해 Stream 클래스에는 iterate()와 generate()
         *  메소드가 정의
         * - iterate() 메소드는 시드(seed)로 명시된 값을 람다 표현식에 사용하여 반환된 값을
         *  다시 시드로 사용하는 방식으로 무한 스트림을 생성
         * - 반면에 generate() 메소드는 매개변수가 없는 람다 표현식을 사용하여 반환된 값으로
         *  무한 스트림을 생성
         */
        // iterate() 메소드를 이용하여 홀수만으로 이루어진 무한 스트림을 생성
        //IntStream streams = IntStream.iterate(2, n -> n + 2); // 2, 4, 6, 8, 10, ...
        //Stream<Integer> s = Stream.iterate(2, n -> n + 2);
        //IntStream ss = Stream.iterate(2, n->n+2);

        /* 파일
         * - 파일의 한 행(line)을 요소로 하는 스트림을 생성하기 위해 java.nio.file.Files
         *  클래스에는 lines() 메소드가 정의
         * -  java.io.BufferedReader 클래스의 lines() 메소드를 사용하면 파일뿐만 아니라
         *  다른 입력으로부터도 데이터를 행(line) 단위로 읽어 올 수 있음
         */
        //String<String> stream = Files.lines(Path path);

        /* 빈 스트림
         * - 아무 요소도 가지지 않는 빈 스트림은 Stream 클래스의 empty() 메소드를 사용하여
         *  생성할 수 있음
         */
        Stream<Object> streamss = Stream.empty();
        System.out.println(streamss.count()); // 스트림의 요소의 총 개수를 출력 // 0
    }
}
