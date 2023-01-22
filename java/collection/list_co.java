package collection;

import java.util.*;

/**
 * - List 컬렉션 클래스 : 요소의 저장 순서가 유지됨; 같은 요소의 중복 저장 허용
 *  1 ArrayList<E>
 *  2 LinkedList<E>
 *  3 Vector<E>
 *  4 Stack<E>
 */
/**
 * - ArrayList<E> 클래스 : 내부적으로 배열을 이용하여 요소 저장; 인덱스를 이용해 배열 요소에
 * 빠르게 접근할 수 있음; 배열은 크기를 변경할 수 없는 인스턴스이므로, 크기를 늘리기 위해서는
 * 새로운 배열을 생성하고 기존의 요소들을 옮겨야하는 복잡한 과정; 물론 이 과정은 자동으로 수행
 * 되지만, 요소의 추가 및 삭제 작업에 걸리는 시간이 매우 길어지는 단점이 있음
 * - LinkedList<E> 클래스 : 내부적으로 연결리스트(linked list)를 이용하여 요소 저장;
 * 연결 리스트는 저장된 요소가 비순차적으로 분포되며, 요소들 사이를 링크로 연결하여 구성;
 *  - 다음 요소를 가리키는 참조만을 가지는 연결 리스트를 단일연결리스트라고 함; 단일연결리스트
 * 는 요소의 저장과 삭제 작업이 다음 요소를 가리키는 참조만 변경하면 되므로, 빠르게 처리가능;
 * 하지만 단일연결리스트는 현재 요소에서 이전 요소로 접근하기가 매우 어렵; 따라서 이전 요소를
 * 가리키는 참조도 가지는 이중연결리스트가 좀 더 많이 사용됨
 * - Vector<E> 클래스 : List 인터페이스를 상속받음; 현재 기존 코드와의 호환성을 위해서만
 * 남아있으므로, ArrayList 클래스를 사용하는 것이 좋음
 */

public class list_co {
    public static void main(String[] args) {
        // ArrayList method
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        arrList.add(10);
        arrList.add(20);
        arrList.add(30);
        // 출력
        for(int i=0; i<arrList.size();i++){
            System.out.print(arrList.get(i)+" ");
        }
        arrList.remove(1);
        // Enhanced for문 이용한 출력
        for(int e : arrList){
            System.out.print(e + " ");
        }
        // 요소 정렬
        // Collection 은 인터페이스, Collections 는 클래스
        Collections.sort(arrList);
        // iterator() 이용한 출력
        Iterator<Integer> iter = arrList.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next()+" ");
        }
        // 요소 변경
        arrList.set(0, 20);
        for(int e : arrList){
            System.out.print(e + " ");
        }
        // 요소의 총 개수
        System.out.println("ArrayList 크기: "+arrList.size());

        // LinkedList method
        LinkedList<String> lnkList = new LinkedList<String>();
        lnkList.add("vier");
        lnkList.add("drei");
        lnkList.add("twei");
        lnkList.add("eins");
        for(int i=0; i<lnkList.size(); i++){
            System.out.print(lnkList.get(i)+" ");
        }
        lnkList.remove(1);
        for(String e: lnkList){
            System.out.print(e+" ");
        }
        lnkList.set(2, "two");
        for(String e:lnkList){
            System.out.print(e+" ");
        }
        System.out.println("LinkedList 크기: "+lnkList.size());
    }
}

/**
 * - List 인터페이스 메소드 : List 인터페이스는 Collection 인터페이스를 상속받으므로,
 * Collection 인터페이스에서 정의한 메소드도 모두 사용할 수 있음
 *  boolean add(E e) : 해당 리스트(list)에 전달된 요소를 추가 (선택적 기능)
 *  void add(int index, E e) : 해당 리스트의 특정 위치에 전달된 요소를 추가 (선택적 기능)
 *  void clear() : 해당 리스트의 모든 요소를 제거 (선택적 기능)
 *  boolean contains(Object o) : 해당 리스트가 전달된 객체를 포함하고 있는지를 확인
 *  boolean equals(Object o) : 해당 리스트와 전달된 객체가 같은지를 확인
 *  E get(int index) : 해당 리스트의 특정 위치에 존재하는 요소를 반환
 *  boolean isEmpty() : 해당 리스트가 비어있는지를 확인
 *  Iterator<E> iterator() : 해당 리스트의 반복자(iterator)를 반환
 *  boolean remove(Object o) : 해당 리스트에서 전달된 객체를 제거 (선택적 기능)
 *  boolean remove(int index) : 해당 리스트의 특정 위치에 존재하는 요소를 제거 (선택적 기능)
 *  E set(int index, E e) : 해당 리스트의 특정 위치에 존재하는 요소를 전달받은 객체로 대체(선택적 기능)
 *  int size() : 해당 리스트의 요소의 총 개수를 반환
 *  Object[] toArray() : 해당 리스트의 모든 요소를 Object 타입의 배열로 반환
 */