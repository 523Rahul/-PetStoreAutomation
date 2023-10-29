package APIEndpoints;

import static io.restassured.RestAssured.given;

import APIPaylaod.User;
import  io.restassured.http.ContentType; 
import  io.restassured.response.Response;

public class UsersEndPoints {
	
	//User Endpoint .java file and created for CURD Operation 
	
	public static Response createUser(User Paylaod)
	{
	Response Respo=	given().contentType(ContentType.JSON).accept(ContentType.JSON).body(Paylaod).
		
		when().post(Routers.Put_URL); 
		
	
		return Respo; 
	}
	
	public static Response getUser(String userName)
	{
	Response Respo=	given().pathParam("userName", userName).
		
		when().get(Routers.Get_URL); 
		
	
		return Respo; 
	}
	
	public static Response UpdateUser(String userName , User Paylaod)
	{
	Response Respo=	given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("userName", userName).
			body(Paylaod).
		
		when().put(Routers.Put_URL); 
		
	
		return Respo; 


}
	public static Response deleteUser(String userName)
	{
	Response Respo=	given().pathParam("userName", userName).
			
		
		when().delete(Routers.Delete_URL); 
		
	
		return Respo; 
	
}
}