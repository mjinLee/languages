import java.util.Arrays;

public class array {
    public static void main(String[] args) {
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        arr1[0]=30;
        arr1[1]=40;
        arr1[2]=50;
        arr2[0]=10;
        for(int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+ " ");
        } // 30 40 50
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+ " ");
        } // 10

        int[] grade1 = {10,20,30}; // 배열 선언과 동시에 초기화
        int[] grade2 = new int[]{40,50,60}; // 배열 선언과 동시에 초기화
        int[] grade3; // 배열 선언
        grade3 = new int[]{70,80,90}; // 이미 선언된 배열의 초기화
        int sum=0;
        for(int i=0;i<grade3.length;i++){
            sum += grade3[i];
        }
        System.out.println("모든 과목 총점 : "+sum); // 240
        System.out.println("평균 : "+(sum/grade3.length)); // 80

        // 다차원 배열
        int[][] arr = new int[2][3];
        int k=10;
        for(int i=0; i<arr.length; i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = k; // 인덱스를 이용한 초기화
                k += 10;
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        } // 10 20 30 | 40 50 60

        int[][] a = { {10,20,30}, {40,50,60} };
        
        int[][] b = new int[3][]; // 가변 배열
        b[0] = new int[2];
        b[1] = new int[4];
        b[2] = new int[1]; // 행마다 다른 길이의 배열 요소 저장 가능
        
        int[][] c = { {10,20}, {10,20,30,40}, {10} };

        // 배열 복사
        /*
         * - 1 System 클래스의 arraycopy() 메소드
         * - 2 Arrays 클래스의 copyOf() 메소드
         * - 3 Object 클래스의 clone() 메소드 - 이전 배열과 같은 길이의 배열만 만들 수 있음
         * - 4 for 문과 인덱스를 이용한 복사
         */
        int[] bae1 = new int[]{1,2,3,4,5};
        int newLen = 10;
        // 1
        int[] bae2 = new int[newLen];
        System.arraycopy(bae1, 0, bae2, 0, bae1.length);
        // 2
        int[] bae3 = Arrays.copyOf(bae1, newLen);
        // 3
        int[] bae4 = (int[])bae1.clone();
        // 4
        int[] bae5 = new int[newLen];

        // Enhanced for 문
        /*
         * Enhanced for 문은 요소를 참조할 때만 사용하는 것이 좋으며,
         * 요소의 값을 변경하는 작업에는 적합하지 않음
         * for(타입 변수이름 : 배열이나컬렉션이름){
         *    배열의 길이만큼 반복적으로 실행하고자 하는 명령문;
         * }
         */
        int[] enhan = new int[]{1,2,3,4,5};
        for(int e:enhan){
            System.out.print(e+" ");
        } // 1 2 3 4 5
        // 모든 배열 요소에 10을 더하는 예제
        int[] ar1 = new int[]{1,2,3,4,5};
        int[] ar2 = new int[]{1,2,3,4,5};
        for(int i=0; i<ar1.length;i++){
            ar1[i] += 10;
        }
        for(int e:ar2){
            e += 10;
            System.out.print(e + " ");
        } // 11 12 13 14 15
        for(int i=0; i<ar2.length;i++){
            System.out.print(ar2[i] + " ");
        } // 1 2 3 4 5
        // => Enhance for 문 내부에서 사용되는 배열 요소는 배열 요소 그 자체가 아닌 복사본
        // Enhance for 문에서 배열 요소의 값을 변경하여도 원본 배열에는 아무런 영향을 주지 못함
     }
}
