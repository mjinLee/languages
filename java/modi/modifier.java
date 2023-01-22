/**
 * package 패키지이름;
 * import 패키지이름.클래스이름;
 * import 패키지이름.*;
 */

/**
 * 접근 제어자(access modifier)
 * 1 private : 선언한 클래스에서만 접근 가능
 * 2 public : 어디에서 누구나 접근 가능
 *  - public 메소드를 통해서만 해당 객체의 private에 접근 가능
 * 3 default : 접근 제어의 기본값; 같은 패키지, 같은 클래스만 접근 가능
 * - java class는 private 멤버로 정보를 은닉하고, public 멤버로 사용자나 프로그램과의
 *  인터페이스를 구축함. 여기에 부모클래스와 관련된 접근 제어자가 하나 더 존재
 * 4 protected : 부모클래스에 대해서는 public 멤버처럼 취급되며, 외부에서는 private멤버 취급
 *  - protected 멤버에 접근할 수 있는 영역 : 이 멤버를 선언한 클래스의 멤버 / 
 *   이 멤버를 선언한 클래스가 속한 패키지의 멤버 / 이 멤버를 선언한 클래스를 상속받은
 *   자식 클래스의 멤버 => 같은 패키지에 속하는 클래스와 다른 패키지에 속하는 자식 클래스에서만
 *   접근 가능함
 * => 접근 범위 : pubic > protected > default > private
 */
package modi;
import modi.Sameclass;

public class modifier extends Sameclass { // child class
    private String var = "같은 클래스만 허용"; // private field
    private String getVar(){ // private method
        return this.var;
    }
    public String var2 = "누구든지 허용"; // pubic field
    public String getVar2(){ // public method
        return this.var2;
    }
    String var3 = "다른 패키지는 접근 불가"; // default field
    public static void main(String[] args) {
        // default
        Samepackage sp = new Samepackage(); // modtest.java's 
        System.out.println(sp.sameVar); // 같은 패키지는 허용

        // protected
        Sameclass sp2 = new Sameclass();
        System.out.println(sp2.sameVar2); // 다른 패키지에 속하는 자식 클래스까지 허용
    }
}
