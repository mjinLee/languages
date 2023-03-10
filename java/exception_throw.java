import java.io.*;

/**
 * - 예외 발생시키기 : throw 키워드를 사용하여 강제로 예외를 발생시킬 수 있음
 *    Exception e = new Exception("오류 메시지");
 *    throw e;
 *   - 생성자에 전달된 문자열은 getMessage() 메소드를 사용하여 오류 메시지로 출력할 수 있음
 * - 예외 회피하기 : 메소드 선언부에 throws 키워드를 사용하여 해당 메소드를 사용할 때 발생할 
 * 수 있는 예외를 미리 명시할 수도 있음; 그러면 해당 메소드를 사용할 때 발생할 수 있는 예외를 
 * 사용자가 충분히 인지할 수 있으며, 그에 대한 처리까지도 강제할 수 있음
 *  => 1), 2)
 */

/**
 * - 사용자 정의 예외 클래스 : Exception 클래스를 상속받아 자신만의 새로운 예외 클래스를 
 * 정의하여 사용할 수 있음; 사용자 정의 예외 클래스에는 생성자뿐만 아니라 필드 및 메소드도 
 * 원하는 만큼 추가할 수 있음; Exception 클래스가 아닌 예외 처리를 강제하지 않는 
 * RuntimeException 클래스를 상속받아 작성하는 경우가 많음
 *  => 3)
 */
// 3)
class MyException extends RuntimeException {
    MyException(String errMsg){
        super(errMsg);
    }
}

public class exception_throw {
    // 1) 호출된 메소드에서 발생한 예외를 호출된 메소드에서 처리하는 예제
    static void handlingException(){
        try{
            throw new Exception();
        } catch (Exception e){
            System.out.println("호출된 메소드에서 예외가 처리됨");
        }
    }
    // 이때 호출된 메소드의 try / catch 문을 생략하면 컴파일 오류가 발생함
    // 이 메소드를 호출한 main() 메소드는 호출된 메소드에서 예외가 발생한 사실을 알 수 없음
    
    // 2) throws 키워드를 사용하여 호출된 메소드에서 발생한 예외를 호출한 메소드로 넘기는 예제
    static void handlingException2() throws Exception { throw new Exception(); }
    // 이렇게 함으로써 호출된 메소드에는 try / catch 문을 생략할 수 있음
    // 그리고 호출된 메소드에서 발생한 예외를 해당 메소드를 호출한 main() 메소드에서 처리할 수
    // 있게 됨

    /**
     * - try-with-resources 문 : Java SE 7부터는 사용한 자원을 자동으로 해제해 주는 
     * try-with-resources 문을 사용할 수 있음; try 블록에 괄호(())를 추가하여 파일을 
     * 열거나 자원을 할당하는 명령문을 명시하면, 해당 try 블록이 끝나자마자 자동으로 파일을
     * 닫거나 할당된 자원을 해제해줌
     * - Java SE 7 이전에서는 finally 블록을 사용하여 사용한 파일을 닫아줘야 했음 => 4)
     * - 하지만 try-with-resources 문을 사용하면 다음과 같이 자동으로 파일의 닫기를 수행할
     * 수 있음 => 5)
     */
    // 4) 파일에서 문자열을 한 줄 읽어오는 예제
    static String readFile(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            return br.readLine();
        } finally {
            if (br != null)
                br.close();        
        }        
    }
    // 5)
    static String readFile2(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {    
            return br.readLine();    
        }    
    }

    public static void main(String[] args) {
        // 1)
        try {
            handlingException();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("호출된 메소드에서 예외가 처리됨");
        }

        // 2)
        try {
            handlingException2();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("main() 메소드에서 예외가 처리됨");
        }
    }
}
