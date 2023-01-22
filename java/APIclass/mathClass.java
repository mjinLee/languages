package APIclass;

import java.util.Random;

/**
 * - java.lang.Math 클래스 : 수학에서 자주 사용하는 상수, 함수들을 미리 구현해 놓음; 모든
 *  메소드는 클래스 메소드(static method)이므로, 객체를 생성하지 않고도 바로 사용 가능
 * - Math 클래스에 정의되어 있는 클래스 필드)
 *  1 Math.E : 오일러의 수; 자연로그의 밑(base)값으로 약 2.718을 의미
 *  2 Math.PI : 원의 원주를 지름으로 나눈 비율(원주율)값으로 약 3.14159를 의미
 */
/**
 * - random() 메소드 : 0.0 이상 1.0 미만의 범위에서 임의의 double형 값을 하나 생성하여 반환;
 * 이 메소드는 내부적으로 java.util 패키지의 Random 클래스를 사용한 의사 난수 발생기를 사용
 * 하여 임의의 수를 생성; nextInt() 메소드를 사용해도 난수 생성 가능
 * - abs() 메소드 : 전달된 값이 음수이면 그 값의 절댓값을 반환하며, 전달된 값이 양수이면
 * 전달된 값을 그대로 반환
 * - floor() 메소드 : 인수로 전달받은 값과 같거나 작은 수 중에서 가장 큰 정수를 반환
 * - ceil() 메소드 : 인수로 전달받은 값과 같거나 큰 수 중에서 가장 작은 정수를 반환
 * - round() 메소드 : 전달받은 실수를 소수점 첫째 자리에서 반올림한 정수를 반환
 * - max() 메소드 : 전달된 두 값을 비교하여 그 중에서 큰 값을 반환
 * - min() 메소드 : 그 중에서 작은 값을 반환
 * - pow() 메소드 : 전달된 두 개의 double형 값을 가지고 제곱 연산 수행
 *   => pow(a,b)는 a의 b승, 즉 a^b를 반환
 * - sqrt() 메소드 : 전달된 double형 값의 제곱근 값을 반환
 * - sin(), cos(), tan(), asin(), acos(), atan(), atan2(), sinh(), cosh(), tanh()
 */

public class mathClass {
    public static void main(String[] args) {
        // random() method
        System.out.println((int)(Math.random() * 100)); // 0 ~ 99까지의 난수 생성

        Random ran = new Random();
        System.out.println(ran.nextInt(100)); // 0 ~ 99까지의 난수 생성
        /**
         * - 특정 범위에 속하는 난수를 생성하려면, 난수 생성 범위를 조절할 수 있음
         *  (int)(Math.random() * 6); // 0 ~ 5
         *  ((int)(Math.random() * 6) + 1); // 1 ~ 6
         *  ((int)(Math.random() * 6) + 3); // 3 ~ 8
         */

         // abs() method
         System.out.println(Math.abs(10));    // 10
         System.out.println(Math.abs(-10));   // 10
         System.out.println(Math.abs(-3.14)); // 3.14

         // floor(), ceil(), round() method
         System.out.println(Math.ceil(10.0));      // 10.0
         System.out.println(Math.ceil(10.1));      // 11.0
         System.out.println(Math.ceil(10.000001)); // 11.0

         System.out.println(Math.floor(10.0));     // 10.0
         System.out.println(Math.floor(10.9));     // 10.0
 
         System.out.println(Math.round(10.0));     // 10
         System.out.println(Math.round(10.4));     // 10
         System.out.println(Math.round(10.5));     // 11

         // max(), min() method
         System.out.println(Math.max(3.14, 3.14159)); // 3.14159
         System.out.println(Math.min(3.14, 3.14159)); // 3.14
         System.out.println(Math.max(-10, -11));      // -10
         System.out.println(Math.min(-10, -11));      // -11

         // pow(), sqrt() method
         System.out.println((int)Math.pow(5, 2)); // 25
         System.out.println((int)Math.sqrt(25));  // 5

         // sin(), cos(), tan() method
         System.out.println(Math.sin(Math.toRadians(30)));
         System.out.println(Math.sin(Math.PI / 6));
         System.out.println(Math.cos(Math.toRadians(60)));
         System.out.println(Math.cos(Math.PI / 3));
         System.out.println(Math.tan(Math.toRadians(45)));
         System.out.println(Math.tan(Math.PI / 4));
         // 삼각 함수에 관한 메소드는 정확한 값을 나타내지 못함
         // 컴퓨터가 실수를 나타내는 데 사용하는 부동 소수점 방식의 한계 
    }
}

/**
 * - Math 클래스의 메소드)
 *  static double random() : 0.0 이상 1.0 미만의 범위에서 임의의 double형 값을 하나 생성하여 
 * 반환
 *  static double abs(double a), static double abs(float a), static double abs(int a),
 *  static double abs(long a) : 전달된 값이 음수이면 그 값의 절댓값을 반환하며, 전달된 값이 
 * 양수이면 인수를 그대로 반환
 *  static double ceil(double a) : 전달된 double형 값의 소수 부분이 존재하면 소수 부분을 
 * 무조건 올리고 반환
 *  static double floor(double a) : 전달된 double형 값의 소수 부분이 존재하면 소수 부분을 
 * 무조건 버리고 반환
 *  static long round(double a), static int round(float a) : 전달된 값을 소수점 첫째 
 * 자리에서 반올림한 정수를 반환
 *  static double rint(double a) : 전달된 double형 값과 가장 가까운 정수값을 double형으로 
 * 반환
 *  static double max(double a, double b), static float max(float a, float b),
 *  static long max(long a, long b), static int max(int a, int b) : 전달된 두 값을 비교
 * 하여 큰 값을 반환
 *  static double min(double a, double b), static float min(float a, float b),
 *  static long min(long a, long b), static int min(int a, int b) : 전달된 두 값을 비교
 * 하여 작은 값을 반환
 *  static double pow(double a, double b) : 전달된 두 개의 double형 값을 가지고 제곱 연산을
 * 수행하여, ab을 반환
 *  static double sqrt(double a) : 전달된 double형 값의 제곱근 값을 반환
 *  static double sin(double a), static double cos(double a), 
 *  static double tan(double a) : 전달된 double형 값에 해당하는 각각의 삼각 함숫값을 반환
 *  static double toDegrees(double angrad) : 호도법의 라디안 값을 대략적인 육십분법의 각도 
 * 값으로 변환
 *  static double toRaidans(double angdeg) : 육십분법의 각도 값을 대략적인 호도법의 라디안 
 * 값으로 변환
 */