package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = sc.nextLine();

        Calculator cal = new Calculator();

        String[] inputSplit = new String[input.length()];

        if (input == null || input.trim().isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        if(cal.isCustom(input)){
            inputSplit = cal.splitCustom(input);
        } else{
            inputSplit = cal.splitCommon(input);
        }

        int[] numberSplit = cal.convertIntArray(inputSplit);
        System.out.println("결과 : " + cal.add(numberSplit));
    }

    public static class Calculator {
        // 커스텀인지 아닌지 구별
        public boolean isCustom(String input){
            return input.startsWith("//");
        }

        //기본 구분자 처리
        public String[] splitCommon(String input){
            String[] splitInput = input.split(",|:");

            return splitInput;
        }

        // 커스텀 구분자 처리
        public String[] splitCustom(String input){
            String[] parts = input.split("\\\\n", 2); // /n을 기준으로 2개로 나눔
            if(parts.length < 2){
                throw new IllegalArgumentException();
            }

            String delimiter = parts[0].substring(2); ;
            String[] splitInput = parts[1].split(delimiter); //1,2,3

            return splitInput;
        }

        //덧셈
        public int add(int[] numbers){
            int result = 0;
            for(int n : numbers){
                result += n;
            }

            return result;
        }

        // 잘못된 값 오류 처리 - 문자열을 추출하고 난 뒤 검사
        public int[] convertIntArray(String[] input){
            int[] numbers = new int[input.length];

            for(int i=0; i<input.length; i++){
                String value = input[i].trim();
                if (value.isEmpty()) { //빈 칸 0처리
                    numbers[i] = 0;
                    continue;
                }

                try{
                    int n = Integer.parseInt(input[i]);
                } catch(NumberFormatException e) {
                    throw new IllegalArgumentException();
                }

                int n = Integer.parseInt(input[i]);
                if(n <0){
                    throw new IllegalArgumentException();
                }

                numbers[i] = n;
            }
            return numbers;
        }

    }
}