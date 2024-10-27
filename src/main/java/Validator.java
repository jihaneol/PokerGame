package main.java;

public class Validator {

    public static boolean PlayerNumCheck(String num){
        if(!num.matches("^[0-9]*$")){
            System.out.println("형식이 잘못되었습니다.");
            System.out.println("ex) 2 , 3, 4");
            return true;
        }
        int i = Integer.parseInt(num);
        if(2>i || i>4){
            OutPutView.print("플레이어 수는 2~4명을 입력해야 합니다.");
            return true;
        }

        return false;
    }
    private static boolean nullCheck(String s){
        return s==null || s.isBlank();
    }
    private static boolean gapCheck(String s){
        return s.trim().length() !=s.length();
    }

    private static boolean nicknameLengthCheck(String nickname){
        return nickname.length()<1 || nickname.length()>20;
    }
    public static boolean PlayerNicknameCheck(String nickname) {

        if(nullCheck(nickname) || gapCheck(nickname)){
            System.out.println("공백은 안됩니다.");
            return false;
        }

        if(nicknameLengthCheck(nickname)){
            System.out.println("닉네임길이는 1이상 20이하만 가능합니다.");
            return false;
        }
        return true;
    }
}