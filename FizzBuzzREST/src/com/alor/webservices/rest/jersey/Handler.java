package com.alor.webservices.rest.jersey;
/**
 * 
 * @author me
 * Parent handler class for CoR implementation
 *
 */
public abstract class Handler {

	static final int FIZZ_CONST_INT = 3;
	static final int BUZZ_CONST_INT = 5;
	static final int FIZZ_BUZZ_CONST_INT = 15;
	
	static final String FIZZ_CONST_STR = "Fizz";
	static final String BUZZ_CONST_STR = "Buzz";
	static final String FIZZ_BUZZ_CONST_STR = "FizzBuzz";
	
	protected Handler Next;
	
	public Handler getNext(){
		return this.Next;
	}
	
	public void setNext(Handler next) {
		this.Next = next;
	}
	
	public Handler RegisterNext(Handler next)
    {
        Next = next;
        return Next;
    }

    public abstract String IsSatisfiedBy(int number);

}
