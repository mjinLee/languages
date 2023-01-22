/** class
 * - 객체의 상태를 나타내는 field와 객체의 행동을 나타내는 method로 구성
 * - field : 클래스에 포함된 변수
 * - method : 특정 작업을 수행하기 위한 명령문의 집합
 * - instance : 클래스로부터 객체를 선언하는 과정을 클래스의 인스턴스화; 선언된 해당 클래스 타입의
 * 객체를 인스턴스; 즉, 인스턴스란 메모리에 할당된 객체
 * - 하나의 클래스로부터 여러 개의 인스턴스 생성 가능
 * - 인스턴스는 독립된 메모리 공간에 저장된 자신만의 필드를 가질 수 있
 * - 해당 클래스의 모든 메소드는 해당 클래스에서 생성된 모든 인스턴스가 공유하게 됨
 * - 클래스는 생성된 객체의 필드를 초기화해주는 메소드인 생성자(constructor)를 가짐
 */

class Car{
    private String modelName; // field
    private int modelYear;
    private String color;
    private int currentSpeed;
    private int accelerationTime;
    private int maxSpeeds;
    
    Car(String modelName, int modelYear){ // constructor 생성자
        this.modelName = modelName;
        this.modelYear = modelYear;
    }
    Car(String modelName, int modelYear, String color, int maxSpeeds){
        this.modelName = modelName; // this 참조 변수는 인스턴스의 주소를 가리킴
        this.modelYear = modelYear;
        this.color = color;    
        this.maxSpeeds = maxSpeeds;    
        this.currentSpeed = 0;
    }
    // this() 메소드 : 생성자 내부에서만 사용 가능, 같은 클래스의 다른 생성자 호출
    Car(){ 
        this("소나타",2012,"검정색",160);
        // 한 생성자에서 다른 생성자를 호출할 땐 반드시 해당 생성자의 첫 줄에서만 호출가능
    }

    public String getModel(){ // method
        return this.modelYear + "년식 " + this.modelName + " " + this.color;
    }
    public void accelerate(int speed, int second){
        System.out.println(second+"초간 속도를 시속 "+speed+"(으)로 가속함!");
    }
}

public class class_ {
    public static void main(String[] args) {               
        Car myCar = new Car(); // 객체 생성
        //Car myCar = new Car("아반떼",2016,"흰색",200);
        myCar.accelerate(60, 3); // 메소도 호출
        System.out.println(myCar.getModel());
    }
}
