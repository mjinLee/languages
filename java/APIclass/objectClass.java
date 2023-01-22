package APIclass;
/**
 * - java.lang 패키지 : 가장 기본적인 동작을 수행하는 클래스들의 집합; import 문을 사용하지
 *  않아도 클래스 이름만으로 바로 사용할 수 있음
 * - java.lang.Object 클래스 : 모든 자바 클래스의 최고 조상 클래스; 자바의 모든 클래스는
 *  Object 클래스의 모든 메소드를 바로 사용할 수 있음; Object 클래스는 필드를 가지지 않으며,
 *  총 11개의 메소드만으로 구성되어 있음
 */
/**
 * - toString() 메소드 : 해당 인스턴스에 대한 정보를 문자열로 반환
 *  => 클래스이름 @ 16진수 해시코드(hash code; 인스턴스의 주소를 가리키는 값)
 * - equals() 메소드 : 해당 인스턴스를 매개변수로 전달받는 참조 변수와 비교하여, 결과 반환;
 *  이때 참조 변수가 가리키는 값을 비교하므로, 서로 다른 두 객체는 언제나 false 반환
 * - clone() 메소드 : 해당 인스턴스를 복제하여, 새로운 인스턴스를 생성해 반환; 하지만
 *  Object 클래스의 clone() 메소드는 단지 필드의 값만 복사하므로, 필드의 값이 배열이나 
 *  인스턴스면 제대로 복제할 수 없음; 이러한 경우에는 해당 클래스에서 clone() 메소드를
 *  오버라이딩하여, 복제가 제대로 이루어지도록 재정의해야 함
 *  => 데이터의 보호를 이유로 Cloneable 인터페이스를 구현한 클래스의 인스턴스만 사용 가능
 */
import java.util.ArrayList;
// toString(), equals()
 class Car { }
// clone()

class Car22 implements Cloneable {
    private String modelName;
    private ArrayList<String> owners = new ArrayList<String>();
    
    public String getModelName(){ return this.modelName; } // modelName의 값 반환
    public void setModelName(String modelName){ this.modelName = modelName; } // 값 설정

    public ArrayList getOwners(){ return this.owners; }
    public void setOwners(String ownerName){ this.owners.add(ownerName); }

    public Object clone(){
        try{
            Car22 clonedCar = (Car22)super.clone(); // clone() 오버라이딩
            clonedCar.owners = (ArrayList)owners.clone();
            // 배열이나 인스턴스인 필드에 대해서 별도로 clone()을 구현해야 정확한 실행결과 출력
            /**
             * // clonedCar.owners = (ArrayList)owners.clone();
             * car01 : Sonata, [Sooki]

               car01 : Sonata, [Sooki, Lee]
               car01 : Sonata, [Sooki, Lee]

             * clonedCar.owners = (ArrayList)owners.clone();
             * car01 : Sonata, [Sooki]

               car01 : Sonata, [Sooki]
               car01 : Sonata, [Sooki, Lee]
             */
            return clonedCar;
        } catch (CloneNotSupportedException ex){
            ex.printStackTrace();
            return null;
        }
    }
}

public class objectClass {
    public static void main(String[] args) {        
        Car car01 = new Car();
        Car car02 = new Car();
        // toString() method
        System.out.println(car01.toString()); // Car@4517d9a3
        System.out.println(car02.toString()); // Car@372f7a8d  
        // equals() method
        System.out.println(car01.equals(car02)); // false
        car01 = car02;
        System.out.println(car01.equals(car02)); // true

        // clone() method
        Car22 ca01 = new Car22();
        ca01.setModelName("Sonata");
        ca01.setOwners("Sooki");
        System.out.println("car01 : "+ca01.getModelName()+", "+ca01.getOwners()+"\n");

        Car22 ca02 = (Car22)ca01.clone(); // 오버라이딩한 clone() 호출하여 복제 수행
        ca02.setOwners("Lee"); // 복제된 인스턴스 ca02의 owners 필드에 값 추가
        System.out.println("car01 : "+ca01.getModelName()+", "+ca01.getOwners());
        // -> 원본 인스턴스 ca01의 owners 필드에도 새로운 값이 추가됨
        System.out.println("car01 : "+ca02.getModelName()+", "+ca02.getOwners());
        
        /**
         * - 부모 클래스의 clone() 메소드를 호출하여 clone() 메소드를 재정의하면, 배열이나
         * 인스턴스인 필드는 복제되는 것이 아닌 해당 배열이나 인스턴스를 가리키는 주소값만이 복제
         */
    }
}

/**
 * - Object 클래스의 메소드)
 *  protected Object clone() : 해당 객체의 복제본을 생성하여 반환
 *  boolean equals(Object obj) : 해당 객체와 전달받은 객체가 같은지 여부를 반환
 *  protected void finalize() : 해당 객체를 더는 아무도 참조하지 않아 가비지 컬렉터가 객체의
 * 리소스를 정리하기 위해 호출
 *  Class<T> getClass() : 해당 객체의 클래스 타입을 반환
 *  int hashCode() : 해당 객체의 해시 코드값을 반환
 *  void notify() : 해당 객체의 대기(wait)하고 있는 하나의 스레드를 다시 실행할 때 호출
 *  void notifyAll() : 해당 객체의 대기(wait)하고 있는 모든 스레드를 다시 실행할 때 호출
 *  String toString() : 해당 객체의 정보를 문자열로 반환
 *  void wait() : 해당 객체의 다른 스레드가 notify()나 notifyAll() 메소드를 실행할 때까지
 * 현재 스레드를 일시적으로 대기(wait)시킬 때 호출
 *  void wait(long timeout) : 해당 객체의 다른 스레드가 notify()나 notifyAll() 메소드를
 * 실행하거나 전달받은 시간이 지날 때까지 현재 스레드를 일시적으로 대기(wait)시킬 때 호출 
 *  void wait(long timeout, int nanos) : 해당 객체의 다른 스레드가 notify()나 notifyAll()
 * 메소드를 실행하거나 전달받은 시간이 지나거나 다른 스레드가 현재 스레드를 인터럽트(interrupt)
 * 할 때까지 현재 스레드를 일시적으로 대기(wait)시킬 때 호출
 */