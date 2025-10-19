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
            inputSplit = cal.splitCustom(input);
        } else{
            inputSplit = cal.splitCommon(input);
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

        //기본 구분자 처리
        public String[] splitCommon(String input){
            String[] splitInput = input.split(",|:");

            return splitInput;
        }

        // 커스텀 구분자 처리
        public String[] splitCustom(String input){
            String[] parts = input.split("\\\\n"); // //; , 1;2;3
            String delimiter = parts[0].substring(2); ;

            String[] splitInput = parts[1].split(delimiter); //1,2,3

            return splitInput;
        }


    }
}