package com.alor.webservices.rest.jersey;

/**
 * 
 * @author my
 * Aggregator class for CoR implementation
 *
 */


public class HandlerChain {
    
	private static Handler Head = register();
	
	public static Handler getHead(){
		return Head;
	}
	
	public static void setHead(Handler head){
		Head = head;
	}
	

	private static Handler register()
    {
        Handler head = new FizzBuzzHandler();
        head.RegisterNext(new BuzzHandler())
            .RegisterNext(new FizzHandler())
            .RegisterNext(new DefaultHandler());
        
        return head;
    }

    public static String Calculate(int number)
    {
        return Head.IsSatisfiedBy(number);
    }

}
