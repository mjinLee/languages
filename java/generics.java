import java.util.ArrayList;

/**
 * - generic : 데이터의 타입을 일반화(generalize)한다는 것을 의미; 클래스나 메소드에서 사용할
 * 내부 데이터 타입을 컴파일 시에 미리 지정하는 방법
 */
/**
 * - 제네릭 선언 및 생성
 * - T : 타입 변수(임의의 참조형 타입); T 뿐만 아니라 어떠한 문자를 사용해도 됨; 여러 개의 타입
 * 변수는 쉼표(,)로 구분하여 명시; 타입 변수는 클래스에서뿐만 아니라 메소드의 매개변수나 반환값
 * 으로도 사용할 수 있음
 * - 제네릭 클래스를 생성할 땐 타입 변수 자리에 사용할 실제 타입을 명시해야 함
 */
/*
class MyArray<T> {
    T element;
    void setElement(T element) { this.element = element; }
    T getElement() { return element; }
}
// MyArray 클래스에 사용된 타입 변수로 Integer 타입을 사용
MyArray<Integer> myArr = new MyArray<>(); // <> : java SE 7부터 가능
*/
// 제네릭에서 적용되는 타입 변수의 다형성
class LandAnimal { public void crying() { System.out.println("육지동물");}}
class Cat1 extends LandAnimal { public void crying(){System.out.println("야옹");}}
class Dog1 extends LandAnimal { public void crying(){System.out.println("멍멍");}}
class Sparrow { public void crying(){System.out.println("짹짹");}}

class AnimalList<T>{
    ArrayList<T> al = new ArrayList<>();
    void add(T animal){ al.add(animal); }
    T get(int index) { return al.get(index); }
    boolean remove(T animal){ return al.remove(animal); }
    int size(){ return al.size(); }
}
/**
 * - 타입변수의 제한 : 제네릭은 'T'와 같은 타입변수를 사용하여 타입을 제한함. extends 키워드를
 * 사용하면 타입 변수에 특정 타입만을 사용하도록 제한할 수 있음
 *  => class AnimalList<T extends LandAnimal> { }
 * - 클래스의 타입 변수에 제한을 걸어 놓으면 클래스 내부에서 사용된 모든 타입 변수에 제한 걸림;
 * 클래스가 아닌 인터페이스를 구현할 경우에도 implements 가 아닌 extends 를 사용해야 함
 *  => interface WarmBlood { }
 *     class AnimalList<T extends WarmBlood> { }
 * - 클래스와 인터페이스를 동시에 상속받고 구현해야 한다면 엠퍼센트(&) 기호를 사용하면 됨
 *  => class AnimalList<T extends LandAnimal & WarmBlood> { }
 */
// 위 예제에서 타입변수의 다형성을 이용하여 AnimalList 클래스의 선언부에 명시한 
// 'extends LandAnimal' 구문을 생략해도 제대로 동작함

public class generics {
    public static void main(String[] args) {
        // 제네릭에서 적용되는 타입 변수의 다형성
        AnimalList<LandAnimal> landAnimal = new AnimalList<>();
        landAnimal.add(new LandAnimal());
        landAnimal.add(new Cat1());
        landAnimal.add(new Dog1());
        //landAnimal.add(new Sparrow()); // 오류 발생
        // Cat1, Dog1 클래스는 LandAnimal 클래스를 상속받는 자식 클래스이므로,
        // AnimalList<LandAnimal>에 추가할 수 있으나, Sparrow 클래스는 타입이 다르므로 불가
        for(int i=0; i<landAnimal.size(); i++){
            landAnimal.get(i).crying();
        } // 육지동물 야옹 멍멍
    }
}

/**
 * - 제네릭의 제거 시기)
 * 자바 코드에서 선언되고 사용된 제네릭 타입은 컴파일 시 컴파일러에 의해 자동으로 검사되어 타입 
 * 변환됨. 그리고서 코드 내의 모든 제네릭 타입은 제거되어, 컴파일된 class 파일에는 어떠한 제네릭 
 * 타입도 포함되지 않게 됨. 이런 식으로 동작하는 이유는 제네릭을 사용하지 않는 코드와의 호환성을 
 * 유지하기 위해서임.
 */