package collection;
import java.util.ArrayList;

/** 
 * - 컬렉션 프레임워크 : 데이터를 저장하는 자료구조와 데이터를 처리하는 알고리즘을 구조화하여
 * 클래스로 구현해놓은 것; 자바의 interface 를 사용하여 구현됨
 *  1 List interface
 *  2 Set interface
 *  3 Map interface
 *  => List 와 Set 인터페이스는 모두 Collection 인터페이스를 상속받지만, 구조상의 차이로 
 *   Map 인터페이스는 별도로 정의됨; List와 Set 의 공통된 부분을 Collection 인터페이스에서 정의
 * - 인터페이스 특징)
 *  List<E> : 순서가 있는 데이터의 집합; 데이터의 중복을 허용
 *            Vector, ArrayList, LinkedList, Stack, Queue
 *  Set<E> : 순서가 없는 데이터의 집합; 데이터의 중복을 허용하지 않음
 *            HashSet, TreeSet
 *  Map<K, V> : 키와 값의 한 쌍으로 이루어지는 데이터의 집합; 순서가 없음; 이때 키는 중복을 허용
 *              하지 않지만, 값은 중복될 수 있음
 *              HashMap, TreeMap, Hashtable, Properties
 */

public class collection {
    public static void main(String[] args) {
        // 리스트 생성
        ArrayList<String> arrList = new ArrayList<>();
        // 리스트에 요소 저장
        arrList.add("eins");
        arrList.add("twei");
        arrList.add("drei");
        arrList.add("vier");
        // 리스트 요소 출력
        for(int i=0;i<arrList.size();i++){
            System.out.println(arrList.get(i));
        }
    }
}

/**
 * - Collection 인터페이스 메소드)
 *  boolean add(E e) : 해당 컬렉션(collection)에 전달된 요소를 추가 (선택적 기능)
 *  void clear() : 해당 컬렉션의 모든 요소를 제거 (선택적 기능)
 *  boolean contains(Object o) : 해당 컬렉션이 전달된 객체를 포함하고 있는지를 확인
 *  boolean equals(Object o) : 해당 컬렉션과 전달된 객체가 같은지를 확인
 *  boolean isEmpty() : 해당 컬렉션이 비어있는지를 확인
 *  Iterator<E> iterator() : 해당 컬렉션의 반복자(iterator)를 반환
 *  boolean remove(Object o) : 해당 컬렉션에서 전달된 객체를 제거 (선택적 기능)
 *  int size() : 해당 컬렉션의 요소의 총 개수를 반환
 *  Object[] toArray() : 해당 컬렉션의 모든 요소를 Object 타입의 배열로 반환
 */