import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

public class java8 {  
    public static void main(String[] args) {
        //** lambda expression 람다 표현식 : 함수형 프로그래밍 */
        /*
        * method를 하나의 식으로 표현
        * 식별자 없이 실행할 수 있는 함수 표현식; 익명함수
        * method를 람다 표현식으로 표현하면 클래스를 만들고 객체를 생성하지 않아도 method 사용가능
        * method의 매개변수로 전달될 수 있고, method의 결과값으로 반환될 수도 있음
        */
        // 전통적인 방식의 일회용 스레드 생성
        new Thread(new Runnable(){
            public void run(){
                System.out.println("전통적인 방식");
            }
        }).start();
        // 람다 표현식을 사용한 일회용 스레드 생성
        new Thread(()->{
            System.out.println("람다 표현식");
        }).start();

        //** stream API */
        /*
        * 많은 양의 데이터를 저장하기 위해 배열이나 컬렉션 사용
        * 스트림 API는 데이터를 추상화하여 다루므로, 다양한 방식으로 저장된 데이터를 읽고 쓰기
        * 위한 공통된 방법을 제공
        * 배열, 컬렉션, 파일에 저장된 데이터도 다룰 수 있음
        */
        String[] arr = new String[]{"넷","둘","셋","하나"};
        // 배열에서 스트림 생성
        Stream<String> stream1 = Arrays.stream(arr);
        stream1.forEach(e -> System.out.print(e + " ")); // 넷 둘 셋 하나
        System.out.println();
        // 배열의 특정 부분만을 이용한 스트림 생성
        Stream<String> stream2 = Arrays.stream(arr,1,3);
        stream2.forEach(e -> System.out.print(e + " ")); // 둘 셋
        System.out.println();

        //** java.time 패키지 */
        LocalDate today = LocalDate.now();
        System.out.println("올해는 " + today.getYear() + "년"); // 올해는 2022년
        LocalDate otherday = today.withYear(1982); 
        System.out.println("올해는 " + otherday.getYear() + "년"); // 올해는 1982년
        
        /* Java SE 8 버전부터는 자바스크립트의 새로운 엔진으로 오라클의 나즈혼 도입
         * 나즈혼(Nashorn)은 기존에 사용되어 온 리노(Rhino)에 비해
         * 성능과 메모리 관리 면에서 크게 개선된 스크립트 엔진
         */
    }
}
