package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req ; //use this instance in entire class due to static
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));

		req = new RequestSpecBuilder().setBaseUri(getglobal("baseurl"))
				.addQueryParam("key", "qaclick123").
				addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();


		return req;

	
		}
		
		else {
		return req;
		}
	}
	public  static String getglobal(String key) throws IOException
	{
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Ashwini\\eclipse-workspace\\APIAutomation\\src\\test\\java\\resources\\Global.properties");
	
	prop.load(fis);
	return prop.getProperty(key);
	
	}
	
	
	public String jsonpath(Response rp,String key) {
		String responseString = rp.asString();
		 JsonPath js=new JsonPath(responseString);
		
		return js.get(key).toString();
			
	}
}
