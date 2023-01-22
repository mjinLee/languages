package APIclass;

import java.util.Arrays;

/**
 * - java.util.Arrays 클래스 : 배열을 다루기 위한 다양한 메소드가 포함되어 있음; 모든 메소드는
 *  클래스 메소드(static method)이므로, 객체를 생성하지 않고도 바로 사용할 수 있음
 * - import java.util.*
 */
/**
 * - binarySearch() 메소드 : 전달받은 배열에서 특정 객체의 위치를 이진 검색 알고리즘을 사용하여
 * 검색한 후, 해당 위치를 반환; 이 메소드는 이진 검색 알고리즘을 사용하므로, 매개변수로 전달되는
 * 배열이 sort() 메소드 등을 사용하여 미리 정렬되어 있어야만 제대로 동작함
 * - copyOf() 메소드 : 전달받은 배열의 특정 길이만큼을 새로운 배열로 복사하여 반환; 첫 번째
 * 매개변수로 원본 배열을 전달받고, 두 번째 매개변수로 원본 배열에서 새로운 배열로 복사할 요소의
 * 개수를 전달받음. 그리고 원본 배열과 같은 타입의 복사된 새로운 배열을 반환; 새로운 배열의
 * 길이가 원본 배열보다 길면, 나머지 요소는 배열 요소의 타입에 맞게 기본값(0,false,null,...)
 * 으로 채워짐
 * - copyOfRange() 메소드 : 전달받은 배열의 특정 범위에 해당하는 요소만을 새로운 배열로 복사하여
 * 반환
 *  => copyOfRange(복사대상이 될 원본 배열, 원본 배열에서 복사할 시작 인덱스, 마지막으로 복사될
 *    배열 요소의 바로 다음 인덱스);
 *  즉, 세 번째 매개변수로 전달된 인덱스 바로 전까지의 배열 요소까지만 복사됨. 그리고 원본 배열과
 * 같은 타입의 복사된 새로운 배열을 반환
 * - fill() method : 전달받은 배열의 모든 요소를 특정 값으로 초기화해줌
 *  => fill(초기화할 배열, 초기값);
 *  따라서 이 메소드는 전달받은 원본 배열의 값을 변경하게 됨
 * - sort() 메소드 : 전달받은 배열의 모든 요소를 오름차순으로 정렬; 매개변수로 정렬할 배열을 전달
 * 받으며, 이 메소드는 전달받은 원본 배열의 순서를 변경하게 됨
 */

public class arraysClass {
    public static void main(String[] args) {
        // binarySearch() method
        int[] arr = new int[1000];
        for(int i=0; i<arr.length; i++){
            arr[i] = i;
        }
        System.out.println(Arrays.binarySearch(arr, 437)); // 437

        // copyOf() method
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = Arrays.copyOf(arr1, 3);
        for(int i=0;i<arr2.length; i++){
            System.out.print(arr2[i]+" ");
        } // 1 2 3
        int[] arr3 = Arrays.copyOf(arr1, 10);
        for(int i=0;i<arr3.length; i++){
            System.out.print(arr3[i]+" ");
        } // 1 2 3 4 5 0 0 0 0 0

        // copyOfRange() method
        int[] ar1 = {1,2,3,4,5};
        int[] ar2 = Arrays.copyOfRange(ar1, 2, 4);
        for(int i=0;i<ar2.length; i++){
            System.out.print(ar2[i]+" ");
        } // 3 4

        // fill() method
        int[] ar = new int[5];
        Arrays.fill(ar, 7);
        for(int i=0; i<ar.length; i++)
            System.out.print(ar[i]+" ");
        // 7 7 7 7 7 

        // sort() method
        int[] a = {5,3,4,1,2};
        Arrays.sort(a);
        for(int i=0; i<a.length; i++)
            System.out.print(a[i]+" ");
        // 1 2 3 4 5 
    }
}

/**
 * - Arrays 클래스의 메소드)
 *  static <T> List<T> asList(T... a) : 전달받은 배열을 고정 크기의 list로 변환하여 반환
 *  static int binarySearch(Object[] a, Object key) : 전달받은 배열에서 특정 객체를 이진 검색 
 * 알고리즘을 사용하여 검색한 후, 그 위치를 반환
 *  static <T> T[] copyOf(T[] original, int newLength) : 전달받은 배열을 특정 길이의 새로운 
 * 배열로 복사하여 반환
 *  static <T> T[] copyOfRange(T[] original, int from, int to) : 전달받은 배열의 특정 범위에 
 * 해당하는 요소만을 새로운 배열로 복사하여 반환
 *  static boolean equals(Object[] a, Object[] a2) : 전달받은 두 배열이 같은지를 확인
 *  static void fill(Object[] a, Object val) : 전달받은 배열의 모든 요소를 특정 값으로 초기화
 *  static void sort(Object[] a) : 전달받은 배열의 모든 요소를 오름차순으로 정렬
 */