import java.io.IOException;

/**
 * - 예외 처리(exception handling) : 프로그램이 실행되는 도중 발생하는 예외를 처리 하기 위해
 * try / catch / finally 문을 사용할 수 있음
 *  1 try 블록 : 기본적으로 맨 먼저 실행되는 코드로 여기에서 발생한 예외는 catch 블록에서 처리
 *  2 catch 블록 : try 블록에서 발생한 예외 코드나 예외 객체를 인수로 전달받아 그 처리를 담당
 *  3 finally 블록 : 이 블록은 try 블록에서 예외가 발생하건 안 하건 맨 마지막에 무조건 실행
 *  - catch 블록과 finally 블록은 선택적인 옵션으로 반드시 사용할 필요는 없음
 *  - ex. try / catch | try / finally | try / catch / .. / finally
 *  - 다른 제어문과는 달리 예외 처리문은 중괄호({})를 생략할 수 없음
 * - Exception 클래스 : 모든 예외의 조상 클래스
 *  1 RuntimeException 클래스 : 주로 치명적인 예외 상황을 발생시키지 않는 예외들로 구성;
 * 따라서  try / catch 문을 사용하기보다는 프로그램을 작성하면서 예외가 발생하지 않도록 
 * 주의를 기울이는 편이 좋음
 *  2 그 외의 Exception 클래스의 자식 클래스 : 치명적인 예외 상황을 발생시키므로, 
 * 반드시 try / catch 문을 사용하여 예외를 처리; 따라서 자바 컴파일러는 RuntimeException 
 * 클래스 이외의 Exception 클래스의 자식 클래스에 속하는 예외가 발생할 가능성이 있는 구문에는
 * 반드시 예외를 처리하도록 강제하고 있음; 만약 이러한 예외가 발생할 가능성이 있는 구문을 
 * 예외 처리하지 않았을 때는 컴파일 시 오류를 발생시킴
 */

public class exceptions {
    public static void main(String[] args) {
        // PrintStream 클래스의 write() 메소드를 사용하여 byte 타입 배열의 모든 요소 출력
        byte[] list = {'a', 'b', 'c'};
        // IOException에 대한 예외 처리까지 해 주어야만 컴파일 할 수 있음
        try {
            System.out.write(list); // a b c
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * - 자바에서는 예외가 발생하면, try 블록과 가장 가까운 catch 블록부터 순서대로 검사;
         * 따라서 여러 개의 catch 블록을 사용할 때는 Exception 클래스의 계층 관계에도 주의
         * - 위의 예제에서 IOException이 발생하면, 첫 번째 catch 블록에서 해당 예외를 처리;
         * IOException 외의 Exception 클래스의 자식 클래스에 해당하는 예외가 발생하면, 
         * 두 번째 catch 블록에서 처리될 것; 이처럼 범위가 더 좁은 예외를 처리하는 catch 
         * 블록을 먼저 명시하고, 범위가 더 넓은 예외를 처리하는 catch 블록은 나중에 명시해야만
         * 정상적으로 해당 예외를 처리할 수 있음
         */

         /**
          * - 여러 예외 타입의 동시 처리
          * - Java SE 7부터는 '|' 기호를 사용하여 하나의 catch 블록에서 여러 타입의 예외를 
          * 동시에 처리할 수 있음
          *      try {
          *          this.db.commit();        
          *      } catch (IOException | SQLException e) {        
          *          e.printStackTrace();        
          *      }
          * - 하지만 둘 이상의 예외 타입를 동시에 처리하는 catch 블록에서 매개변수로 전달받은 
          * 예외 객체는 묵시적으로 final 제어자를 가지게 됨; 따라서 catch 블록 내에서 해당 
          * 매개변수에는 어떠한 값도 대입할 수 없음
          */
        
          /**
           * - Throwable 클래스 : 모든 예외의 조상이 되는 Exception 클래스와 모든 오류의 
           * 조상이 되는 Error 클래스의 부모 클래스; Throwable 타입과 이 클래스를 상속받은 
           * 서브 타입만이 자바 가상 머신(JVM)이나 throw 키워드에 의해 던져질 수 있음
           *  - String getMessage()	해당 throwable 객체에 대한 자세한 내용을 문자열로 반환
           *  - void printStackTrace()	해당 throwable 객체와 표준 오류 스트림
           * (standard error stream)에서 해당 객체의 스택 트레이스(stack trace)를 출력
           *  - String toString()	해당 throwable 객체에 대한 간략한 내용을 문자열로 반환
           */
          // 숫자를 0으로 나눠 ArithmeticException 오류를 발생시키는 예제
          // Throwable 메소드를 사용하여 발생한 오류에 대한 정보를 출력
          try {
            System.out.println(5 / 0);
          } catch (ArithmeticException e) {
            System.out.println("현재 발생한 예외 정보 : " + e.getMessage());
          } // 현재 발생한 예외 정보 : / by zero

          /**
           * - 자주 사용되는 예외 클래스)
           *  ClassCastException	수행할 수 없는 타입 변환이 진행될 경우
           *  ArrayIndexOutOfBoundsException	배열에 잘못된 인덱스를 사용하여 접근할 경우
           *  NullPointerException	null 객체의 인스턴스 메소드를 호출하는 등의 경우
           *  ArithmeticException	산술 연산에서 정수를 0으로 나누는 등 연산을 수행할 수 없는 경우
           */
    }
}
