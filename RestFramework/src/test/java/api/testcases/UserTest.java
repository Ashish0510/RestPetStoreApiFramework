package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userendpoints;
import api.payload.user;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	user payload;
	
	@BeforeClass
	
	public void generatetestdata() {
		faker=new Faker();
		payload=new user();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setUsername(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().safeEmailAddress());
		payload.setPassword(faker.internet().password());
		payload.setPhone(faker.phoneNumber().cellPhone());
		
		System.out.println("payload has been set by the java faker");
		
	}
	
	
	@Test(priority=1)
	public void testcreateuser() {
		Response response=userendpoints.createuser(payload);
		
		System.out.println("createuser has been from test method");
		
		
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		System.out.print("user has been created successfully");
	}
	
	@Test(priority=2)
	public void testgetuser() {
		Response response=userendpoints.getuser(this.payload.getUsername());
		System.out.println("Created user **************************** created user");
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		
		
	}
	
	@Test(priority=3)
	public void testupdateuser() {
		payload.setFirstName(faker.name().firstName());
		
		Response response=userendpoints.updateuser(this.payload.getUsername(), payload);
		System.out.println("updated firstname user **************************** updated firstname user");
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		Response response1=userendpoints.getuser(this.payload.getUsername());
		System.out.println(" After updated firstname user **************************** After updated firstname user");
		
		response1.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		
	}
	public void TestChange() {
		System.out.println("changes*****");
	}
	
	public void gitTestChange() {
		System.out.println("changes*****");
	}

}
