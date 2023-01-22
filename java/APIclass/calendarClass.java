package APIclass;

import java.util.Calendar;

/**
 * - Calendar 클래스 : java SE 8 버전부터 Joda-Time 라이브러리를 발전시킨 새로운 날짜와 시간
 * API인 java.time 패키지 제공; Calendar 클래스는 자바에서 날짜와 시간에 관한 데이터를 손쉽게
 * 처리할 수 있도록 제공하는 추상 클래스; 날짜와 시간을 처리하기 위한 다양한 필드와 메소드 포함;
 * 모든 필드는 클래스 변수(static variable)이므로, 객체를 생성하지 않고도 바로 사용할 수 있음
 * - java.util.GregorianCalendar 클래스 : Calendar 클래스는 추상 클래스이므로, 직접 인스턴스를
 * 생성할 수 없음. GregorianCalendar 클래스느 이러한 Calendar 클래스를 상속받아 그레고리오 달력
 * 을 완전히 구현한 하위 클래스
 */
/**
 * - add() 메소드 : 전달된 Calendar 필드에서 일정 시간 만큼 더하거나 빼줌; 즉, 특정 시간을 기준
 * 으로 일정 시간 전후의 날짜와 시간을 알 수 있음
 * - before() 메소드 : 현재 Calendar 인스턴스가 전달된 객체가 나타내는 시간보다 앞서는지 판단
 * - after() 메소드 : 나중인지 판단
 * - get() 메소드 : 전달된 Calendar 필드에 저장된 값 반환
 * - roll() 메소드 : 전달된 Calendar 필드에서 일정 시간 만큼 더하거나 빼줌; add() 메소드와는
 * 달리 다른 Calendar 필드에는 영향을 주지 않음; 즉, 계산 결과가 해당 필드의 최댓값이나 최솟값을
 * 넘어가도 다른 필드에 영향을 주지 않음
 * - set() 메소드 : 전달된 Calendar 필드를 특정 값으로 설정
 */

public class calendarClass {
    public static void main(String[] args) {
        // add() method
        Calendar ti = Calendar.getInstance();
        System.out.println(ti.getTime()); // Thu Dec 22 12:21:21 KST 2022
        ti.add(Calendar.SECOND, 120); // 현재 시각에 120초를 더함
        System.out.println(ti.getTime()); // Thu Dec 22 12:23:21 KST 2022
        
        // before(), after() method
        Calendar time1 = Calendar.getInstance();
        Calendar time2 = Calendar.getInstance();
        Calendar time3 = Calendar.getInstance();
        time2.set(1982, 12, 22);
        time3.set(2022, 12, 22);
        System.out.println(time1.before(time2)); // false
        System.out.println(time1.before(time3)); // true

        // get() method
        Calendar time = Calendar.getInstance();
        System.out.println(time.getTime()); // Thu Dec 22 12:26:27 KST 2022
        System.out.println(time.get(Calendar.DAY_OF_WEEK)); // 5
        System.out.println(time.get(Calendar.MONTH) + 1); // 12
        System.out.println(time.get(Calendar.DAY_OF_MONTH)); // 22
        System.out.println(time.get(Calendar.HOUR_OF_DAY)); // 12
        System.out.println(time.get(Calendar.MINUTE)); // 26
        System.out.println(time.get(Calendar.SECOND)); // 27
        System.out.println(time.get(Calendar.YEAR)); // 2022

        // roll() mehtod
        Calendar t1 = Calendar.getInstance();
        Calendar t2 = Calendar.getInstance();
        System.out.println(t1.getTime()); // Thu Dec 22 12:30:25 KST 2022
        t1.add(Calendar.SECOND, 60); // add() 사용해 60초 증가-> MINUTE 필드 1 증가
        System.out.println(t1.getTime()); // Thu Dec 22 12:31:25 KST 2022
        t2.roll(Calendar.SECOND, 60); // roll() 사용하면 -> MINUTE 필드에 영향 X
        System.out.println(t2.getTime()); // Thu Dec 22 12:30:25 KST 2022

        // set() method
        Calendar time11 = Calendar.getInstance();
        System.out.println(time11.getTime()); // Thu Dec 22 12:33:32 KST 2022
        time11.set(Calendar.YEAR, 2020);
        System.out.println(time11.getTime()); // Tue Dec 22 12:33:32 KST 2020
        time11.set(1982, 1, 19); // 1은 2월을 나타냄
        System.out.println(time11.getTime()); // Fri Feb 19 12:33:32 KST 1982
        time11.set(1982, 1, 19, 12, 34, 56);
        System.out.println(time11.getTime()); // Fri Feb 19 12:34:56 KST 1982
    }
}

/**
 * - Calendar 클래스의 메소드)
 *  void add(int field, int amount)	: 전달된 Calendar 필드에서 특정 시간 만큼을 더하거나 뺌
 *  boolean after(Object when) : 현재 Calendar 인스턴스가 전달된 객체가 나타내는 시간보다 
 * 나중인지를 확인
 *  boolean before(Object when) : 현재 Calendar 인스턴스가 전달된 객체가 나타내는 시간보다 
 * 앞서는지를 확인
 *  void clear(int field) : 현재 Calendar 인스턴스의 모든 필드의 값을 undefined로 설정
 *  int get(int field) : 전달된 Calendar 필드에 저장된 값을 반환
 *  static Calendar getInstance() : 시스템의 현재 날짜와 시간으로 Calendar 인스턴스를 생성하여
 * 반환
 *  Date getTime() : 현재 Calendar 인스턴스의 시간 정보를 나타내는 Date 인스턴스를 생성하여
 * 반환
 *  void roll(int field, int amount) : 전달된 Calendar 필드에서 특정 시간 만큼을 더하거나 뺌
 *  void set(int field, int value), void set(int year, int month, int date),
 *  void set(int year, int month, int date, int hourOfDay, int minute),
 *  void set(int year, int month, int date, int hourOfDay, int minute, int second)
 *  : 전달된 Calendar 필드를 특정 값으로 설정함.
 */