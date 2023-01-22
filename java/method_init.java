/**
 * - method
 * 1 클래스 메소드 : static 키워드 가짐; 인스턴스를 생성하지 않고 바로 사용 가능;
 *  메소드 내부에서 인스턴스 변수를 사용할 수 없음
 * 2 인스턴스 메소드 : static 키워드 가지지 않음
 */
class Method {
    int a=10, b=20; // 인스턴스 변수
    int add(){ return a+b; } // 인스턴스 메소드
    static int add(int x, int y){ return x+y; } // 클래스 메소드
}

/**
 * - 초기화 블록 : 자바에서 필드는 초기화하지 않아도 변수의 타입에 맞는 초깃값으로
 *  자동으로 초기화됨. 하지만 지역변수와 마찬가지로 적절한 값으로 초기화한 후에
 *  사용하는 것이 좋음
 */
// 인스턴스 초기화 블록
class Field{
    static int classVar = 10; // 클래스 변수의 명시적 초기화
    int instanceVar = 20; // 인스턴스 변수의 명시적 초기화
}
class Car{
    private String modelName;
    private int modelYear;
    private String color;
    private int maxSpeed;
    private int currentSpeed;

    { // 인스턴스 초기화 블록
        this.currentSpeed = 0;
    }
    Car(){}
    Car(String modelName, int modelYear, String color, int maxSpeed){
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
    public int getSpeed(){
        return currentSpeed;
    }
}

// 클래스 초기화 블록
class initBlock{
    static int classV; // 클래스 변수
    int instanceV; // 인스턴스 변수
    static { // 클래스 초기화 블록을 이용한 초기화
        classV = 10;
    }
}

// 필드의 초기화 순서
// 클래스 변수 : 기본값 -> 명시적 초기화 -> 클래스 초기화 블록
// 인스턴스 변수 : 기본값 -> 명시적 초기화 -> 인스턴스 초기화 블록 -> 생성자
class InitBlock2 {     
    static int classVar = 10;         // 클래스 변수의 명시적 초기화      
    int instanceVar = 10;             // 인스턴스 변수의 명시적 초기화
    static { classVar = 20; }         // 클래스 초기화 블록을 이용한 초기화
    { instanceVar = 20; }             // 인스턴스 초기화 블록을 이용한 초기화
    InitBlock2() { instanceVar = 30; } // 생성자를 이용한 초기화
}

public class method_init {
    public static void main(String[] args) {
        // 메소드
        System.out.println(Method.add(20, 30)); // 클래스 메소드 호출
        Method mMethod = new Method(); // 인스턴스 생성
        System.out.println(mMethod.add()); // 인스턴스 메소드 호출
        // => 클래스 메소드는 인스턴스 변수는 사용하지 않고, 전달된 매개변수만으로 동작
    
        // 인스턴스 초기화 블록
        Car mCar = new Car(); // 인스턴스 생성
        System.out.println(mCar.getSpeed()); // 인스턴스 메소드 호출

        // 클래스 초기화 블록
        System.out.println(initBlock.classV); // 클래스 변수에 접근

        // 필드의 초기화 순서
        System.out.println(InitBlock2.classVar);
        InitBlock2 myInit = new InitBlock2();
        System.out.println(myInit.instanceVar);
    }
}
