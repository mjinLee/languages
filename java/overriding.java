// method overriding : 상속받은 부모 클래스의 메소드를 재정의하여 사용하는 것
class Parent{
    void display(){
        System.out.println("부모 클래스의 display() 메소드");
    }
}
class Child extends Parent{
    void display(){
        System.out.println("자식 클래스의 display() 메소드");
    } // 오버라이딩

    void display(String str){ 
        System.out.println(str); // 오버로딩
    }
}
/**
 * overloading : 새로운 메소드 정의
 * overriding : 상속받은 기존의 메소드 재정의
 */

public class overriding {
    public static void main(String[] args) {
        // method overriding
        Parent pa = new Parent();
        pa.display(); // 부모 클래스의 display()
        Child ch = new Child();
        ch.display(); // 자식 클래스의 display()
        Parent pc = new Child();
        pc.display(); // Child cp = new Parent(); // 자식 클래스의 display()

        // overloading
        Child ch1 = new Child();
        ch1.display();
        ch1.display("오버로딩된 display() 메소드");
    }
}
