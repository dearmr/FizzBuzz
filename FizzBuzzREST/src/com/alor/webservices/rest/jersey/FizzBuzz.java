package com.alor.webservices.rest.jersey;

/**
 * 
 * @author me
 * Caller class to resolve FizzBuzz mapping using CoR pattern
 *
 */

public class FizzBuzz {
    public static String Calculate(int number)
    {
        return HandlerChain.Calculate(number);
    }

}
