package streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * - 스트림의 중개 연산(intermediate operation) : 스트림 API에 의해 생성된 초기 스트림은 
 * 중개 연산을 통해 또 다른 스트림으로 변환됨; 이러한 중개 연산은 스트림을 전달받아 스트림을 
 * 반환하므로, 중개 연산은 연속으로 연결해서 사용할 수 있음; 또한, 스트림의 중개 연산은 
 * 필터-맵(filter-map) 기반의 API를 사용함으로 지연(lazy) 연산을 통해 성능을 최적화할 수 있음
 * - 스트림 API에서 사용할 수 있는 대표적인 중개 연산과 그에 따른 메소드)
 *  1 스트림 필터링 : filter(), distinct()
 *  2 스트림 변환 : map(), flatMap()
 *  3 스트림 제한 : limit(), skip()
 *  4 스트림 정렬 : sorted()
 *  5 스트림 연산 결과 확인 : peek()
 */

public class streaminter {
    public static void main(String[] args) {
        /* 스트림 필터링
         * - filter() 메소드는 해당 스트림에서 주어진 조건(predicate)에 맞는 요소만으로 구성
         *  된 새로운 스트림을 반환
         *  - 또한, distinct() 메소드는 해당 스트림에서 중복된 요소가 제거된 새로운 스트림을
         *  반환
         * - distinct() 메소드는 내부적으로 Object 클래스의 equals() 메소드를 사용하여 요소의
         *  중복을 비교
         */
        IntStream stream1 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        IntStream stream2 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        // 스트림에서 중복된 요소를 제거
        stream1.distinct().forEach(e -> System.out.print(e + " "));
        System.out.println(); // 7 5 2 1 3 4 6
        // 스트림에서 홀수만을 골라냄
        stream2.filter(n -> n % 2 != 0).forEach(e -> System.out.print(e + " "));
        // 7 5 5 1 3 5

        /* 스트림 변환
         * - map() 메소드는 해당 스트림의 요소들을 주어진 함수에 인수로 전달하여, 그 반환값들
         *  로 이루어진 새로운 스트림을 반환
         * - 만약 해당 스트림의 요소가 배열이라면, flatMap() 메소드를 사용하여 각 배열의 각
         *  요소의 반환값을 하나로 합친 새로운 스트림을 얻을 수 있음
         */
        // 문자열로 이루어진 스트림을 map() 메소드를 이용하여 각 문자열의 길이로 이루어진
        // 스트림으로 변환
        Stream<String> s = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
        s.map(s1 -> s1.length()).forEach(System.out::println); // 4 | 3 | 4 | 10
        // 여러 문자열이 저장된 배열을 각 문자열에 포함된 단어로 이루어진 스트림으로 변환
        String[] arr = {"I study hard", "You study JAVA", "I am hungry"};
        Stream<String> stream = Arrays.stream(arr);
        stream.flatMap(s2 -> Stream.of(s2.split(" +"))).forEach(System.out::println);
        // I | study | hard | You | study | JAVA | I | am | hungry

        /* 스트림 제한
         * - limit() 메소드는 해당 스트림의 첫 번째 요소부터 전달된 개수만큼의 요소만으로
         *  이루어진 새로운 스트림을 반환
         * - skip() 메소드는 해당 스트림의 첫 번째 요소부터 전달된 개수만큼의 요소를 제외한
         *  나머지 요소만으로 이루어진 새로운 스트림을 반환
         */
        IntStream st1 = IntStream.range(0, 10);
        IntStream st2 = IntStream.range(0, 10);
        IntStream st3 = IntStream.range(0, 10);
        st1.skip(4).forEach(n -> System.out.print(n + " "));
        System.out.println(); // 4 5 6 7 8 9
        st2.limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println(); // 0 1 2 3 4 
        st3.skip(3).limit(5).forEach(n -> System.out.print(n + " "));
        // 3 4 5 6 7

        /* 스트림 정렬
         * - sorted() 메소드는 해당 스트림을 주어진 비교자(comparator)를 이용하여 정렬
         * - 이때 비교자를 전달하지 않으면 기본적으로 사전 편찬 순(natural order)으로 정렬
         */
        Stream<String> st4 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");
        Stream<String> st5 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");
        st4.sorted().forEach(s4 -> System.out.print(s4 + " "));
        System.out.println(); // CSS HTML JAVA JAVASCRIPT 
        st5.sorted(Comparator.reverseOrder()).forEach(s5 -> System.out.print(s5 + " "));
        // JAVASCRIPT JAVA HTML CSS

        /* 스트림 연산 결과 확인
         * - peek() 메소드는 결과 스트림으로부터 요소를 소모하여 추가로 명시된 동작을 수행
         * - 이 메소드는 원본 스트림에서 요소를 소모하지 않으므로, 주로 연산과 연산 사이에
         *  결과를 확인하고 싶을 때 사용
         * - 개발자가 디버깅 용도로 많이 사용
         */
        IntStream str = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        str.peek(s0 -> System.out.println("원본 스트림 : " + s0))
            .skip(2)
            .peek(s0 -> System.out.println("skip(2) 실행 후 : " + s0))
            .limit(5)
            .peek(s0 -> System.out.println("limit(5) 실행 후 : " + s0))
            .sorted()
            .peek(s0 -> System.out.println("sorted() 실행 후 : " + s0))
            .forEach(n -> System.out.println(n));
        /*
         *  원본 스트림 : 7 원본 스트림 : 5 
         *  원본 스트림 : 5 skip(2) 실행 후 : 5 limit(5) 실행 후 : 5 
            원본 스트림 : 2 skip(2) 실행 후 : 2 limit(5) 실행 후 : 2
            원본 스트림 : 1 skip(2) 실행 후 : 1 limit(5) 실행 후 : 1
            원본 스트림 : 2 skip(2) 실행 후 : 2 limit(5) 실행 후 : 2
            원본 스트림 : 3 skip(2) 실행 후 : 3 limit(5) 실행 후 : 3
            sorted() 실행 후 : 1    1
            sorted() 실행 후 : 2    2
            sorted() 실행 후 : 2    2
            sorted() 실행 후 : 3    3
            sorted() 실행 후 : 5    5
            => 첫 번째 요소인 7과 두 번째 요소인 5는 skip() 메소드에 의해 삭제되므로,
              원본 스트림에서만 나타남
              하지만 세 번째 요소인 5는 skip() 메소드와 limit() 메소드가 실행된 후에도
              존재하므로, 모두 나타남
            => 이렇게 peek() 메소드는 스트림의 각 요소가 해당 중개 연산 후에 어떻게
              변화하는지를 보여줌
         */
    }
}
