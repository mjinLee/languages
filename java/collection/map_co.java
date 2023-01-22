package collection;

import java.util.*;

/**
 * - Map 컬렉션 클래스 : 키와 값을 하나의 쌍으로 저장하는 방식(key-value방식)을 사용;
 *  key-실질적인 값(value)을 찾기 위한 이름의 역할
 *  - 요소의 저장 순서를 유지하지 않음
 *  - 키는 중복을 허용하지 않지만, 값의 중복은 허용
 *  1 HashMap<K,V>
 *  2 Hashtable<K,V>
 *  3 TreeMap<K,V>
 */
/**
 * - HashMap<K,V> 클래스 :  가장 많이 사용되는 클래스 중 하나; JDK 1.2부터 제공된 HashMap 
 * 클래스는 해시 알고리즘(hash algorithm)을 사용하여 검색 속도가 매우 빠름; HashMap 클래스는 
 * Map 인터페이스를 구현하므로, 중복된 키로는 값을 저장할 수 없음; 같은 값을 다른 키로 저장하는
 * 것은 가능
 * - Hashtable<K,V> 클래스 : HashMap 클래스와 같은 동작을 하는 클래스; Map 인터페이스를 
 * 상속받음; 따라서 Hashtable 클래스에서 사용할 수 있는 메소드는 HashMap 클래스에서 사용할
 * 수 있는 메소드와 거의 같음; 하지만 현재에는 기존 코드와의 호환성을 위해서만 남아있으므로, 
 * Hashtable 클래스보다는 HashMap 클래스를 사용하는 것이 좋음
 *  - TreeMap<K,V> 클래스 :  키와 값을 한 쌍으로 하는 데이터를 이진 검색 트리
 * (binary search tree)의 형태로 저장; 이진 검색 트리는 데이터를 추가하거나 제거하는 등의 
 * 기본 동작 시간이 매우 빠름; JDK 1.2부터 제공된 TreeMap 클래스는 NavigableMap 인터페이스를 
 * 기존의 이진 검색 트리의 성능을 향상시킨 레드-블랙 트리(Red-Black tree)로 구현;
 * TreeMap 클래스는 Map 인터페이스를 구현하므로, 중복된 키로는 값을 저장할 수 없음; 하지만
 * 같은 값을 다른 키로 저장하는 것은 가능
 */

public class map_co {
    public static void main(String[] args) {
        // HashMap
        HashMap<String,Integer> hm = new HashMap<>();
        // put() method 요소 저장
        hm.put("삼십", 30);
        hm.put("십", 10);
        hm.put("사십", 40);
        hm.put("이십", 20);
        // Enhanced for , get() 요소 출력
        System.out.println("맵에 저장된 키들의 집합 : " + hm.keySet());
         // keySet() : 해당 맵에 포함된 모든 키 값들을 하나의 집합(Set)으로 반환
        for (String key : hm.keySet()) {
            System.out.println(String.format("키 : %s, 값 : %s", key, hm.get(key)));
        }
        // 요소 제거
        hm.remove("사십");
        // 요소 출력
        Iterator<String> keys = hm.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(String.format("키 : %s, 값 : %s", key, hm.get(key)));
        }
        // 요소 수정
        hm.replace("이십", 200);
        // 출력
        for (String key : hm.keySet()) {
            System.out.println(String.format("키 : %s, 값 : %s", key, hm.get(key)));
        }
        // size() 메소드를 이용한 요소의 총 개수        
        System.out.println("맵의 크기 : " + hm.size());

        // TreeMap
        TreeMap<Integer, String> tm = new TreeMap<Integer, String>();   
        // put() 메소드를 이용한 요소의 저장
        tm.put(30, "삼십");
        tm.put(10, "십");
        tm.put(40, "사십");
        tm.put(20, "이십");
        // Enhanced for 문과 get() 메소드를 이용한 요소의 출력
        System.out.println("맵에 저장된 키들의 집합 : " + tm.keySet());
        for (Integer key : tm.keySet()) {
            System.out.println(String.format("키 : %s, 값 : %s", key, tm.get(key)));
        }
        // remove() 메소드를 이용한 요소의 제거
        tm.remove(40);
        // iterator() 메소드와 get() 메소드를 이용한 요소의 출력
        Iterator<Integer> keys = tm.keySet().iterator();
        while (keys.hasNext()) {
            Integer key = keys.next();
            System.out.println(String.format("키 : %s, 값 : %s", key, tm.get(key)));
        }
        // replace() 메소드를 이용한 요소의 수정
        tm.replace(20, "twenty");

        for (Integer key : tm.keySet()) {
            System.out.println(String.format("키 : %s, 값 : %s", key, tm.get(key)));
        }
        // size() 메소드를 이용한 요소의 총 개수
        System.out.println("맵의 크기 : " + tm.size());
    }
}

/** */