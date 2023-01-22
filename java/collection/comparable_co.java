package collection;

import java.util.*;

/**
 * - Comparable<T> 인터페이스 : 객체를 정렬하는 데 사용되는 메소드인 compareTo() 메소드를
 * 정의하고 있음; 같은 타입의 인스턴스를 서로 비교해야만 하는 클래스들은 모두 Comparable
 * 인터페이스를 구현하고 있음; 따라서 Boolean을 제외한 래퍼 클래스나 String, Time, Date와
 * 같은 클래스의 인스턴스는 모두 정렬 가능함; 이때 기본 정렬 순서는 오름차순
 *  - int compareTo(T o) : 해당 객체와 전달된 객체의 순서를 비교
 */
class Cars implements Comparable<Cars>{
    private String modelName;
    private int modelYear;
    private String color;

    Cars(String mn, int my, String c){
        this.modelName = mn;
        this.modelYear = my;
        this.color = c;
    }
    public String getModel(){
        return this.modelYear+"식"+this.modelName+" "+this.color;
    }
    @Override
    public int compareTo(Cars o) {
        // TODO Auto-generated catch block
        if(this.modelYear == o.modelYear)
            return 0;
        else if(this.modelYear < o.modelYear)
            return -1;
        else
            return 1;
    }
}
/**
 * - Comparator<T> 인터페이스 : Comparable 인터페이스와 같이 객체를 정렬하는 데 사용되는 
 * 인터페이스; 내림차순이나 아니면 다른 기준으로 정렬하고 싶을 때 사용; 즉, 오름차순 이외의 
 * 기준으로도 정렬할 수 있게 되는 것; 이때 Comparator 인터페이스를 구현한 클래스에서는 
 * compare() 메소드를 재정의하여 사용
 *  - int compare(T o1, T o2)	전달된 두 객체의 순서를 비교
 *  - boolean equals(Object obj)	해당 comparator와 전달된 객체가 같은지를 확인
 *  - default Comparator<T> reversed()	해당 comparator의 역순인 comparator를 반환
 */
class DescendingOrder implements Comparator<Integer>{
    public int compare(Integer o1, Integer o2){
        if(o1 instanceof Comparable && o2 instanceof Comparable){
            Integer c1 = (Integer)o1;
            Integer c2 = (Integer)o2;
            return c2.compareTo(c1);
        }
        return -1;
    }
}

public class comparable_co {
    public static void main(String[] args) {
        // Comparable
        Cars c01 = new Cars("sonata", 2020, "white");
        Cars c02 = new Cars("niro", 2019, "blue");
        System.out.println(c01.compareTo(c02)); // 1

        // Comparator
        TreeSet<Integer> ts = new TreeSet<Integer>(new DescendingOrder());
        ts.add(30);
        ts.add(40);
        ts.add(20);
        ts.add(10);
        Iterator<Integer> iter = ts.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        } // 40 30 20 10
    }
}
