public class condition {
    public static void main(String[] args) {
        char ch ='i';
        if(ch >= 'a' && ch <= 'z')
            System.out.println("해당 문자는 영문 소문자");
        else if (ch >= 'A' && ch <= 'Z')
            System.out.println("해당 문자는 영문 대문자");
        else
            System.out.println("해당 문자는 영문자가 아님");
        
        switch(ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("해당 문자는 소문자 모음입니다.");
                break;
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                System.out.println("해당 문자는 대문자 모음입니다.");
                break;
            default:
                System.out.println("해당 문자는 모음이 아닙니다.");
                break;
        }
    }
}
