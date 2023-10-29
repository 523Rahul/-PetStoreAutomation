package APITest;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import APIEndpoints.UsersEndPoints;
import APIPaylaod.User;
import io.restassured.response.Response;

public class UserTests {

	Faker fakedata; 

	User UserPayload; 

	@BeforeTest 

	public void setupData()
	{
		fakedata =new Faker(); 

		UserPayload = new User(); 


		UserPayload.setId(fakedata.idNumber().hashCode());
		UserPayload.setUsername(fakedata.name().username());
		UserPayload.setFirstName(fakedata.name().firstName());
		UserPayload.setLastName(fakedata.name().lastName());
		UserPayload.setEmail(fakedata.internet().safeEmailAddress());
		UserPayload.setPasswod(fakedata.internet().password(5,10));	  
		UserPayload.setPhone(fakedata.phoneNumber().cellPhone());


	}
	@Test (priority=1)

	public void testPostUser()
	{
		Response  Res= 	UsersEndPoints.createUser(UserPayload);
		Res.then().log().all(); 

		Assert.assertEquals(Res.getStatusCode(), 200);

	}
	@Test (priority=2)

	public void testGetUserByname()
	{

		Response Res = UsersEndPoints.getUser(this.UserPayload.getUsername()); 

		Res.then().log().all();

	Assert.assertEquals(Res.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void updateUserByname()
	{
		//update data using payload
		
		UserPayload.setFirstName(fakedata.name().firstName());
		UserPayload.setLastName(fakedata.name().lastName());
		UserPayload.setEmail(fakedata.internet().safeEmailAddress());

		Response Res = UsersEndPoints.UpdateUser(this.UserPayload.getUsername(),UserPayload); 

		Res.then().log().all();
		Assert.assertEquals(Res.getStatusCode(), 200);
		
		
	}
	@Test(priority=4)
	public void testDeleteuserbyName()
	{
		Response Res=	UsersEndPoints.deleteUser(this.UserPayload.getUsername());
		
		Assert.assertEquals(Res.getStatusCode(), 200);
	}

}
