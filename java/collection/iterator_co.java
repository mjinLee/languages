package collection;
import java.util.*;
/**
 * - Iterator<E> 인터페이스 : 컬렉션에 저장된 요소를 읽어오는 방법을 Iterator 인터페이스로 
 * 표준화하고 있음; Collection 인터페이스에서는 Iterator 인터페이스를 구현한 클래스의 
 * 인스턴스를 반환하는 iterator() 메소드를 정의하여 각 요소에 접근; 따라서 Collection 
 * 인터페이스를 상속받는 List와 Set 인터페이스에서도 iterator() 메소드를 사용할 수 있음
 *  - boolean hasNext()	해당 이터레이션(iteration)이 다음 요소를 가지고 있으면 true를 
 * 반환하고, 더 이상 다음 요소를 가지고 있지 않으면 false를 반환
 *  - E next()	이터레이션(iteration)의 다음 요소를 반환
 *  - default void remove()	해당 반복자로 반환되는 마지막 요소를 현재 컬렉션에서 제거함. 
 * (선택적 기능)
 * - 현재 자바에서는 될 수 있으면 JDK 1.5부터 추가된 Enhanced for 문을 사용하도록 권장
 * - Enhanced for 문을 사용하면 같은 성능을 유지하면서도 코드의 명확성을 확보하고 발생할 
 * 수 있는 버그를 예방해줌
 * -하지만 요소의 선택적 제거나 대체 등을 수행하기 위한 경우에는 반복자(iterator)를 
 * 사용해야만 함
 * - Enumeration<E> 인터페이스 : Enumeration 인터페이스는 JDK 1.0부터 사용해 온 Iterator 
 * 인터페이스와 같은 동작을 하는 인터페이스; Enumeration 인터페이스는 hasMoreElements()와 
 * nextElement() 메소드를 사용하여 Iterator와 같은 작업을 수행함; 현재에는 기존 코드와의 
 * 호환성을 위해서만 남아있으므로, Enumeration 인터페이스보다는 Iterator 인터페이스를 사용
 * 하는 것이 좋음 
 * - ListIterator<E> 인터페이스 : Iterator 인터페이스를 상속받아 여러 기능을 추가한 인터페이스;
 * 컬렉션의 요소에 접근할 때 한 방향으로만 이동할 수 있음; 하지만 JDK 1.2부터 제공된 
 * ListIterator 인터페이스는 컬렉션 요소의 대체, 추가 그리고 인덱스 검색 등을 위한 작업에서 
 * 양방향으로 이동하는 것을 지원; 단, ListIterator 인터페이스는 List 인터페이스를 구현한 List 
 * 컬렉션 클래스에서만 listIterator() 메소드를 통해 사용할 수 있음
 * 
 */


public class iterator_co {
    public static void main(String[] args) {
        // Iterator
        LinkedList<Integer> lnkList = new LinkedList<Integer>();
        lnkList.add(4);
        lnkList.add(2);
        lnkList.add(3);
        lnkList.add(1);

        Iterator<Integer> iter = lnkList.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        // ListIterator
        LinkedList<Integer> lnkList2 = new LinkedList<Integer>(); 
        lnkList2.add(4);
        lnkList2.add(2);
        lnkList2.add(3);
        lnkList2.add(1);
        ListIterator<Integer> iter2 = lnkList2.listIterator();
        while (iter2.hasNext()) { // 순방향 출력
            System.out.print(iter2.next() + " ");
        } // 4 2 3 1
        while (iter2.hasPrevious()) { // 역방향 출력
            System.out.print(iter2.previous() + " ");
        } // 1 3 2 4
    }
}
