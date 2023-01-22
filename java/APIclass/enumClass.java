package APIclass;
/**
 * - Enum 클래스 : JDK 1.5부터 사용할 수 있는 열거체
 *  1 열거체를 비교할 때 실제 값뿐만 아니라 타입까지도 체크함
 *  2 열거체의 상숫값이 재정의되더라도 다시 컴파일할 필요가 없음
 * - 열거체 정의)
 *   enum 열거체이름 { 상수1이름, 상수2이름, ... }
 * - 열거체 사용)
 *   열거체이름.상수이름
 * - java.lang.Enum
 */
/**
 * - 열거체의 첫 번째 상숫값은 0부터 설정되며, 그 다음은 바로 앞의 상숫값보다 1만큼 증가
 * - 불규칙한 값을 상숫값으로 설정하고 싶으면 상수의 이름 옆에 괄호를 추가하고, 그 안에
 *  원하는 상숫값을 명시할 수 있음; 하지만 불규칙한 특정 값을 저장할 수 있는 인스턴스
 *  변수와 생성자를 별도로 추가해야 함
 */
enum Rain{
    RED(3), ORANGE(10), YELLOW(21), GREEN(5), BLUE(1),
     INDIGO(-1), VIOLET(-11);

    private final int value;
    Rain(int value){ this.value = value; }
    public int getValue() { return value; }
}
/**
 * - values() 메소드 : 해당 열거체의 모든 상수를 저장한 배열을 생성하여 반환; 이 메소드는
 *  자바의 모든 열거체에 컴파일러가 자동으로 추가해 주는 메소드
 * - valuesOf() 메소드 : 전달된 문자열과 일치하는 해당 열거체의 상수를 반환
 * - ordinal() 메소드 : 해당 열거체의 상수가 열거체 정의에서 정의된 순서(0부터 시작) 반환;
 *  이때 반환되는 값은 열거체 정의에서 해당 열거체 상수가 정의된 순서이며, 상숫값 자체가
 *  아님을 명심
 */
enum Rainbow { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }

public class enumClass {
    public static void main(String[] args) {
        // values() method
        Rainbow[] arr = Rainbow.values();
        for(Rainbow rb:arr){
            System.out.println(rb);
        } // RED ORANGE YELLOW GREEN BLUE INDIGO VIOLET 

        // valuesOf() method
        Rainbow rb2 = Rainbow.valueOf("GREEN");
        System.out.println(rb2); // GREEN

        // ordinal() method
        int idx = Rainbow.YELLOW.ordinal();
        System.out.println(idx); // 2
        
        // 불규칙한 상숫값을 가지는 열거체에서 ordinal() method를 사용
        System.out.println(Rain.YELLOW.ordinal()); // 2
    }
}

/**
 * - Enum 클래스의 메소드)
 *  static E values() : 해당 열거체의 모든 상수를 저장한 배열을 생성하여 반환
 *  static E valueOf(String name) :	전달된 문자열과 일치하는 해당 열거체의 상수를 반환
 *  protected void finalize() :	해당 Enum 클래스가 final 메소드를 가질 수 없게 됨
 *  String name() :	해당 열거체 상수의 이름을 반환
 *  int ordinal() :	해당 열거체 상수가 열거체 정의에서 정의된 순서(0부터 시작)를 반환
 */