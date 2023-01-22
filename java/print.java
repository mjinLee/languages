/**
 * print
 */
public class print {

    int field1;
    String field2;
    public static void method1() {
        System.out.print("java "); // print() 메소드는 줄바꿈 x
        System.out.println("programming"); // java programming
        System.out.println(3.14); // 3.14
        System.out.println("숫자"+2+"와 문자열 연결"); // 숫자2와 문자열 연결
    }
    public static void main(String[] args) {
        method1();
    }
}
