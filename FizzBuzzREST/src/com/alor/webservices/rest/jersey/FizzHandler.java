package com.alor.webservices.rest.jersey;

/**
 * 
 * @author me
 * FizzHandler is resolving Fizz mapping in CoR
 *
 */

public class FizzHandler extends Handler {
    @Override
	public String IsSatisfiedBy(int number)
    {
        if (number%FIZZ_CONST_INT == 0)
            return FIZZ_CONST_STR;
        return Next.IsSatisfiedBy(number);
    }

}
