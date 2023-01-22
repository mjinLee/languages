package APIclass;
/**
 * - java.lang.StringBuffer 클래스 : String 클래스와 달리 StringBuffer 클래스의 인스턴스는
 *  값을 변경, 추가할 수 있음; 내부적으로 버퍼(buffer)라고 하는 독립적인 공간을 가짐
 *  - 버퍼 크기의 기본값은 16개의 문자를 저장할 수 있는 크기이며, 생성자를 통해 그 크기를
 *   별도로 설정할 수도 있음. 하지만 인스턴스 생성 시 사용자가 설정한 크기보다 언제나 16개의
 *   문자를 더 저장할 수 있도록 여유 있는 크기로 생성됨
 *  ex. 덧셈(+) 연산자를 이용해 String 인스턴스의 문자열을 결합하면, 내용이 합쳐진 새로운
 *  String 인스턴스를 생성함. 따라서 문자열을 많이 결합하면 결합할수록 공간의 낭비뿐만 아니라
 *  속도 또한 매우 느려지게 됨.; 하지만 StringBuffer 인스턴스를 사용하면 문자열을 바로 추가할
 *  수 있으므로, 공간의 낭비도 없으며 속도도 매우 빨라짐
 *  - StringBuffer 클래스는 인스턴스의 값을 자유롭게 변경할 수 있는 가변 클래스(mutable class)
 */
/**
 * - append() 메소드 : 인수로 전달된 값을 문자열로 변환한 후, 해당 문자열의 마지막에 추가; 이
 *  메소드는 String 클래스의 concat() 메소드와 같은 결과를 반환하지만, 내부적인 처리 속도가
 *  훨씬 빠름
 * - capacity() 메소드 : StringBuffer 인스턴스의 현재 버퍼 크기를 반환
 * - delete() 메소드 : 전달된 인덱스에 해당하는 부분 문자열을 해당 문자열에서 제거
 * - deleteCharAt() 메소드 : 특정 위치의 문자 한 개만 제거
 * - insert() 메소드 : 인수로 전달된 값을 문자열로 변환한 후, 해당 문자열의 지정된 인덱스
 *  위치에 추가; 이때 전달된 인덱스가 해당 문자열의 길이와 같으면, append() 메소드와 같은
 *  결과를 반환함; ex. insert() 이용하여 문자열 중간에 다른 문자열 삽입
 */

public class stringbufferClass {
    public static void main(String[] args) {
        // append() method
        StringBuffer str = new StringBuffer("Java");
        System.out.println("원본 문자열 : " + str); // Java
        System.out.println(str.append("수업")); // Java수업
        System.out.println("append() 메소드 호출 후 원본 문자열 : " + str); // Java수업

        // capacity() method
        StringBuffer str01 = new StringBuffer();
        StringBuffer str02 = new StringBuffer("Java");
        System.out.println(str01.capacity()); // 16
        System.out.println(str02.capacity()); // 20
        // 길이가 4인 문자열로 StringBuffer 인스턴스를 생성하면, 기본적으로 생성되는 여유
        // 버퍼 크기인 16에 문자의 길이인 4를 더한 총 20개의 문자를 저장할 수 있는 버퍼가
        // 생성됨

        // delete(), deleteCharAt() method
        StringBuffer str2 = new StringBuffer("Java Oracle");
        System.out.println("원본 문자열 : " + str2); // Java Oracle
        System.out.println(str2.delete(4, 8)); // Javacle
        System.out.println(str2.deleteCharAt(1)); // Jvacle
        System.out.println("deleteCharAt() 메소드 호출 후 원본 문자열 : " + str2); // Jvacle

        // insert() method
        StringBuffer str3 = new StringBuffer("Java 만세!!");
        System.out.println("원본 문자열 : " + str3); // Java 만세!!
        System.out.println(str3.insert(4, "Script")); // JavaScript 만세!!
        System.out.println("insert() 메소드 호출 후 원본 문자열 : " + str3); // JavaScript 만세!!
    }
}

/**
 * - StringBuffer 클래스의 메소드)
 *  StringBuffer append(boolean b), StringBuffer append(char c), 
 *  StringBuffer append(char[] str), StringBuffer append(CharSequence s),
 *  StringBuffer append(double d), StringBuffer append(float f),
 *  StringBuffer append(int i), StringBuffer append(long lng),
 *  StringBuffer append(Object obj), StringBuffer append(String str),
 *  StringBuffer append(StringBuffer sb) : 인수로 전달된 값을 문자열로 변환한 후, 해당
 * 문자열의 마지막에 추가
 *  int capacity() : 현재 버퍼 크기를 반환
 *  StringBuffer delete(int start, int end)	: 전달된 인덱스에 해당하는 부분 문자열을 해당 
 * 문자열에서 제거
 *  StringBuffer deleteCharAt(int index) : 전달된 인덱스에 해당하는 문자를 해당 문자열에서
 * 제거
 *  StringBuffer insert(int offset, boolean b), StringBuffer insert(int offset, char c),
 *  StringBuffer insert(int offset, char[] str), StringBuffer insert(int offset, CharSequence s),
 *  StringBuffer insert(int offset, double d), StringBuffer insert(int offset, float f),
 *  StringBuffer insert(int offset, int i), StringBuffer insert(int offset, long lng),
 *  StringBuffer insert(int offset, Object obj), StringBuffer insert(int offset, String str)
 * : 인수로 전달된 값을 문자열로 변환한 후, 해당 문자열의 지정된 인덱스 위치에 추가
 *  StringBuffer reverse() : 해당 문자열의 인덱스를 역순으로 재배열
 */