package collection;

import java.util.*;

/**
 * - Set 컬렉션 클래스 : 요소의 저장 순서를 유지하지 않음; 같은 요소의 중복 저장을 허용 X
 *  1 HashSet<E>
 *  2 TreeSet<E>
 */
/**
 * -1 HashSet<E> 클래스 : Set 컬렉션 클래스에서 가장 많이 사용되는 클래스 중 하나; JDK 1.2
 * 부터 제공됨; 해시 알고리즘을 사용하여 검색 속도가 매우 빠름; 내부적으로 HashMap 인스턴스를
 * 이용하여 요소를 저장함; Set 인터페이스를 구현하므로, 요소를 순서에 상관없이 저장하고 중복된
 * 값은 저장하지 않음; 만약 요소의 저장 순서를 유지해야 한다면 JDK 1.4부터 제공하는
 * LinkedHashSet 클래스를 사용하면 됨
 */
/**
 * - Collection 인터페이스에서는 Iterator 인터페이스를 구현한 클래스의 인스턴스를 반환하는 
 * iterator() 메소드를 정의하여 각 요소에 접근하도록 하고 있음
 * - 요소의 저장 순서를 바꿔도 저장되는 순서에는 영향을 미치지 않음
 * - add() 메소드를 사용하여 해당 HashSet에 이미 존재하는 요소를 추가하려고 하면, 해당 요소를 
 * 저장하지 않고 false를 반환
 * => 이때 해당 HashSet에 이미 존재하는 요소인지를 파악하기 위해서는 내부적으로 다음과 같은 
 * 과정을 거침
 *   1 해당 요소에서 hashCode() 메소드를 호출하여 반환된 해시값으로 검색할 범위를 결정해야 함
 *   2 해당 범위 내의 요소들을 equals() 메소드로 비교함
 * => HashSet에서 add() 메소드를 사용하여 중복 없이 새로운 요소를 추가하기 위해서는 hashCode()
 * 와 equals() 메소드를 상황에 맞게 오버라이딩해야함
 */
// 사용자가 정의한 Animal 클래스의 인스턴스를 HashSet에 저장하기 위해 hashCode()와 equals() 
// 메소드를 오버라이딩
class Animal {
    String species;
    String habitat;
    Animal(String species, String habitat){
        this.species = species;
        this.habitat = habitat;
    }
    public int hashCode(){ return (species+habitat).hashCode();}
    public boolean equals(Object obj){
        if(obj instanceof Animal){
            Animal temp = (Animal)obj;
            return species.equals(temp.species) && habitat.equals(temp.habitat);
        }else{
            return false;
        }
    }
}        

/**
 * -2 TreeSet<E> 클래스 : 데이터가 정렬된 상태로 저장되는 이진 검색 트리(binary search tree)의
 * 형태로 요소를 저장; 이진 검색 트리는 데이터를 추가하거나 제거하는 등의 기본 동작 시간이 매우
 * 빠름; JDK 1.2부터 제공되는 TreeSet 클래스는 NavigableSet 인터페이스를 기존의 이진 검색 트리
 * 의 성능을 향상시킨 레드-블랙 트리(Red-Black tree)로 구현
 * - TreeSet 클래스는 Set 인터페이스를 구현하므로, 요소를 순서에 상관없이 저장하고 중복된 값은 
 * 저장하지 않음
 */

