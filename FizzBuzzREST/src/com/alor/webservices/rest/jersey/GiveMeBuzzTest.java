package com.alor.webservices.rest.jersey;

import org.junit.Assert;
import org.junit.Test;
import com.alor.webservices.rest.jersey.GiveMeBuzz;

/**
 * 
 * @author me
 * Room to add unit test scenarios
 *
 */
public class GiveMeBuzzTest {

    @Test
    public void testWithNumberIsDividableBy3() {
        Assert.assertEquals("Fizz", FizzBuzz.Calculate(3));

    }

    @Test
    public void testWithNumberIsDividableBy5() {
        Assert.assertEquals("Buzz",FizzBuzz.Calculate(5));
    }

    @Test
    public void testWithNumberIsDividableBy15() {
        Assert.assertEquals("FizzBuzz", FizzBuzz.Calculate(15));
        Assert.assertEquals("FizzBuzz", FizzBuzz.Calculate(45));
    }

    @Test
    public void testOtherNumbers() {
        Assert.assertEquals("1", FizzBuzz.Calculate(1));
        Assert.assertEquals("7", FizzBuzz.Calculate(7));
    }
}



