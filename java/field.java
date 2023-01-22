/**
 * - 필드 : 클래스에 포함된 변수
 * 1 클래스 변수 : static 키워드를 가짐
 * 2 인스턴스 변수 : static 키워드를 가지지 않음
 * 3 지역 변수 : 메소드나 생성자, 초기화 블록 내에 위치한 변수
 */
class Car{
    static int modelOutput; // 클래스 변수
    String modelName; // 인스턴스 변수
    void method(){
        int something = 10; // 지역 변수
    }
    // 클래스 변수와 인스턴스 변수는 초기화하지 않아도 변수의 타입에 맞게 자동 초기화
    // 지역 변수는 사용하기 전에 초기화하지 않으면, 자바 컴파일러 오류 발생
}
/*
 * - 클래스 변수는 인스턴스를 생성지 않고도 바로 사용할 수 있음; 공유 변수라고도 함
 * - 클래스 변수는 해당 클래스의 모든 인스턴스가 공유해야 하는 값을 유지하기 위해 사용
 * - 인스턴스 변수는 인스턴스마다 가져야 하는 고유한 값을 유지하기 위해 사용
 * => 클래스 변수는 생성된 모든 인스턴스가 같은 값을 공유하고, 인스턴스 변수는 각 인스턴스마다
 *  고유한 값을 가짐
 */
class fieldTest{
    static int classVar = 10; // 클래스 변수 선언
    int instanceVar = 20; // 인스턴스 변수 선언
}

public class field {
    public static void main(String[] args) {
        int var = 30; // 지역 변수 선언
        System.out.println(var + "\n"); // 지역 변수 참조 // 30

        fieldTest mField1 = new fieldTest(); // 인스턴스 생성
        fieldTest mField2 = new fieldTest();

        System.out.println(fieldTest.classVar); // 클래스 변수 참조 // 10
        System.out.println(mField1.classVar); // 10
        System.out.println(mField2.classVar + "\n"); // 10

        mField1.classVar = 100; // 클래스 변수의 값 변경

        System.out.println(fieldTest.classVar); // 클래스 변수 참조 // 100
        System.out.println(mField1.classVar); // 100
        System.out.println(mField2.classVar+"\n"); // 100

        mField1.instanceVar = 200; // 인스턴스 변수의 값을 변경
 
        System.out.println(mField1.instanceVar); // 200
        System.out.println(mField2.instanceVar); // 20
    }
}