public class set_co {
    public static void main(String[] args) {
        // HashSet class
        HashSet<String> hs01 = new HashSet<>();
        HashSet<String> hs02 = new HashSet<>();
        // add() 요소 저장
        hs01.add("홍길동");
        hs01.add("이순신");
        System.out.println(hs01.add("임꺽정")); // true
        System.out.println(hs01.add("임꺽정")); // 중복된 요소의 저장 // false
        // Enhanced for 문과 get() 요소 출력
        for(String e:hs01){
            System.out.print(e+" ");
        } // 홍길동 이순신 임꺽정 
        // add() 요소 저장
        hs02.add("임꺽정");
        hs02.add("홍길동");
        hs02.add("이순신");
        // iterator() 요소 출력
        Iterator<String> iter02 = hs02.iterator();
        while(iter02.hasNext()){
            System.out.print(iter02.next()+" ");
        } // 홍길동 이순신 임꺽정
        // size() 요소의 총 개수
        System.out.println("HashSet 크기: "+hs02.size()); // HashSet 크기: 3

        // 사용자가 정의한 Animal 클래스의 인스턴스를 HashSet에 저장하기 위해 hashCode()와 
        // equals() 메소드를 오버라이딩
        HashSet<Animal> hs = new HashSet<>();
        hs.add(new Animal("야옹이", "육지"));
        hs.add(new Animal("야옹이", "육지"));
        hs.add(new Animal("야옹이", "육지"));
        System.out.println(hs.size()); // 1
        // add() 메소드를 통해 같은 값을 가지는 Animal 인스턴스를 여러 번 저장하지만, size()
        // 메소드를 통해 살펴본 HashSet 요소의 총 개수는 1개만 저장되었음을 확인

        // TreeSet<E> class
        TreeSet<Integer> ts = new TreeSet<Integer>();
        // add() 메소드를 이용한 요소의 저장
        ts.add(30);
        ts.add(40);
        ts.add(20);
        ts.add(10);
        // Enhanced for 문과 get() 메소드를 이용한 요소의 출력
        for (int e : ts) {
            System.out.print(e + " ");
        }
        // remove() 메소드를 이용한 요소의 제거
        ts.remove(40);
        // iterator() 메소드를 이용한 요소의 출력
        Iterator<Integer> iter = ts.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        // size() 메소드를 이용한 요소의 총 개수
        System.out.println("이진 검색 트리의 크기 : " + ts.size());
        // subSet() 메소드를 이용한 부분 집합의 출력
        System.out.println(ts.subSet(10, 20));
        System.out.println(ts.subSet(10, true, 20, true));
        /**
         * - TreeSet 인스턴스에 저장되는 요소들은 모두 정렬된 상태로 저장됨
         * - subSet() 메소드는 TreeSet 인스턴스에 저장되는 요소가 모두 정렬된 상태이기에 동작이
         *  가능한 해당 트리의 부분 집합만을 보여주는 메소드
         *    public NavigableSet<E> subSet(E fromElement, E toElement)
         *  => 첫 번째 매개변수로 전달된 값에 해당하는 요소부터 시작하여 두 번째 매개변수로 
         *    전달된 값에 해당하는 요소의 바로 직전 요소까지를 반환
         *    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive,
         *      E toElement, boolean toInclusive)
         *  => 두 번째와 네 번째 매개변수로 각각 첫 번째와 세 번째 매개변수로 전달된 값에 해당하는 
         *    요소를 포함할 것인지 아닌지를 명시
         *  => 즉, 네 번째 매개변수를 false로 변경하면 20을 포함하지 않게되므로, 같은 결과 출력
         * 
         */
    }
}

/**
 * - 해시 알고리즘 : 해시 함수를 사용하여 데이터를 해시 테이블에 저장하고, 다시 그것을 검색하는 
 * 알고리즘; 자바에서 해시 알고리즘을 이용한 자료 구조는 배열과 연결 리스트로 구현; 저장할 
 * 데이터의 키값을 해시 함수에 넣어 반환되는 값으로 배열의 인덱스를 구함. 그리고서 해당 인덱스에
 * 저장된 연결 리스트에 데이터를 저장
 *  예를 들어, 정수형 데이터를 길이가 10인 배열에 저장한다고 한다면 1,000,002를 검색하는 방법은
 * 다음과 같을 수 있. -> 1,000,002를 10으로 나눈 나머지가 2이므로 배열의 세 번째 요소에 연결된
 * 연결 리스트에서 검색을 시작함
 * => 해시 알고리즘을 이용하면 매우 빠르게 검색 작업을 수행
 */

/**
 * - Set 인터페이스 메소드 : Set 인터페이스는 Collection 인터페이스를 상속받으므로, 
 * Collection 인터페이스에서 정의한 메소드도 모두 사용할 수 있음
 *  boolean add(E e)	해당 집합(set)에 전달된 요소를 추가 (선택적 기능)
 *  void clear()	해당 집합의 모든 요소를 제거 (선택적 기능)
 *  boolean contains(Object o)	해당 집합이 전달된 객체를 포함하고 있는지를 확인
 *  boolean equals(Object o)	해당 집합과 전달된 객체가 같은지를 확인
 *  boolean isEmpty()	해당 집합이 비어있는지를 확인
 *  Iterator<E> iterator()	해당 집합의 반복자(iterator)를 반환
 *  boolean remove(Object o)	해당 집합에서 전달된 객체를 제거 (선택적 기능)
 *  int size()	해당 집합의 요소의 총 개수를 반환
 *  Object[] toArray()	해당 집합의 모든 요소를 Object 타입의 배열로 반환
 */