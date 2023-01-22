import java.util.*;

/**
 * - 제네릭 메소드 : 메소드의 선언부에 타입변수를 사용한 메소드; 이때 타입 변수의 선언은 메소드
 * 선언부에서 반환 타입 바로 앞에 위치
 *  => public static <T> void sort(...){ }
 */
// 제네릭 클래스에서 정의된 타입 변수 T와 제네릭 메소드에서 사용된 타입 변수 T는 전혀 별개의 것
class AnimalList<T>{
    public static <T> void sort(List<T> list, Comparator<? super T> comp){
        
    }
}
/**
 * - 와일드카드 : 이름에 제한을 두지 않음을 표현하는 데 사용되는 기호 => 제네릭에서는 '?' 사용
 *  <?> // 타입 변수에 모든 타입을 사용할 수 있음
 *  <? extends T> // T 타입과 T 타입을 상속받는 자손 클래스 타입만을 사용할 수 있음
 *  <? super T> // T 타입과 T 타입을 상속받은 조상 클래스 타입만을 사용할 수 있음
 */ 
// 클래스 메소드인 cryingAnimalList() 메소드의 매개변수의 타입을 와일드카드를 사용하여 제한
class LandAnimal { public void crying() { System.out.println("육지"); } }
class Catss extends LandAnimal { public void crying() { System.out.println("야옹"); } }
class Dogss extends LandAnimal { public void crying() { System.out.println("멍"); } }
class Sparrowss { public void crying() { System.out.println("짹"); } }

class AnimList<T> {
    ArrayList<T> al = new ArrayList<T>();
    public static void cryingAnimalList(AnimList<? extends LandAnimal> al) {
        LandAnimal la = al.get(0);
        la.crying();
    }
    void add(T animal) { al.add(animal); }
    T get(int index) { return al.get(index); }
    boolean remove(T animal) { return al.remove(animal); }
    int size() { return al.size(); }
}

public class generics2 {
    public static void main(String[] args) {
        AnimList<Catss> catList = new AnimList<Catss>();
        catList.add(new Catss());
        AnimList<Dogss> dogList = new AnimList<Dogss>();
        dogList.add(new Dogss());

        AnimList.cryingAnimalList(catList); // 야옹
        AnimList.cryingAnimalList(dogList); // 멍
    }
}
