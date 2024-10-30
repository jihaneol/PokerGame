package main.java.view;

import main.java.Message;
import main.java.util.Consol;

public class Inputview {

    public static String readNumber() {
        OutPutView.print(Message.PLAYER_NUMBER_INPUT_MESSAGE);
        return Consol.readLine();
    }

    public static String readNickname() {
        OutPutView.print(Message.PLAYER_NICKNAME_INPUT_MESSAGE);
        return Consol.readLine();
    }
}
