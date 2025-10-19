package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = sc.nextLine();

        Calculator cal = new Calculator();

        String[] inputSplit = new String[input.length()];

        if(cal.isCustom(input)){

        } else{

        }

    }

    public static class Calculator {
        // 커스텀인지 아닌지 구별
        public boolean isCustom(String input){
            if(input.startsWith("//")){
                return true;
            }
            return false;
        }

    }
}