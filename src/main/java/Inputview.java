package main.java;

public class Inputview {

    public static String readNumber() {
        System.out.print("플레이어 숫자를 입력하세요: ");
        return Consol.readLine();
    }

    public static String readNickname(Long id) {
        System.out.printf("플레이어%d 닉네임을 설정해주세요: ",id);
        return Consol.readLine();
    }
}
