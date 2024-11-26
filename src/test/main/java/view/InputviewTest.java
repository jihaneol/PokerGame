package main.java.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputviewTest {

    @Test
    void readNumber() {
        InputStream inputStream = setReadLine("1");
        System.setIn(inputStream);
        String s = Inputview.readNumber();
        assertEquals(s, "1");
    }

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

}