package collection;

import java.util.*;

/**
 * - Stack<E> 클래스 : List 컬렉션 클래스의 Vector 클래스를 상속받아, 스택 메모리 구조(선형
 * 메모리 공간에 데이터를 저장하면서 후입선출(LIFO)의 시멘틱을 따르는 자료구조)의 클래스를
 * 제공; 가장 나중에 저장된(push) 데이터가 가장 먼저 인출(pop)되는 구조
 * - Stack 클래스가 상속받아 사용하는 Vector 클래스의 메소드)
 *  boolean empty() : 스택이 비어 있으면 true, 아니면 false 반환
 *  E peek() : 스택의 제일 상단에 있는(제일 마지막으로 저장된) 요소 반환
 *  E pop() : 스택 제일 상단 요소를 반환하고, 해당 요소를 스택에서 제거
 *  E push(E item) : 스택의 제일 상단에 전달된 요소를 삽입
 *  int search(Object o) : 스택에서 전달된 객체가 존재하는 위치의 인덱스를 반환; 이때 인덱스
 * 는 제일 상단에 있는 요소의 위치부터 0이 아닌 1부터 시작함
 *  => 더욱 복잡하고 빠른 스택 구현 : Deque 인터페이스를 구현한 ArrayDeque 클래스 사용
 *   Deque<Integer> st = new ArrayDeque<Integer>();
 *   - ArrayDeque 클래스는 Stack 클래스와는 달리 search() 메소드는 지원하지 않음
 * 
 * - Queue<E> 인터페이스 : 클래스로 구현된 스택과는 달리 자바에서 큐 메모리 구조는 별도의
 * 인터페이스 형태로 제공;
 * - Queue 인터페이스를 상속받는 하위 인터페이스)
 *  1 Deque<E>
 *  2 BlockingDeque<E>
 *  3 BlockingQueue<E>
 *  4 TransferQueue<E>
 * - Deque 인터페이스를 구현한 LinkedList 클래스가 큐 메모리 구조를 구현하는 데 가장 많이
 * 사용됨; 큐 메모리 구조는 선형 메모리 공간에 데이터를 저장하면서 선입선출(FIFO)의 시멘틱을
 * 따르는 자료구조. 즉, 가장 먼저 저장된(push) 데이터가 가장 먼저 인출(pop)되는 구조
 * - Queue 인터페이스가 상속받아 사용하는 Collection 인터페이스 메소드)
 *  boolean add(E e) : 해당 큐의 맨 뒤에 전달된 요소를 삽입; 만약 삽입에 성공하면 true를
 * 반환하고, 큐에 여유 공간이 없어 삽입에 실패하면 IllegalStateException을 발생시킴
 *  E element() : 해당 큐의 맨 앞에 있는(제일 먼저 저장된) 요소를 반환
 *  boolean offer(E e) : 해당 큐의 맨 뒤에 전달된 요소를 삽입
 *  E peek() : 해당 큐의 맨 앞에 있는 요소를 반환; 만약 큐가 비어있으면 null 반환
 *  E poll() : 해당 큐의 맨 앞에 있는 요소를 반환하고, 해당 요소를 큐에서 제거; 만약 큐가
 * 비어있으면 null을 반환
 *  E remove() : 해당 큐의 맨 앞에 있는 요소를 제거
 *  => 더욱 복잡하고 빠른 스택 구현 : Deque 인터페이스를 구현한 ArrayDeque 클래스 사용
 *   Deque<Integer> st = new ArrayDeque<Integer>();
 */
public class stack_queue_co {
    public static void main(String[] args) {
        // Stack method
        Stack<Integer> st = new Stack<>();
        //Deque<Integer> st1 = new ArrayDeque<>();
        // push() 요소 저장
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        // peek() 요소 반환
        System.out.println(st.peek()); // 1
        System.out.println(st); // [4, 3, 2, 1]
        // pop() 요소 반환 및 제거
        System.out.println(st.pop()); // 1
        System.out.println(st); // [4, 3, 2]
        // search() 요소 위치 검색
        System.out.println(st.search(4)); // 3
        System.out.println(st.search(3)); // 2

        // LinkedList method
        LinkedList<String> qu = new LinkedList<>();
        //Deque<String> qu1 = new ArrayDeque<>();
        // add() 요소 저장
        qu.add("vier"); qu.add("drei"); qu.add("twei"); qu.add("eins");
        // peek() 요소 반환
        System.out.println(qu.peek()); // vier
        System.out.println(qu); // [vier, drei, twei, eins]
        // poll() 요소 반환 및 제거
        System.out.println(qu.poll()); // vier
        System.out.println(qu); // [drei, twei, eins]
        // remove() 요소 제거 
        qu.remove("eins");
        System.out.println(qu); // [drei, twei]
    }
}

// java SE 6부터 지원되는 ArrayDeque 클래스는 스택과 큐 메모리 구조를 모두 구현하는데 가장
// 적합한 클래스.