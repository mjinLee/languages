import java.io.*;
/** 
 * - 스트림(stream) : 파일이나 콘솔의 입출력을 직접 다루지 않고, 스트임이라는 흐름을 통해 다룸; 
 * 실제의 입력이나 출력이 표현된 데이터의 이상화된 흐름을 의미; 즉, 스트림은 운영체제에 의해 생성
 * 되는 가상의 연결고리를 의미하며, 중간 매개자 역할을 함
 *  cf. Java SE 8 버전부터 추가된 스트림 API는 앞서 설명한 스트림과는 전혀 다른 개념
 * - 입출력 스트림 : 스트림은 한 방향으로만 통신할 수 있으므로, 입력과 출력을 동시에 처리할 수는
 * 없음; 사용 목적에 따라 입력 스트림과 출력 스트림으로 구분; java.io 패키지를 통해 
 * InputStream과 OutputStream 클래스를 별도로 제공; 즉, 스트림 생성이란 이러한 스트림 클래스 
 * 타입의 인스턴스를 생성한다는 의미; InputStream 클래스에는 read() 메소드가, OutputStream 
 * 클래스에는 write() 메소드가 각각 추상 메소드로 포함되어 있음; 사용자는 이 두 메소드를 상황에 
 * 맞게 적절히 구현해야만 입출력 스트림을 생성하여 사용할 수 있음
 */
/**
 * - InputStream
 * 	abstract int read()	해당 입력 스트림으로부터 다음 바이트를 읽어들임
 *  int read(byte[] b)	해당 입력 스트림으로부터 특정 바이트를 읽어들인 후, 배열 b에 저장
 *  int read(byte[] b, int off, int len)	해당 입력 스트림으로부터 len 바이트를 읽어들인 
 * 후, 배열 b[off]부터 저장
 * - OutputStream
 * 	abstract void write(int b)	해당 출력 스트림에 특정 바이트를 저장
 *  void write(byte[] b)	배열 b의 특정 바이트를 배열 b의 길이만큼 해당 출력 스트림에 저장
 *  void write(byte[] b, int off, int len)	배열 b[off]부터 len 바이트를 해당 출력 스트림에
 * 저장
 * - read() 메소드는 해당 입력 스트림에서 더 이상 읽어들일 바이트가 없으면, -1을 반환;
 * 반환 타입을 byte 타입으로 하면, 0부터 255까지의 바이트 정보는 표현할 수 있지만 -1은 표현할 
 * 수 없게 됨; 그래서 InputStream의 read() 메소드는 반환 타입을 int형으로 선언하고 있음
 */
/**
 * - 바이트 기반 스트림 : 스트림은 기본적으로 바이트 단위로 데이터를 전송
 *  입력 스트림	             출력 스트림	           입출력 대상
 *  FileInputStream	        FileOutputStream	     파일
 *  ByteArrayInputStream	ByteArrayOutputStream 	 메모리
 *  PipedInputStream	    PipedOutputStream	     프로세스
 *  AudioInputStream	    AudioOutputStream	     오디오 장치
 */
/**
 * - 보조 스트림 : 실제로 데이터를 주고받을 수는 없지만, 다른 스트림의 기능을 향상시키거나 
 * 새로운 기능을 추가해 주는 스트림
 *  입력 스트림	             출력 스트림	          설명
 *  FilterInputStream	    FilterOutputStream	    필터를 이용한 입출력
 *  BufferedInputStream	    BufferedOutputStream	버퍼를 이용한 입출력
 *  DataInputStream	        DataOutputStream	    입출력 스트림으로부터 자바의 기본 타입으로 데이터를 읽어올 수 있게 함
 *  ObjectInputStream	    ObjectOutputStream	    데이터를 객체 단위로 읽거나, 읽어 들인 객체를 역직렬화
 *  SequenceInputStream	    X	                    두 개의 입력 스트림을 논리적으로 연결
 *  PushbackInputStream	    X	                    다른 입력 스트림에 버퍼를 이용하여 push back이나 unread와 같은 기능을 추가
 *  X	                    PrintStream	            다른 출력 스트림에 버퍼를 이용하여 다양한 데이터를 출력하기 위한 기능을 추가
 */
/**
 * - 문자 기반 스트림 : 가장 작은 타입인 char 형이 2바이트이므로, 1바이트씩 전송되는 바이트 
 * 기반 스트림으로는 원활한 처리가 힘든 경우가 있음; 바이트 기반 스트림뿐만 아니라 문자 기반의 
 * 스트림도 별도로 제공; 기존의 바이트 기반 스트림에서 InputStream을 Reader로, OutputStream을
 * Writer로 변경하면 사용할 수 있음
 *  입력 스트림	         출력 스트림	     입출력 대상
 *  FileReader	        FileWriter	       파일
 *  CharArrayReader	    CharArrayWriter	   메모리
 *  PipedReader	        PipedWriter	       프로세스
 *  StringReader	    StringWriter	   문자열
 * - 문자 기반의 보조 스트림
 *  입력 스트림	        출력 스트림	          설명
 *  FilterReader	    FilterWriter	    필터를 이용한 입출력
 *  BufferedReader	    BufferedWriter	    버퍼를 이용한 입출력
 *  PushbackReader	    X	                다른 입력 스트림에 버퍼를 이용하여 push back이나 unread와 같은 기능을 추가
 *  X	                PrintWriter	        다른 출력 스트림에 버퍼를 이용하여 다양한 데이터를 출력하기 위한 기능을 추가
 */

