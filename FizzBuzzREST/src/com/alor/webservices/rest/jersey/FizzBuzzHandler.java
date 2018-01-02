package com.alor.webservices.rest.jersey;

/**
 * 
 * @author me
 * FizzBuzzHandler is resolving FizzBuzz mapping in CoR
 *
 */
public class FizzBuzzHandler extends Handler {

    @Override
	public String IsSatisfiedBy(int number)
    {
        if (number%FIZZ_BUZZ_CONST_INT == 0)
            return FIZZ_BUZZ_CONST_STR;
        return Next.IsSatisfiedBy(number);
    }

}
