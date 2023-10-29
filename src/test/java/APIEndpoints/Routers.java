package APIEndpoints;

public class Routers {
	
	//Swagger URL - https://petstore.swagger.io/
	
	//Create user (Post)  - https://petstore.swagger.io/v2/user
	//Get user (Get)  -https://petstore.swagger.io/v2/user
	//Update user (Put) - -https://petstore.swagger.io/v2/user{username} 
	//Delete user (Delete)  -https://petstore.swagger.io/v2/user{username} 

	public static String BaseURL = "https://petstore.swagger.io/v2"; 
	
	//User Module
	
	
	public static String Post_URL = BaseURL+"/user";
	public static String Get_URL = BaseURL+ "user{username}"; 
	public static String Put_URL = BaseURL+ "user{username}";
	public static String Delete_URL = BaseURL+ "user{username}";

	
	
}