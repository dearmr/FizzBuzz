package com.alor.webservices.rest.jersey;
/**
 * 
 * @author me
 * BuzzHandler is a handler class for resolution Buzz mapping for CoR
 *
 */
public class BuzzHandler extends Handler {
    @Override
	public String IsSatisfiedBy(int number)
    {
        if (number%BUZZ_CONST_INT == 0)
            return BUZZ_CONST_STR;
        return Next.IsSatisfiedBy(number);
    }

}
