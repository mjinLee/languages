import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * - JDK 1.0에서는 Date 클래스를 사용하여 날짜에 관한 처리를 수행; 하지만 Date 클래스는 현재
 *  대부분의 메소드가 사용을 권장하지 않고(deprecated) 있음
 * - JDK 1.1부터 새롭게 제공된 Calendar 클래스는 날짜와 시간에 대한 정보를 손쉽게 얻을 수
 *  있었으나, 문제가 있음
 * - 따라서 많은 자바 개발자들은 Calendar 클래스뿐만 아니라 더 나은 성능의 Joda-Time이라는
 *  라이브러리를 함께 사용
 * - Joda-Time 라이브러리를 발전시킨 새로운 날짜와 시간 API인 java.time 패키지를 제공
 */
/**
 * - java.time 패키지 : Java SE 8부터 제공; 날짜와 시간을 다루는 데 사용되는 필수 클래스들이
 *  포함
 *   1 java.time.chrono : ISO-8601에 정의된 표준 달력 이외의 달력 시스템을 사용할 때 필요한
 *    클래스들
 *   2 java.time.format : 날짜와 시간에 대한 데이터를 구문분석하고 형식화하는 데 사용되는
 *    클래스들
 *   3 java.time.temporal : 날짜와 시간에 대한 데이터를 연산하는 데 사용되는 보조 클래스들
 *   4 java.time.zone : 타임 존(time-zone)과 관련된 클래스들
 * - java.time 패키지는 기존에 사용되던 Calendar 클래스의 단점을 보완; 따라서 해당 패키지에
 *  속하는 모든 클래스의 인스턴스는 불변 객체로 생성; 즉, java.time 패키지에 포함되는 클래스의
 *  메소드들은 모두 새로운 객체를 생성하여 반환
 */
/**
 * - java.time 패키지의 구성 클래스)
 * - 기존의 Calendar 클래스는 날짜와 시간을 한 번에 표현했지만, java.time 패키지에서는 별도로
 *  구분하여 처리
 * - LocalDate 클래스는 날짜를 표현할 때 사용하며, LocalTime 클래스는 시간을 표현할 때 사용
 * - 기존의 Calendar 클래스처럼 날짜와 시간을 한 번에 표현하고 싶을 때는 LocalDateTime 클래스
 *  를 사용
 * - ZonedDateTime 클래스는 특정 타임 존(time-zone)에 해당하는 날짜와 시간을 다루는 데 사용
 * - 기존의 Date 클래스와 비슷한 용도로 사용되는 Instant 클래스가 있음
 * - Instant 클래스는 특정 시점의 날짜와 시간을 나노초(nanosecond) 단위로 표현하는 타임스탬프
 *  를 다루는 데 사용
 * - Period 클래스는 두 날짜 사이의 차이를 표현하는 데 사용되며, Duration 클래스는 두 시각 
 *  사이의 차이를 표현하는 데 사용
 */

