package Logic;

import org.junit.Test;

import static org.junit.Assert.*;

public class SherlockTest {

    @Test
    public void isValid_case_0() throws Exception {

        assertEquals("NO",Logic.Sherlock.isValid("aabbcd"));
    }


    @Test
    public void isValid_case_1() throws Exception {

        assertEquals("NO",Logic.Sherlock.isValid("aabbccddeefghi"));
    }

    @Test
    public void isValid_case_2() throws Exception {

        assertEquals("YES",Logic.Sherlock.isValid("abcdefghhgfedecba"));
    }
}