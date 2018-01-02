package com.alor.webservices.rest.jersey;

/**
 * 
 * @author me
 * DefaultHandler is a class to resolve the last resort situation for CoR
 *
 */
public class DefaultHandler extends Handler {

	@Override
	public String IsSatisfiedBy(int number) {

		return Integer.toString(number);
	}

}