public class times {
    public static void main(String[] args) {
        /* 날짜와 시간 객체의 생성
         * - LocalDate와 LocalTime 클래스는 객체를 생성하기 위해서 now()와 of() 메소드라는
         *  클래스 메소드를 제공
         * - now() 메소드는 현재의 날짜와 시간을 이용하여 새로운 객체를 생성하여 반환
         * - of() 메소드는 전달된 인수를 가지고 특정 날짜와 시간을 표현하는 새로운 객체를
         *  생성하여 반환
         * - of() 메소드는 다양한 형태가 오버로딩되어 제공
         */
        LocalDate today = LocalDate.now();
        LocalTime present = LocalTime.now();
        System.out.println(today + " " + present); // 2023-01-02 13:14:18.624956900
        // static LocalDate of(int year, int month, int dayOfMonth)
        LocalDate birthDay = LocalDate.of(1982, 02, 19);
        // static LocalTime of(int hour, int minute, int second, int nanoOfSecond)
        LocalTime birthTime = LocalTime.of(02, 02, 00, 100000000);
        System.out.println(birthDay + " " + birthTime); // 1982-02-19 02:02:00.100

        /* 날짜와 시간 객체에 접근하기
         * - LocalDate와 LocalTime 클래스는 특정 필드의 값을 가져오기 위해서 다양한 getter
         *  메소드를 제공
         * - 기존의 Calendar 클래스에서는 1월을 0으로 표현하여 월의 범위가 0~11이었으며,
         *  요일은 일요일부터 1로 표현
         * - java.time 패키지에서는 1월을 1로 표현하여 월의 범위가 1~12가 되었으며,
         *  요일은 월요일부터 1로 표현하도록 변경
         */
        LocalDate todays = LocalDate.now(); 
        System.out.println("올해는 " + todays.getYear() + "년입니다.");
        System.out.println("이번달은 " + todays.getMonthValue() + "월입니다.");
        System.out.println("오늘은 " + todays.getDayOfWeek() + "입니다.");
        System.out.println("오늘은 1년 중 " + todays.get(ChronoField.DAY_OF_YEAR) + "일째 날입니다.");
        /*
         *  올해는 2023년입니다.
            이번달은 1월입니다.
            오늘은 MONDAY입니다.
            오늘은 1년 중 2일째 날입니다.
         */
        LocalTime presents = LocalTime.now();
        System.out.println("현재 시각은 " + presents.getHour() + "시 " + presents.getMinute() + "분입니다.");
        // 현재 시각은 13시 18분입니다.

        /* TemporalField 인터페이스
         * - 월(month-of-year)과 시(hour-of-day)와 같이 날짜와 시간과 관련된 필드를 정의해
         *  놓은 인터페이스
         * - 이 인터페이스를 구현하여 날짜와 시간을 나타낼 때 사용하는 열거체가 바로 ChronoField
         * - java.time 패키지를 구성하는 클래스의 메소드에서는 이 열거체를 이용하여 날짜와
         *  시간을 처리
         * - ChronoField 열거체에 정의된 대표적인 열거체 상수)
         */
        LocalTime pre = LocalTime.now();
        String ampm;
        if(pre.get(ChronoField.AMPM_OF_DAY) == 0) {
            ampm = "오전";
        } else {
            ampm = "오후";
        }
        System.out.println("지금은 " + ampm + " " + pre.get(ChronoField.HOUR_OF_AMPM) + "시입니다.");
        // 지금은 오후 1시입니다.

        /* 날짜와 시간 객체의 필드값 변경
         * - LocalDate와 LocalTime 클래스는 날짜와 시간 객체에 접근하여 특정 필드의 값을
         *  변경하기 위해서 with() 메소드를 사용
         * - with() 메소드를 사용하면 값이 변경될 필드를 사용자가 직접 명시할 수 있음
         * -  특정 필드의 값을 변경하기 위해 미리 정의되어 제공되는 다양한 with() 메소드를
         *  사용할 수도 있음
         */
        LocalDate to = LocalDate.now();
        System.out.println("올해는 " + to.getYear() + "년입니다."); // 올해는 2023년입니다.
        LocalDate otherDay = to.withYear(1982);
        System.out.println("올해는 " + otherDay.getYear() + "년입니다."); // 올해는 1982년입니다.
        //
        LocalTime pres = LocalTime.now();
        System.out.println("현재 시각은 " + pres.getHour() + "시입니다."); // 현재 시각은 13시입니다.
        LocalTime otherTime = pres.withHour(8);
        System.out.println("현재 시각은 " + otherTime.getHour() + "시입니다."); // 현재 시각은 8시입니다.
        // with() 메소드 이외에도 특정 필드의 값을 더하거나 뺄 수 있는 다양한 plus()와 minus()
        // 메소드도 제공
        LocalTime p = LocalTime.now();
        System.out.println("현재 시각은 " + p.get(ChronoField.HOUR_OF_DAY) + "시입니다.");
        // 현재 시각은 13시입니다.
        LocalTime o = present.plus(2, ChronoUnit.HOURS);
        System.out.println("바뀐 시간은 " + o.getHour() + "시입니다.");   
        // 바뀐 시간은 15시입니다.
        LocalTime anotherTime = p.minus(6, ChronoUnit.HOURS);
        System.out.println("바뀐 시간은 " + anotherTime.getHour() + "시입니다.");
        // 바뀐 시간은 7시입니다.

        /* 날짜와 시간 객체의 비교
         * - LocalDate와 LocalTime 클래스에도 객체를 비교할 수 있는 compareTo() 메소드가
         * 오버라이딩되어 있음
         *  1 isEqual() 메소드 : equals() 메소드와는 달리 오직 날짜만을 비교
         *   (LocalDate 클래스에서만 제공)
         *  2 isBefore() 메소드 : 두 개의 날짜와 시간 객체를 비교하여 현재 객체가 명시된
         *   객체보다 앞선 시간인지를 비교
         *  3 isAfter() 메소드 : 두 개의 날짜와 시간 객체를 비교하여 현재 객체가 명시된
         *   객체보다 늦은 시간인지를 비교         
         */
        LocalDate tod = LocalDate.now();
        LocalDate ot = LocalDate.of(1982, 02, 19);
        System.out.println(tod.compareTo(ot)); // 41
        System.out.println(tod.isBefore(ot)); // false
        System.out.println(tod.isEqual(ot)); // false
    }
}
