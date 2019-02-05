package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void test() {
        assertEquals(1, 1);
        assertEquals(BibliotecaApp.validChoice(""), false);
        assertEquals(BibliotecaApp.validChoice("z"), false);
        assertEquals(BibliotecaApp.validChoice("-1"), false);
        assertEquals(BibliotecaApp.validChoice("0"), false);
        assertEquals(BibliotecaApp.validChoice("1"), true);
        assertEquals(BibliotecaApp.validChoice("3"), true);
        assertEquals(BibliotecaApp.validChoice("4"), true);
        assertEquals(BibliotecaApp.validChoice("5"), false);
    }
}
