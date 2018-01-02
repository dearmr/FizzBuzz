package com.alor.webservices.rest.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.ws.rs.QueryParam;

//Attempting to use chain of responsibility with ability to extend functionality if reqs change 
//The sole purpose of this project is to demonstrate use of Java 8 constructs
/**
 * 
 * @author me
 * GiveMeBuzz is a driver demo class for FizzBuzz functionality
 * Includes the main method and can be used as RESTful web service
 * Command line gets a single parameter which has to be a positive integer
 * As a web service, subject to configuration, the url should be like http://<host:port>/rest/givemebuzz?maxval=<value>
 *
 */
@Path("/givemebuzz")
public class GiveMeBuzz {

	private static int maxRange = 0;
	
	public static void main(String[] args) {
		
		try{
			validateInput(args[0]);
		} catch (NumberFormatException e){
			System.out.println("Wrong parameter " + args[0]);
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Missing parameter");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println(getMeFizzBuzz(maxRange).toString());
		System.out.println(categorizeFizzBuzz(maxRange).toString());
		
	}
	
	private static void validateInput (String inmaxval){
			Optional<String> inparam = Optional.ofNullable(inmaxval);
				
			if (!inparam.isPresent()){
				throw new IllegalArgumentException("val cannot be null!");
			}
		
			maxRange = Integer.parseInt(inparam.get());	
			if (maxRange <= 0){
			  throw new NumberFormatException();
			}
	}
	
	protected static MultivaluedMap<String, String> categorizeFizzBuzz(int highRange){
		
		MultivaluedMap<String, String> fizzBuzzMap = new MultivaluedHashMap<String, String>();
		IntStream.rangeClosed(1, highRange)
		           .forEach(i-> { String tmpFizzBuzz = FizzBuzz.Calculate(i);
		                          if(!(Integer.toString(i).equals(FizzBuzz.Calculate(i)))){
		        	                fizzBuzzMap.add(tmpFizzBuzz, Integer.toString(i));
		                          }
		           });
		
	    return fizzBuzzMap;
	
	}
	
	public static List<String> getMeFizzBuzz(int highRange){	
		
		return IntStream.rangeClosed(1, highRange)
				.mapToObj( i -> FizzBuzz.Calculate(i)).map(m -> m.toString())
		        .collect(Collectors.<String>toList());

	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(@QueryParam("maxval") int maxval) {
		validateInput(Integer.toString(maxval));
		return categorizeFizzBuzz(maxval).toString();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello(@QueryParam("maxval") int maxval) {
		validateInput(Integer.toString(maxval));
		return "<?xml version=\"1.0\"?>" + "<categorized> Hello World RESTful Jersey" + categorizeFizzBuzz(maxval).toString()
				+ "</categorized>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello(@QueryParam("maxval") int maxval) {
		validateInput(Integer.toString(maxval));
		return "<html> " + "<title>" + "Hello World RESTful Jersey"
				+ "</title>" + "<body><h1>" + categorizeFizzBuzz(maxval).toString()
				+ "</body></h1>" + "</html> ";
	}

}