public class loop {
    public static void main(String[] args) {
        int i=0, j=1;
        while(i<5){
            System.out.println("while문 "+(i+1)+"번째");
            i++;
        }
        System.out.println("현재 변수 i는 "+i);

        do {
            System.out.println("while문 "+j+"번째");
            j++;
        } while(j<1);
        System.out.println("현재 변수 j는 "+j);

        for(i=0;i<5;i++){
            System.out.println("while문 "+(i+1)+"번째");
        }
        System.out.println("현재 변수 i는 "+i);

        for(int z=1; z<=10;z++){
            if(z%5==0||z%7==0){
                System.out.println(z);
            }else{
                continue;
            }
        } // 5 7 10

        int num=1, sum=0;
        while(true){ // 무한 루프
            sum += num;
            if(num==10){
                break;
            }
            num++;
        }
        System.out.println(sum); // 55

        /*
         * - 일반적인 break문은 단 하나의 반복문만 빠져나감
         * - 가장 바깥쪽 반복문이나 빠져나가고 싶은 특정 반복문에 이름을 설정한 후,
         *  break 키워드 다음에 해당 이름을 명시
         * - 단, 이때 이름(label)은 가리키고자 하는 반복문의 키워드 바로 앞에 위치
         */
        allLoop:
        for(int n=2; n<10; n++){
            for(int m=2;m<10;m++){
                if(n==3){
                    break allLoop;
                }
                System.out.println(n + " * " + m + " = " + (n * m));
            }
        } // 변수 n의 값이 3이 되는 순간, 프로그램 종료(구구단 2단만 출력됨)
    }
}