/**
 * - 파일 입출력
 * - 표준 입출력 :  콘솔과 같은 표준 입출력 장치를 위해 System이라는 표준 입출력 클래스를 정의;
 * java.lang 패키지에 포함되어 있는 System 클래스는 표준 입출력을 위해 다음과 같은 클래스 변수
 * 를 제공
 *  클래스 변수	    입출력 스트림	  설명
 *  System.in	    InputStream	    콘솔로부터 데이터를 입력받음
 *  System.out	    PrintStream	    콘솔로 데이터를 출력
 *  System.err	    PrintStream	    콘솔로 데이터를 출력
 * - 표준 입출력 스트림은 자바가 자동으로 생성하므로, 개발자가 별도로 스트림을 생성하지 않아도 
 * 사용할 수 있음
 */
/**
 * - 표준 입출력의 대상 변경 : 앞서 살펴본 세 가지 입출력 스트림은 모두 콘솔과 같은 표준 입출력
 * 장치를 대상으로 함; 하지만 이와 같은 스트림에 다음 System 메소드를 사용하면 스트림의 대상을
 * 다른 입출력 장치로 변경할 수 있음
 *  메소드	                              설명
 *  static void setIn(InputStream in)	 입력 스트림의 대상을 전달된 입력 스트림으로 변경
 *  static void setOut(PrintStream out)	 출력 스트림의 대상을 전달된 출력 스트림으로 변경
 *  static void setErr(PrintStream err)	 출력 스트림의 대상을 전달된 출력 스트림으로 변경
 *
 * - RandomAccessFile 클래스 : 앞서 살펴본 다양한 입출력 스트림을 이용하면 파일에 순차적으로 
 * 입출력 작업을 수행할 수 있음; 하지만 순차적인 접근이 아닌 임의의 지점에 접근하여 작업을 
 * 수행하고 싶다면, RandomAccessFile 클래스를 사용하면 됨; 이 클래스는 파일만을 대상으로 하며,
 * 임의의 지점에서 입출력을 동시에 수행할 수 있음
 *  - RandomAccessFile 클래스의 생성자에는 인수로 파일의 이름뿐만 아니라 파일 모드까지 함께 
 * 전달해야 함
 *  - 파일 모드 : 파일의 사용 용도를 나타내는 문자열
 *   파일 모드	설명
 *   "r"	    파일을 오로지 읽는 것만 가능한 모드로 개방
 *   "rw"	    파일을 읽고 쓰는 것이 모두 가능한 모드로 개방; 파일이 없으면 새로운 파일을 생성
 *  - getFilePointer() 메소드를 사용하면 파일 포인터의 현재 위치를 확인할 수 있음; 또한, 
 *   seek() 메소드를 사용하면 파일 포인터의 위치를 변경할 수도 있음
 */

public class fileInOut {
    public static void main(String[] args) {
        // RandomAccessFile class
        try (// "rw" 모드로 "data.txt" 파일을 개방함.   
        RandomAccessFile file = new RandomAccessFile("data.txt", "rw")) {
            System.out.println(file.getFilePointer()); // 0 : 파일 포인터의 현재 위치를 반환    
            file.writeInt(10);                         // 정수 10을 저장   
            System.out.println(file.getFilePointer()); // 4   
            file.seek(20);                             // 파일 포인터의 위치를 20으로 이동 
            System.out.println(file.getFilePointer()); // 20             
        } catch (IOException e) {   
            e.printStackTrace();   
        }

        // File class
        File dir = new File("D:\\data");  // 디렉터리 생성
        File file = new File(dir, "data.txt"); // 파일 생성
        if(!file.exists()) {                   // 파일이 생성되었는지를 확인
            System.out.println("파일이 존재하지 않습니다.");
            System.exit(0);
        }
        System.out.println(file.getPath());    // D:\data\data.txt
        System.out.println(file.length());     // 파일의 크기를 반환
    }
}

/** 
 * - File class : 앞서 살펴본 입출력 스트림을 사용하면 파일을 통한 입출력 작업을 수행할 수 있음;
 * 하지만 파일의 제거나 디렉터리에 관한 작업 등은 입출력 스트림을 통해서는 수행할 수 없음;
 * 이러한 입출력 작업 이외의 파일과 디렉터리에 관한 작업을 File 클래스를 통해 처리하도록 하고 있음
 *  boolean canRead() : 해당 파일이 읽을 수 있는 파일인지를 검사
 *  boolean canWrite() : 해당 파일이 쓸 수 있는 파일인지를 검사
 *  boolean delete() : 해당 파일 또는 디렉터리를 삭제
 *  boolean exists() : 해당 파일이 존재하는지를 검사
 *  String getPath() : 해당 파일의 경로명을 문자열로 반환
 *  boolean isAbsolute() : 해당 파일의 경로명이 절대 경로인지를 검사
 *  boolean isDirectory() : 해당 파일이 디렉터리인지를 검사
 *  boolean isFile() : 해당 파일이 파일인지를 검사
 *  long length() : 해당 파일의 크기를 반환
 *  boolean mkdir() : 지정된 경로에 디렉터리를 생성
 *  boolean mkdirs() : 지정된 경로에 디렉터리를 생성하며, 필요한 모든 상위 디렉터리도 생성
 *  boolean renameTo(File dest) : 해당 파일의 이름을 전달된 파일 이름으로 변경
 *  boolean setExecutable(boolean executable), boolean setReadable(boolean readable),
 *  boolean setWritable(boolean writable), boolean setReadOnly() : 해당 파일의 속성을 변경
 */