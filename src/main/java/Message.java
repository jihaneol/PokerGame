package main.java;

public enum Message {
    PLAYER_NUMBER_INPUT_MESSAGE("플레이어 숫자를 입력하세요. : "),
    PLAYER_NICKNAME_INPUT_MESSAGE("플레이어 닉네임을 설정해주세요: "),
    RE_INPUT_NICKNAME_MESSAGE("이미 닉네임이 있거나 형식이 틀렸습니다. 다시 입력하세요. \n"),
    EXEMPLE_NICKNAME_MESSAGE("EX) 1~20자 그리고 공백은 안됩니다.");

    private String message;

    Message(String s) {
        message = s;
    }

    public String getmessage() {
        return message;
    }
}
