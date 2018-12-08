package Logic;

import org.junit.Test;

import static org.junit.Assert.*;

public class NonDivisibleTest {

    @Test
    public void nonDivisibleSubset_Case_0() {
        assertEquals(3,Logic.NonDivisible.nonDivisibleSubset(3,new int[]{1,7,2,4}));
    }



    @Test
    public void nonDivisibleSubset_Case_1() {
        assertEquals(11,Logic.NonDivisible.nonDivisibleSubset(7,new int[]{278,576,496,727,410,124,338,149,209,702,282,718,771,575,436}));
    }

    @Test
    public void nonDivisibleSubset_Case_2() {
        assertEquals(3,Logic.NonDivisible.nonDivisibleSubset(4,new int[]{1,3,4,4}));
    }


    @Test
    public void nonDivisibleSubset_Case_3() {
        assertEquals(3,Logic.NonDivisible.nonDivisibleSubset(6,new int[]{1,5,6,6}));
    }

}