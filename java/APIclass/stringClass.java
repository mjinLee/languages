package APIclass;
/**
 * - java.lang.String 클래스 : String 인스턴스는 한 번 생성되면 그 값을 읽기만 할 수 있고,
 *  변경할 수는 없음; 이러한 객체를 불변 객체(immutable object)라고 함
 *  ex. 덧셈(+) 연산자를 이용하여 문자열 결합을 수행하면, 기존 문자열의 내용이 변경되는 것이
 *   아니라, 내용이 합쳐진 새로운 String 인스턴스가 생성되는 것
 * => String 클래스와 같은 불변 클래스는 StringBuffer 클래스의 append()나 insert() 메소드와
 *  같이 값을 변경하는 set 메소드를 포함하지 않음; 불변 클래스를 사용하는 이유는 멀티 스레드 
 *  환경에서 객체가 변화되는 상황이라면 불변 인스턴스를 사용하는 것이 좀 더 신뢰할 수 있는
 *  코드를 작성할 수 있기 때문; 즉, 하나의 객체에 접근하면서 각각의 객체가 서로 영향을 주어서는
 *  안 되는 경우에 불변 인스턴스를 사용하면 값이 변하지 않는다는 점이 보장
 */
/**
 * - charAt() 메소드 : 해당 문자열의 특정 인덱스에 해당하는 문자를 반환; 만약 해당 문자열의
 *  길이보다 큰 인덱스나 음수를 전달하면, IndexOutOfBoundsException 오류 발생
 * - compareTo() 메소드 : 해당 문자열을 인수로 전달된 문자열과 사전 편찬 순으로 비교; 이
 *  메소드는 문자열을 비교할 때 대소문자를 구분하여 비교; 만약 두 문자열이 같다면 0을 반환
 *  하며, 해당 문자열이 인수로 전달된 문자열보다 작으면 음수를, 크면 양수를 반환
 * - compareToIgnoreCase() : 문자열을 비교할 때 대소문자를 구분하지 않을 때 사용
 * - concat() 메소드 : 해당 문자열의 뒤에 인수로 전달된 문자열을 추가한 새로운 문자열 반환;
 *  만약 인수로 전달된 문자열의 길이가 0이면, 해당 문자열을 그대로 반환; 두 문자열 연결
 * - indexOf() 메소드 : 해당 문자열에서 특정 문자나 문자열이 처음으로 등장하는 위치의
 *  인덱스를 반환; 만약 해당 문자열에 전달된 문자나 문자열이 포함되어 있지 않으면 -1을 반환;
 *  indexOf() 메소드는 문자나 문자열을 찾을 때 대소문자를 구분함
 * - trim() 메소드 : 해당 문자열의 맨 앞과 맨 뒤에 포함된 모든 공백 문자를 제거
 * - toLowerCase() 메소드 : 해당 문자열의 모든 문자를 소문자로 변환
 * - toUpperCase() 메소드 : 해당 문자열의 모든 문자를 대문자로 변환
 */


public class stringClass {
    public static void main(String[] args) {
        // charAt() method
        String str = new String("java");
        System.out.println("원본 문자열: "+str); // java
        for(int i=0; i<str.length(); i++){
            System.out.print(str.charAt(i)+" ");
        } // j a v a
        System.out.println("\ncharAt() 메소드 호출 후 원본 문자열 : "+str); // java

        // compareTo(), compareToIgnoreCase() method
        String str1 = new String("abcd");
        System.out.println("원본 문자열: "+str1);
        System.out.println(str1.compareTo("bcef")); // -1
        System.out.println(str1.compareTo("abcd")+"\n"); // 0
        System.out.println(str1.compareTo("Abcd")); // 32
        System.out.println(str1.compareToIgnoreCase("Abcd")); // 0
        System.out.println("compareTo() 메소드 호출 후 원본 문자열 : "+str1); // abcd

        // concat() method
        String str2 = new String("java");
        System.out.println("원본 문자열: "+str2); // java
        System.out.println(str2.concat("수업")); // java수업
        System.out.println("concat() 메소드 호출 후 원본 문자열 : "+str2); // java

        // indexOf() method
        String str3 = new String("Oracle Java"); 
        System.out.println("원본 문자열: "+str3); // Oracle Java
        System.out.println(str3.indexOf('o')); // -1
        System.out.println(str3.indexOf('a')); // 2
        System.out.println(str3.indexOf("Java")); // 7
        System.out.println("indexOf() 메소드 호출 후 원본 문자열 : "+str3); // Oracle Java

        // trim() method
        String str4 = new String("java  ");
        System.out.println("원본 문자열: "+str4+"|"); // java  |
        System.out.println(str4.trim() + "|"); // java|
        System.out.println("trim() 메소드 호출 후 원본 문자열 : "+str2+"|"); // java|

        // toLowerCase(), toUpperCase() method
        String str5 = new String("Java");
        System.out.println("원본 문자열: "+str5); // Java
        System.out.println(str5.toLowerCase()); // java
        System.out.println(str5.toUpperCase()); // JAVA
        System.out.println("두 메소드 호출 후 원본 문자열 : "+str5); // Java
    }
}

/**
 * - String 클래스의 메소드)
 *  char charAt(int index) : 해당 문자열의 특정 인덱스에 해당하는 문자를 반환
 *  int compareTo(String str) : 해당 문자열을 인수로 전달된 문자열과 사전 편찬 순으로 비교
 *  int compareToIgnoreCase(String str) : 해당 문자열을 인수로 전달된 문자열과 대소문자를
 * 구분하지 않고 사전 편찬 순으로 비교
 *  String concat(String str) : 해당 문자열의 뒤에 인수로 전달된 문자열을 추가한 새로운
 * 문자열을 반환
 *  int indexOf(int ch), int indexOf(String str) : 해당 문자열에서 특정 문자나 문자열이 
 * 처음으로 등장하는 위치의 인덱스를 반환
 *  int indexOf(int ch, int fromIndex), int indexOf(String str, int fromIndex) : 해당 
 * 문자열에서 특정 문자나 문자열이 전달된 인덱스 이후에 처음으로 등장하는 위치의 인덱스를 반환
 *  int lastIndexOf(int ch) : 해당 문자열에서 특정 문자가 마지막으로 등장하는 위치의 인덱스를
 * 반환
 *  int lastIndexOf(int ch, int fromIndex) : 해당 문자열에서 특정 문자가 전달된 인덱스 이후에
 * 마지막으로 등장하는 위치의 인덱스를 반환
 *  String[] split(String regex) : 해당 문자열을 전달된 정규 표현식(regular expression)에
 * 따라 나눠서 반환
 *  String substring(int beginIndex) : 해당 문자열의 전달된 인덱스부터 끝까지를 새로운 
 * 문자열로 반환
 *  String substring(int begin, int end) : 해당 문자열의 전달된 시작 인덱스부터 마지막 인덱스
 * 까지를 새로운 문자열로 반환
 *  String toLowerCase() : 해당 문자열의 모든 문자를 소문자로 변환
 *  String toUpperCase() : 해당 문자열의 모든 문자를 대문자로 변환
 *  String trim() : 해당 문자열의 맨 앞과 맨 뒤에 포함된 모든 공백 문자를 제거
 *  length() : 해당 문자열의 길이를 반환
 *  isEmpty() : 해당 문자열의 길이가 0이면 true를 반환하고, 아니면 false를 반환
 */